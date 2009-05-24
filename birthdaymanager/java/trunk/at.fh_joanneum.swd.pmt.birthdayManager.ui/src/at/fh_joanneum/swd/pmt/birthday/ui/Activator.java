package at.fh_joanneum.swd.pmt.birthday.ui;

import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import at.fh_joanneum.swd.pmt.birthday.data.IUserDataStore;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

	// The plug-in ID
	public static final String PLUGIN_ID = "at.fh-joanneum.swd.pmt.birthdaymanager.ui";

	// The shared instance
	private static Activator plugin;
	private ServiceTracker dataTracker;
	
	/**
	 * The constructor
	 */
	public Activator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		this.dataTracker = new ServiceTracker(context, at.fh_joanneum.swd.pmt.birthday.data.IUserDataStore.class.getName(), null);
		this.dataTracker.open();	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * @return the shared instance
	 */
	public static Activator getDefault() {
		return plugin;
	}

	/**
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor for the image file at the given
	 */
	public static ImageDescriptor getImageDescriptor(String path) 
	{
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}

	public IUserDataStore getStore()
	{
		return (IUserDataStore)this.dataTracker.getService();
	}
}
