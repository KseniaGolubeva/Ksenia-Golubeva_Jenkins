package org.douggschwind.games.boardgames.monopoly;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.douggschwind.games.boardgames.monopoly.actioncard.ActionCard;
import org.douggschwind.games.boardgames.monopoly.actioncard.DeckFactory;
import org.douggschwind.games.boardgames.monopoly.space.BoardSpace;
import org.douggschwind.games.common.DeckOfCards;

/**
 * This class houses the Collection of BoardSpace instances and their correct order as well
 * as each of the Player's position within the board, and the Chance and Community Chest
 * decks of cards too.
 * @author Doug Gschwind
 */
public class GameBoard {
	
	private static final List<BoardSpace> boardSpaces;
	private static final Map<BoardSpace, Integer> boardSpacePositionMap = new HashMap<>();
	private static final Map<Integer, BoardSpace> positionBoardSpaceMap = new HashMap<>();
	private static final DeckOfCards<ActionCard> chanceDeck;
	private static final DeckOfCards<ActionCard> communityChestDeck;
	
	static {
		boardSpaces = GameBoardFactory.createGameBoard();
		int position = 0;
		for (BoardSpace boardSpace : boardSpaces) {
			boardSpacePositionMap.put(boardSpace, position);
			positionBoardSpaceMap.put(position++, boardSpace);
		}
		
		chanceDeck = DeckFactory.createChanceDeck();
		communityChestDeck = DeckFactory.createCommunityChestDeck();
	}
	
	private Map<Player, BoardSpace> playerBoardSpaceMap = new HashMap<>();
	
	public GameBoard() {
		reset();
	}
	
	private void setPlayerStartingPosition(Player player) {
		// Each Player starts at Go!
		setPlayerBoardSpace(player, getGoBoardSpace());
	}

	void addPlayer(Player player) {
		setPlayerStartingPosition(player);
	}
	
	List<BoardSpace> getBoardSpaces() {
		return boardSpaces;
	}
	
	BoardSpace getGoBoardSpace() {
		return boardSpaces.get(GameBoardFactory.GO_SPACE_INDEX);
	}
	
	BoardSpace getIllinoisAveBoardSpace() {
		return boardSpaces.get(GameBoardFactory.ILLINOIS_AVENUE_SPACE_INDEX);
	}
	
	BoardSpace getStCharlesPlaceBoardSpace() {
		return boardSpaces.get(GameBoardFactory.ST_CHARLES_PLACE_SPACE_INDEX);
	}
	
	private int computeBoardPositionOfNearestUtility(int playerBoardPosition) {
		return (playerBoardPosition < GameBoardFactory.FREE_PARKING_SPACE_INDEX) ? GameBoardFactory.ELECTRIC_COMPANY_SPACE_INDEX : GameBoardFactory.WATER_WORKS_SPACE_INDEX;
	}
	
	BoardSpace getNearestUtility(Player player) {
		return positionBoardSpaceMap.get(computeBoardPositionOfNearestUtility(getPlayerBoardPosition(player)));
	}
	
	private int computeBoardPositionOfNearestRailroad(int playerBoardPosition) {
		if (playerBoardPosition < GameBoardFactory.JAIL_SPACE_INDEX) {
			return GameBoardFactory.READING_RAILROAD_SPACE_INDEX;
		} else if (playerBoardPosition < GameBoardFactory.FREE_PARKING_SPACE_INDEX) {
			return GameBoardFactory.PENNSYLVANIA_RAILROAD_SPACE_INDEX;
		} else if (playerBoardPosition < GameBoardFactory.GO_DIRECTLY_TO_JAIL_SPACE_INDEX) {
			return GameBoardFactory.B_O_RAILROAD_SPACE_INDEX;
		} else {
			return GameBoardFactory.SHORT_LINE_RAILROAD_SPACE_INDEX;
		}
	}
	
	BoardSpace getNearestRailroad(Player player) {
		return positionBoardSpaceMap.get(computeBoardPositionOfNearestRailroad(getPlayerBoardPosition(player)));
	}
	
	BoardSpace goBackThreeSpaces(Player player) {
		BoardSpace currentPlayerBoardSpace = getPlayerBoardSpace(player);
		int currentPlayerBoardPosition = boardSpacePositionMap.get(currentPlayerBoardSpace);
		int newPlayerBoardPosition = currentPlayerBoardPosition - 3;
		if (newPlayerBoardPosition < 0) {
			newPlayerBoardPosition = GameBoardFactory.NUM_BOARD_SPACES_TOTAL + newPlayerBoardPosition;
		}
		return positionBoardSpaceMap.get(newPlayerBoardPosition);
	}
	
	BoardSpace getReadingRailroadBoardSpace() {
		return boardSpaces.get(GameBoardFactory.READING_RAILROAD_SPACE_INDEX);
	}
	
	BoardSpace getBoardwalkBoardSpace() {
		return boardSpaces.get(GameBoardFactory.BOARDWALK_SPACE_INDEX);
	}
	
	BoardSpace findBoardSpaceWherePlayerHasLanded(Player player, DiceRollResult diceRollResult) {
		BoardSpace currentPlayerBoardSpace = getPlayerBoardSpace(player);
		int currentPlayerPosition = boardSpacePositionMap.get(currentPlayerBoardSpace);
		int newPlayerPosition = currentPlayerPosition + diceRollResult.getDiceRollTotal();
		
		if (newPlayerPosition >= GameBoardFactory.NUM_BOARD_SPACES_TOTAL) {
			// Player passed Go!
			newPlayerPosition = (newPlayerPosition % GameBoardFactory.NUM_BOARD_SPACES_TOTAL);
		}
		
		return positionBoardSpaceMap.get(newPlayerPosition);
	}
	
	boolean didPlayerLandOnOrPassGo(BoardSpace startingBoardSpace, BoardSpace endingBoardSpace) {
		int startingPosition = boardSpacePositionMap.get(startingBoardSpace);
		int endingPosition = boardSpacePositionMap.get(endingBoardSpace);
		return (endingPosition < startingPosition);
	}
	
	/**
	 * Obtains the Player's current position on the board.
	 * @param player
	 * @return
	 */
	BoardSpace getPlayerBoardSpace(Player player) {
		return playerBoardSpaceMap.get(player);
	}
	
	private int getPlayerBoardPosition(Player player) {
		BoardSpace currentPlayerBoardSpace = getPlayerBoardSpace(player);
		return boardSpacePositionMap.get(currentPlayerBoardSpace);
	}
	
	/**
	 * Sets the Player's position on the board.
	 * @param player
	 * @param boardSpace
	 */
	void setPlayerBoardSpace(Player player, BoardSpace boardSpace) {
		playerBoardSpaceMap.put(player, boardSpace);
	}
	
	void sendPlayerToJail(Player player) {
		setPlayerBoardSpace(player, boardSpaces.get(GameBoardFactory.JAIL_SPACE_INDEX));
	}
	
	ActionCard dealChanceCard() {
		ActionCard result = null;
		try {
			result = chanceDeck.dealCard();
		} catch (IllegalStateException ignored) {
			chanceDeck.shuffle();
			result = chanceDeck.dealCard();
		}
		return result;
	}
	
	ActionCard dealCommunityChestCard() {
		ActionCard result = null;
		try {
			result = communityChestDeck.dealCard();
		} catch (IllegalStateException ignored) {
			communityChestDeck.shuffle();
			result = communityChestDeck.dealCard();
		}
		return result;
	}
	
	void reset() {
		boardSpaces.forEach(boardSpace -> boardSpace.resetOwnership());
		DeedRecorder.clear();
		chanceDeck.shuffle();
		communityChestDeck.shuffle();
	}
}