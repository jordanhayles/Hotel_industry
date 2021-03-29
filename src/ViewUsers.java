import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JEditorPane;
import javax.swing.ImageIcon;

public class ViewUsers {

	private JFrame frmImperialViewUsers;

	
	private JTextField fname;
	private JTextField lname;
	private JTextField user;
	private JTextField pass;
	private JTable client;
	private JTextField fname1;
	private JTextField lname1;
	private JTextField user1;
	private JTextField pass1;
	private JTable admin1;
	private JTextField find1;
	private JTextField find2;
     private JComboBox position;
     private JComboBox position1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewUsers window = new ViewUsers();
					window.frmImperialViewUsers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Users use=new Users();
	Users use2=new Users();
	private JTextField id;


	private JLabel result;


	private JLabel fnameerr;


	private JLabel lnameerr;


	private JLabel positionerr;


	private JLabel usererr;


	private JLabel passerr;
	private JTextField id1;


	private JLabel fnameerr1;


	private JLabel lnameerr1;


	private JLabel positionerr1;


	private JLabel usererr1;


	private JLabel passerr1;
	public ViewUsers() {
		
		initialize();
	
		
		use.filladminJTable(admin1,"");
		use2.fillclientJTable(client,"");
		
		id = new JTextField();
		id.setEditable(false);
		id.setBackground(new Color(255, 204, 102));
		id.setColumns(10);
		id.setBounds(94, 45, 57, 20);
		frmImperialViewUsers.getContentPane().add(id);
		
		JLabel lblid = new JLabel("ID");
		lblid.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblid.setBounds(10, 45, 74, 14);
		frmImperialViewUsers.getContentPane().add(lblid);
		
		JLabel label = new JLabel("ID");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 339, 74, 14);
		frmImperialViewUsers.getContentPane().add(label);
		
		id1 = new JTextField();
		id1.setEditable(false);
		id1.setColumns(10);
		id1.setBackground(new Color(255, 204, 102));
		id1.setBounds(94, 337, 57, 20);
		frmImperialViewUsers.getContentPane().add(id1);
		
		 fnameerr1 = new JLabel("*");
		fnameerr1.setForeground(Color.RED);
		fnameerr1.setBackground(Color.WHITE);
		fnameerr1.setBounds(214, 371, 130, 14);
		frmImperialViewUsers.getContentPane().add(fnameerr1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 341, 603);
		frmImperialViewUsers.getContentPane().add(panel);
		
		JButton button = new JButton("Refresh");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialViewUsers.dispose();
				ViewUsers as = new ViewUsers();
				as.main(null);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-view-refresh-icon.png"));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(new Color(165, 42, 42));
		button.setBounds(768, 49, 106, 23);
		frmImperialViewUsers.getContentPane().add(button);
		
		JButton button_1 = new JButton("Refresh");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialViewUsers.dispose();
				ViewUsers as = new ViewUsers();
				as.main(null);
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-view-refresh-icon.png"));
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBackground(new Color(165, 42, 42));
		button_1.setBounds(768, 325, 106, 23);
		frmImperialViewUsers.getContentPane().add(button_1);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
	
	
	
 	private void initialize() {
		frmImperialViewUsers = new JFrame();
		frmImperialViewUsers.setTitle("IMPERIAL- View Users");
		frmImperialViewUsers.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		});
		frmImperialViewUsers.getContentPane().setBackground(new Color(255, 255, 255));
		frmImperialViewUsers.setBounds(100, 100, 966, 679);
		frmImperialViewUsers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImperialViewUsers.getContentPane().setLayout(null);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Go-back-icon.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialViewUsers.dispose();
				Users as = new Users();
				as.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.setBounds(801, 0, 89, 23);
		frmImperialViewUsers.getContentPane().add(btnBack);
		
	
	
		
		JLabel lblNewLabel = new JLabel("First Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(10, 79, 74, 14);
		frmImperialViewUsers.getContentPane().add(lblNewLabel);
		
		fname = new JTextField();
		fname.setBounds(94, 76, 119, 20);
		frmImperialViewUsers.getContentPane().add(fname);
		fname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(10, 110, 74, 14);
		frmImperialViewUsers.getContentPane().add(lblNewLabel_1);
		
		lname = new JTextField();
		lname.setBounds(94, 107, 119, 20);
		frmImperialViewUsers.getContentPane().add(lname);
		lname.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Position");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(10, 141, 74, 14);
		frmImperialViewUsers.getContentPane().add(lblNewLabel_2);
		
		user = new JTextField();
		user.setBounds(94, 169, 119, 20);
		frmImperialViewUsers.getContentPane().add(user);
		user.setColumns(10);
		
		pass = new JTextField();
		pass.setBounds(94, 200, 119, 20);
		frmImperialViewUsers.getContentPane().add(pass);
		pass.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-document-edit-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (id.getText().trim().isEmpty())
				{
					id.setText("0");     
				}
				
				if (fname.getText().trim().isEmpty())
				{
					fnameerr.setText("*First Name is required");     
				}
				
				if (lname.getText().trim().isEmpty())
				{
					lnameerr.setText("*Last Name is required");     
				}
				
				if (((String) position.getSelectedItem()).trim().isEmpty())
				{
					positionerr.setText("*Position is required");     
				}
				
				if (user.getText().trim().isEmpty())
				{
					usererr.setText("*Username is required");     
				}
				
				if (pass.getText().trim().isEmpty())
				{
					passerr.setText("*Password is required");     
				}
				
				
				else {
					String pass1=pass.getText();
					if (pass1.length() >=6 && pass1.length() <=9)
					{
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="UPDATE `admin` SET `id`='"+id.getText()+"',`fname`='"+fname.getText()+"',`lname`='"+lname.getText()+"',`position`='"+position.getSelectedItem()+"',`username`='"+user.getText()+"',`password`='"+pass.getText()+"' WHERE `id`='"+id.getText()+"'";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "User record updated");
				frmImperialViewUsers.dispose();
				ViewUsers as = new ViewUsers();
				as.main(null);
				
					
				    
				con.close();
				}
				    
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			
				}
					else {
						passerr.setText("*Password must have 6-9 characters");
					}
				}
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(0, 128, 0));
		btnNewButton.setBounds(35, 244, 116, 23);
		frmImperialViewUsers.getContentPane().add(btnNewButton);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Delete-icon.png"));
		btnDelete.addActionListener(new ActionListener() {
			private String title;

			public void actionPerformed(ActionEvent e) {
				if (id.getText().trim().isEmpty())
				{
					id.setText("0");     
				}
				
				if (fname.getText().trim().isEmpty())
				{
					fnameerr.setText("*First Name is required");     
				}
				
				if (lname.getText().trim().isEmpty())
				{
					lnameerr.setText("*Last Name is required");     
				}
				
				if (((String) position.getSelectedItem()).trim().isEmpty())
				{
					positionerr.setText("*Position is required");     
				}
				
				if (user.getText().trim().isEmpty())
				{
					usererr.setText("*Username is required");     
				}
				
				if (pass.getText().trim().isEmpty())
				{
					passerr.setText("*Password is required");     
				}
				
				
				else {
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="DELETE FROM admin WHERE id="+id.getText();
				
				int reply =JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this record?", title, JOptionPane.YES_NO_OPTION);
				 if (reply == JOptionPane.YES_OPTION) {
					 stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "User record is deleted");
						frmImperialViewUsers.dispose();
						ViewUsers as = new ViewUsers();
						as.main(null);
				 }
				 else 
				 {
					
				 }
				
				
					
				    
				con.close();
				}
				    
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			}
			}
		});
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setBackground(Color.RED);
		btnDelete.setBounds(151, 244, 109, 23);
		frmImperialViewUsers.getContentPane().add(btnDelete);
		
		JLabel lblNewLabel_3 = new JLabel("Username");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_3.setBounds(10, 172, 74, 14);
		frmImperialViewUsers.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 =  new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_4.setBounds(10, 203, 74, 14);
		frmImperialViewUsers.getContentPane().add(lblNewLabel_4);
		
		 position = new JComboBox();
		position.setModel(new DefaultComboBoxModel(new String[] {"", "IT Manager", "Receptionist", "Hotel Manager"}));
		position.setToolTipText("\r\nIT Manager\r\nReceptionist");
		position.setBounds(94, 138, 119, 20);
		frmImperialViewUsers.getContentPane().add(position);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		scrollPane_1.setBounds(346, 354, 563, 199);
		frmImperialViewUsers.getContentPane().add(scrollPane_1);
		
		client = new JTable();
		scrollPane_1.setViewportView(client);
		
		JLabel lblNewLabel_5 = new JLabel("Admin Data");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_5.setBounds(24, 20, 159, 14);
		frmImperialViewUsers.getContentPane().add(lblNewLabel_5);
		
		JLabel label = new JLabel("First Name");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(10, 371, 74, 14);
		frmImperialViewUsers.getContentPane().add(label);
		
		JLabel lblClientData = new JLabel("Client Data");
		lblClientData.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClientData.setBounds(24, 314, 159, 14);
		frmImperialViewUsers.getContentPane().add(lblClientData);
		
		fname1 = new JTextField();
		fname1.setColumns(10);
		fname1.setBounds(94, 368, 119, 20);
		frmImperialViewUsers.getContentPane().add(fname1);
		
		JLabel label_1 = new JLabel("Last Name");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(10, 402, 74, 14);
		frmImperialViewUsers.getContentPane().add(label_1);
		
		lname1 = new JTextField();
		lname1.setColumns(10);
		lname1.setBounds(94, 399, 119, 20);
		frmImperialViewUsers.getContentPane().add(lname1);
		
		JComboBox position1 = new JComboBox();
		position1.setModel(new DefaultComboBoxModel(new String[] {"", "Receptionist"}));
		position1.setBounds(94, 430, 119, 20);
		frmImperialViewUsers.getContentPane().add(position1);
		
		user1 = new JTextField();
		user1.setColumns(10);
		user1.setBounds(94, 463, 119, 20);
		frmImperialViewUsers.getContentPane().add(user1);
		
		pass1 = new JTextField();
		pass1.setColumns(10);
		pass1.setBounds(94, 494, 119, 20);
		frmImperialViewUsers.getContentPane().add(pass1);
		
		JLabel label_2 = new JLabel("Position");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(10, 433, 74, 14);
		frmImperialViewUsers.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Username");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(10, 466, 74, 14);
		frmImperialViewUsers.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Password");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(10, 497, 74, 14);
		frmImperialViewUsers.getContentPane().add(label_4);
		
		JButton button = new JButton("Update");
		button.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-document-edit-icon.png"));
		button.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				if (id1.getText().trim().isEmpty())
				{
					id1.setText("0");     
				}
				
				if (fname1.getText().trim().isEmpty())
				{
					fnameerr1.setText("*First Name is required");     
				}
				
				if (lname1.getText().trim().isEmpty())
				{
					lnameerr1.setText("*Last Name is required");     
				}
				
				if (((String) position1.getSelectedItem()).trim().isEmpty())
				{
					positionerr1.setText("*Position is required");     
				}
				
				if (user1.getText().trim().isEmpty())
				{
					usererr1.setText("*Username is required");     
				}
				
				if (pass1.getText().trim().isEmpty())
				{
					passerr1.setText("*Password is required");     
				}
				
				
				else {
					String pass2=pass1.getText();
					if (pass2.length() >=6 && pass2.length() <=9) 
					{
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="UPDATE `client` SET `id`='"+id1.getText()+"',`fname`='"+fname1.getText()+"',`lname`='"+lname1.getText()+"',`position`='"+position1.getSelectedItem()+"',`username`='"+user1.getText()+"',`password`='"+pass1.getText()+"' WHERE `id`='"+id1.getText()+"'";
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "User record updated");
				frmImperialViewUsers.dispose();
				ViewUsers as = new ViewUsers();
				as.main(null);
				
				
				    
				con.close();
				}
				    
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			
				}
					else {
						passerr1.setText("*Password must have 6-9 characters");
					}
			}
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(0, 128, 0));
		button.setBounds(35, 536, 103, 23);
		frmImperialViewUsers.getContentPane().add(button);
		
		JButton button_1 = new JButton("Delete");
		button_1.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Delete-icon.png"));
		button_1.addActionListener(new ActionListener() {
			private String title;

			public void actionPerformed(ActionEvent e) {
				if (id1.getText().trim().isEmpty())
				{
					id1.setText("0");     
				}
				
				if (fname1.getText().trim().isEmpty())
				{
					fnameerr1.setText("*First Name is required");     
				}
				
				if (lname1.getText().trim().isEmpty())
				{
					lnameerr1.setText("*Last Name is required");     
				}
				
				if (((String) position1.getSelectedItem()).trim().isEmpty())
				{
					positionerr1.setText("*Position is required");     
				}
				
				if (user1.getText().trim().isEmpty())
				{
					usererr1.setText("*Username is required");     
				}
				
				if (pass1.getText().trim().isEmpty())
				{
					passerr1.setText("*Password is required");     
				}
				
				
				else {
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="DELETE FROM client WHERE id="+id1.getText();
				
				int reply2 =JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this record?", title, JOptionPane.YES_NO_OPTION);
				 if (reply2 == JOptionPane.YES_OPTION) {
					 stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "User record is deleted");
						frmImperialViewUsers.dispose();
						ViewUsers as = new ViewUsers();
						as.main(null);
				 }
				 else 
				 {
					 
				 }
				
				
					
				    
				con.close();
				}
				    
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			}
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(Color.RED);
		button_1.setBounds(137, 536, 96, 23);
		frmImperialViewUsers.getContentPane().add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(340, 0, 610, 34);
		frmImperialViewUsers.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 603, 950, 37);
		frmImperialViewUsers.getContentPane().add(panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(346, 79, 563, 199);
		frmImperialViewUsers.getContentPane().add(scrollPane);
		
		admin1 = new JTable();
		scrollPane.setViewportView(admin1);
		
		find1 = new JTextField();
		find1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});
		find1.setBounds(457, 50, 180, 20);
		frmImperialViewUsers.getContentPane().add(find1);
		find1.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Enter Value");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_6.setBounds(373, 53, 74, 14);
		frmImperialViewUsers.getContentPane().add(lblNewLabel_6);
		
		JButton Find = new JButton("View");
		Find.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Zoom-icon.png"));
		Find.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				admin1.setModel(new DefaultTableModel(null,new Object[] {"id","fname","lname","position","username","password"}));
				use.filladminJTable(admin1, find1.getText());
			}
		});
		Find.setBounds(654, 49, 103, 23);
		frmImperialViewUsers.getContentPane().add(Find);
		
		JLabel label_5 = new JLabel("Enter Value");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(373, 329, 74, 14);
		frmImperialViewUsers.getContentPane().add(label_5);
		
		find2 = new JTextField();
		find2.setColumns(10);
		find2.setBounds(457, 326, 180, 20);
		frmImperialViewUsers.getContentPane().add(find2);
		
		JButton Findit = new JButton("View");
		Findit.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Zoom-icon.png"));
		Findit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.setModel(new DefaultTableModel(null,new Object[] {"id","fname","lname","position","username","password"}));
				use.fillclientJTable(client, find2.getText());
			}
		});
		Findit.setBounds(654, 325, 103, 23);
		frmImperialViewUsers.getContentPane().add(Findit);
		
		 fnameerr = new JLabel("*");
		fnameerr.setForeground(new Color(255, 0, 0));
		fnameerr.setBackground(new Color(255, 255, 255));
		fnameerr.setBounds(214, 79, 130, 14);
		frmImperialViewUsers.getContentPane().add(fnameerr);
		
		 lnameerr = new JLabel("*");
		lnameerr.setForeground(new Color(255, 0, 0));
		lnameerr.setBounds(214, 107, 130, 14);
		frmImperialViewUsers.getContentPane().add(lnameerr);
		
		 positionerr = new JLabel("*");
		positionerr.setForeground(new Color(255, 0, 0));
		positionerr.setBounds(214, 141, 130, 14);
		frmImperialViewUsers.getContentPane().add(positionerr);
		
		 usererr = new JLabel("*");
		usererr.setForeground(new Color(255, 0, 0));
		usererr.setBounds(214, 172, 130, 14);
		frmImperialViewUsers.getContentPane().add(usererr);
		
		 passerr = new JLabel("*");
		passerr.setForeground(new Color(255, 0, 0));
		passerr.setBounds(214, 203, 130, 14);
		frmImperialViewUsers.getContentPane().add(passerr);
		
		lnameerr1 = new JLabel("*");
		lnameerr1.setForeground(new Color(255, 0, 0));
		lnameerr1.setBounds(214, 402, 130, 14);
		frmImperialViewUsers.getContentPane().add(lnameerr1);
		
		 positionerr1 = new JLabel("*");
		positionerr1.setForeground(new Color(255, 0, 0));
		positionerr1.setBounds(214, 433, 130, 14);
		frmImperialViewUsers.getContentPane().add(positionerr1);
		
		 usererr1 = new JLabel("*");
		usererr1.setForeground(new Color(255, 0, 0));
		usererr1.setBounds(214, 466, 130, 14);
		frmImperialViewUsers.getContentPane().add(usererr1);
		
		 passerr1 = new JLabel("*");
		passerr1.setForeground(new Color(255, 0, 0));
		passerr1.setBounds(214, 497, 130, 14);
		frmImperialViewUsers.getContentPane().add(passerr1);
		
	    result = new JLabel("");
	    result.setFont(new Font("Tahoma", Font.BOLD, 11));
	    result.setForeground(Color.RED);
		result.setBounds(10, 278, 159, 14);
		frmImperialViewUsers.getContentPane().add(result);
		admin1.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {            //VALUES SHOWS IN FIELDBOXES WHEN SELECTING RECORDS ON JTABLE
				int rowIndex=admin1.getSelectedRow();
				DefaultTableModel model=(DefaultTableModel)admin1.getModel();
				id.setText(model.getValueAt(rowIndex, 0).toString());
				fname.setText(model.getValueAt(rowIndex, 1).toString());
				lname.setText(model.getValueAt(rowIndex, 2).toString());
			position.setSelectedItem(model.getValueAt(rowIndex, 3).toString());
			user.setText(model.getValueAt(rowIndex, 4).toString());
			pass.setText(model.getValueAt(rowIndex, 5).toString());
			}
		});
client.addMouseListener(new MouseAdapter() {
			

			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex=client.getSelectedRow();
				DefaultTableModel model=(DefaultTableModel)client.getModel();
				id1.setText(model.getValueAt(rowIndex, 0).toString());
				fname1.setText(model.getValueAt(rowIndex, 1).toString());
				lname1.setText(model.getValueAt(rowIndex, 2).toString());
			position1.setSelectedItem(model.getValueAt(rowIndex, 3).toString());
			user1.setText(model.getValueAt(rowIndex, 4).toString());
			pass1.setText(model.getValueAt(rowIndex, 5).toString());
			}
		});
		
		
	}
}
