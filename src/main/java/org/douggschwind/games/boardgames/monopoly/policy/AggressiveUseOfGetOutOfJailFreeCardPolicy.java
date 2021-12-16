package org.douggschwind.games.boardgames.monopoly.policy;

import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * In this implementation of this policy, the Player doesn't care even if there are no Titles
 * available for purchase, just get them out of Jail so that they can move around the board.
 * @author Doug Gschwind
 */
public class AggressiveUseOfGetOutOfJailFreeCardPolicy implements UseOfGetOutOfJailFreeCardPolicy {

	@Override
	public boolean shouldUseGetOutOfJailFreeCard(Player player, int numberTitlesAvailableForPurchase) {
		return true;
	}
}