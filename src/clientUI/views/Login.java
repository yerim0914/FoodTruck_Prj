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

public class Login extends JFrame {	//�α��� ������

	private JPanel contentPane;
	private JTextField txtEmail;	//�̸��� �Է� â
	private JTextField txtPw;	//��й�ȣ �Է� â
	private JLabel btnLogin;	//�α��� ��ư
	private JLabel btnFindAcc;	//���̵�/��й�ȣ ã�� ��ư
	private JLabel btnHome;	//Ȩ ��ư
	private JLabel btnSignup;	//ȸ������ ��ư
	

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
	 * �ʱ�ȭ �޼ҵ�
	 */
	private void initialize() {
		setTitle("Foodi");	//������ â
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/clientUI/images/icon_foodTruck_64.png")));	//â ������
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 549);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Util util = new Util();
		
		/*
		btnHome = new JLabel("");	//Ȩ ��ư
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setToolTipText("HOME");
		btnHome.setBounds(94, 63, 244, 81);
		contentPane.add(btnHome);
		*/
		
		txtEmail = new JTextField();	//�̸��� �Է� â
		txtEmail.setText("\uC774\uBA54\uC77C \uC8FC\uC18C\uB97C \uC785\uB825\uD558\uC138\uC694.");
		txtEmail.setBorder(null);
		txtEmail.setToolTipText("\uC774\uBA54\uC77C");
		txtEmail.setBounds(222, 235, 152, 29);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPw = new JTextField();	//��й�ȣ �Է� â
		txtPw.setBorder(null);
		txtPw.setText("\uBE44\uBC00\uBC88\uD638\uB97C \uC785\uB825\uD558\uC138\uC694.");
		txtPw.setToolTipText("\uBE44\uBC00\uBC88\uD638");
		txtPw.setColumns(10);
		txtPw.setBounds(222, 304, 152, 29);
		contentPane.add(txtPw);
		
		btnLogin = new JLabel("");	//�α��� ��ư
		btnLogin.setToolTipText("\uB85C\uADF8\uC778");
		btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnLogin.setBorder(null);
		btnLogin.setBounds(158, 383, 125, 38);
		contentPane.add(btnLogin);
		
		btnFindAcc = new JLabel("");	//���̵�/��й�ȣ ã�� ��ư
		btnFindAcc.setToolTipText("\uC544\uC774\uB514/\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnFindAcc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFindAcc.setBounds(143, 440, 152, 15);
		contentPane.add(btnFindAcc);
		
		btnSignup = new JLabel("");	//ȸ������ ��ư
		btnSignup.setToolTipText("\uD68C\uC6D0\uAC00\uC785");
		btnSignup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSignup.setBounds(145, 483, 273, 15);
		contentPane.add(btnSignup);
		
		JLabel lblLogin = new JLabel("");	//�α��� ������ �̹���
		lblLogin.setBounds(0, 0, 440, 511);
		lblLogin.setIcon(new ImageIcon(util.imgResize(lblLogin, "/clientUI/images/page_login.png")));
		contentPane.add(lblLogin);
	}

	/**
	 * �̺�Ʈ �޼ҵ�
	 */
	private void createEvents() {
		/*
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//Ȩ ��ư Ŭ��
				new Main();
				setVisible(false);
			}
		});
		*/
		
		txtEmail.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//�̸��� �Է� â Ŭ��
				txtEmail.setText(null);
			}
		});

		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//�̸��� �Է� â ���� ����
				if(e.getKeyChar()=='\n'){
					txtPw.requestFocus();
				}
			}
		});
		
		txtPw.addFocusListener(new FocusAdapter() { 
			@Override
			public void focusGained(FocusEvent e) {	// ��й�ȣ �Է� â focus Gained
				txtPw.setText(null);
			}
		});
		
		txtPw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//��й�ȣ �Է� â Ŭ��
				txtPw.setText(null);
			}
		});
		
		txtPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//��й�ȣ �Է� â ����
				login();
			}

		});
		
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//�α��� ��ư Ŭ��
				login();
			}
		});
		
		btnFindAcc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	// ���̵�/��й�ȣ ã�� Ŭ��
				//////////////////////////////////
				//ã���ǰ���? �����ϳ���?
				///////////////////////////.///////
			}
		});
		
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//ȸ������ ��ư Ŭ��
				new Signup();
				setVisible(false);
				//dispose();
				
			}
		});
		
		
	}

	private void login() {

		Client_InfoService login = new Client_InfoServiceImpl();
		
		if(login.Login(txtEmail.getText(), txtPw.getText())){
			JOptionPane.showMessageDialog(contentPane, "�α��� ����");
			new Main();
			setVisible(false);
			
		} else {

			JOptionPane.showMessageDialog(contentPane, "�α��� ����");
			new Login();
			setVisible(false);
		}
		
		
	}
}
