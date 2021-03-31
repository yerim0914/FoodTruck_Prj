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
import java.awt.Font;
import javax.swing.AbstractListModel;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ClientOrderList extends JFrame {

	private JPanel contentPane;
	private JLabel btnHome;
	private JTable tableOrderList;
	private String header[];
	private String cells[][];
	private JLabel btnCheck;
	private JLabel btnClientMenu;
	private JLabel lblClientMenu;
	private JScrollPane scrollPane;
	private JList listOrderList;
	private JLabel btnOpinion;
	private JScrollPane scrPaneComment;
	private JTextArea txtComment;
	private JLabel btnInsert;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientOrderList frame = new ClientOrderList();
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
	public ClientOrderList() {
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
		setBounds(100, 100, 750, 549);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Util util = new Util();
		
		readOrderList();
		tableOrderList = new JTable(cells, header);
		tableOrderList.setOpaque(false);
		tableOrderList.setRowHeight(30);
		tableOrderList.setFillsViewportHeight(true);
		tableOrderList.setBorder(null);
		tableOrderList.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableOrderList.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
		

		/////////////////////////////////////////////////////
		// 회원 메뉴 시작
		////////////////////////////////////////////////////
	
		JPanel panelClientMenu = new JPanel();	//회원메뉴 panel		
		panelClientMenu.setOpaque(false);
		panelClientMenu.setBounds(512, 0, 76, 79);
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
		btnClientMenu.setBounds(613, 24, 31, 41);
		btnClientMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnClientMenu);
		
		////////////////////////////////////////
		// 회원 메뉴 끝
		///////////////////////////////////////////
		
			
		btnHome = new JLabel("");	//홈 버튼
		btnHome.setToolTipText("HOME");
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setBounds(661, 24, 33, 41);
		contentPane.add(btnHome);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(36, 98, 664, 177);
		contentPane.add(scrollPane);
		
		listOrderList = new JList();	//주문 리스트
		listOrderList.setModel(new AbstractListModel() {
			String[] values = new String[] {"\uC8FC\uBB381", "\uC8FC\uBB382", "\uC8FC\uBB383"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(listOrderList);
		listOrderList.setBorder(null);
		
		btnOpinion = new JLabel("");	//평가하기 버튼
		btnOpinion.setToolTipText("\uD3C9\uAC00");
		btnOpinion.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOpinion.setBounds(647, 296, 58, 35);
		contentPane.add(btnOpinion);
		
		scrPaneComment = new JScrollPane();
		scrPaneComment.setBorder(null);
		scrPaneComment.setBounds(68, 378, 272, 96);
		contentPane.add(scrPaneComment);
		
		txtComment = new JTextArea();
		txtComment.setBorder(null);
		scrPaneComment.setViewportView(txtComment);
		
		JTextField txtScore = new JTextField();
		txtScore.setBounds(472, 330, 116, 35);
		contentPane.add(txtScore);
		txtScore.setColumns(10);
		
		btnInsert = new JLabel("");	//입력 버튼
		btnInsert.setBounds(487, 434, 58, 41);
		contentPane.add(btnInsert);
		
		
		JLabel lblClientOrderList = new JLabel("");	//주문내역 페이지 이미지
		lblClientOrderList.setBorder(null);
		lblClientOrderList.setBounds(0, 0, 734, 511);
		lblClientOrderList.setIcon(new ImageIcon(util.imgResize(lblClientOrderList, "/clientUI/images/page_ClientOrderList.png")));
		contentPane.add(lblClientOrderList);
		
	}
	
	/**
	 * 주문내역 불러오는 메소드
	 */
	private void readOrderList() {
		/////////////////////////////////////////////
		//cells[][], header[] 정의하는 메소드
		/////////////////////////////////////////////
		header = new String[]{"주문일자", "업체명", "메뉴", "가격", "수량"};
		cells = new String[5][5];
		for(int i=0;i<5;i++){
			for(int j=0; j<5;j++){
			cells[i][j] = "테스트"+i+j; 
			}
		}
	}

	/** 이벤트 메소드
	 * 
	 */
	private void createEvents() {
		
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//홈 버튼 클릭
				new Main();
				setVisible(false);
			}
		});
		
		btnOpinion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//주문 선택
				//////////////////////////////////////////
				// 
				///////////////////////////////////////////
			}
		});
		
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//입력 버튼 클릭
			}
		});
		
	}
	
}