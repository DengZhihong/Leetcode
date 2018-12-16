package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 思路: 给定数组arr[n][m]
 * 自上而下递归:
 * 第一维数组的长度n作为递归的深度,
 * f(n,m) = min( f(n-1,m),f(n-1,m+1) ) + arr[n][m]
 */

public class Q120 {

    private int[][] arr;

    /**
     * 记忆化搜索:
     * 利用数组arr来存储计算过的答案;
     *
     * @param triangle
     * @param n
     * @param m
     * @return
     */
    private int calcMini(List<List<Integer>> triangle, int n, int m) {
        if (n == triangle.size()) {
            return 0;
        }

        if (arr[n][m] == -1) {
            arr[n][m] = Math.min(calcMini(triangle, n + 1, m), calcMini(triangle, n + 1, m + 1)) +
                    triangle.get(n).get(m);
        }

        return arr[n][m];
    }

    /**
     * 动态规划,自下而上,采用res[][]保存计算结果
     *
     * @param triangle
     * @return
     */
    private int dp(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(triangle.size() - 1).size();
        int[][] res = new int[n][m];
        for (int i = 0; i < m; i++) {
            res[n - 1][i] = triangle.get(n - 1).get(i);
        }


        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                res[i][j] = Math.min(res[i + 1][j], res[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return res[0][0];
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(triangle.size() - 1).size();
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = -1;
            }
        }
        return dp(triangle);
        /*for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }*/
    }

    public static void main(String[] args) {

        List<List<Integer>> tr = new ArrayList<>();
        tr.add(Arrays.asList(new Integer[]{2}));
        tr.add(Arrays.asList(new Integer[]{3, 4}));
        tr.add(Arrays.asList(new Integer[]{6, 5, 7}));
        tr.add(Arrays.asList(new Integer[]{4, 1, 8, 3}));
        System.out.println(new Q120().minimumTotal(tr));

    }
}
