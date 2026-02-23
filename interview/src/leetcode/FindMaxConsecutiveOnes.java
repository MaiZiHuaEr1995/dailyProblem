package leetcode;

public class FindMaxConsecutiveOnes {
    public static void main(String[] args) {
        int maxConsecutiveOnes = findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1});
        System.out.println(maxConsecutiveOnes);
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int last = -1, max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                last = i;
            } else {
                max = Math.max(max, i - last);
            }
        }
        return max;
    }
}
