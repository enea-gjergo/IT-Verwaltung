package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import  Backend.Geraete;
import Datenbank.Datenbank2;
import net.proteanit.sql.DbUtils;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.*;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ItemEvent;
import java.util.Date.*;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.util.Calendar;




public class All extends JFrame{
	
	private Connection con;
	private JPanel geraet;
	public JTable table;
	private JScrollPane scrollPane;
	private JTextField inventar;
	private JTextField serien_nr;
	private JLabel lblFunktional;
	private JTextField kommentar;
	private JLabel lblKommentar;
	private JTextField kaufpreis_n;
	private JLabel lblFunktional_1;
	private JTextField funktional;
	private JLabel lblGarantieablauf;
	private JLabel lblFswitchhostname;
	private JTextField sw_hostname;
	private JLabel lblFgeabudenr;
	private JTextField gebaude;
	private JLabel lblRaumNr;
	private JTextField raum_nr;
	private JLabel lblGeraetetypnr;
	private JTextField geraetetyp_nr;
	private JTextField id;
	private JTextField name;
	private JLabel lblDatum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					All frame = new All();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public All() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1500, 1500);
		geraet = new JPanel();
		geraet.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(geraet);
		geraet.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(532, 196, 753, 426);
		geraet.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, "", null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Inventar_Nr", "Kaufdatum", "Seriennummer", "Funktional", "Kommentar", "Kaufpreis_Netto", "Garantieablauf", "F_Switch_Hostname", "Geraetetyp_nr", "F_Geabude_Nr", "F_Raum_Nr"
			}
		));
	// Lidhja e Databazes me GUI	
		Button alle_geraete = new Button("alle_geraete");
		alle_geraete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
/*			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/it_verwaltung", "root", "");
				String sql = "SELECT * from t_all";
				Statement st = con.prepareStatement(sql);
				ResultSet rs= st.executeQuery(sql);
				
				table.setModel(DbUtils.resultSetToTableModel(rs));
			}
			catch (Exception a) {
				a.printStackTrace();
			}*/
				
				try {
					
					Datenbank2 db=new Datenbank2();
					db.datenbank();
					
					//String sql = "SELECT * from t_geraete";
					String sql = "SELECT * from t_geraete";
					Statement st = db.con.prepareStatement(sql);
					ResultSet rs= st.executeQuery(sql);
					 
					//TO DO mbaj Table Header te Databazes se pare
					
					//table.setTableHeader(null);
					table.setModel(DbUtils.resultSetToTableModel(rs));	
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
		alle_geraete.setBounds(114, 41, 126, 21);
		geraet.add(alle_geraete);
		
		JLabel InventarNr = new JLabel("InventarNr :");
		InventarNr.setHorizontalAlignment(SwingConstants.LEFT);
		InventarNr.setBounds(29, 131, 93, 33);
		geraet.add(InventarNr);
		
		JLabel lblNewLabel = new JLabel("Kaufdatum :");
		lblNewLabel.setBounds(29, 167, 69, 13);
		geraet.add(lblNewLabel);
		
		inventar = new JTextField();
		inventar.setBounds(114, 138, 96, 19);
		geraet.add(inventar);
		inventar.setColumns(10);
		
		JLabel lblSeriennummer = new JLabel("Seriennummer :");
		lblSeriennummer.setBounds(29, 203, 93, 13);
		geraet.add(lblSeriennummer);
		
		serien_nr = new JTextField();
		serien_nr.setColumns(10);
		serien_nr.setBounds(114, 197, 96, 19);
		geraet.add(serien_nr);
		
		lblFunktional = new JLabel("Kommentar :");
		lblFunktional.setBounds(29, 260, 93, 13);
		geraet.add(lblFunktional);
		
		kommentar = new JTextField();
		kommentar.setColumns(10);
		kommentar.setBounds(114, 254, 96, 19);
		geraet.add(kommentar);
		
		lblKommentar = new JLabel("Kaufpreis Netto :");
		lblKommentar.setBounds(29, 296, 93, 13);
		geraet.add(lblKommentar);
		
		kaufpreis_n = new JTextField();
		kaufpreis_n.setColumns(10);
		kaufpreis_n.setBounds(114, 290, 96, 19);
		geraet.add(kaufpreis_n);
		
		lblFunktional_1 = new JLabel("Funktional :");
		lblFunktional_1.setBounds(29, 234, 93, 13);
		geraet.add(lblFunktional_1);
		
		funktional = new JTextField();
		funktional.setColumns(10);
		funktional.setBounds(114, 228, 96, 19);
		geraet.add(funktional);
		
		lblGarantieablauf = new JLabel("Garantieablauf :");
		lblGarantieablauf.setBounds(29, 322, 93, 13);
		geraet.add(lblGarantieablauf);
		
		lblFswitchhostname = new JLabel("Switch Hostname :");
		lblFswitchhostname.setBounds(29, 351, 93, 13);
		geraet.add(lblFswitchhostname);
		
		sw_hostname = new JTextField();
		sw_hostname.setColumns(10);
		sw_hostname.setBounds(114, 345, 96, 19);
		geraet.add(sw_hostname);
		
		lblFgeabudenr = new JLabel("Gebaude Nr :");
		lblFgeabudenr.setBounds(29, 431, 93, 13);
		geraet.add(lblFgeabudenr);
		
		gebaude = new JTextField();
		gebaude.setColumns(10);
		gebaude.setBounds(114, 425, 96, 19);
		geraet.add(gebaude);
		
		lblRaumNr = new JLabel("Raum Nr :");
		lblRaumNr.setBounds(29, 466, 93, 13);
		geraet.add(lblRaumNr);
		
		raum_nr = new JTextField();
		raum_nr.setColumns(10);
		raum_nr.setBounds(114, 460, 96, 19);
		geraet.add(raum_nr);
		
		JDateChooser kaufdatum = new JDateChooser();
		kaufdatum.setBounds(114, 167, 100, 19);
		kaufdatum.setDateFormatString("yyyy-MM-dd");
		geraet.add(kaufdatum);
		
		JDateChooser garantie = new JDateChooser();
		garantie.setBounds(114, 319, 100, 19);
		garantie.setDateFormatString("yyyy-MM-dd");
		geraet.add(garantie);
		
		
		
		JButton btnNewButton = new JButton("Hinzuf\u00FCgen");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					Datenbank2 db=new Datenbank2();
					db.datenbank();
				
					
					/* Shembull i shtimit te integer	
					 * 
					 String sid;
	  				sid = (id.getText());
	  				st.setString(2, sid);
	  				int iid=Integer.parseInt(sid);
	  				st.setInt(1, iid);*/
	  				 

					
					
					
					//String sql = "SELECT * from t_geraete";
  String sql = "INSERT INTO t_geraete(P_Inventar_Nr, Kaufdatum, Seriennummer, Funktional, Kommentar, Kaufpreis_Netto, Garantieablauf, F_Switch_Hostname, F_Geraetetyp_Nr, F_Gebaeude_Nr, F_Raum_Nr) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
  
  PreparedStatement st = db.con.prepareStatement(sql);
  
  
  
  
				String skaufpreis;
				skaufpreis = (kaufpreis_n.getText());
				st.setString(6, skaufpreis);
				int kaufpreis=Integer.parseInt(skaufpreis);
				
				String sgeraetetyp_nr;
				sgeraetetyp_nr = (geraetetyp_nr.getText());
				st.setString(9, sgeraetetyp_nr);
				int geraetetyp=Integer.parseInt(sgeraetetyp_nr);
				
				String sfunktional;
				sfunktional=(funktional.getText());
				st.setString(9, sfunktional);
				boolean bfunktional=Boolean.parseBoolean(sfunktional);
  
  
					//st.setString();
			
  				st.setString(1, inventar.getText());
  				
  				//Vendosja e Dates 
  				st.setString(2, ((JTextField)kaufdatum.getDateEditor().getUiComponent()).getText());
  			st.setString(3, serien_nr.getText());
  				//st.setInt(3, serien);
  				st.setString(4, funktional.getText());
  				st.setBoolean(4, bfunktional);
  				st.setString(5, kommentar.getText());
  			//	st.setString(6, kaufpreis_n.getText());
  				st.setInt(6, kaufpreis);
  				st.setString(7, ((JTextField)garantie.getDateEditor().getUiComponent()).getText());
  				st.setString(8, sw_hostname.getText());
  				//st.setString(9, geraetetyp_nr.getText());
  				st.setInt(9, geraetetyp);
  				st.setString(10, gebaude.getText());
  				st.setString(11, raum_nr.getText());
  				
										
					st.executeUpdate();
					 
					//TO DO mbaj Table Header te Databazes se pare
					
					//table.setTableHeader(null);
					ResultSet rs= st.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));	
					
					
	  				
	  				
					
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBounds(13, 589, 85, 21);
		geraet.add(btnNewButton);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		btnLschen.setBounds(114, 589, 85, 21);
		geraet.add(btnLschen);
		
		JButton btnAktualisieren = new JButton("Aktualisieren");
		btnAktualisieren.setBounds(723, 709, 141, 21);
		geraet.add(btnAktualisieren);
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBounds(219, 589, 85, 21);
		geraet.add(btnNewButton_1);
		
		lblGeraetetypnr = new JLabel("Geraetetyp Nr :");
		lblGeraetetypnr.setBounds(29, 389, 93, 13);
		geraet.add(lblGeraetetypnr);
		
		geraetetyp_nr = new JTextField();
		geraetetyp_nr.setColumns(10);
		geraetetyp_nr.setBounds(114, 383, 96, 19);
		geraet.add(geraetetyp_nr);
		
		JDateChooser datum = new JDateChooser();
		datum.setBounds(321, 272, 100, 19);
		datum.setDateFormatString("yyyy-MM-dd");
		geraet.add(datum);
		
		
		JButton btnTest = new JButton("Test");
		btnTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				Datenbank2 db=new Datenbank2();
				db.datenbank();
				String all ="INSERT INTO t_all(id,name, Datum) VALUES(?,?,?)";
				 PreparedStatement st = db.con.prepareStatement(all);
				 
				 	String sid;
	  				sid = (id.getText());
	  				st.setString(2, sid);
	  				int iid=Integer.parseInt(sid);
	  				st.setInt(1, iid);
	  			st.setString(2, name.getText());
	  			st.setString(3, ((JTextField)datum.getDateEditor().getUiComponent()).getText());
				 st.executeUpdate();
				 
				 
				}
			catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
		}
		}
		});
		btnTest.setBounds(114, 633, 85, 21);
		geraet.add(btnTest);
		
		id = new JTextField();
		id.setColumns(10);
		id.setBounds(325, 178, 96, 19);
		geraet.add(id);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(240, 184, 93, 13);
		geraet.add(lblId);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(325, 228, 96, 19);
		geraet.add(name);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(240, 234, 93, 13);
		geraet.add(lblName);
		
		lblDatum = new JLabel("Datum");
		lblDatum.setBounds(240, 278, 93, 13);
		geraet.add(lblDatum);
		
		
		
		

		
	
		
	}
}

/*
 		try {
			Datenbank2 db= new Datenbank2();
			db.datenbank();
			All all=new All();
			Statement st = con.createStatement();
			ResultSet rs= st.executeQuery("SELECT * FROM t_geraete");
			all.table.setModel(DbUtils.resultSetToTableModel(rs));
			return rs;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
 */
