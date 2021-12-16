package org.douggschwind.games.boardgames.monopoly.space;

import org.douggschwind.games.boardgames.monopoly.title.Title;

/**
 * An instance of this class represents one of the four Railroads available in the game.
 * @author Doug Gschwind
 */
public class RailroadBoardSpace extends PrivateBoardSpace<Title> {

	public RailroadBoardSpace(Title title) {
		super(title);
	}
	
	@Override
	public final boolean isRailroad() {
		return true;
	}
	
	public int computeRent(int numberOfRailroadsOwned) {
		switch (numberOfRailroadsOwned) {
			case 4:
				return 200;
			case 3:
				return 100;
			case 2:
				return 50;
			case 1:
				return 25;
			case 0:
			default:
				return 0;
		}
	}
}