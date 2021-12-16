package org.douggschwind.games.boardgames.monopoly.policy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;

import org.douggschwind.games.boardgames.monopoly.Player;
import org.douggschwind.games.boardgames.monopoly.title.Title;

/**
 * This defines the Strategies/Policies that a given Player can employ to
 * determine how to go about liquidating assets when a bill is due and they
 * do not have enough cash on hand to pay it.
 * @author Doug Gschwind
 */
public interface AssetLiquidationPolicy {
	
	void sortLiquidationValuesMostLiquidatableFirst(List<Integer> liquidationValues);
	
	/**
	 * Identifies the next Title that should be considered to be liquidated by the
	 * given Player to help make a Payment.
	 * @param player Must be non-null.
	 * @return Should be non-null and a Title which is not mortgaged
	 */
	default Title identifyNextTitleToLiquidate(Player player) {
		Map<Title, Integer> titleLiquidationValuesMap = computeTitleLiquidationValuesMap(player);
		if (titleLiquidationValuesMap.isEmpty()) {
			return null;
		}
		
		List<Integer> liquidationValues = new ArrayList<>(titleLiquidationValuesMap.values());
		sortLiquidationValuesMostLiquidatableFirst(liquidationValues);
		final int liquidationValueToFind = liquidationValues.get(0);
		
		Predicate<? super Title> mostLiquidablePredicate = candidateTitle -> {
			Integer liquidationValue = titleLiquidationValuesMap.get(candidateTitle);
			return ((liquidationValue != null) && (liquidationValue.intValue() == liquidationValueToFind));
		};
		
		Optional<Title> foundTitle = titleLiquidationValuesMap.keySet().stream().filter(mostLiquidablePredicate).findFirst();
		return foundTitle.map(title -> title).orElse(null);
	}
	
	/**
	 * This is really an implementation detail method and is not intended to be
	 * exposed for client use.
	 * @param player Must be non-null.
	 * @return Will be non-null. The key for each entry is a title, and its
	 * value is the liquidation value for that title, excepting those Titles
	 * that are currently mortgaged.
	 */
	default Map<Title, Integer> computeTitleLiquidationValuesMap(Player player) {
		Map<Title, Integer> result = new HashMap<>();
		player.getOwnedProperties().stream().filter(titleDeed -> !titleDeed.isMortgaged()).forEach(titleDeed -> result.put(titleDeed, player.computeLiquidationValue(titleDeed)));
		player.getOwnedRailroads().stream().filter(railroadTitle -> !railroadTitle.isMortgaged()).forEach(railroadTitle -> result.put(railroadTitle, player.computeLiquidationValue(railroadTitle)));
		player.getOwnedUtilities().stream().filter(utilityTitle -> !utilityTitle.isMortgaged()).forEach(utilityTitle -> result.put(utilityTitle, player.computeLiquidationValue(utilityTitle)));
		return result;
	}
}