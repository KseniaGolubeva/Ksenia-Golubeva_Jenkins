package org.douggschwind.games.dicegames.boggle;

import java.util.Arrays;

/**
 * Records the board locations that have been visited. A board location (i.e. die in the game board) is visited when
 * the letter on the die is considered for a part of a word being built. Since a given die can only be used once
 * within a valid word in the game of Boggle, this logic is required.
 *
 * Allows an instance of this class to be easily cloned.
 * @author Doug Gschwind
 */
public class BoardLocationsVisited implements Cloneable {
    private boolean[][] state;

    BoardLocationsVisited(int gameBoardSize) {
        state = new boolean[gameBoardSize][];
        for (int row = 0;row < gameBoardSize;row++) {
            state[row] = new boolean[gameBoardSize];
        }
    }

    boolean hasBeenVisited(int row, int column) {
        return state[row][column];
    }

    void markVisited(int row, int column) {
        state[row][column] = true;
    }

    @Override
    public BoardLocationsVisited clone() {
        BoardLocationsVisited clone = null;
        try {
            clone = (BoardLocationsVisited) super.clone();
            int boardSize = this.state.length;
            clone.state = Arrays.copyOf(this.state, boardSize);
            for (int row = 0;row < boardSize;row++) {
                clone.state[row] = Arrays.copyOf(this.state[row], boardSize);
            }
        } catch (CloneNotSupportedException ignored) {
        }

        return clone;
    }
}
