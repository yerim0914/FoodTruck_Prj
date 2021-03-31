package businessUI.views;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import businessUI.util.ResizableUtil;
import service.business.Menu_Service;
import service.business.Menu_ServiceImpl;
import vo.business.MenuVO;

public class MenuList extends JFrame {

	private JPanel contentPane;
	private final JLabel menuListPage = new JLabel("");
	private JTextField menuname1;
	private JTextField price1;
	private JTextField menuname3;
	private JTextField price3;
	private JTextField menuname2;
	private JTextField price2;
	private JTextArea menudesc3;
	private JTextArea menudesc2;
	private JLabel confirmButton;
	Menu_Service menu_service = new Menu_ServiceImpl();
	List<MenuVO> list = null;
	MenuVO menu = new MenuVO();
	private JLabel updateMenuButton_2;
	private JLabel deleteMenuButton_2;
	private JTextField choiceTextBox;
	String menu_id[];
	/**
	 * Launch the application.
	 * public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuList frame = new MenuList();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	 */
	

	/**
	 * Create the frame.
	 */
	public MenuList() {
		String[] model = new String[3];
		//String[] menu_id = new String[3];
		menu_id = new String[3];
		ResizableUtil util = new ResizableUtil();
		setTitle("Foodi");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuList.class.getResource("/images/icon_foodTruck_64.png")));		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 650);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);

		menuname1 = new JTextField();
		menuname1.setBounds(124, 28, 119, 27);
		contentPane.add(menuname1);
		menuname1.setColumns(10);
		
		price1 = new JTextField();
		price1.setColumns(10);
		price1.setBounds(127, 71, 119, 27);
		contentPane.add(price1);
		
		menuname3 = new JTextField();
		menuname3.setColumns(10);
		menuname3.setBounds(111, 329, 119, 27);
		contentPane.add(menuname3);
		
		price3 = new JTextField();
		price3.setColumns(10);
		price3.setBounds(111, 381, 119, 27);
		contentPane.add(price3);
		
		menuname2 = new JTextField();
		menuname2.setColumns(10);
		menuname2.setBounds(580, 28, 119, 27);
		contentPane.add(menuname2);
		
		price2 = new JTextField();
		price2.setColumns(10);
		price2.setBounds(580, 81, 119, 27);
		contentPane.add(price2);
	
		JTextArea menudesc1 = new JTextArea();
		menudesc1.setLineWrap(true);
		menudesc1.setRows(5);
		menudesc1.setBounds(156, 158, 186, 92);
		contentPane.add(menudesc1);
		
		
		menudesc3 = new JTextArea();
		menudesc3.setWrapStyleWord(true);
		menudesc3.setLineWrap(true);
		menudesc3.setBounds(141, 461, 186, 92);
		contentPane.add(menudesc3);
		
		menudesc2 = new JTextArea();
		menudesc2.setWrapStyleWord(true);
		menudesc2.setLineWrap(true);
		menudesc2.setBounds(609, 170, 186, 92);
		contentPane.add(menudesc2);
		
		JLabel updateMenuButton = new JLabel("New label");
		updateMenuButton.setBounds(339, 33, 79, 27);
		updateMenuButton.setIcon(new ImageIcon(util.imgResize(updateMenuButton,"/images/updateMenuButton.png")));
		contentPane.add(updateMenuButton);
		
		updateMenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				updateMenuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				updateMenuButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				menu.setBusiness_id(BusinessMain.business_id);
				menu.setMenu_name(menuname1.getText());
				menu.setMenu_price(Integer.parseInt(price1.getText()));
				menu.setMenu_desc(menudesc1.getText());
				menu_service.Menu_Insert(menu);
				new MenuList();
				setVisible(false);	
				}
			});
		
		list = menu_service.Menu_List(BusinessMain.business_id);
		//메뉴1
		if(list.size()>0){
		menuname1.setText(list.get(0).getMenu_name());
		price1.setText(Integer.toString(list.get(0).getMenu_price()));
		menudesc1.setText(list.get(0).getMenu_desc());
		menu_id[0] = list.get(0).getMenu_id();
		}
		//메뉴2
		if(list.size()>1){
		menuname2.setText(list.get(1).getMenu_name());
		price2.setText(Integer.toString(list.get(1).getMenu_price()));
		menudesc2.setText(list.get(1).getMenu_desc());
		menu_id[1] = list.get(1).getMenu_id();
		}
		//메뉴3
		if(list.size()>2){
		menuname3.setText(list.get(2).getMenu_name());
		price3.setText(Integer.toString(list.get(2).getMenu_price()));
		menudesc3.setText(list.get(2).getMenu_desc());
		menu_id[2] = list.get(2).getMenu_id();
		}
		
		JLabel deleteMenuButton = new JLabel("New label");
		deleteMenuButton.setBounds(339, 65, 79, 27);
		deleteMenuButton.setIcon(new ImageIcon(util.imgResize(deleteMenuButton,"/images/deleteMenuButton.png")));
		contentPane.add(deleteMenuButton);
		
		deleteMenuButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				deleteMenuButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				deleteMenuButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				menu_service.Menu_Delete(menu_id[0]);
				new MenuList();
				setVisible(false);	
				}
			});
		
		
		JLabel updateMenuButton_1 = new JLabel("New label");
		updateMenuButton_1.setBounds(758, 34, 79, 27);
		updateMenuButton_1.setIcon(new ImageIcon(util.imgResize(updateMenuButton_1,"/images/updateMenuButton.png")));
		contentPane.add(updateMenuButton_1);
		
		updateMenuButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				updateMenuButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				updateMenuButton_1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				menu.setBusiness_id(BusinessMain.business_id);
				menu.setMenu_name(menuname3.getText());
				menu.setMenu_price(Integer.parseInt(price3.getText()));
				menu.setMenu_desc(menudesc2.getText());
				menu_service.Menu_Insert(menu);
				new MenuList();
				setVisible(false);	
				}
			});
		
		
		JLabel deleteMenuButton_1 = new JLabel("New label");
		deleteMenuButton_1.setBounds(758, 65, 79, 27);
		deleteMenuButton_1.setIcon(new ImageIcon(util.imgResize(deleteMenuButton_1,"/images/deleteMenuButton.png")));
		contentPane.add(deleteMenuButton_1);
		
		deleteMenuButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				deleteMenuButton_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				deleteMenuButton_1.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				menu_service.Menu_Delete(menu_id[1]);
				new MenuList();
				setVisible(false);	
				}
			});
		
		updateMenuButton_2 = new JLabel("New label");
		updateMenuButton_2.setBounds(326, 335, 79, 27);
		updateMenuButton_2.setIcon(new ImageIcon(util.imgResize(updateMenuButton_2,"/images/updateMenuButton.png")));
		contentPane.add(updateMenuButton_2);
		

		updateMenuButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				updateMenuButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				updateMenuButton_2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				menu.setBusiness_id(BusinessMain.business_id);
				menu.setMenu_name(menuname2.getText());
				menu.setMenu_price(Integer.parseInt(price2.getText()));
				menu.setMenu_desc(menudesc3.getText());
				menu_service.Menu_Insert(menu);
				new MenuList();
				setVisible(false);	
				}
			});
		
		
		
		deleteMenuButton_2 = new JLabel("New label");
		deleteMenuButton_2.setBounds(326, 368, 79, 27);
		deleteMenuButton_2.setIcon(new ImageIcon(util.imgResize(deleteMenuButton_2,"/images/deleteMenuButton.png")));
		contentPane.add(deleteMenuButton_2);
		
		deleteMenuButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				deleteMenuButton_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				deleteMenuButton_2.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				menu_service.Menu_Delete(menu_id[2]);
				new MenuList();
				setVisible(false);	
				}
			});
		
		confirmButton = new JLabel("");
		confirmButton.setBounds(720, 434, 119, 33);
		confirmButton.setIcon(new ImageIcon(util.imgResize(confirmButton,"/images/newConfirmButton.png")));
		contentPane.add(confirmButton);
		
		confirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				confirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				confirmButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				new LoginOrderList();
				setVisible(false);
				
				}
			});

		model[0] = menuname1.getText();
		model[1] = menuname2.getText();
		model[2] = menuname3.getText();
		JComboBox choiceMenu = new JComboBox();
		
		choiceMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				choiceTextBox.setText((String)choiceMenu.getSelectedItem());
				
				for(int i = 0; i < model.length; i++){
					if(model[i].equals(choiceTextBox.getText())){
						
						menu_service.Menu_Recommend(menu_id[i], "Y");
					}
					else {
						menu_service.Menu_Recommend(menu_id[i], "N");
					}
					}
			}
		});
		
		
		
		choiceMenu.setEditable(true);
		choiceMenu.setBounds(483, 371, 119, 27);

		
		choiceMenu.setModel(new DefaultComboBoxModel(model));
		contentPane.add(choiceMenu);
		
		
		choiceTextBox = new JTextField();
		choiceTextBox.setBounds(483, 414, 119, 27);
		contentPane.add(choiceTextBox);
		choiceTextBox.setColumns(10);
		//System.out.println(menu_id[0]);
		/*for(int i = 0; i < model.length; i++){
		if(model[i].equals(choiceTextBox.getText())){
			System.out.println(menu_id[i]);
			menu_service.Menu_Recommend(menu_id[i], "Y");
		}
		else {
			menu_service.Menu_Recommend(menu_id[i], "N");
		}
		}*/

		
		
		menuListPage.setIcon(new ImageIcon(MenuList.class.getResource("/images/menuList_2.jpg")));
		menuListPage.setBounds(0, 0, 900, 600);
		contentPane.add(menuListPage);
	}
}