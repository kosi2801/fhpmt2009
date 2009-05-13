package at.fh_joanneum.swd.pmt.bl;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.ISafeRunnable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.SafeRunner;


public class DataInitializerTask {

	private static final String EXTENSIONPOINT_ID = "at.fh_joanneum.swd.pmt.datainitializer";
	
	public void run() {
		try {
			IConfigurationElement[] config = Platform.getExtensionRegistry()
					.getConfigurationElementsFor(EXTENSIONPOINT_ID);
			for (IConfigurationElement e : config) {
				final Object o = e.createExecutableExtension("class");
				if (o instanceof DataInitializerInterface) {
					ISafeRunnable runnable = new ISafeRunnable() {
						@Override
						public void handleException(Throwable exception) {
							System.out.println("Exception in client");
						}

						@Override
						public void run() throws Exception {
							((DataInitializerInterface) o).initialize();
						}
					};
					SafeRunner.run(runnable);
				}
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}
}
