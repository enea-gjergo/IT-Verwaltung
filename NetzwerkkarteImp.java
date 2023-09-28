package Interface;


import Datenbank.Datenbank2;
import Interface.NetzwerkkarteInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import Backend.Netzwerkkarte;

public class NetzwerkkarteImp implements NetzwerkkarteInterface{

	public void speichern(Netzwerkkarte netz) {
		 try {
	            Connection con =  Datenbank2.getConnection();
	         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
	        String sql = "INSERT INTO t_netzwerkkarte(P_MAC,f_P_Inventar_Nr,Uebertragungsrate,IP,Netzmask,DNS) VALUES(?,?,?,?,?,?)";
	            
           PreparedStatement ps = con.prepareStatement(sql);
	            
           ps.setString(1, netz.getMac()); // !! Kujdes!! Eshte vene metoda e Geräte
           ps.setInt(2, netz.getInventar_nr());
           ps.setString(3, netz.getUebertragungsrate());
           ps.setString(4, netz.getIp());
           ps.setString(5, netz.getNetzmaske());
           ps.setString(6, netz.getDns());
             //!! Kujdes ndoshta duhet ndryshuar dhe duhet vene metoda e Vlan nga klasa Vlan
         //  ps.setInt(7,switches.getF_Inventar_Nr());
           
          
           ps.executeUpdate();
	         
	            JOptionPane.showMessageDialog(null, "Gespeichert!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }

	}
	
	
	 public void aktualisieren(Netzwerkkarte netz) {
		 
		 try {
	            Connection con =  Datenbank2.getConnection();
	         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
	            String sql = "UPDATE t_netzwerkkarte SET f_P_Inventar_Nr=?,Uebertragungsrate=?,IP=?,Netzmask=?,DNS=? WHERE P_MAC=?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	            
	            ps.setInt(1, netz.getInventar_nr());
	          //  ps.setInt(1, switches.getInventar_nr());
	         //   ps.setString(2, switches.getP_Hostname());
	            ps.setString(2, netz.getUebertragungsrate());
	            ps.setString(3, netz.getIp());
	            ps.setString(4, netz.getNetzmaske());
	            ps.setString(5, netz.getDns());
	            ps.setString(6, netz.getMac());
	            ps.executeUpdate();
	         
	            JOptionPane.showMessageDialog(null, "Gespeichert!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }	
	 }
	 public void loeschen(Netzwerkkarte netz)
	 {
			// TODO Auto-generated method stub
			 try {
		            Connection con =  Datenbank2.getConnection();
		         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
		            String sql = "DELETE FROM t_netzwerkkarte WHERE P_MAC=?";
		            
		            PreparedStatement ps = con.prepareStatement(sql);
		               
		            ps.setString(1, netz.getMac());
		            ps.executeUpdate();
		         
		            JOptionPane.showMessageDialog(null, "Gelöscht!");
		        } catch (Exception e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
		        }
		}
	 public Netzwerkkarte get(String id)
	 {
			
		 Netzwerkkarte netz = new Netzwerkkarte();
			 try {
		            Connection con =  Datenbank2.getConnection();
		         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
		            String sql = "SELECT * FROM t_netzwerkkarte WHERE P_MAC=?";
		            
		            PreparedStatement ps = con.prepareStatement(sql);
		           // ps.setInt(1, g.getInventar_nr());
		          //  ps.setInt(1, id);
		            ps.setString(1, id);
		            
		            ResultSet rs = ps.executeQuery();
		            
		            if(rs.next()){
		            	
		            	//Po nuk funksionoji provoje te shtosh nga fillimi dhe tek metoda rs.getString zgjidh opsionin e pare
		            	netz.setMac(rs.getString("P_MAC"));
		            	netz.setF_inventar(rs.getInt("f_P_Inventar_Nr"));
		            	netz.setUebertragungsrate(rs.getString("Uebertragungsrate"));
		            	netz.setIp(rs.getString("IP"));
		            	netz.setNetzmaske(rs.getString("Netzmask"));
		            	netz.setDns(rs.getString("DNS"));
		            

		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
		        }
			return netz;
		}
	 
	 public List<Netzwerkkarte> list(){
			
			List<Netzwerkkarte> list = new ArrayList <Netzwerkkarte>();
			
			try {
	            Connection con = Datenbank2.getConnection();
	            String sql = "SELECT * FROM t_netzwerkkarte ";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	           
	            
	            while(rs.next()){
	                Netzwerkkarte netz = new Netzwerkkarte();
	                
	                
	            	netz.setMac(rs.getString("P_MAC"));
	            	netz.setF_inventar(rs.getInt("f_P_Inventar_Nr"));
	            	netz.setUebertragungsrate(rs.getString("Uebertragungsrate"));
	            	netz.setIp(rs.getString("IP"));
	            	netz.setNetzmaske(rs.getString("Netzmask"));
	            	netz.setDns(rs.getString("DNS"));
	                list.add(netz);
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }
			return list;
		}


	
	
}
