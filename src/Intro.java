import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.ImageIcon;

public class Intro extends JFrame {

	private JPanel contentPane;
	private JLabel percent;
	private JProgressBar loader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intro frame = new Intro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Intro() {
		setTitle("IMPERIAL- StartUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 378);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Options");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Start");
		mntmNewMenuItem.addActionListener(new ActionListener() {
		

			
			
			public void actionPerformed(ActionEvent e) {       //Click on start to Load Progress Bar 
				
				try {
					for (int i=0;i<=100;i++)
					{
						
						percent.setText("Loading Please Wait...........");
						Thread.sleep(40);
						
						
						loader.setValue(i);
						percent.setText("Load Complete");
						
					}
				}
				catch (Exception e1)
				{
					
				}
				
				
				Login log=new Login();
				log.main(null);
				
				 
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Exit");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnNewMenu.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	 
	  percent = new JLabel("");
	  percent.setFont(new Font("Tahoma", Font.BOLD, 11));
	  percent.setForeground(new Color(0, 0, 0));
	  percent.setBounds(10, 295, 182, 14);
	  contentPane.add(percent);
		
	 loader = new JProgressBar();
	 loader.setForeground(new Color(0, 128, 0));
	 loader.setStringPainted(true);
		loader.setBounds(0, 295, 434, 23);
		contentPane.add(loader);
		
		JLabel label = new JLabel("IMPERIAL");
		label.setForeground(new Color(47, 79, 79));
		label.setFont(new Font("Snap ITC", Font.ITALIC, 18));
		label.setBounds(10, 0, 126, 28);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Hotel Reservation System");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(35, 23, 197, 23);
		contentPane.add(label_1);
		
		JLabel lblWelcome = new JLabel("WELCOME");
		lblWelcome.setBackground(new Color(255, 255, 255));
		lblWelcome.setForeground(new Color(0, 0, 0));
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblWelcome.setBounds(170, 136, 105, 23);
		contentPane.add(lblWelcome);
		
		JList list = new JList();
		list.setBackground(new Color(0, 191, 255));
		list.setBounds(0, 0, 434, 42);
		contentPane.add(list);
		
		JList list_1 = new JList();
		list_1.setBackground(new Color(255, 255, 255));
		list_1.setBounds(0, 131, 434, 28);
		contentPane.add(list_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\jordan\\eclipse-workspace\\Hotel_industry\\Pictures\\para.jpg"));
		lblNewLabel.setBounds(-13, -57, 589, 414);
		contentPane.add(lblNewLabel);
		
		
		
	}
}
