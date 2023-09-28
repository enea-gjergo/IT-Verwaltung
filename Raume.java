package Backend;

import java.util.ArrayList;
import java.util.List;

public class Raume {

	private int raum_nr;
	private String verwendungszweck;
	private List<Geraete> Geraete = new ArrayList<Geraete>(); // Eins zu Viele Beziehung
	public int getRaum_nr() {
		return raum_nr;
	}
	public void setRaum_nr(int raum_nr) {
		this.raum_nr = raum_nr;
	}
	public String getVerwendungszweck() {
		return verwendungszweck;
	}
	public void setVerwendungszweck(String verwendungszweck) {
		this.verwendungszweck = verwendungszweck;
	}
	

}