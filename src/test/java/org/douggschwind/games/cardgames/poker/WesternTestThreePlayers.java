package org.douggschwind.games.cardgames.poker;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.common.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Set;

/**
 * @author Doug Gschwind
 */
public class WesternTestThreePlayers {
	
	private Western underTest;
	private Player player1, player2, player3;

	@Before
	public void initializeWestern() {
		underTest = new Western();
		player1 = new Player();
		player2 = new Player();
		player3 = new Player();
		underTest.addPlayer(player1);
		underTest.addPlayer(player2);
		underTest.addPlayer(player3);
	}
	
	@Test
	public void testDetermineWinnersAscendingStrengthHands() {
		// Player 1 has a ten high straight
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));

		// Player 2 has a flush
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Diamonds));

		// Player 3 has a full house
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Hearts));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		
		// In this case, player three is the winner with a full house.
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(1, handWinners.size());
		Assert.assertTrue(handWinners.contains(player3));
	}
	
	@Test
	public void testDetermineWinnersDescendingStrengthHands() {
		// Player 1 has a full house
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));

		// Player 2 has a flush
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Diamonds));

		// Player 3 has a ten high straight
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Clubs));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Hearts));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		
		// In this case, player one is the winner
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(1, handWinners.size());
		Assert.assertTrue(handWinners.contains(player1));
	}

	@Test
	public void testDetermineWinnersThreeMatchingRoyalFlushHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));

		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));

		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));

		// In this case, all three hands match identically, and not one of
		// them loses to the others.
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(3, handWinners.size());
		Assert.assertTrue(handWinners.contains(player1));
		Assert.assertTrue(handWinners.contains(player2));
		Assert.assertTrue(handWinners.contains(player3));
	}

	@Test
	public void testDetermineWinnersTwoMatchingRoyalFlushHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));

		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));

		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));

		// In this case, player 1 and 2 both have a Royal Flush and they both beat player 3 that simply has an Ace
		// high flush. Player 1 and 2 are declared the winners.
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(2, handWinners.size());
		Assert.assertTrue(handWinners.contains(player1));
		Assert.assertTrue(handWinners.contains(player2));
	}

	@Test
	public void testDetermineWinnersThreeMatchingStraightFlushHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));

		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));

		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));

		// In this case, all three hands match identically, and not one of
		// them loses to the others.
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(3, handWinners.size());
		Assert.assertTrue(handWinners.contains(player1));
		Assert.assertTrue(handWinners.contains(player2));
		Assert.assertTrue(handWinners.contains(player3));
	}

	@Test
	public void testDetermineWinnersTwoMatchingStraightFlushHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));

		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));

		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));

		// In this case, player 1 and 2 both have a King high straight flush, whereas player 3 has only a Queen
		// high straight flush. Players 1 and 2 are declared the winners.
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(2, handWinners.size());
		Assert.assertTrue(handWinners.contains(player1));
		Assert.assertTrue(handWinners.contains(player2));
	}

	@Test
	public void testDetermineWinnersAllFourOfAKindHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));

		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));

		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Hearts));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));

		// In this case, player 2 wins since four Tens beats both four Nines and four Eights.
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(1, handWinners.size());
		Assert.assertTrue(handWinners.contains(player2));
	}

	@Test
	public void testDetermineWinnersAllFullHouseHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));

		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));

		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Hearts));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));

		// In this case, player 2 wins since Tens over Kings beats Nines over Threes and Eights over Jacks.
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(1, handWinners.size());
		Assert.assertTrue(handWinners.contains(player2));
	}

	@Test
	public void testDetermineWinnersThreeMatchingFlushHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Clubs));
		
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Spades));
		
		// In this case, all three hands match identically, and not one of
		// them loses to the others.
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(3, handWinners.size());
		Assert.assertTrue(handWinners.contains(player1));
		Assert.assertTrue(handWinners.contains(player2));
		Assert.assertTrue(handWinners.contains(player3));
	}
	
	@Test
	public void testDetermineWinnersThreeVeryCloseFlushHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Clubs));
		
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Spades));
		
		// In this case, player two is the winner
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(1, handWinners.size());
		Assert.assertTrue(handWinners.contains(player2));
	}
	
	@Test
	public void testDetermineWinnersThreeMatchingHighCardHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Spades));
		
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Clubs));
		
		// In this case, all three hands match identically, and not one of
		// them loses to the others.
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(3, handWinners.size());
		Assert.assertTrue(handWinners.contains(player1));
		Assert.assertTrue(handWinners.contains(player2));
		Assert.assertTrue(handWinners.contains(player3));
	}
	
	@Test
	public void testDetermineWinnersThreeVeryCloseHighCardHands() {
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		player1.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Hearts));
		
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		player2.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Spades));
		
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player3.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Clubs));
		
		// Player two is the winner
		Set<Player> handWinners = underTest.determineWinners();
		Assert.assertEquals(1, handWinners.size());
		Assert.assertTrue(handWinners.contains(player2));
	}
}