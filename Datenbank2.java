package Datenbank;
import java.sql.Connection;

import java.sql.DriverManager;


public class Datenbank2 {

	static	 Connection con; //Erstellen einer Attribut con, die für die Verbindung mit Datenbank genutzt wird

	public  static  Connection getConnection() throws Exception{// Erstellen der Methode getConnection
		if (con==null){// Falss kein andere Verbindung lauft, wird diese Methode laufen
			Class.forName("com.mysql.cj.jdbc.Driver");// Benutzen der Driver com.mysql.cj.jdbc.Driver für mysql Verbindung
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/it_verwaltung", "root", ""); // Eingeben der URL, Datenbankname, und Benutzername sowie Passwort
		}
		return con; //Gibt die Verbindung zurück.
 }
}