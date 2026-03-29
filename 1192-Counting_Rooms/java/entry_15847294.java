//package CSES;
import java.util.*;

public class entry_15847294 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        char[][] grid = new char[n][m];

        for(int i = 0; i < n; i++){
            String s = sc.next();
            for(int j = 0; j < m; j++){
                grid[i][j] = s.charAt(j);
            }
        }

        int[][] visited = new int[n][m];
        int count = 0;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(visited[i][j] == 0 && grid[i][j] == '.'){
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i, j});
                    visited[i][j] = 1;

                    while(!q.isEmpty()){
                        int[] coordinate = q.poll();
                        int row = coordinate[0];
                        int col = coordinate[1];

                        for(int d = 0; d < 4; d++){
                            int newRow = row + delRow[d];
                            int newCol = col + delCol[d];

                            if(newRow >= 0 && newCol >= 0 &&
                                    newRow < n && newCol < m &&
                                    visited[newRow][newCol] == 0 &&
                                    grid[newRow][newCol] == '.') {

                                visited[newRow][newCol] = 1;
                                q.add(new int[]{newRow, newCol});
                            }
                        }
                    }
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}