import java.util.*;

public class entry_14627134 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();

        char[][] map = new char[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = sc.nextLine().toCharArray();
        }

        int count = 0;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (map[i][j] == '.' && !visited[i][j]) {
                    count++;

                    Stack<int[]> s = new Stack<>();
                    s.push(new int[]{i, j});
                    visited[i][j] = true;

                    while (!s.isEmpty()) {
                        int[] current = s.pop();
                        int x = current[0];
                        int y = current[1];

                        for (int d = 0; d < 4; d++) {
                            int newX = x + dx[d];
                            int newY = y + dy[d];

                            if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                                if (map[newX][newY] == '.' && !visited[newX][newY]) {
                                    visited[newX][newY] = true;
                                    s.push(new int[]{newX, newY});
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}