package edu.towson.cis.cosc603.project2.monopoly.gui;

import edu.towson.cis.cosc603.project2.monopoly.IOwnable;
import edu.towson.cis.cosc603.project2.monopoly.Player;
import edu.towson.cis.cosc603.project2.monopoly.PropertyCell;

// TODO: Auto-generated Javadoc
/**
 * The Class PropertyCellInfoFormatter.
 */
public class PropertyCellInfoFormatter implements CellInfoFormatter {
    
    /* (non-Javadoc)
     * @see edu.towson.cis.cosc603.project2.monopoly.gui.CellInfoFormatter#format(edu.towson.cis.cosc603.project2.monopoly.IOwnable)
     */
    public String format(IOwnable cell) {
        PropertyCell c = (PropertyCell)cell;
        StringBuffer buf = new StringBuffer();
        Player owner = cell.getTheOwner();
        String ownerName = "";
        if(owner != null) {
        	ownerName = owner.getName();
        }
        buf.append("<html><b><font color='")
                .append(c.getColorGroup())
                .append("'>")
                .append(cell.getName())
                .append("</font></b><br>")
                .append("$").append(c.getPrice())
				.append("<br>Owner: ").append(ownerName)
				.append("<br>* ").append(c.getNumHouses())
                .append("</html>");
        return buf.toString();
    }
}
