/** this interface contains the method to schedule a job
 * @author <em>Omar Loudghiri</em>
 */
public interface ScheduleMetric {
    /**
     * a method that will be overridden to work, it will add the job input to the schedule
     * @param s the schedule where the job will be added
     * @param job the job that will be added
     * @return true if the job was added, false if it wasn't
     */
    boolean scheduleJob(Schedule s, Job job);
}
