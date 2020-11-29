/** this class represents a job that is made of many other smaller jobs
 * @author <em>Omar Loudghiri</em>
 */
public class CompoundJob extends Job{

    // an array that stores the sub jobs of this compound job
    private Job[] subJobs;

    /**
     * creates an instance of a compound job and initializes the values of the compound job
     * @param profit        how much money will the completion of this job make
     * @param subJobs       the array that contains the subjobs of this compound job
     */
    public CompoundJob(int profit, Job... subJobs) {
        super(subJobs[0].getId(), subJobs[0].getEarliestStart(), subJobs[subJobs.length - 1].getDeadline(), 0, profit);
        // set the duration of the compound job to be the addition of each job's duration
        int duration = 0;
        for (Job subJob : subJobs) {
            duration += subJob.getDuration();
        }
        this.setDuration(duration);
    }

    /**
     * a method to retrieve the array of jobs that composes this compound job
     * @return the array of jobs
     */
    public Job[] getSubJobs() {
        return this.subJobs;
    }
}
