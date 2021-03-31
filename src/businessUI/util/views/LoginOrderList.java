package businessUI.views;

import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.factories.DefaultComponentFactory;

import businessUI.util.ResizableUtil;
import service.business.OrderList_Service;
import service.business.OrderList_ServiceImpl;
import vo.business.OrderListVO;

import javax.swing.table.DefaultTableModel;
import java.awt.Toolkit;

public class LoginOrderList extends JFrame {

	private JPanel contentPane;
	private JLabel orderList;
	private JScrollPane jscrollpane;
	private JTable table;
	private JTable orderTable;
	private int row;
	private int column;
	GetBInfo info = null;
	public static String orders_num;
	OrderList_Service orderservice = new OrderList_ServiceImpl();
	private String salableSign;
	
	PrintStream ps;
	FileOutputStream fos;
	

	/**
	 * Launch the application. public static void main(String[] args) {
	 * EventQueue.invokeLater(new Runnable() { public void run() { try {
	 * OrderList frame = new OrderList(); frame.setVisible(true); } catch
	 * (Exception e) { e.printStackTrace(); } } }); }
	 *
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					LoginOrderList frame = new LoginOrderList();
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
	public LoginOrderList() {
		setTitle("Foodi");
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(LoginOrderList.class.getResource("/images/icon_foodTruck_64.png")));
		ResizableUtil util = new ResizableUtil();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 456, 548);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setVisible(true);
		contentPane.setLayout(null);

		JLabel topink = new JLabel("New label");
		topink.setBounds(358, 11, 50, 40);
		topink.setIcon(new ImageIcon(util.imgResize(topink, "/images/topink.png")));
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
			public void mousePressed(MouseEvent e) {

				new BusinessMain();
				setVisible(false);
			}
		});

		JLabel member = new JLabel("New label");
		member.setBounds(309, 15, 36, 36);
		member.setIcon(new ImageIcon(util.imgResize(member, "/images/member.png")));
		contentPane.add(member);

		member.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				member.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				member.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new MyInformation();
			}
		});

		JLabel todaySchedule = DefaultComponentFactory.getInstance()
				.createTitle("\uC624\uB298\uC758 \uC601\uC5C5 \uC2A4\uCF00\uC904\uC740?\r\n");
		todaySchedule.setBounds(94, 395, 146, 30);
		contentPane.add(todaySchedule);
		todaySchedule.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				todaySchedule.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				todaySchedule.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new Schedule();
			}
		});

		JLabel myMenu = DefaultComponentFactory.getInstance().createTitle("\uB0B4 \uAC00\uAC8C \uBA54\uB274\r\n");
		myMenu.setBounds(94, 435, 121, 24);
		contentPane.add(myMenu);

		myMenu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				myMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				myMenu.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new MenuList();
			}
		});

		JLabel foodititle = new JLabel("New label");
		foodititle.setBounds(94, 15, 146, 53);
		foodititle.setIcon(new ImageIcon(util.imgResize(foodititle, "/images/foodititle.png")));
		contentPane.add(foodititle);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setInheritsPopupMenu(true);
		scrollPane_1.setIgnoreRepaint(true);
		scrollPane_1.setAutoscrolls(true);
		scrollPane_1.setBounds(64, 140, 323, 213);
		contentPane.add(scrollPane_1);

		String header[] = new String[] { "\uBA54\uB274\uC774\uB984", "\uC218\uB7C9", "\uACE0\uAC1Did",
				"\uD310\uB9E4\uC5EC\uBD80" };
		String[][] contents = new String[100][100];
		String [] orderN = new String[10];
		ArrayList<String> arr = new ArrayList<>();
		//무식한 null들을 지우고 String배열에 주문들어온 값들을 넣으면 되용.
			//menu_name, 수량, client_id, salable
		
		OrderListVO order = new OrderListVO();
		List<OrderListVO> list = new ArrayList<>();
		
		list = orderservice.getOrderList(BusinessMain.business_id);
		Iterator<OrderListVO> it = list.iterator();
		
		while(it.hasNext()){
			for(int i = 0; i < list.size(); i++){
				order = (OrderListVO) it.next();
				contents[i][0] = order.getMenu_id();
				contents[i][1] = Integer.toString(order.getOrders_count());
				contents[i][2] = order.getClient_id();
				contents[i][3] = order.getSalable();
				orderN[i] = order.getOrders_num();
			}
		}

		orderTable = new JTable();
		orderTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				row = orderTable.getSelectedRow();
				//column = orderTable.getSelectedColumn();
			}
		});
		orderTable.setAutoCreateRowSorter(true);
		scrollPane_1.setViewportView(orderTable);
		orderTable.setModel(new DefaultTableModel(contents, header) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		orderTable.getColumnModel().getColumn(1).setPreferredWidth(49);
		orderTable.getColumnModel().getColumn(2).setPreferredWidth(143);
		orderTable.getColumnModel().getColumn(3).setPreferredWidth(62);
		
		JLabel saleConfirmButton = new JLabel("");
		saleConfirmButton.setBounds(295, 368, 92, 30);
		saleConfirmButton.setIcon(new ImageIcon(util.imgResize(saleConfirmButton,"/images/saleConfirmButton.png")));
		contentPane.add(saleConfirmButton);
		
		saleConfirmButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				saleConfirmButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				saleConfirmButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				orderTable.setValueAt("Y", row, 3);
				orders_num = orderN[row];
				orderservice.soldoutIs(orders_num, "Y");
				
				salableSign = (String) orderTable.getValueAt(row, 3); 
				
				if(salableSign!=null && salableSign.equals("Y")){
					try {
				    	fos = new FileOutputStream("./log/orderconfirm.txt",true);
						ps = new PrintStream(fos);
						System.setOut(ps);
						
						 Calendar cal = Calendar.getInstance();
					     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
					     System.out.println("주문확인시간 : "+sdf.format(cal.getTime()));							
					     System.out.println("사업자번호: " + BusinessMain.business_id);
				    
						} catch (FileNotFoundException e1) {
							System.err.println("File not found.");						
						} catch (IOException e1) {
							System.err.println("Stream err...");
						}finally{
							try {
								if(fos!=null)	fos.close();
								if(ps!=null)	ps.close();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
						}
				}
			}
		});
		
		JLabel logoutIcon = DefaultComponentFactory.getInstance().createTitle("Logout");
		logoutIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logoutIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				logoutIcon.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				logoutIcon.setCursor(new Cursor(Cursor.HAND_CURSOR));
				new BusinessMain();
				setVisible(false);				
			}
		});
		logoutIcon.setFont(new Font("굴림", Font.BOLD, 15));
		logoutIcon.setBounds(12, 24, 58, 15);
		contentPane.add(logoutIcon);

		orderList = new JLabel("");
		orderList.setBounds(0, 0, 440, 511);
		orderList.setIcon(new ImageIcon(util.imgResize(orderList, "/images/orderList.jpg")));
		contentPane.add(orderList);
	}
}
