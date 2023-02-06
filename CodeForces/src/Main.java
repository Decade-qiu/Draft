import java.util.*;import java.io.*;

public class Main {
    static String ss, io[];
    static int test, N = 100010, M = 1000000007;
    static void solve() throws Exception{
        int n = ni(); 
        long x = ni(), y = ni();
        long[] dp = new long[2*n+1];
        Arrays.fill(dp, (long)1e18);
        dp[0] = 0;
        for (int i = 0;i <= n;i++){
            dp[i] = min(dp[i], min(dp[i-1]+x, dp[i+1]+x));
            dp[i*2] = min(dp[i*2], dp[i]+y);
        }
        out.println(dp[n]);
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