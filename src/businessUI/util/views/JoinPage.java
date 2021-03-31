package businessUI.views;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businessUI.util.ResizableUtil;
import service.business.Business_Info_Service;
import service.business.Business_Info_ServiceImpl;
import vo.business.Business_InfoVO;

import java.awt.Toolkit;


public class JoinPage extends JFrame {

	private JPanel contentPane;
	private ImageIcon joinPageImage = new ImageIcon("./images/joinPage.jpg");
	private Image joinPageImage1;
	private JTextField business_id;
	private JTextField pw;
	private JTextField shop_name;
	private JTextField owner_name;
	private JTextField owner_phone;
	private JTextField owner_acc;
	private JComboBox comboBox;
	private JTextField textField;
	private JTextField business_name;
	private String[] Bcode = {"한식", "양식","중식","일식","분식","베이커리","음료","주류","디저트"};
	/**
	 * Launch the application.
	 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinPage frame = new JoinPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */
	Business_Info_Service Binfo_service = new Business_Info_ServiceImpl();
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinPage frame = new JoinPage();
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
	public JoinPage() {
		setTitle("Foodi\t");
		setIconImage(Toolkit.getDefaultToolkit().getImage(JoinPage.class.getResource("/images/icon_foodTruck_64.png")));
		ResizableUtil util = new ResizableUtil();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 548);
		setLocationRelativeTo(null);	
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel joinFinishButton = new JLabel("New label");
		joinFinishButton.setBounds(130, 448, 173, 43);
		joinFinishButton.setIcon(new ImageIcon(util.imgResize(joinFinishButton,"/images/joinFinish.png")));
		contentPane.add(joinFinishButton);
		joinFinishButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				joinFinishButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				joinFinishButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				Business_InfoVO vo = new Business_InfoVO(business_id.getText(), shop_name.getText(),
						owner_name.getText(), owner_phone.getText(), pw.getText(),
						owner_acc.getText(), null, business_name.getText() , null);
				Binfo_service.Join_Business(vo);
				JOptionPane.showMessageDialog(new JoinPage(),"회원 가입에 성공했습니다. 로그인 페이지로 이동합니다.");
				new BusinessMain();
				setVisible(false);	
				}
			});
		
		JLabel topink = new JLabel("New label");
		topink.setBounds(356, 26, 50, 40);
		topink.setIcon(new ImageIcon(util.imgResize(topink,"/images/topink.png")));
		contentPane.add(topink);
		topink.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				topink.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				topink.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				
				new BusinessMain();
				setVisible(false);	
				}
			});
		
		JLabel backspace = new JLabel("New label");
		backspace.setBounds(12, 25, 61, 48);
		backspace.setIcon(new ImageIcon(util.imgResize(backspace,"/images/backspace.png")));
		contentPane.add(backspace);
		backspace.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backspace.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backspace.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				new BusinessMain();
				setVisible(false);	
				}
			});
		
		business_id = new JTextField();
		business_id.setBounds(196, 143, 141, 21);
		contentPane.add(business_id);
		business_id.setColumns(10);
		
		pw = new JTextField();
		pw.setColumns(10);
		pw.setBounds(196, 174, 141, 21);
		contentPane.add(pw);
		
		shop_name = new JTextField();
		shop_name.setColumns(10);
		shop_name.setBounds(196, 203, 141, 21);
		contentPane.add(shop_name);
		
		owner_name = new JTextField();
		owner_name.setColumns(10);
		owner_name.setBounds(196, 230, 141, 21);
		contentPane.add(owner_name);
		
		owner_phone = new JTextField();
		owner_phone.setColumns(10);
		owner_phone.setBounds(196, 258, 141, 21);
		contentPane.add(owner_phone);
		
		owner_acc = new JTextField();
		owner_acc.setColumns(10);
		owner_acc.setBounds(196, 285, 141, 21);
		contentPane.add(owner_acc);
		
		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				business_name.setText((String)comboBox.getSelectedItem());
			}
		});
		comboBox.setBounds(196, 316, 77, 21);
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"\uD55C\uC2DD", "\uC591\uC2DD", "\uC911\uC2DD", "\uC77C\uC2DD", "\uBD84\uC2DD", "\uBCA0\uC774\uCEE4\uB9AC", "\uC74C\uB8CC", "\uC8FC\uB958", "\uB514\uC800\uD2B8"}));
		String[] model = new String[] {"한식", "양식","중식","일식","분식","베이커리","음료","주류","디저트"};
		comboBox.setModel(new DefaultComboBoxModel(model));
		contentPane.add(comboBox);
		
		business_name = new JTextField();
		business_name.setBounds(289, 316, 77, 21);
		contentPane.add(business_name);
		business_name.setColumns(10);
		
			
		JLabel joinPage = new JLabel("New label");
		joinPage.setBounds(0, 0, 440, 510);
		joinPage.setIcon(new ImageIcon(util.imgResize(joinPage, "/images/joinPage.jpg")));
		contentPane.add(joinPage);
		
	}
}
