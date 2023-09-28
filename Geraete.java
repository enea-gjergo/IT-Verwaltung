package Backend;

// Importieren der benötige Bibliotheken

import java.util.ArrayList;
import java.util.List;

public class Geraete {

//	Erstellen der Attributen
	private int inventar_nr;
	private String kaufdatum;
	private String seriennummer;
	private boolean	funktional;
	private String kommentar;
	private int kaufpreis_n;
	private  String garantieablauf;
	private String f_switch_hostname;
	private  int f_geraetetyp_nr;
	private String f_gebaeude_nr;
	private String f_raum_nr;
	private String f_p_mac;
	private int ansprechpartner;
	private List<Mitarbeiter> mitarbeiter = new ArrayList<Mitarbeiter>(); // Viel zu Viele Beziehung
	private List<Netzwerkkarte> netzwerkkarte = new ArrayList<Netzwerkkarte>(); // Eins zu Viele Beziehung
	private Raume raum;	//Eins zu Viele Beziehung

//Erstellen der Getter und Setter Methoden
public String getF_p_mac() {
		return f_p_mac;
	}
	public void setF_p_mac(String f_p_mac) {
		this.f_p_mac = f_p_mac;
	}
public int getInventar_nr() {
		
			return inventar_nr;
	}
	public void set_Inventar_nr(Integer inventar_nr) {
		this.inventar_nr = inventar_nr;
	}
	public String getKaufdatum() {
		return kaufdatum;
	}
	public void setKaufdatum(String kaufdatum) {
		this.kaufdatum = kaufdatum;
	}
	public String getSeriennummer() {
		return seriennummer;
	}
	public void setSeriennummer(String seriennummer) {
		this.seriennummer = seriennummer;
	}
	public boolean isFunktional() {
		return funktional;
	}
	public void setFunktional(boolean funktional) {
		this.funktional = funktional;
	}
	public String getKommentar() {
		return kommentar;
	}
	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}
	public int getKaufpreis_n() {
		return kaufpreis_n;
	}
	public void setKaufpreis_n(int kaufpreis_n) {
		this.kaufpreis_n = kaufpreis_n;
	}
	public String getGarantieablauf() {
		return garantieablauf;
	}
	public void setGarantieablauf(String garantieablauf) {
		this.garantieablauf = garantieablauf;
	}
	public String getF_switch_hostname() {
		return f_switch_hostname;
	}
	public void setF_switch_hostname(String f_switch_hostname) {
		this.f_switch_hostname = f_switch_hostname;
	}
	public int getF_geraetetyp_nr() {
		return f_geraetetyp_nr;
	}
	public void setF_geraetetyp_nr(int f_geraetetyp_nr) {
		this.f_geraetetyp_nr = f_geraetetyp_nr;
	}
	public String getF_gebaeude_nr() {
		return f_gebaeude_nr;
	}
	public void setF_gebaeude_nr(String f_gebaeude_nr) {
		this.f_gebaeude_nr = f_gebaeude_nr;
	}
	public String getF_raum_nr() {
		return f_raum_nr;
	}
	public void setF_raum_nr(String f_raum_nr) {
		this.f_raum_nr = f_raum_nr;
	}
	public int getF_Ansprechpartner() {
		return ansprechpartner;
	}
	public void setF_Ansprechpartner(int ansprechpartner) {
		this.ansprechpartner = ansprechpartner;
	}
}