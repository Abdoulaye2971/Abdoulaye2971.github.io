package requetes;
/*Application de gestion des notes des étudiants
 * réalisée en 2016 à Ndjaména au Tchad par 
 * Targoto Christian
 * Contact: +23560316682  / ct@chrislink.net*/

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import ig.Connecteur;

import java.sql.*;

public class List_notes_etd extends JFrame implements ActionListener{
	JLabel lab1,lab2;
	JComboBox jcb1,jcb2;
	JButton jb1,jb2,jb3;
	JTable tb;
	JScrollPane scrl,scrl2;
	Statement st;
	ResultSet rst;
	Connecteur cn=new Connecteur();
	public List_notes_etd(){
		this.setTitle("chcode_appli");
		this.setSize(1000,600);
		this.setLocation(350,30);
		this.setResizable(false);
		JPanel pn=new JPanel();
		pn.setLayout(null);
		pn.setBackground(Color.cyan);
		add(pn);
		//
		lab1=new JLabel("RELEVE DES NOTES D'UN ETUDIANT");
		lab1.setBounds(150,10,500,30);
		lab1.setFont(new Font("Arial",Font.BOLD,25));
		lab1.setBorder(BorderFactory.createLineBorder(Color.black));
		pn.add(lab1);
		//label1
		lab1=new JLabel("ETUDIANT :");
		lab1.setBounds(50,80,90,30);
		lab1.setFont(new Font("Arial",Font.BOLD,15));
		pn.add(lab1);
		//combo1
		jcb1=new JComboBox();
		jcb1.addItem("8030");
		jcb1.addItem("8031");
		jcb1.addItem("8032");
		jcb1.addItem("8033");
		jcb1.addItem("8034");
		jcb1.addItem("8035");
		jcb1.setBounds(140,80,80,30);
		pn.add(jcb1);
		/*//label2
				lab2=new JLabel("NIVEAU :");
				lab2.setBounds(360,80,80,30);
				lab2.setFont(new Font("Arial",Font.BOLD,15));
				pn.add(lab2);
				//combo2
				jcb2=new JComboBox();
				jcb2.addItem("1");
				jcb2.addItem("2");
				jcb2.addItem("3");
				jcb2.setBounds(440,80,80,30);
				pn.add(jcb2);*/
				//
				jb1=new JButton("Recherche");
				jb1.setBounds(640,80,100,30);
				jb1.setBackground(Color.white);
				jb1.setForeground(Color.blue);
				jb1.addActionListener(this);
				pn.add(jb1);
				
				//
				DefaultTableModel df=new DefaultTableModel();
				init();
				df.addColumn("NOM");
				df.addColumn("PRENOM");
				df.addColumn("CONTROLE");
				df.addColumn("EXAMEN");
				df.addColumn("TP");
				df.addColumn("MATIERE");
				//df.addColumn("Filiere");
				//df.addColumn("Niveau");
				tb.setModel(df);
				pn.add(scrl);
		
	}
	private void init(){
		tb=new JTable();
		scrl=new JScrollPane();
		scrl.setViewportView(tb);
		scrl.setBounds(10,150,960,400);
		
	}
public static void main(String[] args){
		
	List_notes_etd ls=new List_notes_etd();
		ls.setVisible(true);
	}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(e.getSource()==jb1){
		String a;
		a=jcb1.getSelectedItem().toString();
		DefaultTableModel df=new DefaultTableModel();
		df.addColumn("NOM");
		df.addColumn("PRENOM");
		df.addColumn("CONTROLE");
		df.addColumn("EXAMEN");
		df.addColumn("TP");
		df.addColumn("MATIERE");
		//df.addColumn("Filiere");
		//df.addColumn("Niveau");
		tb.setModel(df);
		String qry="select nom,prenom,controle,examen,tp,appelation from etudiant inner join note on etudiant.matricule=note.idetudiant inner join matiere on note.idmatiere=matiere.idmat  where matricule='"+a+"'";
		try{
			st=cn.chrisConnect().createStatement();
			rst=st.executeQuery(qry);
			while(rst.next()){
				df.addRow(new Object[]{
						rst.getString("nom"),rst.getString("prenom"),rst.getString("controle"),rst.getString("examen")
					,rst.getString("tp"),rst.getString("appelation")
						
				});
				
			}
			
		}
		catch(SQLException ex){
			JOptionPane.showMessageDialog(this,"INTROUVABLE",null,JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
}


}
