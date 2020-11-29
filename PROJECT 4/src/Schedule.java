import java.util.*;
/** this class is an ordered linked list of the schedule slots that contain jobs
 * @author <em>Omar Loudghiri</em>
 */
public class Schedule extends LinkedList<ScheduleSlot> {

    /**
     * the constructor of the schedule, will create an empty linked list of schedule slots
     */
    public Schedule(){
        LinkedList<ScheduleSlot> scheduleSlots = new LinkedList<>();
    }

    /**
     * a method that returns whether there is a job scheduled at that time
     * @param time the time at which we are looking for a job
     * @return true if there is no job at that time, or false if there is a job
     */
    public boolean noJobAt(int time){
        if(!this.isEmpty()) {
            for (ScheduleSlot slot : this) {
                return (slot.getStartTime() > time || slot.getEndTime() < time);
            }
        }
        return true;
    }
}
