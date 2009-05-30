package at.fh_joanneum.swd.pmt.mmm.ui.views;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Image;
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
	private TableViewer viewImages, viewVideos, viewAudios;
	private TabFolder tabFolder;
	private Action action1;
	private Action action2;
	private Action doubleClickAction;
	private MultimediaTyp active = MultimediaTyp.IMAGE;
	private String[] auswahl;
	
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
			
			if (Activator.getDefault().getStore() == null) {
				System.out.println("no store loaded (Sample View)!");
				return new String[]{};
			}
			
			List<Multimedia> multimedias = Activator.getDefault().getStore().getMultimedias();
			List<String> teil = new ArrayList<String>(); 
			
			for(int i=0; i<multimedias.size(); i++)
				if (multimedias.get(i).getTyp() == active) teil.add(multimedias.get(i).getTitel());
			auswahl = new String[teil.size()];;
			Iterator<String> itr = teil.iterator();
			for (int i = 0; i < teil.size(); i++) auswahl[i] = itr.next(); 
			
			return auswahl;
			
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
			if (active == MultimediaTyp.IMAGE)	return new Image(Display.getCurrent(), SampleView.class.getResourceAsStream("../../../../../../../icons/camera.png"));
			if (active == MultimediaTyp.VIDEO)	return new Image(Display.getCurrent(), SampleView.class.getResourceAsStream("../../../../../../../icons/film.png"));
			if (active == MultimediaTyp.AUDIO)	return new Image(Display.getCurrent(), SampleView.class.getResourceAsStream("../../../../../../../icons/music.png"));
			return PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_OBJ_ELEMENT);
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
		itemImage.setControl (getTabControl(tabFolder, MultimediaTyp.IMAGE));
		TabItem itemVideo = new TabItem (tabFolder, SWT.NONE);
		itemVideo.setText ("Videos");
		Button buttonVideo = new Button (tabFolder, SWT.PUSH);
		buttonVideo.setText ("Page Videos");
		itemVideo.setControl (getTabControl(tabFolder, MultimediaTyp.VIDEO));
		TabItem itemAudio = new TabItem (tabFolder, SWT.NONE);
		itemAudio.setText ("Audios");
		Button buttonAudio = new Button (tabFolder, SWT.PUSH);
		buttonAudio.setText ("Page Audios");
		itemAudio.setControl (getTabControl(tabFolder, MultimediaTyp.AUDIO));
		tabFolder.addSelectionListener(new SelectionListener() {
		      public void widgetSelected(SelectionEvent e) {
		    	  	if (tabFolder.getSelectionIndex() == 0) active = MultimediaTyp.IMAGE;
					if (tabFolder.getSelectionIndex() == 1) active = MultimediaTyp.VIDEO;
					if (tabFolder.getSelectionIndex() == 2) active = MultimediaTyp.AUDIO;
		      }
		      
			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				widgetSelected(e);
			}
		});
		
		
		// Create the help context id for the viewer's control
		//PlatformUI.getWorkbench().getHelpSystem().setHelp(viewer.getControl(), "at.joanneum.fh.swd.ptm.mmm.ui.viewer");
		makeActions();
		hookContextMenu();
		hookDoubleClickAction();
		contributeToActionBars();
		
	}

	
	/**
	   * Gets the control for tab one
	   * 
	   * @param tabFolder the parent tab folder
	   * @return Control
	   */
	  private Control getTabControl(TabFolder tabFolder, MultimediaTyp mt) {
	    // Create a composite and add four buttons to it
		this.active = mt;
	    Composite composite = new Composite(tabFolder, SWT.NONE);
	    composite.setLayout(new GridLayout());
	    TableViewer viewer = null;
	    if (active == MultimediaTyp.IMAGE) {
	    	viewImages = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
	    	viewer = viewImages;
	    }
	    if (active == MultimediaTyp.VIDEO) {
	    	viewVideos = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
	    	viewer = viewVideos;
	    }
	    if (active == MultimediaTyp.AUDIO) {
	    	viewAudios = new TableViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
	    	viewer = viewAudios;
	    }
		viewer.setContentProvider(new ViewContentProvider());
	    viewer.setLabelProvider(new ViewLabelProvider());
		viewer.setSorter(new NameSorter());
		viewer.setInput(getViewSite());
		GridData gd = new GridData();
		gd.grabExcessHorizontalSpace = true;
		gd.horizontalAlignment = SWT.FILL;
		viewer.getControl().setLayoutData(gd);
		Button button1 = new Button(composite, SWT.PUSH);
		button1.setText("Load default images");
		button1.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
//				new DataInitializerTask().run();
				//viewer.refresh();
			}
			
		});

		Button button2 = new Button(composite, SWT.PUSH);
		button2.setText("Edit ...");
		button2.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				TableViewer viewer = null;
				if (active == MultimediaTyp.IMAGE) viewer = viewImages;
				if (active == MultimediaTyp.VIDEO) viewer =	viewVideos;
				if (active == MultimediaTyp.AUDIO) viewer =	viewAudios;
				
				ISelection selection = viewer.getSelection();
				Object obj = ((IStructuredSelection) selection).getFirstElement();
				Multimedia image = Activator.getDefault().getStore().getMultimediaTitelTyp(obj.toString(), active);
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
		
		Button button3 = new Button(composite, SWT.PUSH);
		button3.setText("New ...");
		button3.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				TableViewer viewer = null;
				if (active == MultimediaTyp.IMAGE) viewer = viewImages;
				if (active == MultimediaTyp.VIDEO) viewer =	viewVideos;
				if (active == MultimediaTyp.AUDIO) viewer =	viewAudios;
				
				InputDialog dlg = new InputDialog(Display.getCurrent().getActiveShell(),
			            "", "New title", null, null);
			        if (dlg.open() == Window.OK) {
			          // User clicked OK; update the label with the input
			        	Multimedia mlt = new Multimedia(dlg.getValue(), active);
			        	Activator.getDefault().getStore().addMultimedia(mlt);
			        	viewer.refresh();
			        }
				}
			
		});
	    
		active = MultimediaTyp.IMAGE;
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
		Menu menu = menuMgr.createContextMenu(viewImages.getControl());
		viewImages.getControl().setMenu(menu);
		getSite().registerContextMenu(menuMgr, viewImages);
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
				ISelection selection = viewImages.getSelection();
				Object obj = ((IStructuredSelection)selection).getFirstElement();
				showMessage("Double-click detected on "+obj.toString());
			}
		};
	}

	private void hookDoubleClickAction() {
		viewImages.addDoubleClickListener(new IDoubleClickListener() {
			public void doubleClick(DoubleClickEvent event) {
				doubleClickAction.run();
			}
		});
	}
	private void showMessage(String message) {
		MessageDialog.openInformation(
			viewImages.getControl().getShell(),
			"Multimedia View",
			message);
	}

	/**
	 * Passing the focus request to the viewer's control.
	 */
	public void setFocus() {
		viewImages.getControl().setFocus();
	}
}