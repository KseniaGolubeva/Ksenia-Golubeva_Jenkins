package org.douggschwind.games.boardgames.monopoly.policy;

import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * @author Doug Gschwind
 */
public interface UseOfGetOutOfJailFreeCardPolicy {
	
	/**
	 * This operation returns true if the implementation indicates the Player, when in Jail,
	 * should use their "Get out of Jail free" card, should they have one in their possession.
	 * There may be times when it is advantageous to simply remain in Jail for another turn
	 * or two.
	 * @param player Must be non-null.
	 * @param numberTitlesAvailableForPurchase Indicates the overall number of Titles
	 * that remain available for purchase by any Player, which includes Properties, Railroads,
	 * and Utilities.
	 * @return true if the Player should use their Get out of Jail free card, false if they
	 * should retain it.
	 */
	public boolean shouldUseGetOutOfJailFreeCard(Player player, int numberTitlesAvailableForPurchase);
}