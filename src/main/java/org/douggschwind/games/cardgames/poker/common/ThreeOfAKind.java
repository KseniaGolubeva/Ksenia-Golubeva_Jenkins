package org.douggschwind.games.cardgames.poker.common;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;

/**
 * @author Doug Gschwind
 */
public class ThreeOfAKind extends MatchedKind {

	public ThreeOfAKind(FrenchSuitedPlayingCard.Kind kind) {
		super(kind);
	}

	@Override
	public final int getHandRank() {
		return 7;
	}
}