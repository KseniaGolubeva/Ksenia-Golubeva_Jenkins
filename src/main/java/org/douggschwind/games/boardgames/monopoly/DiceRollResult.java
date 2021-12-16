package org.douggschwind.games.boardgames.monopoly;

/**
 * Houses the result when a Player rolls the dice.
 * @author Doug Gschwind
 */
public class DiceRollResult {
	
	private final int diceRollTotal; // 2 to 12
	private final boolean doublesWereRolled;

	public DiceRollResult(int diceRollTotal, boolean doublesWereRolled) {
		this.diceRollTotal = diceRollTotal;
		this.doublesWereRolled = doublesWereRolled;
	}
	
	public int getDiceRollTotal() {
		return diceRollTotal;
	}
	
	public boolean wereDoublesRolled() {
		return doublesWereRolled;
	}
}