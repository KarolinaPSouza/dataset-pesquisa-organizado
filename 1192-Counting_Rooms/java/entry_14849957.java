import java.util.*;
class Pair {
    int first;
    int second;
    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class BFS {
    public static void bfsTraversal(char[][] edges , boolean[][] visited , int row , int col) {
        Queue<Pair> queue = new LinkedList<>();
        visited[row][col] = true;
        queue.add(new Pair(row, col));

        int[] delRow = {-1, 1, 0, 0};
        int[] delCol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {
            int rowN = queue.peek().first;
            int colN = queue.peek().second;
            queue.remove();

            for(int i = 0 ; i < 4 ; i++) {
                int Nrow = rowN + delRow[i];
                int Ncol = colN + delCol[i];

                if(Nrow >= 0 && Nrow < edges.length && Ncol >= 0 && Ncol < edges[0].length
                        && edges[Nrow][Ncol] == '.' && !visited[Nrow][Ncol]) {
                    visited[Nrow][Ncol] = true;
                    queue.add(new Pair(Nrow, Ncol));
                }
            }
        }
    }
}
public class entry_14849957 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] edges = new char[n][m];
        for(int i = 0 ; i < n ; i++) {
            String line = sc.next();
            for(int j = 0 ; j < m ; j++) {
                edges[i][j] = line.charAt(j);
            }
        }
        boolean[][] visited = new boolean[n][m];
        for(boolean[] row : visited) {
            Arrays.fill(row, false);
        }
        int ans = 0;
        for(int i = 0 ; i < n ; i++) {
            for(int j = 0 ; j < m ; j++) {
                if(edges[i][j] == '.' && !visited[i][j]) {
                    ans++;
                    BFS.bfsTraversal(edges, visited, i, j);
                }
            }
        }
        System.out.println(ans);
    }
}