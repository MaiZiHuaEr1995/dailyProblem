package org.example.dailyQuestion;

import java.util.Arrays;

/**
 * 题目描述：给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 */

public class FindDiagonalOrder20250825 {
    public static int[] findDiagonalOrder(int[][] mat) {
        // 有几列
        int rows = mat.length;
        // 有几行
        int cols = mat[0].length;
        // 总元素的数量
        int[] res = new int[rows * cols];
        int i = 0, j = 0 , index = 0;
        while (index < rows * cols) {
            while (i >= 0 && j < cols) {
                res[index++] = mat[i][j];
                i--;
                j++;
            }
            i++;
            if (j >= cols) {
                i++;
                j--;
            }
            while (i < rows && j >= 0) {
                res[index++] = mat[i][j];
                i++;
                j--;
            }
            j++;
            while (i >= rows ) {
                i--;
                j++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] case1 = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[] res1 = findDiagonalOrder(case1);
        System.out.println(Arrays.toString(res1));
        int[][] case2 = {{1,2}, {3,4}};
        int[] res2 = findDiagonalOrder(case2);
        System.out.println(Arrays.toString(res2));
    }
}
