package businessUI.views;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businessUI.util.ResizableUtil;
import service.business.Business_Info_Service;
import service.business.Business_Info_ServiceImpl;

import java.awt.Toolkit;

public class BusinessMain extends JFrame {

	private JPanel contentPane;
	private JTextField business_num;
	private JPasswordField pw;
	private JLabel businessmain;
	private JButton login;
	private JButton join;
	public static String business_id;
	private ImageIcon businessMainImage = new ImageIcon("./images/business2_1.jpg");
	private ImageIcon joinButtonImage = new ImageIcon("./images/joinButton.png");
	private ImageIcon loginButtonImage = new ImageIcon("./images/loginButton.png");
	
	Business_Info_Service Binfo_service = new Business_Info_ServiceImpl();
	GetBInfo info = null;
	
	PrintStream ps;
	FileOutputStream fos;
	

	/**
	 * Launch the application.
	 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					BusinessMain frame = new BusinessMain();
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
					BusinessMain frame = new BusinessMain();
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
	public BusinessMain() {
		setTitle("Foodi");
		setIconImage(Toolkit.getDefaultToolkit().getImage(BusinessMain.class.getResource("/images/icon_foodTruck_64.png")));
		ResizableUtil util = new ResizableUtil();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 548);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		
		business_num = new JTextField();
		business_num.setBounds(225, 225, 165, 27);
		business_num.setBorder(null);
		contentPane.add(business_num);
		business_num.setColumns(10);
		
		pw = new JPasswordField();
		pw.setBounds(225, 291, 165, 27);
		pw.setBorder(null);
		contentPane.add(pw);
		
		JButton join = new JButton();
		
		join.setIcon(new ImageIcon(BusinessMain.class.getResource("/images/joinButton.png")));
		join.setBounds(75, 440, 118, 40);
		join.setBorderPainted(false);
		join.setFocusPainted(true);
		join.setContentAreaFilled(false);
		contentPane.add(join);
		
		join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				join.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				join.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				new JoinPage();
				setVisible(false);	
				}
			});
		
		
		login = new JButton();
		
		login.setIcon(new ImageIcon(BusinessMain.class.getResource("/images/loginButton.png")));
		login.setBounds(263, 440, 118, 40);
		login.setBorderPainted(false);
		//button.setFocusPainted(false);
		login.setContentAreaFilled(false);
		contentPane.add(login);
		
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				login.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				login.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){			//로그인 버튼 클릭
				business_id = business_num.getText();
				if(business_num.getText().equals("")&&pw.getText().equals("")){
					JOptionPane.showMessageDialog(new BusinessMain(), "사업자번호와 비밀번호를 입력해주세요.");
					
				}else if(Binfo_service.Owner_Login(business_id, pw.getText())){
					new LoginOrderList();
					
					try {
						fos = new FileOutputStream("./log/login.txt",true);
						ps = new PrintStream(fos);
						System.setOut(ps);
						
						 Calendar cal = Calendar.getInstance();
					     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					     System.out.println("loginTime : "+sdf.format(cal.getTime()));							
						System.out.println("business_id : "+business_num.getText());
						
					} catch (FileNotFoundException e1) {
						System.err.println("File not found.");						
					} catch (IOException e1) {
						System.err.println("Stream err...");
					}finally{
						
							try {
								if(fos!=null)	fos.close();		
								if(ps!=null)	ps.close();
							} catch (IOException e1) {
								e1.printStackTrace();
							}
						}
					
					setVisible(false);
				}else{
					JOptionPane.showMessageDialog(new BusinessMain(), "사업자번호와 비밀번호를 다시 확인해주세요.");
				}
			}
		});
		
		businessmain = new JLabel("");
		businessmain.setBounds(0, 0, 440, 511);
		businessmain.setIcon(new ImageIcon(util.imgResize(businessmain, "/images/businessMain.jpg")));

		contentPane.add(businessmain);
		
	}
	
}
class GetBInfo{
	String business_id;
	
	public GetBInfo() {
		super();
	}

	public GetBInfo(String business_id) {
		super();
		this.business_id = business_id;
	}

	public String getBusiness_info() {
		return business_id;
	}

	public void setBusiness_info(String business_id) {
		this.business_id = business_id;
	}
	
}
