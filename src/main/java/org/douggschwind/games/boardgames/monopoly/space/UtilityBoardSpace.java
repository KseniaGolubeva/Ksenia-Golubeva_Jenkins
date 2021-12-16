package org.douggschwind.games.boardgames.monopoly.space;

import org.douggschwind.games.boardgames.monopoly.title.Title;

/**
 * An instance of this class represents one of the two Utilities available in the game.
 * @author Doug Gschwind
 */
public class UtilityBoardSpace extends PrivateBoardSpace<Title> {

	public UtilityBoardSpace(Title title) {
		super(title);
	}
	
	@Override
	public final boolean isUtility() {
		return true;
	}
	
	public int computeRent(int numberOfUtilitiesOwned, int valueOfDiceRoll) {
		int multiplier = 0;
		if (numberOfUtilitiesOwned == 2) {
			multiplier = 10;
		} else if (numberOfUtilitiesOwned == 1) {
			multiplier = 4;
		}
		return multiplier * valueOfDiceRoll;
	}
}