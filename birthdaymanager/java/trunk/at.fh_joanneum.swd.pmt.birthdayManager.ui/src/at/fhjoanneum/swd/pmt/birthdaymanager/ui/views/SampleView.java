package at.fhjoanneum.swd.pmt.birthdaymanager.ui.views;

import java.util.Date;
import java.util.Vector;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;

import at.fh_joanneum.swd.pmt.birthday.data.User;
import at.fh_joanneum.swd.pmt.birthday.ui.Activator;

/**
 * This sample class demonstrates how to plug-in a new workbench view. The view
 * shows data obtained from the model. The sample creates a dummy model on the
 * fly, but a real implementation would connect to the model available either in
 * this or another plug-in (e.g. the workspace). The view is connected to the
 * model using a content provider.
 * <p>
 * The view uses a label provider to define how model objects should be
 * presented in the view. Each view can present the same model objects using
 * different labels and icons, if needed. Alternatively, a single label provider
 * can be shared between views in order to ensure that objects of the same type
 * are presented in the same way everywhere.
 * <p>
 */

public class SampleView extends ViewPart
{
	private Text firstName;
	private Text lastName;
	private Text birthday;
	
	private TableViewer viewer;
	private Action doubleClickAction;

	/*
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
	 */
	class ViewContentProvider implements IStructuredContentProvider
	{
		public void inputChanged(Viewer v, Object oldInput, Object newInput)
		{
		}

		public void dispose()
		{
		}

		public Object[] getElements(Object parent)
		{
			if (Activator.getDefault().getStore() == null) 
			{
				System.out.println("no store loaded!");
				return new String[]{};
			}
			Vector<User> users = Activator.getDefault().getStore().getAllUser();
			
			if (users != null)
			{
				String[] fullnames = new String[users.size()];
				for(int i=0; i<users.size(); i++)
					fullnames[i] = users.get(i).getFirstName() + " " + users.get(i).getLastName();
				return fullnames;
			}
			else
				return new String[]{};
		}
	}

	class ViewLabelProvider extends LabelProvider implements ITableLabelProvider
	{
		public String getColumnText(Object obj, int index)
		{
			return getText(obj);
		}

		public Image getColumnImage(Object obj, int index)
		{
			return getImage(obj);
		}

		public Image getImage(Object obj)
		{
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	class NameSorter extends ViewerSorter
	{
	}

	/**
	 * The constructor.
	 */
	public SampleView()
	{
	}

	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent)
	{
		GridLayout gridLayout = new GridLayout(4, false);
		gridLayout.verticalSpacing = 8;
		parent.setLayout(gridLayout);

		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());


		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.horizontalSpan = 4;		
		viewer.getControl().setLayoutData(gd);
		
		Label firstName = new Label(parent, SWT.LEFT);
		firstName.setText("Firstname:");
		this.firstName = new Text(parent,SWT.SINGLE | SWT.BORDER);

		Label lastName = new Label(parent, SWT.LEFT);
		lastName.setText("Lastname:");
		this.lastName = new Text(parent,SWT.SINGLE | SWT.BORDER);

		Label birthday = new Label(parent, SWT.LEFT);
		birthday.setText("Birthday:");
		this.birthday = new Text(parent,SWT.SINGLE | SWT.BORDER);

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
				"at.fh-joanneum.swd.pmt.birthdaymanager.ui.viewer");
		makeActions();
		hookDoubleClickAction();
	}

	private void makeActions() {
		doubleClickAction = new Action()
		{
			public void run()
			{
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				String tmpLastName = (obj.toString().split(" "))[1];
				
				User tmpUser = Activator.getDefault().getStore().getUserByLastName(tmpLastName);
				firstName.setText(tmpUser.getFirstName());
				lastName.setText(tmpUser.getLastName());
				birthday.setText(tmpUser.getBirthday());
			}
		};
	}

	private void hookDoubleClickAction()
	{
		viewer.addDoubleClickListener(new IDoubleClickListener()
		{
			public void doubleClick(DoubleClickEvent event)
			{
				doubleClickAction.run();
			}
		});
	}

	private void showMessage(String message)
	{
		MessageDialog.openInformation(viewer.getControl().getShell(), "Sample View", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus()
	{
		viewer.getControl().setFocus();
	}
}