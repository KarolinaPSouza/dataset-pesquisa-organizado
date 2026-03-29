import java.util.Scanner;

public class entry_12785235 {

    static int n, m;
    static char[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        grid = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }

        System.out.println(count);
        scanner.close();
    }

    static void dfs(int row, int col) {
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '#' || visited[row][col]) {
            return;
        }

        visited[row][col] = true;

        dfs(row + 1, col);
        dfs(row - 1, col);
        dfs(row, col + 1);
        dfs(row, col - 1);
    }
}