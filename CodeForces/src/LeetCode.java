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
        String[] x = {"[1,1,2,2,2,3]"};
        System.out.println(new Solution().dieSimulator(
                2, int1d(x[0])
        ));
        System.out.println(Integer.toBinaryString(3));
        System.out.println((3L >> 32 & 1));
    }
}

class Solution {
    public int dieSimulator(int n, int[] rollMax) {
        int M = (int)(1e9+7), ans = 0;
        int[][][] dp = new int[n+1][6][16];
        for (int i = 0;i < 6;i++) dp[0][i][0] = 1;
        for (int i = 1;i <= n;i++){
            for (int j = 0;j < 6;j++){
                for (int k = 2;k <= rollMax[j];k++){
                    dp[i][j][k] = (dp[i][j][k]+dp[i-1][j][k-1])%M;
                }
                for (int t = 0;t < 6;t++){
                    if (t == j) continue;
                    for (int k = 0;k <= rollMax[t];k++){
                        dp[i][j][1] = (dp[i][j][1]+dp[i-1][t][k])%M;
                    }
                }
            }
        }
        for (int i = 0;i < 6;i++){
            for (int j = 1;j <= rollMax[i];j++){
                ans = (ans + dp[n][i][j])%M;
            }
        }
        return ans;
    }
}