package org.douggschwind.games.cardgames.common;

import java.util.Set;

/**
 * Represents a player in a card game than can be dealt an arbitrary number of
 * French Suited playing cards.
 * @author Doug Gschwind
 */
public class Player extends AbstractPlayer<FrenchSuitedPlayingCard> {
	public Set<FrenchSuitedPlayingCard.Kind> getDistinctCardKinds() {
		return FrenchSuitedPlayingCard.getDistinctCardKinds(getHand());
	}
}