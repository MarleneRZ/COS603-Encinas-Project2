package edu.towson.cis.cosc603.project2.monopoly;

import java.util.ArrayList;
import java.util.Hashtable;

// TODO: Auto-generated Javadoc
/**
 * The Class GameBoard.
 */
public class GameBoard {

	/** The cells. */
	private ArrayList<Cell> cells = new ArrayList<Cell>();
    
    /** The chance cards. */
    private ArrayList<Card> chanceCards = new ArrayList<Card>();
	//the key of colorGroups is the name of the color group.
	/** The color groups. */
	private Hashtable<String, Integer> colorGroups = new Hashtable<String, Integer>();
	
	/** The community chest cards. */
	private ArrayList<Card> communityChestCards = new ArrayList<Card>();
	
	/**
	 * Instantiates a new game board.
	 */
	public GameBoard() {
		Cell go = new GoCell();
		addCell(go);
	}

    /**
     * Adds the card.
     *
     * @param card the card
     */
    public void addCard(Card card) {
        card.addCard(this);
    }
	
	/**
	 * Adds the cell.
	 *
	 * @param cell the cell
	 */
	public void addCell(Cell cell) {
		cells.add(cell);
	}
	
	/**
	 * Adds the cell.
	 *
	 * @param cell the cell
	 */
	public void addCell(PropertyCell cell) {
		String colorGroup = cell.getColorGroup();
		int propertyNumber = getPropertyNumberForColor(colorGroup);
		colorGroups.put(colorGroup, new Integer(propertyNumber + 1));
        cells.add(cell);
	}

    /**
     * Draw cc card.
     *
     * @return the card
     */
    public Card drawCCCard() {
        Card card = (Card)communityChestCards.get(0);
        communityChestCards.remove(0);
        addCard(card);
        return card;
    }

    /**
     * Draw chance card.
     *
     * @return the card
     */
    public Card drawChanceCard() {
        Card card = (Card)chanceCards.get(0);
        chanceCards.remove(0);
        addCard(card);
        return card;
    }

	/**
	 * Gets the cell.
	 *
	 * @param newIndex the new index
	 * @return the cell
	 */
	public Cell getCell(int newIndex) {
		return (Cell)cells.get(newIndex);
	}
	
	/**
	 * Gets the cell number.
	 *
	 * @return the cell number
	 */
	public int getCellNumber() {
		return cells.size();
	}
	
	/**
	 * Gets the properties in monopoly.
	 *
	 * @param color the color
	 * @return the properties in monopoly
	 */
	public PropertyCell[] getPropertiesInMonopoly(String color) {
		PropertyCell[] monopolyCells = 
			new PropertyCell[getPropertyNumberForColor(color)];
		int counter = 0;
		for (int i = 0; i < getCellNumber(); i++) {
			IOwnable c = getCell(i);
			if(c instanceof PropertyCell) {
				PropertyCell pc = (PropertyCell)c;
				if(pc.getColorGroup().equals(color)) {
					monopolyCells[counter] = pc;
					counter++;
				}
			}
		}
		return monopolyCells;
	}
	
	/**
	 * Gets the property number for color.
	 *
	 * @param name the name
	 * @return the property number for color
	 */
	public int getPropertyNumberForColor(String name) {
		Integer number = (Integer)colorGroups.get(name);
		if(number != null) {
			return number.intValue();
		}
		return 0;
	}

	/**
	 * Query cell.
	 *
	 * @param string the string
	 * @return the cell
	 */
	public Cell queryCell(String string) {
		for(int i = 0; i < cells.size(); i++){
			Cell temp = (Cell)cells.get(i); 
			if(temp.getName().equals(string)) {
				return temp;
			}
		}
		return null;
	}
	
	/**
	 * Query cell index.
	 *
	 * @param string the string
	 * @return the int
	 */
	public int queryCellIndex(String string){
		for(int i = 0; i < cells.size(); i++){
			IOwnable temp = (IOwnable)cells.get(i); 
			if(temp.getName().equals(string)) {
				return i;
			}
		}
		return -1;
	}

    /**
     * Removes the cards.
     */
    public void removeCards() {
        communityChestCards.clear();
    }

	/**
	 * Btn draw card clicked.
	 * @param gui
	 * @param gameMaster
	 * @return  the card
	 */
	public Card btnDrawCardClicked(MonopolyGUI gui, GameMaster gameMaster) {
		gui.setDrawCardEnabled(false);
		CardCell cell = (CardCell) gameMaster.getCurrentPlayer().getPosition();
		Card card = null;
		if (cell.getType() == Card.TYPE_CC) {
			card = drawCCCard();
			card.applyAction();
		} else {
			card = drawChanceCard();
			card.applyAction();
		}
		gui.setEndTurnEnabled(true);
		return card;
	}

	

	/**
	 * Send to jail.
	 * @param player    the player
	 * @param gui
	 * @param gameMaster
	 */
	public void sendToJail(Player player, MonopolyGUI gui, GameMaster gameMaster) {
		gameMaster.sendToJail(player, gui, this);
	}

	/**
	 * Move player.
	 * @param player  the player
	 * @param diceValue  the dice value
	 * @param gui
	 * @param gameMaster
	 */
	public void movePlayer(Player player, int diceValue, MonopolyGUI gui,
			GameMaster gameMaster) {
		IOwnable currentPosition = player.getPosition();
		int positionIndex = queryCellIndex(currentPosition.getName());
		int newIndex = (positionIndex + diceValue) % getCellNumber();
		if (newIndex <= positionIndex || diceValue > getCellNumber()) {
			player.setMoney(player.getMoney() + 200);
		}
		player.setPosition(getCell(newIndex));
		gui.movePlayer(gameMaster.getPlayerIndex(player), positionIndex,
				newIndex);
		gameMaster.playerMoved(player);
		gameMaster.updateGUI();
	}

	

	public ArrayList<Card> getCommunityChestCards() {
		return communityChestCards;
	}

	public ArrayList<Card> getChanceCards() {
		return chanceCards;
	}
}
