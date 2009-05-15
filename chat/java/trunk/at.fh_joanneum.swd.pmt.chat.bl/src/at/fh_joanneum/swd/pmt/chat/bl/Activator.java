package at.fh_joanneum.swd.pmt.chat.bl;

import org.eclipse.core.runtime.Plugin;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import at.fh_joanneum.swd.pmt.chat.data.IMessageLog;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends Plugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "at.fh_joanneum.swd.pmt.chat.bl";

	// The shared instance
	private static Activator plugin;
	
	private ServiceTracker messagesTracker;
	
	/**
	 * The constructor
	 */
	public Activator() 
	{
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.core.runtime.Plugins#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception 
	{
		super.start(context);
		plugin = this;
		
		this.messagesTracker = new ServiceTracker(context, IMessageLog.class.getName(), null);
		this.messagesTracker.open();
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
