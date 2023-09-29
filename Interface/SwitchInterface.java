package Interface;

import java.util.List;
import Backend.Switch;


public interface SwitchInterface {
	
	 public void speichern(Switch switches);
	 public void ak(Switch switches);
	 public void lo(Switch switches);
	 public Switch get(String id);
	 public List<Switch> list();

}
