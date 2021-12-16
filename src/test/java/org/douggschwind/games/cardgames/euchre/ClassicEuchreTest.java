package org.douggschwind.games.cardgames.euchre;

import org.douggschwind.games.cardgames.common.FrenchSuitedPlayingCard;
import org.douggschwind.games.cardgames.common.Player;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Doug Gschwind
 */
public class ClassicEuchreTest {
    @Test
    public void testHand() {
        ClassicEuchre underTest = new ClassicEuchre();

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

        underTest.addPlayer(player1);
        underTest.addPlayer(player2);
        underTest.addPlayer(player3);
        underTest.addPlayer(player4);

        underTest.newHand();
        underTest.dealCardsToPlayers();
        Assert.assertNotNull(underTest.getInitialTrumpBiddingCardFromKitty());

        Assert.assertEquals(5, player1.getHand().size());
        Assert.assertEquals(5, player2.getHand().size());
        Assert.assertEquals(5, player3.getHand().size());
        Assert.assertEquals(5, player4.getHand().size());

        underTest.newHand();

        Assert.assertTrue(player1.getHand().isEmpty());
        Assert.assertTrue(player2.getHand().isEmpty());
        Assert.assertTrue(player3.getHand().isEmpty());
        Assert.assertTrue(player4.getHand().isEmpty());
    }

    @Test
    public void testPlayersAllGetDistinctCards() {
        ClassicEuchre underTest = new ClassicEuchre();

        Player player1 = new Player();
        Player player2 = new Player();
        Player player3 = new Player();
        Player player4 = new Player();

        underTest.addPlayer(player1);
        underTest.addPlayer(player2);
        underTest.addPlayer(player3);
        underTest.addPlayer(player4);

        underTest.newHand();
        underTest.dealCardsToPlayers();

        // Lets make sure that the cards in any one Player's hand are NOT
        // found in any of the other Player's hands.
        for (FrenchSuitedPlayingCard player1Card : player1.getHand()) {
            Assert.assertFalse(player2.getHand().contains(player1Card));
            Assert.assertFalse(player3.getHand().contains(player1Card));
            Assert.assertFalse(player4.getHand().contains(player1Card));
        }

        for (FrenchSuitedPlayingCard player2Card : player2.getHand()) {
            Assert.assertFalse(player1.getHand().contains(player2Card));
            Assert.assertFalse(player3.getHand().contains(player2Card));
            Assert.assertFalse(player4.getHand().contains(player2Card));
        }

        for (FrenchSuitedPlayingCard player3Card : player3.getHand()) {
            Assert.assertFalse(player1.getHand().contains(player3Card));
            Assert.assertFalse(player2.getHand().contains(player3Card));
            Assert.assertFalse(player4.getHand().contains(player3Card));
        }

        for (FrenchSuitedPlayingCard player4Card : player4.getHand()) {
            Assert.assertFalse(player1.getHand().contains(player4Card));
            Assert.assertFalse(player2.getHand().contains(player4Card));
            Assert.assertFalse(player3.getHand().contains(player4Card));
        }
    }
}
