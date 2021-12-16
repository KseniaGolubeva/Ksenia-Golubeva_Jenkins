package org.douggschwind.games.boardgames.monopoly.policy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Identifies the highest valued title that can be liquidated.
 * @author Doug Gschwind
 */
public class HighestValuedAssetLiquidationPolicy implements AssetLiquidationPolicy {
	
	private static final Comparator<Integer> DESCENDING_COMPARATOR = new Comparator<Integer>() {
		@Override
		public int compare(Integer i1, Integer i2) {
			return i2.compareTo(i1);
		}
	};
	
	@Override
	public void sortLiquidationValuesMostLiquidatableFirst(List<Integer> liquidationValues) {
		Collections.sort(liquidationValues, DESCENDING_COMPARATOR);
	}
}