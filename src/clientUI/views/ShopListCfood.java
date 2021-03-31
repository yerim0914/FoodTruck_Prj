package clientUI.views;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientUI.util.Util;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.AbstractListModel;

public class ShopListCfood extends JFrame {

	private JLabel lblMenu;
	private JLabel btnMenu; 
	private JPanel contentPane;
	private JList listFood;
	private JLabel btnBack;
	private JLabel btnGo;
	private JLabel btnHome;
	clientUI.views.Main s_list=null;

	private JLabel lblClientMenu;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopListCfood frame = new ShopListCfood();
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
	public ShopListCfood() {

		initialize();
		createEvents();
	}

	/**
	 * 초기화 메소드
	 */
	public void initialize(){
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
		
		JLabel lblfood = new JLabel("\uC911\uC2DD");
		lblfood.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		lblfood.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		lblfood.setBounds(148, 25, 109, 54);
		contentPane.add(lblfood);
			
		btnMenu.setToolTipText("");
		btnMenu.setBounds(339, 23, 31, 34);
		btnMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnMenu);
		
		////////////////////////////////////////
		// 회원 메뉴 끝
		///////////////////////////////////////////

		
		btnHome = new JLabel("");	//홈 버튼
		btnHome.setBounds(394, 25, 34, 30);
		btnHome.setToolTipText("HOME");
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setBorder(null);
		contentPane.add(btnHome);
		
		btnBack = new JLabel("");	//뒤로 가기 버튼
		btnBack.setBounds(31, 25, 51, 32);
		btnBack.setIcon(new ImageIcon(util.imgResize(btnBack, "/clientUI/images/icon_back.png")));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		contentPane.add(btnBack);
		
		JScrollPane scroPane = new JScrollPane();
		scroPane.setBounds(33, 122, 377, 330);
		contentPane.add(scroPane);
		
		listFood = new JList();	//업체 리스트
		
		////////////////////////////////////////////
		// 업체명 불러오기
		////////////////////////////////////////////////////
				
		listFood.setModel(new AbstractListModel() {
			
			public int getSize() {
				return s_list.values.length;
			}
			public Object getElementAt(int index) {
				return s_list.values[index];
			}
		});
		listFood.setBorder(null);
		scroPane.setViewportView(listFood);
		
		btnGo = new JLabel("");
		btnGo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnGo.setToolTipText("\uC774\uB3D9");
		btnGo.setBorder(null);
		btnGo.setBounds(198, 462, 45, 39);
		contentPane.add(btnGo);
		
		JLabel lblShopList = new JLabel("");
		lblShopList.setBounds(0, 0, 440, 511);
		lblShopList.setIcon(new ImageIcon(util.imgResize(lblShopList, "/clientUI/images/page_shopInfoList.png")));
		contentPane.add(lblShopList);
		
		////////////////////////////////////////
		// 회원 메뉴 끝
		///////////////////////////////////////////
		
	}
	private void createEvents() {
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//홈 버튼 클릭
				new Main();
				setVisible(false);
			}	
		});
		
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//이동버튼 클릭
				System.out.println("이동!");
				///////////////////////////////////////
				// 해당 업체로 이동
				///////////////////////////////////////////
			}
		});
		
		btnBack.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {	//뒤로가기 버튼 클릭
				new Main();
				setVisible(false);
			}
		});
		
		listFood.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//리스트에서 업체명 클릭
				///////////////////////////////////////
				////리스트에서 업체명 클릭
				//////////////////////////////////////////////
				System.out.println("업체명 클릭");
			}
		});
		
	}
}
