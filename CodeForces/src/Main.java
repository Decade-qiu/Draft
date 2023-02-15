import java.util.*;

import javax.management.Query;

import java.io.*;
import java.lang.reflect.Array;
import java.security.GeneralSecurityException;

public class Main {
    static String ss, io[];
    static int test, N = 2010, M = 1000000007;
    static int n, m, c[] = new int[N], dis[][] = new int[N][N];
    static List<Integer>[] g = new List[N];
    static void solve() throws Exception{
        n = ni(); m = ni();
        for (int i = 1;i <= n;i++){
            g[i] = new ArrayList<>();
            for (int j = 1;j <= n;j++) dis[i][j] = -1;
        }
        for (int i = 1;i <= n;i++) c[i] = ni();
        for (int i = 1;i <= m;i++){
            int u = ni(), v = ni();
            g[u].add(v);
            g[v].add(u);
        }
        Deque<int[]> d = new LinkedList<>();
        d.offerLast(new int[]{1, n});
        dis[1][n] = 0;
        while (!d.isEmpty()){
            int[] cur = d.pollFirst();
            int x = cur[0], y = cur[1];
            for (int nx : g[x]){
                for (int ny : g[y]){
                    if (c[nx] != c[ny] && dis[nx][ny] == -1){
                        dis[nx][ny] = dis[x][y]+1;
                        d.offerLast(new int[]{nx, ny});
                    }
                }
            }
        }out.println(dis[n][1]);
    }
    public static void main(String[] args) throws Exception {
        // test = 1;
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