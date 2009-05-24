package at.fh_joanneum.swd.pmt.chat.ui.views;

import java.util.Vector;

import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerSorter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import at.fh_joanneum.swd.pmt.chat.data.IMessageLog;
import at.fh_joanneum.swd.pmt.chat.data.Message;
import at.fh_joanneum.swd.pmt.chat.ui.Activator;

public class ChatUI extends ViewPart 
{
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
			if (Activator.getDefault() == null ||
					Activator.getDefault().getMessageLog() == null) 
			{
				return new String[]{ "No messages found" };
			}
			
			IMessageLog log = Activator.getDefault().getMessageLog();
			Message[] messages = log.getAllMessages();
			
			Vector<String> translated = new Vector<String>();
			for(Message m : messages)
				translated.add(m.getUserName() + ": " + m.getMessage());

			return translated.toArray();
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
			return PlatformUI.getWorkbench().
					getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
		}
	}
	class NameSorter extends ViewerSorter 
	{
	}

	/**
	 * The constructor.
	 */
	public ChatUI() 
	{
	}

	TableViewer viewer;
	Text messageText;
	
	/**
	 * This is a callback that will allow us
	 * to create the viewer and initialize it.
	 */
	public void createPartControl(Composite parent) 
	{
		GridLayout gridLayout = new GridLayout(4, false);
		gridLayout.verticalSpacing = 8;
		parent.setLayout(gridLayout);
		
		Label messageLabel = new Label(parent, SWT.NULL);
		messageLabel.setText("Message: ");
	    messageText = new Text(parent, SWT.SINGLE | SWT.BORDER);

	    GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
	    gridData.horizontalSpan = 3;
	    messageText.setLayoutData(gridData);

		Button buttonDefault = new Button(parent, SWT.PUSH);
		buttonDefault.setText("Fill with default");

		Button buttonAdd = new Button(parent, SWT.PUSH);
		buttonAdd.setText("Add chat message");
		buttonAdd.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				Message message = new Message();
				message.setMessage(messageText.getText());
				Activator.getDefault().getMessageLog().AddMessage(message);
				viewer.refresh();
			}
		});

		Button buttonRefresh = new Button(parent, SWT.PUSH);
		buttonRefresh.setText("Refresh log");
		buttonRefresh.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				viewer.refresh();
			}
		});

		Button buttonClear = new Button(parent, SWT.PUSH);
		buttonClear.setText("Clear log");
		buttonClear.addSelectionListener(new SelectionAdapter() 
		{
			@Override
			public void widgetSelected(SelectionEvent e) 
			{
				Activator.getDefault().getMessageLog().ClearLog();
				viewer.refresh();
			}
		});

		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.grabExcessVerticalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.verticalAlignment = SWT.FILL;
	    gd.horizontalSpan = 4;
	    
		viewer.getControl().setLayoutData(gd);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() 
	{
		viewer.getControl().setFocus();
	}
}