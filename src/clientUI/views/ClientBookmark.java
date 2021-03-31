package clientUI.views;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientUI.util.Util;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ClientBookmark extends JFrame {

	private JPanel contentPane;
	//private JList listBookmark;
	private JList<String> listBookmark;
	private JLabel btnHome;
	private String values[];
	private JLabel btnClientInfo;
	private JLabel btnBookmark;
	private JLabel btnSub;
	private JLabel lblClientMenu;
	private JLabel btnMenu;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientBookmark frame = new ClientBookmark();
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
	public ClientBookmark() {
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
		btnHome.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setToolTipText("HOME");
		btnHome.setBounds(382, 23, 28, 32);
		contentPane.add(btnHome);

		/////////////////////////////////////////////////////
		// 회원 메뉴 시작
		////////////////////////////////////////////////////
	
		JPanel paneMenu = new JPanel();	//회원메뉴 panel		
		paneMenu.setOpaque(false);
		paneMenu.setBounds(261, 0, 76, 79);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
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
		paneMenu.add(btnClientInfo);
		
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
		paneMenu.add(btnBookmark);
		
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
		btnOrderList.setBounds(0, 53, 76, 26);
		paneMenu.add(btnOrderList);
		
		lblClientMenu = new JLabel("");	//회원 메뉴 이미지
		lblClientMenu.setBounds(0, 0, 76, 79);
		paneMenu.add(lblClientMenu);
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
		
	
		JScrollPane scrBookmark = new JScrollPane(); //즐겨찾기 스크롤 pane
		scrBookmark.setBorder(null);
		scrBookmark.setBounds(70, 103, 303, 311);
		contentPane.add(scrBookmark);
		
		listBookmark = new JList();	//즐겨찾기 목록
		readBookmark();
		//listBookmark.setModel(new AbstractListModel() {
		listBookmark.setModel(new AbstractListModel<String>() {
			//////////////////////////////////////////////
			// 즐겨찾기 목록 가져오기
			///////////////////////////////////////////////
			public int getSize() {
				return values.length;
			}
			//public Object getElementAt(int index) {
			public String getElementAt(int index) {
				return values[index];
			}
		});
		listBookmark.setFont(new Font("맑은 고딕", Font.PLAIN, 15));

		scrBookmark.setViewportView(listBookmark);
		
		btnSub = new JLabel("");	//제거 버튼
		btnSub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSub.setToolTipText("\uC990\uACA8\uCC3E\uAE30 \uB9AC\uC2A4\uD2B8\uC5D0\uC11C \uC81C\uC678\uD569\uB2C8\uB2E4.");
		btnSub.setBounds(137, 443, 43, 44);
		contentPane.add(btnSub);
		
		btnBookmark = new JLabel("");	//이동 버튼
		btnBookmark.setBorder(null);
		btnBookmark.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBookmark.setToolTipText("\uC120\uD0DD\uD55C \uC5C5\uCCB4 \uD398\uC774\uC9C0\uB85C \uC774\uB3D9\uD569\uB2C8\uB2E4.");
		btnBookmark.setBounds(261, 443, 43, 44);
		contentPane.add(btnBookmark);
		
		JLabel lblBookmark = new JLabel("");	//즐겨찾기 페이지 이미지
		lblBookmark.setBounds(0, 0, 440, 511);
		lblBookmark.setIcon(new ImageIcon(util.imgResize(lblBookmark, "/clientUI/images/page_ClientBookmark.png")));
		contentPane.add(lblBookmark);
		
	}

	/**
	 * 북마크 업체 배열화 메소드
	 * 초기화 메소드에 포함시키는 게 더 좋은가??
	 * 업체명만 나열해도 괜찮은가요????? 업체명만 나열합시다ㅜㅜㅜㅜㅜ
	 */
	private void readBookmark() {
		/////////////////////////////////////////////
		//즐겨찾기 업체 불러오는 메소드
		/////////////////////////////////////////////
		values = new String[30];
		for(int i=0;i<30;i++){
			values[i] = "테스트테스트세트세틋테ㅡㅅ테스트테스트세트세틋테ㅡㅅ테스트테스트세트세틋테ㅡㅅ테스트테스트세트세틋테ㅡㅅ"+i; 
		}
	}

	/**
	 * 이벤트 메소드
	 */
	private void createEvents() {
		
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//홈 버튼 클릭
				////////////////////////////////////////
				//메인 페이지로 이동
				/////////////////////////////////////////
				new Main();
				setVisible(false);
			}
		});
		
		listBookmark.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//리스트에서 한 업체 클릭
				/////////////////////////////////
				// 업체 선택 
				/////////////////////////////////

			}
		});
		
		btnSub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//제거 버튼 클릭
				//////////////////////////////////
				// 즐겨찾기 리스트에서 제외합니다
				//////////////////////////////////////////
			}
		});
		
		btnBookmark.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//이동 버튼 클릭
				///////////////////////////////////
				// 선택한 업체 페이지로 이동
				////////////////////////////////////
			}
		});


		
	}
}
