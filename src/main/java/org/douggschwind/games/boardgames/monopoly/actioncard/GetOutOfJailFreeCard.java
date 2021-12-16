package org.douggschwind.games.boardgames.monopoly.actioncard;

import org.douggschwind.games.boardgames.monopoly.Monopoly;
import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * An instance of this card entitles the bearer to be able to extricate themselves
 * from the Jail BoardSpace should they land there.
 * @author Doug Gschwind
 */
public class GetOutOfJailFreeCard extends ActionCard {

	public GetOutOfJailFreeCard() {
		super("Get out of Jail Free!");
	}

	@Override
	public final void takeAction(Monopoly gameInProgress, Player player, int playerDiceRollTotal) {
		gameInProgress.playerHasAcquiredGetOutOfJailFreeCard(player);
	}
}