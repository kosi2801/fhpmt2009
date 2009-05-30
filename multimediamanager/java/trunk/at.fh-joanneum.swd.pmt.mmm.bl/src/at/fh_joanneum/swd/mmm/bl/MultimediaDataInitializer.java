package at.fh_joanneum.swd.mmm.bl;

import at.fh_joanneum.swd.pmt.bl.DataInitializerInterface;
import at.fh_joanneum.swd.pmt.mmm.data.Multimedia;
import at.fh_joanneum.swd.pmt.mmm.data.MultimediaTyp;

public class MultimediaDataInitializer implements DataInitializerInterface {

	public MultimediaDataInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		Multimedia multimedia = new Multimedia();
		multimedia.setTitel("DataInitializer Test");
		multimedia.setTyp(MultimediaTyp.IMAGE);
		if (Activator.getDefault().getStore() != null)
			Activator.getDefault().getStore().addMultimedia(multimedia);
		
	}

}
