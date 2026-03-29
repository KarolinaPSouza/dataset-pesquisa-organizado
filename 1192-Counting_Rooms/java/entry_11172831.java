import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class entry_11172831 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] ranges = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = ranges[0] , m = ranges[1];
        char[][] matrix = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        for(int i = 0;i<n;i++){
            matrix[i] = reader.readLine().toCharArray();
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == '.'){
                    visited[i][j] = true;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(visited[i][j]){
                    res++;
                    dfs(visited, i, j);
                }
            }
        }
        System.out.println(res);
    }

    private static void dfs(boolean[][] visited, int i, int j) {
        if(!visited[i][j]){
            return;
        }
        visited[i][j] = false;
        if(i+1 < visited.length ){
            dfs(visited, i+1, j);
        }
        if (j+1 < visited[0].length ) {
            dfs(visited,i,j+1);
        }
        if(i-1 >= 0) {
            dfs(visited, i - 1, j);
        }
        if(j-1 >= 0){
            dfs(visited, i, j - 1);
        }
    }

}