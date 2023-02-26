import java.util.*;import java.io.*;

public class Main {
    static String ss, io[];
    static int test, N = 200010, M = 1000000007;
    static int n;
    static void solve() throws Exception{
        n = ni();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0;i < n;i++) {
            int c = ni();
            mp.put(c, mp.getOrDefault(c, 0)+1);
        }
        int m = mp.size(), dx = 0;
        int[][] a = new int[m][2];
        for (int k : mp.keySet()){
            a[dx][0] = k;
            a[dx++][1] = mp.get(k);
        }
        Arrays.sort(a, (x, y)->x[0]-y[0]);
        for (int[] tp : a) System.out.println(tp[0]+" "+tp[1]);
        int ans = 0;
        for (int i = 1;i < m;i++){
            int c = a[i][0], p = a[i-1][0];
            if (c != p+1){
                ans += a[i-1][1];
            }else{
                ans += max(a[i-1][1]-a[i][1], 0);
            }
        }
        out.println(ans+a[m-1][1]);
    }// 这样BFS每走一步时间不一定只增加1，所以需要用优先队列来获得当前最短的时间
    public static void main(String[] args) throws Exception {
        test = 1;
        test = ni(in.readLine());
        while (test-- > 0){
            solve();
        }out.flush();
    }
    static int ni() throws IOException{input.nextToken();return (int) input.nval;}
    static long nl() throws IOException{input.nextToken();return (long) input.nval;}
    static int ni(String x) {return Integer.parseInt(x);}
    static long nl(String x) {return Long.parseLong(x);}
    static int max(int a, int b) {return a > b ? a : b;}
    static long max(long a, long b) {return a > b ? a : b;}
    static int min(int a, int b) {return a < b ? a : b;}
    static long min(long a, long b) {return a < b ? a : b;}
    static int lg2(long a) {return (int)Math.ceil((Math.log(a)/Math.log(2)));}
    static int abs(int a) {return a > 0?a:-a;}
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer input = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}  