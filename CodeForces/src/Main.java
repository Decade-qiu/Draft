import java.util.*;

import java.io.*;
import java.math.BigInteger;

public class Main {
    static String ss, io[];
    static int test, N = 200010, M = 1000000007;
    static int n, m;
    static void solve() throws IOException{
        io = sc.nextLine().split(" ");
        String x = io[0], y = io[1];
        BigInteger ans = new BigInteger(y).subtract(new BigInteger(x)).subtract(new BigInteger("1"));
        BigInteger mi = new BigInteger("2");
        mi = mi.pow(ni(x)).multiply(new BigInteger("2")).subtract(new BigInteger("1"));
        ans = ans.divide(mi).add(new BigInteger("1"));
        System.out.println(ans);
    }
    public static void main(String[] args) throws Exception{
        // try {
            test = 1;
            // test = ni(in.readLine());
            while (test-- > 0){
                solve();
            }out.flush();
            sc.close();
        // } catch (Exception e) {e.getStackTrace();}
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
    static Scanner sc = new Scanner(System.in);
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer input = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
}  