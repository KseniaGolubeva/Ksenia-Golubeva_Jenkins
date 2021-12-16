package org.douggschwind.games.boardgames.monopoly.space;

import org.douggschwind.games.boardgames.monopoly.DiceRollResult;
import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * Represents the Jail space on the Monopoly board.
 * @author Doug Gschwind
 */
public class JailSpace extends PublicBoardSpace {

	public JailSpace() {
		super("Jail");
	}
	
	@Override
	public final boolean canPlayerAdvance(Player player, DiceRollResult diceRollResult) {
		// If Player is not in Jail, they are considered "just visiting"
		return (player.isInJail()) ? diceRollResult.wereDoublesRolled() : true;
	}
}