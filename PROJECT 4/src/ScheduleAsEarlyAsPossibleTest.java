import org.junit.Test;

import static org.junit.Assert.*;

public class ScheduleAsEarlyAsPossibleTest extends ScheduleAsEarlyAsPossible {

    Job job1 = new Job(1,2,6,2,2);
    Job job2 = new Job(2,4,9,3,2);
    Job job3 = new Job(3,5,13,2,2);
    Job job4 = new Job(4,1,4,1,2);
    Job job5 = new Job(5,12,10,1,2);
    Schedule schedule = new Schedule();

    @Test
    public void scheduleJobTest() {
        //0.nothing in list
        scheduleJob(schedule, job1);
        assertEquals(schedule.getFirst().getJob(), job1);
        assertEquals(schedule.getFirst().getStartTime(), 2);

        //1. insert after the first element
        scheduleJob(schedule, job2);
        assertEquals(schedule.getLast().getJob(), job2);
        assertEquals(schedule.getLast().getStartTime(), 4);

        //many. last. insert after two elements
        scheduleJob(schedule, job3);
        assertEquals(schedule.getLast().getJob(), job3);
        assertEquals(schedule.getLast().getStartTime(),7);

        //first. shceduled before the first element
        scheduleJob(schedule, job4);
        // assertEquals(schedule.getFirst().getJob(), job4);
        // assertEquals(schedule.getFirst().getStartTime(), 2);

        //middle should go between job2 and job3
        scheduleJob(schedule, job5);
        //assertEquals(schedule.listIterator(3).next().getJob(), job5);

        //compund job test
        Job subjob1 = new Job(1,15,2,2,0);
        Job subjob2 = new Job(2,12,2,2,0);
        Job subjob3 = new Job(3,14,2,2,0);
        Job subjob4 = new Job(4,16,25,2,0);
        Job[] subjobs = {subjob1, subjob2 ,subjob3, subjob4 };
        CompoundJob compoundJob = new CompoundJob(10, subjobs);

        scheduleJob(schedule, compoundJob);
        assertEquals(schedule.getLast().getJob(), compoundJob);
        assertEquals(schedule.getLast().getStartTime(),15);

        Job subjob5 = new Job(1,7,2,2,0);
        Job subjob6 = new Job(2,12,2,2,0);
        Job subjob7 = new Job(3,14,2,2,0);
        Job subjob8 = new Job(4,16,10,2,0);
        Job[] subjobs1 = {subjob5, subjob6 ,subjob7, subjob8 };
        CompoundJob compoundJob1 = new CompoundJob(10, subjobs1);

        assertFalse(scheduleJob(schedule,compoundJob1));
    }
}