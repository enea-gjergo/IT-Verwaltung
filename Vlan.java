package Backend;

import java.util.ArrayList;
import java.util.List;

public class Vlan extends Switch{
	private Integer id;
	private String hostname;
	private String vlan;
	private String gruppe;
	private String port_typ;
	private List<Switch> s = new ArrayList<Switch>();
	private Ports port;
	
	public int getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getVlanNr() {
		return vlan;
	}
	public void setVlanNr(String vlan) {
		this.vlan = vlan;
	}
	public String getGruppe() {
		return gruppe;
	}
	public void setGruppe(String gruppe) {
		this.gruppe = gruppe;
	}
	public String getPort_typ() {
		return port_typ;
	}
	public void setPort_typ(String port_typ) {
		this.port_typ = port_typ;
	}
}