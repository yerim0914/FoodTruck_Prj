package businessUI.util;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ResizableUtil extends JFrame {
	private JPanel contentPane;
	private JLabel label;
	//private String path;

	public ResizableUtil() {
	//public Util() throws HeadlessException {
		super();
	}

	public Image imgResize(JLabel label, String path) {	//이미지 리사이즈
		ImageIcon iconOriginal = new ImageIcon(ResizableUtil.class.getResource(path));
		Image imgOriginal = iconOriginal.getImage();
		Image imgNew = imgOriginal.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
		return imgNew;

	}
}
