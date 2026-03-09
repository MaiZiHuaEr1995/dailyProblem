package leetcode;

import java.util.*;

public class FindShortestSubArray {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4,2};
        int shortestSubArray = findShortestSubArray(nums);
        System.out.println(shortestSubArray);
    }

    public static int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> first = new HashMap<>();
        HashMap<Integer, Integer> last = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count.put(num, count.getOrDefault(num, 0) + 1);
            max = Math.max(max, count.get(num));
            if (!first.containsKey(num)) {
                first.put(num, i);
            }
            last.put(num, i);
        }

        int min = Integer.MAX_VALUE;
        for(Map.Entry<Integer, Integer> entry: count.entrySet()){
            int num = entry.getKey();
            if (count.get(num) == max) {
                int length = last.get(num) - first.get(num) + 1;
                min = Math.min(min, length);
            }
        }
        return min;
    }
}
