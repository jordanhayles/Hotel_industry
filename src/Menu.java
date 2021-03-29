import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.JTextArea;

public class Menu {

	JFrame frmImperialAdminMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.frmImperialAdminMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		initialize();
	}
	


	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmImperialAdminMenu = new JFrame();
		frmImperialAdminMenu.setTitle("IMPERIAL- Admin Menu");
		frmImperialAdminMenu.getContentPane().setBackground(new Color(230, 230, 250));
		frmImperialAdminMenu.setBounds(100, 100, 839, 363);
		frmImperialAdminMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImperialAdminMenu.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Log-Off-icon.png"));
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You're Logged Out");
				frmImperialAdminMenu.dispose();
				Login as = new Login();
				as.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(675, 11, 115, 26);
		frmImperialAdminMenu.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rooms");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialAdminMenu.dispose();
				Rooms as = new Rooms();
				as.main(null);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\room.png"));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(240, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(35, 140, 155, 93);
		frmImperialAdminMenu.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bookings");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialAdminMenu.dispose();
				Bookings1 as = new Bookings1();
				as.main(null);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\bookings.png"));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 165, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(341, 140, 155, 93);
		frmImperialAdminMenu.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(62, 140, -25, -20);
		frmImperialAdminMenu.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 295, 823, 27);
		frmImperialAdminMenu.getContentPane().add(panel_1);
		
		JLabel label_1 = new JLabel("Copyright 2019 ");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("AVA Designs Ltd");
		panel_1.add(label_2);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialAdminMenu.dispose();
				Customers as = new Customers();
				as.main(null);
			}
		});
		btnCustomers.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\customer.png"));
		btnCustomers.setForeground(new Color(255, 255, 255));
		btnCustomers.setBackground(new Color(0, 128, 128));
		btnCustomers.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCustomers.setBounds(187, 140, 155, 93);
		frmImperialAdminMenu.getContentPane().add(btnCustomers);
		
		JButton btnUsers = new JButton("Users");
		btnUsers.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\user.png"));
		btnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialAdminMenu.dispose();
				Users as = new Users();
				as.main(null);
			}
		});
		btnUsers.setForeground(new Color(255, 255, 255));
		btnUsers.setBackground(new Color(50, 205, 50));
		btnUsers.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUsers.setBounds(495, 140, 155, 93);
		frmImperialAdminMenu.getContentPane().add(btnUsers);
		
		JButton btnTransaction = new JButton("Transactions");
		btnTransaction.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\cash.png"));
		btnTransaction.setForeground(new Color(255, 255, 255));
		btnTransaction.setBackground(new Color(65, 105, 225));
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTransaction.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTransaction.setBounds(649, 140, 164, 93);
		frmImperialAdminMenu.getContentPane().add(btnTransaction);
		
		JLabel lblNewLabel = new JLabel("Hotel Name:");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\hotel.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(21, 12, 121, 14);
		frmImperialAdminMenu.getContentPane().add(lblNewLabel);
		
		JLabel uname = new JLabel("User:");
		uname.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Users-Name-icon.png"));
		uname.setFont(new Font("Tahoma", Font.BOLD, 11));
		uname.setBounds(355, 12, 209, 25);
		frmImperialAdminMenu.getContentPane().add(uname);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBounds(0, 0, 823, 44);
		frmImperialAdminMenu.getContentPane().add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\2889392.jpg"));
		lblNewLabel_1.setBounds(-19, -40, 854, 517);
		frmImperialAdminMenu.getContentPane().add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBounds(21, 107, 802, 149);
		frmImperialAdminMenu.getContentPane().add(list);
	}
}
