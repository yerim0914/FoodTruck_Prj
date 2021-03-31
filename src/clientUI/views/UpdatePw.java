package clientUI.views;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientUI.util.Util;
import dao.client.Client_InfoDAO;
import service.client.Client_InfoService;
import service.client.Client_InfoServiceImpl;
import vo.client.Client_InfoVO;

import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UpdatePw extends JFrame {

	private JPanel contentPane;
	private JLabel lblClientMenu;
	private JLabel btnMenu;
	private JTextField txtPw;
	private JTextField txtNewPw1;
	private JTextField txtNewPw2;
	private JLabel btnConfirm;
	Client_InfoService cis=new Client_InfoServiceImpl();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePw frame = new UpdatePw();
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
	public UpdatePw() {
		initialize();
		createEvents();
		
	}

	private void initialize() {
		setTitle("Foodi");	//윈도우 창
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/clientUI/images/icon_foodTruck_64.png")));	//창 아이콘
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 549);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		Util util = new Util();
		contentPane.setLayout(null);
				

		/////////////////////////////////////////////////////
		// 회원 메뉴 시작
		////////////////////////////////////////////////////
	
		JPanel panelMenu = new JPanel();	//회원메뉴 panel		
		panelMenu.setBounds(261, 0, 76, 79);
		panelMenu.setOpaque(false);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel btnClientInfo = new JLabel("");	//회원정보 버튼	
		btnClientInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//회원정보 버튼 클릭
				new ClientInfo();
				
				setVisible(false);
				///////////////////////////////
				// 회원정보 페이지로 이동
				//////////////////////////////////////
			}
		});
		btnClientInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientInfo.setBounds(0, 0, 76, 26);
		panelMenu.add(btnClientInfo);
		
		JLabel btnBookmark = new JLabel("");	//즐겨찾기 버튼
		btnBookmark.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//즐겨찾기 버튼 클릭
				new ClientBookmark();
				setVisible(false);
				///////////////////////////////////
				// 즐겨찾기 페이지로 이동
				///////////////////////////////////////
			}
		});
		btnBookmark.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBookmark.setBounds(0, 28, 76, 25);
		panelMenu.add(btnBookmark);
		
		JLabel btnOrderList = new JLabel("");	//주문내역 버튼
		btnOrderList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//주문내역 버튼 클릭
				new ClientOrderList();
				setVisible(false);
				////////////////////////////////////
				//주문내역 페이지로 이동
				////////////////////////////////////				
			}
		});
		btnOrderList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOrderList.setBounds(0, 57, 76, 22);
		panelMenu.add(btnOrderList);
		
		lblClientMenu = new JLabel("");	//회원 메뉴 이미지
		lblClientMenu.setBounds(0, 0, 76, 79);
		panelMenu.add(lblClientMenu);
		lblClientMenu.setIcon(new ImageIcon(util.imgResize(lblClientMenu, "/clientUI/images/lbl_clientMenu.png")));
		lblClientMenu.setVisible(false);
		
		btnMenu = new JLabel("");	//회원 메뉴  버튼
		btnMenu.setBounds(339, 23, 31, 34);
		btnMenu.addMouseListener(new MouseAdapter() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					lblClientMenu.setVisible(true);
				}
				if(e.getClickCount()==1){
					lblClientMenu.setVisible(false);
				}
			}

		});
			
		btnMenu.setToolTipText("");
		btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnMenu);
		
		txtPw = new JTextField();	//비밀번호 입력 창
		txtPw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtPw.setBounds(214, 158, 167, 28);
		contentPane.add(txtPw);
		txtPw.setColumns(10);
		
		txtNewPw1 = new JTextField();
		txtNewPw1.setColumns(10);
		txtNewPw1.setBounds(214, 216, 167, 28);
		contentPane.add(txtNewPw1);
		
		txtNewPw2 = new JTextField();	//새 비밀번호 확인 입력 창
		txtNewPw2.setColumns(10);
		txtNewPw2.setBounds(214, 292, 167, 28);
		contentPane.add(txtNewPw2);
		
		btnConfirm = new JLabel("");	//확인 버튼
		btnConfirm.setBorder(null);
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirm.setBounds(178, 414, 85, 34);
		contentPane.add(btnConfirm);
		
		JLabel lblUpdatePw = new JLabel("");
		lblUpdatePw.setBounds(0, 0, 440, 511);
		lblUpdatePw.setIcon(new ImageIcon(util.imgResize(lblUpdatePw, "/clientUI/images/page_updatePw.png")));
		contentPane.add(lblUpdatePw);
		
		////////////////////////////////////////
		// 회원 메뉴 끝
		///////////////////////////////////////////
		
		
	}

	protected void update() {
		
		if(txtNewPw2.getText().equals(txtNewPw1.getText())){
			if(txtPw.getText().equals(Client_InfoDAO.log.getPw())){
				cis.updateClientInfo(Client_InfoDAO.log.getClient_id(),txtNewPw2.getText(), 
						Client_InfoDAO.log.getClient_phone(),Client_InfoDAO.log.getClient_addr());
				JOptionPane.showMessageDialog(contentPane, "비밀번호 변경 완료");
				new ClientInfo();
				setVisible(false);
				
				
			}
		}
		else{
			JOptionPane.showMessageDialog(contentPane, "새비밀번호 확인");
			txtNewPw2.setText("");
			txtNewPw1.setText("");
		}
		if(txtPw.getText().equals(Client_InfoDAO.log.getPw())){
			
			System.out.println("변경.");
			
				
			
		}
		else{
			JOptionPane.showMessageDialog(contentPane, "비밀번호 확인해주세요");
			txtPw.setText("");		
			
	
			System.out.println("안옴");
		}
		
	}

	private void createEvents() {
		
		txtPw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//비밀번호 입력 창 엔터 누름
				if(e.getKeyChar()=='\n'){
					txtNewPw1.requestFocus();
				}
			}
		});
		
		txtNewPw1.addKeyListener(new KeyAdapter() {	//새 비밀번호 입력 창
			@Override
			public void keyPressed(KeyEvent e) {	//새 비밀번호 입력 창 엔터 누름
				if(e.getKeyChar()=='\n'){
					txtNewPw2.requestFocus();
				}
			}
		});
		
		txtNewPw2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//새 비밀번호 확인 입력 창 엔터 누름
				update();
			}
		});
		
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//확인 버튼 클릭
				update();
			}
		});
		
		
	}

}
