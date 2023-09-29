package Interface;

import java.util.List;

import Backend.Vlan;

public interface VlanInterface {

	 public void speichern(Vlan v);
	 public void ak(Vlan v);
	 public void lo(Vlan v);
	 public Vlan  get(int id);
	 public List<Vlan> list();
}
