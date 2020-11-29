import java.util.*;

/**this class stores the characteristics of a job
 * @author <em>Omar Loudghiri</em>
 */
public class Job implements Comparable<Job> {

    //field that stores the job's unique id
    private final int id;

    // a field that stores how early a job can start
    private final int earliestStart;

    //a field that stores the deadline for the job: that latest it can be completed
    private final int deadline;

    // the duration of the job
    private int duration;

    // the amount of money earned if the job is complete
    private final int profit;

    /**
     * creates an instance of a job and initializes the values of the job
     * @param id the identification of that job
     * @param earliestStart the earliest time this job can start
     * @param deadline by what time the job needs to be done
     * @param duration how long the job will take
     * @param profit how much money will the completion of this job make
     */
    public Job (int id, int earliestStart, int deadline, int duration, int profit){
        this.id = id;
        this.earliestStart = earliestStart;
        this.deadline = deadline;
        this.duration = duration;
        this.profit = profit;
    }

    /**
     * this method sets the duration of a job and can only be used from within the code
     * @param duration the amount of time the job will take
     */
    protected void setDuration(int duration){
        this.duration = duration;
    }

    /**
     * a method that returns the id of that job
     * @return the id of the instance job
     */
    public int getId() {
        return id;
    }

    /**
     * a method to obtain what time is earliest to start this job
     * @return the value int of the earliest start.
     */
    public int getEarliestStart() {
        return earliestStart;
    }

    /**
     * a method to retrieve the deadline of this job
     * @return the hour at which it is the deadline
     */
    public int getDeadline() {
        return deadline;
    }

    /**
     * a method to get how long a job will take
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * to get how much money will be earned if the job is complete
     * @return the profit
     */
    public int getProfit() {
        return profit;
    }

    /**
     * the equals method compares Jobs by comparing their id, if the id is the same then they are equal
     * @param other the object we are comparing the job to
     * @return true if same id, false if different id, false if not a job
     */
    @Override
    public boolean equals(Object other){
        if(this == other)
            return true;
        if( !(other instanceof Job)){
            return false;
        }
        Job other1 = (Job) other;
        return (other1.getId() == this.getId());
    }

    /**
     * a the default compareto method that compares the jobs by
     * @param other the object that the instance calling the method will be compared to
     * @return true if they have the same id, false if different
     */
    @Override
    public int compareTo(Job other) {
            return (this.getId() -  other.getId());
    }

    /**
     * a nested class that compares two objects depending on how early they start
     */
    public static class sortByEarliestStart implements Comparator<Job>{

        /**
         * compare two jobs by how early they start
         * @param job1 the first job to compare
         * @param job2 the second job to compare
         * @return less than 0 if job2 starts earlier, 0 if it's the same time, more than 0 if job2 starts later
         */
        @Override
        public int compare(Job job1, Job job2) {
            return (job1.getEarliestStart() - job2.getEarliestStart() );
        }
    }

    /**
     * a method that returns the comparator that sorts by how early a job starts
     * @return the comparator that compares by how early the job starts
     */
    public static Comparator<Job> getStartComparator(){
        return new sortByEarliestStart();
    }

    /**
     *  a nested class that compares two objects depending on how much money they make
     */

    public static class sortByProfit implements Comparator<Job>{
        /**
         * a comparators to sort the jobs by how much profit they generate
         * @param job1 the first job
         * @param job2 compared to the second jon
         * @return negative if the the profit of job2 is lower, 0 if the same, positive is the profit of job2 is higher
         */
        @Override
        public int compare(Job job1, Job job2){
            return (job2.getProfit() - job1.getProfit());
        }
    }

    /**
     * a method that creates a comparator that compares by how much profit a job earns
     * @return the comparator that sorts by profit earned
     */
    public static Comparator<Job> getProfitComparator(){
        return new sortByProfit();
    }

}
