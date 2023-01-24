import java.util.*;


public class LeetCode {
    static int[][] int2d(String x){
        x = x.substring(2, x.length()-2);
        String[] d2 = x.split("\\],\\[");
        int n = d2.length, m = d2[0].split(",").length;
        int[][] res = new int[n][m];
        for (int i = 0;i < n;i++){
            String[] cur = d2[i].split(",");
            for (int j = 0;j < m;j++) res[i][j] = Integer.parseInt(cur[j]);
        }
        return res;
        
    }
    static int[] int1d(String x){
        x = x.substring(1, x.length()-1);
        String[] tp = x.split(",");
        int n = tp.length;
        int[] res = new int[n];
        for (int i = 0;i < n;i++){
            res[i] = Integer.parseInt(tp[i]);
        }
        return res;
    }
    public static void main(String[] args) {
        String[] x = {"[3,10,5,25]",
                        "[2,3,3,3,1,5,5,0,5,3,4,2,1,2,5,1,2,0]"};
        System.out.println(new Solution().minCost(
                int1d(x[1]), 5
        ));
        System.out.println(Integer.toBinaryString(3));
        System.out.println((3L >> 32 & 1));
    }
}

class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0;
        int[] cnt = new int[1010];
        for (int i = 1;i <= n;i++){
            for (int t = 0;t < 1010;t++) cnt[t] = 0;
            int tp = 0;
            for (int j = i;j >= 1;j--){
                if (cnt[nums[j-1]]++ == 0) tp++;
                else tp = Math.max(tp-1, 0);
                dp[i] = Math.min(dp[j-1]+i-j+1-tp+k, dp[i]);
            }
        }return dp[n];
    }
}