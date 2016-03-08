package edu.towson.cis.cosc603.project2.monopoly;

// TODO: Auto-generated Javadoc
/**
 * The Class Cell.
 */
public abstract class Cell implements IOwnable {
	
	/** The name. */
	private String name;
	
	/** The theOwner. */
	protected Player theOwner;

	/** The available. */
	private boolean available = true;

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc603.project2.monopoly.IOwnable#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc603.project2.monopoly.IOwnable#getTheOwner()
	 */
	@Override
	public Player getTheOwner() {
		return theOwner;
	}
	
	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc603.project2.monopoly.IOwnable#getPrice()
	 */
	@Override
	public int getPrice() {
		return 0;
	}

	/**
	 * Play action.
	 * @param msg TODO
	 * @return TODO
	 */
	public abstract boolean playAction(String msg);

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc603.project2.monopoly.IOwnable#setTheOwner(edu.towson.cis.cosc603.project2.monopoly.Player)
	 */
	@Override
	public void setTheOwner(Player owner) {
		this.theOwner = owner;
	}
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() {
        return name;
    }

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc603.project2.monopoly.IOwnable#isAvailable()
	 */
	@Override
	public boolean isAvailable() {
		return available;
	}

	/* (non-Javadoc)
	 * @see edu.towson.cis.cosc603.project2.monopoly.IOwnable#setAvailable(boolean)
	 */
	@Override
	public void setAvailable(boolean available) {
		this.available = available;
	}

	/**
	 * Purchase.
	 * @param player
	 */
	public void purchase(Player player) {
		if (isAvailable()) {
			IOwnable c = player.getPosition();//position;
			c.setAvailable(false);
			if (c instanceof PropertyCell) {
				PropertyCell cell = (PropertyCell) c;
				player.purchaseProperty(cell);
			}
			if (c instanceof RailRoadCell) {
				RailRoadCell cell = (RailRoadCell) c;
				player.purchaseRailRoad(cell);
			}
			if (c instanceof UtilityCell) {
				UtilityCell cell = (UtilityCell) c;
				player.purchaseUtility(cell);
			}
		}
	}

	public void playerMoved(Player player, int playerIndex,
			GameMaster gameMaster) {
		if (this.isAvailable()) {
			int price = this.getPrice();
			if (price <= player.getMoney() && price > 0) {
				gameMaster.getGUI().enablePurchaseBtn(playerIndex);
			}
		}
		gameMaster.getGUI().enableEndTurnBtn(playerIndex);
	}
}
