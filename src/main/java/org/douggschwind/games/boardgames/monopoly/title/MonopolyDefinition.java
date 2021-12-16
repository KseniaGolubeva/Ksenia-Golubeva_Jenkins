package org.douggschwind.games.boardgames.monopoly.title;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.douggschwind.games.boardgames.monopoly.BuildingSummary;
import org.douggschwind.games.boardgames.monopoly.DeedRecorder;
import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * An instance of this class defines which Titles, when all owned by the
 * same Player, constitute a monopoly by that Player concerning those specific
 * Titles.
 * @author Doug Gschwind
 */
public class MonopolyDefinition {
	
	/**
	 * Is used to identity a specific Monopoly. e.g. The Brown identifier
	 * identifies the Monopoly that is comprised of the Mediterranean and
	 * Baltic Avenue properties.
	 */
	public enum Identifier {
		Brown,
		LightBlue,
		Purple,
		Orange,
		Red,
		Yellow,
		Green,
		Blue,
		Railroads,
		Utilities;
	}
	
	public enum Type {
		Property,
		Railroad,
		Utility;
	}
	
	private final Identifier identifier;
	private final Type type;
	
	private final List<Title> titles = new ArrayList<>();

	public MonopolyDefinition(Identifier identifier, Type type) {
		this.identifier = identifier;
		this.type = type;
	}
	
	public Identifier getIdentifier() {
		return identifier;
	}
	
	private Type getType() {
		return type;
	}
	
	public boolean isProperty() {
		return getType() == Type.Property;
	}
	
	public boolean isRailroad() {
		return getType() == Type.Railroad;
	}
	
	public boolean isUtility() {
		return getType() == Type.Utility;
	}

	public void addTitle(Title title) {
		if (title != null) {
			titles.add(title);
		}
	}
	
	/**
	 * Determines if all of the properties defined by this instance are
	 * in fact all owned by the same Player and none of those TitleDeeds
	 * are in the mortgaged state.
	 * @return true if so, false otherwise.
	 */
	public boolean hasBeenMonopolized() {
		if (titles.stream().anyMatch(title -> title.isMortgaged() || title.getOwner() == null)) {
			return false;
		}
		
		Set<Player> distinctPlayerOwners = new HashSet<>();
		titles.stream().forEach(title -> distinctPlayerOwners.add(title.getOwner()));
		return (distinctPlayerOwners.size() == 1);
	}
	
	public TitleDeed findLeastImprovedTitleDeed() {
		if (!isProperty()) {
			return null;
		}
		
		TitleDeed result = null;
		BuildingSummary leastImproved = null;
		for (Title title : titles) {
			TitleDeed titleDeed = (TitleDeed) title;
			BuildingSummary titleDeedBuildingSummary = DeedRecorder.getBuildingSummary(titleDeed);
			if ((leastImproved == null) ||
				(leastImproved.isMoreImproved(titleDeedBuildingSummary))) {
				leastImproved = titleDeedBuildingSummary;
				result = titleDeed;
			}
		}
		return result;
	}
}
