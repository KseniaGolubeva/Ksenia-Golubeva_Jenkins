package org.douggschwind.games.cardgames.wildcardpoker;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.common.Player;
import org.douggschwind.games.cardgames.poker.common.FiveOfAKind;
import org.douggschwind.games.cardgames.poker.common.Flush;
import org.douggschwind.games.cardgames.poker.common.FourOfAKind;
import org.douggschwind.games.cardgames.poker.common.FullHouse;
import org.douggschwind.games.cardgames.poker.common.HandStrength;
import org.douggschwind.games.cardgames.poker.common.Pair;
import org.douggschwind.games.cardgames.poker.common.RoyalFlush;
import org.douggschwind.games.cardgames.poker.common.Straight;
import org.douggschwind.games.cardgames.poker.common.StraightFlush;
import org.douggschwind.games.cardgames.poker.common.ThreeOfAKind;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests that the hand strength of different hands with one eyed Jacks as being
 * wild is in fact what is expected.
 * @author Doug Gschwind
 */
public class OneEyedJacksHandStrengthTest {
	
	private OneEyedJacksWild underTest;
	private Player player;
	
	@Before
	public void initializeDeucesWild() {
		underTest = new OneEyedJacksWild();
		player = new Player();
		underTest.addPlayer(player);
	}
	
	@Test
	public void testDetermineHandStrengthFiveOfAKindViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FiveOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((FiveOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFiveOfAKindViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Hearts));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FiveOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Queen, ((FiveOfAKind) actualHandStrength).getKind());
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
	public void testDetermineHandStrengthRoyalFlushViaOneWildCard1() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		Assert.assertEquals(RoyalFlush.class, underTest.determinePlayerHandStrength(player).getClass());
	}
	
	@Test
	public void testDetermineHandStrengthRoyalFlushViaOneWildCard2() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Diamonds));
		Assert.assertEquals(RoyalFlush.class, underTest.determinePlayerHandStrength(player).getClass());
	}
	
	@Test
	public void testDetermineHandStrengthRoyalFlushViaTwoWildCards1() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));
		Assert.assertEquals(RoyalFlush.class, underTest.determinePlayerHandStrength(player).getClass());
	}
	
	@Test
	public void testDetermineHandStrengthRoyalFlushViaTwoWildCards2() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		Assert.assertEquals(RoyalFlush.class, underTest.determinePlayerHandStrength(player).getClass());
	}
	
	@Test
	public void testDetermineHandStrengthRoyalFlushViaTwoWildCards3() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));
		Assert.assertEquals(RoyalFlush.class, underTest.determinePlayerHandStrength(player).getClass());
	}
	
	@Test
	public void testDetermineHandStrengthInsideStraightFlushViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Jack, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthInsideStraightFlushViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Clubs));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.King, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthOutsideStraightFlushViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Queen, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthOutsideStraightFlushViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.King, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthAceLowStraightFlushViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Clubs));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Five, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthAceLowStraightFlushViaTwoWildCards() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(StraightFlush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Five, ((StraightFlush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthFourOfAKindViaOneWildCard1() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FourOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Nine, ((FourOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFourOfAKindViaOneWildCard2() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Diamonds));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FourOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Nine, ((FourOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFourOfAKindViaTwoWildCards1() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FourOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((FourOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFourOfAKindViaTwoWildCards2() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FourOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((FourOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFullHouseViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Nine, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(FullHouse.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Queen, ((FullHouse) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthFlushViaOneWildCard1() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Flush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((Flush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthFlushViaOneWildCard2() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Flush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((Flush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthFlushViaTwoWildCards1() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Eight, FrenchSuitedPlayingCard.Suit.Clubs));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Flush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((Flush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthFlushViaTwoWildCards2() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Clubs));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Flush.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((Flush) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthInsideStraightViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
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
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Straight.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((Straight) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthOutsideStraightViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
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
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Straight.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ten, ((Straight) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthAceLowStraightViaOneWildCard1() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Five, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Straight.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Five, ((Straight) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthAceLowStraightViaOneWildCard2() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Clubs));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Two, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Straight.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Five, ((Straight) actualHandStrength).getHighCardKind());
	}
	
	@Test
	public void testDetermineHandStrengthThreeOfAKindViaOneWildCard() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
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
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(ThreeOfAKind.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Queen, ((ThreeOfAKind) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthPairViaOneWildCard1() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Seven, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
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
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Hearts));
		
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
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Pair.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((Pair) actualHandStrength).getKind());
	}
	
	@Test
	public void testDetermineHandStrengthPairViaOneWildCard4() {
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Four, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Six, FrenchSuitedPlayingCard.Suit.Hearts));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Three, FrenchSuitedPlayingCard.Suit.Spades));
		player.acceptDealtCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Diamonds));
		
		HandStrength actualHandStrength = underTest.determinePlayerHandStrength(player);
		Assert.assertEquals(Pair.class, actualHandStrength.getClass());
		Assert.assertEquals(FrenchSuitedPlayingCard.Kind.Ace, ((Pair) actualHandStrength).getKind());
	}
}