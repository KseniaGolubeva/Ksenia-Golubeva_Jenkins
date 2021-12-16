package org.douggschwind.games.boardgames.monopoly.title;

import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * An instance of this class represents something that can be purchased and owned by
 * a given Player : property, railroad, or utility. An instance of this class that
 * is NOT a TitleDeed is a railroad or utility for which a usage fee can be charged
 * to an opponent.
 * @author Doug Gschwind
 */
public class Title {
	private final MonopolyDefinition monopolyDefinition;
	private final String name;
	private final int purchasePrice;
	private final int mortgageValue;
	private final int mortgageLiftingPrice;
	private Player owner;
	private boolean mortgaged;
	
	public Title(MonopolyDefinition monopolyDefinition,
			     String name,
			     int purchasePrice) {
		this.monopolyDefinition = monopolyDefinition;
		this.name = name;
		this.purchasePrice = purchasePrice;
		this.mortgageValue = purchasePrice / 2;
		this.mortgageLiftingPrice = (int) (mortgageValue * 1.1); // 10% above mortgageValue
		monopolyDefinition.addTitle(this);
	}
	
	public boolean isTitleDeed() {
		return false;
	}
	
	public MonopolyDefinition getMonopolyDefinition() {
		return monopolyDefinition;
	}
	
	public boolean isProperty() {
		return getMonopolyDefinition().isProperty();
	}
	
	public boolean isRailroad() {
		return getMonopolyDefinition().isRailroad();
	}
	
	public boolean isUtility() {
		return getMonopolyDefinition().isUtility();
	}
	
	public String getName() {
		return name;
	}

	public int getPurchasePrice() {
		return purchasePrice;
	}

	public int getMortgageValue() {
		return mortgageValue;
	}
	
	public int getMortgageLiftingPrice() {
		return mortgageLiftingPrice;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
		if (owner == null) {
			// Ownership is changing back to the Bank, thus
			// this Title is no longer mortgaged.
			setMortgaged(false);
		} else {
			owner.acceptOwnership(this);
		}
	}
	
	public boolean isBankOwned() {
		return (getOwner() == null);
	}
	
	/**
	 * Determines whether or not the given Player is the owner of this Property.
	 * @param player Expected to be non-null.
	 * @return true if so, false otherwise.
	 */
	public boolean isOwner(Player player) {
		return ((getOwner() != null) && (getOwner().equals(player)));
	}
	
	public boolean isPartOfMonopoly() {
		return getMonopolyDefinition().hasBeenMonopolized();
	}

	public boolean isMortgaged() {
		return mortgaged;
	}

	public void setMortgaged(boolean newValue) {
		mortgaged = newValue;
	}
	
	public int computeBuildingsLiquidationValue(int numberHousesOnProperty, int numberHotelsOnProperty) {
		return 0;
	}
	
	/**
	 * Typically used to reset game state before playing a new game.
	 */
	public void reset() {
		setOwner(null);
	}
}