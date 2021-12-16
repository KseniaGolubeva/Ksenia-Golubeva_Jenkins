package org.douggschwind.games.dicegames.boggle;

import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

/**
 * @author Doug Gschwind
 */
public class BoggleTest {

    private void assertResults(String[] wordsExpectedToBeFound, Set<String> wordsActuallyFound) {
        Assert.assertEquals(wordsExpectedToBeFound.length, wordsActuallyFound.size());
        for (String wordExpected : wordsExpectedToBeFound) {
            Assert.assertTrue("Did not find word <" + wordExpected + ">", wordsActuallyFound.contains(wordExpected));
        }
    }

    @Test
    public void test4x4BoggleWordFindingNoQuPresent() {
        DieLetter[][] gameBoard = new DieLetter[4][];
        gameBoard[0] = new DieLetter[4];
        gameBoard[0][0] = new DieLetter('s');
        gameBoard[0][1] = new DieLetter('u');
        gameBoard[0][2] = new DieLetter('m');
        gameBoard[0][3] = new DieLetter('e');
        gameBoard[1] = new DieLetter[4];
        gameBoard[1][0] = new DieLetter('r');
        gameBoard[1][1] = new DieLetter('e');
        gameBoard[1][2] = new DieLetter('i');
        gameBoard[1][3] = new DieLetter('n');
        gameBoard[2] = new DieLetter[4];
        gameBoard[2][0] = new DieLetter('s');
        gameBoard[2][1] = new DieLetter('a');
        gameBoard[2][2] = new DieLetter('e');
        gameBoard[2][3] = new DieLetter('i');
        gameBoard[3] = new DieLetter[4];
        gameBoard[3][0] = new DieLetter('e');
        gameBoard[3][1] = new DieLetter('r');
        gameBoard[3][2] = new DieLetter('t');
        gameBoard[3][3] = new DieLetter('f');

        String[] wordsExpectedToBeFound = new String[]
                {
                        "ate",
                        "eat",
                        "eaten",
                        "fin",
                        "fine",
                        "fit",
                        "meat",
                        "meet",
                        "net",
                        "rat",
                        "rate",
                        "resume",
                        "sat",
                        "sea",
                        "seas",
                        "seat",
                        "see",
                        "seen",
                        "tar",
                        "tare",
                        "tea",
                        "teas",
                        "tee",
                        "tees",
                        "ten"
                };

        Boggle subject = new Boggle();
        Set<String> wordsFound = subject.findWordsPresent(4, gameBoard);
        assertResults(wordsExpectedToBeFound, wordsFound);
    }

    @Test
    public void test4x4BoggleWordFindingQuPresent() {
        DieLetter[][] gameBoard = new DieLetter[4][];
        gameBoard[0] = new DieLetter[4];
        gameBoard[0][0] = new DieLetter('k');
        gameBoard[0][1] = new DieLetter('p');
        gameBoard[0][2] = new DieLetter('t');
        gameBoard[0][3] = new DieLetter('a');
        gameBoard[1] = new DieLetter[4];
        gameBoard[1][0] = new DieLetter('r');
        gameBoard[1][1] = new DieLetter('i');
        gameBoard[1][2] = new DieLetter('n');
        gameBoard[1][3] = new DieLetter('s');
        gameBoard[2] = new DieLetter[4];
        gameBoard[2][0] = new DieLetter('n');
        gameBoard[2][1] = new DieLetter('h');
        gameBoard[2][2] = new DieLetter('q', true);
        gameBoard[2][3] = new DieLetter('c');
        gameBoard[3] = new DieLetter[4];
        gameBoard[3][0] = new DieLetter('i');
        gameBoard[3][1] = new DieLetter('l');
        gameBoard[3][2] = new DieLetter('d');
        gameBoard[3][3] = new DieLetter('h');

        String[] wordsExpectedToBeFound = new String[]
                {
                        "hit", "hits", "kit", "kits", "pin", "pins", "quit", "quits", "sat"
                };

        Boggle subject = new Boggle();
        Set<String> wordsFound = subject.findWordsPresent(4, gameBoard);
        assertResults(wordsExpectedToBeFound, wordsFound);
    }

    /**
     * Here, I just want to test that the searching finds : fast, faster, fastest, fasts. Just want to verify that
     * after fast is found, the algorithm continues searching and finds faster, etc.
     */
    @Test
    public void test4x4BoggleWordFindingLongerWordsBasedUponShorterWordsPresent() {
        DieLetter[][] gameBoard = new DieLetter[4][];
        gameBoard[0] = new DieLetter[4];
        gameBoard[0][0] = new DieLetter('f');
        gameBoard[0][1] = new DieLetter('o');
        gameBoard[0][2] = new DieLetter('r');
        gameBoard[0][3] = new DieLetter('e');
        gameBoard[1] = new DieLetter[4];
        gameBoard[1][0] = new DieLetter('x');
        gameBoard[1][1] = new DieLetter('a');
        gameBoard[1][2] = new DieLetter('y');
        gameBoard[1][3] = new DieLetter('r');
        gameBoard[2] = new DieLetter[4];
        gameBoard[2][0] = new DieLetter('c');
        gameBoard[2][1] = new DieLetter('b');
        gameBoard[2][2] = new DieLetter('s');
        gameBoard[2][3] = new DieLetter('e');
        gameBoard[3] = new DieLetter[4];
        gameBoard[3][0] = new DieLetter('u');
        gameBoard[3][1] = new DieLetter('t');
        gameBoard[3][2] = new DieLetter('s');
        gameBoard[3][3] = new DieLetter('t');

        String[] wordsExpectedToBeFound = new String[]
                {
                        "act", "acts", "bar", "bare", "base", "bases", "bay", "bays", "cub", "cubs", "cut", "cuts",
                        "far", "fare", "fast", "faster", "fastest", "fasts", "fore", "ore", "ray", "rays",
                        "rest", "rests", "set", "sets", "stub", "stubs", "test", "tests", "yes"
                };

        Boggle subject = new Boggle();
        Set<String> wordsFound = subject.findWordsPresent(4, gameBoard);
        assertResults(wordsExpectedToBeFound, wordsFound);
    }

    @Test
    public void test5x5BoggleWordFindingNoQuPresent() {
        final int GAME_BOARD_SIZE = 5;

        DieLetter[][] gameBoard = new DieLetter[GAME_BOARD_SIZE][];
        gameBoard[0] = new DieLetter[GAME_BOARD_SIZE];
        gameBoard[0][0] = new DieLetter('t');
        gameBoard[0][1] = new DieLetter('e');
        gameBoard[0][2] = new DieLetter('o');
        gameBoard[0][3] = new DieLetter('s');
        gameBoard[0][4] = new DieLetter('w');
        gameBoard[1] = new DieLetter[GAME_BOARD_SIZE];
        gameBoard[1][0] = new DieLetter('e');
        gameBoard[1][1] = new DieLetter('n');
        gameBoard[1][2] = new DieLetter('s');
        gameBoard[1][3] = new DieLetter('o');
        gameBoard[1][4] = new DieLetter('x');
        gameBoard[2] = new DieLetter[GAME_BOARD_SIZE];
        gameBoard[2][0] = new DieLetter('c');
        gameBoard[2][1] = new DieLetter('i');
        gameBoard[2][2] = new DieLetter('a');
        gameBoard[2][3] = new DieLetter('h');
        gameBoard[2][4] = new DieLetter('i');
        gameBoard[3] = new DieLetter[GAME_BOARD_SIZE];
        gameBoard[3][0] = new DieLetter('i');
        gameBoard[3][1] = new DieLetter('a');
        gameBoard[3][2] = new DieLetter('e');
        gameBoard[3][3] = new DieLetter('t');
        gameBoard[3][4] = new DieLetter('i');
        gameBoard[4] = new DieLetter[GAME_BOARD_SIZE];
        gameBoard[4][0] = new DieLetter('o');
        gameBoard[4][1] = new DieLetter('o');
        gameBoard[4][2] = new DieLetter('c');
        gameBoard[4][3] = new DieLetter('s');
        gameBoard[4][4] = new DieLetter('i');

        String[] wordsExpectedToBeFound = new String[]
                {
                        "act",
                        "acts",
                        "ate",
                        "coo",
                        "eat",
                        "eats",
                        "has",
                        "heat",
                        "heats",
                        "hit",
                        "hits",
                        "net",
                        "nose",
                        "oat",
                        "sane",
                        "sat",
                        "sea",
                        "seas",
                        "seat",
                        "see",
                        "seen",
                        "sent",
                        "set",
                        "show",
                        "shows",
                        "sit",
                        "soon",
                        "sow",
                        "tea",
                        "teas",
                        "tee",
                        "teen",
                        "teens",
                        "tees",
                        "ten",
                        "tens",
                        "woo",
                        "woos"
                };

        Boggle subject = new Boggle();
        Set<String> wordsFound = subject.findWordsPresent(GAME_BOARD_SIZE, gameBoard);
        assertResults(wordsExpectedToBeFound, wordsFound);
    }
}
