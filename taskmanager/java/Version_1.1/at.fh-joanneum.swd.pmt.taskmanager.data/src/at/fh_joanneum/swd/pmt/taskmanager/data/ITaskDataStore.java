package at.fh_joanneum.swd.pmt.taskmanager.data;

import java.util.Vector;

public interface ITaskDataStore {

	Task getTaskBySubject(String subject);
	boolean addTask(Task task);
	boolean delTask(String subject);
	Vector<Task> getAllTasks();
}
