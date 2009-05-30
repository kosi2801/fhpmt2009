package at.fh_joanneum.swd.pmt.mmm.data;

public class MultimediaDataStore implements IMultimediaDataStore{
	
	private Multimedia multimedia;
	
	@Override
	public Multimedia getMultimedia() {
		return multimedia;
	}

	@Override
	public void setMultimedia(Multimedia multimedia) {
		this.multimedia = multimedia;	
	}

}
