import org.junit.Test;

import static org.junit.Assert.*;
/** Testing class for schedule
 * @author <em>Omar Loudghiri</em>
 */
public class ScheduleTest {

    //create a schedule and create slots to add
    Schedule schedule = new Schedule();
    Job job1 = new Job(1,1,1,1,1);
    Job job2 = new Job(2,2,4,1,1);
    Job job3 = new Job(3,3,1,1,1);
    ScheduleSlot slot1 = new ScheduleSlot(job1, 1);
    ScheduleSlot slot2 = new ScheduleSlot(job2,2);
    ScheduleSlot slot3 = new ScheduleSlot(job3, 3);

    @Test
    public void noJobAt() {
        // loop test: 0 no object
        assertTrue(schedule.noJobAt(10));
        //1.add the slots to the schedule
        schedule.add(slot1);
        assertFalse(schedule.noJobAt(1));
        //many
        schedule.add(slot2);
        schedule.add(slot3);
        //middle
        assertFalse(schedule.noJobAt(2));
        //end
        assertFalse(schedule.noJobAt(3));

    }
}