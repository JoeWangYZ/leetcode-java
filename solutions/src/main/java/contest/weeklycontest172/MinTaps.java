package contest.weeklycontest172;

import java.util.*;

/**
 * Created by wangyuzhou on 2020/1/29.
 * STATUS: STUDIED
 */
public class MinTaps {
    public int minTaps(int n, int[] ranges) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < ranges.length; i ++) {
            int left = Math.max((i - ranges[i]), 0);
            int right = Math.min((i + ranges[i]), n);
            for (int j = left + 1; j <= right; j ++) {
                if (dp[left] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[left] + 1);
                }
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1: dp[n];
    }

    class Interval {
        int s;
        int e;
        Interval(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }

    public int minTaps_14ms(int n, int[] ranges) {
        Interval[] intervals = new Interval[n+1];
        for (int i = 0; i < n + 1; i++) {
            intervals[i] = new Interval(i - ranges[i], i + ranges[i]);
        }

        int from = 0;
        boolean[] visited = new boolean[n+1];
        int ans = 0;
        while (from < n) {
            int maxEnd = 0;
            int targetIndex = -1;
            for (int i = 0; i < n + 1; i++) {
                if (!visited[i] && intervals[i].s <= from && intervals[i].e > maxEnd) {
                    maxEnd = intervals[i].e;
                    targetIndex = i;
                }
            }

            if (targetIndex == -1) {
                return -1;
            }

            from = maxEnd;
            visited[targetIndex] = true;
            ans++;
        }

        return ans;
    }




    public static void main(String[] args) {
        MinTaps minTaps = new MinTaps();
        int[] input = {3, 4, 1, 1, 0, 0};
        int[] test = new int[10];
        System.out.println("result: " + minTaps.minTaps(5, input));

    }
}
