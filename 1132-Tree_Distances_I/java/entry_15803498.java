import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class entry_15803498 {
    static List<Integer>[] tree;


    static int[] bfs(int start, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist,-1);

        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : tree[node]) {
                if (dist[nei]==-1) {
                    dist[nei] = dist[node] + 1;
                    q.add(nei);
                }
            }
        }
        return dist;
    }

    static int farthest(int[] dist){
        int max = 0;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > dist[max]){
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        tree = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }


        int[] dist1 = bfs(1,n);
        int A = farthest(dist1);

        int[] distA = bfs(A,n);
        int B = farthest(distA);

        int[] distB = bfs(B,n);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(distA[i],distB[i])).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}