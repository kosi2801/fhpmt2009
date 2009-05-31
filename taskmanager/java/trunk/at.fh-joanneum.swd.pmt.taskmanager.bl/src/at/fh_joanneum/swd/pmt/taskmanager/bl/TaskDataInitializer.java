package at.fh_joanneum.swd.pmt.taskmanager.bl;
import java.util.Calendar;
import java.util.Date;

import at.fh_joanneum.swd.pmt.bl.DataInitializerInterface;
import at.fh_joanneum.swd.pmt.taskmanager.bl.Activator;
import at.fh_joanneum.swd.pmt.taskmanager.data.Task;


public class TaskDataInitializer implements DataInitializerInterface {

	public TaskDataInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		Task task = new Task();
		task.setSubject("BeispielAufgabe");
		task.setDone(false);
		task.setOwner("Max Mustrmann");
		task.setStartDate(new Date());
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		calendar.add(Calendar.DATE, 7);
		task.setEndDate(calendar.getTime());

		if (Activator.getDefault().getStore() != null)
			Activator.getDefault().getStore().addTask(task);

	}

}
