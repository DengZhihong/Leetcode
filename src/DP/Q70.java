package DP;

import java.util.ArrayList;
import java.util.List;

/**
 * 自顶向下:
 * 当输入为n阶台阶,有两个分支,
 * 一个是走一步 n-1
 * 一个是走两步 n-2
 * 所以递归方程为f(n) = f(n-1) + f(n-2); // f(1) = 1
 */

public class Q70 {
    private int[] arr;

    /**
     * 直接递归的方式,超时
     *
     * @param n
     * @return
     */
    private int calcWays1(int n) {
        if (n == 1 || n == 0)
            return 1;
        /*if (n == 2)
            return 2;
            等价于n==0
            */
        return calcWays1(n - 1) + calcWays1(n - 2);
    }

    /**
     * 记忆化搜索
     *
     * @param n
     * @return
     */
    private int calcWays2(int n) {
        if (n == 0 || n == 1)
            return 1;
        /*if (n == 2)
            return 2;
            等价于n==0
            1
            */
        if (arr[n] == -1)
            arr[n] = calcWays2(n - 1) + calcWays2(n - 2);
        return arr[n];
    }

    /**
     * 动态规划
     *
     * @param n
     * @return
     */
    private int calcWays3(int n) {
        if (n == 1 || n == 0)
            return 1;
        int arr[] = new int[n + 1];
        arr[0] = 1;
        arr[1] = 1;

        for (int i = 2; i <= n; i++)
            arr[i] = arr[i - 1] + arr[i - 2];

        return arr[n];
    }

    public int climbStairs(int n) {
        //记忆化搜索
        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = -1;
        }
        return calcWays3(n);
    }

}
