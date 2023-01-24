import java.util.*;import java.io.*;
import java.util.stream.IntStream;

public class Main {
    static String ss, io[];
    static int test, N = 100010, M = 1000000007;
    static int n;
    static void solve() throws Exception{
        n = ni(in.readLine());
        int ans = 0, m = 0;
        String s = "";
        for (int i = 1;i <= n;i++){
            ss = in.readLine();
            int t = ss.length();
            for (int j = 1;j < t-1;j++){
                if (ss.charAt(j)=='w'&&ss.charAt(j-1)=='o'&&ss.charAt(j+1)=='o') ans++;
            }
            for(int j = -1;j < n;j++) s[j] += 2;
            if (m==0) s = ss;
            else{
                char s1=s.charAt(0), s2=s.charAt(m-1);
                char t1=ss.charAt(0), t2=ss.charAt(t-1);
                int tp = 0, f = 0, ff = 0;
                if (s2=='o'&&t1=='w'){
                    if (t>1&&ss.charAt(1)=='o') {tp = 1;}
                }if (s2=='w'&&t1=='o'){
                    if (m>1&&s.charAt(m-2)=='o') {tp = 1;}
                }if (t2=='o'&&s1=='w'){
                    ff = 1;
                    if (m>1&&s.charAt(1)=='o') {tp=1;f=1;}
                }if (t2=='w'&&s1=='o'){
                    ff = 1;
                    if (t>1&&ss.charAt(t-2)=='o') {tp=1;f=1;}
                }
                if (tp == 1) ans++;
                if (f == 1 || ff == 1) s = ss+s;
                else s += ss;
            }
            m += t;
            out.println(ans+" "+s);
        }
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