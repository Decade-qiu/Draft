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
        String[] x = {"[3,4,4,5]"};
        System.out.println(new Solution().squareFreeSubsets(
                int1d(x[0])
        ));
        System.out.println(Integer.toBinaryString(3));
        System.out.println((3L >> 32 & 1));
    }
}

class Solution {
    public int squareFreeSubsets(int[] nums) {
        int[] cnt = new int[31];
        for (int i : nums) cnt[i]++;
        for (int i = 1;i < (1<<(31));i++){
            
        }
    }
}