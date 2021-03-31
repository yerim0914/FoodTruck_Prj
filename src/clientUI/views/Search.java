package clientUI.views;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientUI.util.Util;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Search extends JFrame {

	private JPanel contentPane;
	private JLabel btnHome;
	private JLabel lblClientMenu;
	private JLabel btnClientMenu;
	private JLabel lblSearch;
	private JTextArea txtResult;
	private JScrollPane scrPaneResult;
	private JTextField txtSearch;
	private Component btnSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
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
	public Search() {
		
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
		contentPane.setLayout(null);
		
		Util util = new Util();

		/////////////////////////////////////////////////////
		// 회원 메뉴 시작
		////////////////////////////////////////////////////
	
		JPanel panelClientMenu = new JPanel();	//회원메뉴 panel		
		panelClientMenu.setOpaque(false);
		panelClientMenu.setBounds(270, 0, 76, 79);
		contentPane.add(panelClientMenu);
		panelClientMenu.setLayout(null);
		
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
		btnClientMenu.setBounds(352, 23, 31, 34);
		btnClientMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnClientMenu);
		
		btnHome = new JLabel("");	//홈 버튼
		btnHome.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setToolTipText("HOME");
		btnHome.setBounds(395, 25, 28, 32);
		contentPane.add(btnHome);
		
		txtSearch = new JTextField();	//검색어 입력 창
		txtSearch.setText("\uAC80\uC0C9\uC5B4 \uD45C\uC2DC");
		/////////////////////////////////////////////////////
		// 검색어 가져오기
		////////////////////////////////////////////////////
		txtSearch.setBounds(38, 23, 167, 34);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel btnSearch = new JLabel("");	//검색 버튼
		btnSearch.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSearch.setBounds(213, 23, 28, 32);
		contentPane.add(btnSearch);
		
		scrPaneResult = new JScrollPane();
		scrPaneResult.setBorder(null);
		scrPaneResult.setBounds(38, 130, 363, 348);
		contentPane.add(scrPaneResult);
		
		txtResult = new JTextArea();
		txtResult.setText("\uD14C\uC2A4\uD2B8\uD569\uB2C8\uB2E4\uD14C\uC2A4\uD2B8\uD569\uB2C8\uB2E4\uD14C\uC2A4\uD2B8\uD569\uB2C8\uB2E4\uD14C\uC2A4\uD2B8\uD569\uB2C8\uB2E4\uD14C\uC2A4\uD2B8\uD569\uB2C8\uB2E4\uD14C\uC2A4\uD2B8\uD569\uB2C8\uB2E4\uD14C\uC2A4\uD2B8\uD569\uB2C8\uB2E4");
		txtResult.setBorder(null);
		txtResult.setEditable(false);
		txtResult.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		scrPaneResult.setViewportView(txtResult);
	
		////////////////////////////////////////
		// 회원 메뉴 끝
		///////////////////////////////////////////

		
		lblSearch = new JLabel("");
		lblSearch.setBounds(0, 0, 440, 511);
		lblSearch.setIcon(new ImageIcon(util.imgResize(lblSearch, "/clientUI/images/page_search.png")));
		contentPane.add(lblSearch);

		
	}

	private void createEvents() {
		
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//홈 버튼 클릭
				new Main();
				setVisible(false);
			}
		});
		
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//검색어 입력창에서 엔터
				search();
			}
		});
		
		btnSearch.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {	//검색어 버튼 클릭
				search();
			}
		});

		
	}
	
	/**
	 * 검색 결과 출력 메소드
	 */
	protected void search() {
		// TODO Auto-generated method stub
		
	}
}
