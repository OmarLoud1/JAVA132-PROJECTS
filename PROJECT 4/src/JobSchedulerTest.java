import org.junit.Test;

import java.util.Comparator;
import java.util.LinkedList;

import static org.junit.Assert.*;

/** Testing class for schedule job
 * @author <em> Omar Loudghiri </em>
 */
public class JobSchedulerTest extends JobScheduler {
    @Test
    public void scheduleJobstest() {
        LinkedList<Job> jobs = new LinkedList<>();
        Job job1 = new Job(1,2,6,2,2);
        jobs.addFirst(job1);
        Job job2 = new Job(2,4,9,3,2);
        jobs.addLast(job2);
        Job job3 = new Job(3,5,13,2,2);
        jobs.addLast(job3);
        Job job4 = new Job(4,1,4,1,10);
        jobs.addLast(job4);
        Job job5 = new Job(5,12,10,1,2);
        jobs.addLast(job5);

        Schedule schedule = scheduleJobs(jobs, Job.getProfitComparator(),new ScheduleAsLateAsPossible());

        assertEquals(schedule.getFirst().getJob(), job4);
        assertEquals(schedule.getLast().getJob(), job3);

    }
}