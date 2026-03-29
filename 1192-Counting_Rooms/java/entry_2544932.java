import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_2544932 implements Runnable {
    static int dx[] = {-1,1,0,0};
    static int dy[] = {0,0,-1,1};
    public static void main(String arg[]) {
        new Thread(null, new entry_2544932(), "entry_2544932", 1<<28).start();
    }

    private static void dfs(boolean[][] visited, char[][] grid, int i, int j, int n, int m,int curDepth, int maxDepth) {
        if (curDepth > maxDepth) {
            return ;
        }
        visited[i][j] = true;
        for(int d=0;d<4;d++) {
            if(isValid(i+dx[d], j+dy[d], n, m) && grid[i+dx[d]][j+dy[d]] == '.' && !visited[i+dx[d]][j+dy[d]]) {
                dfs(visited,grid,i+dx[d],j+dy[d],n, m,curDepth + 1, maxDepth);
            }
        }
    }

    private static boolean isValid(int i, int j, int n,int m) {
        return i>=0 && i<n && j>=0 && j<m;
    }

    @Override
    public void run() {
        FastScanner fs = new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        char[][] grid = new char[n][m];
        for(int i=0;i<n;i++) {
            String s = fs.next();
            if(s.length() != m) {
                throw new RuntimeException("INPUT MISMATCH");
            }
            grid[i] = s.toCharArray();
        }
        int cnt=0;
        boolean [][] visited = new boolean[n][m];
        for (int i = 0; i < 100000; i++) {
            dfs(visited,grid,0,0,n,m,0, 0);
        }
        for(int i=0;i<n;i++) for(int j=0;j<m;j++) visited[i][j]=false;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!visited[i][j] && grid[i][j] == '.') {
                    dfs(visited,grid,i,j,n,m,0, Integer.MAX_VALUE);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }
}