package org.douggschwind.games.cardgames.wildcardpoker;

import java.util.List;
import java.util.Map;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.poker.common.HandStrength;

/**
 * An instance of this class represents that the player has a
 * hand with four wild cards within it and one natural card.
 * @author Doug Gschwind
 */
public class FourWildCardsHand extends WildCardHand {

	/**
	 * @param numNonWildKindOccurrencesMap A Map that houses the distinct
	 * non wild Kinds found in the player's hand and the number of occurrences
	 * per Kind in the hand.
	 * @param sortedNonWildCardsInHand Must be non-null.
	 */
	public FourWildCardsHand(Map<FrenchSuitedPlayingCard.Kind, Integer> numNonWildKindOccurrencesMap, List<FrenchSuitedPlayingCard> sortedNonWildCardsInHand) {
		super(numNonWildKindOccurrencesMap, 1, sortedNonWildCardsInHand);
	}
	
	private FrenchSuitedPlayingCard getNonWildCardInHand() {
		return getSortedNonWildCardsInHand().iterator().next();
	}
	
	@Override
	protected final HandStrength determineBestPossibleHand() {
		return createFiveOfAKind(getNonWildCardInHand().getKind());
	}
}