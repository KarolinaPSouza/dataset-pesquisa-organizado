import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class entry_9071546 {

    static int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static int fun(int n, int m, char[][] arr) {

        boolean[][] vis = new boolean[n][m];
        int cnt = 0;

        for(int i = 0; i <n;i++){
            for(int j = 0; j <m;j++){
                if(arr[i][j] == '.' && !vis[i][j]){
                    cnt++;
                    // dfs(i, j, arr, vis);
                    bfs(i, j, arr, vis);
                }

            }
        }

        return cnt;
    }

    // public static void dfs(int i, int j, char[][] grid, boolean[][] vis) {
    //     if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '#' || vis[i][j]) {
    //         return;
    //     }

    //     vis[i][j] = true; // Mark the cell as visited

    //     // Explore neighboring cells
    //     dfs(i + 1, j, grid, vis);
    //     dfs(i - 1, j, grid, vis);
    //     dfs(i, j + 1, grid, vis);
    //     dfs(i, j - 1, grid, vis);
    // }

    public static void bfs(int i, int j, char[][] grid, boolean vis[][]){
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{i, j});

        vis[i][j] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();

            int x = curr[0];
            int y = curr[1];

            for(int[] dir : dirs){
                int newX = x + dir[0];
                int newY = y + dir[1];

                if(newX >= 0 && newY >= 0 && newX < grid.length && newY < grid[0].length && !vis[newX][newY] && grid[newX][newY] == '.'){
                    q.offer(new int[]{newX, newY});
                    vis[newX][newY] = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();


        char[][] grid = new char[n][m];

        for(int i = 0; i < n; i++){
            String line = sc.nextLine();
            for(int j = 0; j < m; j++){
                grid[i][j] = line.charAt(j);
            }
        }

        int rooms = fun(n, m, grid);
        System.out.println(rooms);
    }
}