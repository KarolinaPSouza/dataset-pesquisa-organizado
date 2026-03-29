/******************************************************************************
                             Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.
 *******************************************************************************/

import java.util.*;

public class entry_12762546 {
    static final long INF = 1000000000000000L;
    static int MAX_N = 2501;

    // Adjacency List to store the weighted graph
    static List<Pair>[] graph = new ArrayList[MAX_N];

    // array to store the distance to any node
    static long[] dist = new long[MAX_N];
    // array to store the parent of any node
    static int[] par = new int[MAX_N];
    // array to store the number of times a node has been
    // relaxed
    static int[] cnt = new int[MAX_N];

    static int n, m, u, v, q;
    // array to keep track of whether a node is already in
    // the queue
    static boolean[] in_queue = new boolean[MAX_N];
    // array to keep track of visited nodes
    static boolean[] visited = new boolean[MAX_N];
    static int x;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number of nodes and edges
        n = sc.nextInt();
        m = sc.nextInt();

        // Initialize the distance to all nodes as INF
        Arrays.fill(dist, INF);

        // Initialize the graph
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // Input edges
        for (int i = 0; i < m; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            long w = sc.nextLong();  // Declare w as long to store large edge weights
            graph[u].add(new Pair(v, w));
        }

        // Check for negative cycles
        for (int i = 1; i <= n; i++) {
            // If there is a negative weight cycle in the graph
            if (!spfa(i)) {
                System.out.println("YES");
                int ele = x;
                Stack<Integer> stack = new Stack<>();
                boolean[] is_stack = new boolean[MAX_N];

                // Push all the elements in the stack using
                // the parent array
                while (!is_stack[ele]) {
                    is_stack[ele] = true;
                    stack.push(ele);
                    ele = par[ele];
                }

                // Print all the nodes in the negative
                // weight cycle
                System.out.print(ele + " ");
                while (stack.peek() != ele) {
                    System.out.print(stack.pop() + " ");
                }
                System.out.println(ele);
                return;
            }
        }

        System.out.println("NO");
    }

    // Function to run Shortest Path Fast Algorithm
    static boolean spfa(int start) {
        // Initialize the distance of starting node = 0
        dist[start] = 0;
        // Initialize the parent of starting node = -1
        par[start] = -1;

        // Queue to run SPFA
        Queue<Integer> q = new LinkedList<>();

        // Push the starting node in the queue
        q.add(start);
        in_queue[start] = true;

        while (!q.isEmpty()) {
            // Pop the front element of the queue
            int ele = q.poll();
            visited[ele] = true;
            in_queue[ele] = false;

            // Iterate over all the children of the current node
            for (Pair child : graph[ele]) {
                // If the distance to the child node is greater than the distance of the current node + edge weight,
                // then relax the child node
                if (dist[child.first] > dist[ele] + child.second) {
                    // Increment the relaxation count of the child node
                    cnt[child.first]++;
                    // If the child has been relaxed more than n times, then there is a cycle
                    if (cnt[child.first] > n) {
                        x = child.first;
                        par[child.first] = ele;
                        return false;
                    }
                    // Update the minimum distance to the child node
                    dist[child.first] = dist[ele] + child.second;
                    // Push the child node if it is already not in the queue
                    if (!in_queue[child.first]) {
                        q.add(child.first);
                        in_queue[child.first] = true;
                    }
                    // Update the parent of the child node with the current node
                    par[child.first] = ele;
                }
            }
        }
        return true;
    }

    // Helper class to represent pairs (Node, Edge Weight)
    static class Pair {
        int first;  // The destination node
        long second;  // The weight of the edge

        Pair(int first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}