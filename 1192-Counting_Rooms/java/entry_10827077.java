import java.util.*;

class Pair {
    int first;
    int second;
    Pair(int x, int y) {
        this.first = x;
        this.second = y;
    }
}

class Graph {
    char[][] grid;
    int[][] visited;

    // Constructor to initialize the graph with dynamic size based on input
    Graph(int n, int m) {
        grid = new char[n][m];
        visited = new int[n][m];
    }

    // DFS function to explore connected components
    void DFS(int i, int j, int n, int m) {
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(i, j));
        while (!s.isEmpty()) {
            Pair p = s.pop();
            int u = p.first;
            int v = p.second;

            if (u + 1 < n && visited[u + 1][v] == 0 && grid[u + 1][v] == '.') {
                visited[u + 1][v] = 1;
                s.push(new Pair(u + 1, v));
            }

            if (u - 1 >= 0 && visited[u - 1][v] == 0 && grid[u - 1][v] == '.') {
                visited[u - 1][v] = 1;
                s.push(new Pair(u - 1, v));
            }

            if (v - 1 >= 0 && visited[u][v - 1] == 0 && grid[u][v - 1] == '.') {
                visited[u][v - 1] = 1;
                s.push(new Pair(u, v - 1));
            }

            // Corrected boundary check here
            if (v + 1 < m && visited[u][v + 1] == 0 && grid[u][v + 1] == '.') {
                visited[u][v + 1] = 1;
                s.push(new Pair(u, v + 1));
            }
        }
    }
}

public class entry_10827077 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        input.nextLine();
        Graph g = new Graph(n, m);

        // Read grid row by row
        for (int i = 0; i < n; i++) {
            String row = input.nextLine();
            for (int j = 0; j < m; j++) {
                g.visited[i][j]=0;
                g.grid[i][j] = row.charAt(j);
            }
        }


        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g.grid[i][j] == '.' && g.visited[i][j] == 0) {
                    count++;
                    g.DFS(i, j, n, m);
                }
            }
        }

        System.out.println(count);
        input.close();
    }
}