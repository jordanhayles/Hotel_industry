import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.Label;
import java.awt.Window;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTable;

public class Users extends JFrame {

	private JFrame frmImperialUsers;
	private JTextField fname;
	private JTextField lname;
	private JTextField user;
	private JTextField pass;
	private JComboBox acctype;
	private JComboBox position;
	private JLabel fnameerr;
	private JLabel accerr;
	private JLabel lnameerr;
	private JLabel positionerr;
	private JLabel usererr;
	private JLabel passerr;
	private JLabel insert;
	private JTable admin;
   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Users window = new Users();
					window.frmImperialUsers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Users() {
		initialize();

	
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frmImperialUsers = new JFrame();
		frmImperialUsers.setTitle("IMPERIAL- Users");
		frmImperialUsers.getContentPane().setBackground(new Color(248, 248, 255));
		frmImperialUsers.setBounds(100, 100, 700, 419);
		frmImperialUsers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImperialUsers.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("User:");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Users-Name-icon.png"));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(274, 11, 153, 14);
		frmImperialUsers.getContentPane().add(lblNewLabel_1);
		
		JButton button = new JButton("Log Out");
		button.setForeground(new Color(255, 255, 255));
		button.setBackground(new Color(0, 128, 128));
		button.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Log-Off-icon.png"));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You're Logged Out");
				frmImperialUsers.dispose();
				Login as = new Login();
				as.main(null);
				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBounds(567, 7, 109, 26);
		frmImperialUsers.getContentPane().add(button);
		
		JLabel lblHotelName = new JLabel("Hotel Name:");
		lblHotelName.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\hotel.png"));
		lblHotelName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHotelName.setBounds(24, 11, 185, 14);
		frmImperialUsers.getContentPane().add(lblHotelName);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 686, 37);
		frmImperialUsers.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 353, 686, 26);
		frmImperialUsers.getContentPane().add(panel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jordan\\Pictures\\user1.png"));
		lblNewLabel.setBounds(469, 60, 205, 183);
		frmImperialUsers.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("First Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(64, 82, 83, 14);
		frmImperialUsers.getContentPane().add(lblNewLabel_2);
		
		fname = new JTextField();
		fname.setBounds(163, 80, 126, 20);
		frmImperialUsers.getContentPane().add(fname);
		fname.setColumns(10);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Go-back-icon.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialUsers.dispose();
				Menu as = new Menu();
				as.main(null);
			}
		});
		btnNewButton.setBackground(new Color(220, 20, 60));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(165, 264, 97, 23);
		frmImperialUsers.getContentPane().add(btnNewButton);
		
		JButton adduser = new JButton("Add");
		adduser.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Add-icon.png"));
		
		
		
		adduser.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				
				
				if (((String) acctype.getSelectedItem()).trim().isEmpty())
				{
					accerr.setText("*Account Type is required");     
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
				
				else
				{
				String pass1=pass.getText();
				if (pass1.length() >=6 && pass1.length() <=9)
				{
			
					if(((String) acctype.getSelectedItem()).trim().equals("Admin")) 
						{
						
					try { Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
					Statement stmt=con.createStatement();
					String sql="insert into admin (fname,lname,position,username,password) values('"+fname.getText()+"','"+lname.getText()+"','"+position.getSelectedItem()+"','"+user.getText()+"', '"+pass.getText()+"')";
					
					
					stmt.executeUpdate(sql);
					
					JOptionPane.showMessageDialog(null, "User record inserted");
					frmImperialUsers.dispose();
					Users as = new Users();
					as.main(null);
						
						
					    
					con.close();
					}
					    
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
					}
					}
					
						
						
			
					if(((String) acctype.getSelectedItem()).trim().equals("Client"))
					{
						try { Class.forName("com.mysql.jdbc.Driver");
						Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
						Statement stmt2=con2.createStatement();
						String sql2="insert into client (fname,lname,position,username,password) values('"+fname.getText()+"','"+lname.getText()+"','"+position.getSelectedItem()+"','"+user.getText()+"', '"+pass.getText()+"')";
						
						stmt2.executeUpdate(sql2);
						
						
						JOptionPane.showMessageDialog(null, "User record inserted");
						frmImperialUsers.dispose();
						Users as = new Users();
						as.main(null);
							
						   
						con2.close();
						}
						    
						catch(Exception e1) {
							JOptionPane.showMessageDialog(null,e1);
							
						}
						}
					}
				else {
					passerr.setText("*Password must have 6-9 characters");
				}
				
				}
			
		}});
		
		
	
		
		adduser.setBackground(new Color(50, 205, 50));
		adduser.setForeground(new Color(255, 255, 255));
		adduser.setFont(new Font("Tahoma", Font.BOLD, 12));
		adduser.setBounds(64, 264, 89, 23);
		frmImperialUsers.getContentPane().add(adduser);
		
		JButton btnViewUsers = new JButton("View Users");
		btnViewUsers.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Zoom-icon.png"));
		btnViewUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmImperialUsers.dispose();
				ViewUsers as = new ViewUsers();
				as.main(null);
			}
		});
		btnViewUsers.setForeground(new Color(255, 255, 255));
		btnViewUsers.setBackground(new Color(255, 165, 0));
		btnViewUsers.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnViewUsers.setBounds(521, 254, 126, 23);
		frmImperialUsers.getContentPane().add(btnViewUsers);
		
		JLabel lblNewLabel_3 = new JLabel("Last Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(64, 113, 75, 14);
		frmImperialUsers.getContentPane().add(lblNewLabel_3);
		
		lname = new JTextField();
		lname.setBounds(163, 110, 126, 20);
		frmImperialUsers.getContentPane().add(lname);
		lname.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Position");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(64, 148, 62, 14);
		frmImperialUsers.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Username");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(64, 178, 62, 14);
		frmImperialUsers.getContentPane().add(lblNewLabel_5);
		
		user = new JTextField();
		user.setBounds(163, 172, 126, 20);
		frmImperialUsers.getContentPane().add(user);
		user.setColumns(10);
		
		 position = new JComboBox();
		position.setModel(new DefaultComboBoxModel(new String[] {"", "Hotel Manager","IT Manager", "Receptionist"}));
		position.setBounds(163, 141, 126, 20);
		frmImperialUsers.getContentPane().add(position);
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_6.setBounds(64, 209, 62, 14);
		frmImperialUsers.getContentPane().add(lblNewLabel_6);
		
		pass = new JPasswordField();
		pass.setColumns(10);
		pass.setBounds(163, 203, 126, 20);
		frmImperialUsers.getContentPane().add(pass);
		
		JLabel lblAccountType = new JLabel("Account Type");
		lblAccountType.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblAccountType.setBounds(45, 48, 109, 14);
		frmImperialUsers.getContentPane().add(lblAccountType);
		
		 acctype = new JComboBox();
		acctype.setModel(new DefaultComboBoxModel(new String[] {"", "Admin", "Client"}));
		acctype.setToolTipText("");
		acctype.setBounds(163, 48, 126, 20);
		frmImperialUsers.getContentPane().add(acctype);
		
	    accerr = new JLabel("*");
		accerr.setForeground(new Color(255, 0, 0));
		accerr.setBackground(new Color(255, 255, 255));
		accerr.setBounds(295, 49, 164, 14);
		frmImperialUsers.getContentPane().add(accerr);
		
		 fnameerr = new JLabel("*");
		fnameerr.setForeground(new Color(255, 0, 0));
		fnameerr.setBounds(295, 83, 164, 14);
		frmImperialUsers.getContentPane().add(fnameerr);
		
	    lnameerr = new JLabel("*");
		lnameerr.setForeground(new Color(255, 0, 0));
		lnameerr.setBounds(295, 114, 164, 14);
		frmImperialUsers.getContentPane().add(lnameerr);
		
		positionerr = new JLabel("*");
		positionerr.setForeground(new Color(255, 0, 0));
		positionerr.setBounds(295, 144, 164, 14);
		frmImperialUsers.getContentPane().add(positionerr);
		
		 usererr = new JLabel("*");
		usererr.setForeground(new Color(255, 0, 0));
		usererr.setBounds(295, 175, 164, 14);
		frmImperialUsers.getContentPane().add(usererr);
		
		 passerr = new JLabel("*");
		passerr.setForeground(new Color(255, 0, 0));
		passerr.setBounds(295, 203, 164, 14);
		frmImperialUsers.getContentPane().add(passerr);
		
		 insert = new JLabel("");
		insert.setFont(new Font("Tahoma", Font.BOLD, 11));
		insert.setForeground(Color.RED);
		insert.setBounds(45, 326, 164, 14);
		frmImperialUsers.getContentPane().add(insert);
		
		admin = new JTable();
		admin.setBounds(64, 404, 511, 229);
		frmImperialUsers.getContentPane().add(admin);
	}

	public void filladminJTable(JTable admin1, String find) {
		// TODO Auto-generated method stub
		try { Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
		PreparedStatement ps;
		ps=con.prepareStatement("SELECT * FROM `admin` WHERE CONCAT (`id`,`fname`,`lname`,`position`,`username`,`password`) LIKE ?"); //search for admin
		ps.setString(1, "%"+find+"%");
		ResultSet rs=ps.executeQuery();
		DefaultTableModel model=(DefaultTableModel)admin1.getModel();
		Object[]row;
		while(rs.next())
		{
			row=new Object[6];
			row[0]=rs.getInt(1);
			row[1]=rs.getString(2);
			row[2]=rs.getString(3);
			row[3]=rs.getString(4);
			row[4]=rs.getString(5);
			row[5]=rs.getString(6);
			
			model.addRow(row);
		}
		
		con.close();
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
	}
}
	public void fillclientJTable(JTable client, String find1) {
		// TODO Auto-generated method stub
		try { Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
		PreparedStatement ps;    
		ps=con.prepareStatement("SELECT * FROM `client` WHERE CONCAT (`id`,`fname`,`lname`,`position`,`username`,`password`) LIKE ?"); //Search for client
		ps.setString(1, "%"+find1+"%");
		ResultSet rs=ps.executeQuery();
		DefaultTableModel model=(DefaultTableModel)client.getModel();
		Object[]row;
		while(rs.next())
		{
			row=new Object[6];
			row[0]=rs.getInt(1);
			row[1]=rs.getString(2);
			row[2]=rs.getString(3);
			row[3]=rs.getString(4);
			row[4]=rs.getString(5);
			row[5]=rs.getString(6);
			
			model.addRow(row);
		}
		
		con.close();
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
	}
}

	
}
