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
import javax.swing.table.DefaultTableModel;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JList;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
public class Bookings1 extends JFrame{
	
	

	private JFrame frmImperialBookings;
	private JTextField roomnumber;
	private JTextField custid;
	private JLabel iderr;
	private JTextField bookid;
	private JTextField price;
	private JLabel ider;
	private JLabel ider2;
	private JLabel ider3;
	private JLabel ider4;
	private JLabel ider5;
	private JLabel ider6;
	JComboBox roomtype;
	private JComboBox roomtype2;
	private JComboBox status;
	private JLabel ider7;
	private JLabel ider8;
	private JDateChooser checkin;
	private JDateChooser checkout;
	private Object s;
    String roomt;
    private JTable book;
    private JLabel label;
    private JTextField find;
    private JScrollPane scrollPane;
    private JButton button_2;
	
	


	/**
	 * Launch the application.
	 */
	public void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bookings1 window = new Bookings1();
					window.frmImperialBookings.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bookings1() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImperialBookings = new JFrame();
		frmImperialBookings.setTitle("IMPERIAL- Bookings");
		frmImperialBookings.getContentPane().setBackground(new Color(255, 255, 255));
		frmImperialBookings.setBounds(100, 100, 1083, 537);
		frmImperialBookings.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImperialBookings.getContentPane().setLayout(null);
		
		JTextArea txtrCustName = new JTextArea();
		txtrCustName.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtrCustName.setBackground(new Color(255, 255, 255));
		txtrCustName.setText("Customer  ID:");
		txtrCustName.setBounds(15, 128, 115, 22);
		frmImperialBookings.getContentPane().add(txtrCustName);
		
		JTextArea txtrRoomNum = new JTextArea();
		txtrRoomNum.setBackground(new Color(255, 255, 255));
		txtrRoomNum.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtrRoomNum.setText("Room Num#:");
		txtrRoomNum.setBounds(26, 227, 104, 22);
		frmImperialBookings.getContentPane().add(txtrRoomNum);
		
		JTextArea txtrRoomType = new JTextArea();
		txtrRoomType.setBackground(new Color(255, 255, 255));
		txtrRoomType.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtrRoomType.setText("Room Type Other:");
		txtrRoomType.setBounds(0, 194, 151, 22);
		frmImperialBookings.getContentPane().add(txtrRoomType);
		
		JTextArea txtrGender = new JTextArea();
		txtrGender.setBackground(new Color(255, 255, 255));
		txtrGender.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtrGender.setText("Room Type:");
		txtrGender.setBounds(26, 161, 104, 22);
		frmImperialBookings.getContentPane().add(txtrGender);
		
		JButton btnBook = new JButton("Book");
		btnBook.setForeground(new Color(255, 255, 255));
		btnBook.setBackground(new Color(50, 205, 50));
		btnBook.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-view-calendar-day-icon.png"));
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (custid.getText().trim().isEmpty())
				{
					iderr.setText("*Customer ID is required");     
				}
				if (bookid.getText().trim().isEmpty())
				{
					ider.setText("*Book ID is required");     
				}
				
				if (((String) roomtype.getSelectedItem()).trim().isEmpty())
				{
					ider2.setText("*Room type is required");     
				}
				if (((String) roomtype2.getSelectedItem()).trim().isEmpty());
				{
					ider3.setText("*Room type is required");     
				}
				if (roomnumber.getText().trim().isEmpty())
				{
					ider4.setText("*Room number is required");     
				}
				if (((String) status.getSelectedItem()).trim().isEmpty())
				{
					ider5.setText("*Status is required");     
				}
				if (price.getText().trim().isEmpty())
				{
					ider6.setText("*Price is required");     
				}
				if (((JTextField)checkin.getDateEditor().getUiComponent()).getText().isEmpty())
				 {
					ider7.setText("*Check in date is required");     
				}
				if (((JTextField)checkout.getDateEditor().getUiComponent()).getText().isEmpty())
				{
					ider8.setText("*Check out date is required");     
				}
				else
				{ 
					
					try { Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Imperial","root","");
					Statement stmt=con.createStatement();
					String sql="insert into bookings (custid,roomtype,roomtype2,roomno,status,price,checkin,checkout) values('"+custid.getText()+"','"+roomtype.getSelectedItem()+"','"+roomtype2.getSelectedItem()+"','"+roomnumber.getText()+"','"+status.getSelectedItem()+"','"+price.getText()+"','"+((JTextField)checkin.getDateEditor().getUiComponent()).getText()+"','"+((JTextField)checkout.getDateEditor().getUiComponent()).getText()+"')";
					
					
					stmt.executeUpdate(sql);
					
					JOptionPane.showMessageDialog(null, "Booking details inserted");
					frmImperialBookings.dispose();
					Bookings1 as = new Bookings1();
					as.main(null);
						
						
					    
					con.close();
					}
					    
					catch(Exception e1) {
						JOptionPane.showMessageDialog(null,e1);
					}
						}
				
				
			}
		});
		btnBook.setBounds(54, 392, 97, 25);
		frmImperialBookings.getContentPane().add(btnBook);
		
		JButton btnCancel = new JButton("Back");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialBookings.dispose();
				Menu as = new Menu();
				as.main(null);
			}
		});
		btnCancel.setForeground(new Color(255, 255, 255));
		btnCancel.setBackground(new Color(178, 34, 34));
		btnCancel.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Go-back-icon.png"));
		btnCancel.setBounds(180, 392, 97, 25);
		frmImperialBookings.getContentPane().add(btnCancel);
		
		roomnumber = new JTextField();
		roomnumber.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		roomnumber.setBounds(161, 231, 116, 22);
		frmImperialBookings.getContentPane().add(roomnumber);
		roomnumber.setColumns(10);
		
		custid = new JTextField();
		custid.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		custid.setBounds(161, 131, 116, 22);
		frmImperialBookings.getContentPane().add(custid);
		custid.setColumns(10);
		
		roomtype2 = new JComboBox();
		roomtype2.setModel(new DefaultComboBoxModel(new String[] {"", "Connecting Room", "Adjoining Room", "Adjacent  Room", "None"}));
		
	
		roomtype = new JComboBox();
		roomtype.setModel(new DefaultComboBoxModel(new String[] {"", "Single", "Double ", "Triple", "Quad", "Queen ", "King", "Twin ", "Double-Double", "Studio"}));
		roomtype.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		roomtype.setBounds(161, 165, 115, 22);
		frmImperialBookings.getContentPane().add(roomtype);
		
		JTextArea txtrBooking = new JTextArea();
		txtrBooking.setBackground(new Color(255, 255, 255));
		txtrBooking.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		txtrBooking.setText("BOOKING DETAILS");
		txtrBooking.setBounds(163, 44, 276, 31);
		frmImperialBookings.getContentPane().add(txtrBooking);
		
		JTextArea txtrCheckIn = new JTextArea();
		txtrCheckIn.setBackground(new Color(255, 255, 255));
		txtrCheckIn.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtrCheckIn.setText("Check In:");
		txtrCheckIn.setBounds(26, 326, 85, 22);
		frmImperialBookings.getContentPane().add(txtrCheckIn);
		
		JTextArea txtrCheckOut = new JTextArea();
		txtrCheckOut.setBackground(new Color(255, 255, 255));
		txtrCheckOut.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtrCheckOut.setText("Check Out:");
		txtrCheckOut.setBounds(26, 359, 104, 22);
		frmImperialBookings.getContentPane().add(txtrCheckOut);
			roomtype2.addItem("Twin");
		roomtype2.addItem("Master Suite");
		roomtype2.addItem("Mini Suite");
		roomtype2.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		roomtype2.setBounds(161, 198, 116, 22);
		frmImperialBookings.getContentPane().add(roomtype2);
		
		
		 iderr = new JLabel("*");
		iderr.setForeground(new Color(255, 0, 0));
		iderr.setBounds(286, 135, 172, 16);
		frmImperialBookings.getContentPane().add(iderr);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 467, 1067, 31);
		frmImperialBookings.getContentPane().add(panel_1);
		
		 ider2 = new JLabel("*");
		ider2.setForeground(Color.RED);
		ider2.setBounds(286, 168, 172, 16);
		frmImperialBookings.getContentPane().add(ider2);
		
		 ider3 = new JLabel("*");
		ider3.setForeground(Color.RED);
		ider3.setBounds(287, 201, 171, 16);
		frmImperialBookings.getContentPane().add(ider3);
		
		 ider4 = new JLabel("*");
		ider4.setForeground(Color.RED);
		ider4.setBounds(287, 234, 172, 16);
		frmImperialBookings.getContentPane().add(ider4);
		
		 ider5 = new JLabel("*");
		ider5.setForeground(Color.RED);
		ider5.setBounds(286, 264, 172, 22);
		frmImperialBookings.getContentPane().add(ider5);
		
		 ider6 = new JLabel("*");
		ider6.setForeground(Color.RED);
		ider6.setBounds(286, 297, 172, 22);
		frmImperialBookings.getContentPane().add(ider6);
		
		JTextArea txtrBookId = new JTextArea();
		txtrBookId.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtrBookId.setText("Book ID:");
		txtrBookId.setBounds(26, 93, 74, 22);
		frmImperialBookings.getContentPane().add(txtrBookId);
		
		bookid = new JTextField();
		bookid.setBackground(new Color(240, 230, 140));
		bookid.setEditable(false);
		bookid.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		bookid.setBounds(161, 100, 116, 20);
		frmImperialBookings.getContentPane().add(bookid);
		bookid.setColumns(10);
		
		 ider = new JLabel("*");
		ider.setForeground(Color.RED);
		ider.setBounds(286, 100, 172, 16);
		frmImperialBookings.getContentPane().add(ider);
		
		JTextArea txtrStatus = new JTextArea();
		txtrStatus.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtrStatus.setText("Status:");
		txtrStatus.setBounds(26, 260, 75, 22);
		frmImperialBookings.getContentPane().add(txtrStatus);
		
		JTextArea txtrPrice = new JTextArea();
		txtrPrice.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		txtrPrice.setText("Price:");
		txtrPrice.setBounds(26, 293, 64, 22);
		frmImperialBookings.getContentPane().add(txtrPrice);
		
		status = new JComboBox();
		status.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		status.setModel(new DefaultComboBoxModel(new String[] {"", "Paid", "Not Paid"}));
		status.setBounds(161, 264, 116, 20);
		frmImperialBookings.getContentPane().add(status);
		
		price = new JTextField();
		price.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		price.setBounds(161, 298, 116, 20);
		frmImperialBookings.getContentPane().add(price);
		price.setColumns(10);
		
		 
		 ider7 = new JLabel("*");
		ider7.setForeground(Color.RED);
		ider7.setBounds(286, 330, 172, 22);
		frmImperialBookings.getContentPane().add(ider7);
		
		 ider8 = new JLabel("*");
		ider8.setForeground(Color.RED);
		ider8.setBounds(286, 363, 172, 22);
		frmImperialBookings.getContentPane().add(ider8);
		
	    checkin = new JDateChooser();
		checkin.setBounds(161, 328, 116, 20);
		frmImperialBookings.getContentPane().add(checkin);
		
		 checkout = new JDateChooser();
		checkout.setBounds(161, 359, 116, 20);
		frmImperialBookings.getContentPane().add(checkout);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(468, 114, 589, 298);
		frmImperialBookings.getContentPane().add(scrollPane);
		
		book = new JTable();
		scrollPane.setViewportView(book);
		book.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int rowIndex=book.getSelectedRow();
				DefaultTableModel model=(DefaultTableModel)book.getModel();
				bookid.setText(model.getValueAt(rowIndex, 0).toString());
				custid.setText(model.getValueAt(rowIndex, 1).toString());
				roomtype.setSelectedItem(model.getValueAt(rowIndex, 2).toString());
				roomtype2.setSelectedItem(model.getValueAt(rowIndex, 3).toString());
				roomnumber.setText(model.getValueAt(rowIndex, 4).toString());
			status.setSelectedItem(model.getValueAt(rowIndex, 5).toString());
			price.setText(model.getValueAt(rowIndex,6 ).toString());
			((JTextField)checkin.getDateEditor().getUiComponent()).setText(model.getValueAt(rowIndex, 7).toString());
			((JTextField)checkout.getDateEditor().getUiComponent()).setText(model.getValueAt(rowIndex, 8).toString());
			}
		});
		book.setBackground(new Color(192, 192, 192));
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (custid.getText().trim().isEmpty())
				{
					iderr.setText("*Customer ID is required");     
				}
				if (bookid.getText().trim().isEmpty())
				{
					ider.setText("*Book ID is required");     
				}
				
				if (((String) roomtype.getSelectedItem()).trim().isEmpty())
				{
					ider2.setText("*Room type is required");     
				}
				if (((String) roomtype2.getSelectedItem()).trim().isEmpty());
				{
					ider3.setText("*Room type is required");     
				}
				if (roomnumber.getText().trim().isEmpty())
				{
					ider4.setText("*Room number is required");     
				}
				if (((String) status.getSelectedItem()).trim().isEmpty())
				{
					ider5.setText("*Status is required");     
				}
				if (price.getText().trim().isEmpty())
				{
					ider6.setText("*Price is required");     
				}
				if (((JTextField)checkin.getDateEditor().getUiComponent()).getText().isEmpty())
				 {
					ider7.setText("*Check in date is required");     
				}
				if (((JTextField)checkout.getDateEditor().getUiComponent()).getText().isEmpty())
				{
					ider8.setText("*Check out date is required");     
				}
				else
				{ 
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="UPDATE `bookings` SET `bookid`='"+bookid.getText()+"',`custid`='"+custid.getText()+"',`roomtype`='"+roomtype.getSelectedItem()+"',`roomtype2`='"+roomtype2.getSelectedItem()+"',`roomno`='"+roomnumber.getText()+"',`status`='"+status.getSelectedItem()+"',`price`='"+price.getText()+"',`checkin`='"+((JTextField)checkin.getDateEditor().getUiComponent()).getText()+"',`checkout`='"+((JTextField)checkout.getDateEditor().getUiComponent()).getText()+"' WHERE `bookid`='"+bookid.getText()+"'";
				
				stmt.executeUpdate(sql);
			
				
				JOptionPane.showMessageDialog(null, "Booking record updated");
				frmImperialBookings.dispose();
				Bookings1 as = new Bookings1();
				as.main(null);
				
				    
				con.close();
				}
				    
				catch(Exception e1) {
					JOptionPane.showMessageDialog(null,e1);
				}
				}
			}
		});
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(218, 165, 32));
		btnUpdate.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-document-edit-icon.png"));
		btnUpdate.setBounds(54, 428, 97, 25);
		frmImperialBookings.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			private String title;

			public void actionPerformed(ActionEvent e) {
				if (custid.getText().trim().isEmpty())
				{
					iderr.setText("*Customer ID is required");     
				}
				if (bookid.getText().trim().isEmpty())
				{
					ider.setText("*Book ID is required");     
				}
				
				if (((String) roomtype.getSelectedItem()).trim().isEmpty())
				{
					ider2.setText("*Room type is required");     
				}
				if (((String) roomtype2.getSelectedItem()).trim().isEmpty());
				{
					ider3.setText("*Room type is required");     
				}
				if (roomnumber.getText().trim().isEmpty())
				{
					ider4.setText("*Room number is required");     
				}
				if (((String) status.getSelectedItem()).trim().isEmpty())
				{
					ider5.setText("*Status is required");     
				}
				if (price.getText().trim().isEmpty())
				{
					ider6.setText("*Price is required");     
				}
				if (((JTextField)checkin.getDateEditor().getUiComponent()).getText().isEmpty())
				 {
					ider7.setText("*Check in date is required");     
				}
				if (((JTextField)checkout.getDateEditor().getUiComponent()).getText().isEmpty())
				{
					ider8.setText("*Check out date is required");     
				}
				else
				{ 
				try { Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
				Statement stmt=con.createStatement();
				String sql="DELETE FROM bookings WHERE bookid="+bookid.getText();
				
				int reply =JOptionPane.showConfirmDialog(null,"Are you sure you want to delete this record?", title, JOptionPane.YES_NO_OPTION);
				 if (reply == JOptionPane.YES_OPTION) {
					 stmt.executeUpdate(sql);
						JOptionPane.showMessageDialog(null, "Booking record is deleted");
						frmImperialBookings.dispose();
						Bookings1 as = new Bookings1();
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
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(255, 0, 0));
		btnDelete.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Delete-icon.png"));
		btnDelete.setBounds(180, 428, 97, 25);
		frmImperialBookings.getContentPane().add(btnDelete);
		
		JLabel lblNewLabel = new JLabel("Hotel Name:");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\hotel.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(15, 11, 244, 14);
		frmImperialBookings.getContentPane().add(lblNewLabel);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Users-Name-icon.png"));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setBounds(393, 11, 244, 14);
		frmImperialBookings.getContentPane().add(lblUser);
		
		JButton button = new JButton("Log Out");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You're Logged Out");
				frmImperialBookings.dispose();
				Login as = new Login();
				as.main(null);
				
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Log-Off-icon.png"));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBackground(new Color(0, 128, 128));
		button.setBounds(855, 6, 115, 23);
		frmImperialBookings.getContentPane().add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(0, 2, 1067, 31);
		frmImperialBookings.getContentPane().add(panel);
		
		label = new JLabel("Enter Value");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(484, 89, 95, 14);
		frmImperialBookings.getContentPane().add(label);
		
		find = new JTextField();
		find.setColumns(10);
		find.setBounds(589, 87, 192, 20);
		frmImperialBookings.getContentPane().add(find);
		
		JButton button_1 = new JButton("View");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				book.setModel(new DefaultTableModel(null,new Object[] {"Book ID","Customer ID","Room Type","Room Type Other","Room #","Status","Price","Check In","Check Out"}));
				fillbookJTable(book, find.getText());
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Zoom-icon.png"));
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		button_1.setBackground(new Color(0, 128, 0));
		button_1.setBounds(799, 86, 89, 23);
		frmImperialBookings.getContentPane().add(button_1);
		
		button_2 = new JButton("Refresh");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialBookings.dispose();
				Bookings1 as = new Bookings1();
				as.main(null);
				
				
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Actions-view-refresh-icon.png"));
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBackground(new Color(165, 42, 42));
		button_2.setBounds(898, 86, 106, 23);
		frmImperialBookings.getContentPane().add(button_2);
	}
	public void fillbookJTable(JTable book, String find) {
		// TODO Auto-generated method stub
		try { Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/imperial","root","");
		PreparedStatement ps;
		ps=con.prepareStatement("SELECT * FROM `bookings` WHERE CONCAT (`bookid`,`custid`,`roomtype`,`roomtype2`,`roomno`,`status`,`price`,`checkin`,`checkout`) LIKE ?"); //Search for rooms
		ps.setString(1, "%"+find+"%");
		ResultSet rs=ps.executeQuery();
		DefaultTableModel model=(DefaultTableModel)book.getModel();
		Object[]row;
		while(rs.next())
		{
			row=new Object[9];
			row[0]=rs.getInt(1);
			row[1]=rs.getInt(2);
			row[2]=rs.getString(3);
			row[3]=rs.getString(4);
			row[4]=rs.getInt(5);
			row[5]=rs.getString(6);
			row[6]=rs.getString(7);
			row[7]=rs.getString(8);
			row[8]=rs.getString(9);
			model.addRow(row);
		}
		
		con.close();
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null,e1);
	}
	}
}