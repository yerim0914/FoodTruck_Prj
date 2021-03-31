package businessUI.views;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import businessUI.util.ResizableUtil;

import javax.swing.JTextField;
import java.awt.Toolkit;

public class MyInformation extends JFrame {

	private JPanel contentPane;
	private JLabel myInformation;
	private JTextField business_id;
	private JTextField pw;
	private JTextField pw_new;
	private JTextField shop_name;
	private JTextField owner_name;
	private JTextField owner_phone;
	private JTextField owner_acc;
	private JTextField business_name;
	/**
	 * Launch the application.
	 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInformation frame = new MyInformation();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyInformation frame = new MyInformation();
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
	public MyInformation() {
		setTitle("Foodi");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MyInformation.class.getResource("/images/icon_foodTruck_64.png")));
		ResizableUtil util = new ResizableUtil();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 548);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);
		
		business_id = new JTextField();
		business_id.setBounds(214, 142, 152, 21);
		contentPane.add(business_id);
		business_id.setColumns(10);
		
		pw = new JTextField();
		pw.setColumns(10);
		pw.setBounds(214, 172, 152, 21);
		contentPane.add(pw);
		
		pw_new = new JTextField();
		pw_new.setColumns(10);
		pw_new.setBounds(214, 201, 152, 21);
		contentPane.add(pw_new);
		
		shop_name = new JTextField();
		shop_name.setColumns(10);
		shop_name.setBounds(214, 229, 152, 21);
		contentPane.add(shop_name);
		
		owner_name = new JTextField();
		owner_name.setColumns(10);
		owner_name.setBounds(214, 257, 152, 21);
		contentPane.add(owner_name);
		
		owner_phone = new JTextField();
		owner_phone.setColumns(10);
		owner_phone.setBounds(214, 288, 152, 21);
		contentPane.add(owner_phone);
		
		owner_acc = new JTextField();
		owner_acc.setColumns(10);
		owner_acc.setBounds(214, 314, 152, 21);
		contentPane.add(owner_acc);
		
		business_name = new JTextField();
		business_name.setColumns(10);
		business_name.setBounds(214, 345, 152, 21);
		contentPane.add(business_name);
		
		JLabel updateButton = new JLabel("New label");
		updateButton.setBounds(87, 453, 94, 47);
		updateButton.setIcon(new ImageIcon(util.imgResize(updateButton,"/images/updateButton.png")));
		contentPane.add(updateButton);
		
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				updateButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				//수정 버튼을 눌렀을 때 실행될 메소드
				
				new MyInformation();
				setVisible(false);	
				}
			});
		
		
		
		JLabel confirmButton = new JLabel("New label");
		confirmButton.setBounds(262, 453, 88, 47);
		confirmButton.setIcon(new ImageIcon(util.imgResize(confirmButton,"/images/confirmButton.png")));
		contentPane.add(confirmButton);
		
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				confirmButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				setVisible(false);	
				}
			});
		
		myInformation = new JLabel("New label");
		myInformation.setBounds(0, 0, 440, 511);
		myInformation.setIcon(new ImageIcon(util.imgResize(myInformation, "/images/myInformation.jpg")));
		contentPane.add(myInformation);
	}
}
