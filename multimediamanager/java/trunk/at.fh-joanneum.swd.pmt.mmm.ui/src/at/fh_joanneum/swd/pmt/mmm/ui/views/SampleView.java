package at.fh_joanneum.swd.pmt.mmm.ui.views;


import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.ui.part.*;
import org.eclipse.jface.viewers.*;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.jface.action.*;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.*;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;

import at.fh_joanneum.swd.pmt.mmm.ui.Activator;
import at.fh_joanneum.swd.pmt.mmm.data.Multimedia;
//import at.fh_joanneum.swd.pmt.bl.DataInitializerTask;
import at.fh_joanneum.swd.pmt.mmm.data.MultimediaTyp;


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
	private TabFolder tabFolder;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;
	public static final String ID = "at.fh_joanneum.swd.pmt.mmm.ui.views.SampleView";
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
			//return new String[] { "One1", "Two2", "Three2" };
//			return new TestData().getData();
			//User user = UserDataStore.getInstance().getUser();
			Multimedia multimedia = new Multimedia();
			multimedia.setTitel("Ferien am Strand");
			multimedia.setTyp(MultimediaTyp.AUDIO);
			System.out.println("MultimediaIniliazer");
//			UserDataStore.getInstance().setUser(user);
			if (Activator.getDefault().getStore() != null)
				Activator.getDefault().getStore().setMultimedia(multimedia);
			
			if (Activator.getDefault().getStore() == null) {
				System.out.println("no store loaded (Sample View)!");
				return new String[]{};
			}
			//Multimedia multimedia = Activator.getDefault().getStore().getMultimedia();
			if (multimedia != null)
				return new String[] {multimedia.getTitel()};
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
		tabFolder = new TabFolder (parent, SWT.BORDER);
		TabItem itemImage = new TabItem (tabFolder, SWT.NONE);
		itemImage.setText ("Images");
		Button buttonImage = new Button (tabFolder, SWT.PUSH);
		buttonImage.setText ("Page Images");
		itemImage.setControl (getTabImageControl(tabFolder));
		TabItem itemVideo = new TabItem (tabFolder, SWT.NONE);
		itemVideo.setText ("Videos");
		Button buttonVideo = new Button (tabFolder, SWT.PUSH);
		buttonVideo.setText ("Page Videos");
		itemVideo.setControl (getTabVideoControl(tabFolder));
		TabItem itemAudio = new TabItem (tabFolder, SWT.NONE);
		itemAudio.setText ("Audios");
		Button buttonAudio = new Button (tabFolder, SWT.PUSH);
		buttonAudio.setText ("Page Audios");
		itemAudio.setControl (getTabAudioControl(tabFolder));
		
		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "at.joanneum.fh.swd.ptm.mmm.ui.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		
	}
		

/*		viewer = new TableViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
		viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());

		// Create the help context id for the viewer's control
		PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "at.fh_joanneum.swd.pmt.mmm.ui.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
	}*/
	
	/**
	   * Gets the control for tab one
	   * 
	   * @param tabFolder the parent tab folder
	   * @return Control
	   */
	  private Control getTabImageControl(TabFolder tabFolder) {
	    // Create a composite and add four buttons to it
	    Composite composite = new Composite(tabFolder, SWT.NONE);
	    composite.setLayout(new GridLayout());
	    viewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		viewer.setContentProvider(new ViewContentProvider());
	    viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		viewer.getControl().setLayoutData(gd);
		Button button = new Button(composite, SWT.PUSH);
		button.setText("Load default images");
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
//				new DataInitializerTask().run();
				viewer.refresh();
			}
			
		});

		button = new Button(composite, SWT.PUSH);
		button.setText("Edit Image");
		button.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				Multimedia image = Activator.getDefault().getStore().getMultimedia();
				if (image != null) {
					  InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
					            "", "Change Titel", image.getTitel(), null);
					        if (dlg.open() == Window.OK) {
					          // User clicked OK; update the label with the input
					        	image.setTitel(dlg.getValue());
					          viewer.refresh();
					        }
				}
			}
			
		});
	    
	    return composite;
	  }
	  
	  private Control getTabVideoControl(TabFolder tabFolder) {
		    // Create a composite and add four buttons to it
		    Composite composite = new Composite(tabFolder, SWT.NONE);
		    composite.setLayout(new GridLayout());
		    viewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
			viewer.setContentProvider(new ViewContentProvider());
			viewer.setLabelProvider(new ViewLabelProvider());
			viewer.setSorter(new NameSorter());
			viewer.setInput(getViewSite());
			GridData gd = new GridData();
			gd.grabExcessHorizontalSpace = true;
			gd.horizontalAlignment = SWT.FILL;
			viewer.getControl().setLayoutData(gd);
			
			Button button = new Button(composite, SWT.PUSH);
			button.setText("Load default videos");
			button.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
//					new DataInitializerTask().run();
					viewer.refresh();
				}
				
			});

			button = new Button(composite, SWT.PUSH);
			button.setText("Edit Video");
			button.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					Multimedia image = Activator.getDefault().getStore().getMultimedia();
					if (image != null) {
						  InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
						            "", "Change Titel", image.getTitel(), null);
						        if (dlg.open() == Window.OK) {
						          // User clicked OK; update the label with the input
						        	image.setTitel(dlg.getValue());
						          viewer.refresh();
						        }
					}
				}
				
			});
		    
		    return composite;
		  }
	  
	  private Control getTabAudioControl(TabFolder tabFolder) {
		    // Create a composite and add four buttons to it
		    Composite composite = new Composite(tabFolder, SWT.NONE);
		    composite.setLayout(new GridLayout());
		    viewer = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
			viewer.setContentProvider(new ViewContentProvider());
			viewer.setLabelProvider(new ViewLabelProvider());
			viewer.setSorter(new NameSorter());
			viewer.setInput(getViewSite());
			viewer.setInput("test");
			GridData gd = new GridData();
			gd.grabExcessHorizontalSpace = true;
			gd.horizontalAlignment = SWT.FILL;
			viewer.getControl().setLayoutData(gd);
			
			Button button = new Button(composite, SWT.PUSH);
			button.setText("Load default audios");
			button.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					//new DataInitializerTask().run();
					viewer.refresh();
				}
				
			});

			button = new Button(composite, SWT.PUSH);
			button.setText("Edit Audio");
			button.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent e) {
					Multimedia image = Activator.getDefault().getStore().getMultimedia();
					if (image != null) {
						  InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
						            "", "Change Titel", image.getTitel(), null);
						        if (dlg.open() == Window.OK) {
						          // User clicked OK; update the label with the input
						        	image.setTitel(dlg.getValue());
						          viewer.refresh();
						        }
					}
				}
				
			});
		    
		    return composite;
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
			"Multimedia View",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewer.getControl().setFocus();
	}
}