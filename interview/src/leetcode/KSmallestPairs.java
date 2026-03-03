package leetcode;

import java.util.*;

public class KSmallestPairs {
    public static void main(String[] args) {

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> nums1[a[0]] + nums2[a[1]]));
        for (int i = 0; i < nums1.length; i++) {
            pq.offer(new int[]{i, 0});
        }
        List<List<Integer>> res = new ArrayList<>();
        // 只要 k 当前的值还大于 0，就进入循环，并且每进入一次循环，k 的值就自动减少 1
        while (k-- > 0 && !pq.isEmpty()) {
            // 取出来队头元素，不断弹出队头元素，弹出来k次就可以
            int[] cur = pq.poll();
            // cur 含有两个元素
            int index1 = cur[0];
            int index2 = cur[1];
            res.add(Arrays.asList(nums1[index1], nums2[index2]));
            index2++;
            if (index2 <nums2.length) {
                pq.offer(new int[]{index1, index2});
            }
        }
        return res;
    }
}
