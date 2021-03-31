package clientUI.views;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientUI.util.Util;
import service.client.Client_InfoService;
import service.client.Client_InfoServiceImpl;
import vo.client.Client_InfoVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JLabel btnHome;	// 홈 버튼
	private JTextField txtEmail;	//이메일 입력 창
	private JTextField txtPw1;	//비밀번호 입력 창
	private JTextField txtPw2;	//비밀번호 확인 입력 창	
	private JTextField txtRegNum;	//주민등록번호 입력 창
	private JTextField txtPhone;	//전화번호 입력 창
	private JTextField txtAddr;	//주소 입력 창
	private JLabel btnSignup;	//회원가입 완료 버튼
	
	Client_InfoVO user=null;	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
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
	public Signup() {
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
		
		btnHome = new JLabel("");	//홈 버튼
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setToolTipText("\uB85C\uADF8\uC778 \uD398\uC774\uC9C0");
		btnHome.setBounds(375, 22, 43, 43);
		contentPane.add(btnHome);
		
		txtEmail = new JTextField();	//이메일 입력 창
		txtEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtEmail.setText("\uC774\uBA54\uC77C \uC8FC\uC18C\uB97C \uC785\uB825\uD558\uC138\uC694");
		txtEmail.setToolTipText("E-mail");
		txtEmail.setBorder(null);
		txtEmail.setBounds(193, 157, 144, 22);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPw1 = new JTextField();	//비밀번호 입력 창
		txtPw1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtPw1.setToolTipText("\uBE44\uBC00\uBC88\uD638");
		txtPw1.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694");
		txtPw1.setColumns(10);
		txtPw1.setBorder(null);
		txtPw1.setBounds(193, 202, 143, 20);
		contentPane.add(txtPw1);
		
		txtPw2 = new JTextField();	//비밀번호 확인 입력 창
		txtPw2.setToolTipText("\uC804\uD654\uBC88\uD638");
		txtPw2.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC7AC\uC785\uB825\uD558\uC138\uC694.");
		txtPw2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtPw2.setColumns(10);
		txtPw2.setBorder(null);
		txtPw2.setBounds(193, 260, 143, 20);
		contentPane.add(txtPw2);
		
		txtRegNum = new JTextField();	//주민등록번호 입력 창
		txtRegNum.setToolTipText("\uC804\uD654\uBC88\uD638");
		txtRegNum.setText("\uC8FC\uBBFC\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694.");
		txtRegNum.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtRegNum.setColumns(10);
		txtRegNum.setBorder(null);
		txtRegNum.setBounds(193, 297, 143, 20);
		contentPane.add(txtRegNum);
		
		txtPhone = new JTextField();	//전화번호 입력 창
		txtPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtPhone.setToolTipText("\uC804\uD654\uBC88\uD638");
		txtPhone.setText("\uC804\uD654\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694.");
		txtPhone.setColumns(10);
		txtPhone.setBorder(null);
		txtPhone.setBounds(193, 337, 143, 20);
		contentPane.add(txtPhone);
		
		txtAddr = new JTextField();	//주소 입력 창
		txtAddr.setToolTipText("\uC8FC\uC18C");
		txtAddr.setText("\uC8FC\uC18C\uB97C \uC785\uB825\uD558\uC138\uC694.");
		txtAddr.setColumns(10);
		txtAddr.setBorder(null);
		txtAddr.setBounds(193, 395, 143, 20);
		contentPane.add(txtAddr);
		
		btnSignup = new JLabel("");	//회원가입 완료 버튼
		btnSignup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignup.setToolTipText("\uD68C\uC6D0\uAC00\uC785 \uC644\uB8CC");
		btnSignup.setBounds(148, 447, 145, 43);
		contentPane.add(btnSignup);
		
		JLabel lblSignup = new JLabel("");	//회원가입 페이지 이미지
		lblSignup.setBounds(0, 0, 440, 511);
		lblSignup.setIcon(new ImageIcon(util.imgResize(lblSignup, "/clientUI/images/page_signup.png")));
		contentPane.add(lblSignup);

	}
	
	/**
	 * 이벤트 메소드
	 */
	private void createEvents() {
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//홈 버튼 클릭
				new Login();
				setVisible(false);
			}
		});
		
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//이메일 입력 창 클릭
				txtEmail.setText(null);
			}
		});
		
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//이메일 입력 창 엔터키 누름
				if(e.getKeyChar()=='\n') {
					txtPw1.requestFocus();
				}
			}
		});
		
		txtPw1.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {	//비밀번호 입력 창 focus Gained
				txtPw1.setText(null);
			}
		});
		
		txtPw1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//비밀번호 입력 창 엔터 누름
				if(e.getKeyChar()=='\n'){
					txtPw2.requestFocus();
				}
			}
		});
		
		txtPw2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//비밀번호 확인 입력 창 엔터
				if(e.getKeyChar()=='\n'){
					txtRegNum.requestFocus();
				}
			}
		});
		
		txtRegNum.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//주민등록번호 입력 창 엔터 누름
				if(e.getKeyChar()=='\n'){
					txtPhone.requestFocus();
				}
			}
		});
		txtRegNum.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {	//주민등록번호 입력 창 focus Gained
				txtRegNum.setText(null);
				
			}
		});
		
		txtPw2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {	//비밀번호 확인 입력 창 focus Gained
				txtPw2.setText(null);
			}
		});
		
		txtPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {	//전화번호 입력 창 focus Gained
				txtPhone.setText(null);
			}
		});
		
		
		
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//전화번호 입력 창 엔터 누름
				if(e.getKeyChar()=='\n'){
					txtAddr.requestFocus();
				}
			}
		});
		
		txtAddr.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {	//주소 입력 창 focus Gained
				txtAddr.setText(null);
			}
		});
		
		txtAddr.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//주소 입력 창 엔터 누름
				if(e.getKeyChar()=='\n'){
					join();					
				}
			}
		});
		
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				join();
			}
		});
	}
	
	/**
	 * 회원가입 버튼 클릭 시 수행 메소드
	 */
	protected void join() {
		//String jumin="92512131";
		Client_InfoService join=new Client_InfoServiceImpl();
		if(txtPw1.getText().equals(txtPw2.getText())){
		
		join.insertClientInfo(user=new Client_InfoVO(txtEmail.getText(),txtPw1.getText(),
				txtRegNum.getText(),txtPhone.getText(),txtAddr.getText()));
		
		JOptionPane.showMessageDialog(contentPane, "가입에 성공했습니다");
		
		new Login();
		setVisible(false);

		//} else if(txtPw1.getText().equals(txtPw2.getText())==false){
		} else {
			JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다");
			new Signup();
			setVisible(false);
		}
		
		
		
	}
	
	
}
