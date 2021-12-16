package org.douggschwind.games.boardgames.monopoly.actioncard;

import org.douggschwind.games.boardgames.monopoly.Monopoly;
import org.douggschwind.games.boardgames.monopoly.Player;
import org.douggschwind.games.common.AbstractCard;

/**
 * ActionCards in Monopoly form the basis for the Community Chest and Chance cards.
 * @author Doug Gschwind
 */
public abstract class ActionCard implements AbstractCard {
	private final String cardName; // e.g. Go to Jail
	
	protected ActionCard(String cardName) {
		this.cardName = cardName;
	}
	
	public final String getCardName() {
		return cardName;
	}
	
	public abstract void takeAction(Monopoly gameInProgress, Player player, int playerDiceRollTotal);
}