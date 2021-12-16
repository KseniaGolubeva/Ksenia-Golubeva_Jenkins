package org.douggschwind.games.cardgames.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.common.DeckFactory;
import org.douggschwind.games.cardgames.common.Player;
import org.douggschwind.games.cardgames.common.StandardDeckCardGame;
import org.douggschwind.games.cardgames.poker.common.Flush;
import org.douggschwind.games.cardgames.poker.common.HandStrength;
import org.douggschwind.games.cardgames.poker.common.HighCard;
import org.douggschwind.games.cardgames.poker.common.Pair;
import org.douggschwind.games.cardgames.poker.common.RoyalFlush;
import org.douggschwind.games.cardgames.poker.common.Straight;
import org.douggschwind.games.cardgames.poker.common.StraightFlush;
import org.douggschwind.games.cardgames.poker.common.TwoPair;

/**
 * Best five out of seven cards poker, no wild cards, and five "river" cards
 * that are shared by all players. This implementation does not concern itself
 * with either the small or big blind, but rather which player would win given
 * any card combination in their hand and in the river cards.
 * @author Doug Gschwind
 */
public class TexasHoldEm extends StandardDeckCardGame {
	
	private Set<FrenchSuitedPlayingCard> riverCards = new HashSet<>();

	public TexasHoldEm() {
		super(DeckFactory.createStandardDeck());
	}
	
	@Override
	protected final int getNumberCardsDealtToEachPlayer() {
		return 2;
	}

	@Override
	public void dealCardsToPlayers() {
		super.dealCardsToPlayers();
		
		riverCards.add(getDeck().dealCard());
		riverCards.add(getDeck().dealCard());
		riverCards.add(getDeck().dealCard());
		getDeck().dealCard(); // Burn card after flop
		riverCards.add(getDeck().dealCard());
		getDeck().dealCard(); // Burn card
		riverCards.add(getDeck().dealCard());
	}
	
	private HandStrength determinePlayerHandStrengthNoMatchingKinds(Player player) {
		Map<FrenchSuitedPlayingCard.Suit, Integer> numSuitOccurrences = determineNumSuitOccurrencesInHand(player);
		// Make a copy of the player's hand so that we leave the players hand in
		// its originally dealt form.
		List<FrenchSuitedPlayingCard> playerHand = new ArrayList<>(player.getHand());
		Collections.sort(playerHand);
		FrenchSuitedPlayingCard lowCard = playerHand.get(4);
		FrenchSuitedPlayingCard highCard = playerHand.get(0);
		FrenchSuitedPlayingCard secondHighestCard = playerHand.get(1);
		int lowToHighDistance = FrenchSuitedPlayingCard.Kind.computeDistance(lowCard.getKind(), highCard.getKind());
		if (numSuitOccurrences.size() == 1) {
			// Player has a flush, straight flush, or royal flush
			if (lowToHighDistance == 4) {
				// Player has a straight flush or a royal flush
				return highCard.isAce() ? new RoyalFlush() : new StraightFlush(highCard.getKind());
			} else if (highCard.isAce()) {
				lowToHighDistance = FrenchSuitedPlayingCard.Kind.computeDistance(lowCard.getKind(), secondHighestCard.getKind());
				if ((lowToHighDistance == 3) &&
					(lowCard.getKind() == FrenchSuitedPlayingCard.Kind.Two)) {
					// Ace low straight flush
					return new StraightFlush(secondHighestCard.getKind());
				}
			}
			
			// Player has a flush
			return new Flush(highCard.getKind());
		} else {
			// Player has a high card hand or a straight
			if (lowToHighDistance == 4) {
				return new Straight(highCard.getKind());
			} else if (highCard.isAce()) {
				lowToHighDistance = FrenchSuitedPlayingCard.Kind.computeDistance(lowCard.getKind(), secondHighestCard.getKind());
				if ((lowToHighDistance == 3) &&
					(lowCard.getKind() == FrenchSuitedPlayingCard.Kind.Two)) {
					// Ace low straight
					return new Straight(secondHighestCard.getKind());
				}
			}
			return new HighCard(highCard.getKind());
		}
	}
	
	@Override
	public HandStrength determinePlayerHandStrength(Player player) {
		List<FrenchSuitedPlayingCard> playersHand = new ArrayList<>(riverCards);
		playersHand.addAll(player.getHand());
		Map<FrenchSuitedPlayingCard.Kind, Integer> numKindOccurrences = determineNumKindOccurrencesInHand(playersHand);
		
		if (numKindOccurrences.size() == 7) {
			// Player has no matching kinds, but instead could have a
			// Straight, Flush, Straight Flush, Royal Flush, or simply
			// a HighCard hand.
			return determinePlayerHandStrengthNoMatchingKinds(player);
		} else if (numKindOccurrences.size() == 6) {
			// With six distinct kind cards out of seven, the player
			// simply has a Pair, but the remaining five cards still
			// need to be evaluated as they may contain a Straight,
			// Flush, Straight Flush, or Royal Flush which is a
			// stronger hand than simply a Pair.
			return determinePlayerHandPair(numKindOccurrences);
		} else if (numKindOccurrences.size() == 5) {
			// The player could have three of a kind or two pair.
		} else if (numKindOccurrences.size() == 4) {
			// The player could have four of a kind, a full house,
			// three of a kind, or three pair. In case the player
			// does have three pair, the best two pair of those
			// three can be used. In the case of three of a kind
			// though, the other four cards in the player's hand
			// need to be considered as they, with one of the other
			// cards, could form a Straight, Flush, Straight Flush,
			// or Royal Flush, all of which are stronger than a
			// Three of a Kind hand.
		}
		
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	protected final boolean canPlayersHandHoldTiebreakerCards(HandStrength playerHandStrength) {
		return ((playerHandStrength instanceof HighCard) ||
				(playerHandStrength instanceof Pair) ||
				(playerHandStrength instanceof TwoPair) ||
				(playerHandStrength instanceof Flush));
	}
}