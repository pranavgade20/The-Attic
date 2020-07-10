# The-Attic

This is where I put random/unrelated, but useful stuff.

## ClassDescriber

A Java class intended to be used ONLY FOR DEBUGGING. This class has methods to obtain information about constructors, methods and fields an object has.

#### Usage

Use `ClassDescriber.describe(Object obj)` for a summary about the object. You can also use `describeConstructors(Object)`, `describeMethods(Object)`, and `describeVars(Object)` for summarizing constructors, methods, and fields the object has. `describeVars` also attempts to get the values of public variables of the object, which is especially handy if you are debugging something you can write a patch to, but cannot set up proper debugging tools.

#### Example

`ClassDescriber.describe((byte)42)` returns:

`Class: java.lang.Byte`

`Constructors:`
`java.lang.Byte(byte arg0)`
`java.lang.Byte(java.lang.String arg0)`

`Methods:`
`equals(java.lang.Object arg0)`
`toString(void)`
`toString(byte arg0)`
`hashCode(byte arg0)`
`hashCode(void)`
`compareTo(java.lang.Byte arg0)`
`compareTo(java.lang.Object arg0)`
`byteValue(void)`
`shortValue(void)`
`intValue(void)`
`longValue(void)`
`floatValue(void)`
`doubleValue(void)`
`valueOf(java.lang.String arg0, int arg1)`
`valueOf(java.lang.String arg0)`
`valueOf(byte arg0)`
`decode(java.lang.String arg0)`
`compare(byte arg0, byte arg1)`
`toUnsignedInt(byte arg0)`
`toUnsignedLong(byte arg0)`
`parseByte(java.lang.String arg0)`
`parseByte(java.lang.String arg0, int arg1)`
`compareUnsigned(byte arg0, byte arg1)`
`wait(long arg0)`
`wait(long arg0, int arg1)`
`wait(void)`
`getClass(void)`
`notify(void)`
`notifyAll(void)`

`Fields:`
`public static final byte MIN_VALUE = -128`
`public static final byte MAX_VALUE = 127`
`public static final java.lang.Class TYPE = byte`
`private final byte value`
`public static final int SIZE = 8`
`public static final int BYTES = 1`
`private static final long serialVersionUID`