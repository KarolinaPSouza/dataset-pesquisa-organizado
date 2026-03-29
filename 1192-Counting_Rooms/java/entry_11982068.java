import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class entry_11982068 {

    static void bfs(int r, int c, int n, int m, char[][] arr, boolean[][] vis){
        vis[r][c] = true;
        int dr[] = {-1, 1, 0, 0};
        int dc[] = {0, 0, -1, 1};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        while(!q.isEmpty()){
            int[] cell = q.poll();
            for(int i = 0; i < 4; i++){
                int newR = dr[i] + cell[0];
                int newC = dc[i] + cell[1];
                if(newR >= 0 && newR < n && newC >= 0 && newC < m && arr[newR][newC] == '.' && !vis[newR][newC]){
                    vis[newR][newC] = true;
                    q.add(new int[]{newR, newC});
                }      
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] arr = new char[n][m];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine().toCharArray(); 
        }

        boolean vis[][] = new boolean[n][m];
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == '.' && !vis[i][j]){
                    bfs(i , j, n, m, arr, vis);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}