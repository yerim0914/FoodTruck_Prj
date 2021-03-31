package clientUI.views;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import clientUI.util.Util;
import service.business.*;
import vo.business.*;
import vo.client.*;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ListModel;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;

public class ShopInfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtBusinessName;	//업체명
	private JTabbedPane tabTable;	//메뉴 분류 탭 테이블
	private JLabel btnClientInfo;	//회원 메뉴 버튼
	private JLabel btnHome;	//홈 버튼
	private JLabel btnBack;	//이전 페이지 버튼
	private JPanel panelOrder;
	private JLabel lblOrder;
	private JComboBox cbOrderMenu;
	private JTextField txtOrderCount;
	private JLabel btnOrderAdd;
	private JLabel btnOrderSub;
	private JLabel lblOrderSum;
	private JTextField txtOrderSum;
	private JRadioButton rdBtnPayTransfer;
	//private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel panelMenu;
	private JScrollPane scrollPaneMenuRecommend;
	private JTextArea txtMenuRecommend;
	private JScrollPane scrPaneMenu;
	private JTextArea textMenu;
	private JScrollPane scrPaneOrderList;
	private JPanel panelShopInfo;
	private JLabel lblShopInfo;
	private JTextField txtPhone;
	private JScrollPane scrPaneSchedule;
	private JTextArea txtSchedule;
	private JLabel btnAddBookmark;
	private JPanel panelOpinion;
	private JLabel lblOpinion;
	private JTextField txtScore;
	private JScrollPane scrPaneComment;
	private JTextField txtComment;
	private JLabel lblClientMenu;
	private JComponent btnClientMenu;
	private JLabel btnOrder;
	static List<ShopListVO> s_info;
	
	String[] values = new String[10];
	List<String> l_values=new ArrayList<>();
	Schedule_Service b_s = new Schedule_ServiceImpl();
	Menu_Service b_m = new Menu_ServiceImpl();
	OrderList_Service b_o = new OrderList_ServiceImpl();
	List<ScheduleVO> svo=new ArrayList<>();
	OrderListVO ovo;
	List<MenuVO> mvo = new ArrayList<>();
	OpinionVO pvo;
	JList listOrderList = new JList();	
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopInfo frame = new ShopInfo();
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
	public ShopInfo() {
		
		
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
		
		Util util = new Util();
		contentPane.setLayout(null);
		
		btnClientMenu = new JLabel("");	//회원 메뉴  버튼
		btnClientMenu.addMouseListener(new MouseAdapter() {

			
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
		

		/////////////////////////////////////////////////////
		// 회원 메뉴 시작
		////////////////////////////////////////////////////
	
		JPanel panelClientMenu = new JPanel();	//회원메뉴 panel		
		panelClientMenu.setOpaque(false);
		panelClientMenu.setBounds(261, 0, 76, 79);
		contentPane.add(panelClientMenu);
		panelClientMenu.setLayout(null);
		
		btnClientInfo = new JLabel("");	//회원정보 버튼	
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
		panelClientMenu.add(btnClientInfo);
		
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
		panelClientMenu.add(btnBookmark);
		
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
		panelClientMenu.add(btnOrderList);
		
		lblClientMenu = new JLabel("");	//회원 메뉴 이미지
		lblClientMenu.setBounds(0, 0, 76, 79);
		panelClientMenu.add(lblClientMenu);
		lblClientMenu.setIcon(new ImageIcon(util.imgResize(lblClientMenu, "/clientUI/images/lbl_clientMenu.png")));
		lblClientMenu.setVisible(false);
		
		btnClientMenu = new JLabel("");	//회원 메뉴  버튼
		btnClientMenu.addMouseListener(new MouseAdapter() {

			
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
			
		btnClientMenu.setToolTipText("");
		btnClientMenu.setBounds(339, 23, 31, 34);
		btnClientMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnClientMenu);
		
		////////////////////////////////////////
		// 회원 메뉴 끝
		///////////////////////////////////////////
		

		
		btnHome = new JLabel("");	//홈 버튼
		btnHome.setBounds(394, 25, 34, 30);
		btnHome.setToolTipText("HOME");
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setBorder(null);
		contentPane.add(btnHome);
		
		txtBusinessName = new JTextField();	//업체명 표시
		txtBusinessName.setOpaque(false);
		txtBusinessName.setBounds(25, 74, 391, 41);
		txtBusinessName.setFont(new Font("맑은 고딕", Font.BOLD, 28));
		txtBusinessName.setText("\uC5C5\uCCB4\uBA85");
		////////////////////////////////////////////////////////////
		//업체명 불러오기!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		////////////////////////////////////////////////////////////
		txtBusinessName.setBorder(null);
		txtBusinessName.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtBusinessName.setEditable(false);
		contentPane.add(txtBusinessName);
		txtBusinessName.setColumns(10);
		
		tabTable = new JTabbedPane(JTabbedPane.TOP);	//메뉴 분류 탭 테이블
		tabTable.setBounds(25, 147, 391, 354);
		tabTable.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		tabTable.setAutoscrolls(true);
		tabTable.setBorder(null);
		contentPane.add(tabTable);
		
		panelShopInfo = new JPanel();	//소개 탭 panel
		panelShopInfo.setBorder(null);
		tabTable.addTab("\uC18C\uAC1C", new ImageIcon(util.iconResize("/clientUI/images/icon_truck.png")), panelShopInfo, null);
		panelShopInfo.setLayout(null);
		
		txtPhone = new JTextField();	//전화번호 텍스트 필드
		txtPhone.setOpaque(false);
		txtPhone.setEditable(false);
		txtPhone.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtPhone.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtPhone.setBounds(167, 21, 190, 21);
		txtPhone.setText(s_info.get(0).getOwner_phone());
		panelShopInfo.add(txtPhone);
		txtPhone.setColumns(10);
		
		btnAddBookmark = new JLabel("");	//즐겨찾기 추가 버튼
		btnAddBookmark.setToolTipText("\uC990\uACA8\uCC3E\uAE30 \uCD94\uAC00");
		btnAddBookmark.setBorder(null);
		btnAddBookmark.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAddBookmark.setBounds(27, 53, 122, 15);
		panelShopInfo.add(btnAddBookmark);
		
		scrPaneSchedule = new JScrollPane();	//스케줄 스크롤 pane
		scrPaneSchedule.setBorder(null);
		scrPaneSchedule.setBounds(34, 103, 323, 193);
		panelShopInfo.add(scrPaneSchedule);
		
		txtSchedule = new JTextArea();	//스케줄 텍스트 필드
		
		svo=b_s.Schedule_List(s_info.get(0).getBusiness_id());
		System.out.println(svo);
		String sc = "";
		for(int i =0;i<svo.size() ;i++){
			sc += svo.get(i).getBusiness_day() + " : ";
			sc += svo.get(i).getBusiness_hour().substring(0, 2) + "시 ~ ";
			sc += svo.get(i).getBusiness_hour().substring(2, 4) + "시, ";
			sc += svo.get(i).getBusiness_addr()+"\n";			
		}
	
		
		System.out.println(sc);
		//svo.get(0).getBusiness_day()
		//svo.get(0).getBusiness_addr();
		
		
		txtSchedule.setText(sc);
		
		///////////////////////////////////////////////////
		//	↑ 스케줄 불러오기
		///////////////////////////////////////////////////
		txtSchedule.setBorder(null);
		scrPaneSchedule.setViewportView(txtSchedule);
		txtSchedule.setColumns(10);
		
		lblShopInfo = new JLabel("");	//소개 탭 이미지
		lblShopInfo.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		lblShopInfo.setBorder(null);
		lblShopInfo.setBounds(0, 0, 386, 319);
		lblShopInfo.setIcon(new ImageIcon(util.imgResize(lblShopInfo, "/clientUI/images/lblShopInfo.png")));
		panelShopInfo.add(lblShopInfo);
		
		panelMenu = new JPanel();	//메뉴 탭 panel
		panelMenu.setBorder(null);
		panelMenu.setOpaque(false);
		tabTable.addTab("\uBA54\uB274", new ImageIcon(util.iconResize("/clientUI/images/icon_menu.png")), panelMenu, null);
		panelMenu.setLayout(null);
		
		scrollPaneMenuRecommend = new JScrollPane();	//추천메뉴 스크롤 pane
		scrollPaneMenuRecommend.setAutoscrolls(true);
		scrollPaneMenuRecommend.setBorder(null);
		scrollPaneMenuRecommend.setOpaque(false);
		scrollPaneMenuRecommend.setBounds(23, 37, 337, 87);
		panelMenu.add(scrollPaneMenuRecommend);
		
		txtMenuRecommend = new JTextArea();	//추천메뉴 TextArea 
		txtMenuRecommend.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtMenuRecommend.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		txtMenuRecommend.setBorder(null);
		//txtMenuRecommend.setText("\uBA54\uB274\uBA85 : \uBA54\uB274\uBA85\r\n\uAC00\uACA9 : 5000\uC6D0\r\n\uBA54\uB274 \uC18C\uAC1C : \uC544\uC8FC \uB9DB\uB098\uC694!!! \uC5C4\uCCAD \uB9DB\uB098\uC694!!! \uC815\uB9D0 \uB9DB\uB098\uC694!!! \uC9C4\uC9DC \uB9DB\uB098\uC694!!\r\n\uD14C\uC2A4\uD2B81\r\n\uD14C\uC2A4\uD2B82\r\n\uD14C\uC2A4\uD2B83\r\n\uD14C\uC2A4\uD2B84\r\n\uD14C\uC2A4\uD2B85\r\n\r\n");
		mvo=b_m.Menu_List(s_info.get(0).getBusiness_id());
		String mreco = "";
		for(int i = 0; i < mvo.size(); i++){
			System.out.println("이거머야"+mvo.get(i).getRecommend());
		if(mvo.get(i).getRecommend().equals("Y")){
			mreco += mvo.get(i).getMenu_name() + ": ";
			mreco += mvo.get(i).getMenu_price() + "원 \n";
			mreco += mvo.get(i).getMenu_desc();			
		}
		}
		txtMenuRecommend.setText(mreco);
		/////////////////////////////////////////////////////////
		//    ↑ 추천메뉴 내용 불러오기
		////////////////////////////////////////////////////////////
		scrollPaneMenuRecommend.setViewportView(txtMenuRecommend);
		
		scrPaneMenu = new JScrollPane();
		scrPaneMenu.setBorder(null);
		scrPaneMenu.setBounds(24, 176, 336, 121);
		panelMenu.add(scrPaneMenu);
		
		textMenu = new JTextArea();
		textMenu.setBorder(null);

		mvo=b_m.Menu_List(s_info.get(0).getBusiness_id());
		String menu = "";
		for(int i =0;i<mvo.size() ;i++){
			System.out.println("menu"+i+". ");
			menu += mvo.get(i).getMenu_name()+ "  ";
			menu += Integer.toString(mvo.get(i).getMenu_price())+ "\n";
			menu += mvo.get(i).getMenu_desc() + "\n";		
			
		}
		textMenu.setText(menu);
		textMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		textMenu.setEditable(false);
		textMenu.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrPaneMenu.setViewportView(textMenu);
		
		JLabel lblMenu = new JLabel("");	//메뉴 탭 이미지
		lblMenu.setBounds(0, 0, 386, 319);
		panelMenu.add(lblMenu);
		lblMenu.setBorder(null);
		lblMenu.setIcon(new ImageIcon(util.imgResize(lblMenu, "/clientUI/images/lblMenu.png")));
		
		panelOrder = new JPanel();	//
		panelOrder.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		panelOrder.setBorder(null);
		tabTable.addTab("\uC8FC\uBB38", new ImageIcon(util.iconResize("/clientUI/images/icon_order.png")), panelOrder, null);
		panelOrder.setLayout(null);
		
		cbOrderMenu = new JComboBox();	//메뉴 리스트 콤보 박스
		cbOrderMenu.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		
		////////////////////////////////////////////////////////////
		//↓ 메뉴 불러오기
		////////////////////////////////////////////////////////////////
		mvo=b_m.Menu_List(s_info.get(0).getBusiness_id());
		String[] select_menu=null;
		select_menu=new String[mvo.size()];
		for(int i =0;i<mvo.size() ;i++){
			//System.out.println("menu"+i+". ");
			select_menu[i] = mvo.get(i).getMenu_name();		
		}
		
		cbOrderMenu.setModel(new DefaultComboBoxModel(select_menu));
		cbOrderMenu.setBorder(null);
		cbOrderMenu.setBounds(12, 10, 362, 29);
		panelOrder.add(cbOrderMenu);
		
		txtOrderCount = new JTextField();	//주문 수량 입력 창
		txtOrderCount.setToolTipText("\uC8FC\uBB38 \uC218\uB7C9");
		
		txtOrderCount.setText("\uC8FC\uBB38 \uC218\uB7C9\uC744 \uC785\uB825\uD558\uC138\uC694.");
		txtOrderCount.setBounds(88, 49, 143, 21);
		panelOrder.add(txtOrderCount);
		txtOrderCount.setColumns(10);
		
		btnOrderAdd = new JLabel("");	//추가 버튼
		btnOrderAdd.setBorder(null);
		btnOrderAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOrderAdd.setToolTipText("\uCD94\uAC00");
		btnOrderAdd.setBounds(286, 49, 23, 15);
		panelOrder.add(btnOrderAdd);
		
		btnOrderSub = new JLabel("");	//제외 버튼
		btnOrderSub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.out.println("삭전"+l_values);
				//l_values.remove();
				System.out.println("삭후"+l_values);
				System.out.println("제발"+listOrderList.getSelectedValue());
				System.out.println("야야야");
				System.out.println(listOrderList.getSelectedValue());
				listOrderList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
					
				listOrderList.remove(listOrderList.getSelectedIndex());
				
				////////////////////////////////////////////////////
				//	↓ 추가한 메뉴 불러오기
				///////////////////////////////////////////////////////
				
			}
		});

		btnOrderSub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOrderSub.setToolTipText("\uC81C\uC678");
		btnOrderSub.setBounds(324, 49, 23, 15);
		panelOrder.add(btnOrderSub);
		
		lblOrderSum = new JLabel("\uACB0\uC81C \uC608\uC815\uC561");	//결제 예정액 lbl
		lblOrderSum.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		lblOrderSum.setBounds(135, 205, 81, 21);
		panelOrder.add(lblOrderSum);
		
		txtOrderSum = new JTextField();	//결제 예정액 텍스트 필드
		txtOrderSum.setOpaque(false);
		txtOrderSum.setEditable(false);
		txtOrderSum.setText(null);	//결제 예정액
		///////////////////////////////////////////////////
		// 결제 예정액 가져오기
		///////////////////////////////////////////////////////
		txtOrderSum.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		txtOrderSum.setBounds(228, 206, 126, 21);
		panelOrder.add(txtOrderSum);
		txtOrderSum.setColumns(10);
		
		JRadioButton rdBtnPayCredit = new JRadioButton("\uC2E0\uC6A9\uCE74\uB4DC");	//신용카드 라디오 버튼
		//buttonGroup.add(rdBtnPayCredit);
		rdBtnPayCredit.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		rdBtnPayCredit.setOpaque(false);
		rdBtnPayCredit.setBounds(124, 246, 81, 21);
		panelOrder.add(rdBtnPayCredit);
		
		rdBtnPayTransfer = new JRadioButton("\uACC4\uC88C\uC774\uCCB4");	//계좌이체 라디오 버튼
		//buttonGroup.add(rdBtnPayTransfer);
		rdBtnPayTransfer.setOpaque(false);
		rdBtnPayTransfer.setFont(new Font("맑은 고딕", Font.PLAIN, 13));
		rdBtnPayTransfer.setBounds(233, 245, 121, 23);
		panelOrder.add(rdBtnPayTransfer);
		
		scrPaneOrderList = new JScrollPane();	//메뉴 추가 내역 리스트 pane
		scrPaneOrderList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		scrPaneOrderList.setBorder(null);
		scrPaneOrderList.setBounds(24, 107, 339, 80);
		panelOrder.add(scrPaneOrderList);
		
		
		JList listOrderList = new JList();	//메뉴 추가 내역 리스트
		listOrderList.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		////////////////////////////////////////////////////
		//	↓ 추가한 메뉴 불러오기
		///////////////////////////////////////////////////////
		listOrderList.setModel(new AbstractListModel() {
			
			public int getSize() {
				return l_values.size();
			}
			public Object getElementAt(int index) {
				return l_values.get(index);
			}
		});
		listOrderList.setBorder(null);
		scrPaneOrderList.setViewportView(listOrderList);
		
		btnOrder = new JLabel("");	//주문 버튼
		btnOrder.setBorder(null);
		btnOrder.setBounds(287, 283, 67, 15);
		panelOrder.add(btnOrder);
		
		
		lblOrder = new JLabel("");	//주문 페이지 이미지
		lblOrder.setOpaque(true);
		lblOrder.setBounds(0, 0, 386, 319);
		lblOrder.setIcon(new ImageIcon(util.imgResize(lblOrder, "/clientUI/images/lblOrder.png")));
		panelOrder.add(lblOrder);
		
		
		panelOpinion = new JPanel();
		panelOpinion.setOpaque(false);
		tabTable.addTab("\uD3C9\uAC00", new ImageIcon(util.iconResize("/clientUI/images/icon_opinion.png")), panelOpinion, null);
		panelOpinion.setLayout(null);
		
		txtScore = new JTextField();	//평점 텍스트 필드
		txtScore.setOpaque(false);
		txtScore.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtScore.setEditable(false);
		txtScore.setBorder(null);
		txtScore.setFont(new Font("맑은 고딕", Font.BOLD, 30));
		txtScore.setText("4.5");
		////////////////////////////////////////////////////
		//	↑ 평점 불러오기
		////////////////////////////////////////////////////
		txtScore.setBounds(193, 24, 70, 29);
		panelOpinion.add(txtScore);
		txtScore.setColumns(10);
		
		scrPaneComment = new JScrollPane();	//평가글 스크롤 pane
		scrPaneComment.setOpaque(false);
		scrPaneComment.setBorder(null);
		scrPaneComment.setBounds(35, 114, 323, 180);
		panelOpinion.add(scrPaneComment);
		
		txtComment = new JTextField();
		txtComment.setOpaque(false);
		txtComment.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		txtComment.setText("\uD14C\uC2A4\uD2B8");
		//////////////////////////////////////////////////////
		// ↑ 평가글 불러오기
		/////////////////////////////////////////////////////
		txtComment.setEditable(false);
		txtComment.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtComment.setBorder(null);
		scrPaneComment.setViewportView(txtComment);
		txtComment.setColumns(10);
		
		lblOpinion = new JLabel("");	//평가 탭 이미지
		lblOpinion.setBounds(0, 0, 386, 319);
		panelOpinion.add(lblOpinion);
		lblOpinion.setIcon(new ImageIcon(util.imgResize(lblOpinion, "/clientUI/images/lblOpnion.png")));
		
		btnBack = new JLabel("");	//이전 페이지 버튼
		btnBack.setBounds(17, 17, 40, 25);
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//이전 페이지 버튼 클릭
				new Main();
				setVisible(false);
				
			}
		});
		btnBack.setToolTipText("\uC774\uC804 \uD398\uC774\uC9C0");
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBack.setBorder(null);
		contentPane.add(btnBack);
		
		JLabel lblClientShopInfo = new JLabel("");	// 업체 페이지 이미지
		lblClientShopInfo.setBounds(0, 0, 440, 511);
		lblClientShopInfo.setIcon(new ImageIcon(util.imgResize(lblClientShopInfo, "/clientUI/images/page_shopInfo.png")));
		contentPane.add(lblClientShopInfo);
		

		
	}
	

	/**
	 * 이벤트 메소드
	 */
	private void createEvents() {
		
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//홈 버튼 클릭
				////////////////////////////////////////
				//메인 페이지 열고 현재 창 종료
				/////////////////////////////////////////////
				new Main();
				setVisible(false);
			}
		});
		
		btnAddBookmark.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//즐겨찾기 추가 버튼 클릭
				/////////////////////////////////////////
				// 즐겨찾기 추가~~~~~
				////////////////////////////////////////////
			}
		});
		
		txtOrderCount.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {	//주문 수량 입력 창 focus Gained
				txtOrderCount.setText(null);
			}
		});
		
		btnOrderAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//추가 버튼 클릭
				listOrderList.setBorder(null);
				scrPaneOrderList.setViewportView(listOrderList);
								
			}
		});
		
		btnOrderSub.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//제외 버튼 클릭
				
				
			}
		});
		
		btnOrder.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//주문 버튼 클릭
				JOptionPane.showMessageDialog(contentPane, "주문 성공");
			}
		});
		
	}
}
