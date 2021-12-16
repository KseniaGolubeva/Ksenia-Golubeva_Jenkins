package org.douggschwind.games.boardgames.monopoly.policy;

import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * In this implementation of this policy, the Player does care if there are few Titles
 * available for purchase. If there are few or even none, sit out a turn or two in Jail
 * to hopefully save money due to landing on Titles owned by opponents. Of course, this
 * policy isn't well informed, doesn't know which properties are available, how close they
 * are to the Jail board spot, etc. That would be an advanced exercise to consider.
 * @author Doug Gschwind
 */
public class ConservativeUseOfGetOutOfJailFreeCardPolicy implements UseOfGetOutOfJailFreeCardPolicy {

	@Override
	public boolean shouldUseGetOutOfJailFreeCard(Player player, int numberTitlesAvailableForPurchase) {
		if (player.getBankAccountBalance() < 230) {
			// Don't have much money to buy Titles anyway, hang out in Jail for another
			// turn or two. $230 is a rough approximation of the average cost to purchase
			// a Title on the board.
			return false;
		}
		
		// Just a WAG at a reasonable number here.
		return (numberTitlesAvailableForPurchase >= 5);
	}
}