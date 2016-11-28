package lang.String;

import java.util.Date;

import org.apache.log4j.Logger;

public class Difference_Between_String_StringBuilder_and_StringBuffer {
  
  private static Logger _log = Logger.getLogger(Difference_Between_String_StringBuilder_and_StringBuffer.class);
  
  public static void main(String[] args) {
    
    long totalStringBufferTest = 0;
    long totalStringBuilderTest = 0;
    for (int i = 0; i < 10; i++) {
      totalStringBufferTest += stringBufferTest();
      totalStringBuilderTest += stringBuilderTest();
    }
    
    _log.info("Total time in milliseconds for StringBuffer test:" + totalStringBufferTest);
    _log.info("Total time in milliseconds for StringBuilder test:" + totalStringBuilderTest);
    
  }
  
  public static long stringBufferTest() {
    Date start = new Date();
    StringBuffer stringBuffer = new StringBuffer();
    for (int i = 0; i < 5000000; i++) {
      stringBuffer.append("a");
    }
    Date end = new Date();
    long millis = end.getTime() - start.getTime();
    _log.info("StringBuffer time in milliseconds:" + millis);
    return millis;
  }
  
  public static long stringBuilderTest() {
    Date start = new Date();
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < 5000000; i++) {
      stringBuilder.append("a");
    }
    Date end = new Date();
    long millis = end.getTime() - start.getTime();
    _log.info("StringBuilder time in milliseconds:" + millis);
    return millis;
  }
}
/**

		Today we are going to understand the difference between String, StringBuilder and StringBuffer. As you will find
that there are minor differences between the above mentioned classes.

========================String==============================
		String is immutable (once created can not be changed )object. The object created as a String is stored in the
Constant String Pool.
		Every immutable object in Java is thread safe,that implies String is also thread safe. String can not be used by
two threads simultaneously. String  once assigned can not be changed .

		String  demo = "hello";
The above object is stored in constant string pool and its value can not be modified.


demo="Bye";//new "Bye" string is created in constant pool and referenced by the demo variable
"hello" string still exists in string constant pool and its value is not overrided but we lost reference to the
"hello"string

========================StringBuffer========================
		StringBuffer is mutable means one can change the value of the object. The object created through StringBuffer is
stored in the heap. StringBuffer has the same methods as the StringBuilder, but each method in StringBuffer is
synchronized that is StringBuffer is thread safe.

		Due to this it does not allow  two threads to simultaneously access the same method. Each method can be accessed by
one thread at a time .

		But being thread safe has disadvantages too as the performance of the StringBuffer hits due to thread safe property.
Thus StringBuilder is faster than the StringBuffer when calling the same methods of each class.

		StringBuffer value can be changed, it means it can be assigned to the new value. Now a days its a most common
interview question ,the differences between the above classes. StringBuffer can be converted to the string by using 
toString() method.

StringBuffer demo1 = new StringBuffer("Hello") ;
// The above object stored in heap and its value can be changed .
demo1 = new StringBuffer("Bye");
// Above statement is right as it modifies the value which is allowed in the StringBuffer

========================StringBuilder========================

		StringBuilder is same as the StringBuffer, that is it stores the object in heap and it can also be modified.
The main difference between the StringBuffer and StringBuilder is that StringBuilder is also not thread safe. 
StringBuilder is fast as it is not thread safe.


StringBuilder demo2 = new StringBuilder("Hello");
//The above object too is stored in the heap and its value can be modified
demo2 = new StringBuilder("Bye"); 
//Above statement is right as it modifies the value which is allowed in the StringBuilder.

========================
		The StringBuffer class has been around since the earliest days of JavaSW. Whereas a String is immutableW (can't
change once it's been created), a StringBuffer is mutable. It can change in terms of length and content. StringBuffers
are thread-safe, meaning that they have synchronized methods to control access so that only one thread can access a
StringBuffer object's synchronized code at a time. Thus, StringBuffer objects are generally safe to use in a
ulti-threaded environment where multiple threads may be trying to access the same StringBuffer object at the same time.

		The StringBuilder class was added to Java in version 1.5. The StringBuilder class is very similar to StringBuffer,
except that its access is not synchronized so that it is not thread-safe. By not being synchronized, the performance of
StringBuilder can be better than StringBuffer. Thus, if you are working in a single-threaded environment, using
StringBuilder instead of StringBuffer may result in increased performance. This is also true of other situations such
as a StringBuilder local variable (ie, a variable within a method) where only one thread will be accessing a
StringBuilder object.

		Let's do a simple test to compare the performance of StringBuilder and StringBuffer. The StringBuilderStringBuffer
class below compares StringBuilder and StringBuffer. It times the appending of 5 million "a"s to a StringBuffer object
and does the same for a StringBuilder object. It does this 10 times and records the total times. These totals are
displayed in the console.


*/
