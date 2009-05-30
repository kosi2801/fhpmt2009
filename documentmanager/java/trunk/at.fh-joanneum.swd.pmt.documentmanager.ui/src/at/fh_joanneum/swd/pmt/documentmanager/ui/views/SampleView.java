package at.fh_joanneum.swd.pmt.documentmanager.ui.views;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredContentProvider;
import org.eclipse.jface.viewers.IStructuredSelection;
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
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.ViewPart;

import at.fh_joanneum.swd.pmt.documentmanager.data.Document;
import at.fh_joanneum.swd.pmt.documentmanager.ui.Activator;

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

public class SampleView extends ViewPart {
	private TableViewer viewer;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;

	private Text tDocIdentifier;
	private Text tDocOwner;
	private Text tDocPath;

	/*
	 * The content provider class is responsible for providing objects to the
	 * view. It can wrap existing objects in adapters or simply return objects
	 * as-is. These objects may be sensitive to the current input of the view,
	 * or ignore it and always show the same content (like Task List, for
	 * example).
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
				return new String[] {};
			}
			Collection<Document> docs = Activator.getDefault().getStore()
					.getAllDocuments();

			// Read all existing Addresses if present
			List<String> identifiers = new ArrayList<String>(docs.size());
			for (Document doc : docs) {
				identifiers.add(doc.getIdentifier());
			}

			return identifiers.toArray();
		}
	}

	class ViewLabelProvider extends LabelProvider implements
			ITableLabelProvider {
		public String getColumnText(Object obj, int index) {
			return getText(obj);
		}

		public Image getColumnImage(Object obj, int index) {
			return getImage(obj);
		}

		public Image getImage(Object obj) {
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJ_ELEMENT);
		}
	}

	class NameSorter extends ViewerSorter {
	}

	/**
	 * The constructor.
	 */
	public SampleView() {
	}

	private void clearControls(){
		this.tDocIdentifier.setText("");
		this.tDocOwner.setText("");
		this.tDocPath.setText("");
	}
	
	/**
	 * This is a callback that will allow us to create the viewer and initialize
	 * it.
	 */
	public void createPartControl(Composite parent) {
		GridLayout gridLayout = new GridLayout(2, false);
		gridLayout.verticalSpacing = 8;
		parent.setLayout(gridLayout);
		
		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL);
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
		gd2.horizontalIndent = 1;
		gd2.verticalIndent = 1;

		Label identifier = new Label(parent, SWT.NULL);
		identifier.setText("Identifier:");
		identifier.setLayoutData(gd2);
		this.tDocIdentifier = new Text(parent, SWT.SINGLE | SWT.BORDER);
		this.tDocIdentifier.setLayoutData(gd2);

		Label owner = new Label(parent, SWT.LEFT);
		owner.setText("Owner:");
		owner.setLayoutData(gd2);
		this.tDocOwner = new Text(parent, SWT.SINGLE | SWT.BORDER);
		this.tDocOwner.setLayoutData(gd2);

		Label uri = new Label(parent, SWT.LEFT);
		uri.setText("URI:");
		uri.setLayoutData(gd2);
		this.tDocPath = new Text(parent, SWT.SINGLE | SWT.BORDER);
		this.tDocPath.setLayoutData(gd2);

		Button add = new Button(parent,SWT.PUSH );
		add.setText("Add");		
		add.setLayoutData(gd2);
		add.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				
				if( tDocIdentifier.getText().isEmpty()){
					showMessage("Provide at least an identifier");
					return;
				};
				
				Document tmp = new Document();
				tmp.setIdentifier(tDocIdentifier.getText());
				tmp.setOwner(tDocOwner.getText());
				tmp.setPath(tDocPath.getText());
				
				if(!Activator.getDefault().getStore().addDocument(tmp))
					showMessage("Failed to save this entry!");
				else{					
					viewer.add(tmp.getIdentifier());
					viewer.refresh();
					clearControls();
				};
			}
		});
		
		Button bDelete = new Button(parent,SWT.PUSH);
		bDelete.setText("Delete");
		bDelete.setLayoutData(gd2);
		bDelete.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				Document doc = Activator.getDefault().getStore().getDocumentByIdentifier(tDocIdentifier.getText());
				if(Activator.getDefault().getStore().removeDocument(doc) == null){
					showMessage("Unable to delete this entry!");
					return;
				}
				clearControls();
				viewer.refresh();
			}
		});
		
		Button bUpdate = new Button(parent, SWT.PUSH);
		bUpdate.setText("Update");
		bUpdate.setLayoutData(gd2);
		bUpdate.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				if(tDocIdentifier.getText().isEmpty()){
					showMessage("The attribute Identifier must not be empty!");
					return;
				};
				ISelection selection = viewer.getSelection();
				Object name = ((IStructuredSelection)selection).getFirstElement();
				
				Document tmp = new Document();
				tmp.setIdentifier(tDocIdentifier.getText());
				tmp.setOwner(tDocOwner.getText());
				tmp.setPath(tDocPath.getText());
				
				if(!Activator.getDefault().getStore().updateDocument(tmp))
					showMessage("Unable to update current entry!");
				else{									
					viewer.refresh();
				}
			}
		});

		Button bClear = new Button(parent,SWT.PUSH);
		bClear.setText("Clear");
		bClear.setLayoutData(gd2);
		bClear.addSelectionListener(new SelectionAdapter(){
			@Override
			public void widgetSelected(SelectionEvent e){
				clearControls();
				viewer.refresh();
			}
		});
		
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(),
				"at.fh_joanneum.swd.pmt.documentmanager.ui.viewer");
		makeActions();
		// hookContextMenu();
		hookDoubleClickAction();
		// contributeToActionBars();
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
		action1.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));

		action2 = new Action() {
			public void run() {
				showMessage("Action 2 executed");
			}
		};
		action2.setText("Action 2");
		action2.setToolTipText("Action 2 tooltip");
		action2.setImageDescriptor(PlatformUI.getWorkbench().getSharedImages()
				.getImageDescriptor(ISharedImages.IMG_OBJS_INFO_TSK));
		doubleClickAction = new Action() {
			public void run() {
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				
				Document tmp = Activator.getDefault().getStore().getDocumentByIdentifier(obj.toString());
				
				tDocIdentifier.setText(tmp.getIdentifier());
				tDocOwner.setText(tmp.getOwner());
				tDocPath.setText(tmp.getPath());
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
		MessageDialog.openInformation(viewer.getControl().getShell(),
				"Sample View", message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}