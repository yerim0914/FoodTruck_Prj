package clientUI.views;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientUI.util.Util;
import service.client.Client_InfoService;
import service.client.Client_InfoServiceImpl;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Login extends JFrame {	//로그인 페이지

	private JPanel contentPane;
	private JTextField txtEmail;	//이메일 입력 창
	private JTextField txtPw;	//비밀번호 입력 창
	private JLabel btnLogin;	//로그인 버튼
	private JLabel btnFindAcc;	//아이디/비밀번호 찾기 버튼
	private JLabel btnHome;	//홈 버튼
	private JLabel btnSignup;	//회원가입 버튼
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		initialize();
		createEvents();
		
	}
	
	/**
	 * 초기화 메소드
	 */
	private void initialize() {
		setTitle("Foodi");	//윈도우 창
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/clientUI/images/icon_foodTruck_64.png")));	//창 아이콘
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 549);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Util util = new Util();
		
		/*
		btnHome = new JLabel("");	//홈 버튼
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setToolTipText("HOME");
		btnHome.setBounds(94, 63, 244, 81);
		contentPane.add(btnHome);
		*/
		
		txtEmail = new JTextField();	//이메일 입력 창
		txtEmail.setText("\uC774\uBA54\uC77C \uC8FC\uC18C\uB97C \uC785\uB825\uD558\uC138\uC694.");
		txtEmail.setBorder(null);
		txtEmail.setToolTipText("\uC774\uBA54\uC77C");
		txtEmail.setBounds(222, 235, 152, 29);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPw = new JTextField();	//비밀번호 입력 창
		txtPw.setBorder(null);
		txtPw.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694.");
		txtPw.setToolTipText("\uBE44\uBC00\uBC88\uD638");
		txtPw.setColumns(10);
		txtPw.setBounds(222, 304, 152, 29);
		contentPane.add(txtPw);
		
		btnLogin = new JLabel("");	//로그인 버튼
		btnLogin.setToolTipText("\uB85C\uADF8\uC778");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setBorder(null);
		btnLogin.setBounds(158, 383, 125, 38);
		contentPane.add(btnLogin);
		
		btnFindAcc = new JLabel("");	//아이디/비밀번호 찾기 버튼
		btnFindAcc.setToolTipText("\uC544\uC774\uB514/\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnFindAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFindAcc.setBounds(143, 440, 152, 15);
		contentPane.add(btnFindAcc);
		
		btnSignup = new JLabel("");	//회원가입 버튼
		btnSignup.setToolTipText("\uD68C\uC6D0\uAC00\uC785");
		btnSignup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignup.setBounds(145, 483, 273, 15);
		contentPane.add(btnSignup);
		
		JLabel lblLogin = new JLabel("");	//로그인 페이지 이미지
		lblLogin.setBounds(0, 0, 440, 511);
		lblLogin.setIcon(new ImageIcon(util.imgResize(lblLogin, "/clientUI/images/page_login.png")));
		contentPane.add(lblLogin);
	}

	/**
	 * 이벤트 메소드
	 */
	private void createEvents() {
		/*
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//홈 버튼 클릭
				new Main();
				setVisible(false);
			}
		});
		*/
		
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//이메일 입력 창 클릭
				txtEmail.setText(null);
			}
		});

		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//이메일 입력 창 엔터 누름
				if(e.getKeyChar()=='\n'){
					txtPw.requestFocus();
				}
			}
		});
		
		txtPw.addFocusListener(new FocusAdapter() { 
			@Override
			public void focusGained(FocusEvent e) {	// 비밀번호 입력 창 focus Gained
				txtPw.setText(null);
			}
		});
		
		txtPw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//비밀번호 입력 창 클릭
				txtPw.setText(null);
			}
		});
		
		txtPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//비밀번호 입력 창 엔터
				login();
			}

		});
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//로그인 버튼 클릭
				login();
			}
		});
		
		btnFindAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	// 아이디/비밀번호 찾기 클릭
				//////////////////////////////////
				//찾을건가요? 구현하나요?
				///////////////////////////.///////
			}
		});
		
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//회원가입 버튼 클릭
				new Signup();
				setVisible(false);
				//dispose();
				
			}
		});
		
		
	}

	private void login() {

		Client_InfoService login = new Client_InfoServiceImpl();
		
		if(login.Login(txtEmail.getText(), txtPw.getText())){
			JOptionPane.showMessageDialog(contentPane, "로그인 성공");
			new Main();
			setVisible(false);
			
		} else {

			JOptionPane.showMessageDialog(contentPane, "로그인 실패");
			new Login();
			setVisible(false);
		}
		
		
	}
}
