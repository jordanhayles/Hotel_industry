import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;



import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import java.awt.Dimension;

public class Login extends JDialog {
	
	


	private JFrame frmImperial;
	private JPasswordField pass;
	private JTextField user;
	private JComboBox acctype;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmImperial.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImperial = new JFrame();
		frmImperial.setMaximumSize(new Dimension(0, 0));
		frmImperial.setTitle("IMPERIAL- Login");
		frmImperial.setBounds(100, 100, 509, 448);
		frmImperial.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImperial.getContentPane().setLayout(null);
		
		pass = new JPasswordField();
		pass.setBackground(new Color(245, 245, 245));
		pass.setBounds(175, 228, 167, 28);
		frmImperial.getContentPane().add(pass);
		
		user = new JTextField();
		user.setBackground(new Color(245, 245, 245));
		user.setBounds(175, 189, 167, 28);
		frmImperial.getContentPane().add(user);
		user.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username");
		lblNewLabel.setForeground(new Color(47, 79, 79));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(87, 195, 66, 14);
		frmImperial.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setForeground(new Color(47, 79, 79));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(86, 234, 79, 14);
		frmImperial.getContentPane().add(lblNewLabel_1);
		
		JButton btnLogIn = new JButton("Login");
		btnLogIn.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Users-Enter-2-icon.png"));
		btnLogIn.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				if (((String) acctype.getSelectedItem()).trim().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Choose account type to log in.");
				}
				if(((String) acctype.getSelectedItem()).trim().equals("Admin"))
				{
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="Select * from admin where username='"+user.getText()+"' and password='"+pass.getText()+"'";
				
				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					JOptionPane.showMessageDialog(null, "Login Successful");
					frmImperial.dispose();
					Menu as = new Menu();
					as.main(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "Username and Password is incorrect. Please check again.");
				user.setText("");
				pass.setText("");
				}
				con.close();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
				}
				if(((String) acctype.getSelectedItem()).trim().equals("Client"))
				{
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="Select * from client where username='"+user.getText()+"' and password='"+pass.getText()+"'";
				
				ResultSet rs=stmt.executeQuery(sql);
				if(rs.next())
				{
					frmImperial.dispose();
					Menu_client as = new Menu_client();
					as.main(null);
				}
				else {
					JOptionPane.showMessageDialog(null, "Username and Password is incorrect. Please check again.");
				user.setText("");
				pass.setText("");
				}
				con.close();
				}
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
				}
			}
		});
		btnLogIn.setForeground(new Color(255, 255, 255));
		btnLogIn.setBackground(new Color(30, 144, 255));
		btnLogIn.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogIn.setBounds(88, 285, 243, 28);
		frmImperial.getContentPane().add(btnLogIn);
		
		JButton btnNewButton = new JButton("Exit");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Close-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			private String title;

			public void actionPerformed(ActionEvent e) {
				int reply =JOptionPane.showConfirmDialog(null,"Are you sure?", title, JOptionPane.YES_NO_OPTION);
				 if (reply == JOptionPane.YES_OPTION) {
				System.exit(0);
				 }
				 else 
				 {
					 
				 }
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(178, 34, 34));
		btnNewButton.setBounds(394, 343, 89, 34);
		frmImperial.getContentPane().add(btnNewButton);
		
		JLabel login = new JLabel("User Login");
		login.setForeground(new Color(255, 255, 255));
		login.setFont(new Font("Tahoma", Font.BOLD, 14));
		login.setBounds(92, 100, 89, 23);
		frmImperial.getContentPane().add(login);
		
		JButton btnContact = new JButton(" Contact Us");
		btnContact.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Phone-icon.png"));
		btnContact.setForeground(Color.WHITE);
		btnContact.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnContact.setBackground(new Color(50, 205, 50));
		btnContact.setBounds(233, 343, 149, 34);
		frmImperial.getContentPane().add(btnContact);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(65, 100, 296, 40);
		frmImperial.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBounds(0, 381, 493, 28);
		frmImperial.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_6 = new JLabel("Copyright 2019 ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		panel_2.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("AVA Designs Ltd");
		panel_2.add(lblNewLabel_7);
		
		JLabel lblNewLabel_4 = new JLabel("IMPERIAL");
		lblNewLabel_4.setForeground(new Color(47, 79, 79));
		lblNewLabel_4.setFont(new Font("Snap ITC", Font.ITALIC, 18));
		lblNewLabel_4.setBounds(0, 11, 126, 28);
		frmImperial.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Hotel Reservation System");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(25, 38, 197, 23);
		frmImperial.getContentPane().add(lblNewLabel_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 191, 255));
		panel_3.setBounds(0, 0, 493, 61);
		frmImperial.getContentPane().add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_4.setBounds(0, 333, 493, 51);
		frmImperial.getContentPane().add(panel_4);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setForeground(new Color(47, 79, 79));
		lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccountType.setBounds(86, 157, 87, 14);
		frmImperial.getContentPane().add(lblAccountType);
		
	    acctype = new JComboBox();
		acctype.setModel(new DefaultComboBoxModel(new String[] {"", "Admin", "Client"}));
		acctype.setToolTipText("");
		acctype.setBounds(175, 151, 167, 28);
		frmImperial.getContentPane().add(acctype);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(65, 100, 296, 221);
		frmImperial.getContentPane().add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\jamaica.jpg"));
		lblNewLabel_2.setBounds(-32, -29, 772, 488);
		frmImperial.getContentPane().add(lblNewLabel_2);
	}
}
