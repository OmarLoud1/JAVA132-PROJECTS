import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

/**Testing class for ScheduleSlot
 * @author <em>Omar Loudghiri</em>
 */
public class ScheduleSlotTest {

    Job job1 = new Job(1,1,1,1,1);
    ScheduleSlot slot = new ScheduleSlot(job1, 1);
    @Test
    public void getJob() {
        assertEquals(slot.getJob(), job1);
    }

    @Test
    public void getStartTime() {
        assertEquals(slot.getStartTime(), 1);
    }

    @Test
    public void setStartTime() {
        slot.setStartTime(3);
        assertEquals(slot.getStartTime(), 3);
    }

    @Test
    public void getEndTime() {
        assertEquals(slot.getEndTime(),2);
    }

    @Test
    public void compareTo() {
        Job job2 = new Job(2,2,4,1,1);
        Job job3 = new Job(3,3,1,1,1);
        ScheduleSlot slot2 = new ScheduleSlot(job2,2);
        ScheduleSlot slot3 = new ScheduleSlot(job3, 3);

        assertEquals(slot.compareTo(slot3), -2);
        assertEquals(slot.compareTo(slot), 0);
        assertEquals(slot3.compareTo(slot2),1);
    }

    @Test
    public void getSlotStartComparator() {
        Job job2 = new Job(2,2,4,1,1);
        Job job3 = new Job(3,3,1,1,1);
        ScheduleSlot slot2 = new ScheduleSlot(job2,2);
        ScheduleSlot slot3 = new ScheduleSlot(job3, 3);

        LinkedList<ScheduleSlot> list = new LinkedList<>();
        list.addFirst(slot2);
        list.addFirst(slot);
        list.addFirst(slot3);

        assertEquals(list.getFirst(), slot3);
        //sort the list with the comparator
        list.sort(ScheduleSlot.getSlotStartComparator());
        assertEquals(list.getFirst(),slot);
    }
}