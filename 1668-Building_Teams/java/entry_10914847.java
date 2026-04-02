import java.io.*;
import java.util.*;

public class entry_10914847 {
    private static ArrayList<Integer>[] graph;
    private static int[] teams;
    private static final int UNASSIGNED = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        graph = new ArrayList[n + 1];
        for(int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<Integer>();
        }


        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }


        teams = new int[n + 1];
        Arrays.fill(teams, UNASSIGNED);


        boolean possible = true;
        for(int i = 1; i <= n; i++) {
            if(teams[i] == UNASSIGNED) {
                if(!bfs(i, 1, n)) {
                    possible = false;
                    break;
                }
            }
        }


        if(possible) {
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i <= n; i++) {
                sb.append(teams[i]).append(' ');
            }
            System.out.println(sb.toString().trim());
        }
        else {
            System.out.println("IMPOSSIBLE");
        }
    }

    private static boolean bfs(int start, int initialTeam, int n) {

        int[] queue = new int[n];
        int head = 0, tail = 0;
        queue[tail++] = start;
        teams[start] = initialTeam;

        while(head < tail) {
            int current = queue[head++];
            int currentTeam = teams[current];
            int oppositeTeam = 3 - currentTeam;

            for(int neighbor : graph[current]) {
                if(teams[neighbor] == UNASSIGNED) {
                    teams[neighbor] = oppositeTeam;
                    queue[tail++] = neighbor;
                }
                else if(teams[neighbor] != oppositeTeam) {

                    return false;
                }
            }
        }

        return true;
    }
}