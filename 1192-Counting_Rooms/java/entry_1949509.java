import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_1949509 {

    static int rows, columns;
    static char[][] grid;
    static boolean[][] visited;
    static int roomCounter;

    public static void floodfill(int r, int c) {
        if (!(r >= 0 && r < rows && c >= 0 && c < columns)) return;
        if (visited[r][c]) return;
        if (grid[r][c] == '#') return;

        visited[r][c] = true;

        floodfill(r - 1, c);
        floodfill(r + 1, c);
        floodfill(r, c - 1);
        floodfill(r, c + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        columns = Integer.parseInt(st.nextToken());

        grid = new char[rows][columns];
        for (int i = 0; i < rows; i++) {
            String line = br.readLine();
            for (int j = 0; j < columns; j++) {
                grid[i][j] = line.charAt(j);
            }
        }
        br.close();

        visited = new boolean[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (!visited[i][j] && grid[i][j] != '#') {
                    floodfill(i, j);
                    roomCounter++;
                }
            }
        }

        pw.println(roomCounter);
        pw.close();
    }
}