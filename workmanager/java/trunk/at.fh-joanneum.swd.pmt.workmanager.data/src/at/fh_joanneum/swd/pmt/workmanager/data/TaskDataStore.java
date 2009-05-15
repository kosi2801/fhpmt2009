package at.fh_joanneum.swd.pmt.workmanager.data;

import java.util.Date;

public class TaskDataStore implements ITask{
	
	protected Task task;
	
	public String getTaskName() {
		return task.taskName;
	}

	public void setTaskName(String taskName) {
		task.taskName = taskName;
	}

	public String getTaskDescription() {
		return task.taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		task.taskDescription = taskDescription;
	}

	public Date getTaskDate() {
		return task.taskDate;
	}

	public void setTaskDate(Date taskDate) {
		task.taskDate = taskDate;
	}
}
