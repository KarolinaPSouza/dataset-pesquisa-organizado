import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * https://cses.fi/problemset/task/1192
 */
public class entry_6158688 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = new Scanner(entry_6158688.class.getResourceAsStream("test_input.txt"));
        String s = scanner.nextLine();
        String[] s1 = s.split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        int[][] graph = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s2 = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                if (s2.charAt(j) == '.')
                    graph[i][j] = 1;
                else graph[i][j] = 0;
            }
        }
        System.out.println(roomCount(graph, n, m));
    }

    private static int roomCount(int[][] graph, int row, int col) {
        int ans = 0;
        int[][] dir = {{0, -1},{-1, 0}, {0, 1}, {1, 0}};
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 1) {
                    ans++;
                    bfs(graph, i, j, row, col, dir);
                }
            }
        }
        return ans;
    }

    private static class Pair<T, V> {
        T x;
        V y;
        Pair(T x, V y) {
            this.x = x;
            this.y = y;
        }
    }

    private static void bfs(int[][] graph, int i, int j, int row,
                            int col, int[][] dir) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(i, j));
        while (!q.isEmpty()){
            Pair<Integer, Integer> pair = q.poll();
            graph[pair.x][pair.y] = -1;
            for (int[] ints : dir) {
                int x = pair.x + ints[0];
                int y = pair.y + ints[1];
                if (x >= 0 && x < row && y >= 0 && y < col && graph[x][y] == 1){
                    graph[x][y] = 2;
                    q.add(new Pair<>(x, y));
                }
            }
        }
    }
}