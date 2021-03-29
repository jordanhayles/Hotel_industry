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
import javax.swing.JList;
import javax.swing.JOptionPane;

public class Menu_client {

	private JFrame frmImperialClient;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu_client window = new Menu_client();
					window.frmImperialClient.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Menu_client() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frmImperialClient = new JFrame();
		frmImperialClient.setTitle("IMPERIAL - Client Menu");
		frmImperialClient.getContentPane().setBackground(new Color(230, 230, 250));
		frmImperialClient.setBounds(100, 100, 812, 363);
		frmImperialClient.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmImperialClient.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Log Out");
		btnNewButton.setBackground(new Color(0, 128, 128));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Button-Log-Off-icon.png"));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "You're Logged Out");
				frmImperialClient.dispose();
				Login as = new Login();
				as.main(null);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(673, 11, 117, 26);
		frmImperialClient.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Rooms");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialClient.dispose();
				Rooms2 as = new Rooms2();
				as.main(null);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\room.png"));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(240, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(35, 140, 155, 93);
		frmImperialClient.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Bookings");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialClient.dispose();
				Bookings2 as = new Bookings2();
				as.main(null);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\bookings.png"));
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setBackground(new Color(255, 165, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_2.setBounds(341, 140, 155, 93);
		frmImperialClient.getContentPane().add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setBounds(62, 140, -25, -20);
		frmImperialClient.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 191, 255));
		panel_1.setBounds(0, 295, 796, 27);
		frmImperialClient.getContentPane().add(panel_1);
		
		JLabel label_1 = new JLabel("Copyright 2019 ");
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("AVA Designs Ltd");
		panel_1.add(label_2);
		
		JButton btnCustomers = new JButton("Customers");
		btnCustomers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmImperialClient.dispose();
				Customers2 as = new Customers2();
				as.main(null);
			}
		});
		btnCustomers.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\customer.png"));
		btnCustomers.setForeground(new Color(255, 255, 255));
		btnCustomers.setBackground(new Color(0, 128, 128));
		btnCustomers.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCustomers.setBounds(187, 140, 155, 93);
		frmImperialClient.getContentPane().add(btnCustomers);
		
		JButton btnTransaction = new JButton("Transactions");
		btnTransaction.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\cash.png"));
		btnTransaction.setForeground(new Color(255, 255, 255));
		btnTransaction.setBackground(new Color(65, 105, 225));
		btnTransaction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnTransaction.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTransaction.setBounds(495, 140, 175, 93);
		frmImperialClient.getContentPane().add(btnTransaction);
		
		JLabel lblNewLabel = new JLabel("Hotel Name:");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\hotel.png"));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(21, 12, 223, 14);
		frmImperialClient.getContentPane().add(lblNewLabel);
		
		JLabel lblUser = new JLabel("User:");
		lblUser.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Users-Name-icon.png"));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblUser.setBounds(355, 12, 71, 14);
		frmImperialClient.getContentPane().add(lblUser);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBounds(0, 0, 796, 44);
		frmImperialClient.getContentPane().add(panel_2);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\Settings-icon.png"));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 12));
		button.setBackground(new Color(192, 192, 192));
		button.setBounds(742, 48, 44, 34);
		frmImperialClient.getContentPane().add(button);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\2889392.jpg"));
		lblNewLabel_1.setBounds(-46, -25, 874, 465);
		frmImperialClient.getContentPane().add(lblNewLabel_1);
		
		JList list = new JList();
		list.setBounds(10, 119, 700, 142);
		frmImperialClient.getContentPane().add(list);
	}

	

	
		
	
}
