package edu.towson.cis.cosc603.project2.monopoly.gui;

import edu.towson.cis.cosc603.project2.monopoly.IOwnable;
import edu.towson.cis.cosc603.project2.monopoly.Player;
import edu.towson.cis.cosc603.project2.monopoly.RailRoadCell;

// TODO: Auto-generated Javadoc
/**
 * The Class RRCellInfoFormatter.
 */
public class RRCellInfoFormatter implements CellInfoFormatter {
    
    /* (non-Javadoc)
     * @see edu.towson.cis.cosc603.project2.monopoly.gui.CellInfoFormatter#format(edu.towson.cis.cosc603.project2.monopoly.IOwnable)
     */
    public String format(IOwnable cell) {
        RailRoadCell c = (RailRoadCell)cell;
        StringBuffer buf = new StringBuffer();
        Player owner = cell.getTheOwner();
        String ownerName = "";
        if(owner != null) {
        	ownerName = owner.getName();
        }
        buf.append("<html><b><font color='lime'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
				.append("<br>Owner: ").append(ownerName)
                .append("</html>");
        return buf.toString();
    }
}
