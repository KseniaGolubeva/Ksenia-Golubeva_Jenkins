package org.douggschwind.games.dicegames.boggle;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Houses an n-ary tree that decomposes our list of valid words into a sequence of nodes for ease
 * in determining if a sequence of letters is a word or the first letters of one to many valid words.
 * @author Doug Gschwind
 */
public class WordTreeTest {
    @Test
    public void comprehensiveTest() {
        // We will use but a brief subset of valid words for our testing purposes here.
        Set<String> validWords = new HashSet<>();
        validWords.add("apple");
        validWords.add("artist");
        validWords.add("art");
        validWords.add("arts");
        validWords.add("banana");
        validWords.add("ban");
        validWords.add("bane");
        validWords.add("two");
        validWords.add("to");
        validWords.add("too");
        validWords.add("top");
        validWords.add("three");
        validWords.add("thank");
        validWords.add("thanks");
        validWords.add("thee");
        validWords.add("theme");
        validWords.add("them");
        validWords.add("the");
        validWords.add("though");
        validWords.add("those");
        validWords.add("this");
        validWords.add("that");
        validWords.add("thus");
        validWords.add("thought");
        validWords.add("thoughts");
        validWords.add("thorough");
        validWords.add("you");
        validWords.add("zebra");
        validWords.add("zero");
        validWords.add("zoo");

        final WordTree subject = new WordTree();
        subject.seed(validWords);

        Set<String> invalidWords = new HashSet<>();
        invalidWords.add("appled");
        invalidWords.add("arf");
        invalidWords.add("b");
        invalidWords.add("band");
        invalidWords.add("color");
        invalidWords.add("deck");
        invalidWords.add("easy");
        invalidWords.add("false");
        invalidWords.add("gaff");
        invalidWords.add("house");
        invalidWords.add("idle");
        invalidWords.add("joy");
        invalidWords.add("king");
        invalidWords.add("long");
        invalidWords.add("mind");
        invalidWords.add("none");
        invalidWords.add("optional");
        invalidWords.add("people");
        invalidWords.add("queen");
        invalidWords.add("rest");
        invalidWords.add("session");
        invalidWords.add("t");
        invalidWords.add("u");
        invalidWords.add("v");
        invalidWords.add("w");
        invalidWords.add("x");
        invalidWords.add("y");
        invalidWords.add("z");

        for (String invalidWord : invalidWords) {
            Assert.assertFalse(validWords.contains(invalidWord));
        }

        Assert.assertFalse(subject.isValidWord(null));
        Assert.assertFalse(subject.isValidWord(""));
        invalidWords.forEach(invalidWord -> Assert.assertFalse(subject.isValidWord(invalidWord)));
        validWords.forEach(validWord -> Assert.assertTrue(subject.isValidWord(validWord)));

        Assert.assertTrue(subject.hasWordsThatBeginWith("a"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("ab"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("az"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("ap"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("ar"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("art"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("arti"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("az"));

        Assert.assertTrue(subject.hasWordsThatBeginWith("b"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("ba"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("ban"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("bana"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("banan"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("banana"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("bb"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("bz"));

        Assert.assertFalse(subject.hasWordsThatBeginWith("c"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("d"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("e"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("f"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("g"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("h"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("i"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("j"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("k"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("l"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("m"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("n"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("o"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("p"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("q"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("r"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("s"));

        Assert.assertTrue(subject.hasWordsThatBeginWith("t"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("th"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("tha"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("thi"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("tho"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("to"));

        Assert.assertFalse(subject.hasWordsThatBeginWith("u"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("v"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("w"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("x"));

        Assert.assertTrue(subject.hasWordsThatBeginWith("z"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("ze"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("zeb"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("zebr"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("zebra"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("zer"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("zero"));
        Assert.assertTrue(subject.hasWordsThatBeginWith("zo"));
        Assert.assertFalse(subject.hasWordsThatBeginWith("zz"));
    }
}
