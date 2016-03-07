package edu.towson.cis.cosc603.project2.monopoly.gui;

import edu.towson.cis.cosc603.project2.monopoly.IOwnable;

// TODO: Auto-generated Javadoc
/**
 * The Class ChanceCellInfoFormatter.
 */
public class ChanceCellInfoFormatter implements CellInfoFormatter {
    
    /** The Constant CHANCE_CELL_LABEL. */
    public static final String CHANCE_CELL_LABEL = "<html><font color='teal'><b>Chance</b></font></html>";
    
    /* (non-Javadoc)
     * @see edu.towson.cis.cosc603.project2.monopoly.gui.CellInfoFormatter#format(edu.towson.cis.cosc603.project2.monopoly.IOwnable)
     */
    public String format(IOwnable cell) {
        return CHANCE_CELL_LABEL;
    }
}
