package at.fh_joanneum.swd.pmt.taskmanager.data;

import java.util.Vector;

public class TaskDataStore implements ITaskDataStore{
	private Vector<Task> tasklist;

	public TaskDataStore() {
		this.tasklist = new Vector<Task>();
	}
	
	@Override
	public boolean addTask(Task task) {
		if(findTask(task) == -1)
			return this.tasklist.add(task);
		else
			return false;
	}

	@Override
	public boolean delTask(String subject) {
		Task tmp = new Task();
		tmp.setSubject(subject);
		int idx = findTask(tmp);
		if( idx>=0) {
			this.tasklist.removeElementAt(idx);
			return true;
		}
		else
			return false;
	}

	@Override
	public Vector<Task> getAllTasks() {
		return this.tasklist;
	}

	@Override
	public Task getTaskBySubject(String subject) {
		Task tmp = new Task();
		tmp.setSubject(subject);
		int idx = findTask(tmp);
		if( idx>=0)
			return this.tasklist.elementAt(idx);
		else
			return null;
	}
	
	private int findTask(Task task) {
		for(int i=0; i<this.tasklist.size();i++){
			if(this.tasklist.elementAt(i).getSubject().equalsIgnoreCase(task.getSubject()))
				return i;
		}
		return -1;
	}

}
