package com.bongo.anagram;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class AnagramTest {
    @Test
    public void testAnagram() {
        MainActivity mainActivity = new MainActivity();
        assertTrue(mainActivity.checkAnagram("tea", "eat"));
    }
}