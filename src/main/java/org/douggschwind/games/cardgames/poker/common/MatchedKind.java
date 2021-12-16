package org.douggschwind.games.cardgames.poker.common;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;

/**
 * @author Doug Gschwind
 */
public abstract class MatchedKind extends HandStrength {
	
	private final FrenchSuitedPlayingCard.Kind kind;

	protected MatchedKind(FrenchSuitedPlayingCard.Kind kind) {
		super();
		this.kind = kind;
	}
	
	public FrenchSuitedPlayingCard.Kind getKind() {
		return kind;
	}
	
	@Override
	protected Boolean isStrongerThanSameHandRank(HandStrength that) {
		return this.getKind().hasHigherRank(((MatchedKind) that).getKind());
	}
}