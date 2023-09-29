package Interface;

import java.util.List;


import Backend.Netzwerkkarte;

public interface NetzwerkkarteInterface {

	 public void speichern(Netzwerkkarte netz);
	 public void aktualisieren(Netzwerkkarte netz);
	 public void loeschen(Netzwerkkarte netz);
	 public Netzwerkkarte get(String id);
	 public List<Netzwerkkarte> list();
}
