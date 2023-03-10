import java.util.*;
import java.io.*;

public class Main {
    static String ss, io[];
    static int test, N = 200010, M = 1000000007;
    static int n, ans;
    static int[] dx={1,0,0,-1}, dy={0,-1,1,0};
    static int[][] g = new int[101][101], v = new int[101][101];
    static void solve(){
        n = sc.nextInt(); sc.nextLine();
        int stx = 0, sty = 0;
        for(int i = 1;i <= n;i++){
            String[] c = sc.nextLine().split(" ");
            for (int j = 1;j <= n;j++){
                v[i][j] = -1;
                char cur = c[j-1].charAt(0);
                if (cur == '+') g[i][j] = 1;
                else if (cur == '-') g[i][j] = -1;
                else if (cur == 'B') g[i][j] = 2;
                else{
                    g[i][j] = 3;
                    stx = i; sty = j;
                }
            }
        }
        Deque<int[]> d = new LinkedList<>();
        d.offerLast(new int[]{stx, sty});
        while (!d.isEmpty()){
            int s = d.size();
            while (s-- > 0){
                int[] cur = d.pollFirst();
                int x = cur[0], y = cur[1];
                if (v[x][y] != -1) continue;
                v[x][y] = 1;
                for (int k = 0;k < 4;k++){
                    int nx = x+dx[k], ny = y+dy[k];
                    if (nx<1||ny<1||nx>n||ny>n||v[nx][ny]==1) continue;
                    if (g[nx][ny] == 2){
                        System.out.println(ans+1);
                        return;
                    }
                    if (ans==0 || g[x][y]+g[nx][ny]==0) {
                        d.offerLast(new int[]{nx, ny});
                    }
                }
            }
            ans++;
        }
        System.out.println(-1);
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