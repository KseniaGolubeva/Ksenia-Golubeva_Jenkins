package org.douggschwind.games.cardgames.wildcardpoker;

import java.util.List;
import java.util.Map;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.poker.common.FourOfAKind;
import org.douggschwind.games.cardgames.poker.common.HandStrength;
import org.douggschwind.games.cardgames.poker.common.RoyalFlush;
import org.douggschwind.games.cardgames.poker.common.StraightFlush;

/**
 * An instance of this class represents that the player has a
 * hand with three wild cards within it and two natural cards.
 * @author Doug Gschwind
 */
public class ThreeWildCardsHand extends WildCardHand {

	/**
	 * @param numNonWildKindOccurrencesMap A Map that houses the distinct
	 * non wild Kinds found in the player's hand and the number of occurrences
	 * per Kind in the hand.
	 * @param numDistinctNonWildSuits One of : 1 or 2.
	 * @param sortedNonWildCardsInHand Must be non-null.
	 */
	public ThreeWildCardsHand(Map<FrenchSuitedPlayingCard.Kind, Integer> numNonWildKindOccurrencesMap,
			                  int numDistinctNonWildSuits,
			                  List<FrenchSuitedPlayingCard> sortedNonWildCardsInHand) {
		super(numNonWildKindOccurrencesMap, numDistinctNonWildSuits, sortedNonWildCardsInHand);
	}
	
	@Override
	protected final HandStrength determineBestPossibleHand() {
		if (getNumDistinctNonWildKinds() == 1) {
			// Here the player has a natural pair. With three wild
			// cards that yields Five of a Kind.
			return createFiveOfAKind(getSortedNonWildCardsInHand().iterator().next().getKind());
		}
		
		// The player does not have a natural pair. They do however at worst
		// have four of a kind, but could instead have a Straight Flush or a
		// Royal Flush.
		FrenchSuitedPlayingCard highCard = getNonWildHighCard();
		
		if (isSingleSuited()) {
			TypeOfStraightThatCanBeFormed typeOfStraightThatCanBeFormed = determineTypeOfStraightThatCanBeFormed();
			if (typeOfStraightThatCanBeFormed.isAceHighStraight()) {
				return new RoyalFlush();
			} else if (typeOfStraightThatCanBeFormed.isAceLowStraight()) {
				return new StraightFlush(FrenchSuitedPlayingCard.Kind.Five);
			} else if (typeOfStraightThatCanBeFormed.isStraight()) {
				return new StraightFlush(typeOfStraightThatCanBeFormed.getHighCardKind());
			}
		}
		
		// The two non wild cards are NOT in the same suit, or are
		// far enough apart from each other that the three wild cards
		// cannot be used to form a Straight Flush.
		return new FourOfAKind(highCard.getKind());
	}
}