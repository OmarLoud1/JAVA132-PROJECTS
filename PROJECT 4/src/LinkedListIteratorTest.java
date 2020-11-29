import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;
/** Testing Class for Iterator
 *@author <em> Omar Loudghiri </em>
 */

public class LinkedListIteratorTest {
    // create a double linked list
    DoubleLinkedList<Job> list = new DoubleLinkedList<>();
    // assign an iterator to it
    LinkedListIterator<Job> iterator = new LinkedListIterator<>(list);
    //create jobs instances
    Job job1 = new Job(1,1,1,1,1);
    Job job2 = new Job(2,2,2,2,2);
    Job job3 = new Job(3,3,3,3,3);

    @Test
    public void add() {
        //create a list iterator
        list.iterator();
        // add a job to the list and check it is there
        iterator.add(job1);
        assertEquals(list.getFront().getElement(), job1);
        list.addToFront(job1);
        iterator.add(job2);
        assertEquals(list.getBack().getElement(), job2);
    }

    @Test
    public void hasNext() {
        // add elements to the list and add an iterator
        list.addToFront(job3);
        list.addToFront(job2);
        list.addToFront(job1);
        LinkedListIterator<Job> iterator1 = new LinkedListIterator<>(list);
        //check that the first element has a next
        assertTrue(iterator1.hasNext());
        //move until the end
        iterator1.next();
        iterator1.next();
        assertFalse(iterator1.hasNext());
    }

    @Test
    public void next() {
        // add elements to the list and add an iterator
        list.addToFront(job3);
        list.addToFront(job2);
        list.addToFront(job1);
        LinkedListIterator<Job> iterator1 = new LinkedListIterator<>(list);
        //check that returns next returns the element it was pointing and check the second next returns the second elelemt
        assertEquals(iterator1.next(),job1);
        assertEquals(iterator1.next(),job2);
    }

    @Test
    public void hasPrevious() {
        list.addToFront(job3);
        list.addToFront(job2);
        list.addToFront(job1);
        LinkedListIterator<Job> iterator1 = new LinkedListIterator<>(list);
        assertFalse(iterator1.hasPrevious());
        iterator1.next();
        assertTrue(iterator1.hasPrevious());
    }

    @Test
    public void previous() {
        list.addToFront(job3);
        list.addToFront(job2);
        list.addToFront(job1);
        LinkedListIterator<Job> iterator1 = new LinkedListIterator<>(list);
        iterator1.next();
        iterator1.next();
        assertEquals(iterator1.previous(), job3);
        assertEquals(iterator1.previous(), job2);
    }

    @Test
    public void remove() {
        list.addToFront(job3);
        list.addToFront(job2);
        list.addToFront(job1);
        LinkedListIterator<Job> iterator1 = new LinkedListIterator<>(list);
        iterator1.remove();
        assertEquals(list.getFront().getElement(), job2);
    }
}