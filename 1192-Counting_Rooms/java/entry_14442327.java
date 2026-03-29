import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_14442327 {
    static char[][] grid; 
    static int n; 
    static int m; 
    static boolean[][] visited; 
    static int cnt; 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); 
        m = Integer.parseInt(st.nextToken()); 
        cnt = 0; 
        grid = new char[n][m]; 
        visited = new boolean[n][m]; 
        for (int i = 0; i < n; i++) {
            String line = br.readLine(); 
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j); 
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grid[i][j] == '.') {
                    floodfill(i, j, '.'); 
                    cnt++; 
                }
            }
        }
        pw.println(cnt); 
        pw.close(); 
    }

    private static void floodfill(int r, int c, char dot) {
  if ((r < 0 || r >= n || c < 0 || c >= m)  
      || grid[r][c] != dot                         
      || visited[r][c]  
  )
   return;

  visited[r][c] = true; 

  floodfill(r, c + 1, dot);
  floodfill(r, c - 1, dot);
  floodfill(r - 1, c, dot);
  floodfill(r + 1, c, dot);
 }
}