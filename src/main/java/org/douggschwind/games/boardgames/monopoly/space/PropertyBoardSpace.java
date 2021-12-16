package org.douggschwind.games.boardgames.monopoly.space;

import org.douggschwind.games.boardgames.monopoly.Player;
import org.douggschwind.games.boardgames.monopoly.title.TitleDeed;

/**
 * An instance of this class is a property that can be owned, upon which
 * houses and hotels may be built, and rent may be charged.
 * @author Doug Gschwind
 */
public class PropertyBoardSpace extends PrivateBoardSpace<TitleDeed> {

	public PropertyBoardSpace(TitleDeed titleDeed) {
		super(titleDeed);
	}
	
	@Override
	public final boolean isProperty() {
		return true;
	}
	
	public int getUnmonopolizedRentCost() {
		return getTitle().getUnmonopolizedRentCost();
	}

	public int getMonopolizedRentCost() {
		return getTitle().getMonopolizedRentCost();
	}

	public int getOneHouseRentCost() {
		return getTitle().getOneHouseRentCost();
	}

	public int getTwoHouseRentCost() {
		return getTitle().getTwoHouseRentCost();
	}

	public int getThreeHouseRentCost() {
		return getTitle().getThreeHouseRentCost();
	}

	public int getFourHouseRentCost() {
		return getTitle().getFourHouseRentCost();
	}

	public int getPerHotelRentCost() {
		return getTitle().getPerHotelRentCost();
	}

	public int computeRent() {
		return getTitle().computeRent();
	}
}