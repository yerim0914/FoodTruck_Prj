package clientUI.views;

import java.awt.BorderLayout;
import clientUI.views.Main;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientUI.util.Util;
import service.shoplist.ShopListService;
import service.shoplist.ShopListServiceImpl;
import vo.client.ShopListVO;

import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.AbstractListModel;

public class hansic extends JFrame {

	private JLabel lblMenu;
	private JLabel btnMenu; 
	private JPanel contentPane;
	clientUI.views.Main s_list=null;
	String[] values =new String[]{"aaa"};
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					hansic frame = new hansic();
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
	public hansic() {

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
		
		JLabel btnBack = new JLabel("");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//뒤로가기
			}
		});
		btnBack.setBounds(31, 25, 51, 32);
		btnBack.setIcon(new ImageIcon(util.imgResize(btnBack, "/clientUI/images/icon_back.png")));
		btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		contentPane.add(btnBack);
		
		JScrollPane scroPaneKfood = new JScrollPane();
		scroPaneKfood.setBounds(33, 122, 377, 330);
		contentPane.add(scroPaneKfood);
		
		//values=new String[s_list.values.length];
		//System.out.println("dd");
		//System.out.println(s_list.shopsearch("1"));
		//System.out.println(Arrays.toString(s_list.values));
		
		
		//System.arraycopy(s_list.values, 0, values, 0, s_list.values.length);
		 //new String[] {"ddd","나나나"};
		
		
		
		JList listKfood = new JList();
		listKfood.setModel(new AbstractListModel() {

			public int getSize() {
				return s_list.values.length;
			}
			public Object getElementAt(int index) {
				return s_list.values[index];
			}
		});
		listKfood.setBorder(null);
		scroPaneKfood.setViewportView(listKfood);
		
		JLabel btnGo = new JLabel("");
		btnGo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//이동버튼 클릭
			}
		});
		btnGo.setToolTipText("\uC774\uB3D9");
		btnGo.setBorder(null);
		btnGo.setBounds(198, 462, 45, 39);
		contentPane.add(btnGo);
		
		JLabel btnKfood = new JLabel("\uD55C\uC2DD");
		btnKfood.addMouseListener(new MouseAdapter() {	//한식버튼 클릭
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnKfood.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnKfood.setFont(new Font("맑은 고딕", Font.BOLD, 50));
		btnKfood.setBounds(148, 25, 109, 54);
		contentPane.add(btnKfood);
		
		JLabel lblShopListKfood = new JLabel("");
		lblShopListKfood.setBounds(0, 0, 440, 511);
		lblShopListKfood.setIcon(new ImageIcon(util.imgResize(lblShopListKfood, "/clientUI/images/page_shopInfoList.png")));
		contentPane.add(lblShopListKfood);
		
		////////////////////////////////////////
		// 회원 메뉴 끝
		///////////////////////////////////////////
	
		
		
	}
	

	
	
	private void createEvents() {
		// TODO Auto-generated method stub
		
	}
	
}
