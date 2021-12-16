package org.douggschwind.games.boardgames.monopoly;

/**
 * Represents the number of houses and/or hotels that have been
 * built on a given Property.
 * @author Doug Gschwind
 */
public class BuildingSummary {

	private static final int MAX_NUM_HOUSES = 4;
	private static final int MAX_NUM_HOTELS = 1;
	
	private int numberHouses;
	private int numberHotels;
	
	public int getNumberHouses() {
		return numberHouses;
	}

	public void setNumberHouses(int newValue) {
		numberHouses = newValue;
	}

	public boolean canImprove() {
		// A property can have at most one Hotel or at most four Houses.
		return numberHotels < MAX_NUM_HOTELS || numberHouses <= MAX_NUM_HOUSES;
	}
	
	public void addHouse() {
		if (numberHouses == MAX_NUM_HOUSES) {
			// Adding a House to a property that already has four Houses
			// on it results in an additional Hotel on the property and no
			// longer any Houses.
			addHotel();
			numberHouses = 0;
		} else {
			numberHouses++;
		}
	}
	
	public void removeHouse() {
		numberHouses--;
	}
	
	public int getNumberHotels() {
		return numberHotels;
	}
	
	public void addHotel() {
		numberHotels++;
	}
	
	public void removeHotel() {
		numberHotels--;
	}
	
	public void clear() {
		numberHouses = 0;
		numberHotels = 0;
	}
	
	public boolean isMoreImproved(BuildingSummary that) {
		return ((that != null) &&
				((this.getNumberHotels() > that.getNumberHotels()) ||
				 (this.getNumberHouses() > that.getNumberHouses())));
	}
	
	public int computeDifferenceInNumberOfHouses(int input) {
		return ((5 * getNumberHotels()) + getNumberHouses()) - input;
	}
}