import java.util.*;

import javax.management.Query;

import java.io.*;
import java.security.GeneralSecurityException;

public class Main {
    static String ss, io[];
    static int test, N = 200010, M = 1000000007;
    static int n, c;
    static long a[] = new long[N], cost[][] = new long[N][2];
    static void solve() throws Exception{
        n = ni(); c = ni();
        Arrays.fill(a, 0);
        for (int i = 1;i <= n;i++) cost[i] = new long[]{0, 0};
        for (int i = 1;i <= n;i++) a[i] = ni();
        for (int i = 1;i <= n;i++){
            cost[i][0] = min(i+a[i], n-i+1+a[i]);
            cost[i][1] = i;
        }
        Arrays.sort(cost, 1, n+1, (x,y)->Long.compare(x[0], y[0]));
        for (int i = 1;i <= n;i++) cost[i][0] += cost[i-1][0];
        int ans = 0;
        for (int i = 1;i <= n;i++){
            int l = 1, r = n, dx = i;
            long first = cost[i][1]+a[(int)cost[i][1]];
            if (first > c) continue;
            while (l <= r){
                int m = l+r >> 1;
                long cur = cost[m][0];
                if (m < dx) cur += first;
                else cur += first-cost[dx][0]+cost[dx-1][0];
                if (cur <= c) l = m+1;
                else r = m-1;
            }
            ans = max(ans, r<dx?r+1:r);
        }out.println(ans);
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