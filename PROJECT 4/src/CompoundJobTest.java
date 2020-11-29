import org.junit.Test;

import static org.junit.Assert.*;

public class CompoundJobTest {

    Job subjob1 = new Job(1,1,2,2,0);
    Job subjob2 = new Job(2,3,2,2,0);
    Job subjob3 = new Job(3,4,2,2,0);
    Job subjob4 = new Job(4,2,7,2,0);
    Job[] subjobs = {subjob1, subjob2 ,subjob3, subjob4 };
    CompoundJob compoundJob = new CompoundJob(10,subjobs);

    @Test
    public void Compound() {
        assertEquals(compoundJob.getId(),1);
        assertEquals(compoundJob.getEarliestStart(),1);
        assertEquals(compoundJob.getDeadline(),7);
        assertEquals(compoundJob.getDuration(),8);
    }

    @Test
    public void getSubJobs() {
        assertEquals(compoundJob.getSubJobs(), subjobs);
    }
}