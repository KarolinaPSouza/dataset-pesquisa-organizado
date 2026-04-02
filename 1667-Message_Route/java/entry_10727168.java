import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class entry_10727168 {

    // static  long mod=998244353;
    static int mod = (int)(1e9 + 7);
    static boolean MULTI_CASE = false;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static char[] directions = {'L', 'U', 'R', 'D'};


   public static void solve() throws IOException {
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> arr = new ArrayList<>();
        for(int i = 0; i<=n; i++) arr.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            int f = sc.nextInt();
            int t = sc.nextInt();
            arr.get(f).add(t);
            arr.get(t).add(f);
        }

        int vis[] = new int[n + 1];
        Arrays.fill(vis, -1);

        int ans = bfs(arr, 1, vis, n);

        if(ans == -1)
            out.println("IMPOSSIBLE");
        else {
            List<Integer> tmp = new ArrayList<>();
            int curr = n;
            while(vis[curr] != 0) {
                tmp.add(curr);
                curr = vis[curr];
            }
            tmp.add(1);
            Collections.reverse(tmp);  
            out.println(tmp.size());
            for(int i: tmp) {
                out.print(i+" ");
            }


        }

    }

    public static int bfs(List<List<Integer>> arr, int node, int vis[], int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = 0;
        int steps = 1;
        while (!q.isEmpty()) {
            int k = q.size();
            steps++;
            while(k-- > 0) {
                int tmp = q.remove();

                if(tmp == n) return steps;

                for(int ch: arr.get(tmp)) {
                    if(vis[ch] == -1) {
                        q.add(ch);
                        vis[ch] = tmp;
                    }
                }
            }
        }

        return -1;  
    }

    public static void dfs(int c, List<List<Integer>> arr, int[] vis) {

        vis[c] = 1;

        for(int i: arr.get(c)) {
            if(vis[i] != 1) {
                dfs(i, arr, vis);
            }
        }

    }






    static void iterativeDFS(int x, int y, boolean dp[][], int n, int m) {
        Stack<int[]> st = new Stack<>();
        st.push(new int[]{x, y});
        dp[x][y] = false;

        while (!st.isEmpty()) {
            int[] current = st.pop();
            int tx = current[0];
            int ty = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = tx + dx[i];
                int ny = ty + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && dp[nx][ny] == true) {
                    st.push(new int[]{nx, ny});
                    dp[nx][ny] = false;
                }
            }
        }
    }

    public static void bfs(int x, int y, boolean dp[][], int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        dp[x][y] = false;
        while(q.size() > 0) {

            int[] tmp = q.remove();

            for(int i = 0; i<4; i++) {
                int nx = tmp[0] + dx[i];
                int ny = tmp[1] + dy[i];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m || dp[nx][ny] == false) continue;

                q.add(new int[]{nx, ny});
                dp[nx][ny] = false;
            }
        }
    }


    public static void decrementCountMap(Map<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            int count = map.get(key);
            if (count == 1) {
                map.remove(key);
            } else {
                map.put(key, count - 1);
            }
        }
    }

    public static void updateCountMap(Map<Integer, Integer> map, int key) {
        int count = 0;
        if (map.containsKey(key)) {
            count = map.get(key);
        }
        map.put(key, count + 1);
    }

    static long ncr(int n, int r) {
        long sum = 1l;
        for (int i = 1; i <= r; i++) {
            sum = sum * (n - r + i) / i;
        }
        return sum;
    }


    static long fact(int n) {
        return (n == 1 || n == 0) ? 1l : 1l * n * fact(n - 1);
    }

    static int mod_mul(int x, int y) {
        return (int)((long)((x % mod) * (y % mod)) % mod);
    }

    static int mod_add(int x, int y) {
        return (int)((long)((x % mod) + (y % mod)) % mod);
    }


    static long modinv(long x, long mod) {
        return fast_pow(x, mod - 2);
    }

    static long fast_pow(long a, long b) {
        if(b == 0)
            return 1L;

        long val = fast_pow(a, b / 2);

        if(b % 2 == 0)
            return val * val % mod;
        else 
            return val * val % mod * a % mod;
    }


    static boolean[] sieveOfEratosthenes(int n)
    {
        boolean prime[] = new boolean[n+1];
        for(int i=0;i<=n;i++)
            prime[i] = true;

        for(int p = 2; p*p <=n; p++)
        {
            if(prime[p] == true)
            {
                for(int i = p*p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        return prime;

    }


    static int gcdi(int a,int b)
    {
        if(b==0) return a;

        return gcdi(b,a%b);
    }

    static long gcdl(long a,long b)
    {
        if(b==0) return a;

        return gcdl(b,a%b);
    }

    static boolean isPrime(int n)
    {
        if (n <= 1) 
            return false; 

        if (n == 2 || n == 3) 
            return true; 

        if (n % 2 == 0 || n % 3 == 0) 
            return false; 

        for (int i = 5; i < Math.sqrt(n); i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
                return false; 

        return true; 

    }

    public static void main(String[] args) throws IOException {
        if (MULTI_CASE) {
          int T = sc.nextInt();
          for (int i = 0; i < T; ++i) {
            // if(i == 15) print = true;
            solve();
          }
        } 
        else {
          solve();
        }
        out.close();
    }

  static InputReader sc = new InputReader();
  static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

  static class InputReader {
    private StringTokenizer st;
    private BufferedReader bf;

    public InputReader() {
      bf = new BufferedReader(new InputStreamReader(System.in));
      st = null;
    }

    public String next() throws IOException {
      while (st == null || !st.hasMoreTokens()) {
        st = new StringTokenizer(bf.readLine());
      }
      return st.nextToken();
    }

    public String nextLine() throws IOException {
      return bf.readLine();
    }

    public int nextInt() throws IOException {
      return Integer.parseInt(next());
    }

    public long nextLong() throws IOException {
      return Long.parseLong(next());
    }

    public double nextDouble() throws IOException {
      return Double.parseDouble(next());
    }
  }
}
class Pair implements Comparable<Pair>  {
    int rideCnt;
    long wtSum;
    Pair(int a, long b) {
        rideCnt = a;
        wtSum = b;
    }

    @Override
    public int compareTo(Pair other) {

        return Integer.compare(this.rideCnt, other.rideCnt);
    }
}
class Node {
    long val;
    List<Node> child;

    Node(long a) {
        val = a;
        child = new ArrayList<>();
    }
}