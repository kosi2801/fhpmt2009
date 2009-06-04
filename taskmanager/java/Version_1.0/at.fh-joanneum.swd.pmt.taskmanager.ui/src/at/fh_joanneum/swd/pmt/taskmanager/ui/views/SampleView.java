package at.fh_joanneum.swd.pmt.taskmanager.ui.views;


import java.util.Vector;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;


import at.fh_joanneum.swd.pmt.taskmanager.data.Task;

import at.fh_joanneum.swd.pmt.taskmanager.ui.Activator;



/**
 * This sample class demonstrates how to plug-in a new
 * workbench view. The view shows data obtained from the
 * model. The sample creates a dummy model on the fly,
 * but a real implementation would connect to the model
 * available either in this or another plug-in (e.g. the workspace).
 * The view is connected to the model using a content provider.
 * <p>
 * The view uses a label provider to define how model
 * objects should be presented in the view. Each
 * view can present the same model objects using
 * different labels and icons, if needed. Alternatively,
 * a single label provider can be shared between views
 * in order to ensure that objects of the same type are
 * presented in the same way everywhere.
 * <p>
 */

public class SampleView extends ViewPart {
	private TableViewer viewer;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;

	/*
	 * The content provider class is responsible for
	 * providing objects to the view. It can wrap
	 * existing objects in adapters or simply return
	 * objects as-is. These objects may be sensitive
	 * to the current input of the view, or ignore
	 * it and always show the same content 
	 * (like Task List, for example).
	 */
	 
	class ViewContentProvider implements IStructuredContentProvider {
		public void inputChanged(Viewer v, Object oldInput, Object newInput) {
		}
		public void dispose() {
		}
		public Object[] getElements(Object parent) {
			//return new String[] { "Eins", "Zwei", "Drei" };
			if (Activator.getDefault().getStore() == null) {
				System.out.println("no store loaded!");
				return new String[]{};
			}
		Vector<Task> tasklist = Activator.getDefault().getStore().getAllTasks();
			
	
			if (!tasklist.isEmpty()){
				String[] names = new String[tasklist.size()];
				for(int i=0;i<tasklist.size();i++)
					names[i] = tasklist.get(i).getSubject();
				return names;
			}
			else
				return new String[]{};
		}
	}
	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}
		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}
		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public SampleView() {
	}

	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) {
		
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.verticalSpacing = 8;
		parent.setLayout(gridLayout);
		
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		
		GridData gridDataViewer = new GridData(SWT.FILL, SWT.FILL, true, true);
		gridDataViewer.grabExcessHorizontalSpace = true;
		gridDataViewer.horizontalAlignment = SWT.FILL;
		gridDataViewer.horizontalSpan = 4;
		viewer.getControl().setLayoutData(gridDataViewer);
		
		GridData gridData = new GridData(SWT.FILL, SWT.FILL, true, false);
		gridData.horizontalSpan = 1;		
		gridData.horizontalIndent = 5;
		gridData.verticalIndent = 5;
		gridData.grabExcessHorizontalSpace = true;	
		
		Label lblSubject = new Label(parent, SWT.NONE);
		lblSubject.setLayoutData(gridData);
		lblSubject.setText("Subject:");
		
		Text txtSubject = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtSubject.setLayoutData(gridData);
		txtSubject.setText("");
		
		Label lblOwner = new Label(parent, SWT.NONE);
		lblOwner.setLayoutData(gridData);
		lblOwner.setText("Owner:");
		
		Text txtOwner = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtOwner.setLayoutData(gridData);
		txtOwner.setText("");
		
		Label lblStartDate = new Label(parent, SWT.NONE);
		lblStartDate.setLayoutData(gridData);
		lblStartDate.setText("Startdate:");
		
		DateTime dtStartDate = new DateTime(parent, SWT.DATE | SWT.SHORT);
		dtStartDate.setLayoutData(gridData);
		
		Label lblEndDate = new Label(parent, SWT.NONE);
		lblEndDate.setLayoutData(gridData);
		lblEndDate.setText("Enddate:");
		
		DateTime dtEndDate = new DateTime(parent, SWT.DATE | SWT.SHORT);
		dtEndDate.setLayoutData(gridData);
		
		
		Button btnDone = new Button(parent, SWT.CHECK);
		btnDone.setLayoutData(gridData);
		btnDone.setText("Done");
		
		Label label = new Label(parent, SWT.NONE);
		label.setLayoutData(gridData);
		label.setText("");
		
		
		Button btnSave = new Button(parent, SWT.PUSH);
		btnSave.setLayoutData(gridData);
		btnSave.setText("Save");
		
		Button btnCancel = new Button(parent, SWT.PUSH);
		btnCancel.setLayoutData(gridData);
		btnCancel.setText("Cancel");
		
		
		
		
		
		
		

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "at.fh_joanneum.swd.pmt.taskmanager.ui.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}

	private void hookContextMenu() {
		MenuManager menuMgr = new MenuManager("#PopupMenu");
		menuMgr.setRemoveAllWhenShown(true);
		menuMgr.addMenuListener(new IMenuListener() {
			public void menuAboutToShow(IMenuManager manager) {
				SampleView.this.fillContextMenu(manager);
			}
		});
		Menu menu = menuMgr.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewer);
	}

	private void contributeToActionBars() {
		IActionBars bars = getViewSite().getActionBars();
		fillLocalPullDown(bars.getMenuManager());
		fillLocalToolBar(bars.getToolBarManager());
	}

	private void fillLocalPullDown(IMenuManager manager) {
		manager.add(action1);
		manager.add(new Separator());
		manager.add(action2);
	}

	private void fillContextMenu(IMenuManager manager) {
		manager.add(action1);
		manager.add(action2);
		// Other plug-ins can contribute there actions here
		manager.add(new Separator(IWorkbenchActionConstants.MB_ADDITIONS));
	}
	
	private void fillLocalToolBar(IToolBarManager manager) {
		manager.add(action1);
		manager.add(action2);
	}

	private void makeActions() {
		action1 = new Action() {
			public void run() {
				showMessage("Action 1 executed");
			}
		};
		action1.setText("Action 1");
		action1.setToolTipText("Action 1 tooltip");
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
			getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		
		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages().
				getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		viewer.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewer.getControl().getShell(),
			"Sample View",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}