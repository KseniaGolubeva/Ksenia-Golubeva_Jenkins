package org.douggschwind.games.dicegames.boggle;

import java.util.ArrayList;
import java.util.List;

/**
 * This is the dice configuration for the English Boggle 16 dice version:
 * Die0: R, I, F, O, B, X
 * Die1: I, F, E, H, E, Y
 * Die2: D, E, N, O, W, S
 * Die3: U, T, O, K, N, D
 * Die4: H, M, S, R, A, O
 * Die5: L, U, P, E, T, S
 * Die6: A, C, I, T, O, A
 * Die7: Y, L, G, K, U, E
 * Die8: Qu, B, M, J, O, A
 * Die9: E, H, I, S, P, N
 * Die10: V, E, T, I, G, N
 * Die11: B, A, L, I, Y, T
 * Die12: E, Z, A, V, N, D
 * Die13: R, A, L, E, S, C
 * Die14: U, W, I, L, R, G
 * Die15: P, A, C, E, M, D
 * @author Doug Gschwind
 */
public class Boggle4x4Dice extends BoggleDice {
    private static final int SIZE = 4;

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

    private static final List<DieLetter>[] DICE = (List<DieLetter>[]) new List[SIZE * SIZE];

    static {
        DIE0.add(new DieLetter('r'));
        DIE0.add(new DieLetter('i'));
        DIE0.add(new DieLetter('f'));
        DIE0.add(new DieLetter('o'));
        DIE0.add(new DieLetter('b'));
        DIE0.add(new DieLetter('x'));

        DIE1.add(new DieLetter('i'));
        DIE1.add(new DieLetter('f'));
        DIE1.add(new DieLetter('e'));
        DIE1.add(new DieLetter('h'));
        DIE1.add(new DieLetter('e'));
        DIE1.add(new DieLetter('y'));

        DIE2.add(new DieLetter('d'));
        DIE2.add(new DieLetter('e'));
        DIE2.add(new DieLetter('n'));
        DIE2.add(new DieLetter('o'));
        DIE2.add(new DieLetter('w'));
        DIE2.add(new DieLetter('s'));

        DIE3.add(new DieLetter('u'));
        DIE3.add(new DieLetter('t'));
        DIE3.add(new DieLetter('o'));
        DIE3.add(new DieLetter('k'));
        DIE3.add(new DieLetter('n'));
        DIE3.add(new DieLetter('d'));

        DIE4.add(new DieLetter('h'));
        DIE4.add(new DieLetter('m'));
        DIE4.add(new DieLetter('s'));
        DIE4.add(new DieLetter('r'));
        DIE4.add(new DieLetter('a'));
        DIE4.add(new DieLetter('o'));

        DIE5.add(new DieLetter('l'));
        DIE5.add(new DieLetter('u'));
        DIE5.add(new DieLetter('p'));
        DIE5.add(new DieLetter('e'));
        DIE5.add(new DieLetter('t'));
        DIE5.add(new DieLetter('s'));

        DIE6.add(new DieLetter('a'));
        DIE6.add(new DieLetter('c'));
        DIE6.add(new DieLetter('i'));
        DIE6.add(new DieLetter('t'));
        DIE6.add(new DieLetter('o'));
        DIE6.add(new DieLetter('a'));

        DIE7.add(new DieLetter('y'));
        DIE7.add(new DieLetter('l'));
        DIE7.add(new DieLetter('g'));
        DIE7.add(new DieLetter('k'));
        DIE7.add(new DieLetter('u'));
        DIE7.add(new DieLetter('e'));

        DIE8.add(new DieLetter('q', true));
        DIE8.add(new DieLetter('b'));
        DIE8.add(new DieLetter('m'));
        DIE8.add(new DieLetter('j'));
        DIE8.add(new DieLetter('o'));
        DIE8.add(new DieLetter('a'));

        DIE9.add(new DieLetter('e'));
        DIE9.add(new DieLetter('h'));
        DIE9.add(new DieLetter('i'));
        DIE9.add(new DieLetter('s'));
        DIE9.add(new DieLetter('p'));
        DIE9.add(new DieLetter('n'));

        DIE10.add(new DieLetter('v'));
        DIE10.add(new DieLetter('e'));
        DIE10.add(new DieLetter('t'));
        DIE10.add(new DieLetter('i'));
        DIE10.add(new DieLetter('g'));
        DIE10.add(new DieLetter('n'));

        DIE11.add(new DieLetter('b'));
        DIE11.add(new DieLetter('a'));
        DIE11.add(new DieLetter('l'));
        DIE11.add(new DieLetter('i'));
        DIE11.add(new DieLetter('y'));
        DIE11.add(new DieLetter('t'));

        DIE12.add(new DieLetter('e'));
        DIE12.add(new DieLetter('z'));
        DIE12.add(new DieLetter('a'));
        DIE12.add(new DieLetter('v'));
        DIE12.add(new DieLetter('n'));
        DIE12.add(new DieLetter('d'));

        DIE13.add(new DieLetter('r'));
        DIE13.add(new DieLetter('a'));
        DIE13.add(new DieLetter('l'));
        DIE13.add(new DieLetter('e'));
        DIE13.add(new DieLetter('s'));
        DIE13.add(new DieLetter('c'));

        DIE14.add(new DieLetter('u'));
        DIE14.add(new DieLetter('w'));
        DIE14.add(new DieLetter('i'));
        DIE14.add(new DieLetter('l'));
        DIE14.add(new DieLetter('r'));
        DIE14.add(new DieLetter('g'));

        DIE15.add(new DieLetter('p'));
        DIE15.add(new DieLetter('a'));
        DIE15.add(new DieLetter('c'));
        DIE15.add(new DieLetter('e'));
        DIE15.add(new DieLetter('m'));
        DIE15.add(new DieLetter('d'));

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
