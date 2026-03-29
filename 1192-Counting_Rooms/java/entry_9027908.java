import java.util.*;

public class entry_9027908 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // Altura del mapa
        int m = scanner.nextInt(); // Ancho del mapa
        scanner.nextLine(); // Consumir el salto de línea después de los enteros

        char[][] building = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                building[i][j] = line.charAt(j);
            }
        }

        int rooms = countRooms(building);
        System.out.println(rooms);
    }

    public static int countRooms(char[][] building) {
        int rooms = 0;
        boolean[][] visited = new boolean[building.length][building[0].length];
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < building.length; i++) {
            for (int j = 0; j < building[0].length; j++) {
                if (building[i][j] == '.' && !visited[i][j]) {
                    rooms++;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});

                    while (!queue.isEmpty()) {
                        int[] current = queue.poll();
                        int x = current[0];
                        int y = current[1];

                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (nx >= 0 && nx < building.length && ny >= 0 && ny < building[0].length && building[nx][ny] == '.' && !visited[nx][ny]) {
                                visited[nx][ny] = true;
                                queue.offer(new int[]{nx, ny});
                            }
                        }
                    }
                }
            }
        }

        return rooms;
    }
}