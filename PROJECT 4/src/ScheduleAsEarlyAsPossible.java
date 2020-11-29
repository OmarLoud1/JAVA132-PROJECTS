/**this class will schedule a job as early as possible in the schedule
 * @author <em>Omar Loudghiri</em>
 */
public class ScheduleAsEarlyAsPossible implements ScheduleMetric {

    /**
     * a method that schedules a job as early as possible into a schedule
     * @param s the schedule we want the job to be integrated in
     * @param job the job we want to schedule
     * @return true if the job was added, false if the job was not added.
     */
    @Override
    public boolean scheduleJob(Schedule s, Job job) {
        //if it is a normal job
        if (!(job instanceof CompoundJob)) {
            int i;                          // the index at which the job will end
            int earlyDurationCount = 0;     // a field to keep track that we have enough empty slots for the job
            //iterates through the schedule from the earliest start of the job until its deadline, stops if there are
            // enough empty hours for the job to be scheduled.
            for (i = job.getEarliestStart(); i < job.getDeadline() - job.getDuration() && earlyDurationCount < job.getDuration(); i++) {
                if (s.noJobAt(i))
                    earlyDurationCount++;
                else
                    earlyDurationCount = 0;
            }
            if (earlyDurationCount == job.getDuration()) {
                ScheduleSlot earlyJob = new ScheduleSlot(job, i - job.getDuration());
                s.add(earlyJob);
                return true;
            }
            return false;
        }
        // if the job to schedule is a compound job then we check that all the jobs can schedule the same way as above
        //only returns true if all of them can be scheduled
        else {
            Job [] subjobs = ((CompoundJob) job).getSubJobs();
            int subJobCount = 0;
            int earlyDurationCount = 0;
            for(Job sub : subjobs){
                for (int x = sub.getEarliestStart(); x < sub.getDeadline() - sub.getDuration() && earlyDurationCount < job.getDuration(); x++) {
                    if (s.noJobAt(x))
                        earlyDurationCount++;
                    else
                        earlyDurationCount = 0;
                }
                if(earlyDurationCount == sub.getDuration()){
                    subJobCount = subJobCount + 1;
                }
            }
            int i;
            for (i = job.getEarliestStart(); i < job.getDeadline() - job.getDuration() && earlyDurationCount < job.getDuration(); i++) {
                if (s.noJobAt(i))
                    earlyDurationCount++;
                else
                    earlyDurationCount = 0;
            }

            if(subJobCount == subjobs.length){
                ScheduleSlot earlyJob = new ScheduleSlot(job,i);
                s.add(earlyJob);
                return true;
            }
        }
        return false;
    }
}
