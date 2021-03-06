﻿// SPDX-License-Identifier: MIT
// The content of this file has been developed in the context of the MOSIM research project.
// Original author(s): Felix Gaisbauer, Adam Klodowski, Janis Sprenger


using MMIStandard;
using System.Collections.Generic;
using System.Linq;
using UnityEngine;


namespace MMIUnity.TargetEngine.Scene
{
    /// <summary>
    /// Basic script for scene objects which should be synchronized with the MMI framework.
    /// This practically means, that each object which should be synchronized with the framework must have the script attached.
    /// </summary>
    public class MMISceneObject : MonoBehaviour
    {
        #region public variables

        /// <summary>
        /// The scene object in the serializable format of the MMI framework
        /// </summary>
        /// 

        [HideInInspector]
        public MSceneObject MSceneObject;
        //task editor dependencies
        [HideInInspector]
        public ulong TaskEditorLocalID = 0;
        [HideInInspector]
        public ulong TaskEditorID = 0;
        //end of task editor dependencies
        /// <summary>
        /// Specifies whether the arrow pointing into the direction vector is displayed
        /// </summary>
        [Header("Specifies whether the arrow pointing into the direction vector is displayed")]
        public bool ShowCoordinateSystem = false;

        /// <summary>
        /// Allows the specification of a fixed velocity of the object (only works if rigid body is assigned)
        /// </summary>
        [Header("Allows the specification of a fixed velocity of the object (only works if rigid body is assigned)")]
        public Vector3 Velocity = Vector3.zero;

        /// <summary>
        /// Specifies whether the physics should be updated for the current frame
        /// </summary>
        [HideInInspector]
        public bool UpdatePhysicsCurrentFrame = true;

        /// <summary>
        /// Specifies whether the color of the object should be overwritten
        /// </summary>
        public bool OverrideColor = false;

        /// <summary>
        /// The desired color
        /// </summary>
        public Color Color;

        /// <summary>
        /// Specifies whether physics is enabled (overall)
        /// </summary>
        public bool PhysicsEnabled
        {
            get
            {
                return this.physicsEnabled;
            }

            set
            {
                this.physicsEnabled = value;

                if (this.rigidBody != null)
                {
                    this.rigidBody.detectCollisions = value;
                    this.rigidBody.isKinematic = !value;
                }
            }
        }


        /// <summary>
        /// Flag indicates whether the meshes should be transferred
        /// </summary>
        [Header("Flag indicates whether the colliders are ignored.")]
        public bool IgnoreCollision = false;


        /// <summary>
        /// Flag indicates whether the meshes should be transferred
        /// </summary>
        [Header("Flag indicates whether the meshes should be transferred")]
        public bool TransferMesh = false;

        /// Following public fields are used to specify the MMISceneObject depending on the selected type
        public enum Types
        {
            MSceneObject,
            InitialLocation,
            FinalLocation,
            WalkTarget,
            Area,
            Part,
            Tool
        }

        public Types Type;
        public string Tool;
        public MMISceneObject InitialLocation;
        public MMISceneObject FinalLocation;
        public MMISceneObject IsLocatedAt;


        /// <summary>
        /// The constraint that are manually assigned to the scene object
        /// </summary>
        [Header("Constraints that are assigned to the scene object. The constraints will be synchronized (once) in the awake routine.")]
        public List<MConstraint> Constraints = new List<MConstraint>();


#endregion

#region private variables

        /// <summary>
        /// A tracker which monitors potential changes related to physics
        /// </summary>
        private PhysicsTracker physicsTracker;

        /// <summary>
        /// A tracker which monitos potential changes related to the transform
        /// </summary>
        private TransformTracker transformTracker;

        /// <summary>
        /// Flag indicates whetehr physics is enabled for the object (e.g. react on physical forces)
        /// </summary>
        private bool physicsEnabled = true;

        /// <summary>
        /// The optionally assigned rigidBody
        /// </summary>
        private Rigidbody rigidBody;

        /// <summary>
        /// Threshold for recognizing changes (e.g. translation changes or physics changes)
        /// </summary>
        private static readonly float threshold = 1e-6f;

#endregion



        /// <summary>
        /// Basic awake routine
        /// </summary>
        protected virtual void Awake()
        {
            //Create a unique id for the scene object (only valid in the current session -> otherwise UUID required)
            string id = UnitySceneAccess.CreateSceneObjectID();


            //To check -> Is this informaton be required for every use case? Or should be remove it from here.
            Dictionary<string, string> _dict = new Dictionary<string, string>();
            if (Type == Types.Part)
            {
                _dict.Add("type", Type.ToString());
                if (InitialLocation != null)
                    _dict.Add("initialLocation", InitialLocation.MSceneObject.ID);
                if (FinalLocation != null)
                    _dict.Add("finalLocation", FinalLocation.MSceneObject.ID);
                if (IsLocatedAt != null)
                    _dict.Add("isLocatedAt", InitialLocation.MSceneObject.ID);
            } 
            else if (Type == Types.Tool)
            {
                _dict.Add("type", Tool);
                if (InitialLocation != null)
                    _dict.Add("initialLocation", InitialLocation.MSceneObject.ID);
                if (FinalLocation != null)
                    _dict.Add("finalLocation", FinalLocation.MSceneObject.ID);
                if (IsLocatedAt != null)
                    _dict.Add("isLocatedAt", InitialLocation.MSceneObject.ID);
            }
            else
            {
                _dict.Add("type", Type.ToString());
            }

            //Create a new instance
            this.MSceneObject = new MSceneObject()
            {
                Name = this.name,
                ID = id,
                Properties = _dict,
                Transform = new MTransform(id, new MVector3(0, 0, 0), new MQuaternion(0, 0, 0, 1)),
                Constraints = this.Constraints
            };

            //Create a new transform tracker
            this.transformTracker = new TransformTracker(this.MSceneObject);
        }


        // Use this for initialization
        protected virtual void Start()
        {
            //Setup the transforms of the MSceneObject
            this.SetupTransform();

            //Try to get the rigid body (if available)
            this.rigidBody = this.GetComponent<Rigidbody>();

            //Add the physics properties if rigid body is available
            if (this.rigidBody != null)
            {
                this.MSceneObject.PhysicsProperties = new MPhysicsProperties()
                {
                    Mass = this.rigidBody.mass,
                    Inertia = this.rigidBody.inertiaTensor.ToList(),
                    CenterOfMass = this.rigidBody.centerOfMass.ToList()
                };

                //Create a new physics tracker to monitor potential changes with regard to physics
                this.physicsTracker = new PhysicsTracker(this.MSceneObject);
            }

            //Setup the collider and write the result to MSceneObject
            if(!this.IgnoreCollision)
                this.SetupCollider();

            //Setup the mesh and write the result to MSceneObject
            if(this.TransferMesh)
                this.SetupMesh();

            //Add the scene object to the scene access
            UnitySceneAccess.AddSceneObject(this.MSceneObject);
        }


        // Update is called once per frame
        protected virtual void Update()
        {
            //Handle physics
            if (this.rigidBody != null && physicsEnabled)
            {
                this.rigidBody.detectCollisions = this.UpdatePhysicsCurrentFrame;
                this.rigidBody.isKinematic = !this.UpdatePhysicsCurrentFrame;

                //Reset the value
                this.UpdatePhysicsCurrentFrame = true;
            }

            //Handle fixed velocity
            if (this.Velocity.magnitude > 0 && this.rigidBody != null)
            {
                if (this.rigidBody != null)
                {
                    this.rigidBody.velocity = this.Velocity;
                }
            }


            //Check the transformation changes
            if (this.transform.hasChanged && this.transformTracker.HasChanged(this.transform))
            {
                //Write the transform of the mscene object
                this.transformTracker.Update(transform);

                //Signalize transformation change
                UnitySceneAccess.TransformationChanged(this.MSceneObject, this.MSceneObject.Transform.Position, this.MSceneObject.Transform.Rotation, this.MSceneObject.Transform.Parent);
            }

            //Also track the changes in terms of physics
            if (this.rigidBody != null)
            {
                List<MPhysicsInteraction> physicsChanges = this.physicsTracker.GetChanges(this.rigidBody);

                //If some changes occur -> Update the phsysics properties and inform the UnitySceneAccess
                if (physicsChanges.Count > 0)
                {
                    this.physicsTracker.Update(this.rigidBody);
                    UnitySceneAccess.PhysicsPropertiesChanged(this.MSceneObject, this.MSceneObject.PhysicsProperties);
                }
            }

        }


        /// <summary>
        /// Updates the transform of the corresponding MSceneObject
        /// </summary>
        public virtual void UpdateTransform(bool raiseEvent = true)
        {
            string parent = this.MSceneObject.Transform.Parent;

            //Set the transform to the current values
            this.MSceneObject.Transform.Position = this.transform.position.ToMVector3();
            this.MSceneObject.Transform.Rotation = this.transform.rotation.ToMQuaternion();
            this.MSceneObject.Transform.Parent = parent;

            if (raiseEvent)
            {
                //only transmit the changed data
                UnitySceneAccess.TransformationChanged(this.MSceneObject, this.MSceneObject.Transform.Position, this.MSceneObject.Transform.Rotation, this.MSceneObject.Transform.Parent);
                this.transform.hasChanged = false;
            }
        }


        /// <summary>
        /// Synchronizes the (internal) MSceneObject with the present data
        /// </summary>
        public virtual void Synchronize()
        {
            this.UpdateTransform(false);
            this.MSceneObject.Constraints = Constraints;

            //To do -> further actions in here
            UnitySceneAccess.SceneObjectChanged(this.MSceneObject);
        }


        /// <summary>
        /// Debug print
        /// </summary>
        protected virtual void OnDrawGizmos()
        {
            //Visualize the coordiante system if desired
            if (this.ShowCoordinateSystem)
            {
                Gizmos.color = Color.blue;
                Gizmos.DrawLine(this.transform.position, this.transform.position + this.transform.forward * 0.1f);
                Gizmos.color = Color.green;
                Gizmos.DrawLine(this.transform.position, this.transform.position + this.transform.up * 0.05f);
                Gizmos.color = Color.red;
                Gizmos.DrawLine(this.transform.position, this.transform.position + this.transform.right * 0.05f);
            }

            //Visualize the velocity if defined
            if (this.Velocity.magnitude > 0)
            {
                Gizmos.color = Color.green;
                Gizmos.DrawLine(this.transform.position, this.transform.position + this.Velocity.normalized * 0.5f);
            }

            //Optionally override the color
            if (this.OverrideColor)
            {
                if (this.GetComponent<Renderer>() != null)
                {
                    if(this.GetComponent<Renderer>().sharedMaterial.color != this.Color)                
                        this.GetComponent<Renderer>().sharedMaterial = new Material(Shader.Find("Standard"));

                    //Assign the color
                    this.GetComponent<Renderer>().sharedMaterial.color = this.Color;
                }
            }
        }



#region private methods

        /// <summary>
        /// Sets up the transform of the MSceneObject
        /// </summary>
        private void SetupTransform()
        {
            //Create the transform
            this.MSceneObject.Transform = new MTransform()
            {
                ID = this.MSceneObject.ID,
                Position = this.transform.position.ToMVector3(),
                Rotation = this.transform.rotation.ToMQuaternion()
            };

            //Set the parent if available
            if (this.transform.parent != null && this.transform.GetComponentsInParent<MMISceneObject>().Length > 1)
            {
                MMISceneObject parent = this.transform.GetComponentsInParent<MMISceneObject>()[1];

                this.MSceneObject.Transform.Parent = parent.name;
            }

            else
            {
                this.MSceneObject.Transform.Parent = null;
            }
        }


        /// <summary>
        /// Sets up the mesh of the MSceneObject
        /// </summary>
        private void SetupMesh()
        {
            try
            {
                //Set the mesh if available
                if (this.GetComponent<MeshFilter>() != null)
                {
                    //Get the unity mesh
                    Mesh mesh = this.GetComponent<MeshFilter>().mesh;

                    //Create a new mesh representation of the MMI framework
                    MMesh sMesh = new MMesh()
                    {
                        Vertices = mesh.vertices.Select(s => s.ToMVector3()).ToList(),
                        Triangles = mesh.triangles.ToList(),
                        ID = this.MSceneObject.ID
                    };

                    //Assign the mesh
                    this.MSceneObject.Mesh = sMesh;
                }
            }
            catch (System.Exception e)
            {
                Debug.LogError("Problem setting up the mesh: " + e.Message + " " + e.StackTrace);
            }
        }


        /// <summary>
        /// Sets up the collider of the MSceneObject
        /// </summary>
        private void SetupCollider()
        {
            try
            {
                //Set the collider (if defined)
                if (this.GetComponent<Collider>() != null)
                {
                    //Create a new MCollider instance
                    MCollider mCollider = new MCollider()
                    {
                        ID = this.MSceneObject.ID
                    };

                    //Get the collider instance
                    Collider collider = this.GetComponent<Collider>();


                    //Check if collider is a box collider and create corresponding representation in MMI framework
                    if (collider is BoxCollider)
                    {
                        mCollider.Type = MColliderType.Box;
                        BoxCollider boxCollider = collider as BoxCollider;

                        //Set the specific box collider properties
                        mCollider.BoxColliderProperties = new MBoxColliderProperties
                        {
                            //Calculate the size by consdering the scaling
                            Size = new MVector3(boxCollider.size.x * this.transform.localScale.x, boxCollider.size.y * this.transform.localScale.y, boxCollider.size.z * this.transform.localScale.z)
                        };
                        mCollider.PositionOffset = new MVector3(boxCollider.center.x * this.transform.localScale.x, boxCollider.center.y * this.transform.localScale.y, boxCollider.center.z * this.transform.localScale.z);
                    }

                    //Check if collider is a sphere collider and create corresponding representation in MMI framework
                    if (collider is SphereCollider)
                    {
                        mCollider.Type = MColliderType.Sphere;
                        SphereCollider sphereCollider = collider as SphereCollider;

                        //Set the specific sphere collider properties
                        mCollider.SphereColliderProperties = new MSphereColliderProperties
                        {
                            Radius = sphereCollider.radius * Mathf.Max(this.transform.localScale.x, this.transform.localScale.y, this.transform.localScale.z)
                        };
                        mCollider.PositionOffset = new MVector3(sphereCollider.center.x * this.transform.localScale.x, sphereCollider.center.y * this.transform.localScale.y, sphereCollider.center.z * this.transform.localScale.z);

                    }

                    //Check if collider is a capsule collider and create corresponding representation in MMI framework
                    if (collider is CapsuleCollider)
                    {
                        mCollider.Type = MColliderType.Capsule;
                        CapsuleCollider capsuleCollider = collider as CapsuleCollider;


                        //Set the specific capsule collider properties
                        mCollider.CapsuleColliderProperties = new MCapsuleColliderProperties
                        {
                            Radius = capsuleCollider.radius * Mathf.Max(this.transform.localScale.x, this.transform.localScale.z),
                            Height = capsuleCollider.height * this.transform.localScale.y,
                        };

                        //Set the position offset
                        mCollider.PositionOffset = new MVector3(capsuleCollider.center.x * this.transform.localScale.x, capsuleCollider.center.y * this.transform.localScale.y, capsuleCollider.center.z * this.transform.localScale.z);
                    }

                    //Check if collider is a mesh collider and create corresponding representation in MMI framework
                    if (collider is MeshCollider)
                    {
                        mCollider.Type = MColliderType.Mesh;
                        MeshCollider meshCollider = collider as MeshCollider;
                        mCollider.MeshColliderProperties = new MMeshColliderProperties();
                        mCollider.MeshColliderProperties.Vertices = meshCollider.sharedMesh.vertices.Select(s => s.ToMVector3()).ToList();
                        mCollider.MeshColliderProperties.Triangles = meshCollider.sharedMesh.triangles.ToList();

                        //To do provide further option to just consider the bounds as approximation of the mesh collider
                    }

                    //Assign the collider
                    this.MSceneObject.Collider = mCollider;
                }
            }
            catch (System.Exception e)
            {
                Debug.LogError("Problem setting up the collider: " + e.Message + " " + e.StackTrace);
            }

        }

#endregion


#region helper classes 

        /// <summary>
        /// Class which monitors phsyical changes of the scene object
        /// </summary>
        private class PhysicsTracker
        {
#region public variables

            public Vector3 LastAngularVelocity;
            public Vector3 LastVelocity;
            public Vector3 LastCenterOfMass;
            public Vector3 LastInertia;

            public float LastMass;
            public float Threshold = 1e-5f;
            public MSceneObject sceneObject;

#endregion


            /// <summary>
            /// Basic constructor which takes the MSceneObject as input
            /// </summary>
            /// <param name="msceneObject"></param>
            public PhysicsTracker(MSceneObject msceneObject)
            {
                this.sceneObject = msceneObject;
            }

            /// <summary>
            /// Returns the changes occured since the last update
            /// </summary>
            /// <param name="rigidBody"></param>
            /// <returns></returns>
            public List<MPhysicsInteraction> GetChanges(Rigidbody rigidBody)
            {
                List<MPhysicsInteraction> list = new List<MPhysicsInteraction>();

                //Check if velocity has been changed
                if (Vector3.Magnitude(rigidBody.velocity - this.LastVelocity) > Threshold)
                {
                    list.Add(new MPhysicsInteraction(sceneObject.ID, MPhysicsInteractionType.ChangeVelocity, rigidBody.velocity.ToList()));
                }

                //Check if angular velocity has been changed
                if (Vector3.Magnitude(rigidBody.angularVelocity - this.LastAngularVelocity) > Threshold)
                {
                    list.Add(new MPhysicsInteraction(sceneObject.ID, MPhysicsInteractionType.ChangeAngularVelocity, rigidBody.velocity.ToList()));
                }

                //Check if mass has been changed
                if (Mathf.Abs(this.LastMass - rigidBody.mass) > Threshold)
                {
                    list.Add(new MPhysicsInteraction(sceneObject.ID, MPhysicsInteractionType.ChangeMass, new List<double>() { rigidBody.mass }));
                }


                //Check if center of mass has been changed
                if (Vector3.Magnitude(rigidBody.centerOfMass - this.LastCenterOfMass) > Threshold)
                {
                    list.Add(new MPhysicsInteraction(sceneObject.ID, MPhysicsInteractionType.ChangeCenterOfMass, rigidBody.centerOfMass.ToList()));
                }


                //Check if inertia has been changed
                if (Vector3.Magnitude(rigidBody.inertiaTensor - this.LastInertia) > Threshold)
                {
                    list.Add(new MPhysicsInteraction(sceneObject.ID, MPhysicsInteractionType.ChangeInertia, rigidBody.inertiaTensor.ToList()));
                }

                return list;
            }


            /// <summary>
            /// Updates the internal state as well as the phsysics properties of the scene object
            /// </summary>
            /// <param name="rigidBody"></param>
            public void Update(Rigidbody rigidBody)
            {
                this.LastVelocity = rigidBody.velocity;
                this.LastAngularVelocity = rigidBody.angularVelocity;
                this.LastMass = rigidBody.mass;
                this.LastCenterOfMass = rigidBody.centerOfMass;
                this.LastInertia = rigidBody.inertiaTensor;


                this.sceneObject.PhysicsProperties.AngularVelocity = rigidBody.angularVelocity.ToList();
                this.sceneObject.PhysicsProperties.CenterOfMass = rigidBody.centerOfMass.ToList();
                this.sceneObject.PhysicsProperties.Inertia = rigidBody.inertiaTensor.ToList();
                this.sceneObject.PhysicsProperties.Mass = rigidBody.mass;
                this.sceneObject.PhysicsProperties.Velocity = rigidBody.velocity.ToList(); ;
            }
        }

        /// <summary>
        ///  Class which monitors transformation changes of the scene object
        /// </summary>
        private class TransformTracker
        {
            /// <summary>
            /// The specified threshold above which changes are recognized
            /// </summary>
            public float Threshold = 1e-5f;

#region private variables

            private Vector3 lastLocalPosition;
            private Quaternion lastLocalRotation;

            private Vector3 lastGlobalPosition;
            private Quaternion lastGlobalRotation;

            private Transform lastParent;

            private MSceneObject sceneObject;

#endregion

            /// <summary>
            /// Basic constructor which takes the MSceneObject as input
            /// </summary>
            /// <param name="msceneObject"></param>
            public TransformTracker(MSceneObject msceneObject)
            {
                this.sceneObject = msceneObject;
            }

            /// <summary>
            /// Indicates whether changes occured since the last frame
            /// </summary>
            /// <param name="transform"></param>
            /// <returns></returns>
            public bool HasChanged(Transform transform)
            {
                bool hasChanged = false;

                //Check if the position has changed
                if ((lastLocalPosition - transform.localPosition).magnitude > Threshold || (lastGlobalPosition - transform.position).magnitude > Threshold)
                    hasChanged = true;


                //Check if the rotation has changed
                if (Mathf.Abs(Quaternion.Angle(this.lastLocalRotation, transform.localRotation)) > threshold || Mathf.Abs(Quaternion.Angle(this.lastGlobalRotation, transform.rotation)) > Threshold)
                    hasChanged = true;

                //Check if parent has changed
                if (lastParent != transform.parent)
                    hasChanged = true;

                return hasChanged;
            }


            /// <summary>
            /// Updates the internal state according to the specified transform
            /// </summary>
            /// <param name="transform"></param>
            public void Update(Transform transform)
            {
                //Update the transform in each frame
                this.sceneObject.Transform.Position = transform.position.ToMVector3();
                this.sceneObject.Transform.Rotation = transform.rotation.ToMQuaternion();

                this.lastLocalPosition = transform.localPosition;
                this.lastLocalRotation = transform.localRotation;
                this.lastGlobalPosition = transform.position;
                this.lastGlobalRotation = transform.rotation;
                this.lastParent = transform.parent;
            }
        }

#endregion
    }
}
