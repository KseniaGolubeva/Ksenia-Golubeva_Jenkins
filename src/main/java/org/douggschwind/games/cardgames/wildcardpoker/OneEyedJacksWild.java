package org.douggschwind.games.cardgames.wildcardpoker;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.common.DeckFactory;
import org.douggschwind.games.cardgames.common.Player;
import org.douggschwind.games.cardgames.poker.common.Flush;
import org.douggschwind.games.cardgames.poker.common.HandStrength;
import org.douggschwind.games.cardgames.poker.common.HighCard;
import org.douggschwind.games.cardgames.poker.common.Pair;
import org.douggschwind.games.cardgames.poker.common.TwoPair;

/**
 * This is a 5 card draw poker game where the Jack of Spades and the
 * Jack of Hearts, the "one eyed" Jacks are wild. The Jack of Clubs
 * and the Jack of Diamonds are not considered wild cards.
 * For the purposes of this game, the drawing part of the game is ignored
 * in favor of simply dealing with the 5 cards dealt to each player.
 * @author Doug Gschwind
 */
public class OneEyedJacksWild extends WildCardGame {
	
	private static final FrenchSuitedPlayingCard JACK_OF_SPADES = new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades);
	private static final FrenchSuitedPlayingCard JACK_OF_HEARTS = new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts);

	public OneEyedJacksWild() {
		super(DeckFactory.createStandardDeck());
		// Since Card instances are essentially ValueObjects, just create
		// new Card instances to specify wild cards, rather than trying
		// to obtain the correct Card references out of the deck.
		addWildCard(JACK_OF_SPADES);
		addWildCard(JACK_OF_HEARTS);
	}

	@Override
	protected final int getNumberCardsDealtToEachPlayer() {
		return 5;
	}
	
	@Override
	public HandStrength determinePlayerHandStrength(Player player) {
		final int numberOfWildCardsInHand = determineNumberOfWildCardsInPlayersHand(player.getHand());
		if (numberOfWildCardsInHand == 0) {
			// player has no wild cards.
			return super.determinePlayerHandStrength(player);
		}
		
		final Map<FrenchSuitedPlayingCard.Kind, Integer> numKindOccurrencesMap = determineNumKindOccurrencesInHand(player.getHand());

		// Now lets determine if we have non-wild Jacks in the Player's hand.
		Map<FrenchSuitedPlayingCard.Kind, Integer> numNonWildKindOccurrencesMap = new HashMap<>(numKindOccurrencesMap);
		int numberOfNonWildJacksInHand = 0;
		for (FrenchSuitedPlayingCard card : player.getHand()) {
			if (card.isJack() && !isWildCard(card)) {
				numberOfNonWildJacksInHand++;
			}
		}
		if (numberOfNonWildJacksInHand > 0) {
			numNonWildKindOccurrencesMap.put(FrenchSuitedPlayingCard.Kind.Jack, numberOfNonWildJacksInHand);
		} else {
			numNonWildKindOccurrencesMap.remove(FrenchSuitedPlayingCard.Kind.Jack);
		}
		
		List<FrenchSuitedPlayingCard> sortedNonWildCards = eliminateWildCards(player.getHand());
		// Sort the natural non wild cards into descending order.
		Collections.sort(sortedNonWildCards);
		Map<FrenchSuitedPlayingCard.Suit,Integer> nonWildCardNumSuitOccurrencesMap = determineNumSuitOccurrencesInHand(sortedNonWildCards);
		
		WildCardHand wildCardHand = WildCardHandFactory.create(numberOfWildCardsInHand,
				                                               numNonWildKindOccurrencesMap,
				                                               nonWildCardNumSuitOccurrencesMap.size(),
				                                               sortedNonWildCards);
		return wildCardHand.determineBestPossibleHand();
	}
	
	@Override
	protected final boolean canPlayersHandHoldTiebreakerCards(HandStrength playerHandStrength) {
		return ((playerHandStrength instanceof HighCard) ||
				(playerHandStrength instanceof Pair) ||
				(playerHandStrength instanceof TwoPair) ||
				(playerHandStrength instanceof Flush));
	}
}