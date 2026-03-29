import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

public class entry_12007708 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // Read the first line for n and m
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] arr = new char[n][m];

        // Read the grid input line by line
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            arr[i] = line.toCharArray();
        }

        int count = 0;

        // Count non-# regions and apply flood fill
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] != '#') {
                    count++;
                    floodFillBFS(arr, i, j);
                }
            }
        }

        System.out.println(count);
    }

    // Directions: left, right, down, up
    static int[][] dir = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};

    // Iterative Flood Fill using BFS
    public static void floodFillBFS(char[][] arr, int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        arr[i][j] = '#'; // Mark as visited

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];

            for (int[] d : dir) {
                int newX = x + d[0];
                int newY = y + d[1];

                if (newX >= 0 && newX < arr.length && newY >= 0 && newY < arr[0].length && arr[newX][newY] != '#') {
                    arr[newX][newY] = '#'; // Mark as visited
                    queue.add(new int[]{newX, newY});
                }
            }
        }
    }
}