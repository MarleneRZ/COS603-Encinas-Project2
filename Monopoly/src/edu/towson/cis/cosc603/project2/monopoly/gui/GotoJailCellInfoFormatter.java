package edu.towson.cis.cosc603.project2.monopoly.gui;

import edu.towson.cis.cosc603.project2.monopoly.IOwnable;

// TODO: Auto-generated Javadoc
/**
 * The Class GotoJailCellInfoFormatter.
 */
public class GotoJailCellInfoFormatter implements CellInfoFormatter {

    /** The Constant GOTO_JAIL_LABEL. */
    public static final String GOTO_JAIL_LABEL = "<html><b>Go to Jail</b></html>";

    /* (non-Javadoc)
     * @see edu.towson.cis.cosc603.project2.monopoly.gui.CellInfoFormatter#format(edu.towson.cis.cosc603.project2.monopoly.IOwnable)
     */
    public String format(IOwnable cell) {
    	return GOTO_JAIL_LABEL;
	}
}
