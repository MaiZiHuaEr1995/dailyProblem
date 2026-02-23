package leetcode;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        MoveZeros moveZeros = new MoveZeros();
        int[] demo =  new int[] {0,1,0,3,12};
        moveZeros.removeZeros(demo);
        System.out.println(Arrays.toString(Arrays.stream(demo).toArray()));
    }
    public void removeZeros(int[] nums) {
        int slow = 0, fast = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                fast++;
            } else {
                nums[slow] = nums[i];
                fast++;
                slow++;
            }
        }
        for (int i = slow; i < fast; i++) {
            nums[i] = 0;
        }
    }
}
