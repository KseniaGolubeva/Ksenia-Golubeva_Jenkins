package org.douggschwind.games.cardgames.common;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard.Kind;
import org.douggschwind.games.common.DeckOfCards;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Can create a standard deck of 52 cards, or an subset deck of standard cards for use in playing the
 * game Euchre, which only uses Ace through Nine of all four suits.
 * @author Doug Gschwind
 */
public class DeckFactory {
	
	public static DeckOfCards<FrenchSuitedPlayingCard> createStandardDeck() {
		DeckOfCards<FrenchSuitedPlayingCard> result = new DeckOfCards<>();
		for (FrenchSuitedPlayingCard.Kind kind : FrenchSuitedPlayingCard.Kind.values()) {
			Arrays.stream(FrenchSuitedPlayingCard.Suit.values()).forEach(suit -> result.addCard(new FrenchSuitedPlayingCard(kind, suit)));
		}
		return result;
	}
	
	public static DeckOfCards<FrenchSuitedPlayingCard> createEuchreDeck() {
		DeckOfCards<FrenchSuitedPlayingCard> result = new DeckOfCards<>();
		
		Consumer<? super FrenchSuitedPlayingCard.Suit> addCardsFromSuit = suit -> {
			result.addCard(new FrenchSuitedPlayingCard(Kind.Ace, suit));
			result.addCard(new FrenchSuitedPlayingCard(Kind.King, suit));
			result.addCard(new FrenchSuitedPlayingCard(Kind.Queen, suit));
			result.addCard(new FrenchSuitedPlayingCard(Kind.Jack, suit));
			result.addCard(new FrenchSuitedPlayingCard(Kind.Ten, suit));
			result.addCard(new FrenchSuitedPlayingCard(Kind.Nine, suit));
		};
		
		Arrays.stream(FrenchSuitedPlayingCard.Suit.values()).forEach(addCardsFromSuit);
		
		return result;
	}
}