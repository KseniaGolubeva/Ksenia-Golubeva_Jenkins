package org.douggschwind.games.cardgames.common;

import org.douggschwind.games.common.DeckOfCards;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Doug Gschwind
 */
public class PlayerTest {
    @Test
    public void testPlayerEquals() {
        Player player1 = new Player();

        Assert.assertEquals(player1, player1);
        Assert.assertEquals(player1.hashCode(), player1.hashCode());
    }

    @Test
    public void testPlayerNotEquals() {
        Player player1 = new Player();
        Player player2 = new Player();

        Assert.assertNotEquals(player1, player2);
        Assert.assertNotEquals(player2, player1);
    }

    @Test
    public void testNewHand() {
        DeckOfCards<FrenchSuitedPlayingCard> standardDeck = DeckFactory.createStandardDeck();
        standardDeck.shuffle();

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

        Assert.assertTrue(player1.getHand().isEmpty());
        Assert.assertTrue(player2.getHand().isEmpty());
        Assert.assertTrue(player3.getHand().isEmpty());
        Assert.assertTrue(player4.getHand().isEmpty());

        for (int i = 0;i < 5;i++) {
            player1.acceptDealtCard(standardDeck.dealCard());
            player2.acceptDealtCard(standardDeck.dealCard());
            player3.acceptDealtCard(standardDeck.dealCard());
            player4.acceptDealtCard(standardDeck.dealCard());
        }

        Assert.assertEquals(5, player1.getHand().size());
        Assert.assertEquals(5, player2.getHand().size());
        Assert.assertEquals(5, player3.getHand().size());
        Assert.assertEquals(5, player4.getHand().size());

        player1.newHand();
        player2.newHand();
        player3.newHand();
        player4.newHand();

        Assert.assertTrue(player1.getHand().isEmpty());
        Assert.assertTrue(player2.getHand().isEmpty());
        Assert.assertTrue(player3.getHand().isEmpty());
        Assert.assertTrue(player4.getHand().isEmpty());
    }
}
