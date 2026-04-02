// import java.util.*;

// public class entry_12828036 {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt(); // number of computers
//         int m = sc.nextInt(); // number of connections

//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) {
//             adj.add(new ArrayList<>());
//         }

//         for (int i = 0; i < m; i++) {
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             adj.get(a).add(b);
//             adj.get(b).add(a);
//         }

//         boolean[] visited = new boolean[n + 1];
//         int[] parent = new int[n + 1];
//         Queue<Integer> q = new LinkedList<>();

//         q.add(1);
//         visited[1] = true;
//         parent[1] = -1;

//         while (!q.isEmpty()) {
//             int curr = q.poll();

//             for (int neighbor : adj.get(curr)) {
//                 if (!visited[neighbor]) {
//                     visited[neighbor] = true;
//                     parent[neighbor] = curr;
//                     q.add(neighbor);
//                 }
//             }
//         }

//         if (!visited[n]) {
//             System.out.println("IMPOSSIBLE");
//         } else {
//             List<Integer> path = new ArrayList<>();
//             int curr = n;
//             while (curr != -1) {
//                 path.add(curr);
//                 curr = parent[curr];
//             }

//             Collections.reverse(path);
//             System.out.println(path.size());
//             for (int node : path) {
//                 System.out.print(node + " ");
//             }
//             System.out.println();
//         }
//     }
// }


import java.io.*;
import java.util.*;

public class entry_12828036 {

    public static void main(String[] args) throws IOException {
        // Fast I/O
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // number of computers
        int m = Integer.parseInt(st.nextToken()); // number of connections

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Read all connections
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj.get(a).add(b);
            adj.get(b).add(a);
        }

        boolean[] visited = new boolean[n + 1];
        int[] parent = new int[n + 1];

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        parent[1] = -1;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    parent[neighbor] = node;
                    q.add(neighbor);
                }
            }
        }

        if (!visited[n]) {
            System.out.println("IMPOSSIBLE");
        } else {
            List<Integer> path = new ArrayList<>();
            int current = n;
            while (current != -1) {
                path.add(current);
                current = parent[current];
            }

            Collections.reverse(path);
            System.out.println(path.size());
            for (int p : path) {
                System.out.print(p + " ");
            }
            System.out.println();
        }
    }
}