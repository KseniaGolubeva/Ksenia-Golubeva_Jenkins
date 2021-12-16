package org.douggschwind.games.cardgames.poker.common;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;

/**
 * @author Doug Gschwind
 */
public class Straight extends HandStrength {
	
	private final FrenchSuitedPlayingCard.Kind highCardKind;

	public Straight(FrenchSuitedPlayingCard.Kind highCardKind) {
		super();
		this.highCardKind = highCardKind;
	}
	
	@Override
	public int getHandRank() {
		return 6;
	}
	
	public final FrenchSuitedPlayingCard.Kind getHighCardKind() {
		return highCardKind;
	}
	
	@Override
	protected Boolean isStrongerThanSameHandRank(HandStrength that) {
		return this.getHighCardKind().hasHigherRank(((Straight) that).getHighCardKind());
	}
}