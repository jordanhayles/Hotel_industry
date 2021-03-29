import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;

public class Customers extends JDialog {

	private JFrame frmImperialCustomers;
	private JTextField custid;
	private JTextField fname;
	private JTextField mint;
	private JTextField lname;
	private JTextField add;
	private JTextField pnum;
	private JLabel iderr;
	private JLabel fnamerr;
	private JLabel mierr;
	private JLabel lnamerr;
	private JLabel adderr;
	private JLabel pnumerr;
	private JLabel generr;
	private JComboBox numofa;
	private JComboBox numofc;
	private JComboBox nationbox;
	private JLabel enation;
	private JLabel echildren;
	private JLabel eadults;
	private JComboBox gender;
	private JTextField find;
	private JTable customers;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customers window = new Customers();
					window.frmImperialCustomers.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Customers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImperialCustomers = new JFrame();
		frmImperialCustomers.setTitle("IMPERIAL- Customers");
		frmImperialCustomers.getContentPane().setBackground(new Color(255, 255, 255));
		frmImperialCustomers.setBounds(100, 100, 1187, 493);
		frmImperialCustomers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImperialCustomers.getContentPane().setLayout(null);
		
		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCustomerId.setForeground(new Color(0, 0, 0));
		lblCustomerId.setBackground(new Color(255, 255, 255));
		lblCustomerId.setBounds(0, 42, 83, 14);
		frmImperialCustomers.getContentPane().add(lblCustomerId);
		
		custid = new JTextField();
		custid.setBackground(new Color(240, 230, 140));
		custid.setEditable(false);
		custid.setBounds(108, 39, 86, 20);
		frmImperialCustomers.getContentPane().add(custid);
		custid.setColumns(10);
		
		fname = new JTextField();
		fname.setBounds(108, 70, 86, 20);
		frmImperialCustomers.getContentPane().add(fname);
		fname.setColumns(10);
		
		JLabel lblfn = new JLabel("First Name");
		lblfn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblfn.setForeground(new Color(0, 0, 0));
		lblfn.setBounds(0, 73, 68, 14);
		frmImperialCustomers.getContentPane().add(lblfn);
		
		JLabel lblmi = new JLabel("Middle Intial");
		lblmi.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblmi.setForeground(new Color(0, 0, 0));
		lblmi.setBounds(0, 104, 73, 14);
		frmImperialCustomers.getContentPane().add(lblmi);
		
		mint = new JTextField();
		mint.setBounds(108, 101, 86, 20);
		frmImperialCustomers.getContentPane().add(mint);
		mint.setColumns(10);
		
		lname = new JTextField();
		lname.setBounds(108, 132, 86, 20);
		frmImperialCustomers.getContentPane().add(lname);
		lname.setColumns(10);
		
		JLabel lblln = new JLabel("Last Name");
		lblln.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblln.setForeground(new Color(0, 0, 0));
		lblln.setBounds(0, 132, 83, 20);
		frmImperialCustomers.getContentPane().add(lblln);
		
		JButton btnEnter = new JButton("Add");
		btnEnter.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Add-icon.png"));
		btnEnter.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnEnter.setForeground(new Color(255, 255, 255));
		btnEnter.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent arg0) {
				if (custid.getText().trim().isEmpty())
				{
			
				iderr.setText("*Customer ID Field is empty");
				}
				
				if (fname.getText().trim().isEmpty())
				{
					fnamerr.setText("*First Name Field is empty");
				}
				{
				if(mint.getText().trim().isEmpty())
					
					mierr.setText("*Middle Intial Field is empty.");
				}
				if(lname.getText().trim().isEmpty())
				{
						lnamerr.setText("*Last Name Field is empty.");
				}
				if(add.getText().trim().isEmpty())
				{
					adderr.setText("*Address Field is empty.");
				}
				if(pnum.getText().trim().isEmpty())
				{	
					pnumerr.setText("*Phone Number Field is empty.");
				}
				if (((String) gender.getSelectedItem()).trim().isEmpty())
				{	
					generr.setText("*No Gender was selected.");
				}
				if (((String) nationbox.getSelectedItem()).trim().isEmpty())
				{
					enation.setText("*Nationality is required");     
				}
				if (((String) numofa.getSelectedItem()).trim().isEmpty())
				{
					eadults.setText("*Number of adults are required");     
				}
				if (((String) numofc.getSelectedItem()).trim().isEmpty())
				{
					echildren.setText("*Number of children are required");     
				}
				
				else {
					
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Imperial","root","");
				Statement stmt=con.createStatement();
				String sql="insert into customers_info (fname,mname,lname,address,gender,pnum,nation,numofa,numofc) values('"+fname.getText()+"','"+mint.getText()+"','"+lname.getText()+"','"+add.getText()+"','"+gender.getSelectedItem()+"','"+pnum.getText()+"','"+nationbox.getSelectedItem()+"','"+numofa.getSelectedItem()+"','"+numofc.getSelectedItem()+"')";
				
				
				stmt.executeUpdate(sql);
				
				JOptionPane.showMessageDialog(null, "Customer record inserted");
				frmImperialCustomers.dispose();
				Customers as = new Customers();
				as.main(null);
					
					
				    
				con.close();
				}
				    
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
					}
			}
			
		});
		btnEnter.setBackground(new Color(50, 205, 50));
		btnEnter.setBounds(17, 333, 89, 23);
		frmImperialCustomers.getContentPane().add(btnEnter);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Go-back-icon.png"));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialCustomers.dispose();
				Menu as = new Menu();
				as.main(null);
				
			}
		});
		btnBack.setBackground(new Color(165, 42, 42));
		btnBack.setBounds(154, 333, 89, 23);
		frmImperialCustomers.getContentPane().add(btnBack);
		
		JPanel panel = new JPanel();
		panel.setBounds(502, 15, -103, 44);
		frmImperialCustomers.getContentPane().add(panel);
		
		JLabel lblHotelName = new JLabel("Hotel Name:");
		lblHotelName.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\hotel.png"));
		lblHotelName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblHotelName.setBounds(17, 0, 321, 14);
		frmImperialCustomers.getContentPane().add(lblHotelName);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You're Logged Out");
				frmImperialCustomers.dispose();
				Login as = new Login();
				as.main(null);
			}
		});
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(new Color(0, 128, 128));
		btnLogOut.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Log-Off-icon.png"));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLogOut.setBounds(1050, 0, 111, 26);
		frmImperialCustomers.getContentPane().add(btnLogOut);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 0, 1171, 30);
		frmImperialCustomers.getContentPane().add(panel_1);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Users-Name-icon.png"));
		panel_1.add(lblUser);
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lbladd = new JLabel("Address");
		lbladd.setFont(new Font("Tahoma", Font.BOLD, 11));
		lbladd.setForeground(new Color(0, 0, 0));
		lbladd.setBounds(0, 163, 83, 19);
		frmImperialCustomers.getContentPane().add(lbladd);
		
		add = new JTextField();
		add.setBounds(108, 160, 173, 20);
		frmImperialCustomers.getContentPane().add(add);
		add.setColumns(10);
		
		JLabel lblgen = new JLabel("Gender");
		lblgen.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblgen.setForeground(new Color(0, 0, 0));
		lblgen.setBounds(0, 193, 90, 14);
		frmImperialCustomers.getContentPane().add(lblgen);
		
		JLabel lblpn = new JLabel("Phone Number");
		lblpn.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblpn.setForeground(new Color(0, 0, 0));
		lblpn.setBounds(0, 219, 90, 14);
		frmImperialCustomers.getContentPane().add(lblpn);
		
		pnum = new JTextField();
		pnum.setBounds(108, 216, 86, 20);
		frmImperialCustomers.getContentPane().add(pnum);
		pnum.setColumns(10);
		
		JLabel lblnat = new JLabel("Nationality");
		lblnat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnat.setForeground(new Color(0, 0, 0));
		lblnat.setBounds(0, 244, 136, 14);
		frmImperialCustomers.getContentPane().add(lblnat);
		
		JButton btnView = new JButton("View");
		btnView.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Zoom-icon.png"));
		btnView.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnView.setForeground(new Color(255, 255, 255));
		btnView.setBackground(new Color(0, 128, 0));
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				customers.setModel(new DefaultTableModel(null,new Object[] {"Customer ID","First Name","Middle Name","Last Name","Address","Gender","Phone Number", "Nationiality","Number of Adults","Number of Children"}));
				fillcustomersJTable(customers, find.getText());
			}
		});
		btnView.setBounds(819, 47, 89, 23);
		frmImperialCustomers.getContentPane().add(btnView);
		
		iderr = new JLabel("*");
		iderr.setForeground(Color.RED);
		iderr.setBounds(281, 42, 211, 14);
		frmImperialCustomers.getContentPane().add(iderr);
		
		fnamerr = new JLabel("*");
		fnamerr.setForeground(Color.RED);
		fnamerr.setBounds(281, 73, 316, 14);
		frmImperialCustomers.getContentPane().add(fnamerr);
		
		mierr = new JLabel("*");
		mierr.setForeground(Color.RED);
		mierr.setBounds(281, 107, 255, 14);
		frmImperialCustomers.getContentPane().add(mierr);
		
		lnamerr = new JLabel("*");
		lnamerr.setForeground(Color.RED);
		lnamerr.setBounds(281, 135, 255, 14);
		frmImperialCustomers.getContentPane().add(lnamerr);
		
		adderr = new JLabel("*");
		adderr.setForeground(Color.RED);
		adderr.setBounds(281, 163, 191, 14);
		frmImperialCustomers.getContentPane().add(adderr);
		
		pnumerr = new JLabel("*");
		pnumerr.setForeground(Color.RED);
		pnumerr.setBounds(281, 219, 255, 14);
		frmImperialCustomers.getContentPane().add(pnumerr);
		
		JLabel lblnoa = new JLabel("Number of Adults");
		lblnoa.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnoa.setForeground(new Color(0, 0, 0));
		lblnoa.setBounds(0, 269, 106, 14);
		frmImperialCustomers.getContentPane().add(lblnoa);
		
		JLabel lblnoc = new JLabel("Number of Children");
		lblnoc.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblnoc.setToolTipText("\r\n1\r\n2\r\n3\r\n4\r\n5\r\n6\r\n7\r\n8\r\n9\r\n10");
		lblnoc.setForeground(new Color(0, 0, 0));
		lblnoc.setBounds(0, 294, 136, 14);
		frmImperialCustomers.getContentPane().add(lblnoc);
		
		 enation = new JLabel("*");
		enation.setForeground(Color.RED);
		enation.setBounds(281, 244, 268, 14);
		frmImperialCustomers.getContentPane().add(enation);
		
	    echildren = new JLabel("*");
		echildren.setForeground(Color.RED);
		echildren.setBounds(281, 294, 191, 14);
		frmImperialCustomers.getContentPane().add(echildren);
		
	    eadults = new JLabel("*");
		eadults.setForeground(Color.RED);
		eadults.setBounds(281, 269, 239, 14);
		frmImperialCustomers.getContentPane().add(eadults);
		
		JList list = new JList();
		list.setBounds(126, 282, 1, 1);
		frmImperialCustomers.getContentPane().add(list);
		
		numofa = new JComboBox();
		numofa.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		numofa.setBounds(108, 265, 46, 22);
		frmImperialCustomers.getContentPane().add(numofa);
		
		numofc = new JComboBox();
		numofc.setModel(new DefaultComboBoxModel(new String[] {"", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		numofc.setBounds(108, 291, 46, 20);
		frmImperialCustomers.getContentPane().add(numofc);
		
		nationbox = new JComboBox();
		nationbox.setModel(new DefaultComboBoxModel(new String[] {"", "American", "Barbadian", "Bahmainan", "Canadian", "English", "German", "Grenadain", "Hatian", "Jamaican", "Trinidardian"}));
		nationbox.setBounds(108, 240, 135, 22);
		frmImperialCustomers.getContentPane().add(nationbox);
		
		generr = new JLabel("*");
		generr.setForeground(Color.RED);
		generr.setBounds(281, 191, 265, 14);
		frmImperialCustomers.getContentPane().add(generr);
		
		gender = new JComboBox();
		gender.setModel(new DefaultComboBoxModel(new String[] {"", "Male", "Female"}));
		gender.setBounds(108, 185, 135, 22);
		frmImperialCustomers.getContentPane().add(gender);
		
		find = new JTextField();
		find.setColumns(10);
		find.setBounds(568, 48, 241, 20);
		frmImperialCustomers.getContentPane().add(find);
		
		JLabel lblEnterValue = new JLabel("Enter Value");
		lblEnterValue.setBackground(new Color(255, 255, 255));
		lblEnterValue.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblEnterValue.setForeground(new Color(0, 0, 0));
		lblEnterValue.setBounds(477, 51, 94, 14);
		frmImperialCustomers.getContentPane().add(lblEnterValue);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(211, 211, 211));
		scrollPane.setBounds(459, 84, 702, 344);
		frmImperialCustomers.getContentPane().add(scrollPane);
		
		customers = new JTable();
		scrollPane.setViewportView(customers);
		customers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex=customers.getSelectedRow();
				DefaultTableModel model=(DefaultTableModel)customers.getModel();
				custid.setText(model.getValueAt(rowIndex, 0).toString());
				fname.setText(model.getValueAt(rowIndex, 1).toString());
				mint.setText(model.getValueAt(rowIndex, 2).toString());
				lname.setText(model.getValueAt(rowIndex, 3).toString());
			add.setText(model.getValueAt(rowIndex, 4).toString());
			gender.setSelectedItem(model.getValueAt(rowIndex, 5).toString());
			pnum.setText(model.getValueAt(rowIndex, 6).toString());
			nationbox.setSelectedItem(model.getValueAt(rowIndex, 7).toString());
			numofa.setSelectedItem(model.getValueAt(rowIndex, 8).toString());
			numofc.setSelectedItem(model.getValueAt(rowIndex, 9).toString());
			}
		});
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBounds(0, 427, 1171, 30);
		frmImperialCustomers.getContentPane().add(panel_2);
		
		JLabel lblCopyright = new JLabel("Copyright 2019");
		panel_2.add(lblCopyright);
		lblCopyright.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel lblAvaDesignsLtd = new JLabel("AVA Designs Ltd");
		panel_2.add(lblAvaDesignsLtd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-document-edit-icon.png"));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (custid.getText().trim().isEmpty())
				{
			
				iderr.setText("*Customer ID Field is empty");
				}
				
				if (fname.getText().trim().isEmpty())
				{
					fnamerr.setText("*First Name Field is empty");
				}
				{
				if(mint.getText().trim().isEmpty())
					
					mierr.setText("*Middle Intial Field is empty.");
				}
				if(lname.getText().trim().isEmpty())
				{
						lnamerr.setText("*Last Name Field is empty.");
				}
				if(add.getText().trim().isEmpty())
				{
					adderr.setText("*Address Field is empty.");
				}
				if(pnum.getText().trim().isEmpty())
				{	
					pnumerr.setText("*Phone Number Field is empty.");
				}
				if (((String) gender.getSelectedItem()).trim().isEmpty())
				{	
					generr.setText("*No Gender was selected.");
				}
				if (((String) nationbox.getSelectedItem()).trim().isEmpty())
				{
					enation.setText("*Nationality is required");     
				}
				if (((String) numofa.getSelectedItem()).trim().isEmpty())
				{
					eadults.setText("*Number of adults are required");     
				}
				if (((String) numofc.getSelectedItem()).trim().isEmpty())
				{
					echildren.setText("*Number of children are required");     
				}
				
				else {
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="UPDATE `customers_info` SET `custid`='"+custid.getText()+"',`fname`='"+fname.getText()+"',`mname`='"+mint.getText()+"',`lname`='"+lname.getText()+"',`address`='"+add.getText()+"',`gender`='"+gender.getSelectedItem()+"',`pnum`='"+pnum.getText()+"',`nation`='"+nationbox.getSelectedItem()+"',`numofa`='"+numofa.getSelectedItem()+"',`numofc`='"+numofc.getSelectedItem()+"' WHERE `custid`='"+custid.getText()+"'";
				
				stmt.executeUpdate(sql);
			
				
				JOptionPane.showMessageDialog(null, "Room record updated");
				frmImperialCustomers.dispose();
				Customers as = new Customers();
				as.main(null);
				
				    
				con.close();
				}
				    
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			
				}
		
			}
		});
		btnUpdate.setBackground(new Color(255, 165, 0));
		btnUpdate.setBounds(17, 367, 110, 23);
		frmImperialCustomers.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Delete-icon.png"));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.addActionListener(new ActionListener() {
			private String title;

			public void actionPerformed(ActionEvent e) {
				if (custid.getText().trim().isEmpty())
				{
			
				iderr.setText("*Customer ID Field is empty");
				}
				
				if (fname.getText().trim().isEmpty())
				{
					fnamerr.setText("*First Name Field is empty");
				}
				{
				if(mint.getText().trim().isEmpty())
					
					mierr.setText("*Middle Intial Field is empty.");
				}
				if(lname.getText().trim().isEmpty())
				{
						lnamerr.setText("*Last Name Field is empty.");
				}
				if(add.getText().trim().isEmpty())
				{
					adderr.setText("*Address Field is empty.");
				}
				if(pnum.getText().trim().isEmpty())
				{	
					pnumerr.setText("*Phone Number Field is empty.");
				}
				if (((String) gender.getSelectedItem()).trim().isEmpty())
				{	
					generr.setText("*No Gender was selected.");
				}
				if (((String) nationbox.getSelectedItem()).trim().isEmpty())
				{
					enation.setText("*Nationality is required");     
				}
				if (((String) numofa.getSelectedItem()).trim().isEmpty())
				{
					eadults.setText("*Number of adults are required");     
				}
				if (((String) numofc.getSelectedItem()).trim().isEmpty())
				{
					echildren.setText("*Number of children are required");     
				}
				
				else {
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="DELETE FROM customers_info WHERE custid="+custid.getText();
				
				int reply =JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this record?", title, JOptionPane.YES_NO_OPTION);
				 if (reply == JOptionPane.YES_OPTION) {
					 stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Customer record is deleted");
						frmImperialCustomers.dispose();
						Customers as = new Customers();
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
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setBounds(154, 367, 106, 23);
		frmImperialCustomers.getContentPane().add(btnDelete);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 191, 255));
		panel_3.setBounds(-1, 25, 460, 403);
		frmImperialCustomers.getContentPane().add(panel_3);
		
		JButton btnRefresh = new JButton("Refresh");
		btnRefresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialCustomers.dispose();
				Customers as = new Customers();
				as.main(null);
			}
		});
		btnRefresh.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-view-refresh-icon.png"));
		btnRefresh.setForeground(Color.WHITE);
		btnRefresh.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnRefresh.setBackground(new Color(165, 42, 42));
		btnRefresh.setBounds(921, 47, 106, 23);
		frmImperialCustomers.getContentPane().add(btnRefresh);
	}
	public void fillcustomersJTable(JTable customers, String find) {
		// TODO Auto-generated method stub
		try { Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
		PreparedStatement ps;
		ps=con.prepareStatement("SELECT * FROM `customers_info` WHERE CONCAT (`custid`,`fname`,`mname`,`lname`,`address`,`gender`,`pnum`,`nation`,`numofa`,`numofc`) LIKE ?"); //Search for rooms
		ps.setString(1, "%"+find+"%");
		ResultSet rs=ps.executeQuery();
		DefaultTableModel model=(DefaultTableModel)customers.getModel();
		Object[]row;
		while(rs.next())
		{
			row=new Object[10];
			row[0]=rs.getInt(1);
			row[1]=rs.getString(2);
			row[2]=rs.getString(3);
			row[3]=rs.getString(4);
			row[4]=rs.getString(5);
			row[5]=rs.getString(6);
			row[6]=rs.getInt(7);
			row[7]=rs.getString(8);
			row[8]=rs.getInt(9);
			row[9]=rs.getInt(10);
			
			
			model.addRow(row);
		}
		
		con.close();
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
	}
}
}
