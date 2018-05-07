package gotBrains;

import java.awt.Color;  
import java.awt.Graphics;  
import java.awt.event.FocusEvent;  
import java.awt.event.FocusListener;  
import javax.swing.plaf.basic.BasicTextFieldUI;  
import javax.swing.text.JTextComponent;
/**
 * A class that sets a hint in a Textfield if the textfield is empty.
 * 
 * @author https://blogs.sequoiainc.com/java-swing-hint-text-on-a-jtextfield/
 * Modified by @author Isak Hartman
 */
public class JTextFieldHintUI extends BasicTextFieldUI implements FocusListener {  
    private String hint;
    private Color  hintColor;

    public JTextFieldHintUI(String hint, Color hintColor) {
        this.hint = hint;
        this.hintColor = hintColor;
    }

    private void repaint() {
        if (getComponent() != null) {
            getComponent().repaint();
        }
    }

    @Override
    protected void paintSafely(Graphics g) {
        // Render the default text field UI
        super.paintSafely(g);
        // Render the hint text
        JTextComponent component = getComponent();
        if (component.getText().length() == 0) {
            g.setColor(hintColor);
            int padding = (component.getHeight() - component.getFont().getSize()) / 2;
            int inset = 18;
            g.drawString(hint, inset, component.getHeight()-3 - padding);
        }
    }

    @Override
    public void focusGained(FocusEvent e) {
        repaint();
    }

    @Override
    public void focusLost(FocusEvent e) {
        repaint();
    }

    @Override
    public void installListeners() {
        super.installListeners();
        getComponent().addFocusListener(this);
    }

    @Override
    public void uninstallListeners() {
        super.uninstallListeners();
        getComponent().removeFocusListener(this);
    }
}