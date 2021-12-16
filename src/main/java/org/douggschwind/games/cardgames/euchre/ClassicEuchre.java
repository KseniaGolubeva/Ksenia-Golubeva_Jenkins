package org.douggschwind.games.cardgames.euchre;

import java.util.ArrayList;
import java.util.List;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.common.DeckFactory;
import org.douggschwind.games.cardgames.common.Player;
import org.douggschwind.games.cardgames.common.StandardDeckCardGame;
import org.douggschwind.games.cardgames.poker.common.HandStrength;

/**
 * Classic Euchre is where there are exactly four players, each are dealt
 * five cards, and the deck used consists of a subset of a standard deck
 * of cards where the 9s and higher (10s, Jacks, etc.) are present in the
 * deck. Besides the 20 cards dealt to the players, the dealer is left with
 * four extra cards after dealing 5 to each player. The topmost of those
 * four cards is turned over to begin attempting to determine trump for
 * the given hand.
 * 
 * There are variants of Euchre that allow different numbers of players
 * such as two, three, or even six (Shoot the Moon) players. The variant
 * supported by this class is expressly for the case where there are
 * exactly four players.
 * 
 * @author Doug Gschwind
 */
public class ClassicEuchre extends StandardDeckCardGame {
	
	private List<FrenchSuitedPlayingCard> kitty = new ArrayList<>(4);

	public ClassicEuchre() {
		super(DeckFactory.createEuchreDeck());
	}

	@Override
	protected final int getNumberCardsDealtToEachPlayer() {
		return 5;
	}

	@Override
	protected final boolean canPlayersHandHoldTiebreakerCards(HandStrength playerHandStrength) {
		return false; // Hand Strength not relevant in Euchre.
	}
	
	@Override
	public void addPlayer(Player toAdd) {
		if (getNumberPlayers() == 4) {
			throw new RuntimeException("This game is already full, cannot accept any more players.");
		}
		
		super.addPlayer(toAdd);
	}

	@Override
	public void newHand() {
		super.newHand();
		kitty.clear();
	}
	
	private void dealCardsIntoKitty() {
		// Since only the top card in the kitty is of use in the playing of the
		// game, no need to request three other cards be dealt.
		kitty.add(getDeck().dealCard());
	}
	
	@Override
	public final void dealCardsToPlayers() {
		super.dealCardsToPlayers();
		// Last four cards go into kitty.
		dealCardsIntoKitty();
	}
	
	public FrenchSuitedPlayingCard getInitialTrumpBiddingCardFromKitty() {
		return kitty.get(0); // Top card in kitty.
	}
}
