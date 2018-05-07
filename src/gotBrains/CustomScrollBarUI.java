package gotBrains;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JScrollBar;
import javax.swing.plaf.basic.BasicScrollBarUI;

/**
 * Custom Scrollbar used in JScrollPanes
 * 
 * @author http://www.programcreek.com/java-api-examples/index.php?api=javax.swing.plaf.basic.BasicScrollBarUI
 *
 */

public class CustomScrollBarUI extends BasicScrollBarUI {

	@Override
	protected JButton createDecreaseButton(int orientation) {
		return createZeroButton();
	}

	@Override
	protected JButton createIncreaseButton(int orientation) {
		return createZeroButton();
	}

	private JButton createZeroButton() {
		JButton jbutton = new JButton();
		jbutton.setPreferredSize(new Dimension(0, 0));
		jbutton.setMinimumSize(new Dimension(0, 0));
		jbutton.setMaximumSize(new Dimension(0, 0));
		return jbutton;
	}

	@Override
	protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
		g.setColor(new Color(0, 0, 0, 0));
		g.fillRect(trackBounds.x, trackBounds.y, trackBounds.width - 5, trackBounds.height - 5);

	}

	@Override
	protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
		if (thumbBounds.isEmpty() || !scrollbar.isEnabled()) {
			return;
		}
		Rectangle thumbRect = new Rectangle(0, 0);

		super.paintThumb(g, c, thumbRect);
		int tw = thumbBounds.width;
		int th = thumbBounds.height;

		g.translate(thumbBounds.x, thumbBounds.y);

		Graphics2D g2 = (Graphics2D) g;
		Paint gp = null;
		if (this.scrollbar.getOrientation() == JScrollBar.VERTICAL) {
			gp = new Color(80, 80, 80, 200);
		}
		if (this.scrollbar.getOrientation() == JScrollBar.HORIZONTAL) {
			gp = new Color(80, 80, 80, 200);
		}
		g2.setPaint(gp);
		g2.fillRoundRect(9, 0, tw - 10, th - 1, 5, 5);

		g2.drawRoundRect(9, 0, tw - 10, th - 1, 5, 5);
	}
}
