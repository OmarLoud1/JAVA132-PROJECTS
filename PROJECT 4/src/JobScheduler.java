import java.io.*;
import java.util.*;

/** this interface contains the method to schedule a job
 * @author <em> Omar Loudghiri </em>
 */
public class JobScheduler {

    /**
     *this class creates a schedule that contains all jobs input while sorting them according to a comparator
     * @param list the list of jobs that will be inserted into the schedule
     * @param comp the comparator that will provide the sor method with the way to sort
     * @param scheduler the way the jobs will be scheduled
     * @return the ordered schedule
     */
    public Schedule scheduleJobs(LinkedList<Job> list , Comparator<Job> comp, ScheduleMetric scheduler){
        Schedule schedule = new Schedule();
        list.sort(comp);
        for(Job job : list){
            scheduler.scheduleJob(schedule,job);
        }
        return schedule;
    }

    /**
     * the main method which takes a file input
     * @param args the input of the function, it should be a txt file that contains many jobs
     * @throws FileNotFoundException if no file is
     */
    public static void main(String[] args) throws FileNotFoundException {
        int profitLate = 0;  // field to store the profit of the ALAP schedule
        int profitEarly = 0; // field to store the profit of the ASAP schedule
        // throwing an exception if there is no file input
        try {
            Scanner scanner = new Scanner(new FileInputStream(args[0]));
        }
        catch (FileNotFoundException e){
            System.out.println("please input a correct file.");
        }
        // open the input file
        Scanner scanner = new Scanner(new FileInputStream(args[0]));
        // create a new list of jobs from the file, with each line representing one job
        LinkedList <Job> list = new LinkedList<>();
        while (scanner.hasNextLine()) {
            Job job = new Job(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
            list.add(job);
        }

        // creates a schedule that sorts all jobs from the list above by order of profit and as late as possible
        JobScheduler scheduler = new JobScheduler();
        Schedule lateSchedule = scheduler.scheduleJobs(list, Job.getProfitComparator(), new ScheduleAsLateAsPossible());

        // prints the result of that schedule and implement its profit, gives a final profit result
        for(ScheduleSlot slot : lateSchedule){
           profitLate = profitLate + slot.getJob().getProfit();
           System.out.println(slot.getJob().getId() + " " + slot.getStartTime() + " " + slot.getEndTime() + " " + slot.getJob().getProfit() + "\n");
        }
        System.out.println("The profit of the schedule 'Late' is = " + profitLate + "\n");

        // create a schedule with the jobs scheduled as early as possible and prints th result
        Schedule earlySchedule = scheduler.scheduleJobs(list, Job.getProfitComparator(), new ScheduleAsEarlyAsPossible());
        for(ScheduleSlot slot : earlySchedule){
            profitEarly = profitEarly + slot.getJob().getProfit();
            System.out.println(slot.getJob().getId() + " " + slot.getStartTime() + " " + slot.getEndTime() + " " + slot.getJob().getProfit() + "\n");
        }

        System.out.println("The profit of the schedule 'Early' is = " + profitEarly + "\n");

        // compares the profit of the two above schedule and returns which one has more profit
        if(profitEarly > profitLate)
            System.out.println("The Early schedule has a higher profit than the late schedule");
        else if(profitEarly < profitLate)
            System.out.println("The Late schedule has a higher profit than the early schedule");
    }

    /**
     * Creates a file with random job data, based on the parameters given.  The job data will be
     * sorted by earliest start time.
     * @param numJobs   the number of jobs to create
     * @param maxStart  the latest time at which a job may set as its earliest start time
     * @param maxDuration  the maximum time that a job can take to complete
     * @param maxLag   the greatest time between the earliest start time for a job and the latest time that a job must start to meet its deadline
     * @param maxProfit  the maximum amount of profit from a job
     * @return an array containing the random jobs
     */
    public Job[] createRandomJobs(int numJobs, int maxStart, int maxDuration, int maxLag, int maxProfit) {
        Job[] jobs = new Job[numJobs];

        // For each desired job, create 4 random numbers based on the parameters, use the numbers to create a job,
        // and store the job in an array.
        for (int i = 0; i < numJobs; i++) {
            int start = (int)(Math.random() * maxStart) + 1;
            int duration = (int)(Math.random() * maxDuration) + 1;
            int deadline = start + duration + (int)(Math.random() * (maxLag + 1));
            int profit = (int)(Math.random() * maxProfit) + 1;
            jobs[i] = new Job(i, start, deadline, duration, profit);
        }

        // Sort the jobs by earliest start time
        Arrays.sort(jobs, Job.getStartComparator());

        return jobs;
    }

    /**
     * Creates a file with job data.
     * @param fileName  the name of the file to store the job data.  The file must not exist.
     * @param jobs an array containing the jobs
     */
    public void createJobFile(String fileName, Job[] jobs) {
        // Check that the output file does not already exist
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println("Error: file " + fileName + " already exists.");
            return;
        }

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            // For each job in the array, write the job to the file as 5 numbers separated by spaces.
            // Place an each job on a new line.
            for (int i = 0; i < jobs.length; i++) {
                String s = i + " " + jobs[i].getEarliestStart() + " " + jobs[i].getDeadline() + " " + jobs[i].getDuration() + " " + jobs[i].getProfit();
                writer.write(s, 0, s.length());
                writer.newLine();
            }
            writer.flush();
            writer.close();
        }
        catch (IOException e) {
            System.out.println("Error writing to file " + fileName);
        }
    }
}