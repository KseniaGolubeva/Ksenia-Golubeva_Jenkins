package org.douggschwind.games.cardgames.wildcardpoker;

import java.util.List;
import java.util.Map;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;

/**
 * Creates an appropriate WildCardHand instance to most easily
 * determine the best possible player hand.
 * @author Doug Gschwind
 */
public class WildCardHandFactory {

	/**
	 * @param numberWildCardsInHand One of : 1, 2, 3, or 4.
	 * @param numNonWildKindOccurrencesMap A Map that houses the distinct
	 * non wild Kinds found in the player's hand and the number of occurrences
	 * per Kind in the hand.
	 * @param numDistinctNonWildSuits The number of distinct Suits
	 * represented in the hand that are not wild cards.
	 * @param sortedNonWildCardsInHand Must be non-null and non-empty, expected
	 * to be sorted in descending order by Kind.
	 * @return Will be non-null.
	 * @throws IllegalArgumentException
	 */
	public static WildCardHand create(int numberWildCardsInHand,
			                          Map<FrenchSuitedPlayingCard.Kind, Integer> numNonWildKindOccurrencesMap,
			                          int numDistinctNonWildSuits,
			                          List<FrenchSuitedPlayingCard> sortedNonWildCardsInHand) {
		switch (numberWildCardsInHand) {
			case 1:
				return new OneWildCardHand(numNonWildKindOccurrencesMap, numDistinctNonWildSuits, sortedNonWildCardsInHand);
			case 2:
				return new TwoWildCardsHand(numNonWildKindOccurrencesMap, numDistinctNonWildSuits, sortedNonWildCardsInHand);
			case 3:
				return new ThreeWildCardsHand(numNonWildKindOccurrencesMap, numDistinctNonWildSuits, sortedNonWildCardsInHand);
			case 4:
				return new FourWildCardsHand(numNonWildKindOccurrencesMap, sortedNonWildCardsInHand);
			default:
				throw new IllegalArgumentException();
		}
	}
}