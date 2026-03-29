import java.util.*;
import java.io.*;
public class entry_6682690 {
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] building = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int j = 0; j < m; j++) {
                building[i][j] = s.charAt(j);
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && building[i][j] == '.') {
                    count++;
                    floodFill(building, i, j);
                }
            }
        }
        System.out.println(count);
        br.close();
    }

    public static void floodFill(char[][] building, int i, int j) {
        if (i >= building.length || j >= building[0].length || i < 0 || j < 0 || visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (building[i][j] == '#') {
            return;
        }
        floodFill(building, i + 1, j);
        floodFill(building, i - 1, j);
        floodFill(building, i, j + 1);
        floodFill(building, i, j - 1);
    }

}