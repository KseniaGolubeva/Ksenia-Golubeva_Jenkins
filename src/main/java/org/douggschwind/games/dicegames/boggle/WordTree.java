package org.douggschwind.games.dicegames.boggle;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

/**
 * Houses an n-ary tree that decomposes our list of valid words into a sequence of nodes for ease
 * in determining if a sequence of letters is a word or the first letters of one to many valid words.
 * @author Doug Gschwind
 */
public class WordTree {
    private final Map<Character, LetterNode> rootLetterMap = new HashMap<>();

    // Retain the set of validWords to make the isValidWord() implementation very simple.
    private Set<String> validWords;

    private void seed(String validWord) {
        LetterNode previousLetterNode = null;
        for (int letterIndex = 0;letterIndex < validWord.length();letterIndex++) {
            char currentLetter = validWord.charAt(letterIndex);
            if (letterIndex == 0) {
                previousLetterNode = rootLetterMap.get(currentLetter);
                if (previousLetterNode == null) {
                    previousLetterNode = new LetterNode(currentLetter);
                    rootLetterMap.put(currentLetter, previousLetterNode);
                }
            } else {
                previousLetterNode = previousLetterNode.addChildNode(currentLetter);
            }
        }
        previousLetterNode.setWord(true);
    }

    /**
     * Populates with all of the words known to be valid.
     * @param validWords
     */
    public void seed(Set<String> validWords) {
        validWords.forEach(word -> seed(word));
        this.validWords = validWords;
    }

    /**
     * Determines if this instance has one or more words that begin with the given prefix.
     * @param prefix Expected to be non-empty and non-null.
     * @return
     */
    public boolean hasWordsThatBeginWith(String prefix) {
        if ((prefix == null) || (prefix.isEmpty())) {
            return false;
        }

        LetterNode previousLetterNode = null;
        for (int letterIndex = 0;letterIndex < prefix.length();letterIndex++) {
            char currentLetter = prefix.charAt(letterIndex);
            if (letterIndex == 0) {
                previousLetterNode = rootLetterMap.get(currentLetter);
                if (previousLetterNode == null) {
                    // Can only get here if our list of valid words doesn't have coverage for at least one
                    // word that begins with each different letter of the alphabet.
                    return false;
                }
            } else {
                Optional<LetterNode> previousLetterNodeOptional = previousLetterNode.getChildNode(currentLetter);
                if (!previousLetterNodeOptional.isPresent()) {
                    return false;
                }
                previousLetterNode = previousLetterNodeOptional.get();
            }
        }

        return true;
    }

    public boolean isValidWord(String input) {
        return validWords.contains(input);
    }
}
