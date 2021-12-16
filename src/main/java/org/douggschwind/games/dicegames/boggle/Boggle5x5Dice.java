package org.douggschwind.games.dicegames.boggle;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the dice configuration for the English Boggle 25 dice version:
 * Die0: Qu, B, Z, J, X, K
 * Die1: T, O, U, O, T, O
 * Die2: O, V, W, R, G, R
 * Die3: A, A, A, F, S, R
 * Die4: A, U, M, E, E, G
 * Die5: H, H, L, R, D, O
 * Die6: N, H, O, T, H, O
 * Die7: L, H, N, R, O, D
 * Die8: A, F, A, I, S, R
 * Die9: Y, I, F, A, S, R
 * Die10: T, E, L, P, C, I
 * Die11: S, S, N, S, E, U
 * Die12: R, I, Y, P, R, H
 * Die13: D, O, R, D, L, N
 * Die14: C, C, W, N, S, T
 * Die15: T, T, O, T, E, M
 * Die16: S, C, T, I, E, P
 * Die17: E, A, N, D, N, N
 * Die18: M, N, N, E, A, G
 * Die19: U, O, T, O, W, N
 * Die20: A, E, A, E, E, E
 * Die21: Y, I, F, P, S, R
 * Die22: E, E, E, E, M, A
 * Die23: I, T, I, T, I, E
 * Die24: E, T, I, L, I, C
 * @author Doug Gschwind
 */
public class Boggle5x5Dice extends BoggleDice {
    private static final int SIZE = 5;

    private static final List<DieLetter> DIE0 = new ArrayList();
    private static final List<DieLetter> DIE1 = new ArrayList();
    private static final List<DieLetter> DIE2 = new ArrayList();
    private static final List<DieLetter> DIE3 = new ArrayList();
    private static final List<DieLetter> DIE4 = new ArrayList();
    private static final List<DieLetter> DIE5 = new ArrayList();
    private static final List<DieLetter> DIE6 = new ArrayList();
    private static final List<DieLetter> DIE7 = new ArrayList();
    private static final List<DieLetter> DIE8 = new ArrayList();
    private static final List<DieLetter> DIE9 = new ArrayList();
    private static final List<DieLetter> DIE10 = new ArrayList();
    private static final List<DieLetter> DIE11 = new ArrayList();
    private static final List<DieLetter> DIE12 = new ArrayList();
    private static final List<DieLetter> DIE13 = new ArrayList();
    private static final List<DieLetter> DIE14 = new ArrayList();
    private static final List<DieLetter> DIE15 = new ArrayList();
    private static final List<DieLetter> DIE16 = new ArrayList();
    private static final List<DieLetter> DIE17 = new ArrayList();
    private static final List<DieLetter> DIE18 = new ArrayList();
    private static final List<DieLetter> DIE19 = new ArrayList();
    private static final List<DieLetter> DIE20 = new ArrayList();
    private static final List<DieLetter> DIE21 = new ArrayList();
    private static final List<DieLetter> DIE22 = new ArrayList();
    private static final List<DieLetter> DIE23 = new ArrayList();
    private static final List<DieLetter> DIE24 = new ArrayList();

    private static final List<DieLetter>[] DICE = (List<DieLetter>[]) new List[SIZE * SIZE];

    static {
        DIE0.add(new DieLetter('q', true));
        DIE0.add(new DieLetter('b'));
        DIE0.add(new DieLetter('z'));
        DIE0.add(new DieLetter('j'));
        DIE0.add(new DieLetter('x'));
        DIE0.add(new DieLetter('k'));

        DIE1.add(new DieLetter('t'));
        DIE1.add(new DieLetter('o'));
        DIE1.add(new DieLetter('u'));
        DIE1.add(new DieLetter('o'));
        DIE1.add(new DieLetter('t'));
        DIE1.add(new DieLetter('o'));

        DIE2.add(new DieLetter('o'));
        DIE2.add(new DieLetter('v'));
        DIE2.add(new DieLetter('w'));
        DIE2.add(new DieLetter('r'));
        DIE2.add(new DieLetter('g'));
        DIE2.add(new DieLetter('r'));

        DIE3.add(new DieLetter('a'));
        DIE3.add(new DieLetter('a'));
        DIE3.add(new DieLetter('a'));
        DIE3.add(new DieLetter('f'));
        DIE3.add(new DieLetter('s'));
        DIE3.add(new DieLetter('r'));

        DIE4.add(new DieLetter('a'));
        DIE4.add(new DieLetter('u'));
        DIE4.add(new DieLetter('m'));
        DIE4.add(new DieLetter('e'));
        DIE4.add(new DieLetter('e'));
        DIE4.add(new DieLetter('g'));

        DIE5.add(new DieLetter('h'));
        DIE5.add(new DieLetter('h'));
        DIE5.add(new DieLetter('l'));
        DIE5.add(new DieLetter('r'));
        DIE5.add(new DieLetter('d'));
        DIE5.add(new DieLetter('o'));

        DIE6.add(new DieLetter('n'));
        DIE6.add(new DieLetter('h'));
        DIE6.add(new DieLetter('o'));
        DIE6.add(new DieLetter('t'));
        DIE6.add(new DieLetter('h'));
        DIE6.add(new DieLetter('o'));

        DIE7.add(new DieLetter('l'));
        DIE7.add(new DieLetter('h'));
        DIE7.add(new DieLetter('n'));
        DIE7.add(new DieLetter('r'));
        DIE7.add(new DieLetter('o'));
        DIE7.add(new DieLetter('d'));

        DIE8.add(new DieLetter('a'));
        DIE8.add(new DieLetter('f'));
        DIE8.add(new DieLetter('a'));
        DIE8.add(new DieLetter('i'));
        DIE8.add(new DieLetter('s'));
        DIE8.add(new DieLetter('r'));

        DIE9.add(new DieLetter('y'));
        DIE9.add(new DieLetter('i'));
        DIE9.add(new DieLetter('f'));
        DIE9.add(new DieLetter('a'));
        DIE9.add(new DieLetter('s'));
        DIE9.add(new DieLetter('r'));

        DIE10.add(new DieLetter('t'));
        DIE10.add(new DieLetter('e'));
        DIE10.add(new DieLetter('l'));
        DIE10.add(new DieLetter('p'));
        DIE10.add(new DieLetter('c'));
        DIE10.add(new DieLetter('i'));

        DIE11.add(new DieLetter('s'));
        DIE11.add(new DieLetter('s'));
        DIE11.add(new DieLetter('n'));
        DIE11.add(new DieLetter('s'));
        DIE11.add(new DieLetter('e'));
        DIE11.add(new DieLetter('u'));

        DIE12.add(new DieLetter('r'));
        DIE12.add(new DieLetter('i'));
        DIE12.add(new DieLetter('y'));
        DIE12.add(new DieLetter('p'));
        DIE12.add(new DieLetter('r'));
        DIE12.add(new DieLetter('h'));

        DIE13.add(new DieLetter('d'));
        DIE13.add(new DieLetter('o'));
        DIE13.add(new DieLetter('r'));
        DIE13.add(new DieLetter('d'));
        DIE13.add(new DieLetter('l'));
        DIE13.add(new DieLetter('n'));

        DIE14.add(new DieLetter('c'));
        DIE14.add(new DieLetter('c'));
        DIE14.add(new DieLetter('w'));
        DIE14.add(new DieLetter('n'));
        DIE14.add(new DieLetter('s'));
        DIE14.add(new DieLetter('t'));

        DIE15.add(new DieLetter('t'));
        DIE15.add(new DieLetter('t'));
        DIE15.add(new DieLetter('o'));
        DIE15.add(new DieLetter('t'));
        DIE15.add(new DieLetter('e'));
        DIE15.add(new DieLetter('m'));

        DIE16.add(new DieLetter('s'));
        DIE16.add(new DieLetter('c'));
        DIE16.add(new DieLetter('t'));
        DIE16.add(new DieLetter('i'));
        DIE16.add(new DieLetter('e'));
        DIE16.add(new DieLetter('p'));

        DIE17.add(new DieLetter('e'));
        DIE17.add(new DieLetter('a'));
        DIE17.add(new DieLetter('n'));
        DIE17.add(new DieLetter('d'));
        DIE17.add(new DieLetter('n'));
        DIE17.add(new DieLetter('n'));

        DIE18.add(new DieLetter('m'));
        DIE18.add(new DieLetter('n'));
        DIE18.add(new DieLetter('n'));
        DIE18.add(new DieLetter('e'));
        DIE18.add(new DieLetter('a'));
        DIE18.add(new DieLetter('g'));

        DIE19.add(new DieLetter('u'));
        DIE19.add(new DieLetter('o'));
        DIE19.add(new DieLetter('t'));
        DIE19.add(new DieLetter('o'));
        DIE19.add(new DieLetter('w'));
        DIE19.add(new DieLetter('n'));

        DIE20.add(new DieLetter('a'));
        DIE20.add(new DieLetter('e'));
        DIE20.add(new DieLetter('a'));
        DIE20.add(new DieLetter('e'));
        DIE20.add(new DieLetter('e'));
        DIE20.add(new DieLetter('e'));

        DIE21.add(new DieLetter('y'));
        DIE21.add(new DieLetter('i'));
        DIE21.add(new DieLetter('f'));
        DIE21.add(new DieLetter('p'));
        DIE21.add(new DieLetter('s'));
        DIE21.add(new DieLetter('r'));

        DIE22.add(new DieLetter('e'));
        DIE22.add(new DieLetter('e'));
        DIE22.add(new DieLetter('e'));
        DIE22.add(new DieLetter('e'));
        DIE22.add(new DieLetter('m'));
        DIE22.add(new DieLetter('a'));

        DIE23.add(new DieLetter('i'));
        DIE23.add(new DieLetter('t'));
        DIE23.add(new DieLetter('i'));
        DIE23.add(new DieLetter('t'));
        DIE23.add(new DieLetter('i'));
        DIE23.add(new DieLetter('e'));

        DIE24.add(new DieLetter('e'));
        DIE24.add(new DieLetter('t'));
        DIE24.add(new DieLetter('i'));
        DIE24.add(new DieLetter('l'));
        DIE24.add(new DieLetter('i'));
        DIE24.add(new DieLetter('c'));

        DICE[0] = DIE0;
        DICE[1] = DIE1;
        DICE[2] = DIE2;
        DICE[3] = DIE3;
        DICE[4] = DIE4;
        DICE[5] = DIE5;
        DICE[6] = DIE6;
        DICE[7] = DIE7;
        DICE[8] = DIE8;
        DICE[9] = DIE9;
        DICE[10] = DIE10;
        DICE[11] = DIE11;
        DICE[12] = DIE12;
        DICE[13] = DIE13;
        DICE[14] = DIE14;
        DICE[15] = DIE15;
        DICE[16] = DIE16;
        DICE[17] = DIE17;
        DICE[18] = DIE18;
        DICE[19] = DIE19;
        DICE[20] = DIE20;
        DICE[21] = DIE21;
        DICE[22] = DIE22;
        DICE[23] = DIE23;
        DICE[24] = DIE24;
    }

    @Override
    public final int size() {
        return SIZE;
    }

    @Override
    public final List<DieLetter>[] getSupportedDice() {
        return DICE;
    }
}
