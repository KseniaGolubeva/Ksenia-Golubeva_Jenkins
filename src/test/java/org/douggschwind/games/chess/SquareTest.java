package org.douggschwind.games.chess;

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests interesting methods of the Square class
 * @author Doug Gschwind
 */
public class SquareTest {
    @Test
    public void testEqualsAndHashcode() {
        for (BoardPosition.Row row : BoardPosition.Row.values()) {
            for (BoardPosition.Column column : BoardPosition.Column.values()) {
                Square underTest = new Square(new BoardPosition(row, column));

                for (BoardPosition.Row innerRow : BoardPosition.Row.values()) {
                    for (BoardPosition.Column innerColumn : BoardPosition.Column.values()) {
                        Square comparison = new Square(new BoardPosition(innerRow, innerColumn));

                        if ((row == innerRow) && (column == innerColumn)) {
                            Assert.assertTrue(underTest.equals(comparison));
                            Assert.assertEquals(underTest.hashCode(), comparison.hashCode());
                        } else {
                            Assert.assertFalse(underTest.equals(comparison));
                        }
                    }
                }
            }
        }
    }
}
