import java.util.*;
import java.io.*;

public class Main {
    static String ss, io[];
    static int test, N = 200010, M = 1000000007;
    static int n, m;
    static void solve() throws Exception{
        n = sc.nextInt(); sc.nextLine();
        String s = sc.nextLine();
        long ans = 0, pa[] = new long[N*10], pb[] = new long[N*10];
        for (int i = 0;i < s.length();i++){
            pa[i+1] = pa[i];
            pb[i+1] = pb[i];
            if (i+5<=s.length() && s.substring(i, i+5).equals("Alice")){
                int cur = -1;
                if ((i==0||!Character.isLetter(s.charAt(i-1))) &&
                (i+5>=s.length()||!Character.isLetter(s.charAt(i+5)))) cur = i+5;
                if (cur != -1){
                    ans += pb[i]-pb[Math.max(0, i-n)];
                    pa[i+1]++;
                }
            }
            if (i+3<=s.length() && s.substring(i, i+3).equals("Bob")){
                int cur = -1;
                if ((i==0||!Character.isLetter(s.charAt(i-1))) &&
                (i+3>=s.length()||!Character.isLetter(s.charAt(i+3)))) cur = i+3;
                if (cur != -1){
                    ans += pa[i]-pa[Math.max(0, i-n)];
                    pb[i+1]++;
                }
            }
        }System.out.println(ans);
    }
    public static void main(String[] args) {
        try {
            test = 1;
            // test = ni(in.readLine());
            while (test-- > 0){
                solve();
            }out.flush();
            sc.close();
        } catch (Exception e) {System.out.println(e);}
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