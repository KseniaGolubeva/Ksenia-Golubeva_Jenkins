package org.douggschwind.games.cardgames.poker;

import org.douggschwind.games.cardgames.common.DeckFactory;
import org.douggschwind.games.cardgames.common.StandardDeckCardGame;
import org.douggschwind.games.cardgames.poker.common.Flush;
import org.douggschwind.games.cardgames.poker.common.HandStrength;
import org.douggschwind.games.cardgames.poker.common.HighCard;
import org.douggschwind.games.cardgames.poker.common.Pair;
import org.douggschwind.games.cardgames.poker.common.TwoPair;

/**
 * Five card poker, all five cards dealt at beginning of game,
 * no additional cards can be accepted or improved upon.
 * Also known as five card stud.
 * @author Doug Gschwind
 */
public class Western extends StandardDeckCardGame {
	
	public Western() {
		super(DeckFactory.createStandardDeck());
	}
	
	@Override
	protected final int getNumberCardsDealtToEachPlayer() {
		return 5;
	}
	
	@Override
	protected final boolean canPlayersHandHoldTiebreakerCards(HandStrength playerHandStrength) {
		return ((playerHandStrength instanceof HighCard) ||
				(playerHandStrength instanceof Pair) ||
				(playerHandStrength instanceof TwoPair) ||
				(playerHandStrength instanceof Flush));
	}
}