package leetcode;

import java.util.Arrays;

public class IsAnagram {
    public static void main(String[] args) {

    }

    public boolean anagram(String s, String t) {
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        Arrays.sort(sArray);
        Arrays.sort(tArray);
        return Arrays.equals(sArray, tArray);
    }
}
