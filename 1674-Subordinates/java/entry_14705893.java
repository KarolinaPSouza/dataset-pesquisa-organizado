// # import sys
// # sys.setrecursionlimit(300000)

// # n=int(input())
// # bosses=list(map(int,input().split()))
// # subordinates=[0]*(n+1)

// # adj=[[] for _ in range(n+1)]
// # for i in range(n-1):
// #     adj[bosses[i]].append(i+2)

// # def dfs(node):
// #     for child in adj[node]:
// #         dfs(child)
// #         subordinates[node]+=subordinates[child]+1

// # dfs(1)
// # print(*subordinates[1:])
import java.io.*;
import java.util.*;

public class entry_14705893 {
    static List<List<Integer>> adj;
    static int[] subordinates;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        adj = new ArrayList<>();
        subordinates = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++) {
            int boss = Integer.parseInt(input[i]);
            adj.get(boss).add(i + 2);
        }

        // Iterative DFS using post-order simulation
        boolean[] visited = new boolean[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> postOrder = new ArrayDeque<>();

        stack.push(1);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            postOrder.push(node);
            for (int child : adj.get(node)) {
                stack.push(child);
            }
        }

        while (!postOrder.isEmpty()) {
            int node = postOrder.pop();
            for (int child : adj.get(node)) {
                subordinates[node] += subordinates[child] + 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(subordinates[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}