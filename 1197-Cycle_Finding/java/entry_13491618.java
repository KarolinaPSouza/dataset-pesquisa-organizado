import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class entry_13491618 {

    static List<Edge> edges;
    static long dist[];
    static int totalNodes;
    static int lastNode;
    static int parent[];
    static boolean vis[];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        edges = new ArrayList<>();
        dist = new long[n + 1];
        totalNodes = n;
        lastNode = n;
        vis = new boolean[totalNodes+1];

        for (int i = 0; i <= n; i++)
            dist[i] = Long.MAX_VALUE;

        for (int i = 1; i <= m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int wt = scanner.nextInt();
            edges.add(new Edge(u, v, wt));
        }

        // calculates single source sortest path
        boolean negativeCycleFound = false;
        for(int i=1; i<=totalNodes; i++) {
          // evaluating cycle in isolated components.
          if(!vis[i]) {
            dist[i] = 0;
            negativeCycleFound = print_negative_cycle_Bellman_ford();
            if(negativeCycleFound) break;
            dist[i] = Long.MAX_VALUE;
          }
        }

       if(!negativeCycleFound) 
          System.out.println("NO");

    }

    // modified bellman ford from given node 
    static boolean print_negative_cycle_Bellman_ford() {

        parent = new int[totalNodes + 1]; // stores parent in minimum dist path

        // basic bellman ford decreasing path distance N-1 times
        for (int i = 0; i < totalNodes - 1; i++) {
            boolean changed = false;
            for (Edge e : edges) {
                if (dist[e.u] != Long.MAX_VALUE && dist[e.u] + e.wt < dist[e.v]) {
                    dist[e.v] = dist[e.u] + e.wt;
                    parent[e.v] = e.u;
                    changed = true;
                }
            }
            if(!changed) return false;
        }

        Integer affectedNode = null;
        // iterate once more to check if there is a cycle
        for (Edge e : edges) {
            if (dist[e.u] != Long.MAX_VALUE && dist[e.u] + e.wt < dist[e.v]) {
                // this is node path distance has decreased due to cycle. 
                parent[e.v] = e.u;
                affectedNode = e.u; 
            }
        }

        if( affectedNode == null) {
            // System.out.println("NO");
            return false;
        }


        // travese the parent chain untill we get the node which is already visited.
        int currNode = affectedNode;
        vis[currNode] = true;
        while( vis[parent[currNode]] == false ) {
             vis[parent[currNode]] = true;
             currNode = parent[currNode];
        }

        int cycleStart = currNode;
        ArrayList<Integer> cycleNodes = new ArrayList<>();
        cycleNodes.add(currNode);
        currNode = parent[currNode];

        while( currNode != cycleStart ) {
            cycleNodes.add(currNode);
            currNode = parent[currNode];
        }

        cycleNodes.add(cycleStart);
        System.out.println("YES");
        for(int i=cycleNodes.size()-1; i>=0; i--) {
            System.out.print(cycleNodes.get(i) + " ");
        }
        return true;

    }
}

class Edge {
    int u;
    int v;
    int wt;

    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.wt = weight;
    }
}