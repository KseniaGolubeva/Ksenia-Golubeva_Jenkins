package org.douggschwind.games.cardgames.wildcardpoker;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;

/**
 * @author Doug Gschwind
 */
public class TypeOfStraightThatCanBeFormed {
	
	public static enum StraightType {
		ACE_HIGH_STRAIGHT,
		ACE_LOW_STRAIGHT,
		STRAIGHT,
		NONE;
		
		public boolean isAceHighStraight() {
			return (this == ACE_HIGH_STRAIGHT);
		}
		
		public boolean isAceLowStraight() {
			return (this == ACE_LOW_STRAIGHT);
		}
		
		public boolean isStraight() {
			return (this == STRAIGHT);
		}
		
		public boolean isNone() {
			return (this == NONE);
		}
	}
	
	private final StraightType straightType;
	private final FrenchSuitedPlayingCard.Kind highCardKind;

	public TypeOfStraightThatCanBeFormed(StraightType straightType, FrenchSuitedPlayingCard.Kind highCardKind) {
		this.straightType = straightType;
		this.highCardKind = highCardKind;
	}
	
	public boolean isAceHighStraight() {
		return getStraightType().isAceHighStraight();
	}
	
	public boolean isAceLowStraight() {
		return getStraightType().isAceLowStraight();
	}
	
	public boolean isStraight() {
		return getStraightType().isStraight();
	}
	
	public boolean isNone() {
		return getStraightType().isNone();
	}

	public StraightType getStraightType() {
		return straightType;
	}

	public FrenchSuitedPlayingCard.Kind getHighCardKind() {
		return highCardKind;
	}
}