package org.douggschwind.games.boardgames.monopoly.space;

import org.douggschwind.games.boardgames.monopoly.Monopoly;
import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * When a player lands on this space, they must go directly to Jail, and on their
 * way passing Go, do NOT collect $200.
 * @author Doug Gschwind
 */
public class GoDirectlyToJailSpace extends PublicBoardSpace {

	public GoDirectlyToJailSpace() {
		super("Go directly to Jail");
	}
	
	@Override
	public final void takeAction(Monopoly gameInProgress, Player player, int playerDiceRollTotal) {
		gameInProgress.playerLandedOnGoToJailSpace(player);
	}
}