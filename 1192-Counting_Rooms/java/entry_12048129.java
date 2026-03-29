import java.util.*;
import java.io.*;

public class entry_12048129 {

    static int dx[] = new int[] {0,0,1,-1};
    static int dy[] = new int[] {1,-1,0,0};

    public static void main(String [] args) throws IOException{

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n,m;
        String[] parts = reader.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        m = Integer.parseInt(parts[1]);
        List<String> building = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            building.add(reader.readLine());
        }

        System.out.println(countRooms(building, n, m));

    }


    static int countRooms(List<String> building, int n, int m) {

        char [][] map = new char[n][m];

        for(int i = 0;i<n;i++) {
            map[i] = building.get(i).toCharArray();
        }

        int cnt = 0;

        for(int i = 0;i<n;i++) {
            for(int j = 0;j<m;j++) {
                if(map[i][j]=='.') {
                    bfs(i,j,n,m,map);
                    cnt++;
                }
            }
        }
        return cnt;

    }

    // As input size is large using this dfs givig the TLE and stack overflow for large Testcase
    // to solve this we can use the BFS or DFS in iterative way
    static void dfs(int i, int j, int n, int m, char[][] map) {

        if(i<0 || j<0 || i>=n || j>=m || map[i][j]=='#') return;

        map[i][j] = '#';

        for(int dir = 0; dir<4; dir++) {

            int newX = i + dx[dir];
            int newY = j + dy[dir];
            dfs(newX, newY, n, m, map);
        }
    }

    static void bfs(int i, int j, int n, int m, char [][]map) {

        Queue<int [] > q = new LinkedList<>();
        q.offer(new int[]{i,j});
        map[i][j] = '#';

        while(!q.isEmpty()) {

            int [] p = q.poll();

            for(int dir = 0; dir<4; dir++) {

                int newX = p[0] + dx[dir];
                int newY = p[1] + dy[dir];

                if(newX>=0 && newY>=0 && newX<n && newY<m && map[newX][newY]=='.') {
                    map[newX][newY] = '#';
                    q.offer(new int[] {newX, newY});
                }
            }

        }

    }




}