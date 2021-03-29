import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Window;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

public class Rooms2 extends JFrame{

	private JFrame frmImperialRooms;
	private JTable roomstb;
	private JComboBox status;
	private JLabel etype;
	private JLabel etype2;
	private JLabel estatus;
	private JLabel esuite;
	private JLabel elocation;
	private JComboBox location;
	private JComboBox suite_type;
	private JComboBox room_type2;
	private JComboBox room_type;
	private JLabel lblNewLabel_1;
	private JTextField find;
	private JTextField roomno;
	private JLabel count;
	private JLabel roomnoe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Rooms2 window = new Rooms2();
					window.frmImperialRooms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Rooms2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImperialRooms = new JFrame();
		frmImperialRooms.setTitle("IMPERIAL- Rooms ");
		frmImperialRooms.getContentPane().setBackground(new Color(192, 192, 192));
		frmImperialRooms.setBounds(100, 100, 1000, 532);
		frmImperialRooms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImperialRooms.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Room Type");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(29, 122, 76, 14);
		frmImperialRooms.getContentPane().add(lblNewLabel);
		
		JLabel lblRoomTypeOther = new JLabel("Room Type Other");
		lblRoomTypeOther.setForeground(new Color(255, 255, 255));
		lblRoomTypeOther.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRoomTypeOther.setBounds(29, 174, 115, 14);
		frmImperialRooms.getContentPane().add(lblRoomTypeOther);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(255, 255, 255));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatus.setBounds(29, 224, 46, 14);
		frmImperialRooms.getContentPane().add(lblStatus);
		
		JLabel lblSuite = new JLabel("Suite Type");
		lblSuite.setForeground(new Color(255, 255, 255));
		lblSuite.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSuite.setBounds(29, 271, 76, 14);
		frmImperialRooms.getContentPane().add(lblSuite);
		
		JLabel lblLocation = new JLabel("Location");
		lblLocation.setForeground(new Color(255, 255, 255));
		lblLocation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLocation.setBounds(29, 322, 63, 14);
		frmImperialRooms.getContentPane().add(lblLocation);
		
		 room_type = new JComboBox();
		room_type.setModel(new DefaultComboBoxModel(new String[] {"", "Single", "Double ", "Triple", "Quad", "Queen ", "King", "Twin ", "Double-Double", "Studio"}));
		room_type.setBounds(155, 120, 138, 20);
		frmImperialRooms.getContentPane().add(room_type);
		
		 room_type2 = new JComboBox();
		room_type2.setModel(new DefaultComboBoxModel(new String[] {"", "Connecting Room", "Adjoining Room", "Adjacent  Room", "None"}));
		room_type2.setBounds(154, 172, 138, 20);
		frmImperialRooms.getContentPane().add(room_type2);
		
		status = new JComboBox();
		status.setModel(new DefaultComboBoxModel(new String[] {"", "Available ", "Unavailable "}));
		status.setBounds(155, 222, 138, 20);
		frmImperialRooms.getContentPane().add(status);
		
		 suite_type = new JComboBox();
		suite_type.setModel(new DefaultComboBoxModel(new String[] {"", "Master Suite ", "Mini-Suite ", "None"}));
		suite_type.setBounds(155, 269, 138, 20);
		frmImperialRooms.getContentPane().add(suite_type);
		
		 location = new JComboBox();
		location.setModel(new DefaultComboBoxModel(new String[] {"", "First Floor ", "Second Floor ", "Third Floor", "Fourth Floor ", "Fifth Floor"}));
		location.setBounds(155, 320, 138, 20);
		frmImperialRooms.getContentPane().add(location);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		scrollPane.setBounds(463, 120, 511, 297);
		frmImperialRooms.getContentPane().add(scrollPane);
		
		roomstb = new JTable();
		scrollPane.setViewportView(roomstb);
		roomstb.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex=roomstb.getSelectedRow();
				DefaultTableModel model=(DefaultTableModel)roomstb.getModel();
				count.setText(model.getValueAt(rowIndex, 0).toString());
				roomno.setText(model.getValueAt(rowIndex, 1).toString());
				room_type.setSelectedItem(model.getValueAt(rowIndex, 2).toString());
				room_type2.setSelectedItem(model.getValueAt(rowIndex, 3).toString());
			status.setSelectedItem(model.getValueAt(rowIndex, 4).toString());
			suite_type.setSelectedItem(model.getValueAt(rowIndex, 5).toString());
			location.setSelectedItem(model.getValueAt(rowIndex, 6).toString());
			}
		});
		
		JButton add = new JButton("Add");
		add.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Add-icon.png"));
		add.setForeground(new Color(255, 255, 255));
		add.setBackground(new Color(50, 205, 50));
		add.setFont(new Font("Tahoma", Font.BOLD, 12));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( roomno.getText().trim().isEmpty())
				{
					roomnoe.setText("*Room No. is required");     
				}
				if (((String) room_type.getSelectedItem()).trim().isEmpty())
				{
					etype.setText("*Room Type is required");     
				}
				if (((String) room_type2.getSelectedItem()).trim().isEmpty())
				{
					etype2.setText("*Room Type is required");     
				}
				if (((String) status.getSelectedItem()).trim().isEmpty())
				{
					estatus.setText("*Status is required");     
				}
				if (((String) suite_type.getSelectedItem()).trim().isEmpty())
				{
					esuite.setText("*Suite Type is required");     
				}
				if (((String) location.getSelectedItem()).trim().isEmpty())
				{
					elocation.setText("*Location is required");     
				}
				else {
					try { Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
					Statement stmt=con.createStatement();
					String sql="insert into rooms_info (roomno,room_type,room_type2,status,suite_type,location) values('"+roomno.getText()+"','"+room_type.getSelectedItem()+"','"+room_type2.getSelectedItem()+"','"+status.getSelectedItem()+"','"+suite_type.getSelectedItem()+"','"+location.getSelectedItem()+"')";
				
					stmt.executeUpdate(sql);
					JOptionPane.showMessageDialog(null, "Room record inserted");
					frmImperialRooms.dispose();
					Rooms2 as = new Rooms2();
					as.main(null);
					
					
					    
					con.close();
					}
					    
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
					}
				
					
					
				}
			}
		});
		add.setBounds(59, 382, 89, 23);
		frmImperialRooms.getContentPane().add(add);
		
		etype = new JLabel("*");
		etype.setForeground(Color.RED);
		etype.setBounds(303, 123, 163, 14);
		frmImperialRooms.getContentPane().add(etype);
		
	 etype2 = new JLabel("*");
		etype2.setForeground(Color.RED);
		etype2.setBounds(302, 175, 164, 14);
		frmImperialRooms.getContentPane().add(etype2);
		
	 estatus = new JLabel("*");
		estatus.setForeground(Color.RED);
		estatus.setBounds(303, 225, 163, 14);
		frmImperialRooms.getContentPane().add(estatus);
		
		 esuite = new JLabel("*");
		esuite.setForeground(Color.RED);
		esuite.setBounds(303, 272, 163, 14);
		frmImperialRooms.getContentPane().add(esuite);
		
		 elocation = new JLabel("*");
		elocation.setForeground(Color.RED);
		elocation.setBounds(303, 323, 163, 14);
		frmImperialRooms.getContentPane().add(elocation);
		
		lblNewLabel_1 = new JLabel("Enter Value");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(514, 86, 95, 14);
		frmImperialRooms.getContentPane().add(lblNewLabel_1);
		
		find = new JTextField();
		find.setBounds(601, 84, 192, 20);
		frmImperialRooms.getContentPane().add(find);
		find.setColumns(10);
		
		JButton view = new JButton("View");
		view.setForeground(new Color(255, 255, 255));
		view.setBackground(new Color(0, 128, 0));
		view.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Zoom-icon.png"));
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				roomstb.setModel(new DefaultTableModel(null,new Object[] {"","Room No.","Room Type","Room Type Other","Status","Suite Type","Location"}));
				fillroomsJTable(roomstb, find.getText());
			}
		});
		view.setFont(new Font("Tahoma", Font.BOLD, 12));
		view.setBounds(808, 82, 89, 23);
		frmImperialRooms.getContentPane().add(view);
		
		JButton btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(178, 34, 34));
		btnBack.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Go-back-icon.png"));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialRooms.dispose();
				Menu_client as = new Menu_client();
				as.main(null);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.setBounds(204, 382, 89, 23);
		frmImperialRooms.getContentPane().add(btnBack);
		
		JButton delete = new JButton("Delete");
		delete.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Delete-icon.png"));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( roomno.getText().trim().isEmpty())
				{
					roomnoe.setText("*Room No. is required");     
				}
				if (((String) room_type.getSelectedItem()).trim().isEmpty())
				{
					etype.setText("*Room Type is required");     
				}
				if (((String) room_type2.getSelectedItem()).trim().isEmpty())
				{
					etype2.setText("*Room Type is required");     
				}
				if (((String) status.getSelectedItem()).trim().isEmpty())
				{
					estatus.setText("*Status is required");     
				}
				if (((String) suite_type.getSelectedItem()).trim().isEmpty())
				{
					esuite.setText("*Suite Type is required");     
				}
				if (((String) location.getSelectedItem()).trim().isEmpty())
				{
					elocation.setText("*Location is required");     
				}
				else {
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="DELETE FROM rooms_info WHERE count="+count.getText();
				
				
				stmt.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "Room record is deleted");
				frmImperialRooms.dispose();
				Rooms2 as = new Rooms2();
				as.main(null);
				
					
				    
				con.close();
				}
				    
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
				}
			}
		});
		delete.setForeground(new Color(255, 255, 255));
		delete.setBackground(new Color(255, 0, 0));
		delete.setFont(new Font("Tahoma", Font.BOLD, 12));
		delete.setBounds(204, 428, 109, 23);
		frmImperialRooms.getContentPane().add(delete);
		
		JButton update = new JButton("Update");
		update.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-document-edit-icon.png"));
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( roomno.getText().trim().isEmpty())
				{
					roomnoe.setText("*Room No. is required");     
				}
				if (((String) room_type.getSelectedItem()).trim().isEmpty())
				{
					etype.setText("*Room Type is required");     
				}
				if (((String) room_type2.getSelectedItem()).trim().isEmpty())
				{
					etype2.setText("*Room Type is required");     
				}
				if (((String) status.getSelectedItem()).trim().isEmpty())
				{
					estatus.setText("*Status is required");     
				}
				if (((String) suite_type.getSelectedItem()).trim().isEmpty())
				{
					esuite.setText("*Suite Type is required");     
				}
				if (((String) location.getSelectedItem()).trim().isEmpty())
				{
					elocation.setText("*Location is required");     
				}
				else {
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="UPDATE `rooms_info` SET `roomno`='"+roomno.getText()+"',`room_type`='"+room_type.getSelectedItem()+"',`room_type2`='"+room_type2.getSelectedItem()+"',`status`='"+status.getSelectedItem()+"',`suite_type`='"+suite_type.getSelectedItem()+"',`location`='"+location.getSelectedItem()+"' WHERE `count`='"+count.getText()+"'";
				
				stmt.executeUpdate(sql);
			
				
				JOptionPane.showMessageDialog(null, "Room record updated");
				frmImperialRooms.dispose();
				Rooms2 as = new Rooms2();
				as.main(null);
				
				    
				con.close();
				}
				    
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
			
				}
			}
			
		});
		update.setForeground(new Color(255, 255, 255));
		update.setBackground(new Color(255, 140, 0));
		update.setFont(new Font("Tahoma", Font.BOLD, 12));
		update.setBounds(59, 428, 109, 23);
		frmImperialRooms.getContentPane().add(update);
		
		JButton book = new JButton("Book Room");
		book.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-view-calendar-day-icon.png"));
		book.addActionListener(new ActionListener() {
		

			public void actionPerformed(ActionEvent e) {
			
				Bookings2 bk=new Bookings2();
	          bk.main(null);
	          
	        
			} 
		});
		book.setForeground(new Color(255, 255, 255));
		book.setBackground(new Color(139, 0, 0));
		book.setFont(new Font("Tahoma", Font.BOLD, 12));
		book.setBounds(495, 428, 129, 23);
		frmImperialRooms.getContentPane().add(book);
		
		JLabel lblNewLabel_2 = new JLabel("Hotel Name:");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\hotel.png"));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_2.setBounds(29, 11, 288, 14);
		frmImperialRooms.getContentPane().add(lblNewLabel_2);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Users-Name-icon.png"));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setBounds(396, 11, 278, 14);
		frmImperialRooms.getContentPane().add(lblUser);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You're Logged Out");
				frmImperialRooms.dispose();
				Login as = new Login();
				as.main(null);
			}
		});
		btnLogOut.setBackground(new Color(0, 128, 128));
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Log-Off-icon.png"));
		btnLogOut.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLogOut.setBounds(833, 7, 115, 23);
		frmImperialRooms.getContentPane().add(btnLogOut);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 0, 984, 37);
		frmImperialRooms.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 464, 984, 29);
		frmImperialRooms.getContentPane().add(panel_1);
		
		JLabel lblRoomNo = new JLabel("Room No.");
		lblRoomNo.setBackground(new Color(255, 255, 255));
		lblRoomNo.setForeground(new Color(255, 255, 255));
		lblRoomNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblRoomNo.setBounds(29, 74, 76, 14);
		frmImperialRooms.getContentPane().add(lblRoomNo);
		
		roomno = new JTextField();
		roomno.setBackground(new Color(240, 230, 140));
		roomno.setBounds(156, 72, 63, 20);
		frmImperialRooms.getContentPane().add(roomno);
		roomno.setColumns(10);
		
		JButton button = new JButton("Refresh");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialRooms.dispose();
				Rooms2 as = new Rooms2();
				as.main(null);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-view-refresh-icon.png"));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBackground(new Color(165, 42, 42));
		button.setBounds(808, 48, 106, 23);
		frmImperialRooms.getContentPane().add(button);
		
		 roomnoe = new JLabel("*");
		roomnoe.setForeground(Color.RED);
		roomnoe.setBounds(303, 75, 163, 14);
		frmImperialRooms.getContentPane().add(roomnoe);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 128, 128));
		panel_2.setForeground(new Color(255, 255, 255));
		panel_2.setBounds(0, 36, 461, 428);
		frmImperialRooms.getContentPane().add(panel_2);
		
		 count = new JLabel("");
		count.setForeground(new Color(128, 128, 128));
		panel_2.add(count);
	}
	public void fillroomsJTable(JTable roomstb, String find) {
		// TODO Auto-generated method stub
		try { Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
		PreparedStatement ps;
		ps=con.prepareStatement("SELECT * FROM `rooms_info` WHERE CONCAT (`count`,`roomno`,`room_type`,`room_type2`,`status`,`suite_type`,`location`) LIKE ?"); //Search for rooms
		ps.setString(1, "%"+find+"%");
		ResultSet rs=ps.executeQuery();
		DefaultTableModel model=(DefaultTableModel)roomstb.getModel();
		Object[]row;
		while(rs.next())
		{
			row=new Object[7];
			row[0]=rs.getInt(1);
			row[1]=rs.getInt(2);
			row[2]=rs.getString(3);
			row[3]=rs.getString(4);
			row[4]=rs.getString(5);
			row[5]=rs.getString(6);
			row[6]=rs.getString(7);
			
			model.addRow(row);
		}
		
		con.close();
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
	}
}
}



