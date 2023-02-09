import java.util.*;

import javax.management.Query;

import java.io.*;

public class Main {
    static String ss, io[];
    static int test, N = 100010, M = 1000000007;
    static int n, m, a[] = new int[N];
    static void solve() throws Exception{
        n = ni();
        for (int i = 1;i <= n;i++) a[i] = ni();
        int i = 2, j = n-1;
        while (i <= n && a[i]<=a[i-1]) ++i;
        while (j >= 1 && a[j]<=a[j+1]) --j;
        if (i > j){
            out.println("YES");
        }else{
            int f = 0;
            for (int k = i;k <= j && f == 0;k++){
                if (a[k] < a[k-1]) f = 1;
            }
            if (f == 0){
                if (a[j]-a[i-1] <= a[j+1]) out.println("YES");
                else out.println("NO");
                return;
            }
            for (int k = i;k <= j && f == 1;k++){
                if (a[k] > a[k-1]) f = 0;
            }
            if (f == 1){
                if (a[i]-a[j+1] <= a[i-1]) out.println("YES");
                else out.println("NO");
                return;
            }out.println("NO");
        }
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