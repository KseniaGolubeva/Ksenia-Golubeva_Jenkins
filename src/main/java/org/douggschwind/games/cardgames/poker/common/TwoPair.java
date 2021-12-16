package org.douggschwind.games.cardgames.poker.common;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;

/**
 * @author Doug Gschwind
 */
public class TwoPair extends MatchedKind {
	
	private final FrenchSuitedPlayingCard.Kind lowerValuedKind;

	public TwoPair(FrenchSuitedPlayingCard.Kind higherValuedKind, FrenchSuitedPlayingCard.Kind lowerValuedKind) {
		super(higherValuedKind);
		this.lowerValuedKind = lowerValuedKind;
	}
	
	@Override
	public final int getHandRank() {
		return 8;
	}
	
	public FrenchSuitedPlayingCard.Kind getHigherValuedKind() {
		return getKind();
	}
	
	public FrenchSuitedPlayingCard.Kind getLowerValuedKind() {
		return lowerValuedKind;
	}

	@Override
	protected final Boolean isStrongerThanSameHandRank(HandStrength that) {
		Boolean highPairResult = this.getHigherValuedKind().hasHigherRank(((TwoPair) that).getHigherValuedKind());
		if (highPairResult != null) {
			return highPairResult.booleanValue();
		}
		
		return this.getLowerValuedKind().hasHigherRank(((TwoPair) that).getLowerValuedKind());
	}
}