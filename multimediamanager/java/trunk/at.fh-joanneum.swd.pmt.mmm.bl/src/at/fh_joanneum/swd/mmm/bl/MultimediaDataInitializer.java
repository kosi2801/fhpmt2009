package at.fh_joanneum.swd.mmm.bl;

import at.fh_joanneum.swd.pmt.bl.DataInitializerInterface;
import at.fh_joanneum.swd.mmm.bl.Activator;
import at.fh_joanneum.swd.pmt.mmm.data.Multimedia;
import at.fh_joanneum.swd.pmt.mmm.data.MultimediaTyp;

public class MultimediaDataInitializer implements DataInitializerInterface {

	public MultimediaDataInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize() {
		Multimedia multimedia = new Multimedia();
		multimedia.setTitel("Ferien am Strand");
		multimedia.setTyp(MultimediaTyp.AUDIO);
		System.out.println("MultimediaIniliazer");
//		UserDataStore.getInstance().setUser(user);
		if (Activator.getDefault().getStore() != null)
			Activator.getDefault().getStore().setMultimedia(multimedia);
		
	}

}
