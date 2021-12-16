package org.douggschwind.games.cardgames.wildcardpoker;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.common.StandardDeckCardGame;
import org.douggschwind.games.common.DeckOfCards;

/**
 * This is a 5 card draw poker game where all four deuces in the deck
 * are each considered a wild card.
 * @author Doug Gschwind
 */
public abstract class WildCardGame extends StandardDeckCardGame {
	
	private Set<FrenchSuitedPlayingCard> wildCards = new HashSet<>();

	protected WildCardGame(DeckOfCards<FrenchSuitedPlayingCard> deck) {
		super(deck);
	}
	
	protected void addWildCard(FrenchSuitedPlayingCard wildCard) {
		if (wildCard != null) {
			wildCards.add(wildCard);
		}
	}

	protected final boolean isWildCard(FrenchSuitedPlayingCard card) {
		return wildCards.contains(card);
	}
	
	/**
	 * Determines the number of wild cards present in the given Collection
	 * of Cards present in a player's hand.
	 * @param playersHand Must be non-null and expected to be non-empty.
	 * @return Will be non-negative.
	 */
	protected int determineNumberOfWildCardsInPlayersHand(Collection<FrenchSuitedPlayingCard> playersHand) {
		return (int) playersHand.stream().filter(cardInHand -> isWildCard(cardInHand)).count();
	}
	
	protected List<FrenchSuitedPlayingCard> eliminateWildCards(List<FrenchSuitedPlayingCard> cards) {
		return cards.stream().filter(card -> !isWildCard(card)).collect(Collectors.toList());
	}
}