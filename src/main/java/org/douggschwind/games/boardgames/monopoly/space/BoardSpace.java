package org.douggschwind.games.boardgames.monopoly.space;

import org.douggschwind.games.boardgames.monopoly.DiceRollResult;
import org.douggschwind.games.boardgames.monopoly.Monopoly;
import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * The Monopoly gameboard consists of 40 spaces containing 28 properties (22 colored streets, four railway stations and two utilities), three Chance spaces,
 * three Community Chest spaces, a Luxury Tax space, an Income Tax space, and the four corner squares: GO, (In) Jail/Just Visiting, Free Parking, and Go to Jail.
 * 
 * An instance of this class represents one of those 40 board spaces.
 * @author Doug Gschwind
 */
public abstract class BoardSpace {
	private final String name;
	
	protected BoardSpace(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean canBePrivatelyHeld() {
		return false;
	}
	
	public void resetOwnership() {
	}
	
	public boolean isPubliclyHeld() {
		return false;
	}
	
	public boolean canPlayerAdvance(Player player, DiceRollResult diceRollResult) {
		return true;
	}
	
	public void isDepartingThisSpace(Player player) {
		// If the player can depart this space, they are obviously
		// not in Jail.
		player.setInJail(false);
	}
	
	/**
	 * Takes action now that it is known that the given Player has landed on
	 * this given instance.
	 * @param gameInProgress Must be non-null.
	 * @param hasLanded Must be non-null.
	 */
	public void takeAction(Monopoly gameInProgress, Player hasLanded, int playerDiceRollTotal) {
	}
}