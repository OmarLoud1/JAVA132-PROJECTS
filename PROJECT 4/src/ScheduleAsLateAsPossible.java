/**this class will schedule a job as late as possible in the schedule
 * @author <em>Omar Loudghiri</em>
 */
public class ScheduleAsLateAsPossible implements ScheduleMetric {
    /**
     * this method schedules a job as late as possible in the schedule it operates on
     * @param s the schedule in which the job is supposed to be added
     * @param job the job to add in the schedule
     * @return true if the job was scheduled and false if it wasn't.
     */
    @Override
    public boolean scheduleJob(Schedule s, Job job) {
        if (!(job instanceof CompoundJob)) {
            int lateDurationCount = 0;
            int j;
            // iterates through the schedule until it finds enough consecutive slots for the duration of the job
            for (j = job.getDeadline(); j > job.getEarliestStart() && lateDurationCount < job.getDuration(); j--) {
                if (s.noJobAt(j))
                    lateDurationCount++;
                else
                    lateDurationCount = 0;
            }
            // if enough slots were found then the slot is created and added to the schedule
            if (lateDurationCount == job.getDuration()) {
                ScheduleSlot lateJob = new ScheduleSlot(job, j);
                s.add(lateJob);
                return true;
            }
            return false;
        }
        // if the job to schedule is a compound job then we check that all the jobs can schedule the same way as above
        //only returns true if all of them can be scheduled
        else {
            Job [] subjobs = ((CompoundJob) job).getSubJobs();
            int subJobCount = 0;
            int LateDurationCount = 0;
            for(Job sub : subjobs){
                for (int x = sub.getEarliestStart(); x < sub.getDeadline() - sub.getDuration() && LateDurationCount < job.getDuration(); x++) {
                    if (s.noJobAt(x))
                        LateDurationCount++;
                    else
                        LateDurationCount = 0;
                }
                if(LateDurationCount == sub.getDuration()){
                    subJobCount = subJobCount + 1;
                }
            }
            int i;
            for (i = job.getEarliestStart(); i < job.getDeadline() - job.getDuration() && LateDurationCount < job.getDuration(); i++) {
                if (s.noJobAt(i))
                    LateDurationCount++;
                else
                    LateDurationCount = 0;
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
