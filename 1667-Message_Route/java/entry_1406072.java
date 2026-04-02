import java.io.*;
import java.util.*;

public class entry_1406072 {
    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(f.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        LinkedList<Integer>[] adj = new LinkedList[n+1];
        for(int i = 1; i<=n;i++) {
            adj[i] = new LinkedList<>();
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st1 = new StringTokenizer(f.readLine());
            int a = Integer.parseInt(st1.nextToken());
            int b = Integer.parseInt(st1.nextToken());
            adj[a].add(b);
            adj[b].add(a);
        }

        boolean[] visited = new boolean[n+1];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;

        int[] firstFrom = new int[n+1];

        while (queue.size() != 0) {
            int node = queue.poll();
            if (node == n) {
                break;
            }
            for (int a:adj[node]) {
                if (visited[a] == false) {
                    firstFrom[a] = node;
                    queue.add(a);
                    visited[a] = true;
                }
            }
        }



        if (firstFrom[n] == 0) {
            System.out.print("IMPOSSIBLE");
        } else {
            int counter = 1;
            LinkedList<Integer> q = new LinkedList<>();
            int p = n;
            while (p != 1) {
                q.push(p);
                p = firstFrom[p];
                counter++;
            }

            System.out.println(counter);

            System.out.print(1 + " ");
            while (q.size() != 0) {
                System.out.print(q.pop() + " ");
            }

        }

    }
}