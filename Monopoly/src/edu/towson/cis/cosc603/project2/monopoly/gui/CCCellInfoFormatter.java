package edu.towson.cis.cosc603.project2.monopoly.gui;

import edu.towson.cis.cosc603.project2.monopoly.IOwnable;

// TODO: Auto-generated Javadoc
/**
 * The Class CCCellInfoFormatter.
 */
public class CCCellInfoFormatter implements CellInfoFormatter {
    
    /* (non-Javadoc)
     * @see edu.towson.cis.cosc603.project2.monopoly.gui.CellInfoFormatter#format(edu.towson.cis.cosc603.project2.monopoly.IOwnable)
     */
    public String format(IOwnable cell) {
        return "<html><font color='white'><b>" + cell.getName() + "</b></font></html>";
    }
}
