package Interface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Backend.Mitarbeiter;
import Backend.Switch;
import Datenbank.Datenbank2;
import Interface.MitarbeiterInterface;

public class MitarbeiterImp implements MitarbeiterInterface{
	
	 public void speichern(Mitarbeiter m) {
		 try {
	            Connection con =  Datenbank2.getConnection();
	         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
	        String sql = "INSERT INTO t_mitarbeiter(P_Ansprechpartner_Nr,Nachname,Vorname,Abteilung,Telefon,Mailadresse,Abteilungsleitung,f_P_Inventar_Nr) VALUES(?,?,?,?,?,?,?,?)";
	            
         PreparedStatement ps = con.prepareStatement(sql);
	            
         ps.setInt(1, m.getAnsprechpartner());
         ps.setString(2, m.getNachname());
         ps.setString(3, m.getVorname());
         ps.setString(4,m.getAbteilung());
         ps.setInt(5, m.getTelefon());
         ps.setString(6, m.getMail());
         ps.setString(7, m.getAbteilungsleitung());
         ps.setInt(8, m.getInventar());
        
         ps.executeUpdate();
	         
	            JOptionPane.showMessageDialog(null, "Gespeichert!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }
		 
	 }
	 public void ak(Mitarbeiter m) {
		 try {
	            Connection con =  Datenbank2.getConnection();
	         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
	            String sql = "UPDATE t_mitarbeiter SET Nachname=?,Vorname=?,Abteilung=?,Telefon=?,Mailadresse=?,Abteilungsleitung=?,f_P_Inventar_Nr=? WHERE P_Ansprechpartner_Nr=?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	            
	            ps.setString(1, m.getNachname());
	            ps.setString(2, m.getVorname());
	            ps.setString(3, m.getAbteilung());
	            ps.setInt(4, m.getTelefon());
	            ps.setString(5, m.getMail());
	            ps.setString(6, m.getAbteilung());
	            ps.setInt(7, m.getInventar());
	            ps.setInt(8, m.getAnsprechpartner());
	           
	            ps.executeUpdate();
	         
	            JOptionPane.showMessageDialog(null, "Gespeichert!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }		
		 
	 }
	 public void lo(Mitarbeiter m) {
		 try {
	            Connection con =  Datenbank2.getConnection();
	         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
	            String sql = "DELETE FROM t_mitarbeiter WHERE P_Ansprechpartner_Nr=?";
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	               
	            ps.setInt(1, m.getAnsprechpartner());
	            ps.executeUpdate();
	         
	            JOptionPane.showMessageDialog(null, "Gelöscht!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }
	}
		 
	 public Mitarbeiter get(int suchen) {
		 Mitarbeiter m = new Mitarbeiter();
			 try {
		            Connection con =  Datenbank2.getConnection();
		         //   String sql = "INSERT INTO students(fname,course,fee) VALUES (?,?,?)";
		            String sql = "SELECT * FROM t_mitarbeiter WHERE P_Ansprechpartner_Nr=?";
		            
		            PreparedStatement ps = con.prepareStatement(sql);
		           // ps.setInt(1, g.getInventar_nr());
		          //  ps.setInt(1, id);
		            ps.setInt(1, suchen);
		            
		            ResultSet rs = ps.executeQuery();
		            
		            if(rs.next()){
		            	
		            	//Po nuk funksionoji provoje te shtosh nga fillimi dhe tek metoda rs.getString zgjidh opsionin e pare
		            	
		            	
		            m.setAnsprechpartner(rs.getInt("P_Ansprechpartner_Nr"));	
		            m.setNachname(rs.getString("Nachname"));
		            m.setVorname(rs.getString("Vorname"));
		            m.setAbteilung(rs.getString("Abteilung"));
		            m.setTelefon(rs.getInt("Telefon"));
		            m.setMail(rs.getString("Mailadresse"));
		            m.setAbteilungsleitung(rs.getString("Abteilungsleitung"));
		            m.setInventar(rs.getInt("f_P_Inventar_Nr"));
		            	

		            }
		        } catch (Exception e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
		        }
			return m;
		 
	 }
	 public List<Mitarbeiter> list(){
			
		 List<Mitarbeiter> list = new ArrayList <Mitarbeiter>();
			
			try {
	            Connection con = Datenbank2.getConnection();
	            String sql = "SELECT * FROM t_mitarbeiter ";
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();
	           
	            
	            while(rs.next()){
	            	Mitarbeiter m = new Mitarbeiter();
	                
	                
		            m.setAnsprechpartner(rs.getInt("P_Ansprechpartner_Nr"));	
		            m.setNachname(rs.getString("Nachname"));
		            m.setVorname(rs.getString("Vorname"));
		            m.setAbteilung(rs.getString("Abteilung"));
		            m.setTelefon(rs.getInt("Telefon"));
		            m.setMail(rs.getString("Mailadresse"));
		            m.setAbteilungsleitung(rs.getString("Abteilungsleitung"));
		            m.setInventar(rs.getInt("f_P_Inventar_Nr"));
	                list.add(m);
	            }
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Ein Fehler ist aufgetreten!");
	        }
			
			
			return list;
		}

		 
	 }
