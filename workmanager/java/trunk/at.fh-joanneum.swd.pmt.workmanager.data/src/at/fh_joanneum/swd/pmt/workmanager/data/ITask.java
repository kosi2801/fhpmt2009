package at.fh_joanneum.swd.pmt.workmanager.data;

import java.util.Date;

public interface ITask {

	String getTaskName();

	void setTaskName(String taskName);

	String getTaskDescription();
	
	void setTaskDescription(String taskDescription);

	Date getTaskDate();

	void setTaskDate(Date taskDate);
}
