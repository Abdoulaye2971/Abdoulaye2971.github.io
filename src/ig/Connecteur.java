package ig;
/*Application de gestion des notes des étudiants
 * réalisée en 2016 à Ndjaména au Tchad par 
 * Targoto Christian
 * Contact: +23560316682  / ct@chrislink.net*/

import java.sql.Connection;
import java.sql.DriverManager;

public class Connecteur {
	Connection con;
	public Connecteur(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost/bddgesnote","root","");
			System.out.println("Connection disponible!!!");
			
		}
		catch(Exception e){
			System.out.println("pas de connection!");
			
		}
	}
	public Connection chrisConnect(){
		return con;
	}

}
