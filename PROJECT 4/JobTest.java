import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    // create an instance.
    Job job = new Job(1,2,10,3,5);

    @Test
    public void getId() {
        //make sure the getter return
        assertEquals(job.getId(), 1);
    }

    @Test
    public void getEarliestStart() {
        assertEquals(job.getEarliestStart(),2);
    }

    @Test
    public void getDeadline() {
        assertEquals(job.getDeadline(), 10);
    }

    @Test
    public void getDuration() {
        assertEquals(job.getDuration(), 3);
    }

    @Test
    public void getProfit() {
        assertEquals(job.getProfit(),5);
    }

    @Test
    public void testEquals() {
        Job job1 = new Job(1,2,2,2,2);
        assertTrue(job.equals(job1));
        Job job2 = new Job(2,2,2,2,2);
        assertFalse(job1.equals(job2));
    }

    @Test
    public void compareTo() {
        Job job1 = new Job(1,2,2,2,2);
        Job job2 = new Job(2,2,2,2,2);
        Job job3 = new Job(3,2,2,2,2);
        assertEquals(job1.compareTo(job), 0);
        assertEquals(job1.compareTo(job2), -1);
        assertEquals(job3.compareTo(job2), 1);
    }

    @Test
    public void getStartComparator() {
    }

    @Test
    public void getProfitComparator() {
    }
}