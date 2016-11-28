package util.List;

/**
 * The LinkedList is the other main implementation of the List.
 * Rather than having an array store the list elements, you use an internal object,
 * which points to another object of the same type for the next element in the list.
 * Listing 5-3 shows a simplified version of how to set up a LinkedList.
 * */
public class SimpleLinkedList<E> {
  
  private static class Element<E> {
    
    E value; //giá trị hiện tại
    Element<E> next; //giá trị tiếp theo
  }
  
  private Element<E> head; //giá trị đầu
  /**
   * The LinkedList instance contains a reference to the head of the list, represented as an Element.
   * The Element inner class is a recursive data type,
   * with the next field pointing to the next element in the list.
   * This enables you to traverse(/'trævə:s/ sự đi ngang qua)  the list easily, visiting and processing each element in order.
   * 
   * Like all of the differences between implementations, some trade-offs exist.
   * If you want to get an element by its index, you need to traverse the length of the list,
   * keeping count until you reach the given index. For an ArrayList, which has random access, using get is instant
   * 
   * 
   * It is quite clear that you have powerful reasons to use both LinkedLists and ArrayLists.
   * As a rule of thumb, you should use an ArrayList if you need random access to elements in the list, especially
   * if your use case could result in large lists.
   * 
   * Nếu hoàn toan clear, có nguyên nhân mạnh mẽ nào sử dụng cả hai LinkedLists and ArrayLists,
   * như vai trò của quyền ai,
   * 
   * If you intend to make many insertions and deletions particularly
   * if you make them at the beginning or in the middle of the list, then a LinkedListwould make more sense.
   * LinkedLists also do not suffer from the expensive array reallocation process that occurs with ArrayLists,
   * and as your list shrinks, so does your memory consumption.
   * If you were to create your own specialized data structure, such as a stack,
   * using a LinkedList as the underlying data structure would make sense,
   * because you would simply push and pop elements at the head of the list.
   * */
}
