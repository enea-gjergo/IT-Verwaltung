package Backend;

public class Netzwerkkarte extends Geraete {

	private String mac;
	private int f_inventar;
	private String uebertragungsrate;
	private String ip;
	private String netzmaske;
	private String dns;
	private Geraete geraet;
	
	
	public String getMac() {
		return mac;
	}
	public void setMac(String mac) {
		this.mac = mac;
	}
	public int getF_inventar() {
		return f_inventar;
	}
	public void setF_inventar(int f_inventar) {
		this.f_inventar = f_inventar;
	}
	public String getUebertragungsrate() {
		return uebertragungsrate;
	}
	public void setUebertragungsrate(String uebertragungsrate) {
		this.uebertragungsrate = uebertragungsrate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getNetzmaske() {
		return netzmaske;
	}
	public void setNetzmaske(String netzmaske) {
		this.netzmaske = netzmaske;
	}
	public String getDns() {
		return dns;
	}
	public void setDns(String dns) {
		this.dns = dns;
	}

}
