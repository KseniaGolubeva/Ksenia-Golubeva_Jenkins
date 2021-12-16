package org.douggschwind.games.cardgames.wildcardpoker;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.common.Player;
import org.douggschwind.games.cardgames.poker.common.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests that the hand strength of different hands with Deuces (2s) being * wild is in fact what is expected.
 * @author Doug Gschwind
 */
public class DeucesWildHandStrengthTest {
	
	private DeucesWild underTest;
	private Player player;
	
	@Before
	public void initializeDeucesWild() {
		underTest = new DeucesWild();
		player = new Player();
		underTest.addPlayer(player);
	}

	@Test
	public void testDetermineHandStrengthFiveOfAKindViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FiveOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((FiveOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFiveOfAKindViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FiveOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Jack, ((FiveOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFiveOfAKindViaThreeWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FiveOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Seven, ((FiveOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFiveOfAKindViaFourWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FiveOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Eight, ((FiveOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthNaturalRoyalFlush() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
		Assert.assertEquals(RoyalFlush.class, underTest.determinePlayerHandStrength(player).getClass());
	}
	
	@Test
	public void testDetermineHandStrengthRoyalFlushViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
		Assert.assertEquals(RoyalFlush.class, underTest.determinePlayerHandStrength(player).getClass());
	}
	
	@Test
	public void testDetermineHandStrengthRoyalFlushViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
		Assert.assertEquals(RoyalFlush.class, underTest.determinePlayerHandStrength(player).getClass());
	}
	
	@Test
	public void testDetermineHandStrengthRoyalFlushViaThreeWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
		Assert.assertEquals(RoyalFlush.class, underTest.determinePlayerHandStrength(player).getClass());
	}

	@Test
	public void testDetermineHandStrengthNaturalStraightFlush() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));

		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Jack, ((StraightFlush) actualHandStrength).getHighCardKind());
	}

	@Test
	public void testDetermineHandStrengthInsideStraightFlushViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Jack, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthInsideStraightFlushViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.King, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthInsideStraightFlushViaThreeWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Queen, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthOutsideStraightFlushViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Queen, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthOutsideStraightFlushViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.King, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthOutsideStraightFlushViaThreeWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Jack, ((StraightFlush) actualHandStrength).getHighCardKind());
	}

	@Test
	public void testDetermineHandStrengthNaturalFourOfAKind() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));

		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FourOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((FourOfAKind) actualHandStrength).getKind());
	}

	@Test
	public void testDetermineHandStrengthFourOfAKindViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FourOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Nine, ((FourOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFourOfAKindViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FourOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((FourOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFourOfAKindViaThreeWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FourOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Seven, ((FourOfAKind) actualHandStrength).getKind());
	}

	@Test
	public void testDetermineHandStrengthNaturalFullHouse() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));

		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FullHouse.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Queen, ((FullHouse) actualHandStrength).getKind());
	}

	@Test
	public void testDetermineHandStrengthFullHouseViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FullHouse.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Queen, ((FullHouse) actualHandStrength).getKind());
	}

	@Test
	public void testDetermineHandStrengthNaturalFlush() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Spades));

		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Flush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Jack, ((Flush) actualHandStrength).getHighCardKind());
	}

	@Test
	public void testDetermineHandStrengthFlushViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Flush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((Flush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthFlushViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Flush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((Flush) actualHandStrength).getHighCardKind());
	}

	@Test
	public void testDetermineHandStrengthNaturalStraight() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));

		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Straight.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((Straight) actualHandStrength).getHighCardKind());
	}

	@Test
	public void testDetermineHandStrengthInsideStraightViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Straight.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((Straight) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthInsideStraightViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Straight.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((Straight) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthOutsideStraightViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Straight.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((Straight) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthOutsideStraightViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Straight.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((Straight) actualHandStrength).getHighCardKind());
	}

	@Test
	public void testDetermineHandStrengthNaturalThreeOfAKind() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));

		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(ThreeOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Seven, ((ThreeOfAKind) actualHandStrength).getKind());
	}

	@Test
	public void testDetermineHandStrengthThreeOfAKindViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(ThreeOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Seven, ((ThreeOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthThreeOfAKindViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(ThreeOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Queen, ((ThreeOfAKind) actualHandStrength).getKind());
	}

	@Test
	public void testDetermineHandStrengthNaturalPair() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));

		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Pair.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.King, ((Pair) actualHandStrength).getKind());
	}

		@Test
	public void testDetermineHandStrengthPairViaOneWildCard1() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Pair.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.King, ((Pair) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthPairViaOneWildCard2() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Pair.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((Pair) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthPairViaOneWildCard3() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Pair.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((Pair) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthPairViaOneWildCard4() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Pair.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((Pair) actualHandStrength).getKind());
	}

	@Test
	public void testDetermineHandStrengthNaturalHighCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));

		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(HighCard.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.King, ((HighCard) actualHandStrength).getHighCardKind());
	}
}