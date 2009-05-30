package at.fh_joanneum.swd.pmt.mmm.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public interface IMultimediaDataStore {

		List<Multimedia> getMultimedias();
		
		void setMultimedias(ArrayList<Multimedia> multimedias);
		
		void addMultimedia(Multimedia multimedia);
		
		Multimedia getMultimediaTitelTyp(String titel, MultimediaTyp mt);

		void setMultimedias(List<Multimedia> multimedias);
	
}
