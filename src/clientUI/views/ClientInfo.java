package clientUI.views;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientUI.util.Util;
import dao.client.Client_InfoDAO;
import service.client.Client_InfoService;
import service.client.Client_InfoServiceImpl;
import service.shoplist.ShopListService;
import service.shoplist.ShopListServiceImpl;
import vo.client.Client_InfoVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class ClientInfo extends JFrame {

	private JPanel contentPane;
	private JLabel btnHome;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAddr;
	private JLabel btnUpdate;
	private JLabel btnConfirm;
	private JLabel btnDelete;
	private JLabel btnMenu;
	private JLabel lblClientMenu;
	Client_InfoService cis=new Client_InfoServiceImpl();
	ShopListService service1= new ShopListServiceImpl();
	private JLabel btnUpdatePw;
	private JTextField txtPw;
	Client_InfoVO user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientInfo frame = new ClientInfo();
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
	public ClientInfo() {
		initialize();
		createEvents();
		readClientInfo();

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
				

		/////////////////////////////////////////////////////
		// 회원 메뉴 시작
		////////////////////////////////////////////////////
	
		JPanel panelMenu = new JPanel();	//회원메뉴 panel		
		panelMenu.setOpaque(false);
		panelMenu.setBounds(261, 0, 76, 79);
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
		btnMenu.setBounds(339, 23, 31, 34);
		btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnMenu);
		
		////////////////////////////////////////
		// 회원 메뉴 끝
		///////////////////////////////////////////
		
		btnHome = new JLabel("");	//홈 버튼
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setToolTipText("HOME");
		btnHome.setBounds(374, 21, 42, 41);
		contentPane.add(btnHome);
				
		txtEmail = new JTextField();
		txtEmail.setOpaque(false);
		txtEmail.setEditable(false);
		txtEmail.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtEmail.setBorder(null);
		txtEmail.setBounds(168, 127, 191, 21);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPw = new JTextField();
		txtPw.setText((String) null);
		txtPw.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtPw.setColumns(10);
		txtPw.setBorder(null);
		txtPw.setBounds(168, 168, 188, 21);
		contentPane.add(txtPw);
		
		txtPhone = new JTextField();	//전화번호 입력 창
		txtPhone.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtPhone.setColumns(10);
		txtPhone.setBorder(null);
		txtPhone.setBounds(168, 207, 188, 22);
		contentPane.add(txtPhone);
		
		txtAddr = new JTextField();	//주소 입력 창
		txtAddr.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtAddr.setColumns(10);
		txtAddr.setBorder(null);
		txtAddr.setBounds(168, 246, 189, 72);
		contentPane.add(txtAddr);
		
		btnUpdate = new JLabel("");	//수정 버튼
		btnUpdate.setBorder(null);
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setToolTipText("\uC218\uC815");
		btnUpdate.setBounds(261, 459, 126, 31);
		contentPane.add(btnUpdate);
		
		btnConfirm = new JLabel("");	//확인 버튼
		btnConfirm.setBorder(null);
		btnConfirm.setToolTipText("\uD655\uC778");
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirm.setBounds(182, 353, 83, 31);
		contentPane.add(btnConfirm);
		
		btnDelete = new JLabel("");	//탈퇴 버튼
		btnDelete.setBorder(null);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setToolTipText("\uD0C8\uD1F4");
		btnDelete.setBounds(66, 388, 42, 31);
		contentPane.add(btnDelete);
		
		btnUpdatePw = new JLabel("");	//비밀번호 변경 버튼
		btnUpdatePw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdatePw.setBorder(null);
		btnUpdatePw.setBounds(54, 450, 155, 40);
		contentPane.add(btnUpdatePw);
		
		JLabel lblClientInfo = new JLabel("");	//회원정보 페이지 이미지
		lblClientInfo.setBounds(0, 0, 440, 511);
		lblClientInfo.setIcon(new ImageIcon(util.imgResize(lblClientInfo, "/clientUI/images/page_ClientInfo.png")));
		contentPane.add(lblClientInfo);

	}

	
	/**
	 * 회원정보 불러와서 setText 메소드
	 */
	private void readClientInfo() {
		////////////////////////////////////////
		//
		/////////////////////////////////////////
		txtEmail.setText(Client_InfoDAO.log.getClient_id());		
		txtPhone.setText(Client_InfoDAO.log.getClient_phone());
		txtAddr.setText(Client_InfoDAO.log.getClient_addr());
		
	}
	
	
	/**
	 * 이벤트 메소드	
	 */
	private void createEvents() {
				
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//홈 버튼 클릭
				/////////////////////////////////
				//메인 페이지로 이동
				/////////////////////////////////
				new Main();
				setVisible(false);
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
		
		txtPw.addKeyListener(new KeyAdapter() {	//비밀번호 입력 창
			@Override
			public void keyPressed(KeyEvent e) {	//비밀번호 입력 창 엔터 누름
				if(e.getKeyChar()=='\n'){
					txtPhone.requestFocus();
				}
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

		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//수정 버튼 클릭
				
				if(txtPw.getText().equals(Client_InfoDAO.log.getPw())){
					
					cis.updateClientInfo(Client_InfoDAO.log.getClient_id(),Client_InfoDAO.log.getPw(), 
							txtPhone.getText(),txtAddr.getText());
					System.out.println("변경.");
					JOptionPane.showMessageDialog(contentPane, "정보 변경 완료");
						
					
				}
				else{
					JOptionPane.showMessageDialog(contentPane, "비밀번호 확인해주세요");
					txtPw.setText("");		
					
			
					System.out.println("안옴");
				}
				
			}
		});
		
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//확인 버튼 클릭
				
				new Main();
				setVisible(false);
			

			}
		});

		btnUpdatePw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//비밀번호 변경 버튼 클릭
				
				new UpdatePw();
				setVisible(false);
				
			}
		});
		
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//탈퇴 버튼 클릭
				
				Client_InfoService service = new Client_InfoServiceImpl();
				
				String pw = JOptionPane.showInputDialog("비밀번호를 입력하세요.");
				
				if(Client_InfoDAO.log.getPw().equals(pw)){
					int delete = JOptionPane.showConfirmDialog(contentPane, "탈퇴하시겠습니까?");
					
					if(delete == 0){ //0은 예
						
						service.deleteClientInfo(Client_InfoDAO.log.getClient_id());	//클라이언트 아이디 불러오기
						JOptionPane.showMessageDialog(contentPane, "탈퇴완료");
						new Login();
						setVisible(false);
						
					} else {
						
						new ClientInfo();
						setVisible(false);
					}
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "비밀번호가 일치하지 않습니다");
					new ClientInfo();
					setVisible(false);
				}
				
				
			}
		});
		
	}

}
