package gotBrains;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * A class used for restricting maximum characters of a textfield etc.
 * 
 * @author Isak Hartman
 *
 */
public final class LengthRestrictedDocument extends PlainDocument {
	private final int limit;

	/**
	 * Sets the limit to the paramteter value.
	 * 
	 * @param int
	 *            limit
	 */
	public LengthRestrictedDocument(int limit) {
		this.limit = limit;
	}

	public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {
		if (str == null)
			return;

		if ((getLength() + str.length()) <= limit) {
			super.insertString(offs, str, a);
		}
	}
}