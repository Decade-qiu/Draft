import java.util.*;
import java.io.*;

public class Main {
    static String ss, io[];
    static int test, N = 200010, M = 1000000007;
    static int n, m;
    static void solve() throws Exception{
        long t = nl();
        int cnt[][] = new int[(int)1e6][2], len = 0;
        for (int i = 2;(long)i*i <= t;i++){
            if (t % i == 0){
                cnt[len][0] = i;
                while (t % i == 0){
                    cnt[len][1]++;
                    t /= i;
                }len++;
            }
        }
        if (t != 1){
            cnt[len][0] = (int)t;
            cnt[len][1] = 1;
            len++;
        }
        long ans = 1;
        for (int i = 0;i < len;i++){
            System.out.println(cnt[i][0]+" "+cnt[i][1]);
            if (cnt[i][1]%2 == 1) ans *= cnt[i][0];
        }
        out.println(ans);
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