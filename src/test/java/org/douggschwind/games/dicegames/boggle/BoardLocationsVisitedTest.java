package org.douggschwind.games.dicegames.boggle;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Doug Gschwind
 */
public class BoardLocationsVisitedTest {
    @Test
    public void testClone() {
        BoardLocationsVisited subject = new BoardLocationsVisited(4);
        // Lets just mark the corners as being visited.
        subject.markVisited(0, 0);
        subject.markVisited(0, 3);
        subject.markVisited(3, 0);
        subject.markVisited(3, 3);

        Assert.assertTrue(subject.hasBeenVisited(0, 0));
        Assert.assertFalse(subject.hasBeenVisited(0, 1));
        Assert.assertFalse(subject.hasBeenVisited(0, 2));
        Assert.assertTrue(subject.hasBeenVisited(0, 3));

        Assert.assertFalse(subject.hasBeenVisited(1, 0));
        Assert.assertFalse(subject.hasBeenVisited(1, 1));
        Assert.assertFalse(subject.hasBeenVisited(1, 2));
        Assert.assertFalse(subject.hasBeenVisited(1, 3));

        Assert.assertFalse(subject.hasBeenVisited(2, 0));
        Assert.assertFalse(subject.hasBeenVisited(2, 1));
        Assert.assertFalse(subject.hasBeenVisited(2, 2));
        Assert.assertFalse(subject.hasBeenVisited(2, 3));

        Assert.assertTrue(subject.hasBeenVisited(3, 0));
        Assert.assertFalse(subject.hasBeenVisited(3, 1));
        Assert.assertFalse(subject.hasBeenVisited(3, 2));
        Assert.assertTrue(subject.hasBeenVisited(3, 3));

        BoardLocationsVisited clone = subject.clone();

        Assert.assertTrue(clone.hasBeenVisited(0, 0));
        Assert.assertFalse(clone.hasBeenVisited(0, 1));
        Assert.assertFalse(clone.hasBeenVisited(0, 2));
        Assert.assertTrue(clone.hasBeenVisited(0, 3));

        Assert.assertFalse(clone.hasBeenVisited(1, 0));
        Assert.assertFalse(clone.hasBeenVisited(1, 1));
        Assert.assertFalse(clone.hasBeenVisited(1, 2));
        Assert.assertFalse(clone.hasBeenVisited(1, 3));

        Assert.assertFalse(clone.hasBeenVisited(2, 0));
        Assert.assertFalse(clone.hasBeenVisited(2, 1));
        Assert.assertFalse(clone.hasBeenVisited(2, 2));
        Assert.assertFalse(clone.hasBeenVisited(2, 3));

        Assert.assertTrue(clone.hasBeenVisited(3, 0));
        Assert.assertFalse(clone.hasBeenVisited(3, 1));
        Assert.assertFalse(clone.hasBeenVisited(3, 2));
        Assert.assertTrue(clone.hasBeenVisited(3, 3));
    }
}
