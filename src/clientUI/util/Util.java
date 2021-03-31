package clientUI.util;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Util extends JFrame {
	
	private JPanel contentPane;
	private JLabel label;

	public Util() {
		super();
	}

	public Image imgResize(JLabel label, String path) {	//label 이미지 리사이즈
		ImageIcon iconOriginal = new ImageIcon(Util.class.getResource(path));
		Image imgOriginal = iconOriginal.getImage();
		Image imgNew = imgOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		return imgNew;
	}
	
	public Image iconResize(String path) {	//아이콘 이미지 리사이즈
		ImageIcon iconOriginal = new ImageIcon(Util.class.getResource(path));
		Image imgOriginal = iconOriginal.getImage();
		Image imgNew = imgOriginal.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		return imgNew;
	}	
	

}
