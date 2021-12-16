package org.douggschwind.games.boardgames.monopoly;

import java.util.HashMap;
import java.util.Map;

import org.douggschwind.games.boardgames.monopoly.title.TitleDeed;

/**
 * Houses the BuildingSummary for each TitleDeed.
 * @author Doug Gschwind
 */
public class DeedRecorder {
	
	private static final Map<TitleDeed, BuildingSummary> recordedDeeds = new HashMap<>();
	
	public static BuildingSummary getBuildingSummary(TitleDeed titleDeed) {
		return recordedDeeds.get(titleDeed);
	}
	
	public static void addDeed(TitleDeed titleDeed) {
		recordedDeeds.put(titleDeed, new BuildingSummary());
	}
	
	public static void addHouse(TitleDeed titleDeed) {
		BuildingSummary buildingSummaryForDeed = getBuildingSummary(titleDeed);
		buildingSummaryForDeed.addHouse();
	}
	
	public static void clear() {
		recordedDeeds.clear();
	}
}