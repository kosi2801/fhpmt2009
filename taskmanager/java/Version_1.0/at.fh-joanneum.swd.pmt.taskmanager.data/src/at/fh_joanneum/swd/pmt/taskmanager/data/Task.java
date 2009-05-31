package at.fh_joanneum.swd.pmt.taskmanager.data;

import java.util.Date;

public class Task {
	
	private String Subject;
	private Boolean Done;
	private String Owner;
	private Date StartDate;
	private Date EndDate;
	
	public String getSubject() {
		return Subject;
	}
	public void setSubject(String subject) {
		Subject = subject;
	}
	public Boolean getDone() {
		return Done;
	}
	public void setDone(Boolean done) {
		Done = done;
	}
	public String getOwner() {
		return Owner;
	}
	public void setOwner(String owner) {
		Owner = owner;
	}
	public Date getStartDate() {
		return StartDate;
	}
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	public Date getEndDate() {
		return EndDate;
	}
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
	

}
