package serialization.json;

public class CanXSDdocumentsBeUsedToCreateJavaDomainObjects {
  
  /**
  JAXB is run through a separate compiler, which parses XSD content and creates Java source files.
  The xjc command is distributed as part of the JDK.
  If you run:  xjc -p com.wiley.acinginterview.chapter15.generated /path/to/team.xsd

  you should see the following output:
  parsing a schema...
  compiling a schema...
  com/wiley/acinginterview/chapter15/generated/ObjectFactory.java
  com/wiley/acinginterview/chapter15/generated/Team.java

  If you inspect the Team.java file, you can see that it is a regular Java class.
  This class is a representation of the team.xsd created in Listing 15-5, and can be used as any Java object,
  such as that shown in Listing 15-6
  * */
}
