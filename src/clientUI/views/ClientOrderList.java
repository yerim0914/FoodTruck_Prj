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
	 * �ʱ�ȭ �޼ҵ�
	 */
	private void initialize() {
		setTitle("Foodi");	//������ â
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/clientUI/images/icon_foodTruck_64.png")));	//â ������
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
		tableOrderList.setFont(new Font("���� ���", Font.PLAIN, 15));
		boolean[] columnEditables = new boolean[] {
				false, false, false, false, false
			};
		

		/////////////////////////////////////////////////////
		// ȸ�� �޴� ����
		////////////////////////////////////////////////////
	
		JPanel panelClientMenu = new JPanel();	//ȸ���޴� panel		
		panelClientMenu.setOpaque(false);
		panelClientMenu.setBounds(512, 0, 76, 79);
		contentPane.add(panelClientMenu);
		panelClientMenu.setLayout(null);
		
		JLabel btnClientInfo = new JLabel("");	//ȸ������ ��ư	
		btnClientInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//ȸ������ ��ư Ŭ��
				new ClientInfo();
				setVisible(false);
				///////////////////////////////
				// ȸ������ �������� �̵�
				//////////////////////////////////////
			}
		});
		btnClientInfo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnClientInfo.setBounds(0, 0, 76, 26);
		panelClientMenu.add(btnClientInfo);
		
		JLabel btnBookmark = new JLabel("");	//���ã�� ��ư
		btnBookmark.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//���ã�� ��ư Ŭ��
				new ClientBookmark();
				setVisible(false);
				///////////////////////////////////
				// ���ã�� �������� �̵�
				///////////////////////////////////////
			}
		});
		btnBookmark.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBookmark.setBounds(0, 28, 76, 25);
		panelClientMenu.add(btnBookmark);
		
		JLabel btnOrderList = new JLabel("");	//�ֹ����� ��ư
		btnOrderList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//�ֹ����� ��ư Ŭ��
				new ClientOrderList();
				setVisible(false);
				////////////////////////////////////
				//�ֹ����� �������� �̵�
				////////////////////////////////////				
			}
		});
		btnOrderList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOrderList.setBounds(0, 57, 76, 22);
		panelClientMenu.add(btnOrderList);
		
		lblClientMenu = new JLabel("");	//ȸ�� �޴� �̹���
		lblClientMenu.setBounds(0, 0, 76, 79);
		panelClientMenu.add(lblClientMenu);
		lblClientMenu.setIcon(new ImageIcon(util.imgResize(lblClientMenu, "/clientUI/images/lbl_clientMenu.png")));
		lblClientMenu.setVisible(false);
		
		btnClientMenu = new JLabel("");	//ȸ�� �޴�  ��ư
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
		// ȸ�� �޴� ��
		///////////////////////////////////////////
		
			
		btnHome = new JLabel("");	//Ȩ ��ư
		btnHome.setToolTipText("HOME");
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setBounds(661, 24, 33, 41);
		contentPane.add(btnHome);
		
		scrollPane = new JScrollPane();
		scrollPane.setBorder(null);
		scrollPane.setBounds(36, 98, 664, 177);
		contentPane.add(scrollPane);
		
		listOrderList = new JList();	//�ֹ� ����Ʈ
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
		
		btnOpinion = new JLabel("");	//���ϱ� ��ư
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
		
		btnInsert = new JLabel("");	//�Է� ��ư
		btnInsert.setBounds(487, 434, 58, 41);
		contentPane.add(btnInsert);
		
		
		JLabel lblClientOrderList = new JLabel("");	//�ֹ����� ������ �̹���
		lblClientOrderList.setBorder(null);
		lblClientOrderList.setBounds(0, 0, 734, 511);
		lblClientOrderList.setIcon(new ImageIcon(util.imgResize(lblClientOrderList, "/clientUI/images/page_ClientOrderList.png")));
		contentPane.add(lblClientOrderList);
		
	}
	
	/**
	 * �ֹ����� �ҷ����� �޼ҵ�
	 */
	private void readOrderList() {
		/////////////////////////////////////////////
		//cells[][], header[] �����ϴ� �޼ҵ�
		/////////////////////////////////////////////
		header = new String[]{"�ֹ�����", "��ü��", "�޴�", "����", "����"};
		cells = new String[5][5];
		for(int i=0;i<5;i++){
			for(int j=0; j<5;j++){
			cells[i][j] = "�׽�Ʈ"+i+j; 
			}
		}
	}

	/** �̺�Ʈ �޼ҵ�
	 * 
	 */
	private void createEvents() {
		
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//Ȩ ��ư Ŭ��
				new Main();
				setVisible(false);
			}
		});
		
		btnOpinion.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//�ֹ� ����
				//////////////////////////////////////////
				// 
				///////////////////////////////////////////
			}
		});
		
		btnInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//�Է� ��ư Ŭ��
			}
		});
		
	}
	
}