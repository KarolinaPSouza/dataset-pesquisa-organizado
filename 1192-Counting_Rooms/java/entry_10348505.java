import java.util.*;

public class entry_10348505 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    sc.nextLine();

    char ch[][] = new char[n][m];

    for (int i = 0; i < n; i++) {
      String row = sc.nextLine();
      for (int j = 0; j < m; j++) {
        ch[i][j] = row.charAt(j);
      }
    }

    System.out.println(f(ch));
  }

  public static int f(char ch[][]) {
    int n = ch.length;
    int m = ch[0].length;

    int vis[][] = new int[n][m];
    int count = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < ch[i].length; j++) {
        if (vis[i][j] == 0 && ch[i][j] == '.') {
          count++;
          bfs(i, j, ch, vis);
        }
      }
    }
    return count;
  }

  public static void bfs(int x, int y, char ch[][], int vis[][]) {
    int dx[] = { -1, 1, 0, 0 };
    int dy[] = { 0, 0, -1, 1 };

    Queue<int[]> queue = new LinkedList<>();
    queue.add(new int[] { x, y });
    vis[x][y] = 1;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int cx = current[0];
      int cy = current[1];

      for (int i = 0; i < 4; i++) {
        int nx = cx + dx[i];
        int ny = cy + dy[i];

        if (nx >= 0 && nx < ch.length && ny >= 0 && ny < ch[0].length && vis[nx][ny] == 0 && ch[nx][ny] == '.') {
          vis[nx][ny] = 1;
          queue.add(new int[] { nx, ny });
        }
      }
    }
  }
}