package clientUI.views;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientUI.util.Util;
import service.shoplist.ShopListService;
import service.shoplist.ShopListServiceImpl;
import vo.client.ShopListVO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Cursor;
import java.awt.Toolkit;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JSplitPane;

public class Main extends JFrame {	//메인페이지


	private JPanel contentPane;
	private JTextField txtSearch;	//검색 입력 창
	private JLabel btnSearch;	//검색 돋보기 버튼
	private JLabel btnMenu;	//회원정보 버튼
	private JLabel btnHome;	// 홈 버튼
	private JLabel lblMenu;
	private JLabel btnType1;	//한식 버튼
	private JLabel btnType2; 
	private JLabel btnType3;
	private JLabel btnType4;
	private JLabel btnType5;
	private JLabel btnType6;
	private JLabel btnType7;
	private JLabel btnType8;
	private JLabel btnType9;
	private JLabel btnSignup;
	static int tabIndex;
	ShopListService sls= new ShopListServiceImpl();
	List<ShopListVO> values_l=new ArrayList<ShopListVO>();
	static String[] values =null;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		
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
	
		JPanel panelMenu = new JPanel();	//회원메뉴 panel		
		panelMenu.setOpaque(false);
		panelMenu.setBounds(275, 0, 76, 79);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		JLabel btnClientInfo = new JLabel("");	//회원정보 버튼	
		btnClientInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//회원정보 버튼 클릭
				new ClientInfo();
				setVisible(false);
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
				
			}
		});
		btnOrderList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOrderList.setBounds(0, 57, 76, 22);
		panelMenu.add(btnOrderList);
		
		lblMenu = new JLabel("");	//회원 메뉴 이미지
		lblMenu.setBounds(0, 0, 76, 79);
		panelMenu.add(lblMenu);
		lblMenu.setIcon(new ImageIcon(util.imgResize(lblMenu, "/clientUI/images/lbl_clientMenu.png")));
		lblMenu.setVisible(false);
		
		btnMenu = new JLabel("");	//회원 메뉴  버튼
		btnMenu.addMouseListener(new MouseAdapter() {

			
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==2){
					lblMenu.setVisible(true);
				}
				if(e.getClickCount()==1){
					lblMenu.setVisible(false);
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
		btnHome.setBounds(396, 28, 30, 29);
		contentPane.add(btnHome);
		btnHome.setToolTipText("HOME");
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		txtSearch = new JTextField();	//검색 입력 창
		txtSearch.setBorder(null);
		txtSearch.setText("검색어를 입력하세요");
		txtSearch.setBounds(37, 26, 190, 29);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		

		btnSearch = new JLabel("");	//검색 돋보기 버튼
		btnSearch.setToolTipText("\uAC80\uC0C9");
		btnSearch.setBounds(243, 26, 31, 29);
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnSearch);
		

		
		JPanel panel = new JPanel();	//업종분류 panel
		panel.setOpaque(false);
		panel.setBounds(23, 100, 394, 356);
		contentPane.add(panel);
		panel.setLayout(null);
		
		btnType1 = new JLabel("");	//한식 버튼
		btnType1.setToolTipText("\uD55C\uC2DD");
		btnType1.setBounds(17, 15, 80, 80);
		btnType1.setIcon(new ImageIcon(util.imgResize(btnType1, "/clientUI/images/icon_type1.png")));
		btnType1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnType1);
		
		btnType2 = new JLabel("");	//양식 버튼
		btnType2.setToolTipText("\uC591\uC2DD");
		btnType2.setBounds(145, 15, 80, 80);
		btnType2.setIcon(new ImageIcon(util.imgResize(btnType2, "/clientUI/images/icon_type2.png")));
		btnType2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnType2);
		
		btnType3 = new JLabel("");	//중식
		btnType3.setToolTipText("\uC911\uC2DD");
		btnType3.setBounds(290, 15, 80, 80);
		btnType3.setIcon(new ImageIcon(util.imgResize(btnType3, "/clientUI/images/icon_type3.png")));
		btnType3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnType3);
		
		
		btnType4 = new JLabel("");	//일식
		btnType4.setToolTipText("\uC77C\uC2DD");
		btnType4.setBounds(18, 135, 80, 80);
		btnType4.setIcon(new ImageIcon(util.imgResize(btnType4, "/clientUI/images/icon_type4.png")));
		btnType4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnType4);
		
		btnType5 = new JLabel("");	//분식
		btnType5.setToolTipText("\uBD84\uC2DD");
		btnType5.setBounds(145, 129, 90, 90);
		btnType5.setIcon(new ImageIcon(util.imgResize(btnType5, "/clientUI/images/icon_type5.png")));
		btnType5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnType5);
		
		btnType6 = new JLabel("");	//베이커리
		btnType6.setToolTipText("\uBCA0\uC774\uCEE4\uB9AC");
		btnType6.setBounds(290, 135, 80, 80);
		btnType6.setIcon(new ImageIcon(util.imgResize(btnType6, "/clientUI/images/icon_type6.png")));
		btnType6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnType6);
		
		btnType7 = new JLabel("");	//음료
		btnType7.setToolTipText("\uC74C\uB8CC");
		btnType7.setBounds(18, 255, 80, 80);
		btnType7.setIcon(new ImageIcon(util.imgResize(btnType7, "/clientUI/images/icon_type7.png")));
		btnType7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnType7);
		
		btnType8 = new JLabel("");	//주류
		btnType8.setToolTipText("\uC8FC\uB958");
		btnType8.setBounds(150, 257, 80, 80);
		btnType8.setIcon(new ImageIcon(util.imgResize(btnType8, "/clientUI/images/icon_type8.png")));
		btnType8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnType8);
		
		btnType9 = new JLabel("");	//디저트
		btnType9.setToolTipText("\uB514\uC800\uD2B8");
		btnType9.setBounds(290, 256, 80, 80);
		btnType9.setIcon(new ImageIcon(util.imgResize(btnType9, "/clientUI/images/icon_type9.png")));
		btnType9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel.add(btnType9);
		
		btnSignup = new JLabel("");	//회원가입 버튼
		btnSignup.setToolTipText("\uD68C\uC6D0\uAC00\uC785");
		btnSignup.setBounds(163, 480, 255, 20);
		btnSignup.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnSignup);
		
		JLabel lblMain = new JLabel("");	//메인 화면 이미지
		lblMain.setBounds(0, 0, 440, 511);
		lblMain.setIcon(new ImageIcon(util.imgResize(lblMain, "/clientUI/images/page_main.png")));
		contentPane.add(lblMain);
		
	}
	
	/**
	 * 이벤트 메소드
	 */
	private void createEvents() {
		txtSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//검색 창 클릭
				txtSearch.setText(null);
			}
		});
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//검색 창 입력 후 엔터
				search();
			}
		});
		
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//검색 창 돋보기 아이콘 클릭
				search();
			}
		});
		
		
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//홈 버튼 클릭
				new Main();
				setVisible(false);
				
			}
		});
		
		btnType1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//한식 버튼 클릭
				shopsearch("1");
				
				new ShopListHansic();
				setVisible(false);
			}
		});
		
		btnType2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//양식 버튼 클릭
				shopsearch("2");
				new ShopListWfood();
				setVisible(false);
				
			}
		});
		
		btnType3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//중식 버튼 클릭
				shopsearch("3");
				new ShopListCfood();
				setVisible(false);
				
			}
		});
		
		btnType4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//일식 버튼 클릭
				shopsearch("4");
				new ShopListJfood();
				setVisible(false);
				
			}
		});
		
		btnType5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//분식 버튼 클릭
				shopsearch("5");
				new ShopListBunsic();
				setVisible(false);
				
			}
		});
		
		btnType6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//베이커리 버튼 클릭
				shopsearch("6");
				new ShopListBread();
				setVisible(false);
				
			}
		});
		
		btnType7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//음료 버튼 클릭
				shopsearch("7");
				new ShopListDrink();
				setVisible(false);
				
			}
		});
		
		btnType8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//주류식 버튼 클릭
				shopsearch("8");
				new ShopListAlcohol();
				setVisible(false);
				
			}
		});
		
		btnType9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//디저트 버튼 클릭
				shopsearch("9");
				new ShopListDessert();
				setVisible(false);
				
			}
		});
		
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//회원가입 버튼 클릭
				new Signup();
				setVisible(false);
			}
		});
	}
	public String[] shopsearch(String scode){
		values_l=sls.ShopList(scode);
		System.out.println("밸류_l 값 담기"+values_l);
		values=new String[values_l.size()];
		
		System.out.println(values_l);
				
		for(int i=0;i<values_l.size();i++){
			System.out.println(values_l.get(i).getBusiness_name());
			values[i]=values_l.get(i).getBusiness_name();
			//System.out.println(values);
			System.out.println("값확인"+i);
		}		
		System.out.println("확인 :"+Arrays.toString(values));
		return values;
	}


	/**
	 * 검색 결과 출력 메소드
	 */
	protected void search() {
		new Search();
		setVisible(false);
		
	}
}
