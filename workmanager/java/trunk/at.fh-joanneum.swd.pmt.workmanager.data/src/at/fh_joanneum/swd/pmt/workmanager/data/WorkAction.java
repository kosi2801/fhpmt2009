package at.fh_joanneum.swd.pmt.workmanager.data;

public class WorkAction {
   private String action;
   
   private int duration;

   public WorkAction(String action) {
	   this.action = action;
   }
   public String getAction() {
	return action;
}

public void setAction(String action) {
	this.action = action;
}

public int getDuration() {
	return duration;
}

public void setDuration(int duration) {
	this.duration = duration;
}

public String toString() {
	return action;
}
}
