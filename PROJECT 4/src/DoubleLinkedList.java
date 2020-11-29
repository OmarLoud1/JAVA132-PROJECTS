import java.util.*;

/**  A doubly linked linked list that inplements an iterator
 * @author <em> Omar Loudghiri </em>
 * @author <em>Harold Connamacher ( Lab File )</em>
 */
public class DoubleLinkedList<T> implements Iterable<T> {
  /**
   * a reference to the first node of the double linked list
   */
  private DLNode<T> front;

  /**
   * a reference to the last node of a double linked list
   */
  private DLNode<T> back;

  /**
   * Create an empty double linked list.
   */
  public DoubleLinkedList() {
    front = back = null;
  }

  /**
   * Returns true if the list is empty.
   *
   * @return true if the list has no nodes
   */
  public boolean isEmpty() {
    return (getFront() == null);
  }

  /**
   * Returns the reference to the first node of the linked list.
   *
   * @return the first node of the linked list
   */
  protected DLNode<T> getFront() {
    return front;
  }

  /**
   * Sets the first node of the linked list.
   *
   * @param node the node that will be the head of the linked list.
   */
  protected void setFront(DLNode<T> node) {
    front = node;
  }

  /**
   * Returns the reference to the last node of the linked list.
   *
   * @return the last node of the linked list
   */
  protected DLNode<T> getBack() {
    return back;
  }

  /**
   * Sets the last node of the linked list.
   *
   * @param node the node that will be the last node of the linked list
   */
  protected void setBack(DLNode<T> node) {
    back = node;
  }

  /**
   * Add an element to the head of the linked list.
   *
   * @param element the element to add to the front of the linked list
   */
  public void addToFront(T element) {
    if (isEmpty()) {
      DLNode<T> temp = new DLNode<T>(element, null, null);
      setFront(temp);
      setBack(temp);
    } else {
      DLNode<T> temp = new DLNode<T>(element, null, this.getFront());
      setFront(temp);
    }
  }

  /**
   * Add an element to the tail of the linked list.
   *
   * @param element the element to add to the tail of the linked list
   */
  public void addToBack(T element) {


    if (isEmpty()) {
      DLNode<T> temp = new DLNode<T>(element, null, null);
      setFront(temp);
      setBack(temp);
    } else {
      DLNode<T> temp = new DLNode<T>(element, getBack(), null);
      setBack(temp);
    }
  }

  /**
   * Remove and return the element at the front of the linked list.
   *
   * @return the element that was at the front of the linked list
   * @throws NoSuchElementException if attempting to remove from an empty list
   */
  public T removeFromFront() {
    if (isEmpty())
      throw new NoSuchElementException();
    else {
      T temp = getFront().getElement();
      setFront(getFront().getNext());
      return temp;
    }
  }

  /**
   * Remove and return the element at the back of the linked list.
   *
   * @return the element that was at the back of the linked list
   * @throws NoSuchElementException if attempting to remove from an empty list
   */
  public T removeFromBack() {
    if (isEmpty())
      throw new NoSuchElementException();
    else if (getFront().equals(getBack())) {
      T temp = getBack().getElement();
      setFront(null);
      setBack(null);
      return temp;
    } else {
      T temp = getBack().getElement();
      setBack(getBack().getPrevious());
      return temp;
    }
  }

  /**
   * Returns an interator for the linked list that starts at the head of the list and runs to the tail.
   * the Linked List iterator has its own class
   * @return the iterator that runs through the list from the head to the tail
   */
  @Override
  public Iterator<T> iterator() throws UnsupportedOperationException {
    return new LinkedListIterator<T>(this);
  }
}
