package org.douggschwind.games.dicegames.boggle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * An instance of this class represents a letter in a sequence of letters in a word. If this letter
 * is the last in a valid word, the word boolean will be true.
 * @author Doug Gschwind
 */
public class LetterNode {
    private final char letter;
    private boolean word;
    private final Map<Character, LetterNode> childMap = new HashMap<>();

    public LetterNode(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public boolean isWord() {
        return word;
    }

    public void setWord(boolean newValue) {
        word = newValue;
    }

    protected Optional<LetterNode> getChildNode(char letter) {
        return Optional.ofNullable(childMap.get(letter));
    }

    protected LetterNode addChildNode(char letter) {
        Optional<LetterNode> letterNodeOptional = getChildNode(letter);
        if (letterNodeOptional.isPresent()) {
            return letterNodeOptional.get();
        } else {
            LetterNode result = new LetterNode(letter);
            childMap.put(letter, result);
            return result;
        }
    }
}
