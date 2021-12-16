package org.douggschwind.games.cardgames.common;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard.Kind;
import org.douggschwind.games.cardgames.poker.common.Flush;
import org.douggschwind.games.cardgames.poker.common.FourOfAKind;
import org.douggschwind.games.cardgames.poker.common.FullHouse;
import org.douggschwind.games.cardgames.poker.common.HandStrength;
import org.douggschwind.games.cardgames.poker.common.HighCard;
import org.douggschwind.games.cardgames.poker.common.Pair;
import org.douggschwind.games.cardgames.poker.common.RoyalFlush;
import org.douggschwind.games.cardgames.poker.common.Straight;
import org.douggschwind.games.cardgames.poker.common.StraightFlush;
import org.douggschwind.games.cardgames.poker.common.ThreeOfAKind;
import org.douggschwind.games.cardgames.poker.common.TwoPair;
import org.douggschwind.games.common.DeckOfCards;

/**
 * An instance of this class assumes one standard deck of 52 total cards,
 * four suits of 13 distinct cards each.
 * @author Doug Gschwind
 */
public abstract class StandardDeckCardGame {
	
	private final DeckOfCards<FrenchSuitedPlayingCard> deck;
	private final List<Player> players = new ArrayList<>();
	
	protected StandardDeckCardGame(DeckOfCards<FrenchSuitedPlayingCard> deck) {
		this.deck = deck;
	}
	
	public DeckOfCards<FrenchSuitedPlayingCard> getDeck() {
		return deck;
	}
	
	public void addPlayer(Player toAdd) {
		if (toAdd != null) {
			players.add(toAdd);
		}
	}
	
	public final List<Player> getPlayers() {
		return players;
	}
	
	public final int getNumberPlayers() {
		return getPlayers().size();
	}
	
	public void newHand() {
		getDeck().shuffle();
		for (Player player : getPlayers()) {
			player.newHand();
		}
	}
	
	protected abstract int getNumberCardsDealtToEachPlayer();
	
	// Each game is allowed to vary how cards are dealt to players.
	public void dealCardsToPlayers() {
		for (int i = 1;i <= getNumberCardsDealtToEachPlayer();i++) {
			getPlayers().forEach(player -> player.acceptDealtCard(getDeck().dealCard()));
		}
	}
	
	protected final Map<FrenchSuitedPlayingCard.Kind, Integer> determineNumKindOccurrencesInHand(List<FrenchSuitedPlayingCard> playersHand) {
		Map<FrenchSuitedPlayingCard.Kind, Integer> result = new HashMap<>();
		
		Consumer<? super FrenchSuitedPlayingCard> cardVisitor = cardInHand -> {
			Kind cardKind = cardInHand.getKind();
			result.put(cardKind, Optional.ofNullable(result.get(cardKind)).map(n -> n + 1).orElse(1));
		};
		
		playersHand.stream().forEach(cardVisitor);
		return result;
	}
	
	protected final Map<FrenchSuitedPlayingCard.Suit, Integer> determineNumSuitOccurrencesInHand(List<FrenchSuitedPlayingCard> playersHand) {
		Map<FrenchSuitedPlayingCard.Suit, Integer> result = new HashMap<>();
		
		Consumer<? super FrenchSuitedPlayingCard> cardVisitor = cardInHand -> {
			FrenchSuitedPlayingCard.Suit cardSuit = cardInHand.getSuit();
			result.put(cardSuit, Optional.ofNullable(result.get(cardSuit)).map(n -> n + 1).orElse(1));
		};
		
		playersHand.stream().forEach(cardVisitor);
		return result;
	}
	
	protected final Map<FrenchSuitedPlayingCard.Suit, Integer> determineNumSuitOccurrencesInHand(Player player) {
		return determineNumSuitOccurrencesInHand(player.getHand());
	}
	
	protected final int determineMaximumNumberMatchingKind(Map<FrenchSuitedPlayingCard.Kind, Integer> numKindOccurrences) {
		final Comparator<Integer> numKindOccurrencesComparator = (n1, n2) -> Integer.compare(n1, n2);
		Optional<Integer> comparisonResultMax = numKindOccurrences.keySet().stream().map(cardKind -> numKindOccurrences.get(cardKind)).max(numKindOccurrencesComparator);
		return comparisonResultMax.map(i -> i.intValue()).orElse(0);
	}
	
	protected final Map<Player, List<FrenchSuitedPlayingCard.Kind>> getPlayerSortedDistinctCardKindsMap(Set<Player> players) {
		Map<Player, List<FrenchSuitedPlayingCard.Kind>> result = new HashMap<>();
		Consumer<? super Player> computePlayerDistinctSortedCardKinds = player -> {
			List<Kind> playerSortedDistinctKinds = new ArrayList<>(player.getDistinctCardKinds());
			Collections.sort(playerSortedDistinctKinds);
			result.put(player, playerSortedDistinctKinds);
		};
		players.stream().forEach(computePlayerDistinctSortedCardKinds);
		return result;
	}
	
	protected final FrenchSuitedPlayingCard.Kind determineDominantMatchingKind(Map<FrenchSuitedPlayingCard.Kind, Integer> numKindOccurrences, int numDominantMatchesExpected) {
		Optional<FrenchSuitedPlayingCard.Kind> foundCardKind = numKindOccurrences.keySet().stream().filter(cardKind -> numKindOccurrences.get(cardKind) == numDominantMatchesExpected).findFirst();
		return foundCardKind.map(kind -> kind).orElse(null);
	}
	
	protected final Pair determinePlayerHandPair(Map<FrenchSuitedPlayingCard.Kind, Integer> numKindOccurrences) {
		Optional<FrenchSuitedPlayingCard.Kind> foundCardKind = numKindOccurrences.keySet().stream().filter(cardKind -> numKindOccurrences.get(cardKind) == 2).findFirst();
		return foundCardKind.map(kind -> new Pair(kind)).orElse(null);
	}
	
	private HandStrength determinePlayerHandStrengthNoMatchingKinds(Player player) {
		Map<FrenchSuitedPlayingCard.Suit, Integer> numSuitOccurrences = determineNumSuitOccurrencesInHand(player);
		// Make a copy of the player's hand so that we leave the players hand in
		// its originally dealt form.
		List<FrenchSuitedPlayingCard> playerHand = new ArrayList<>(player.getHand());
		Collections.sort(playerHand);
		FrenchSuitedPlayingCard lowCard = playerHand.get(4);
		FrenchSuitedPlayingCard highCard = playerHand.get(0);
		FrenchSuitedPlayingCard secondHighestCard = playerHand.get(1);
		int lowToHighDistance = FrenchSuitedPlayingCard.Kind.computeDistance(lowCard.getKind(), highCard.getKind());
		if (numSuitOccurrences.size() == 1) {
			// Player has a flush, straight flush, or royal flush
			if (lowToHighDistance == 4) {
				// Player has a straight flush or a royal flush
				return highCard.isAce() ? new RoyalFlush() : new StraightFlush(highCard.getKind());
			} else if (highCard.isAce()) {
				lowToHighDistance = FrenchSuitedPlayingCard.Kind.computeDistance(lowCard.getKind(), secondHighestCard.getKind());
				if ((lowToHighDistance == 3) &&
					(lowCard.getKind() == FrenchSuitedPlayingCard.Kind.Two)) {
					// Ace low straight flush
					return new StraightFlush(secondHighestCard.getKind());
				}
			}
			
			// Player has a flush
			return new Flush(highCard.getKind());
		} else {
			// Player has a high card hand or a straight
			if (lowToHighDistance == 4) {
				return new Straight(highCard.getKind());
			} else if (highCard.isAce()) {
				lowToHighDistance = FrenchSuitedPlayingCard.Kind.computeDistance(lowCard.getKind(), secondHighestCard.getKind());
				if ((lowToHighDistance == 3) &&
					(lowCard.getKind() == FrenchSuitedPlayingCard.Kind.Two)) {
					// Ace low straight
					return new Straight(secondHighestCard.getKind());
				}
			}
			return new HighCard(highCard.getKind());
		}
	}
	
	protected final HandStrength determinePlayerHandStrengthThreeDistinctKindsInHand(int maxNumberMatchingKind, Map<FrenchSuitedPlayingCard.Kind, Integer> numKindOccurrences) {
		if (maxNumberMatchingKind == 3) {
			// Player has three of a kind.
			return new ThreeOfAKind(determineDominantMatchingKind(numKindOccurrences, 3));
		} else {
			// Player has two pair. Filter out those kinds that are paired in the players hand.
			List<FrenchSuitedPlayingCard.Kind> pairedKinds = numKindOccurrences.keySet().stream().filter(cardKind -> numKindOccurrences.get(cardKind) == 2).collect(Collectors.toList());
			FrenchSuitedPlayingCard.Kind pair1 = pairedKinds.get(0);
			FrenchSuitedPlayingCard.Kind pair2 = pairedKinds.get(1);
			return (pair1.hasHigherRank(pair2)) ? new TwoPair(pair1, pair2) : new TwoPair(pair2, pair1);
		}
	}
	
	/**
	 * This method determines the strength of the players hand ignoring the possibility
	 * of any wild cards.
	 * @param player Must be non-null.
	 * @return Will be non-null.
	 */
	public HandStrength determinePlayerHandStrength(Player player) {
		Map<FrenchSuitedPlayingCard.Kind, Integer> numKindOccurrences = determineNumKindOccurrencesInHand(player.getHand());
		
		if (numKindOccurrences.size() == getNumberCardsDealtToEachPlayer()) {
			// Player has no matching kinds, but instead could have a
			// Straight, Flush, Straight Flush, Royal Flush, or simply
			// a HighCard hand.
			return determinePlayerHandStrengthNoMatchingKinds(player);
		} else if (numKindOccurrences.size() == (getNumberCardsDealtToEachPlayer() - 1)) {
			// With four distinct kind cards out of five, the player
			// simply has a Pair.
			return determinePlayerHandPair(numKindOccurrences);
		}
		
		int maxNumberMatchingKind = determineMaximumNumberMatchingKind(numKindOccurrences);
		if (numKindOccurrences.size() == 3) {
			// Player could have three of a kind or two pair.
			return determinePlayerHandStrengthThreeDistinctKindsInHand(maxNumberMatchingKind, numKindOccurrences);
		}
		
		// Player has a four of a kind or a full house.
		if (maxNumberMatchingKind == 4) {
			// Player has four of a kind
			return new FourOfAKind(determineDominantMatchingKind(numKindOccurrences, 4));
		} else {
			// Player has a full house
			return new FullHouse(determineDominantMatchingKind(numKindOccurrences, 3));
		}
	}
	
	public final Map<Player, HandStrength> determinePlayerHandsStrength() {
		Map<Player, HandStrength> result = new HashMap<>();
		
		// Since HandStrength computation is a little involved, lets
		// cache the result for future reference in this method.
		getPlayers().forEach(player -> result.put(player, determinePlayerHandStrength(player)));
		
		return result;
	}
	
	/**
	 * Determines the Player or Players that have the strongest hand.
	 * @param playerHandStrengths Must be non-null.
	 * @return The Set will be non-null and non-empty, and most often only
	 * house a single Player. However, there are times when hand rank alone
	 * cannot be used to determine the winner of a hand, such as when the
	 * two best hands are a Ten high Straight.
	 */
	protected final Set<Player> determineLeadingPlayersBasedUponHandRankAlone(Map<Player, HandStrength> playerHandStrengths) {
		// Lets make a quick first pass attempting to identify the winner
		// based upon HandRank alone.
		Set<Player> result = new HashSet<>();
		
		Consumer<? super Player> playerVisitor = currentPlayer -> {
			HandStrength playerHandStrength = playerHandStrengths.get(currentPlayer);
			if (result.isEmpty()) {
				result.add(currentPlayer);
			} else {
				// Only need to compare against the first leading player. If there are two
				// or more leading players at a given time, they all have the same hand rank.
				Player leadingPlayer = result.iterator().next();
				HandStrength leadingPlayerHandStrength = playerHandStrengths.get(leadingPlayer);
				Boolean playerBeatsLeadingPlayer = playerHandStrength.isStrongerThan(leadingPlayerHandStrength);
				boolean currentPlayerNowALeadingPlayer = false;
				if (playerBeatsLeadingPlayer != null) {
					if (playerBeatsLeadingPlayer.booleanValue()) {
						result.clear();
						currentPlayerNowALeadingPlayer = true;
					}
				} else {
					// The current Player has tied the leading Player(s)!
					currentPlayerNowALeadingPlayer = true;
				}
				
				if (currentPlayerNowALeadingPlayer) {
					result.add(currentPlayer);
				}
			}
		};
		
		playerHandStrengths.keySet().stream().forEach(playerVisitor);
		return result;
	}
	
	/**
	 * Each game must implement this as certain hands in certain games are unique,
	 * but not necessarily in all other games. e.g. In Western, a Four of a Kind
	 * hand is unique enough, the other card in the player's hand will not be used
	 * to determine the winner of a given hand. In DeucesWild, two players can have
	 * the same Four of a Kind, so the fifth card in each player's hand in that case
	 * will be used to attempt to determine which player won the hand.
	 * @param playerHandStrength Expected to be non-null.
	 * @return true if so, false otherwise.
	 */
	protected abstract boolean canPlayersHandHoldTiebreakerCards(HandStrength playerHandStrength);
	
	/**
	 * Determine the Card.Kind instances in which every player holds in their hand.
	 * @param playerSortedDistinctCardKindsMap
	 * @return
	 */
	private Set<FrenchSuitedPlayingCard.Kind> getDistinctGameCommonCardKinds(Map<Player, List<FrenchSuitedPlayingCard.Kind>> playerSortedDistinctCardKindsMap) {
		final Set<FrenchSuitedPlayingCard.Kind> result = new HashSet<>();
		
		Consumer<? super Player> playerVisitor = player -> {
			List<Kind> playerSortedDistinctCardKinds = playerSortedDistinctCardKindsMap.get(player);
			if (result.isEmpty()) {
				result.addAll(playerSortedDistinctCardKinds);
			} else {
				result.retainAll(playerSortedDistinctCardKinds);
			}
		};
		
		playerSortedDistinctCardKindsMap.keySet().forEach(playerVisitor);
		return result;
	}
	
	/**
	 * Determines the List of Card.Kind instances for each Player that exist in the Player's
	 * hand that are not cards found in common among all Players in the argument set.
	 * @param players
	 * @return
	 */
	private Map<Player, List<FrenchSuitedPlayingCard.Kind>> getCommonEliminatedSortedPlayerCardKindsMap(Set<Player> players) {
		Map<Player, List<FrenchSuitedPlayingCard.Kind>> result = getPlayerSortedDistinctCardKindsMap(players);
		Set<FrenchSuitedPlayingCard.Kind> distinctGameCommonCardKinds = getDistinctGameCommonCardKinds(result);
		players.forEach(player -> result.get(player).removeAll(distinctGameCommonCardKinds));
		return result;
	}
	
	/**
	 * Determine the winners of the hand. There will always be at least one,
	 * but in rare cases, two or more players could have equally strong hands
	 * in which case those matching hands tie.
	 * @return Will be non-null, and contain at least one Player.
	 */
	public final Set<Player> determineWinners() {
		Map<Player, HandStrength> playerHandStrengths = determinePlayerHandsStrength();
		Set<Player> leadingPlayers = determineLeadingPlayersBasedUponHandRankAlone(playerHandStrengths);
		
		// If at this point only one player remains, they are the clear winner.
		if (leadingPlayers.size() == 1) {
			return leadingPlayers;
		}
		
		Player aLeadingPLayer = playerHandStrengths.keySet().iterator().next();
		HandStrength aLeadingPlayerHandStrength = playerHandStrengths.get(aLeadingPLayer);
		if (!canPlayersHandHoldTiebreakerCards(aLeadingPlayerHandStrength)) {
			// Here, two or more players have a hand that have matching strength,
			// but comparing individual cards beyond hand strength
			// (e.g. 10 high straight flush in Spades) will not result in a
			// conclusive choice of a winner. Each of the players are then 
			// equal winners.
			return leadingPlayers;
		}
		
		// Otherwise, we have two or more players with the same hand rank (e.g. two pair)
		// that need to be evaluated further to see which one has the winning hand. The
		// only time this can happen is when more than one player has :
		// two pair, one pair, flush, or high card.
		Map<Player, List<FrenchSuitedPlayingCard.Kind>> playerSortedDistinctCardKindsMap = getCommonEliminatedSortedPlayerCardKindsMap(leadingPlayers);
		Player aLeadingPlayer = playerSortedDistinctCardKindsMap.keySet().iterator().next();
		List<FrenchSuitedPlayingCard.Kind> aLeadingPlayerUniqueDistinctCardKinds = playerSortedDistinctCardKindsMap.get(aLeadingPlayer);
		if (aLeadingPlayerUniqueDistinctCardKinds.isEmpty()) {
			// Here, the cards in the players hands that do not contribute to 
			// HandStrength still match. For example, two players each with two
			// pair (say Aces and Eights), with a Ten. They match in entirety,
			// so both Players are winners.
			return leadingPlayers;
		}
		
		// At this point, each player in playerSortedDistinctCardKindsMap has
		// the same number of elements in its List<Card.Kind>.
		Set<Player> eliminatedPlayers = new HashSet<Player>();
		for (int cardIndex = 0;cardIndex < aLeadingPlayerUniqueDistinctCardKinds.size();cardIndex++) {
			FrenchSuitedPlayingCard.Kind cardKindLeadingAtIndex = null;
			Player playerContributingLeadingCardKind = null;
			for (Player player : playerSortedDistinctCardKindsMap.keySet()) {
				if (eliminatedPlayers.contains(player)) {
					continue; // to next player
				}
				
				List<FrenchSuitedPlayingCard.Kind> uniqueDistinctPlayerCardKinds = playerSortedDistinctCardKindsMap.get(player);
				Kind playerCardKindAtIndex = uniqueDistinctPlayerCardKinds.get(cardIndex);
				if (cardKindLeadingAtIndex == null) {
					cardKindLeadingAtIndex = playerCardKindAtIndex;
					playerContributingLeadingCardKind = player;
					continue; // to next player
				}
				
				Boolean leadingKindBeatsPlayersKind = cardKindLeadingAtIndex.hasHigherRank(playerCardKindAtIndex);
				if (leadingKindBeatsPlayersKind == null) {
					// Both players had same Kind of card
					continue; // to next player
				} else if (leadingKindBeatsPlayersKind.booleanValue()) {
					eliminatedPlayers.add(player);
				} else {
					eliminatedPlayers.add(playerContributingLeadingCardKind);
					cardKindLeadingAtIndex = playerCardKindAtIndex;
					playerContributingLeadingCardKind = player;
				}
			}
		}
		
		leadingPlayers.removeAll(eliminatedPlayers);
		return leadingPlayers;
	}
}