package access.modifier;

public class Why_we_make_a_Java_Class_as_an_abstract_class_without_having_any_abstract_method {
  
}

/**
------------
		My guess would be: to prevent substantiation of your class (which cannot be done for an Abstract class), but without
a specific reference or example, it's hard to tell the exact reason.
------------
		Yes It is possible to create an abstract class without abstract method. To clear this concept you need to understand
below points. 

1. We can not create object of abstract class (As JVM cant allocate memory for abstract class). So if you want to prevent
to object creation of your class you can make it abstract class. 

2. But what I believe is better to go with interface if you don't have any abstract method into the abstract class.
As interface methods are internally public abstract only. 

3. Check the possibility, weather you require any abstract method in abstract class in future. 

4. You can not extend multiple class in java, so if you want to extend some another class except abstract then go for interface. 

Let me know if you have still any confusion.
------------
		Well when we declare class abstract we put some common method that could be used by subclass . For instance class
called vehicle there must be some common methods those are mandatory to be implemented and there are some methods those
are option in this case features of vehicle could be different(non abstract method) but some class are common such
start_engine , stop_engine(abstract method) . I hope these clear your doubt

*/
