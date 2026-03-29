import java.util.*;
import java.io.*;

public class entry_12639862 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] grid = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        boolean[][] visited = new boolean[n][m];
        int roomCount = 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !visited[i][j]) {
                    roomCount++;

                    Stack<int[]> stack = new Stack<>();
                    stack.push(new int[]{i, j});
                    visited[i][j] = true;

                    while (!stack.isEmpty()) {
                        int[] current = stack.pop();
                        int x = current[0];
                        int y = current[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < n && ny >= 0 && ny < m &&
                                    grid[nx][ny] == '.' && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                stack.push(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        System.out.println(roomCount);
    }
}