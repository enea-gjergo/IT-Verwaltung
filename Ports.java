package Backend;

import java.util.ArrayList;
import java.util.List;

public class Ports {
	private Integer port_nr;
	private String eigenschaften;
	private int vlan;
	private int anzahl;
	private Switch sswitch;
	private List<Vlan> lvlan = new ArrayList<Vlan>();
	
	public Integer getPort_nr() {
		return port_nr;
	}
	public void setPort_nr(Integer port_nr) {
		this.port_nr = port_nr;
	}
	public String getEigenschaften() {
		return eigenschaften;
	}
	public void setEigenschaften(String eigenschaften) {
		this.eigenschaften = eigenschaften;
	}
	public int getVlan() {
		return vlan;
	}
	public void setVlan(int vlan) {
		this.vlan = vlan;
	}
	public int getAnzahl() {
		return anzahl;
	}
	public void setAnzahl(int anzahl) {
		this.anzahl = anzahl;
	}
	

}