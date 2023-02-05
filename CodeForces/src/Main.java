import java.util.*;import java.io.*;

public class Main {
    static String ss, io[];
    static int test, N = 100010, M = 1000000007;
    static int n, a[], dp[][];
    static void solve() throws Exception{
        n = ni();
        a = new int[n+1];
        dp = new int[n+1][3];
        for (int i = 1;i <= n;i++) a[i] = ni();
        for (int i = 1;i <= n;i++){
            int t = a[i];
            for (int j = 0;j < 3;j++) dp[i][j] = 1001;
            if (t==2 || t==3) dp[i][0] = min(dp[i-1][1], dp[i-1][2]);
            if (t==1 || t==3) dp[i][1] = min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] = min(dp[i-1][0], min(dp[i-1][1], dp[i-1][2]));
        }
        out.println(min(dp[n][0], min(dp[n][1], dp[n][2])));
    }
    public static void main(String[] args) throws Exception {
        test = 1;
        // test = ni(in.readLine());
        while (test-- > 0){
            solve();
        }
        out.flush();
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