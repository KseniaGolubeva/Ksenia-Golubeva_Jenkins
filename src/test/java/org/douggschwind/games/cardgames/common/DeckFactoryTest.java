package org.douggschwind.games.cardgames.common;

import org.douggschwind.games.common.DeckOfCards;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Doug Gschwind
 */
public class DeckFactoryTest {

	@Test
	public void testStandardDeck() {
		DeckOfCards<FrenchSuitedPlayingCard> standardDeck = DeckFactory.createStandardDeck();
		final int EXPECTED_STANDARD_DECK_SIZE = 52;
		Assert.assertEquals(EXPECTED_STANDARD_DECK_SIZE, standardDeck.size());

		for (int i = 0;i < 3;i++) {
			boolean executedSpecificCardAssertions = false;

			standardDeck.shuffle();
			Set<FrenchSuitedPlayingCard> dealtCards = new HashSet<>();
			try {
				while (true) {
					dealtCards.add(standardDeck.dealCard());
				}
			} catch (IllegalStateException ignored) {
			    for (FrenchSuitedPlayingCard.Suit suit : FrenchSuitedPlayingCard.Suit.values()) {
			    	for (FrenchSuitedPlayingCard.Kind kind : FrenchSuitedPlayingCard.Kind.values()) {
						Assert.assertTrue(dealtCards.contains(new FrenchSuitedPlayingCard(kind, suit)));
					}
				}
				executedSpecificCardAssertions = true;
			}

			Assert.assertTrue(executedSpecificCardAssertions);
			// Lets just verify the size of the deck has not changed.
			Assert.assertEquals(EXPECTED_STANDARD_DECK_SIZE, standardDeck.size());
		}
	}

	@Test
	public void testEuchreDeck() {
		DeckOfCards<FrenchSuitedPlayingCard> euchreDeck = DeckFactory.createEuchreDeck();
		final int EXPECTED_EUCHRE_DECK_SIZE = 24;
		Assert.assertEquals(EXPECTED_EUCHRE_DECK_SIZE, euchreDeck.size());

		for (int i = 0;i < 3;i++) {
			boolean executedSpecificCardAssertions = false;

			euchreDeck.shuffle();
			Set<FrenchSuitedPlayingCard> dealtCards = new HashSet<>();
			try {
				int numCardsDealt = 0;
				// We will deal all 24 cards in the deck for good measure.
				while (numCardsDealt < EXPECTED_EUCHRE_DECK_SIZE) {
					dealtCards.add(euchreDeck.dealCard());
				}
			} catch (IllegalStateException ignored) {
				for (FrenchSuitedPlayingCard.Suit suit : FrenchSuitedPlayingCard.Suit.values()) {
					Assert.assertTrue(dealtCards.contains(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, suit)));
					Assert.assertTrue(dealtCards.contains(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, suit)));
					Assert.assertTrue(dealtCards.contains(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, suit)));
					Assert.assertTrue(dealtCards.contains(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, suit)));
					Assert.assertTrue(dealtCards.contains(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, suit)));
					Assert.assertTrue(dealtCards.contains(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, suit)));
				}
				executedSpecificCardAssertions = true;
			}

			Assert.assertTrue(executedSpecificCardAssertions);
			// Lets just verify the size of the deck has not changed.
			Assert.assertEquals(EXPECTED_EUCHRE_DECK_SIZE, euchreDeck.size());
		}
	}
}