package at.fh_joanneum.swd.pmt.mmm.data;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class MultimediaDataStore implements IMultimediaDataStore{
	
	private List<Multimedia> multimedias;
	
	public MultimediaDataStore(){
		this.multimedias = new ArrayList<Multimedia>();
		this.multimedias.add(new Multimedia("Ferien am Strand", MultimediaTyp.IMAGE));
		this.multimedias.add(new Multimedia("Ferien unter karibic Sonne", MultimediaTyp.IMAGE));
		this.multimedias.add(new Multimedia("Vogelzwischern", MultimediaTyp.AUDIO));
		this.multimedias.add(new Multimedia("Jubeln", MultimediaTyp.AUDIO));
		this.multimedias.add(new Multimedia("Sonne, Mond und Sterne", MultimediaTyp.VIDEO));
		this.multimedias.add(new Multimedia("Pinguine der Antarktis", MultimediaTyp.VIDEO));
	}
	
	@Override
	public List<Multimedia> getMultimedias() {
		return multimedias;
	}
	
	public List<Multimedia> getMultimedias(MultimediaTyp mt) {
		List<Multimedia> teil = new ArrayList<Multimedia>();
		Iterator<Multimedia> itr = multimedias.iterator();
		Multimedia m;
		while(itr.hasNext()){
			m = (Multimedia)itr.next();
			if (m.getTyp() == mt)
				teil.add((Multimedia)itr.next());
		}
		return teil;
	}

	@Override
	public void addMultimedia(Multimedia multimedia) {
		this.multimedias.add(multimedia);	
	}

	@Override
	public Multimedia getMultimediaTitelTyp(String titel, MultimediaTyp mt) {
		Iterator<Multimedia> itr = multimedias.iterator();
		Multimedia m;
		while(itr.hasNext()){
			m = (Multimedia)itr.next();
			if ((m.getTyp() == mt)&&(m.getTitel().equals(titel))){
				System.out.println("gefunden");
				return m;
			}
		}
		return null;
	}

	@Override
	public void setMultimedias(ArrayList<Multimedia> multimedias) {
		this.multimedias = multimedias;
		
	}

	@Override
	public void setMultimedias(List<Multimedia> multimedias) {
		this.multimedias = multimedias;	
	}


}
