import java.util.*;

public class entry_14639348 {
    static int height;
    static int width;
    static char[][] buildingMap;
    static boolean[][] visited;

    static int[] deltaRow = { 1, -1, 0, 0 };
    static int[] deltaCol = { 0, 0, 1, -1 };

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        height = sc.nextInt();
        width = sc.nextInt();
        sc.nextLine();

        buildingMap = new char[height][width];
        visited = new boolean[height][width];

        for (int row = 0; row < height; row++) {
            String line = sc.nextLine();
            buildingMap[row] = line.toCharArray();
        }

        int count = 0;

        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                if (buildingMap[row][col] == '.' && !visited[row][col]) {
                    bfs(row, col);
                    count++;
                }
            }
        }
        System.out.println(count);

    }

    static void bfs(int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            int row = current[0];
            int col = current[1];

            for(int i = 0; i<4; i++){
                int newRow = row + deltaRow[i];
                int newCol = col + deltaCol[i];
                if (newRow >= 0 && newRow < height &&
                    newCol >= 0 && newCol < width &&
                    buildingMap[newRow][newCol] == '.' &&
                    !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }
    }
}