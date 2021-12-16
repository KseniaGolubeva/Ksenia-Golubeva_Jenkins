package org.douggschwind.games.boardgames.monopoly.space;

import org.douggschwind.games.boardgames.monopoly.Monopoly;
import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * When a Player lands on this space, they must simply pay $200.
 * @author Doug Gschwind
 */
public class IncomeTaxSpace extends PublicBoardSpace {

	public IncomeTaxSpace() {
		super("Income Tax");
	}
	
	@Override
	public final void takeAction(Monopoly gameInProgress, Player player, int playerDiceRollTotal) {
		gameInProgress.playerLandedOnIncomeTaxSpace(player);
	}
}