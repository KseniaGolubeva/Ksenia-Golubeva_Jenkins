package org.douggschwind.games.cardgames.poker.common;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;

/**
 * @author Doug Gschwind
 */
public class RoyalFlush extends StraightFlush {

	public RoyalFlush() {
		super(FrenchSuitedPlayingCard.Kind.Ace);
	}
	
	@Override
	public final int getHandRank() {
		return 1;
	}
}