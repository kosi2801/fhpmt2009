package at.fh_joanneum.swd.pmt.ui.application;



import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

import at.fh_joanneum.swd.pmt.ui.views.SampleView;



public class Perspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout layout) {
		String editorArea = layout.getEditorArea();
		layout.setEditorAreaVisible(false);
		layout.setFixed(true);
		
		layout.addStandaloneView(SampleView.ID,  false, IPageLayout.LEFT, 1.0f, editorArea);
	}

}
