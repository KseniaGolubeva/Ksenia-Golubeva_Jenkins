package org.douggschwind.games.boardgames.monopoly.policy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Identifies the lowest valued title that can be liquidated.
 * @author Doug Gschwind
 */
public class LowestValuedAssetLiquidationPolicy implements AssetLiquidationPolicy {
	
	private static final Comparator<Integer> ASCENDING_COMPARATOR = new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
			return i1.compareTo(i2);
		}
	};

	@Override
	public void sortLiquidationValuesMostLiquidatableFirst(List<Integer> liquidationValues) {
		Collections.sort(liquidationValues, ASCENDING_COMPARATOR);
	}
}
