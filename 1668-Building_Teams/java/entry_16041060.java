import java.io.*;
import java.util.*;

public class entry_16041060 {

    static final int mod = 1_000_000_007;

    static int nextInt() throws Exception {
        int c, sign = 1, res = 0;
        while ((c = System.in.read()) <= ' ')
            ;
        if (c == '-') {
            sign = -1;
            c = System.in.read();
        }
        do {
            res = res * 10 + (c - '0');
        } while ((c = System.in.read()) > ' ');
        return res * sign;
    }

    public static void main(String[] args) throws Exception {

        int n = nextInt();
        int m = nextInt();

        ArrayList<Integer>[] adj = new ArrayList[n+1];

        for(int i=0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {

            int to = nextInt();
            int from = nextInt();

            adj[to].add(from);
            adj[from].add(to);
        }

        int[] team = new int[n+1];
        Arrays.fill(team, 0);

        for(int i=1; i <= n; i++) {

            if(team[i] == 0) {

                if(!bfs(i, adj, team)) {

                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }

        for(int i=1; i <= n; i++) {
            System.out.print(team[i] + " ");
        }
    }

    public static boolean bfs(int start, ArrayList<Integer>[] adj, int[] team) {

        Queue<Integer> q = new ArrayDeque<>();

        q.add(start);
        team[start] = 1;

        while(!q.isEmpty()) {

            int curr = q.poll();

            for(int neighbour: adj[curr]) {

                if(team[neighbour] == 0) {
                    team[neighbour] = 3 - team[curr];
                    q.offer(neighbour);
                }
                else if(team[neighbour] == team[curr]) {
                    return false;
                }
            }
        }
        return true;
    }
}