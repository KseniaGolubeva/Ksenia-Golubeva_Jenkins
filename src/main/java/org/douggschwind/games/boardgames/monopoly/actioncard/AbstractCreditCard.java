package org.douggschwind.games.boardgames.monopoly.actioncard;

/**
 * An instance of this class represents an amount that is known a priori,
 * that the Player will be paid.
 * @author Doug Gschwind
 */
public abstract class AbstractCreditCard extends InvariantAmountActionCard {
	public AbstractCreditCard(String cardName, int amount) {
		super(cardName, amount);
	}
}