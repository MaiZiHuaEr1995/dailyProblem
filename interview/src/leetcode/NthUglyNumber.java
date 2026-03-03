package leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;

public class NthUglyNumber {
    public static void main(String[] args) {

    }

    public int nthUglyNumber(int n) {
        int[] factor = new int[]{2, 3, 5};
        HashSet<Long> set = new HashSet<>();
        set.add(1L);
        PriorityQueue<Long> queue = new PriorityQueue<>();
        queue.add(1L);
        int res = 0;
        for (int i = 0; i < n ; i++) {
            long cur = queue.poll();
            res = Math.toIntExact(cur);
            for (int f : factor) {
                long next = cur * f;
                if (set.add(next)) {
                    queue.offer(next);
                }
            }
        }
        return res;
    }
}
