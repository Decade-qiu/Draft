import java.util.*;
import java.io.*;

public class Main {
    static String ss, io[];
    static int test, N = 200010, M = 1000000007;
    static int n, a[] = new int[N];
    static tr root = new tr();
    static void insert(int t){
        tr cur = root;
        for (int i = 2;i >= 0;i--){
            int x = (t>>i)&1;
            if (cur.cnt[x] == null) cur.cnt[x] = new tr();
            cur = cur.cnt[x];
        }
    }
    static int dfs(tr cur, int t){
        if (t == 0) return 0;
        tr one = cur.cnt[1], zero = cur.cnt[0];
        if (one != null && zero != null){
            return (1<<t)+min(
                dfs(cur.cnt[0], t-1),
                dfs(cur.cnt[1], t-1)
            );
        }else if (one != null){
            return dfs(cur.cnt[1], t-1);
        }else{
            return dfs(cur.cnt[0], t-1);
        }
    }
    static void solve() throws Exception{
        n = ni(); 
        for (int i = 1;i <= n;i++){
            int x = ni();
            insert(x);
        }out.println(dfs(root, 2));
    }
    static class tr{
        tr[] cnt = new tr[2];
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