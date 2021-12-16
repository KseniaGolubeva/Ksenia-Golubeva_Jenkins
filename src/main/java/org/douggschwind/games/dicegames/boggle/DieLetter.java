package org.douggschwind.games.dicegames.boggle;

/**
 * Instances of this class represent the state of one die on the Boggle game board. There is one die within the
 * set of Boggle dice that represents the letter combination of Q and U. That condition is handled by the qu
 * boolean instance variable here.
 * @author Doug Gschwind
 */
public class DieLetter {
    private final char letter;
    private final boolean qu;

    protected DieLetter(char letter, boolean qu) {
        this.letter = letter;
        this.qu = qu;
    }

    protected DieLetter(char letter) {
        this(letter, false);
    }

    protected char getLetter() {
        return letter;
    }

    protected String asWordPart() {
        return isQu() ? "qu" : "" + getLetter();
    }

    protected boolean isQu() {
        return qu;
    }
}
