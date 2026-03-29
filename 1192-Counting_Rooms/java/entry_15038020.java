import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class entry_15038020 {

    static int n;
    static int m;
    static char[][] matrix;
    static boolean[][] isVisited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); // height
        m = sc.nextInt(); // width
        matrix = new char[n][m];
        sc.nextLine();

        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            for(int j = 0; j < m; j++){
                matrix[i][j] = line.charAt(j);
            }
        }
        isVisited = new boolean[n][m];
        // no of connected components;
        // dfs
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isVisited[i][j] == false && matrix[i][j] == '.'){
                    bfs(i, j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void bfs(int x, int y){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x, y});
        isVisited[x][y] = true;

        while(!queue.isEmpty()){
            int[] curr = queue.poll();
            for(int d = 0; d < 4; d++){
                int xx = curr[0] + dx[d];
                int yy = curr[1] + dy[d];

                if(xx >= 0 && xx < n && yy >= 0 && yy < m && isVisited[xx][yy] == false && matrix[xx][yy] == '.'){
                    isVisited[xx][yy] = true;
                    queue.add(new int[] {xx, yy});
                }
            }
        }
    }


}