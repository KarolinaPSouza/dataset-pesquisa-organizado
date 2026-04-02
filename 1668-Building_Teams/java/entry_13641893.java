import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class entry_13641893 {
    static class Pair {
        int curr;
        int team;

        Pair(int curr, int team) {
            this.curr = curr;
            this.team = team;
        }
    }
    public static boolean bfs(ArrayList<ArrayList<Integer>>adj,boolean []vis,int start,ArrayList<Integer>arr)
    {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start,1));
        vis[start] = true;
        arr.set(start,1);
        while (!q.isEmpty()) {
            Pair poll = q.poll();
            int team=poll.team;
            for (int neighbor : adj.get(poll.curr)) {
                if (!vis[neighbor]) {
                    q.add(new Pair(neighbor,team==1?2:1));
                    vis[neighbor] = true;
                    arr.set(neighbor,team==1?2:1);
                }
                else if (arr.get(neighbor)==team) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        // Fast input and output setup
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Read n and m
        String[] nm = br.readLine().split(" ");
        int n = Integer.parseInt(nm[0]);
        int m = Integer.parseInt(nm[1]);

        // Adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int u = Integer.parseInt(edge[0]);
            int v = Integer.parseInt(edge[1]);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n + 1];
        ArrayList<Integer> ans = new ArrayList<>(Collections.nCopies(n + 1, 0));
        boolean flag=true;
        for (int i=1;i<=n;i++)
        {
            if (!vis[i])
            {
                if (!bfs(adj,vis,i,ans))
                {
                    flag=false;
                    bw.write("IMPOSSIBLE");
                    break;
                }
            }
        }
if (flag) {
    for (int i = 1; i < ans.size(); i++) {
        bw.write(ans.get(i) + " ");
    }
}
        bw.flush();
        br.close();
        bw.close();
    }
}