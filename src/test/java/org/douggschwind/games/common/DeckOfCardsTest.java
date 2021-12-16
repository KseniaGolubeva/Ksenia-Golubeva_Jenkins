package org.douggschwind.games.common;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Doug Gschwind
 */
public class DeckOfCardsTest {
    @Test
    public void testDeckOfCardsLifecycle() {
        DeckOfCards<FrenchSuitedPlayingCard> underTest = new DeckOfCards<>();

        underTest.addCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ace, FrenchSuitedPlayingCard.Suit.Spades));
        underTest.addCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.King, FrenchSuitedPlayingCard.Suit.Spades));
        underTest.addCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Queen, FrenchSuitedPlayingCard.Suit.Spades));
        underTest.addCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Jack, FrenchSuitedPlayingCard.Suit.Spades));
        underTest.addCard(new FrenchSuitedPlayingCard(FrenchSuitedPlayingCard.Kind.Ten, FrenchSuitedPlayingCard.Suit.Spades));

        Assert.assertEquals(5, underTest.size());

        underTest.shuffle();
        Assert.assertFalse(underTest.haveAllCardsBeenDealt());

        FrenchSuitedPlayingCard card1 = underTest.dealCard();
        Assert.assertEquals(FrenchSuitedPlayingCard.Suit.Spades, card1.getSuit());
        Assert.assertTrue(underTest.hasCardBeenDealt(card1));
        Assert.assertFalse(underTest.haveAllCardsBeenDealt());

        FrenchSuitedPlayingCard card2 = underTest.dealCard();
        Assert.assertEquals(FrenchSuitedPlayingCard.Suit.Spades, card2.getSuit());
        Assert.assertTrue(underTest.hasCardBeenDealt(card2));
        Assert.assertFalse(underTest.haveAllCardsBeenDealt());

        FrenchSuitedPlayingCard card3 = underTest.dealCard();
        Assert.assertEquals(FrenchSuitedPlayingCard.Suit.Spades, card3.getSuit());
        Assert.assertTrue(underTest.hasCardBeenDealt(card3));
        Assert.assertFalse(underTest.haveAllCardsBeenDealt());

        FrenchSuitedPlayingCard card4 = underTest.dealCard();
        Assert.assertEquals(FrenchSuitedPlayingCard.Suit.Spades, card4.getSuit());
        Assert.assertTrue(underTest.hasCardBeenDealt(card4));
        Assert.assertFalse(underTest.haveAllCardsBeenDealt());

        FrenchSuitedPlayingCard card5 = underTest.dealCard();
        Assert.assertEquals(FrenchSuitedPlayingCard.Suit.Spades, card5.getSuit());
        Assert.assertTrue(underTest.hasCardBeenDealt(card5));
        Assert.assertTrue(underTest.haveAllCardsBeenDealt());

        try {
            underTest.dealCard();
            Assert.fail("All cards should have been dealt at this point");
        } catch (IllegalStateException e) {
        }

        underTest.shuffle();
        Assert.assertFalse(underTest.haveAllCardsBeenDealt());
        Assert.assertEquals(5, underTest.size());
    }
}
