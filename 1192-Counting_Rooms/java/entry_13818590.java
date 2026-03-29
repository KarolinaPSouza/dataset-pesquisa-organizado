import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_13818590 {
    static char[][] grid;
    static int numOfRooms;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        grid = new char[n][m];
        numOfRooms = 0;
        for(int i = 0; i < n; i++){
            String s = bufferedReader.readLine();
            for(int j = 0; j < m; j++){
                grid[i][j] = s.charAt(j);
            }
        }
        visited = new boolean[n][m];
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(!visited[i][j] && grid[i][j] == '.'){
                    floodfill(i,j);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
    public static void floodfill(int x, int y){
        if(x < 0 || y < 0 || x >= grid.length || y >= grid[0].length){
            return;
        }
        if(visited[x][y]){
            return;
        }
        if(grid[x][y] == '#'){
            return;
        }
        visited[x][y] = true;
        floodfill(x + 1, y);
        floodfill(x, y + 1);
        floodfill(x - 1, y);
        floodfill(x, y - 1);
    }
}