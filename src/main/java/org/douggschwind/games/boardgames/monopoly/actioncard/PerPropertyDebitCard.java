package org.douggschwind.games.boardgames.monopoly.actioncard;

import org.douggschwind.games.boardgames.monopoly.Monopoly;
import org.douggschwind.games.boardgames.monopoly.Player;

/**
 * When dealt this card, the player must pay some amount per House and some amount per Hotel
 * to the bank.
 * @author Doug Gschwind
 */
public class PerPropertyDebitCard extends ActionCard {
	
	private final int perHouseAmount;
	private final int perHotelAmount;

	public PerPropertyDebitCard(String cardName, int perHouseAmount, int perHotelAmount) {
		super(cardName);
		this.perHouseAmount = perHouseAmount;
		this.perHotelAmount = perHotelAmount;
	}

	public int getPerHouseAmount() {
		return perHouseAmount;
	}

	public int getPerHotelAmount() {
		return perHotelAmount;
	}
	
	@Override
	public final void takeAction(Monopoly gameInProgress, Player player, int playerDiceRollTotal) {
		gameInProgress.playerIsAssessedAmountPerBuilding(player, getPerHouseAmount(), getPerHotelAmount());
	}
}