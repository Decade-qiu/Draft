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
        String[] x = {"[4,7,15,8,3,5]", "[[2,1],[3,2]]", "[[18,19],[3,12],[17,19],[2,13],[7,10]]"};
        System.out.println(new Solution().findValidSplit(int1d(x[0]))
        );
    }
}

class Solution {
    long gcd(long a, long b){
        return a==0?b:gcd(b%a, a);
    }
    public int findValidSplit(int[] nums) {
        int[] cnt = new int[(int)1e6+10];
        int n = nums.length;
        for (int i = 0;i < n;i++){
            int t = nums[i];
            for (int j = 2;j*j <= t;j++){
                if (t % j == 0){
                    while (t % j == 0){
                        cnt[j]++;
                        t /= j;
                    }
                }
            }cnt[t]++;
        }
        int a = 0, b = 0;
        int[] has = new int[(int)1e6+10];
        for (int i = 0;i < n-1;i++){
            int t = nums[i];
            for (int j = 2;j*j <= t;j++){
                if (t % j == 0){
                    if (has[j]==0){
                        has[j] = 1;
                        a++;
                    }
                    while (t % j == 0){
                        if (--cnt[j] == 0) b++;
                        t /= j;
                    }
                }
            }if (a == b) return i;
        }
        return -1;
    }
}

