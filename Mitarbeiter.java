package Backend;
import java.util.ArrayList;
import java.util.List;

import Backend.Arbeitszeiterfassung;

public class Mitarbeiter extends Geraete{
	 
	//protected String mitarbeiter;
	private int ansprechpartner;
	private String nachname;
	private String vorname;
	private String abteilung;
	private int telefon;
	private String mail;
	private String abteilungsleitung;
	private int inventar;	
	private List<Arbeitszeiterfassung> dauer = new ArrayList<Arbeitszeiterfassung>();
	private List<Geraete> geraet = new ArrayList<Geraete>();
	
	
	
public int getInventar() {
	return inventar;
}
public void setInventar(int inventar) {
	this.inventar = inventar;
}

public int getAnsprechpartner() {
	return ansprechpartner;
}
public void setAnsprechpartner(int ansprechpartner) {
	this.ansprechpartner = ansprechpartner;
}
public String getNachname() {
	return nachname;
}
public void setNachname(String nachname) {
	this.nachname = nachname;
}
public String getVorname() {
	return vorname;
}
public void setVorname(String vorname) {
	this.vorname = vorname;
}
public String getAbteilung() {
	return abteilung;
}
public void setAbteilung(String abteilung) {
	this.abteilung = abteilung;
}
public int getTelefon() {
	return telefon;
}
public void setTelefon(int telefon) {
	this.telefon = telefon;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public String getAbteilungsleitung() {
	return abteilungsleitung;
}
public void setAbteilungsleitung(String abteilungsleitung) {
	this.abteilungsleitung = abteilungsleitung;
}

public List<Arbeitszeiterfassung> getWartungsArbeit() {
	return dauer;
}
public void setWartungsArbeit(List<Arbeitszeiterfassung> dauer) {
	this.dauer = dauer;
}
	
}
