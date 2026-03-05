package leetcode;

import java.util.ArrayList;
public class NumArray {

    ArrayList<Integer> array;

    public NumArray(int[] nums) {
        array = new ArrayList<>();
        for (int num : nums) {
            array.add(num);
        }
    }

    public int sumRange(int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; i++) {
            sum += array.get(i);
        }
        return sum;
    }
}
