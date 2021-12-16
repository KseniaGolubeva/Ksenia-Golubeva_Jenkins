package org.douggschwind.games.dicegames.boggle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Represents the abstraction that abstracts away whether we are using a 4x4 game board or a 5x5 game board.
 * @author Doug Gschwind
 */
public abstract class BoggleDice {
    public static BoggleDice for4x4Board() {
        return new Boggle4x4Dice();
    }

    public static BoggleDice for5x5Board() {
        return new Boggle5x5Dice();
    }

    /**
     * @return The size of the supported game board, where size indicates the number of rows and the same number
     * of columns on the game board.
     */
    public abstract int size();

    /**
     * @return An array where within each element is a List of DieLetters representing all six possible letters that
     * can appear on the die. This array in total represent all of the dice supported for a given game board
     * configuration.
     */
    public abstract List<DieLetter>[] getSupportedDice();

    /**
     * Shakes all of the dice and shuffles them such that they have all fallen into place on the game board.
     * @return The board configuration. Will be non-null.
     */
    public final DieLetter[][] shake() {
        final int gameBoardSize = size();

        Random random = new Random();
        List<Integer> dieIndicators = new ArrayList<>(gameBoardSize * gameBoardSize);
        for (int i = 0;i < gameBoardSize * gameBoardSize;i++) {
            dieIndicators.add(i);
        }

        DieLetter[][] result = new DieLetter[gameBoardSize][];

        for (int row = 0;row < gameBoardSize;row++) {
            result[row] = new DieLetter[gameBoardSize];

            for (int col = 0;col < gameBoardSize;col++) {
                // Determine the die that has fallen into this position on the game board.

                int dieIndicator;
                if (dieIndicators.size() > 1) {
                    dieIndicator = dieIndicators.get(random.nextInt(dieIndicators.size()));
                    // Remove the die now being used from those available so that it cannot be
                    // selected the next time through this loop. I am being careful to ensure
                    // List.remove(Object o) is being called here rather than List.remove(int index).
                    dieIndicators.remove(Integer.valueOf(dieIndicator));
                } else {
                    dieIndicator = dieIndicators.iterator().next().intValue();
                }
                List<DieLetter> dieFound = getSupportedDice()[dieIndicator];
                DieLetter letterShown = dieFound.get(random.nextInt(6));
                result[row][col] = letterShown;
            }
        }

        return result;
    }
}
