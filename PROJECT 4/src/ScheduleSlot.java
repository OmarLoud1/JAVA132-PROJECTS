import java.util.Comparator;

/**this class represents the slot in the schedule and what job is present there
 * @author <em>Omar Loudghiri</em>
 */
public class ScheduleSlot implements Comparable<ScheduleSlot> {

    // a field to store the job that is saved on this slot of the schedule
    private final Job job;

    // a field to store the time this slot starts
    private int startTime;

    // the time this slot finishes, it is the addition of the duration to the start time.
    private final int endTime;

    /**
     * the constructor that sets what job this slot has and also the time it starts at.
     * @param job the job to be scheduled
     * @param startTime the starting time.
     */
    public ScheduleSlot(Job job, int startTime){
        this.job = job;
        this.startTime = startTime;
        this.endTime = job.getDuration() + this.startTime;
    }

    /**
     * a method that returns what job is scheduled for this slot
     * @return the job scheduled
     */
    public Job getJob() {
        return job;
    }

    /**
     * a method that gets at what time this slot starts
     * @return the time value
     */
    public int getStartTime() {
        return startTime;
    }

    /**
     * a method that sets the starting time of this field
     * @param startTime is the time at which we want the slot to start
     */
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    /**
     * a method that gets at what time this slot starts
     * @return the time value
     */
    public int getEndTime() {
        return endTime;
    }

    /**
     * a comparator that will compare the schedule slots by start time
     * @param o the slot we are comparing with
     * @return negative if the caller's start time is earlier, 0 if the same, positive if later.
     */
    @Override
    public int compareTo(ScheduleSlot o) {
        return this.getStartTime() - o.getStartTime();
    }

    /**
     *  a nested class that compares two objects depending on how early they start
     */
    public static class sortByEarliestStart implements Comparator<ScheduleSlot> {

        /**
         * compare two slots by how early they start
         * @param slot1 the first slot to compare
         * @param slot2 the second slot to compare
         * @return less than 0 if job1 starts earlier, 0 if it's the same time, more than 0 if job1 starts later
         */
        @Override
        public int compare(ScheduleSlot slot1, ScheduleSlot slot2) {
            return (slot1.getStartTime() - slot2.getStartTime());
        }
    }

    /**
     * a method that returns the comparator that sorts by how early a job starts
     * @return the comparator that compares by how early the job starts
     */
    public static Comparator<ScheduleSlot> getSlotStartComparator(){
        return new ScheduleSlot.sortByEarliestStart();
    }

}
