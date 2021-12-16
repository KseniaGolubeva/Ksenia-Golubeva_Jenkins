package org.douggschwind.games.boardgames.monopoly.actioncard;

/**
 * An instance of this class represents an amount that is known a priori,
 * that the Player must pay.
 * @author Doug Gschwind
 */
public abstract class AbstractDebitCard extends InvariantAmountActionCard {
	public AbstractDebitCard(String cardName, int amount) {
		super(cardName, amount);
	}
}