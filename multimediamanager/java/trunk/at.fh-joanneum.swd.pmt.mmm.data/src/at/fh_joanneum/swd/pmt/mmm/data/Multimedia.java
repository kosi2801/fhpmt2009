package at.fh_joanneum.swd.pmt.mmm.data;

public class Multimedia {
	
	String titel;
	MultimediaTyp typ;

	public Multimedia(String titel, MultimediaTyp typ) {
		super();
		this.titel = titel;
		this.typ = typ;
	}

	public Multimedia() {
		super();
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String title) {
		titel = title;
	}

	public MultimediaTyp getTyp() {
		return typ;
	}

	public void setTyp(MultimediaTyp typ) {
		this.typ = typ;
	}
	
	
}
