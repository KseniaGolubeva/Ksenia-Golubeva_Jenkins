package org.douggschwind.games.cardgames.wildcardpoker;

import java.util.Set;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.common.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * The tests here follow what is done in WesternTestTwoPlayers with the following twists :
 * 1) Five of a Kind is possible in Deuces Wild
 * 2) Two players can have the same Four of a Kind hand in terms of rank. e.g. Two players
 *    can both have four Tens by each having a pair of Tens and a pair of Twos.
 * @author Doug Gschwind
 */
public class DeucesWildTestTwoPlayers {
	
	private DeucesWild underTest;
	private Player player1, player2;
	
	@Before
	public void initializeWestern() {
		underTest = new DeucesWild();
		player1 = new Player();
		player2 = new Player();
		underTest.addPlayer(player1);
		underTest.addPlayer(player2);
	}
	
	private void assertPlayersHaveMatchingHands(Set<Player> declaredWinnersOfHand) {
		Assert.assertEquals(2, declaredWinnersOfHand.size());
		Assert.assertTrue(declaredWinnersOfHand.contains(player1));
		Assert.assertTrue(declaredWinnersOfHand.contains(player2));
	}
	
	private void assertGivenPlayerIsWinner(Set<Player> declaredWinnersOfHand, Player declaredWinnerOfHand) {
		Assert.assertEquals(1, declaredWinnersOfHand.size());
		Assert.assertTrue(declaredWinnersOfHand.contains(declaredWinnerOfHand));
	}
	
	@Test
	public void testDetermineWinnerWithFiveOfAKindWithFourWildCards() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		
		// Player two is the winner with five Jacks
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player2);
	}
	
	@Test
	public void testDetermineWinnerWithFiveOfAKindWithThreeWildCards() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		
		// Player one is the winner with five Tens
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnerWithFiveOfAKindWithTwoWildCards() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Hearts));
		
		// Player two is the winner with five Queens
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player2);
	}
	
	@Test
	public void testDetermineWinnerWithFiveOfAKindWithOneWildCard() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		
		// Player one is the winner with five Sevens
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersTwoMatchingRoyalFlushHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		
		// In this case, the two players have matching hands, and since there
		// are no other competitors, they both are declared winners.
		Set<Player> handWinners = underTest.determineWinners();
		assertPlayersHaveMatchingHands(handWinners);
	}
	
	@Test
	public void testDetermineWinnersTwoMatchingStraightFlushHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		
		// In this case, the two players have matching hands, and since there
		// are no other competitors, they both are declared winners.
		Set<Player> handWinners = underTest.determineWinners();
		assertPlayersHaveMatchingHands(handWinners);
	}
	
	@Test
	public void testDetermineWinnersTwoNotMatchingStraightFlushHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		
		// Player one is the winner with a King high straight flush
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersTwoNotMatchingButAceBasedStraightFlushHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		
		// Player one is the winner with a royal flush
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersTwoDifferentFourOfAKindHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// Player one is the winner with four 9s.
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersTwoMatchingFourOfAKindHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// In this case, the two players have matching hands, and since there
		// are no other competitors, they both are declared winners.
		Set<Player> handWinners = underTest.determineWinners();
		assertPlayersHaveMatchingHands(handWinners);
	}
	
	@Test
	public void testDetermineWinnersTwoMatchingFourOfAKindHandsWithDecidingTiebreakerCard1() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// Player one is the winner with four Nines, with a Queen.
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersTwoMatchingFourOfAKindHandsWithDecidingTiebreakerCard2() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// Player two is the winner with four Nines, with a Jack.
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player2);
	}
	
	@Test
	public void testDetermineWinnersTwoFullHouseHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// Player two is the winner with Tens over Fours.
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player2);
	}
	
	@Test
	public void testDetermineWinnersTwoMatchingFlushHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		
		// In this case, the two players have matching hands, and since there
		// are no other competitors, they both are declared winners.
		Set<Player> handWinners = underTest.determineWinners();
		assertPlayersHaveMatchingHands(handWinners);
	}
	
	@Test
	public void testDetermineWinnersTwoNotMatchingFlushHands1() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		
		// Player 1 is the winner with a Queen high flush
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersTwoNotMatchingFlushHands2() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		
		// Player 2 is the winner with the third highest card being an eight
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player2);
	}
	
	@Test
	public void testDetermineWinnersTwoNotMatchingFlushHands3() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		
		// Player 1 is the winner with the stronger least high card.
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersTwoMatchingStraightHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		
		// In this case, the two players have matching hands, and since there
		// are no other competitors, they both are declared winners.
		Set<Player> handWinners = underTest.determineWinners();
		assertPlayersHaveMatchingHands(handWinners);
	}
	
	@Test
	public void testDetermineWinnersTwoNotMatchingStraightHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Spades));
		
		// Player 1 is the winner with a Jack high straight
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersTwoNotMatchingButAceBasedStraightHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		
		// Player 2 is the winner with an Ace high straight
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player2);
	}
	
	@Test
	public void testDetermineWinnersTwoNotMatchingThreeOfAKindHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		
		// Player 2 is the winner with three Sevens
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player2);
	}
	
	@Test
	public void testDetermineWinnersTwoMatchingPairMatchingHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		
		// In this case, the two players have matching hands, and since there
		// are no other competitors, they both are declared winners.
		Set<Player> handWinners = underTest.determineWinners();
		assertPlayersHaveMatchingHands(handWinners);
	}
	
	@Test
	public void testDetermineWinnersTwoMatchingPairNotMatchingHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		
		// In this case, the two players have matching hands, but only one
		// winner since the odd card is used for the tiebreaker.
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersTwoPairNotMatchingHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Spades));
		
		// Player two is the winner
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player2);
	}
	
	@Test
	public void testDetermineWinnersMatchingPairMatchingHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// In this case, the two players have matching hands, and since there
		// are no other competitors, they both are declared winners.
		Set<Player> handWinners = underTest.determineWinners();
		assertPlayersHaveMatchingHands(handWinners);
	}
	
	@Test
	public void testDetermineWinnersMatchingPairNotMatchingHands1() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// Player one wins with a pair of Jacks, Ace high
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersMatchingPairNotMatchingHands2() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// Player two wins with a pair of Jacks, Ace, Ten, Three high
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player2);
	}
	
	@Test
	public void testDetermineWinnersNotMatchingPairHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// Player one wins with a pair of Jacks
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersMatchingHighCardHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// Player one wins with a pair of Jacks
		Set<Player> handWinners = underTest.determineWinners();
		assertPlayersHaveMatchingHands(handWinners);
	}
	
	@Test
	public void testDetermineWinnersNotMatchingHighCardHands1() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// Player two wins with King high
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player2);
	}
	
	@Test
	public void testDetermineWinnersNotMatchingHighCardHands2() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// Player one wins
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player1);
	}
	
	@Test
	public void testDetermineWinnersNotMatchingHighCardHands3() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		// Player two wins
		Set<Player> handWinners = underTest.determineWinners();
		assertGivenPlayerIsWinner(handWinners, player2);
	}
}