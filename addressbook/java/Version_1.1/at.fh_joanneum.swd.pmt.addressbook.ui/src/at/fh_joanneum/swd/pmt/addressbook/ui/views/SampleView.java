package at.fh_joanneum.swd.pmt.addressbook.ui.views;


import java.util.Vector;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.SWT;

import at.fh_joanneum.swd.pmt.addressbook.bl.AddressManipulator;
import at.fh_joanneum.swd.pmt.addressbook.data.Address;
import at.fh_joanneum.swd.pmt.bl.DataInitializerTask;
import at.fh_joanneum.swd.pmt.mmm.data.Multimedia;
import at.fh_joanneum.swd.pmt.mmm.data.MultimediaTyp;
import at.fh_joanneum.swd.pmt.addressbook.ui.Activator;


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
	private Action doubleClickAction;
	private Text tName;
	private Text tStreet;
	private Text tZip;
	private Text tCity;
	private Text tCountry;
	private Text tEmail;
	private Text tPhone;
	private Text tMobile;

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
			// Check if the Dataservice is registered
			if (Activator.getDefault().getStore() == null) {
				System.out.println("no store loaded!");
				return new String[]{};
			}
			Vector<Address> addr = Activator.getDefault().getStore().getAllAddresses();
			
			// Read all existing Addresses if present
			if (addr != null){
				String[] names = new String[addr.size()];
				for(int i=0;i<addr.size();i++)
					names[i] = addr.get(i).getName();
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
		GridLayout gridLayout = new GridLayout(4, false);
		gridLayout.verticalSpacing = 8;
		parent.setLayout(gridLayout);
		
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());		
		
		GridData gd = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		gd.horizontalSpan = 4;
		viewer.getControl().setLayoutData(gd);
		
		GridData gd2 = new GridData(SWT.FILL, SWT.FILL, true, false);
		gd2.horizontalSpan = 1;		
		gd2.horizontalIndent = 5;
		gd2.verticalIndent = 5;
		gd2.grabExcessHorizontalSpace = true;		
		
		
		Label name = new Label(parent, SWT.NULL);
		name.setText("Name:");
		name.setLayoutData(gd2);
		
		this.tName = new Text(parent,SWT.SINGLE | SWT.BORDER );		
		this.tName.setLayoutData(gd2);
		
		Label street = new Label(parent,SWT.LEFT);
		street.setText("Street:");
		street.setLayoutData(gd2);
		this.tStreet = new Text(parent,SWT.SINGLE | SWT.BORDER);
		this.tStreet.setLayoutData(gd2);
		
		Label zip = new Label(parent,SWT.LEFT);
		zip.setText("ZIP-Code:");
		zip.setLayoutData(gd2);
		this.tZip = new Text(parent,SWT.SINGLE | SWT.BORDER);
		this.tZip.setLayoutData(gd2);
		
		Label city = new Label(parent,SWT.LEFT);
		city.setText("City:");
		city.setLayoutData(gd2);
		this.tCity = new Text(parent,SWT.SINGLE | SWT.BORDER);
		this.tCity.setLayoutData(gd2);
		
		Label country = new Label(parent,SWT.LEFT);
		country.setText("Country:");
		country.setLayoutData(gd2);
		this.tCountry = new Text(parent,SWT.SINGLE | SWT.BORDER);
		this.tCountry.setLayoutData(gd2);		
		
		Label email = new Label(parent, SWT.LEFT);
		email.setText("E-Mail Address:");
		email.setLayoutData(gd2);
		this.tEmail = new Text(parent,SWT.SINGLE | SWT.BORDER);
		this.tEmail.setLayoutData(gd2);
		
		Label phone = new Label(parent, SWT.LEFT);
		phone.setText("Phone:");
		phone.setLayoutData(gd2);
		this.tPhone = new Text(parent, SWT.SINGLE | SWT.BORDER);
		this.tPhone.setLayoutData(gd2);
		
		Label mobile = new Label(parent, SWT.LEFT);
		mobile.setText("Mobile:");
		mobile.setLayoutData(gd2);
		this.tMobile = new Text(parent, SWT.SINGLE | SWT.BORDER);
		this.tMobile.setLayoutData(gd2);
		
		Button add = new Button(parent,SWT.PUSH );
		add.setText("Add");		
		add.setLayoutData(gd2);
		add.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				
				if( tName.getText().isEmpty()){
					showMessage("Provide at least a Name");
					return;
				};
				
				Address tmp = new Address();
				tmp.setName(tName.getText());
				tmp.setStreet(tStreet.getText());
				tmp.setZip(tZip.getText());
				tmp.setCity(tCity.getText());
				tmp.setCountry(tCountry.getText());
				tmp.setEmail(tEmail.getText());
				tmp.setPhone(tPhone.getText());
				tmp.setMobile(tMobile.getText());
				
				if(!Activator.getDefault().getStore().addAddress(tmp))
					showMessage("Failed to save this entry!");
				else{
					new AddressManipulator().fillEmptyFields(tmp.getName());
					viewer.add(tmp.getName());
					viewer.refresh();
				};
			}
		});
		
		Button bClear = new Button(parent,SWT.PUSH);
		bClear.setText("Clear");
		bClear.setLayoutData(gd2);
		bClear.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				clearControlls();
				viewer.refresh();
			}
		});
		
		Button bDelete = new Button(parent,SWT.PUSH);
		bDelete.setText("Delete");
		bDelete.setLayoutData(gd2);
		bDelete.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				if(!Activator.getDefault().getStore().removeAddress(tName.getText())){
					showMessage("Unable to delete this entry!");
					return;
				}
				clearControlls();
				viewer.refresh();
			}
		});
		
		Button bUpdate = new Button(parent, SWT.PUSH);
		bUpdate.setText("Update");
		bUpdate.setLayoutData(gd2);
		bUpdate.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				if(tName.getText().isEmpty()){
					showMessage("The attribute Name must not be empty!");
					return;
				};
				ISelection selection = viewer.getSelection();
				Object name = ((IStructuredSelection)selection).getFirstElement();
				
				Address tmp = new Address();
				tmp.setName(tName.getText());
				tmp.setStreet(tStreet.getText());
				tmp.setZip(tZip.getText());
				tmp.setCity(tCity.getText());
				tmp.setCountry(tCountry.getText());
				tmp.setEmail(tEmail.getText());
				tmp.setPhone(tPhone.getText());
				tmp.setMobile(tMobile.getText());
				
				if(!Activator.getDefault().getStore().setAddress((String)name, tmp))
					showMessage("Unable to update current entry!");
				else{									
					new AddressManipulator().fillEmptyFields(tmp.getName());
					viewer.refresh();
				}
			}
		});
		
		Button bDefault = new Button(parent, SWT.PUSH);
		bDefault.setText("Load Default");
		bDefault.setLayoutData(gd2);
		bDefault.addSelectionListener(new SelectionAdapter(){
				public void widgetSelected(SelectionEvent e){
				new DataInitializerTask().run();
				viewer.refresh();
			}
		});
		
		Button bAddPicture = new Button (parent, SWT.PUSH);
		bAddPicture.setText("Add Image");
		bAddPicture.setLayoutData(gd2);
		bAddPicture.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(), "Add", "Add Image", null, null);
			        if (dlg.open() == Window.OK)
			        	Activator.getDefault().getMMStore().setMultimedia(new Multimedia(dlg.getValue(), MultimediaTyp.IMAGE));			        
			}
		});
		
		Button bShwPicture = new Button(parent,SWT.PUSH);
		bShwPicture.setText("Modify Image");
		bShwPicture.setLayoutData(gd2);
		bShwPicture.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				boolean end = false;
				if(Activator.getDefault().getMMStore().getMultimedia() == null ){
					end = true;					
				}else{
					if(Activator.getDefault().getMMStore().getMultimedia().getTyp() != MultimediaTyp.IMAGE )
						end = true;
				}
				if( end ){
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", "No picture defined");
					return;
				};
				
				InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
						"Show", "Show Image", 
						Activator.getDefault().getMMStore().getMultimedia().getTitel(), null);
				if(dlg.open() == Window.OK)
					Activator.getDefault().getMMStore().getMultimedia().setTitel(dlg.getValue());
			}
		});
		
		Button bDelPicture = new Button(parent, SWT.PUSH);
		bDelPicture.setText("Delete Image");
		bDelPicture.setLayoutData(gd2);
		bDelPicture.addSelectionListener(new SelectionAdapter(){
			public void widgetSelected(SelectionEvent e){
				boolean end = false;
				if(Activator.getDefault().getMMStore().getMultimedia() == null ){
					end = true;		
				}else{
					if(Activator.getDefault().getMMStore().getMultimedia().getTyp() != MultimediaTyp.IMAGE )
						end = true;		
				}
				if(end){
					MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error", "No picture defined");
					return;
				}
				if(MessageDialog.openConfirm(Display.getCurrent().getActiveShell(), "Delete?", "Do you really want to delete the picture"))
					Activator.getDefault().getMMStore().setMultimedia(null);
			}
		});
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "at.fh_joanneum.swd.pmt.adressbook.ui.viewer");
		makeActions();
		hookDoubleClickAction();
	}

	private void clearControlls(){
		this.tName.setText("");
		this.tStreet.setText("");
		this.tZip.setText("");
		this.tCity.setText("");
		this.tCountry.setText("");
		this.tEmail.setText("");
		this.tPhone.setText("");
		this.tMobile.setText("");
		
	}
	
	private void makeActions() {
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				
				Address tmp = Activator.getDefault().getStore().getAddressByName(obj.toString());
				
			    tName.setText(tmp.getName());
			    tStreet.setText(tmp.getStreet());
			    tZip.setText(tmp.getZip());
			    tCity.setText(tmp.getCity());
			    tCountry.setText(tmp.getCountry());
			    tEmail.setText(tmp.getEmail());
			    tPhone.setText(tmp.getPhone());
			    tMobile.setText(tmp.getMobile());
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
			"AddressBook View",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}