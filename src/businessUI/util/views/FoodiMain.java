package businessUI.views;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessUI.util.ResizableUtil;

import java.awt.Color;



public class FoodiMain extends JFrame {

	private JPanel contentPane;
	private JLabel mainPage;
	private JButton businessButton; 
	private JButton clientButton;
	private JLabel lblNewLabel_1;
	

	//static Main frame;
	//private FoodiMain frame;
	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FoodiMain frame = new FoodiMain();
				frame.setVisible(true);
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public FoodiMain() {
		ResizableUtil util = new ResizableUtil();
		
		setTitle("Foodi");
		setIconImage(Toolkit.getDefaultToolkit().getImage(FoodiMain.class.getResource("/images/icon_foodTruck_64.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 548);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		JLabel foodiSubtitle = new JLabel("New lab");
		foodiSubtitle.setForeground(Color.BLACK);
		foodiSubtitle.setBounds(-65, -83, 450, 335);
		foodiSubtitle.setIcon(new ImageIcon(util.imgResize(foodiSubtitle,"/images/foodiSubtitle.png")));
		contentPane.add(foodiSubtitle);
		
		businessButton = new JButton();
		businessButton.setBorderPainted(false);
		//businessButton.setFocusPainted(false);
		businessButton.setContentAreaFilled(false);
		businessButton.setIcon(new ImageIcon(FoodiMain.class.getResource("/images/businessButton.png")));
		businessButton.setBounds(116, 256, 230, 70);
		contentPane.add(businessButton);
		
		businessButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				businessButton.setIcon(new ImageIcon(FoodiMain.class.getResource("/images/businessButtonEntered.png")));

				businessButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				businessButton.setIcon(new ImageIcon(FoodiMain.class.getResource("/images/businessButton.png")));
				businessButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				new BusinessMain();
				setVisible(false);	//보이는 상태로 두는게 나은것 같다
			}
			});
		
		
		
		clientButton = new JButton();
		clientButton.setBorderPainted(false);
		//businessButton.setFocusPainted(false);
		clientButton.setContentAreaFilled(false);
		clientButton.setIcon(new ImageIcon(FoodiMain.class.getResource("/images/clientButton.png")));
		clientButton.setBounds(116, 380, 230, 70);
		contentPane.add(clientButton);
		
		clientButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				clientButton.setIcon(new ImageIcon(FoodiMain.class.getResource("/images/clientButtonEntered.png")));
				clientButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				clientButton.setIcon(new ImageIcon(FoodiMain.class.getResource("/images/clientButton.png")));
				clientButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				//클라이언트 객체를 인스턴스화한다.
				new FoodiMain().setVisible(false);	//프로젝트 발표시에는 보이는 상태로 두는게 나은것 같다
			}
			});
		
		mainPage = new JLabel();
		mainPage.setIcon(new ImageIcon(FoodiMain.class.getResource("/images/foodimain_2.jpg")));
		mainPage.setBounds(0, 0, 456, 548);
		contentPane.add(mainPage);
		
		
		
	}
}
