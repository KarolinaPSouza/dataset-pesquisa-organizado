import java.util.*;
public class entry_11489144 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.nextLine();
        char[][] graph = new char[n][m];
        for(int i = 0;i<n;i++){
            String row = sc.nextLine();
            for(int j = 0;j<m;j++){
                graph[i][j] = row.charAt(j);
            }
        }

        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(graph[i][j]=='#'){
                    continue;
                }
                else{
                    count++;
                    visit(graph,i,j);
                }
            }
        }

        System.out.println(count);
        sc.close();
    }

    static void visit(char[][] graph, int i, int j) {
        int[] dr = {0, -1, 0, 1};
        int[] dc = {1, 0, -1, 0};
        int n = graph.length;
        int m = graph[0].length;

        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{i, j});
        graph[i][j] = '#'; // Mark as visited

        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int r = cell[0], c = cell[1];

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && graph[nr][nc] == '.') {
                    graph[nr][nc] = '#'; // Mark as visited
                    stack.push(new int[]{nr, nc});
                }
            }
        }
    }

}