import java.util.*;import java.io.*;
import java.util.stream.IntStream;

public class Main {
    static String ss, io[];
    static int test, N = 100010, M = 1000000007;
    static int n, m;
    static void solve() throws Exception{
        n = ni(); m = ni();
        int[][][] dp = new int[n+m+1][n+1][m+1];
        dp[0][0][2] = 1;
        for (int i = 1;i <= n+m;i++){
            for (int j = 0;j <= min(i, n);j++){
                for (int k = 0;k <= m-i+j;k++){
                    if (j>0&&k%2==0) dp[i][j][k] = (dp[i][j][k]+dp[i-1][j-1][k/2])%M;
                    if (k+1 <= m) dp[i][j][k] = (dp[i][j][k]+dp[i-1][j][k+1])%M;
                }
            }
        }out.println(dp[n+m-1][n][1]);
    }
    public static void main(String[] args) throws Exception {
        test = 1;
        //test = ni(in.readLine());
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