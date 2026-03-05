package leetcode;

// leetcode 409: 最长回文串

public class LongestPalindrome {
    public static void main(String[] args) {

    }

    public int longestPalindrome(String s) {
        // 26个字母但是需要区分大小写，大写字母和小写字母相差32:所以初始化是 26 + 32 = 58
        int[] count = new int[58];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A'] =  count[s.charAt(i) - 'A'] + 1;
        }
        int res = 0;
        for (int j : count) {
            if (j % 2 == 1) {
                res = res + j - 1;
            } else {
                res = res + j;
            }
        }
        if (res < s.length()) {
            res = res + 1;
        }
        return res;
    }
}
