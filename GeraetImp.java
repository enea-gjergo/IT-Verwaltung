package Interface;

import Backend.Geraete;
import Datenbank.Datenbank2;
import Interface.GeraetInterface;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class GeraetImp  implements GeraetInterface{ // Implementiert Interface abstrakte Methoden
	
	@Override
	public void speichern(Geraete geraete) { //Erstellen einer speichern Methode
			 try {
		            Connection con =  Datenbank2.getConnection(); // Verbinfung mit der Datenbank
		            String sql = "INSERT INTO t_geraete(P_Inventar_Nr,Kaufdatum, Seriennummer,Funktional,Kommentar,Kaufpreis_Netto,	Garantieablauf,	F_Switch_Hostname,	F_Geraetetyp_Nr,F_Gebaeude_Nr,	F_Raum_Nr, F_P_MAC, F_Ansprechpartner_Nr) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)"; //Erstellen einer Attribute für Insert Query in MySQL
		            
		            PreparedStatement ps = con.prepareStatement(sql); // Erstellen einer Statement von java.sql.PreparedStatement Librarie
		            
		            ps.setInt(1, geraete.getInventar_nr()); //Nehmen der Elementen von der Objekt und fügen in Query Statement in entsprechenden Position
		            ps.setString(2, geraete.getKaufdatum());
		            ps.setString(3, geraete.getSeriennummer());
		            ps.setBoolean(4, geraete.isFunktional());
		            ps.setString(5,  geraete.getKommentar());
		            ps.setInt(6, geraete.getKaufpreis_n());
		            ps.setString(7, geraete.getGarantieablauf());
		            ps.setString(8, geraete.getF_switch_hostname());
		            ps.setInt(9,  geraete.getF_geraetetyp_nr());
		            ps.setString(10,  geraete.getF_gebaeude_nr());
		            ps.setString(11,  geraete.getF_raum_nr());
		            ps.setString(12,  geraete.getF_p_mac());
		            ps.setInt(13,  geraete.getF_Ansprechpartner());
		            ps.executeUpdate();// Aufrufen der ps Statement
		         
		            JOptionPane.showMessageDialog(null, "Gespeichert!"); // Nach erfolgreichen Ausführung wird ein Dialogbenachrichtung geizeigt mit Text Gespeichert
		        } catch (Exception e) {
		            e.printStackTrace();
		            JOptionPane.showMessageDialog(null, "Fehler Aufgetreten");// Wenn was nicht richtig läuft wird ein Dialogbenachrichtung geizeigt mit Text Fehler Aufgetreten
		        }
			
			
		}

	@Override
	public void aktualisieren(Geraete geraete) { //Methode um Einträge im Datenbank zu löschen
		
		
		 try {
	            Connection con =  Datenbank2.getConnection();
	            String sql = "UPDATE  t_geraete SET Kaufdatum=?, Seriennummer=?,Funktional=?,Kommentar=?,Kaufpreis_Netto=?,Garantieablauf=?,F_Switch_Hostname=?,F_Geraetetyp_Nr=?,F_Gebaeude_Nr=?,F_Raum_Nr=?,F_P_MAC=?,F_Ansprechpartner_Nr=? WHERE P_Inventar_Nr=?";// Erstellen einer Attribut für Bearbeiten einer Eintrag
	            
	            PreparedStatement ps = con.prepareStatement(sql);	            
	            
	            ps.setString(1, geraete.getKaufdatum()); //Nehmen der Atrributen von Objekt mit Get Methode und als String in Datenbank speichern
	            ps.setString(2, geraete.getSeriennummer());
	            ps.setBoolean(3, geraete.isFunktional());
	            ps.setString(4,  geraete.getKommentar());
	            ps.setInt(5, geraete.getKaufpreis_n());
	            ps.setString(6, geraete.getGarantieablauf());
	            ps.setString(7, geraete.getF_switch_hostname());
	            ps.setInt(8,  geraete.getF_geraetetyp_nr());
	            ps.setString(9,  geraete.getF_gebaeude_nr());
	            ps.setString(10,  geraete.getF_raum_nr());
	            ps.setString(11, geraete.getF_p_mac());
	            ps.setInt(12, geraete.getF_Ansprechpartner());
	            ps.setInt(13, geraete.getInventar_nr());
	            ps.executeUpdate();
	         
	            JOptionPane.showMessageDialog(null, "Aktualisiert!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Fehler Aufgetreten");
	        }		
	}

	@Override
	public void loeschen(Geraete geraete) {
		// TODO Auto-generated method stub
		 try {
	            Connection con =  Datenbank2.getConnection();
	            String sql = "DELETE FROM t_geraete WHERE P_Inventar_Nr=?"; // Erstellen einer Attribut um einen Eintrag zu löschen
	            
	            PreparedStatement ps = con.prepareStatement(sql); // Erstellen einer Statement von java.sql.PreparedStatement Librarie 
	               
	            ps.setInt(1, geraete.getInventar_nr()); // Suchen der Eintrag mit eingegebene Inventar Nr von Objekt der Klasse Gerät und fügen dieser element in entsprechenden Postion
	            ps.executeUpdate(); // Aufrufen der ps Statement
	         
	            JOptionPane.showMessageDialog(null, "Gelöscht!");
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Fehler Aufgetreten");
	        }
		
		
		
	}

	@Override
	public Geraete get(int id) { // Esrtellen der Suche Methode
		// TODO Auto-generated method stub
		
		Geraete g = new Geraete();
		 try {
	            Connection con =  Datenbank2.getConnection();
	            String sql = "SELECT * FROM t_geraete WHERE P_Inventar_Nr=?"; //Erstellen einer Attribut die Alle Elementen in Datenbank auswählt
	            
	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, id); //Suchen der Elementen mit Inventar Nr
	            
	            ResultSet rs = ps.executeQuery(); // Erstellen eine Datentabelle, die eine Datenbankergebnismenge darstellt, die normalerweise durch die Ausführung einer Anweisung zur Abfrage der Datenbank erzeugt wird. 
	            
	            if(rs.next()){// Falls ein Übereinstimmung gibt wurden die Daten von Datenbank entnommen und im Gerät Objekt mit Setmethode gespeichert
	                
	                 g.set_Inventar_nr(rs.getInt("P_Inventar_Nr"));
	                 g.setKaufdatum(rs.getString("Kaufdatum"));
	                 g.setSeriennummer(rs.getString("Seriennummer"));
	                 g.setFunktional(rs.getBoolean("Funktional"));
	             	g.setKommentar(rs.getString("Kommentar"));
	             	g.setKaufpreis_n(rs.getInt("Kaufpreis_Netto"));   
	             	g.setGarantieablauf(rs.getString("Garantieablauf")); 
	            	g.setF_switch_hostname(rs.getString("F_Switch_Hostname")); 
	            	g.setF_geraetetyp_nr(rs.getInt("F_Geraetetyp_Nr"));
	            	g.setF_gebaeude_nr(rs.getString("F_Gebaeude_Nr"));
	            	g.setF_raum_nr(rs.getString("F_Raum_Nr"));
	            	g.setF_p_mac(rs.getString("F_P_MAC"));     	
	            	g.setF_Ansprechpartner(rs.getInt("F_Ansprechpartner_Nr"));

	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Fehler Aufgetreten");
	        }
		return g;
	}

	@Override
	public List<Geraete> list() {// Erstellen einer List Methode für die Anwendung im GUI Tabelle
		
		List<Geraete> list = new ArrayList <Geraete>(); // Erstellen einer List Objekt von Klasse Geräte
		
		try {
            Connection con = Datenbank2.getConnection();
            String sql = "SELECT * FROM t_geraete "; //Erstellen einer Attribut die als Query verwendet wird um alle Zeile im t_geraete nimmt
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();// Aufrufen der SQL Anfrage 
           
            
            while(rs.next()){ // Erstellen einer While-Schleife um Daten von Datenbank zu Objekt g(eine Zeile) von Klasse Gerät hinzufügt.
                Geraete g = new Geraete();
                
                
                g.set_Inventar_nr(rs.getInt("P_Inventar_Nr"));
                g.setKaufdatum(rs.getString("Kaufdatum"));
                g.setSeriennummer(rs.getString("Seriennummer"));
                g.setFunktional(rs.getBoolean("Funktional"));
            	g.setKommentar(rs.getString("Kommentar"));
            	g.setKaufpreis_n(rs.getInt("Kaufpreis_Netto"));   
            	g.setGarantieablauf(rs.getString("Garantieablauf")); 
            	g.setF_switch_hostname(rs.getString("F_Switch_Hostname")); 
            	g.setF_geraetetyp_nr(rs.getInt("F_Geraetetyp_Nr"));
            	g.setF_gebaeude_nr(rs.getString("F_Gebaeude_Nr"));
            	g.setF_raum_nr(rs.getString("F_Raum_Nr"));
            	g.setF_p_mac(rs.getString("F_P_MAC"));
            	g.setF_Ansprechpartner(rs.getInt("F_Ansprechpartner_Nr"));
                list.add(g);// jede Jede Objekt(Zeile) wird in diese Liste gespeichert
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Fehler Aufgetreten");
        }
		
		
		return list; //Zurückgeben der Liste
	}
}
