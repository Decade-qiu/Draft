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
        String[] x = {"[1,0,1]", "[0,0,0]", "[[18,19],[3,12],[17,19],[2,13],[7,10]]"};
        System.out.println(new Solution().mostBooked(
                4, int2d(x[2])
        ));
    }
}

class Solution {
    public int mostBooked(int n, int[][] meetings) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x, y)->x[0]==y[0] ? x[1]-y[1] : x[0]-y[0]
        );
        Arrays.sort(meetings, (x, y)->x[0]==y[0] ? x[1]-y[1] : x[0]-y[0]);
        int[] cnt = new int[n];
        for (int i = 0;i < n;i++) pq.add(new int[]{-1, i});
        for (int[] c : meetings){
            List<int[]> tp = new ArrayList<>();
            while (!pq.isEmpty() && pq.peek()[0] <= c[0]){
                tp.add(pq.poll());
            }
            tp.sort((x, y)->x[1]-y[1]);
            for (int i = 1;i < tp.size();i++) pq.add(tp.get(i));
            int[] f = tp.get(0);
            cnt[f[1]]++;
            int st = Math.max(f[0], c[0]), last = c[1]-c[0];
            pq.add(new int[]{st+last, f[1]});
        }
        int max = 0;
        for (int i : cnt) max = Math.max(i, max);
        for (int i = 0;i < n;i++) if (cnt[i]==max) return i;
        return 0;
    }
}