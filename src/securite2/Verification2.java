package securite2;
/*Application de gestion des notes des étudiants
 * réalisée en 2016 à Ndjaména au Tchad par 
 * Targoto Christian
 * Contact: +23560316682  / ct@chrislink.net*/
import java.sql.*;

import ig.*;

public class Verification2 {
	Statement st;
	ResultSet rst;
	Connecteur cn=new Connecteur();
	
	public boolean verifier(String login,String password){
		boolean test=false;
	String log=null,pass=null;
	String qr="select * from secret2 ";
	
	
	try{
		st=cn.chrisConnect().createStatement();
		rst=st.executeQuery(qr);
		while((rst.next())||(test==true)){
			log=rst.getString("login");
			pass=rst.getString("password");
			if(log.equals(login)&&pass.equals(password)){
				test=true;
				
			}
			
		}
		
	}
	catch(SQLException ex){
		
	}
	
		return test;
		
		
	}

}
