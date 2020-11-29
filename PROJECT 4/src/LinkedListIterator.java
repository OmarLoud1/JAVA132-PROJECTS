import java.util.ListIterator;
import java.util.NoSuchElementException;

/** an implementation of a list iterator
 *@author <em> Omar Loudghiri </em>
 */

public class LinkedListIterator<T> implements ListIterator<T> {
    // a pointer to keep track of what node we are looking at
    private  DLNode<T> nodePointer;

    /**
     * the constructor for the itrator, takes a list and points at the first element
     * @param list an iterable linked list that
     */
    public LinkedListIterator(DoubleLinkedList<T> list){
    nodePointer = list.getFront();
    nodePointer = list.getBack();
    }

    /**
     * a method that adds a node right after the position at which the node pointer is pointing
     * @param add the element to be added in the list
     */
    @Override
    public void add(T add) {
        // if the list is not null, it adds the
        if(nodePointer != null){
            DLNode<T> toAdd = new DLNode<>(add, nodePointer,nodePointer.getNext());
            nodePointer.getNext().setPrevious(toAdd);
            nodePointer.setNext(toAdd);
        }
        else {
            DLNode<T> toAdd = new DLNode<>(add, null, null);
            DoubleLinkedList<T> list = new DoubleLinkedList<>();
            list.setFront(toAdd);
            list.setBack(toAdd);
        }
    }

    /**
     * a method to check that the node following this one is not null
     * @return true if the next node exists, false if it doesn't exist
     */
    @Override
    public boolean hasNext() {
        return nodePointer.getNext() != null;
    }

    /**
     * a method to set the node pointer to the next position
     * @return the position the node pointer is at after it moves
     */
    @Override
    public T next() {
        T temp = nodePointer.getElement();
        nodePointer = nodePointer.getNext();
        return temp;
    }

    /**
     * a method to make sure there is a node before the one we are pointing at
     * @return true if there is a node before, false if there nothing
     */
    @Override
    public boolean hasPrevious() {
        if( nodePointer == null)
            return false;
        else
            return nodePointer.getPrevious() != null;
    }

    /**
     *sets the node pointer the position that is right before it
     * @return the element of the previous node
     */
    @Override
    public T previous() {
        T temp = nodePointer.getElement();
        nodePointer = nodePointer.getPrevious();
        return temp;
    }

    /**
     * a method to remove the node we are pointing at directly
     */
    @Override
    public void remove() {
        // if the node pointer pointer points to a an existing node
        if (nodePointer.getPrevious() != null && nodePointer.getNext() != null){
            nodePointer.getPrevious().setNext(nodePointer.getNext());
            nodePointer.getNext().setPrevious(nodePointer.getPrevious());
        }
        else if (nodePointer.getPrevious() == null && nodePointer.getNext() != null)
            nodePointer.getNext().setPrevious(null);
        else if (nodePointer.getPrevious() != null && nodePointer.getNext() == null)
            nodePointer.getPrevious().setNext(null);
        else
            throw new NoSuchElementException();
    }

    /**
     * non supported
     */
    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException();
    }
    /**
     * non supported
     */
    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException();
    }
    /**
     * non supported
     */
    @Override
    public void set(T t) {
        throw new UnsupportedOperationException();
    }
}
