import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class entry_678375 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        PrintWriter pw = new PrintWriter(System.out);

        try {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            char[][] grid = new char[n][m];
            for(int i=0 ; i<n ; i++) {
                grid[i] = br.readLine().toCharArray();
            }

            boolean[][] vis = new boolean[n][m];

            int[] dx = new int[] {1, -1, 0, 0};
            int[] dy = new int[] {0, 0, 1, -1};

            int count = 0;
            for(int i=0 ; i<n ; i++) {
                for(int j=0 ; j<m ; j++) {
                    if(grid[i][j] == '.' && !vis[i][j]) {
                        count++;
                        LinkedList<Pair> ll = new LinkedList<>();
                        ll.add(new Pair(i, j));
                        vis[i][j] = true;

                        while(!ll.isEmpty()) {
                            Pair p = ll.poll();

                            for(int d=0 ; d<4 ; d++) {
                                int nx = p.x+dx[d];
                                int ny = p.y+dy[d];
                                if(bound(nx, ny, n, m) && grid[nx][ny] == '.' && !vis[nx][ny]) {
                                    vis[nx][ny] = true;
                                    ll.add(new Pair(nx, ny));
                                }
                            }
                        }
                    }
                }
            }

            pw.println(count);
        }
        finally {
            pw.flush();
            pw.close();
        }
    }

    static boolean bound(int x, int y, int n, int m) {
        return x>=0 && x<n && y>=0 && y<m;
    }
}

class Pair {
    int x;
    int y;
    Pair(int a, int b) {
        x = a;
        y = b;
    }
}