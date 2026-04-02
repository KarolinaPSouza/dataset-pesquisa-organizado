import java.io.*;
import java.util.*;

public class entry_10914822 {
    static ArrayList<Integer>[] adjacencyList;
    static int[] team;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        // Use BufferedReader for faster input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());  // Number of pupils
        int m = Integer.parseInt(st.nextToken());  // Number of friendships

        adjacencyList = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        // Read all friendships
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList[a].add(b);
            adjacencyList[b].add(a);
        }

        team = new int[n + 1];
        Arrays.fill(team, -1);  // -1 means not yet colored
        isBipartite = true;

        // Check each component for bipartiteness
        for (int i = 1; i <= n; i++) {
            if (team[i] == -1) {  // Not yet visited
                if (!bfsColor(i)) {
                    isBipartite = false;
                    break;
                }
            }
        }

        if (isBipartite) {
            // Use StringBuilder for efficient output
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(team[i]).append(' ');
            }
            System.out.println(sb.toString().trim());
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static boolean bfsColor(int start) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);
        team[start] = 1;  // Start coloring with team 1

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int currentTeam = team[current];
            int oppositeTeam = (currentTeam == 1) ? 2 : 1;

            for (int neighbor : adjacencyList[current]) {
                if (team[neighbor] == -1) {  // If not colored
                    team[neighbor] = oppositeTeam;
                    queue.add(neighbor);
                } else if (team[neighbor] != oppositeTeam) {  // If already colored but not correctly
                    return false;
                }
            }
        }
        return true;
    }
}