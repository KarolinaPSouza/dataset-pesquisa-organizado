import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_13380613 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        Solution2 sol = new Solution2();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            adjList.get(u).add(new int[]{v, w});

        }


        sol.solve(adjList);

    }

}


class Solution2 {
    public void solve(List<List<int[]>> adjList) {
        int n = adjList.size() - 1;

        //for keeping track of shortest distance without any discount, and with one discount
        long[][] distance = new long[n+1][2];

        for(int i = 0; i <= n; i++) {
            Arrays.fill(distance[i], Long.MAX_VALUE);

        }
        distance[1][0] = 0;
        distance[1][1] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[]{1, 0, 0});

        while(!pq.isEmpty()) {
            int[] current = pq.remove();
            int u = current[0];
            int max = current[1];
            int isUsed = current[2];

            //if this node already has a better value
            if(distance[u][isUsed] < max) {
                continue;
            }

            for(int[] edge: adjList.get(u)) {
                int v = edge[0];
                int w = edge[1];

                //if discount not used, we can use it
                if(isUsed == 0) {
                    if(distance[v][1] > distance[u][0] + w/2) {
                        distance[v][1] = distance[u][0] + w/2;
                        pq.add(new int[]{v, (int) distance[v][1], 1});
                    }
                }

                //try normal way also, without the discount of the current edge
                if(distance[v][isUsed] > distance[u][isUsed] + w) {
                    distance[v][isUsed] = distance[u][isUsed] + w;
                    pq.add(new int[]{v, (int) distance[v][isUsed], isUsed});
                }

            }
        }

        System.out.println(distance[n][1]);

    }

}