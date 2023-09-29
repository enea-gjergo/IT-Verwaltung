package Interface;

import java.util.List;

import Backend.Mitarbeiter;

public interface MitarbeiterInterface {
	
	 public void speichern(Mitarbeiter m);
	 public void ak(Mitarbeiter m);
	 public void lo(Mitarbeiter m);
	 public Mitarbeiter get(int id);
	 public List<Mitarbeiter> list();

}
