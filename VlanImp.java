package Interface;

import Backend.Vlan;
import Datenbank.Datenbank2;
import Backend.Switch;
import Interface.VlanInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class VlanImp implements VlanInterface{
	
	@Override
	public void speichern(Vlan v) {
			 try {
		            Connection con =  Datenbank2.getConnection();
		         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
		        String sql = "INSERT INTO t_vlans(P_ID,	F_Hostname,Vlan_Id,Benutzergruppe,Port_type) VALUES(?,?,?,?,?)";
		            
	            PreparedStatement ps = con.prepareStatement(sql);
		            
	            ps.setInt(1, v.getId()); // !! Kujdes!! Eshte vene metoda e Geräte
	            ps.setString(2, v.getHostname());
	            ps.setString(3, v.getVlanNr());
	            ps.setString(4, v.getGruppe());
	            ps.setString(5, v.getPort_typ());
	              //!! Kujdes ndoshta duhet ndryshuar dhe duhet vene metoda e Vlan nga klasa Vlan
	          //  ps.setInt(7,switches.getF_Inventar_Nr());
	            
	           
	            ps.executeUpdate();
		         
		            JOptionPane.showMessageDialog(null, "Gespeichert!");
		        } catch (Exception e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
		        }
			
			
		}

	@Override
	public void ak(Vlan v) {
		
		
		 try {
	            Connection con =  Datenbank2.getConnection();
	         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
	            String sql = "UPDATE t_vlans SET F_Hostname=?,Vlan_Id=?,Benutzergruppe=?,Port_type=? WHERE P_ID=?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	            
	            ps.setString(1, v.getP_Hostname());
	            ps.setString(2, v.getVlanNr());
	            ps.setString(3, v.getGruppe());
	            ps.setString(4, v.getPort_typ());
	            ps.setInt(5, v.getId());
	            ps.executeUpdate();
	         
	            JOptionPane.showMessageDialog(null, "Aktualisiert!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }		
	}

	@Override
	public void lo(Vlan v) {
		// TODO Auto-generated method stub
		 try {
	            Connection con =  Datenbank2.getConnection();
	         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
	            String sql = "DELETE FROM t_vlans WHERE P_ID=?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	               
	            ps.setInt(1, v.getId());
	            ps.executeUpdate();
	         
	            JOptionPane.showMessageDialog(null, "Gelöscht!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }
	}

	@Override
	public Vlan get(int id) {
		
		Vlan v = new Vlan();
		 try {
	            Connection con =  Datenbank2.getConnection();
	         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
	            String sql = "SELECT * FROM t_vlans WHERE P_ID=?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	           // ps.setInt(1, g.getInventar_nr());
	          //  ps.setInt(1, id);
	            ps.setInt(1, id);
	            
	            ResultSet rs = ps.executeQuery();
	            
	            if(rs.next()){
	            	//P_ID,	F_Hostname,Vlan_Id,Benutzergruppe,Port_type
	            	
	            	v.setId(rs.getInt("P_ID"));
	            	v.setHostname(rs.getString("F_Hostname"));
	            	v.setVlanNr(rs.getString("Vlan_Id"));
	            	v.setGruppe(rs.getString("Benutzergruppe"));
	            	v.setPort_typ(rs.getString("Port_type"));
	            	
	            	
	            	//Po nuk funksionoji provoje te shtosh nga fillimi dhe tek metoda rs.getString zgjidh opsionin e pare
	            	
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
		return v;
	}

	@Override
	public List<Vlan> list() {
		
		List<Vlan> list = new ArrayList <Vlan>();
		
		try {
            Connection con = Datenbank2.getConnection();
            String sql = "SELECT * FROM t_vlans ";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
           
            
            while(rs.next()){
                Vlan v = new Vlan();
                
            	v.setId(rs.getInt("P_ID"));
            	v.setHostname(rs.getString("F_Hostname"));
            	v.setVlanNr(rs.getString("Vlan_Id"));
            	v.setGruppe(rs.getString("Benutzergruppe"));
            	v.setPort_typ(rs.getString("Port_type"));
            	list.add(v);
         
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
        }
		
		
		return list;
	}


	
}
