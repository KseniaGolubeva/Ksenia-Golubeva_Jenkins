package org.douggschwind.games.boardgames.monopoly.space;

import org.douggschwind.games.boardgames.monopoly.Monopoly;
import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * When a Player lands on this space, they incur no costs and remain on the space
 * until their next dice roll.
 * @author Doug Gschwind
 */
public class FreeParkingSpace extends PublicBoardSpace {

	public FreeParkingSpace() {
		super("Free Parking");
	}
	
	@Override
	public final void takeAction(Monopoly gameInProgress, Player player, int playerDiceRollTotal) {
		// Do nothing.
	}
}
