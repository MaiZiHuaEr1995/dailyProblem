package leetcode;

public class PivotIndex {
    public static void main(String[] args) {

    }

    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        for (int i = 0; i < nums.length; i++) {
            int right = total - nums[i] - left;
            if (right == left) {
                return i;
            }
            left = left + nums[i];
        }
        return -1;
    }
}
