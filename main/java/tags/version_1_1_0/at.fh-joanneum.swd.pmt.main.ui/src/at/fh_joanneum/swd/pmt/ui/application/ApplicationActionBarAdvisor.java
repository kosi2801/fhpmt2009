package at.fh_joanneum.swd.pmt.ui.application;

import org.eclipse.jface.action.GroupMarker;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.
	private IWorkbenchAction exitAction;
	
    // XXX we want to show all update preferences
	private IWorkbenchAction aboutAction;
    private IWorkbenchAction preferencesAction;


	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	protected void makeActions(final IWorkbenchWindow window) {
		// Creates the actions and registers them.
		// Registering is needed to ensure that key bindings work.
		// The corresponding commands keybindings are defined in the plugin.xml
		// file.
		// Registering also provides automatic disposal of the actions when
		// the window is closed.

		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);
		
		//XXX preferences action
        aboutAction = ActionFactory.ABOUT.create(window);
        register(aboutAction);
        preferencesAction = ActionFactory.PREFERENCES.create(window);
        register(preferencesAction);
        


	}

	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager fileMenu = new MenuManager("&File",
				IWorkbenchActionConstants.M_FILE);

		menuBar.add(fileMenu);
		fileMenu.add(exitAction);

//		MenuManager windowMenu = new MenuManager("&Window", IWorkbenchActionConstants.M_WINDOW);
//		MenuManager helpMenu = new MenuManager("&Help", IWorkbenchActionConstants.M_HELP);
//		// XXX Window menu
//		menuBar.add(windowMenu);
//		// Add a group marker indicating where action set menus will appear.
//		menuBar.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
//		menuBar.add(helpMenu);
//		
//		
//		// XXX Window menu
//		windowMenu.add(preferencesAction);
//		
//		// Help
//		// XXX add an additions group because this is what SDK UI expects
//		helpMenu.add(new GroupMarker(IWorkbenchActionConstants.MB_ADDITIONS));
//		helpMenu.add(new Separator());
//		helpMenu.add(aboutAction);
	}

}
