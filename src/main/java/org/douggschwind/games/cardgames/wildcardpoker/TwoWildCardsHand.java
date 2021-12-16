package org.douggschwind.games.cardgames.wildcardpoker;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.poker.common.Flush;
import org.douggschwind.games.cardgames.poker.common.HandStrength;
import org.douggschwind.games.cardgames.poker.common.RoyalFlush;
import org.douggschwind.games.cardgames.poker.common.Straight;
import org.douggschwind.games.cardgames.poker.common.StraightFlush;
import org.douggschwind.games.cardgames.poker.common.ThreeOfAKind;

/**
 * An instance of this class represents that the player has a
 * hand with two wild cards within it and three natural cards.
 * @author Doug Gschwind
 */
public class TwoWildCardsHand extends WildCardHand {

	/**
	 * @param numNonWildKindOccurrencesMap A Map that houses the distinct
	 * non wild Kinds found in the player's hand and the number of occurrences
	 * per Kind in the hand.
	 * @param numDistinctNonWildSuits One of : 1, 2, or 3.
	 * @param sortedNonWildCardsInHand Must be non-null.
	 */
	public TwoWildCardsHand(Map<FrenchSuitedPlayingCard.Kind, Integer> numNonWildKindOccurrencesMap,
			                int numDistinctNonWildSuits,
			                List<FrenchSuitedPlayingCard> sortedNonWildCardsInHand) {
		super(numNonWildKindOccurrencesMap, numDistinctNonWildSuits, sortedNonWildCardsInHand);
	}
	
	@Override
	protected final HandStrength determineBestPossibleHand() {
		if (getNumDistinctNonWildKinds() == 1) {
			// Here the player has a natural three of a kind. With two wild
			// cards that yields Five of a Kind.
			return createFiveOfAKind(getSortedNonWildCardsInHand().iterator().next().getKind());
		}
		
		if (getNumDistinctNonWildKinds() == 2) {
			// The player has a natural pair with another non-wild non matching Kind.
			// They thus have four of a kind.
			Optional<FrenchSuitedPlayingCard.Kind> naturalPairKind = getNumNonWildKindOccurrencesMap().keySet().stream().filter(cardKind -> getNumNonWildKindOccurrencesMap().get(cardKind) == 2).findFirst();
			return naturalPairKind.map(kind -> createFourOfAKind(kind)).orElse(null);
		} else {
			// The player has three distinct natural kinds. However, if those are in
			// a single suit, the player has at least a Flush, but may instead have
			// a Straight Flush or a Royal Flush.
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
				
				// Player didn't have a Straight or Royal Flush, so the next
				// best hand for them here is a Flush.
				return new Flush(FrenchSuitedPlayingCard.Kind.Ace);
			} else {
				// Player is at least two suited and thus can have at best a
				// Straight and at worst Three of a Kind.
				TypeOfStraightThatCanBeFormed typeOfStraightThatCanBeFormed = determineTypeOfStraightThatCanBeFormed();
				if (typeOfStraightThatCanBeFormed.isAceHighStraight()) {
					return new Straight(FrenchSuitedPlayingCard.Kind.Ace);
				} else if (typeOfStraightThatCanBeFormed.isAceLowStraight()) {
					return new Straight(FrenchSuitedPlayingCard.Kind.Five);
				} else if (typeOfStraightThatCanBeFormed.isStraight()) {
					return new Straight(typeOfStraightThatCanBeFormed.getHighCardKind());
				}
				
				return new ThreeOfAKind(highCard.getKind());
			}
		}
	}
}