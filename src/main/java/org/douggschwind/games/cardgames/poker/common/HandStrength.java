package org.douggschwind.games.cardgames.poker.common;

/**
 * The strength of a hand is FullHouse, Two Pair, etc. Which each type of
 * strength, certain information is known such as the Kind of each pair
 * in a two pair hand. What is missing from HandStrength though, are the
 * other cards in the player's hand that may be used as a tiebreaker in
 * the case of certain types of HandStrength, for the following types
 * of hands : TwoPair, Pair, HighCard, Flush.
 * @author Doug Gschwind
 */
public abstract class HandStrength {

	protected HandStrength() {
	}
	
	public abstract int getHandRank();
	
	/**
	 * This method must be implemented to check that when two hands
	 * have the same HandRank (e.g. ThreeOfAKind), if the winner
	 * between the two of them can be determined at that time.
	 * @param that Must be non-null.
	 * @return true of false if a clear winner between the two
	 * can be determined, null if we still do not have enough
	 * information to declare a winner between the two hands.
	 */
	protected abstract Boolean isStrongerThanSameHandRank(HandStrength that);
	
	/**
	 * Determines if this hand beats that hand in terms of HandStrength
	 * alone. In the case where two hands have the same rank, return null
	 * as this method does not have enough information to answer the
	 * question.
	 * @param that Must be non-null.
	 * @return true or false if known, null in the case that
	 * two hands have the same rank.
	 */
	public Boolean isStrongerThan(HandStrength that) {
		int handRankDifference = this.getHandRank() - that.getHandRank();
		
		if (handRankDifference != 0) {
			return (handRankDifference < 0);
		}
		
		// Matching ranks between the two hands.
		return isStrongerThanSameHandRank(that);
	}
}