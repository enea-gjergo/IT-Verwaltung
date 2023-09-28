package Backend;

import java.util.ArrayList;
import java.util.List;

public class Switch extends Geraete {

	private int F_Inventar_Nr;
	private String P_Hostname;
	private String Kategorie;
	private int Anzahl_Ports;
	private boolean PoE_Faehig;
	private String Management_IP;
	private int vlan;
	private List<Vlan> vlan_list = new ArrayList<Vlan>(); 
	private List<Ports> ports = new ArrayList<Ports>(); 
	
	public int getF_Inventar_Nr() {
		return F_Inventar_Nr;
	}
	public void setF_Inventar_Nr(int f_Inventar_Nr) {
		F_Inventar_Nr = f_Inventar_Nr;
	}
	public String getP_Hostname() {
		return P_Hostname;
	}
	public void setP_Hostname(String p_Hostname) {
		P_Hostname = p_Hostname;
	}
	public String getKategorie() {
		return Kategorie;
	}
	public void setKategorie(String kategorie) {
		Kategorie = kategorie;
	}
	public int getAnzahl_Ports() {
		return Anzahl_Ports;
	}
	public void setAnzahl_Ports(int anzahl_Ports) {
		Anzahl_Ports = anzahl_Ports;
	}
	public boolean isPoE_Faehig() {
		return PoE_Faehig;
	}
	public void setPoE_Faehig(boolean poE_Faehig) {
		PoE_Faehig = poE_Faehig;
	}
	public String getManagement_IP() {
		return Management_IP;
	}
	public void setManagement_IP(String management_IP) {
		Management_IP = management_IP;
	}
	public int getVlan() {
		return vlan;
	}
	public void setVlan(int vlan) {
		this.vlan = vlan;
	}
	
}