/**
 * Autogenerated by Thrift Compiler (0.13.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package de.mosim.mmi.avatar;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.13.0)", date = "2020-12-08")
public enum MEndeffectorType implements org.apache.thrift.TEnum {
  LeftHand(0),
  LeftFoot(1),
  RightHand(2),
  RightFoot(3),
  Root(4);

  private final int value;

  private MEndeffectorType(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static MEndeffectorType findByValue(int value) { 
    switch (value) {
      case 0:
        return LeftHand;
      case 1:
        return LeftFoot;
      case 2:
        return RightHand;
      case 3:
        return RightFoot;
      case 4:
        return Root;
      default:
        return null;
    }
  }
}
