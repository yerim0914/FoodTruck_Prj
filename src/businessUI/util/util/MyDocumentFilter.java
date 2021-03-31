package businessUI.util;

import javax.swing.JTextArea;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class MyDocumentFilter extends DocumentFilter {

    private JTextArea area;
    private int max;

    public MyDocumentFilter(JTextArea area, int max) {
        this.area = area;
        this.max = max;
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length,
            String text, AttributeSet attrs) throws BadLocationException {
        super.replace(fb, offset, length, text, attrs);
        int lines = area.getLineCount();
        if (lines > max) {
            int linesToRemove = lines - max -1;
            int lengthToRemove = area.getLineStartOffset(linesToRemove);
            remove(fb, 0, lengthToRemove);
        }
    }
}
