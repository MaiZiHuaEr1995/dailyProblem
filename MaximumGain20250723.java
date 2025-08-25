package org.example.dailyQuestion;

public class MaximumGain20250723 {

    public static int maximumGain(String s, int x, int y) {
        int res = 0, a = 0, b = 0;
        // 取x，y中比较大的那个值
        int max = Math.max(x, y);
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (curr == 'b') {
                b++;
                if (a > 0 && max == x) {
                    // 有ab组合消除ab组合，加上x分
                    a--;
                    b--;
                    res = res + x;
                }
            } else if (curr == 'a') {
                a++;
                if (b > 0 && max == y) {
                    // 有ba组合消除ba组合，加上y分
                    a--;
                    b--;
                    res = res + y;
                }
            } else {
                res = res + Math.min(a, b) * Math.min(x, y);
                // 遇到不是a,b的字符串结算一次
                a = 0;
                b = 0;
            }
        }
        // 字符循环计算完了，再处理可能没有处理的字符串
        return res + Math.min(x, y) * Math.min(a, b);
    }

    public static void main(String[] args) {
        int res1 = maximumGain("cdbcbbaaabab", 4, 5);
        System.out.println(res1);
    }
}
