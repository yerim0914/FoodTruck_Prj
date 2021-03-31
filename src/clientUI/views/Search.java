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
		setTitle("Foodi");	//������ â
		setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/clientUI/images/icon_foodTruck_64.png")));	//â ������
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 549);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Util util = new Util();

		/////////////////////////////////////////////////////
		// ȸ�� �޴� ����
		////////////////////////////////////////////////////
	
		JPanel panelClientMenu = new JPanel();	//ȸ���޴� panel		
		panelClientMenu.setOpaque(false);
		panelClientMenu.setBounds(270, 0, 76, 79);
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
		btnClientMenu.setBounds(352, 23, 31, 34);
		btnClientMenu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		contentPane.add(btnClientMenu);
		
		btnHome = new JLabel("");	//Ȩ ��ư
		btnHome.setFont(new Font("���� ���", Font.PLAIN, 15));
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setToolTipText("HOME");
		btnHome.setBounds(395, 25, 28, 32);
		contentPane.add(btnHome);
		
		txtSearch = new JTextField();	//�˻��� �Է� â
		txtSearch.setText("\uAC80\uC0C9\uC5B4 \uD45C\uC2DC");
		/////////////////////////////////////////////////////
		// �˻��� ��������
		////////////////////////////////////////////////////
		txtSearch.setBounds(38, 23, 167, 34);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JLabel btnSearch = new JLabel("");	//�˻� ��ư
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
		// ȸ�� �޴� ��
		///////////////////////////////////////////

		
		lblSearch = new JLabel("");
		lblSearch.setBounds(0, 0, 440, 511);
		lblSearch.setIcon(new ImageIcon(util.imgResize(lblSearch, "/clientUI/images/page_search.png")));
		contentPane.add(lblSearch);

		
	}

	private void createEvents() {
		
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//Ȩ ��ư Ŭ��
				new Main();
				setVisible(false);
			}
		});
		
		txtSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	//�˻��� �Է�â���� ����
				search();
			}
		});
		
		btnSearch.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent e) {	//�˻��� ��ư Ŭ��
				search();
			}
		});

		
	}
	
	/**
	 * �˻� ��� ��� �޼ҵ�
	 */
	protected void search() {
		// TODO Auto-generated method stub
		
	}
}
