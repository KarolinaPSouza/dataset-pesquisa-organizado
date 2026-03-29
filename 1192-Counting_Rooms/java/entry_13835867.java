import java.util.*;

class B {

    public static void bfs(int[] node, int[][] movement, boolean[][] visited, char[][] board, Queue<int[]> queue) {
        visited[node[0]][node[1]] = true;
        queue.add(new int[]{node[0], node[1]});
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            for (int[] mov : movement) {
                int nx = x + mov[0];
                int ny = y + mov[1];
                if (nx >= 0 && ny >= 0 && nx < board.length && ny < board[0].length &&
                        !visited[nx][ny] && board[nx][ny] == '.') {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static int solve(char[][] board) {
        if (board == null || board.length == 0) return 0;

        int m = board.length;
        int n = board[0].length;
        int[][] movement = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean[][] visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.' && !visited[i][j]) {
                    count++;
                    bfs(new int[]{i, j}, movement, visited, board, queue);
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        input.nextLine();

        char[][] board = new char[m][n];
        for (int i = 0; i < m; i++) {
            String line = input.nextLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int ans = solve(board);
        System.out.println(ans);
    }
}