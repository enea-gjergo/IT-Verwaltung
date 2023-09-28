package Interface;

import Backend.Switch;
import Datenbank.Datenbank2;
import Interface.SwitchInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SwitchImp implements SwitchInterface{
	
	@Override
	public void speichern(Switch switches) {
			 try {
		            Connection con =  Datenbank2.getConnection();
		         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
		        String sql = "INSERT INTO t_switches(F_Inventar_Nr,P_Hostname,Kategorie,Anzahl_Ports,PoE_Faehig,Management_IP,F_P_Vlan) VALUES(?,?,?,?,?,?,?)";
		            
	            PreparedStatement ps = con.prepareStatement(sql);
		            
	            ps.setInt(1, switches.getInventar_nr()); // !! Kujdes!! Eshte vene metoda e Geräte
	            ps.setString(2, switches.getP_Hostname());
	            ps.setString(3, switches.getKategorie());
	            ps.setInt(4, switches.getAnzahl_Ports());
	            ps.setBoolean(5, switches.isPoE_Faehig());
	            ps.setString(6, switches.getManagement_IP());
	            ps.setInt(7, switches.getVlan());   //!! Kujdes ndoshta duhet ndryshuar dhe duhet vene metoda e Vlan nga klasa Vlan
	          //  ps.setInt(7,switches.getF_Inventar_Nr());
	            
	           
	            ps.executeUpdate();
		         
		            JOptionPane.showMessageDialog(null, "Gespeichert!");
		        } catch (Exception e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
		        }
			
			
		}

	@Override
	public void ak(Switch switches) {
		
		
		 try {
	            Connection con =  Datenbank2.getConnection();
	         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
	            String sql = "UPDATE t_switches SET F_Inventar_Nr=?,Kategorie=?,Anzahl_Ports=?,PoE_Faehig=?,Management_IP=?,F_P_Vlan=? WHERE P_Hostname=?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	            
	            ps.setInt(1, switches.getInventar_nr());
	          //  ps.setInt(1, switches.getInventar_nr());
	         //   ps.setString(2, switches.getP_Hostname());
	            ps.setString(2, switches.getKategorie());
	            ps.setInt(3, switches.getAnzahl_Ports());
	            ps.setBoolean(4, switches.isPoE_Faehig());
	            ps.setString(5, switches.getManagement_IP());
	            ps.setInt(6, switches.getVlan());
	            ps.setString(7, switches.getP_Hostname());
	            ps.executeUpdate();
	         
	            JOptionPane.showMessageDialog(null, "Gespeichert!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }		
	}

	@Override
	public void lo(Switch switches) {
		// TODO Auto-generated method stub
		 try {
	            Connection con =  Datenbank2.getConnection();
	         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
	            String sql = "DELETE FROM t_switches WHERE P_Hostname=?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	               
	            ps.setString(1, switches.getP_Hostname());
	            ps.executeUpdate();
	         
	            JOptionPane.showMessageDialog(null, "Gelöscht!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }
	}

	@Override
	public Switch get(String id) {
		
		Switch s = new Switch();
		 try {
	            Connection con =  Datenbank2.getConnection();
	         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
	            String sql = "SELECT * FROM t_switches WHERE P_Hostname=?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	           // ps.setInt(1, g.getInventar_nr());
	          //  ps.setInt(1, id);
	            ps.setString(1, id);
	            
	            ResultSet rs = ps.executeQuery();
	            
	            if(rs.next()){
	            	
	            	//Po nuk funksionoji provoje te shtosh nga fillimi dhe tek metoda rs.getString zgjidh opsionin e pare
	            	s.setF_Inventar_Nr(rs.getInt("F_Inventar_Nr"));
	            	s.setP_Hostname(rs.getString("P_Hostname"));
	            	s.setKategorie(rs.getString("Kategorie"));
	            	s.setAnzahl_Ports(rs.getInt("Anzahl_Ports"));
	            	s.setPoE_Faehig(rs.getBoolean("PoE_Faehig"));
	            	s.setManagement_IP(rs.getString("Management_IP"));
	            	s.setVlan(rs.getInt("F_P_Vlan"));
	            	
	            //	P_Hostname,Kategorie,Anzahl_Ports,PoE_Faehig,Management_IP
	            	
	         /*   	
	                s.set_Inventar_nr(rs.getInt("P_Inventar_Nr"));
	                s.setKaufdatum(rs.getString("Kaufdatum"));
	                s.setSeriennummer(rs.getString("Seriennummer"));
	                s.setFunktional(rs.getBoolean("Funktional"));
	             	s.setKommentar(rs.getString("Kommentar"));
	             	s.setKaufpreis_n(rs.getInt("Kaufpreis_Netto"));   
	             	s.setGarantieablauf(rs.getString("Garantieablauf")); 
	            	s.setF_switch_hostname(rs.getString("F_Switch_Hostname")); 
	            	s.setF_geraetetyp_nr(rs.getInt("F_Geraetetyp_Nr"));
	            	s.setF_gebaeude_nr(rs.getString("F_Gebaeude_Nr"));
	            	s.setF_raum_nr(rs.getString("F_Raum_Nr"));
	            	*/

	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }
		return s;
	}

	@Override
	public List<Switch> list() {
		
		List<Switch> list = new ArrayList <Switch>();
		
		try {
            Connection con = Datenbank2.getConnection();
            String sql = "SELECT * FROM t_switches ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            
            while(rs.next()){
                Switch s = new Switch();
                
                
                s.setF_Inventar_Nr(rs.getInt("F_Inventar_Nr"));
            	
            	s.setP_Hostname(rs.getString("P_Hostname"));
            	s.setKategorie(rs.getString("Kategorie"));
            	s.setAnzahl_Ports(rs.getInt("Anzahl_Ports"));
            	s.setPoE_Faehig(rs.getBoolean("PoE_Faehig"));
            	s.setManagement_IP(rs.getString("Management_IP"));
            	s.setVlan(rs.getInt("F_P_Vlan"));
                list.add(s);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
        }
		
		
		return list;
	}


	
}
