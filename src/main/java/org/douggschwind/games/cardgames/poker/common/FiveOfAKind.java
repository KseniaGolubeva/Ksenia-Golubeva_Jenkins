package org.douggschwind.games.cardgames.poker.common;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;

/**
 * This hand is only possible when there are wild card(s)
 * present in the deck or more than one standard deck
 * is being used to deal the game.
 * @author Doug Gschwind
 */
public class FiveOfAKind extends MatchedKind {

	public FiveOfAKind(FrenchSuitedPlayingCard.Kind kind) {
		super(kind);
	}

	@Override
	public final int getHandRank() {
		return 0;
	}
}