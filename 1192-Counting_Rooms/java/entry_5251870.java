/*import java.io.DataInputStream;
import java.io.IOException;
import java.util.*;
import java.io.*;
public class entry_5251870 {
    public static char[][] map;
    public static boolean[][] visited;
    public static int count = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String[] input = in.readLine().trim().split("\\s");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String read = in.readLine().trim();
            for (int j = 0; j < m; j++) {
                map[i][j] = read.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && map[i][j] == '.') {
                    count++;
                    dfs(i, j, n, m);
                }
            }
        }
        System.out.println(count);
    }
    public static void dfs(int row, int col, int n, int m) {
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.add(row);
        queue.add(col);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            visited[x][y] = true;
            if (x + 1 < n && !visited[x + 1][y] && map[x + 1][y] == '.') {
                queue.add(x + 1);
                queue.add(y);
                //dfs(x + 1, y, n, m);
            }
            if (y + 1 < m && !visited[x][y + 1] && map[x][y + 1] == '.') {
                queue.add(x);
                queue.add(y + 1);
                //dfs(x, y + 1, n, m);
            }
            if (x - 1 >= 0 && !visited[x - 1][y] && map[x - 1][y] == '.') {
                queue.add(x - 1);
                queue.add(y);
                //dfs(x - 1, y, n, m);
            }
            if (y - 1 >= 0 && !visited[x][y - 1] && map[x][y - 1] == '.') {
                queue.add(x);
                queue.add(y - 1);
                //dfs(x, y - 1, n, m);
            }
        }
    }
}*/
import java.io.*;
import java.util.*;

public class entry_5251870 {
    public static final int R_CHANGE[] = {0, 1, 0, -1};
    public static final int C_CHANGE[] = {1, 0, -1, 0};

    private static boolean[][] visited;
    private static char[][] building;
    private static int rowNum;
    private static int colNum;

    public static void floodfill(int row, int col) {
        // Note: you can also use a queue and pop from the front for a BFS-based approach
        Stack<Pos> frontier = new Stack<>();
        frontier.push(new Pos(row, col));
        while(!frontier.isEmpty()){
            Pos curr = frontier.pop();
            row = curr.row;
            col = curr.col;

            if (row < 0 || row >= rowNum || col < 0 || col >= colNum
                    || building[row][col] == '#' || visited[row][col])
                continue;

            visited[row][col] = true;
            for (int i = 0; i < 4; i++) {
                frontier.add(new Pos(row + R_CHANGE[i], col + C_CHANGE[i]));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer dims = new StringTokenizer(read.readLine());
        rowNum = Integer.parseInt(dims.nextToken());
        colNum = Integer.parseInt(dims.nextToken());

        building = new char[rowNum][colNum];
        for (int r = 0; r < rowNum; r++){
            String row = read.readLine();
            for (int j = 0; j < colNum; j++){
                building[r][j] = row.charAt(j);
            }
        }

        visited = new boolean[rowNum][colNum];
        int roomNum = 0;
        for (int i = 0; i < rowNum; i++){
            for (int j = 0; j < colNum; j++){
                if (building[i][j] == '.' && !visited[i][j]) {
                    floodfill(i, j);
                    roomNum++;
                }
            }
        }
        System.out.println(roomNum);
    }
}

class Pos {
    int row;
    int col;
    public Pos(int row, int col) {
        this.row = row;
        this.col = col;
    }
}
