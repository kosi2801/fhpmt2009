package at.fh_joanneum.swd.pmt.taskmanager.data;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;



/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "at.fh_joanneum.swd.pmt.taskmanager.data";

	// The shared instance
	private static Activator plugin;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		ITaskDataStore store = new TaskDataStore();
		context.registerService(ITaskDataStore.class.getName(), store, null);
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

}