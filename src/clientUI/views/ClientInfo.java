package clientUI.views;

import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import clientUI.util.Util;
import dao.client.Client_InfoDAO;
import service.client.Client_InfoService;
import service.client.Client_InfoServiceImpl;
import service.shoplist.ShopListService;
import service.shoplist.ShopListServiceImpl;
import vo.client.Client_InfoVO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Cursor;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class ClientInfo extends JFrame {

	private JPanel contentPane;
	private JLabel btnHome;
	private JTextField txtEmail;
	private JTextField txtPhone;
	private JTextField txtAddr;
	private JLabel btnUpdate;
	private JLabel btnConfirm;
	private JLabel btnDelete;
	private JLabel btnMenu;
	private JLabel lblClientMenu;
	Client_InfoService cis=new Client_InfoServiceImpl();
	ShopListService service1= new ShopListServiceImpl();
	private JLabel btnUpdatePw;
	private JTextField txtPw;
	Client_InfoVO user;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientInfo frame = new ClientInfo();
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
	public ClientInfo() {
		initialize();
		createEvents();
		readClientInfo();

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
				

		/////////////////////////////////////////////////////
		// ȸ�� �޴� ����
		////////////////////////////////////////////////////
	
		JPanel panelMenu = new JPanel();	//ȸ���޴� panel		
		panelMenu.setOpaque(false);
		panelMenu.setBounds(261, 0, 76, 79);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
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
		panelMenu.add(btnClientInfo);
		
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
		panelMenu.add(btnBookmark);
		
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
		panelMenu.add(btnOrderList);
		
		lblClientMenu = new JLabel("");	//ȸ�� �޴� �̹���
		lblClientMenu.setBounds(0, 0, 76, 79);
		panelMenu.add(lblClientMenu);
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
		
		btnHome = new JLabel("");	//Ȩ ��ư
		btnHome.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnHome.setToolTipText("HOME");
		btnHome.setBounds(374, 21, 42, 41);
		contentPane.add(btnHome);
				
		txtEmail = new JTextField();
		txtEmail.setOpaque(false);
		txtEmail.setEditable(false);
		txtEmail.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		txtEmail.setFont(new Font("���� ���", Font.PLAIN, 12));
		txtEmail.setBorder(null);
		txtEmail.setBounds(168, 127, 191, 21);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPw = new JTextField();
		txtPw.setText((String) null);
		txtPw.setFont(new Font("���� ���", Font.PLAIN, 12));
		txtPw.setColumns(10);
		txtPw.setBorder(null);
		txtPw.setBounds(168, 168, 188, 21);
		contentPane.add(txtPw);
		
		txtPhone = new JTextField();	//��ȭ��ȣ �Է� â
		txtPhone.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtPhone.setFont(new Font("���� ���", Font.PLAIN, 12));
		txtPhone.setColumns(10);
		txtPhone.setBorder(null);
		txtPhone.setBounds(168, 207, 188, 22);
		contentPane.add(txtPhone);
		
		txtAddr = new JTextField();	//�ּ� �Է� â
		txtAddr.setFont(new Font("���� ���", Font.PLAIN, 12));
		txtAddr.setColumns(10);
		txtAddr.setBorder(null);
		txtAddr.setBounds(168, 246, 189, 72);
		contentPane.add(txtAddr);
		
		btnUpdate = new JLabel("");	//���� ��ư
		btnUpdate.setBorder(null);
		btnUpdate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdate.setToolTipText("\uC218\uC815");
		btnUpdate.setBounds(261, 459, 126, 31);
		contentPane.add(btnUpdate);
		
		btnConfirm = new JLabel("");	//Ȯ�� ��ư
		btnConfirm.setBorder(null);
		btnConfirm.setToolTipText("\uD655\uC778");
		btnConfirm.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirm.setBounds(182, 353, 83, 31);
		contentPane.add(btnConfirm);
		
		btnDelete = new JLabel("");	//Ż�� ��ư
		btnDelete.setBorder(null);
		btnDelete.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnDelete.setToolTipText("\uD0C8\uD1F4");
		btnDelete.setBounds(66, 388, 42, 31);
		contentPane.add(btnDelete);
		
		btnUpdatePw = new JLabel("");	//��й�ȣ ���� ��ư
		btnUpdatePw.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnUpdatePw.setBorder(null);
		btnUpdatePw.setBounds(54, 450, 155, 40);
		contentPane.add(btnUpdatePw);
		
		JLabel lblClientInfo = new JLabel("");	//ȸ������ ������ �̹���
		lblClientInfo.setBounds(0, 0, 440, 511);
		lblClientInfo.setIcon(new ImageIcon(util.imgResize(lblClientInfo, "/clientUI/images/page_ClientInfo.png")));
		contentPane.add(lblClientInfo);

	}

	
	/**
	 * ȸ������ �ҷ��ͼ� setText �޼ҵ�
	 */
	private void readClientInfo() {
		////////////////////////////////////////
		//
		/////////////////////////////////////////
		txtEmail.setText(Client_InfoDAO.log.getClient_id());		
		txtPhone.setText(Client_InfoDAO.log.getClient_phone());
		txtAddr.setText(Client_InfoDAO.log.getClient_addr());
		
	}
	
	
	/**
	 * �̺�Ʈ �޼ҵ�	
	 */
	private void createEvents() {
				
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//Ȩ ��ư Ŭ��
				/////////////////////////////////
				//���� �������� �̵�
				/////////////////////////////////
				new Main();
				setVisible(false);
			}
		});
		
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//�̸��� �Է� â ���� ����
				if(e.getKeyChar()=='\n'){
					txtPw.requestFocus();
				}
			}
		});
		
		txtPw.addKeyListener(new KeyAdapter() {	//��й�ȣ �Է� â
			@Override
			public void keyPressed(KeyEvent e) {	//��й�ȣ �Է� â ���� ����
				if(e.getKeyChar()=='\n'){
					txtPhone.requestFocus();
				}
			}
		});
		
		txtPhone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {	//��ȭ��ȣ �Է� â ���� ����
				if(e.getKeyChar()=='\n'){
					txtAddr.requestFocus();
				}
			}
		});

		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//���� ��ư Ŭ��
				
				if(txtPw.getText().equals(Client_InfoDAO.log.getPw())){
					
					cis.updateClientInfo(Client_InfoDAO.log.getClient_id(),Client_InfoDAO.log.getPw(), 
							txtPhone.getText(),txtAddr.getText());
					System.out.println("����.");
					JOptionPane.showMessageDialog(contentPane, "���� ���� �Ϸ�");
						
					
				}
				else{
					JOptionPane.showMessageDialog(contentPane, "��й�ȣ Ȯ�����ּ���");
					txtPw.setText("");		
					
			
					System.out.println("�ȿ�");
				}
				
			}
		});
		
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//Ȯ�� ��ư Ŭ��
				
				new Main();
				setVisible(false);
			

			}
		});

		btnUpdatePw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//��й�ȣ ���� ��ư Ŭ��
				
				new UpdatePw();
				setVisible(false);
				
			}
		});
		
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {	//Ż�� ��ư Ŭ��
				
				Client_InfoService service = new Client_InfoServiceImpl();
				
				String pw = JOptionPane.showInputDialog("��й�ȣ�� �Է��ϼ���.");
				
				if(Client_InfoDAO.log.getPw().equals(pw)){
					int delete = JOptionPane.showConfirmDialog(contentPane, "Ż���Ͻðڽ��ϱ�?");
					
					if(delete == 0){ //0�� ��
						
						service.deleteClientInfo(Client_InfoDAO.log.getClient_id());	//Ŭ���̾�Ʈ ���̵� �ҷ�����
						JOptionPane.showMessageDialog(contentPane, "Ż��Ϸ�");
						new Login();
						setVisible(false);
						
					} else {
						
						new ClientInfo();
						setVisible(false);
					}
					
				} else {
					JOptionPane.showMessageDialog(contentPane, "��й�ȣ�� ��ġ���� �ʽ��ϴ�");
					new ClientInfo();
					setVisible(false);
				}
				
				
			}
		});
		
	}

}
