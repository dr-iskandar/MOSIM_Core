/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package de.mosim.mmi.mmu;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-12-08")
public class MDependency implements org.apache.thrift.TBase<MDependency, MDependency._Fields>, java.io.Serializable, Cloneable, Comparable<MDependency> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("MDependency");

  private static final org.apache.thrift.protocol.TField ID_FIELD_DESC = new org.apache.thrift.protocol.TField("ID", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField TYPE_FIELD_DESC = new org.apache.thrift.protocol.TField("Type", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField MIN_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("MinVersion", org.apache.thrift.protocol.TType.STRUCT, (short)3);
  private static final org.apache.thrift.protocol.TField MAX_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("MaxVersion", org.apache.thrift.protocol.TType.STRUCT, (short)4);
  private static final org.apache.thrift.protocol.TField EXCLUDED_VERSIONS_FIELD_DESC = new org.apache.thrift.protocol.TField("ExcludedVersions", org.apache.thrift.protocol.TType.LIST, (short)5);
  private static final org.apache.thrift.protocol.TField NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("Name", org.apache.thrift.protocol.TType.STRING, (short)6);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new MDependencyStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new MDependencyTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String ID; // required
  /**
   * 
   * @see MDependencyType
   */
  public @org.apache.thrift.annotation.Nullable MDependencyType Type; // required
  public @org.apache.thrift.annotation.Nullable MVersion MinVersion; // required
  public @org.apache.thrift.annotation.Nullable MVersion MaxVersion; // required
  public @org.apache.thrift.annotation.Nullable java.util.List<MVersion> ExcludedVersions; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String Name; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ID((short)1, "ID"),
    /**
     * 
     * @see MDependencyType
     */
    TYPE((short)2, "Type"),
    MIN_VERSION((short)3, "MinVersion"),
    MAX_VERSION((short)4, "MaxVersion"),
    EXCLUDED_VERSIONS((short)5, "ExcludedVersions"),
    NAME((short)6, "Name");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // ID
          return ID;
        case 2: // TYPE
          return TYPE;
        case 3: // MIN_VERSION
          return MIN_VERSION;
        case 4: // MAX_VERSION
          return MAX_VERSION;
        case 5: // EXCLUDED_VERSIONS
          return EXCLUDED_VERSIONS;
        case 6: // NAME
          return NAME;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.EXCLUDED_VERSIONS,_Fields.NAME};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ID, new org.apache.thrift.meta_data.FieldMetaData("ID", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.TYPE, new org.apache.thrift.meta_data.FieldMetaData("Type", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.EnumMetaData(org.apache.thrift.protocol.TType.ENUM, MDependencyType.class)));
    tmpMap.put(_Fields.MIN_VERSION, new org.apache.thrift.meta_data.FieldMetaData("MinVersion", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MVersion.class)));
    tmpMap.put(_Fields.MAX_VERSION, new org.apache.thrift.meta_data.FieldMetaData("MaxVersion", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MVersion.class)));
    tmpMap.put(_Fields.EXCLUDED_VERSIONS, new org.apache.thrift.meta_data.FieldMetaData("ExcludedVersions", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, MVersion.class))));
    tmpMap.put(_Fields.NAME, new org.apache.thrift.meta_data.FieldMetaData("Name", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(MDependency.class, metaDataMap);
  }

  public MDependency() {
  }

  public MDependency(
    java.lang.String ID,
    MDependencyType Type,
    MVersion MinVersion,
    MVersion MaxVersion)
  {
    this();
    this.ID = ID;
    this.Type = Type;
    this.MinVersion = MinVersion;
    this.MaxVersion = MaxVersion;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public MDependency(MDependency other) {
    if (other.isSetID()) {
      this.ID = other.ID;
    }
    if (other.isSetType()) {
      this.Type = other.Type;
    }
    if (other.isSetMinVersion()) {
      this.MinVersion = new MVersion(other.MinVersion);
    }
    if (other.isSetMaxVersion()) {
      this.MaxVersion = new MVersion(other.MaxVersion);
    }
    if (other.isSetExcludedVersions()) {
      java.util.List<MVersion> __this__ExcludedVersions = new java.util.ArrayList<MVersion>(other.ExcludedVersions.size());
      for (MVersion other_element : other.ExcludedVersions) {
        __this__ExcludedVersions.add(new MVersion(other_element));
      }
      this.ExcludedVersions = __this__ExcludedVersions;
    }
    if (other.isSetName()) {
      this.Name = other.Name;
    }
  }

  public MDependency deepCopy() {
    return new MDependency(this);
  }

  @Override
  public void clear() {
    this.ID = null;
    this.Type = null;
    this.MinVersion = null;
    this.MaxVersion = null;
    this.ExcludedVersions = null;
    this.Name = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getID() {
    return this.ID;
  }

  public MDependency setID(@org.apache.thrift.annotation.Nullable java.lang.String ID) {
    this.ID = ID;
    return this;
  }

  public void unsetID() {
    this.ID = null;
  }

  /** Returns true if field ID is set (has been assigned a value) and false otherwise */
  public boolean isSetID() {
    return this.ID != null;
  }

  public void setIDIsSet(boolean value) {
    if (!value) {
      this.ID = null;
    }
  }

  /**
   * 
   * @see MDependencyType
   */
  @org.apache.thrift.annotation.Nullable
  public MDependencyType getType() {
    return this.Type;
  }

  /**
   * 
   * @see MDependencyType
   */
  public MDependency setType(@org.apache.thrift.annotation.Nullable MDependencyType Type) {
    this.Type = Type;
    return this;
  }

  public void unsetType() {
    this.Type = null;
  }

  /** Returns true if field Type is set (has been assigned a value) and false otherwise */
  public boolean isSetType() {
    return this.Type != null;
  }

  public void setTypeIsSet(boolean value) {
    if (!value) {
      this.Type = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public MVersion getMinVersion() {
    return this.MinVersion;
  }

  public MDependency setMinVersion(@org.apache.thrift.annotation.Nullable MVersion MinVersion) {
    this.MinVersion = MinVersion;
    return this;
  }

  public void unsetMinVersion() {
    this.MinVersion = null;
  }

  /** Returns true if field MinVersion is set (has been assigned a value) and false otherwise */
  public boolean isSetMinVersion() {
    return this.MinVersion != null;
  }

  public void setMinVersionIsSet(boolean value) {
    if (!value) {
      this.MinVersion = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public MVersion getMaxVersion() {
    return this.MaxVersion;
  }

  public MDependency setMaxVersion(@org.apache.thrift.annotation.Nullable MVersion MaxVersion) {
    this.MaxVersion = MaxVersion;
    return this;
  }

  public void unsetMaxVersion() {
    this.MaxVersion = null;
  }

  /** Returns true if field MaxVersion is set (has been assigned a value) and false otherwise */
  public boolean isSetMaxVersion() {
    return this.MaxVersion != null;
  }

  public void setMaxVersionIsSet(boolean value) {
    if (!value) {
      this.MaxVersion = null;
    }
  }

  public int getExcludedVersionsSize() {
    return (this.ExcludedVersions == null) ? 0 : this.ExcludedVersions.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<MVersion> getExcludedVersionsIterator() {
    return (this.ExcludedVersions == null) ? null : this.ExcludedVersions.iterator();
  }

  public void addToExcludedVersions(MVersion elem) {
    if (this.ExcludedVersions == null) {
      this.ExcludedVersions = new java.util.ArrayList<MVersion>();
    }
    this.ExcludedVersions.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<MVersion> getExcludedVersions() {
    return this.ExcludedVersions;
  }

  public MDependency setExcludedVersions(@org.apache.thrift.annotation.Nullable java.util.List<MVersion> ExcludedVersions) {
    this.ExcludedVersions = ExcludedVersions;
    return this;
  }

  public void unsetExcludedVersions() {
    this.ExcludedVersions = null;
  }

  /** Returns true if field ExcludedVersions is set (has been assigned a value) and false otherwise */
  public boolean isSetExcludedVersions() {
    return this.ExcludedVersions != null;
  }

  public void setExcludedVersionsIsSet(boolean value) {
    if (!value) {
      this.ExcludedVersions = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getName() {
    return this.Name;
  }

  public MDependency setName(@org.apache.thrift.annotation.Nullable java.lang.String Name) {
    this.Name = Name;
    return this;
  }

  public void unsetName() {
    this.Name = null;
  }

  /** Returns true if field Name is set (has been assigned a value) and false otherwise */
  public boolean isSetName() {
    return this.Name != null;
  }

  public void setNameIsSet(boolean value) {
    if (!value) {
      this.Name = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ID:
      if (value == null) {
        unsetID();
      } else {
        setID((java.lang.String)value);
      }
      break;

    case TYPE:
      if (value == null) {
        unsetType();
      } else {
        setType((MDependencyType)value);
      }
      break;

    case MIN_VERSION:
      if (value == null) {
        unsetMinVersion();
      } else {
        setMinVersion((MVersion)value);
      }
      break;

    case MAX_VERSION:
      if (value == null) {
        unsetMaxVersion();
      } else {
        setMaxVersion((MVersion)value);
      }
      break;

    case EXCLUDED_VERSIONS:
      if (value == null) {
        unsetExcludedVersions();
      } else {
        setExcludedVersions((java.util.List<MVersion>)value);
      }
      break;

    case NAME:
      if (value == null) {
        unsetName();
      } else {
        setName((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ID:
      return getID();

    case TYPE:
      return getType();

    case MIN_VERSION:
      return getMinVersion();

    case MAX_VERSION:
      return getMaxVersion();

    case EXCLUDED_VERSIONS:
      return getExcludedVersions();

    case NAME:
      return getName();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ID:
      return isSetID();
    case TYPE:
      return isSetType();
    case MIN_VERSION:
      return isSetMinVersion();
    case MAX_VERSION:
      return isSetMaxVersion();
    case EXCLUDED_VERSIONS:
      return isSetExcludedVersions();
    case NAME:
      return isSetName();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof MDependency)
      return this.equals((MDependency)that);
    return false;
  }

  public boolean equals(MDependency that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_ID = true && this.isSetID();
    boolean that_present_ID = true && that.isSetID();
    if (this_present_ID || that_present_ID) {
      if (!(this_present_ID && that_present_ID))
        return false;
      if (!this.ID.equals(that.ID))
        return false;
    }

    boolean this_present_Type = true && this.isSetType();
    boolean that_present_Type = true && that.isSetType();
    if (this_present_Type || that_present_Type) {
      if (!(this_present_Type && that_present_Type))
        return false;
      if (!this.Type.equals(that.Type))
        return false;
    }

    boolean this_present_MinVersion = true && this.isSetMinVersion();
    boolean that_present_MinVersion = true && that.isSetMinVersion();
    if (this_present_MinVersion || that_present_MinVersion) {
      if (!(this_present_MinVersion && that_present_MinVersion))
        return false;
      if (!this.MinVersion.equals(that.MinVersion))
        return false;
    }

    boolean this_present_MaxVersion = true && this.isSetMaxVersion();
    boolean that_present_MaxVersion = true && that.isSetMaxVersion();
    if (this_present_MaxVersion || that_present_MaxVersion) {
      if (!(this_present_MaxVersion && that_present_MaxVersion))
        return false;
      if (!this.MaxVersion.equals(that.MaxVersion))
        return false;
    }

    boolean this_present_ExcludedVersions = true && this.isSetExcludedVersions();
    boolean that_present_ExcludedVersions = true && that.isSetExcludedVersions();
    if (this_present_ExcludedVersions || that_present_ExcludedVersions) {
      if (!(this_present_ExcludedVersions && that_present_ExcludedVersions))
        return false;
      if (!this.ExcludedVersions.equals(that.ExcludedVersions))
        return false;
    }

    boolean this_present_Name = true && this.isSetName();
    boolean that_present_Name = true && that.isSetName();
    if (this_present_Name || that_present_Name) {
      if (!(this_present_Name && that_present_Name))
        return false;
      if (!this.Name.equals(that.Name))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetID()) ? 131071 : 524287);
    if (isSetID())
      hashCode = hashCode * 8191 + ID.hashCode();

    hashCode = hashCode * 8191 + ((isSetType()) ? 131071 : 524287);
    if (isSetType())
      hashCode = hashCode * 8191 + Type.getValue();

    hashCode = hashCode * 8191 + ((isSetMinVersion()) ? 131071 : 524287);
    if (isSetMinVersion())
      hashCode = hashCode * 8191 + MinVersion.hashCode();

    hashCode = hashCode * 8191 + ((isSetMaxVersion()) ? 131071 : 524287);
    if (isSetMaxVersion())
      hashCode = hashCode * 8191 + MaxVersion.hashCode();

    hashCode = hashCode * 8191 + ((isSetExcludedVersions()) ? 131071 : 524287);
    if (isSetExcludedVersions())
      hashCode = hashCode * 8191 + ExcludedVersions.hashCode();

    hashCode = hashCode * 8191 + ((isSetName()) ? 131071 : 524287);
    if (isSetName())
      hashCode = hashCode * 8191 + Name.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(MDependency other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetID()).compareTo(other.isSetID());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetID()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ID, other.ID);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetType()).compareTo(other.isSetType());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetType()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Type, other.Type);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetMinVersion()).compareTo(other.isSetMinVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMinVersion()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.MinVersion, other.MinVersion);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetMaxVersion()).compareTo(other.isSetMaxVersion());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetMaxVersion()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.MaxVersion, other.MaxVersion);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetExcludedVersions()).compareTo(other.isSetExcludedVersions());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetExcludedVersions()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.ExcludedVersions, other.ExcludedVersions);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetName()).compareTo(other.isSetName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.Name, other.Name);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("MDependency(");
    boolean first = true;

    sb.append("ID:");
    if (this.ID == null) {
      sb.append("null");
    } else {
      sb.append(this.ID);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("Type:");
    if (this.Type == null) {
      sb.append("null");
    } else {
      sb.append(this.Type);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("MinVersion:");
    if (this.MinVersion == null) {
      sb.append("null");
    } else {
      sb.append(this.MinVersion);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("MaxVersion:");
    if (this.MaxVersion == null) {
      sb.append("null");
    } else {
      sb.append(this.MaxVersion);
    }
    first = false;
    if (isSetExcludedVersions()) {
      if (!first) sb.append(", ");
      sb.append("ExcludedVersions:");
      if (this.ExcludedVersions == null) {
        sb.append("null");
      } else {
        sb.append(this.ExcludedVersions);
      }
      first = false;
    }
    if (isSetName()) {
      if (!first) sb.append(", ");
      sb.append("Name:");
      if (this.Name == null) {
        sb.append("null");
      } else {
        sb.append(this.Name);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (ID == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'ID' was not present! Struct: " + toString());
    }
    if (Type == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'Type' was not present! Struct: " + toString());
    }
    if (MinVersion == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'MinVersion' was not present! Struct: " + toString());
    }
    if (MaxVersion == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'MaxVersion' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (MinVersion != null) {
      MinVersion.validate();
    }
    if (MaxVersion != null) {
      MaxVersion.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class MDependencyStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MDependencyStandardScheme getScheme() {
      return new MDependencyStandardScheme();
    }
  }

  private static class MDependencyStandardScheme extends org.apache.thrift.scheme.StandardScheme<MDependency> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, MDependency struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ID
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.ID = iprot.readString();
              struct.setIDIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // TYPE
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.Type = de.mosim.mmi.mmu.MDependencyType.findByValue(iprot.readI32());
              struct.setTypeIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // MIN_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.MinVersion = new MVersion();
              struct.MinVersion.read(iprot);
              struct.setMinVersionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // MAX_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.MaxVersion = new MVersion();
              struct.MaxVersion.read(iprot);
              struct.setMaxVersionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 5: // EXCLUDED_VERSIONS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list74 = iprot.readListBegin();
                struct.ExcludedVersions = new java.util.ArrayList<MVersion>(_list74.size);
                @org.apache.thrift.annotation.Nullable MVersion _elem75;
                for (int _i76 = 0; _i76 < _list74.size; ++_i76)
                {
                  _elem75 = new MVersion();
                  _elem75.read(iprot);
                  struct.ExcludedVersions.add(_elem75);
                }
                iprot.readListEnd();
              }
              struct.setExcludedVersionsIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 6: // NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.Name = iprot.readString();
              struct.setNameIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, MDependency struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.ID != null) {
        oprot.writeFieldBegin(ID_FIELD_DESC);
        oprot.writeString(struct.ID);
        oprot.writeFieldEnd();
      }
      if (struct.Type != null) {
        oprot.writeFieldBegin(TYPE_FIELD_DESC);
        oprot.writeI32(struct.Type.getValue());
        oprot.writeFieldEnd();
      }
      if (struct.MinVersion != null) {
        oprot.writeFieldBegin(MIN_VERSION_FIELD_DESC);
        struct.MinVersion.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.MaxVersion != null) {
        oprot.writeFieldBegin(MAX_VERSION_FIELD_DESC);
        struct.MaxVersion.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.ExcludedVersions != null) {
        if (struct.isSetExcludedVersions()) {
          oprot.writeFieldBegin(EXCLUDED_VERSIONS_FIELD_DESC);
          {
            oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.ExcludedVersions.size()));
            for (MVersion _iter77 : struct.ExcludedVersions)
            {
              _iter77.write(oprot);
            }
            oprot.writeListEnd();
          }
          oprot.writeFieldEnd();
        }
      }
      if (struct.Name != null) {
        if (struct.isSetName()) {
          oprot.writeFieldBegin(NAME_FIELD_DESC);
          oprot.writeString(struct.Name);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class MDependencyTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public MDependencyTupleScheme getScheme() {
      return new MDependencyTupleScheme();
    }
  }

  private static class MDependencyTupleScheme extends org.apache.thrift.scheme.TupleScheme<MDependency> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, MDependency struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.ID);
      oprot.writeI32(struct.Type.getValue());
      struct.MinVersion.write(oprot);
      struct.MaxVersion.write(oprot);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetExcludedVersions()) {
        optionals.set(0);
      }
      if (struct.isSetName()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetExcludedVersions()) {
        {
          oprot.writeI32(struct.ExcludedVersions.size());
          for (MVersion _iter78 : struct.ExcludedVersions)
          {
            _iter78.write(oprot);
          }
        }
      }
      if (struct.isSetName()) {
        oprot.writeString(struct.Name);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, MDependency struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.ID = iprot.readString();
      struct.setIDIsSet(true);
      struct.Type = de.mosim.mmi.mmu.MDependencyType.findByValue(iprot.readI32());
      struct.setTypeIsSet(true);
      struct.MinVersion = new MVersion();
      struct.MinVersion.read(iprot);
      struct.setMinVersionIsSet(true);
      struct.MaxVersion = new MVersion();
      struct.MaxVersion.read(iprot);
      struct.setMaxVersionIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        {
          org.apache.thrift.protocol.TList _list79 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
          struct.ExcludedVersions = new java.util.ArrayList<MVersion>(_list79.size);
          @org.apache.thrift.annotation.Nullable MVersion _elem80;
          for (int _i81 = 0; _i81 < _list79.size; ++_i81)
          {
            _elem80 = new MVersion();
            _elem80.read(iprot);
            struct.ExcludedVersions.add(_elem80);
          }
        }
        struct.setExcludedVersionsIsSet(true);
      }
      if (incoming.get(1)) {
        struct.Name = iprot.readString();
        struct.setNameIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

