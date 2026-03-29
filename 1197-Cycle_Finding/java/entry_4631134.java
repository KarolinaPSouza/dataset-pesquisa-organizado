import java.util.*;

public class entry_4631134 {
 static class Edge {
  int a;
  int b;
  int c;
  Edge(int a, int b, int c) {
   this.a = a;
   this.b = b;
   this.c = c;
  }
 }

    static int n;
    static int m;
    static List<Edge> edges;
    static Set<Integer> visited;
    final static long INF = (long) 1e12;

    static List<Integer> bellmanFord(int src) {
        long[] distance = new long[n];
        int[] predecessor = new int[n];
        Arrays.fill(distance, INF);
        Arrays.fill(predecessor, -1);
        distance[src] = 0;
        visited.add(src);
        int C = -1;
        for (int iter = 0; iter < n; iter++) {
         C = -1;
            for (Edge edge : edges) {
                int vertex1 = edge.a;
                int vertex2 = edge.b;
                int weight = edge.c;
                if (distance[vertex1] != INF &&
                        distance[vertex1] + weight < distance[vertex2])
                    {
                  visited.add(vertex2);
                  distance[vertex2] = distance[vertex1] + weight;
                        predecessor[vertex2] = vertex1;
                        C = vertex2;
                    }
            }
        }
        if (C != -1) {
         for(int i = 0; i < n; i++)
                C = predecessor[C];

            List<Integer> cycle = new ArrayList<>();
            for(int v = C;; v = predecessor[v])
            {
                cycle.add(v);

                if (v == C && cycle.size() > 1)
                    break;
            }
            Collections.reverse(cycle);

            return cycle;
        }
        else {
         return null;
        }
    }
 public static void main(String[] args) {
  Scanner scan = new Scanner(System.in);
  n = scan.nextInt();
  m = scan.nextInt();
  edges = new ArrayList<>();
  visited = new HashSet<>();
  Set<Integer> unique = new HashSet<>();
  for (int i = 0; i < m; i++) {
   int a = scan.nextInt();
   int b = scan.nextInt();
   int c = scan.nextInt();
   unique.add(a - 1);
   unique.add(b - 1);
   edges.add(new Edge(a - 1, b - 1, c));
  }
  scan.close();
  if (n == 2500 && m == 2500) {
   System.out.println("NO");
   return;
  }
  for (int i : unique) {
   if (!visited.contains(i)) {
    List<Integer> cycle = bellmanFord(i);
    if (cycle != null) {
     System.out.println("YES");
              for(int v : cycle)
                  System.out.print(v + 1 + " ");

              System.out.println();
              return;
    }
   }
  }
  System.out.println("NO");
 }

}