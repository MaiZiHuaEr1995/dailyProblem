package leetcode;

public class SumOddLengthSubarrays {
    public static void main(String[] args) {

    }

    public int sumOddLengthSubarrays(int[] arr) {
        int res = 0;
        int length = arr.length;
        // 计算出来从下标0到下标 i-1 的所有元素
        int[] pre = new int[length + 1];
        for (int i = 0; i < length; i++) {
            pre[i + 1] = pre[i] + arr[i];
        }

        // 从索引为0的位置开始遍历1，3，5等奇数长度的数组
        for (int i = 0; i < length; i++) {
            for (int j = 1; j <= length; j = j + 2) {
                if (i + j - 1 < length) {
                    res += pre[i + j] - pre[i];
                }
            }
        }
        return res;
    }
}
