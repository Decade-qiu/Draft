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
        String[] x = {"[[0,0,0,0,0,1],[1,1,0,0,1,0],[0,0,0,0,1,1],[0,0,1,0,1,0],[0,1,1,0,0,0],[0,1,1,0,0,0]]",
                        "[[0,0,1,1,1,1],[0,0,0,0,1,1],[1,1,0,0,0,1],[1,1,1,0,0,1],[1,1,1,0,0,1],[1,1,1,0,0,0]]"};
        System.out.println(new Solution().minimumMoves(
                int2d(x[1])
        ));
        System.out.println(Integer.toBinaryString(3));
        System.out.println((3L >> 32 & 1));
    }
}

class Solution {
    public int minimumMoves(int[][] g) {
        Deque<int[]> d = new LinkedList<>();
        Set<String> hs = new HashSet<>();
        int n = g.length, ans = 0;
        d.offerLast(new int[]{0, 1, 0});
        while (!d.isEmpty()){
            int si = d.size();
            while (si-- > 0){
                int[] cur = d.pollFirst();
                String hash = cur[0]+" "+cur[1];
                if (hs.contains(hash)) continue;
                hs.add(hash);
                int x=cur[0]/n,y=cur[0]%n,s=cur[1]/n,t=cur[1]%n, st = cur[2];
                if (st == 0 && x==n-1 && y==n-2 && s==n-1 && t == n-1) return ans;
                if (st == 0){
                    if (t+1<n && g[s][t+1]==0){
                        d.offerLast(new int[]{cur[1], cur[1]+1, 0});
                    }
                    if (x+1<n && s+1<n && g[x+1][y]==0 && g[s+1][t]==0){
                        d.offerLast(new int[]{cur[0]+n,cur[1]+n,0});
                        d.offerLast(new int[]{cur[0], cur[0]+n,1});
                    }
                }else{
                    if (s+1<n && g[s+1][t]==0){
                        d.offerLast(new int[]{cur[0]+n, cur[1]+n, 1});
                    }
                    if (y+1<n && t+1<n && g[x][y+1]==0 && g[s][t+1]==0){
                        d.offerLast(new int[]{cur[0]+1,cur[1]+1,1});
                        d.offerLast(new int[]{cur[0], cur[0]+1,0});
                    }
                }
            }++ans;
        }return -1;
    }
}
