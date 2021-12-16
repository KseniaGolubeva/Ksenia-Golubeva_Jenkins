package org.douggschwind.games.boardgames.monopoly.space;

import org.douggschwind.games.boardgames.monopoly.Monopoly;
import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * Represents a Community Chest space on the Monopoly board.
 * @author Doug Gschwind
 */
public class CommunityChestSpace extends PublicBoardSpace {

	public CommunityChestSpace() {
		super("Community Chest");
	}

	@Override
	public final void takeAction(Monopoly gameInProgress, Player player, int playerDiceRollTotal) {
		gameInProgress.playerLandedOnCommunityChestSpace(player, playerDiceRollTotal);
	}
}