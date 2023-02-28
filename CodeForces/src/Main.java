import java.util.*;import java.io.*;

public class Main {
    static String ss, io[];
    static int test, N = 2010, M = 1000000007;
    static int n, m, fa[] = new int[N], rk[] = new int[N];
    static int find(int t){
        if (t == fa[t]) return t;
        return fa[t] = find(fa[t]);
    }
    static void solve() throws Exception{
        n = ni(); m = ni();
        for (int i = 1;i <= n;i++){
            fa[i] = i;
            rk[i] = 1;
        }
        int res = 0;
        for (int i = 1;i <= m;i++){
            int u = find(ni()), v = find(ni());
            if (u != v){
                rk[u] += rk[v];
                fa[v] = u;
            }
            res = Math.max(res, rk[u]-1);
            out.println(res);
        }
    }
    public static void main(String[] args) throws Exception {
        test = 1;
        // test = ni(in.readLine());
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