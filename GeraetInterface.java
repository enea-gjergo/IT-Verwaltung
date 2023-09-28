package Interface;

//Importieren der Bibliotheken
import java.util.List;

import Backend.Geraete;

public interface GeraetInterface {// Erstellen der "abstrakten" Methoden, die in Implementierung Klassen verwendet werden
	
	 public void speichern(Geraete geraete);
	 public void aktualisieren(Geraete geraete);
	 public void loeschen(Geraete geraete);
	 public Geraete get(int id);
	 public List<Geraete> list();
}
