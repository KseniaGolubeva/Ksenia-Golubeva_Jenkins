package org.douggschwind.games.cardgames.poker.common;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;

/**
 * In the case of a Full House, we only care about the Kind 
 * in which the hand has three of those. The additional pair
 * is used to arrive at a FullHouse, but is not needed in
 * the computation to determine who won a hand.
 * @author Doug Gschwind
 */
public class FullHouse extends MatchedKind {

	public FullHouse(FrenchSuitedPlayingCard.Kind kind) {
		super(kind);
	}

	@Override
	public final int getHandRank() {
		return 4;
	}
}