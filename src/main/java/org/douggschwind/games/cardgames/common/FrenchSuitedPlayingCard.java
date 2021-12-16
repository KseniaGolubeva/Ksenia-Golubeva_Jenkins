package org.douggschwind.games.cardgames.common;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.douggschwind.games.common.AbstractCard;

/**
 * An instance of the Card class represents a card from a standard deck of 52 cards, each
 * having a French suit (i.e. Spades, Clubs, Hearts, Diamonds) and a kind (e.g. Ace).
 * @author Doug Gschwind
 */
public class FrenchSuitedPlayingCard implements AbstractCard, Comparable<FrenchSuitedPlayingCard> {
	
	public enum Kind implements Comparator<Kind> {
		Ace(1, "A"),
		King(2, "K"),
		Queen(3, "Q"),
		Jack(4, "J"),
		Ten(5, "10"),
		Nine(6, "9"),
		Eight(7, "8"),
		Seven(8, "7"),
		Six(9, "6"),
		Five(10, "5"),
		Four(11, "4"),
		Three(12, "3"),
		Two(13, "2");
		
		private final int rank;
		private final String abbreviation;
		
		/**
		 * Determines the distance in terms of number of kinds that fall
		 * between the two argument kinds. e.g. The distance between a
		 * Six and a Seven is one, between a Six and Four is two, etc.
		 * @param kind1 Must be non-null.
		 * @param kind2 Must be non-null.
		 * @return Will be non-negative, but can be zero if the two
		 * arguments are in fact the same Kind.
		 */
		public static int computeDistance(Kind kind1, Kind kind2) {
			return Math.abs(kind1.getRank() - kind2.getRank());
		}
		
		private Kind(int rank, String abbreviation) {
			this.rank = rank;
			this.abbreviation = abbreviation;
		}
		
		protected int getRank() {
			return rank;
		}
		
		public String getAbbreviation() {
			return abbreviation;
		}
		
		/**
		 * Determines if this Kind instance has a higher rank that Kind instance.
		 * @param that Must be non-null.
		 * @return true or false if the question can be answered
		 * conclusively, null otherwise.
		 */
		public Boolean hasHigherRank(Kind that) {
			int rankDifference = this.rank - that.rank;
			return (rankDifference != 0) ? (rankDifference < 0) : null;
		}
		
		/**
		 * Determines if this Kind instance has a lower rank that Kind instance.
		 * @param that Must be non-null.
		 * @return true or false if the question can be answered
		 * conclusively, null otherwise.
		 */
		public Boolean hasLowerRank(Kind that) {
			int rankDifference = this.rank - that.rank;
			return (rankDifference != 0) ? (rankDifference > 0) : null;
		}
		
		public Kind getNextHigherRankingKind() {
			switch (this) {
				case Ace:
				case King:
					return Ace;
				case Queen:
					return King;
				case Jack:
					return Queen;
				case Ten:
					return Jack;
				case Nine:
					return Ten;
				case Eight:
					return Nine;
				case Seven:
					return Eight;
				case Six:
					return Seven;
				case Five:
					return Six;
				case Four:
					return Five;
				case Three:
					return Four;
				case Two:
				default:
					return Three;
			}
		}
		
		/**
		 * Sorts Kinds into descending order.
		 */
		@Override
		public int compare(FrenchSuitedPlayingCard.Kind kind1, FrenchSuitedPlayingCard.Kind kind2) {
			return kind1.getRank() - kind2.getRank();
		}
	}
	
	public enum Suit {
		Spades("s"),
		Clubs("c"),
		Hearts("h"),
		Diamonds("d");
		
		private final String abbreviation;
		
		private Suit(String abbreviation) {
			this.abbreviation = abbreviation;
		}
		
		public String getAbbreviation() {
			return abbreviation;
		}
	}
	
	private final Kind kind;
	private final Suit suit;
	
	public static Set<FrenchSuitedPlayingCard.Kind> getDistinctCardKinds(List<FrenchSuitedPlayingCard> cards) {
		Set<FrenchSuitedPlayingCard.Kind> result = new HashSet<>();
		cards.forEach(cardInHand -> result.add(cardInHand.getKind()));
		return result;
	}
	
	public FrenchSuitedPlayingCard(Kind kind, Suit suit) {
		this.kind = kind;
		this.suit = suit;
	}

	public Kind getKind() {
		return kind;
	}

	public Suit getSuit() {
		return suit;
	}
	
	@Override
	public boolean equals(Object wideThat) {
		// Use equals by state value implementation here since Card
		// is a ValueObject.
		if (this == wideThat) {
			return true;
		} else if (!this.getClass().equals(wideThat.getClass())) {
			return false;
		}
		
		FrenchSuitedPlayingCard that = (FrenchSuitedPlayingCard) wideThat;
		
		return this.getKind().equals(that.getKind()) && this.getSuit().equals(that.getSuit());
	}
	
	@Override
	public int hashCode() {
		return getKind().hashCode() + getSuit().hashCode();
	}
	
	public boolean isAce() {
		return Kind.Ace.equals(getKind());
	}
	
	public boolean isKing() {
		return Kind.King.equals(getKind());
	}
	
	public boolean isQueen() {
		return Kind.Queen.equals(getKind());
	}
	
	public boolean isJack() {
		return Kind.Jack.equals(getKind());
	}
	
	public boolean isJackOrBetter() {
		return (isAce() || isKing() || isQueen() || isJack());
	}

	@Override
	public int compareTo(FrenchSuitedPlayingCard that) {
		return this.getKind().getRank() - that.getKind().getRank();
	}
	
	@Override
	public String toString() {
		return getKind().getAbbreviation() + getSuit().getAbbreviation();
	}
}
