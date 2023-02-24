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
        System.out.println(new Solution().buildMatrix(
                3, int2d(x[0]), int2d(x[1])
        ));
    }
}

class Solution {
    int f = 0;
    int[] get(int[] deg, List<Integer>[] g, int k){
        int t = 0, ans[] = new int[k+1];
        Deque<Integer> d = new LinkedList<>();
        for (int i = 1;i <= k;i++) if (deg[i]==0) d.offerLast(i);
        while (!d.isEmpty()){
            int u = d.pollFirst();
            ans[u] = t++;
            for (int v : g[u]){
                if (--deg[v] == 0) d.offerLast(v);
            }
        }
        int max = 0;
        for (int i = 0;i <= k;i++) max = Math.max(max, deg[i]);
        if (max != 0) f = 1;
        return ans;
    }
    public int[][] buildMatrix(int k, int[][] row, int[][] col) {
        int[][] ans = new int[k][k];
        int[] degr = new int[k+1], degc = new int[k+1];
        List<Integer>[] gr = new List[k+1], gc = new List[k+1];
        for (int i = 0;i <= k;i++){
            gr[i] = new ArrayList<>();
            gc[i] = new ArrayList<>();
        }
        for (int[] t : row){
            degr[t[1]]++;
            gr[t[0]].add(t[1]);
        }
        for (int[] t : col){
            degc[t[1]]++;
            gc[t[0]].add(t[1]);
        }
        int[] r = get(degr, gr, k), c = get(degc, gc, k);
        if (f == 1) return new int[0][0];
        for (int i = 1;i <= k;i++){
            ans[r[i]][c[i]] = i;
        }
        for (int i = 0;i < k;i++){
            for (int j = 0;j < k;j++){
                System.out.print(ans[i][j]+" ");
            }System.out.println();
        }
        return ans;
    }
}