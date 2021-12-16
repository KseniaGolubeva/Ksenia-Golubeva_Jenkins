package org.douggschwind.games.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * A DeckOfCards contains some number of AbstractCard instances. This abstraction
 * can support games like Poker, Uno, Euchre, Monopoly, etc.
 * @author Doug Gschwind
 */
public class DeckOfCards <C extends AbstractCard> {
	
	private final List<C> deckConfiguration = new ArrayList<>();
	private final List<C> cardsRemainingInDeck = new ArrayList<>();
	private final Map<C, Boolean> dealtCards = new HashMap<>();
	private Random random;
	
	public void addCard(C toAdd) {
		if (toAdd != null) {
			deckConfiguration.add(toAdd);
		}
	}

	public int size() {
		return deckConfiguration.size();
	}
	
	public void shuffle() {
		random = new Random();
		cardsRemainingInDeck.clear();
		cardsRemainingInDeck.addAll(deckConfiguration);
		dealtCards.clear();
	}
	
	protected final boolean hasCardBeenDealt(AbstractCard card) {
		return (dealtCards.get(card) == true);
	}
	
	protected final boolean haveAllCardsBeenDealt() {
		return cardsRemainingInDeck.isEmpty();
	}
	
	public C dealCard() {
		if (haveAllCardsBeenDealt()) {
			throw new IllegalStateException("All cards have already been dealt!");
		}
		final int randomlySelectedCardIndex = random.nextInt(cardsRemainingInDeck.size());
		C result = cardsRemainingInDeck.remove(randomlySelectedCardIndex);
		dealtCards.put(result, true);
		return result;
	}
}
