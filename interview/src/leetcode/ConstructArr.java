package leetcode;


// 剑指 Offer 66. 构建乘积数组:https://leetcode-cn.com/problems/gou-jian-cheng-ji-shu-zu￾lcof/
public class ConstructArr {
    public static void main(String[] args) {

    }

    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return a;
        }
        int len = a.length;
        int[] res = new int[len];
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] + a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] + a[i + 1];
        }
        for (int i = 0; i < len; i++) {
           res[i] = left[i] + right[i];
        }
        return res;
    }
}
