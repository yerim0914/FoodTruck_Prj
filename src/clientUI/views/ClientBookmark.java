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
	 * �ʱ�ȭ �޼ҵ�
	 */
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
		
		btnHome = new JLabel("");	//Ȩ ��ư
		btnHome.setFont(new Font("���� ���", Font.PLAIN, 15));
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setToolTipText("HOME");
		btnHome.setBounds(382, 23, 28, 32);
		contentPane.add(btnHome);

		/////////////////////////////////////////////////////
		// ȸ�� �޴� ����
		////////////////////////////////////////////////////
	
		JPanel paneMenu = new JPanel();	//ȸ���޴� panel		
		paneMenu.setOpaque(false);
		paneMenu.setBounds(261, 0, 76, 79);
		contentPane.add(paneMenu);
		paneMenu.setLayout(null);
		
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
		paneMenu.add(btnClientInfo);
		
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
		paneMenu.add(btnBookmark);
		
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
		btnOrderList.setBounds(0, 53, 76, 26);
		paneMenu.add(btnOrderList);
		
		lblClientMenu = new JLabel("");	//ȸ�� �޴� �̹���
		lblClientMenu.setBounds(0, 0, 76, 79);
		paneMenu.add(lblClientMenu);
		lblClientMenu.setIcon(new ImageIcon(util.imgResize(lblClientMenu, "/clientUI/images/lbl_clientMenu.png")));
		lblClientMenu.setVisible(false);
		
		btnMenu = new JLabel("");	//ȸ�� �޴�  ��ư
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
		// ȸ�� �޴� ��
		///////////////////////////////////////////
		
	
		JScrollPane scrBookmark = new JScrollPane(); //���ã�� ��ũ�� pane
		scrBookmark.setBorder(null);
		scrBookmark.setBounds(70, 103, 303, 311);
		contentPane.add(scrBookmark);
		
		listBookmark = new JList();	//���ã�� ���
		readBookmark();
		//listBookmark.setModel(new AbstractListModel() {
		listBookmark.setModel(new AbstractListModel<String>() {
			//////////////////////////////////////////////
			// ���ã�� ��� ��������
			///////////////////////////////////////////////
			public int getSize() {
				return values.length;
			}
			//public Object getElementAt(int index) {
			public String getElementAt(int index) {
				return values[index];
			}
		});
		listBookmark.setFont(new Font("���� ���", Font.PLAIN, 15));

		scrBookmark.setViewportView(listBookmark);
		
		btnSub = new JLabel("");	//���� ��ư
		btnSub.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnSub.setToolTipText("\uC990\uACA8\uCC3E\uAE30 \uB9AC\uC2A4\uD2B8\uC5D0\uC11C \uC81C\uC678\uD569\uB2C8\uB2E4.");
		btnSub.setBounds(137, 443, 43, 44);
		contentPane.add(btnSub);
		
		btnBookmark = new JLabel("");	//�̵� ��ư
		btnBookmark.setBorder(null);
		btnBookmark.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBookmark.setToolTipText("\uC120\uD0DD\uD55C \uC5C5\uCCB4 \uD398\uC774\uC9C0\uB85C \uC774\uB3D9\uD569\uB2C8\uB2E4.");
		btnBookmark.setBounds(261, 443, 43, 44);
		contentPane.add(btnBookmark);
		
		JLabel lblBookmark = new JLabel("");	//���ã�� ������ �̹���
		lblBookmark.setBounds(0, 0, 440, 511);
		lblBookmark.setIcon(new ImageIcon(util.imgResize(lblBookmark, "/clientUI/images/page_ClientBookmark.png")));
		contentPane.add(lblBookmark);
		
	}

	/**
	 * �ϸ�ũ ��ü �迭ȭ �޼ҵ�
	 * �ʱ�ȭ �޼ҵ忡 ���Խ�Ű�� �� �� ������??
	 * ��ü�� �����ص� ����������????? ��ü�� �����սô٤̤̤̤̤�
	 */
	private void readBookmark() {
		/////////////////////////////////////////////
		//���ã�� ��ü �ҷ����� �޼ҵ�
		/////////////////////////////////////////////
		values = new String[30];
		for(int i=0;i<30;i++){
			values[i] = "�׽�Ʈ�׽�Ʈ��Ʈ��ƶ�פѤ��׽�Ʈ�׽�Ʈ��Ʈ��ƶ�פѤ��׽�Ʈ�׽�Ʈ��Ʈ��ƶ�פѤ��׽�Ʈ�׽�Ʈ��Ʈ��ƶ�פѤ�"+i; 
		}
	}

	/**
	 * �̺�Ʈ �޼ҵ�
	 */
	private void createEvents() {
		
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//Ȩ ��ư Ŭ��
				////////////////////////////////////////
				//���� �������� �̵�
				/////////////////////////////////////////
				new Main();
				setVisible(false);
			}
		});
		
		listBookmark.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//����Ʈ���� �� ��ü Ŭ��
				/////////////////////////////////
				// ��ü ���� 
				/////////////////////////////////

			}
		});
		
		btnSub.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//���� ��ư Ŭ��
				//////////////////////////////////
				// ���ã�� ����Ʈ���� �����մϴ�
				//////////////////////////////////////////
			}
		});
		
		btnBookmark.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//�̵� ��ư Ŭ��
				///////////////////////////////////
				// ������ ��ü �������� �̵�
				////////////////////////////////////
			}
		});


		
	}
}
