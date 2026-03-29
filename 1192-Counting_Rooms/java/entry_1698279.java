import java.io.*;
import java.util.*;
import java.lang.*;

public class entry_1698279 {

    //CSES

    static boolean debug = false;

    static int n, m;
    static int[][] grid;
    static int rooms = 0;

    public static void main(String[] args) throws IOException {

        //BufferedReader f = new BufferedReader(new FileReader("entry_1698279.in"));
       BufferedReader f = new BufferedReader(new InputStreamReader(System.in));

        //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("entry_1698279.out")));

        StringTokenizer st = new StringTokenizer(f.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new int[n][m];

        for(int i = 0; i < n ; i++)
        {
            String s = f.readLine();
            for(int j = 0; j < m; j++)
            {
                char c = s.charAt(j);

                if(c == '#')
                {
                    grid[i][j] = 0;
                }
                else
                {
                    grid[i][j] = 1;
                }
            }
        }

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < m; j++)
            {
                if(grid[i][j] == 1)
                {
                    rooms++;
                    dfs(i,j);
                }
            }
        }

        System.out.println(rooms);

        f.close();

    }

    public static void dfs(int r, int c)
    {
        if(r < 0 || r >= n || c < 0 || c >= m) return;

        if(grid[r][c] != 1) return;

        grid[r][c] = 2;

        dfs(r, c+1);
        dfs(r+1, c);
        dfs(r, c-1);
        dfs(r-1, c);
    }
}