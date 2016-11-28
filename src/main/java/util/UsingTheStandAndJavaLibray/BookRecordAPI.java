package util.UsingTheStandAndJavaLibray;

public class BookRecordAPI {
  
  /**
   * The APIs available as part of the standard Java library cover a wide range of domains,
   * from database access to optimized sorting and searching algorithms,
   * from concurrency APIs to two user interface frameworks
   * 
   * Why do fields that are private also need to be marked as final to make them immutable
   * 
   * If you had a final class with no accessible setters, and all fields were private,
   * you could be inclined to think that the class is immutable
   * */
  
  private String author;
  private String bookTitle;
  
  public BookRecordAPI(String author, String bookTitle) {
    this.author = author;
    this.bookTitle = bookTitle;
  }
  
  public String getAuthor() {
    return author;
  }
  
  public String getBookTitle() {
    return bookTitle;
  }
  
}
