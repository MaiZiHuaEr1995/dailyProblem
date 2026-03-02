package leetcode;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {

    }

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        res[T.length - 1] = 0;
        for (int i  = T.length - 2; i > 0; i--) {
            for (int j = i + 1; j < T.length; ) {
                if (T[i] < T[j]) {
                    res[i] = j - i;
                } else  {
                    res[i] = 0;
                }
                break;
            }
        }
        return res;
    }
}
