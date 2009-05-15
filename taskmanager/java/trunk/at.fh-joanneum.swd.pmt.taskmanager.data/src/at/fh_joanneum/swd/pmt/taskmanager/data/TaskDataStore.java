package at.fh_joanneum.swd.pmt.taskmanager.data;

public class TaskDataStore implements ITaskDataStore{
	private Task task;
	
	public Task getTask(){
		return task;
	}
	
	public void setTask(Task task) {
		this.task = task;
	}

}
