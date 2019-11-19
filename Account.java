package GUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Account extends JFrame {
	JLabel lblEmail = new JLabel("Email");
	JTextField tfEmail = new JTextField(15);
	JLabel lblPass = new JLabel("Password");
	JTextField tfPass = new JTextField(15);
	JRadioButton rdoMale = new JRadioButton("Male");
	JRadioButton rdoFemale = new JRadioButton("Female");
	JComboBox cboCountry;
	
	JButton btnUpdate = new  JButton("Update");
	JButton btnDelete = new JButton("Delete");
	
	JButton btnRegis = new JButton("Regis");
	public Account() {
		Container cont =this.getContentPane();
		setLayout(new FlowLayout());
		cont.add(lblEmail);
		cont.add(tfEmail);
		cont.add(lblPass);
		cont.add(tfPass);
		ButtonGroup grGender = new ButtonGroup();
		grGender.add(rdoMale);
		grGender.add(rdoFemale);
		cont.add(rdoMale);
		cont.add(rdoFemale);
		String []country= {"Vietnam","China","France","Japan"};
		cboCountry = new JComboBox(country);
		cont.add(cboCountry);
		cont.add(btnRegis);
		btnRegis.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					Class.forName("com.mysql.jdbc.Driver"); 
				 	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/BookDB","root","");
					
					Statement s = conn.createStatement();
					String gender="";
					if(rdoMale.isSelected()) gender =rdoMale.getText();
					if(rdoFemale.isSelected()) gender =rdoFemale.getText();
					String c = cboCountry.getSelectedItem().toString();
					int n=s.executeUpdate("Insert into Account(Email,Pass,Gender,Country) "
					+ "values('"+tfEmail.getText()+"','"+tfPass.getText()+"','"+gender+"','"+c+"')");
					if(n>0) JOptionPane.showConfirmDialog(null, "OK");
					else JOptionPane.showConfirmDialog(null, "Error");
					conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Account();
	}

}
