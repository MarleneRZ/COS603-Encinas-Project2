package edu.towson.cis.cosc603.project2.monopoly;

public interface IOwnable {

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public abstract String getName();

	/**
	 * Gets the theOwner.
	 *
	 * @return the theOwner
	 */
	public abstract Player getTheOwner();

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public abstract int getPrice();

	/**
	 * Sets the theOwner.
	 *
	 * @param theOwner the new theOwner
	 */
	public abstract void setTheOwner(Player owner);

	/**
	 * Checks if is available.
	 *
	 * @return true, if is available
	 */
	public abstract boolean isAvailable();

	/**
	 * Sets the available.
	 *
	 * @param available the new available
	 */
	public abstract void setAvailable(boolean available);

}