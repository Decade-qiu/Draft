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
        String[] x = {"[[1,2],[3,2]]", "[[2,1],[3,2]]", "[[18,19],[3,12],[17,19],[2,13],[7,10]]"};
        System.out.println(new Solution().distinctNames(
                new String[]{"aaa","baa","caa","bbb","cbb","dbb"}
        ));
    }
}

class Solution {
    public long distinctNames(String[] ideas) {
        long ans = 0;
        HashSet<String> hs = new HashSet<>();
        for (String i : ideas) hs.add(i);
        int[] c = new int[26];
        for (String k : ideas){
            int[] f = new int[26];
            for (int i = 0;i < 26;i++){
                if (hs.contains((char)(i+'a')+k.substring(1))) f[i] = 1;
            }
            for (int i = 0;i < 26;i++){
                if (f[i] == 1) continue;
                c[i]++;
            }
            ans += c[k.charAt(0)-'a'];
        }
        return ans*2;
    }
}
// @lc code=end

