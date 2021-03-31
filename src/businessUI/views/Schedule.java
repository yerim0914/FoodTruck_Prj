package businessUI.views;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.business.Schedule_Service;
import service.business.Schedule_ServiceImpl;
import vo.business.OrderListVO;
import vo.business.ScheduleVO;

import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.JComboBox;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import businessUI.util.ResizableUtil;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class Schedule extends JFrame {

	private JPanel contentPane;
	private JLabel schedulePage;
	private Schedule frame;
	private JTextField mon_addr;
	private JTextField tues_addr;
	private JTextField wed_addr;
	private JTextField thu_addr;
	private JTextField fri_addr;
	private JTextField sat_addr;
	private JTextField sun_addr;
	
	Schedule_Service schedule_service = new Schedule_ServiceImpl();
	List<ScheduleVO> list = null;
	ScheduleVO schedule = new ScheduleVO();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Schedule frame = new Schedule();
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
	public Schedule() {
		setTitle("Foodi");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Schedule.class.getResource("/images/icon_foodTruck_64.png")));
		ResizableUtil util = new ResizableUtil();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 456, 548);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setVisible(true);
		

		JLabel topink = new JLabel("New label");
		topink.setBounds(357, 29, 50, 40);
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
		backspace.setBounds(12, 28, 53, 43);
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
		
		JLabel member = new JLabel();
		member.setBounds(309, 33, 36, 36);
		member.setIcon(new ImageIcon(util.imgResize(member,"/images/member.png")));
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
			public void mousePressed(MouseEvent e){
				new MyInformation();
				}
			});
		
		mon_addr = new JTextField();
		mon_addr.setColumns(10);
		mon_addr.setBounds(258, 202, 149, 21);
		contentPane.add(mon_addr);
		
		tues_addr = new JTextField();
		tues_addr.setColumns(10);
		tues_addr.setBounds(258, 233, 149, 21);
		contentPane.add(tues_addr);
		
		wed_addr = new JTextField();
		wed_addr.setColumns(10);
		wed_addr.setBounds(258, 264, 149, 21);
		contentPane.add(wed_addr);
		
		thu_addr = new JTextField();
		thu_addr.setColumns(10);
		thu_addr.setBounds(258, 295, 149, 21);
		contentPane.add(thu_addr);
		
		fri_addr = new JTextField();
		fri_addr.setColumns(10);
		fri_addr.setBounds(258, 326, 149, 21);
		contentPane.add(fri_addr);
		
		sat_addr = new JTextField();
		sat_addr.setColumns(10);
		sat_addr.setBounds(258, 357, 149, 21);
		contentPane.add(sat_addr);
		
		sun_addr = new JTextField();
		sun_addr.setColumns(10);
		sun_addr.setBounds(258, 383, 149, 21);
		contentPane.add(sun_addr);
		
		/**/
		
		
		
		
		
		JLabel confirmButton = new JLabel("New label");
		confirmButton.setBounds(262, 453, 88, 47);
		confirmButton.setIcon(new ImageIcon(util.imgResize(confirmButton,"/images/confirmButton.png")));
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
				setVisible(false);	
				}
			});
		
		JComboBox hour = new JComboBox();
		hour.setEditable(true);
		hour.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		hour.setBounds(130, 202, 36, 21);
		contentPane.add(hour);
		
		JComboBox hour_1 = new JComboBox();
		hour_1.setEditable(true);
		hour_1.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		hour_1.setBounds(130, 233, 36, 21);
		contentPane.add(hour_1);
		
		JComboBox hour_2 = new JComboBox();
		hour_2.setEditable(true);
		hour_2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		hour_2.setBounds(130, 264, 36, 21);
		contentPane.add(hour_2);
		
		JComboBox hour_3 = new JComboBox();
		hour_3.setEditable(true);
		hour_3.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		hour_3.setBounds(130, 295, 36, 21);
		contentPane.add(hour_3);
		
		JComboBox hour_4 = new JComboBox();
		hour_4.setEditable(true);
		hour_4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		hour_4.setBounds(130, 326, 36, 21);
		contentPane.add(hour_4);
		
		JComboBox hour_5 = new JComboBox();
		hour_5.setEditable(true);
		hour_5.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		hour_5.setBounds(130, 357, 36, 21);
		contentPane.add(hour_5);
		
		JComboBox hour_6 = new JComboBox();
		hour_6.setEditable(true);
		hour_6.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		hour_6.setBounds(130, 383, 36, 21);
		contentPane.add(hour_6);
		
		JComboBox minute = new JComboBox();
		minute.setEditable(true);
		minute.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		minute.setBounds(194, 202, 36, 21);
		contentPane.add(minute);
		
		JComboBox minute_1 = new JComboBox();
		minute_1.setEditable(true);
		minute_1.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		minute_1.setBounds(194, 233, 36, 21);
		contentPane.add(minute_1);
		
		JComboBox minute_2 = new JComboBox();
		minute_2.setEditable(true);
		minute_2.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		minute_2.setBounds(194, 264, 36, 21);
		contentPane.add(minute_2);
		
		JComboBox minute_3 = new JComboBox();
		minute_3.setEditable(true);
		minute_3.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		minute_3.setBounds(194, 295, 36, 21);
		contentPane.add(minute_3);
		
		JComboBox minute_4 = new JComboBox();
		minute_4.setEditable(true);
		minute_4.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		minute_4.setBounds(194, 326, 36, 21);
		contentPane.add(minute_4);
		
		JComboBox minute_5 = new JComboBox();
		minute_5.setEditable(true);
		minute_5.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		minute_5.setBounds(194, 357, 36, 21);
		contentPane.add(minute_5);
		
		JComboBox minute_6 = new JComboBox();
		minute_6.setEditable(true);
		minute_6.setModel(new DefaultComboBoxModel(new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24"}));
		minute_6.setBounds(194, 383, 36, 21);
		contentPane.add(minute_6);
		
		JLabel hourtitle = DefaultComponentFactory.getInstance().createTitle("\uC2DC ~");
		hourtitle.setBounds(166, 205, 26, 15);
		contentPane.add(hourtitle);
		
		JLabel hourtitle_1 = DefaultComponentFactory.getInstance().createTitle("\uC2DC ~");
		hourtitle_1.setBounds(166, 236, 26, 15);
		contentPane.add(hourtitle_1);
		
		JLabel hourtitle_2 = DefaultComponentFactory.getInstance().createTitle("\uC2DC ~");
		hourtitle_2.setBounds(166, 267, 36, 15);
		contentPane.add(hourtitle_2);
		
		JLabel hourtitle_3 = DefaultComponentFactory.getInstance().createTitle("\uC2DC ~");
		hourtitle_3.setBounds(166, 298, 36, 15);
		contentPane.add(hourtitle_3);
		
		JLabel hourtitle_4 = DefaultComponentFactory.getInstance().createTitle("\uC2DC ~");
		hourtitle_4.setBounds(166, 329, 26, 15);
		contentPane.add(hourtitle_4);
		
		JLabel hourtitle_5 = DefaultComponentFactory.getInstance().createTitle("\uC2DC ~");
		hourtitle_5.setBounds(166, 360, 36, 15);
		contentPane.add(hourtitle_5);
		
		JLabel hourtitle_6 = DefaultComponentFactory.getInstance().createTitle("\uC2DC ~");
		hourtitle_6.setBounds(166, 386, 36, 15);
		contentPane.add(hourtitle_6);
		
		JLabel minutetitle = DefaultComponentFactory.getInstance().createTitle("\uC2DC");
		minutetitle.setBounds(230, 205, 26, 15);
		contentPane.add(minutetitle);
		
		JLabel minutetitle_1 = DefaultComponentFactory.getInstance().createTitle("\uC2DC");
		minutetitle_1.setBounds(230, 236, 106, 15);
		contentPane.add(minutetitle_1);
		
		JLabel minutetitle_2 = DefaultComponentFactory.getInstance().createTitle("\uC2DC");
		minutetitle_2.setBounds(230, 267, 106, 15);
		contentPane.add(minutetitle_2);
		
		JLabel minutetitle_3 = DefaultComponentFactory.getInstance().createTitle("\uC2DC");
		minutetitle_3.setBounds(230, 298, 106, 15);
		contentPane.add(minutetitle_3);
		
		JLabel minutetitle_4 = DefaultComponentFactory.getInstance().createTitle("\uC2DC");
		minutetitle_4.setBounds(230, 329, 106, 15);
		contentPane.add(minutetitle_4);
		
		JLabel minutetitle_5 = DefaultComponentFactory.getInstance().createTitle("\uC2DC");
		minutetitle_5.setBounds(230, 360, 106, 15);
		contentPane.add(minutetitle_5);
		

		JLabel minutetitle_6 = DefaultComponentFactory.getInstance().createTitle("\uC2DC");
		minutetitle_6.setBounds(230, 388, 106, 15);
		contentPane.add(minutetitle_6);
		

		
		list = schedule_service.Schedule_List(BusinessMain.business_id); // 스케줄 서비스

		for(int i = 0; i < list.size(); i++){
			switch(list.get(i).getBusiness_day()){
			case "월":
				hour.setEditable(true);
				hour.setSelectedItem(list.get(i).getBusiness_hour().substring(0, 2));
				minute.setEditable(true);
				minute.setSelectedItem(list.get(i).getBusiness_hour().substring(2, 4));
				mon_addr.setText(list.get(i).getBusiness_addr());
				break;
			case "화":
				hour_1.setEditable(true);
				hour_1.setSelectedItem(list.get(i).getBusiness_hour().substring(0, 2));
				minute_1.setEditable(true);
				minute_1.setSelectedItem(list.get(i).getBusiness_hour().substring(2, 4));
				tues_addr.setText(list.get(i).getBusiness_addr());
				break;
			case "수":
				hour_2.setEditable(true);
				hour_2.setSelectedItem(list.get(i).getBusiness_hour().substring(0, 2));
				minute_2.setEditable(true);
				minute_2.setSelectedItem(list.get(i).getBusiness_hour().substring(2, 4));
				wed_addr.setText(list.get(i).getBusiness_addr());
				break;
			case "목":
				hour_3.setEditable(true);
				hour_3.setSelectedItem(list.get(i).getBusiness_hour().substring(0, 2));
				minute_3.setEditable(true);
				minute_3.setSelectedItem(list.get(i).getBusiness_hour().substring(2, 4));
				thu_addr.setText(list.get(i).getBusiness_addr());
				break;
			case "금":
				hour_4.setEditable(true);
				hour_4.setSelectedItem(list.get(i).getBusiness_hour().substring(0, 2));
				minute_4.setEditable(true);
				minute_4.setSelectedItem(list.get(i).getBusiness_hour().substring(2, 4));
				fri_addr.setText(list.get(i).getBusiness_addr());
				break;
			case "토":
				hour_5.setEditable(true);
				hour_5.setSelectedItem(list.get(i).getBusiness_hour().substring(0, 2));
				minute_5.setEditable(true);
				minute_5.setSelectedItem(list.get(i).getBusiness_hour().substring(2, 4));
				sat_addr.setText(list.get(i).getBusiness_addr());
				break;
			case "일":
				hour_6.setEditable(true);
				hour_6.setSelectedItem(list.get(i).getBusiness_hour().substring(0, 2));
				minute_6.setEditable(true);
				minute_6.setSelectedItem(list.get(i).getBusiness_hour().substring(2, 4));
				sun_addr.setText(list.get(i).getBusiness_addr());
				break;
			}
		}
		
		JLabel updateButton = new JLabel("New label");
		updateButton.setBounds(87, 453, 94, 47);
		updateButton.setIcon(new ImageIcon(util.imgResize(updateButton,"/images/updateButton.png")));
		contentPane.add(updateButton);
		
		updateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				updateButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				updateButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e){
				//수정 버튼을 눌렀을 때 실행될 메소드
				//월요일
				schedule.setBusiness_id(BusinessMain.business_id);
				schedule.setBusiness_day("월");
				schedule.setBusiness_hour((String)hour.getSelectedItem() + (String)minute.getSelectedItem());
				schedule.setBusiness_addr(mon_addr.getText());
				if(!((String)hour.getSelectedItem()).equals("00") && !((String)minute.getSelectedItem()).equals("00") &&
						!mon_addr.getText().equals("")) schedule_service.Schedule_Insert(schedule);
				//화요일
				schedule.setBusiness_day("화");
				schedule.setBusiness_hour((String)hour_1.getSelectedItem() + (String)minute_1.getSelectedItem());
				schedule.setBusiness_addr(tues_addr.getText());
				if(!((String)hour_1.getSelectedItem()).equals("00") && !((String)minute_1.getSelectedItem()).equals("00") &&
						!tues_addr.getText().equals("")) schedule_service.Schedule_Insert(schedule);
				//수요일
				schedule.setBusiness_day("수");
				schedule.setBusiness_hour((String)hour_2.getSelectedItem() + (String)minute_2.getSelectedItem());
				schedule.setBusiness_addr(wed_addr.getText());
				if(!((String)hour_2.getSelectedItem()).equals("00") && !((String)minute_2.getSelectedItem()).equals("00") &&
						!wed_addr.getText().equals("")) schedule_service.Schedule_Insert(schedule);
				//목요일
				schedule.setBusiness_day("목");
				schedule.setBusiness_hour((String)hour_3.getSelectedItem() + (String)minute_3.getSelectedItem());
				schedule.setBusiness_addr(thu_addr.getText());
				if(!((String)hour_3.getSelectedItem()).equals("00") && !((String)minute_3.getSelectedItem()).equals("00") &&
						!thu_addr.getText().equals("")) schedule_service.Schedule_Insert(schedule);
				//금요일
				schedule.setBusiness_day("금");
				schedule.setBusiness_hour((String)hour_4.getSelectedItem() + (String)minute_4.getSelectedItem());
				schedule.setBusiness_addr(fri_addr.getText());
				if(!((String)hour_4.getSelectedItem()).equals("00") && !((String)minute_4.getSelectedItem()).equals("00") &&
						!fri_addr.getText().equals("")) schedule_service.Schedule_Insert(schedule);
				//토요일
				schedule.setBusiness_day("토");
				schedule.setBusiness_hour((String)hour_5.getSelectedItem() + (String)minute_5.getSelectedItem());
				schedule.setBusiness_addr(sat_addr.getText());
				if(!((String)hour_5.getSelectedItem()).equals("00") && !((String)minute_5.getSelectedItem()).equals("00") &&
						!sat_addr.getText().equals("")) schedule_service.Schedule_Insert(schedule);
				//일요일
				schedule.setBusiness_day("일");
				schedule.setBusiness_hour((String)hour_6.getSelectedItem() + (String)minute_6.getSelectedItem());
				schedule.setBusiness_addr(sun_addr.getText());
				if(!((String)hour_6.getSelectedItem()).equals("00") && !((String)minute_6.getSelectedItem()).equals("00") &&
						!sun_addr.getText().equals("")) schedule_service.Schedule_Insert(schedule);
				
				JOptionPane.showMessageDialog(new Schedule(), "수정에 성공했습니다.");
				setVisible(false);	
				
				}
			});
		
		schedulePage = new JLabel("New label");
		schedulePage.setBounds(0, 0, 440, 510);
		schedulePage.setIcon(new ImageIcon(util.imgResize(schedulePage, "/images/schedule.jpg")));
		contentPane.add(schedulePage);
		
	}
}
