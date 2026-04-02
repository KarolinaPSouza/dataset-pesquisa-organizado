import java.util.*;
import java.io.*;



public class entry_10617953 {

    public static void main(String[] args) {
        FastScanner sc = new FastScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        for(int i=1; i<=n; i++) {
            graph.get(0).add(i);
        }

        int visited[] = new int[n+1];
        int prev[] = new int[n+1];

        int cycleFound = dfs(graph, visited, prev, 0, -1);
        // for(int i=0; i<prev.length; i++) {
        //     System.out.print(prev[i] + " ");
        // }
        // System.out.println();

        if(cycleFound == -1) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        LinkedList<Integer> result = new LinkedList<>();
        result.addFirst(cycleFound);
        int temp = prev[cycleFound];
        while(temp != cycleFound) {
            result.addFirst(temp);
            temp = prev[temp];
        }
        result.addFirst(cycleFound);

        StringBuilder s = new StringBuilder();
        s.append(result.size() + "\n");
        for(int num : result) {
            s.append(num + " ");
        } 
        System.out.println(s);

    }

    private static int dfs(List<List<Integer>> graph, int visited[], int prev[], int node, int prevNode) {
        if(visited[node] == 2) {
            return -1;
        }

        if(visited[node] == 1) {
            prev[node] = prevNode;
            return node;
        }

        visited[node] = 1;
        prev[node] = prevNode;
        for(int neighbor : graph.get(node)) {
            if(neighbor == prevNode) {
                continue;
            }
            int cycleFound = dfs(graph, visited, prev, neighbor, node);
            if(cycleFound != -1) {
                return cycleFound;
            }
        }
        visited[node] = 2;

        return -1;
    }

}

class FastScanner {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer("");

    String next() {
        while (!st.hasMoreTokens())
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    int[] readArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = nextInt();
        return a;
    }

    long nextLong() {
        return Long.parseLong(next());
    }
}
