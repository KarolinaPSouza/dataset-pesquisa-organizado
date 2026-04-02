//package CSES_subordinates;
import java.util.Scanner;
import java.util.ArrayList;
//public class entry_13343576 {
//    static ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
//    static int res[];
//
//    public static int dfs(int node){
//        int count = 0;
//        for(int child : adj.get(node)){
//            count+= 1+ dfs(child);
//        }
//        res[node] = count;
//        return count;
//    }
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        int n = sc.nextInt();
//        res = new int[n+1];
//
//        for(int i=0;i<=n;i++){
//            adj.add(new ArrayList<>());
//        }
//
//        for(int i=2;i<=n;i++){
//            int j = sc.nextInt();
//            adj.get(j).add(i);
//        }
//
//        dfs(1);
//
//        for(int i=1;i<res.length;i++){
//            System.out.print(res[i]+" ");
//        }
//
//
//    }
//}

import java.io.*;
import java.util.*;

public class entry_13343576 {

    static ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    static int[] res;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        // Fast input setup
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        res = new int[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 2; i <= n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            adj.get(parent).add(i);
        }

        // Run iterative DFS
        iterativeDFS(n);

        // Efficient output
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(res[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }

    static void iterativeDFS(int n) {
        Stack<Integer> stack = new Stack<>();
        Stack<Boolean> processed = new Stack<>();
        stack.push(1);
        processed.push(false);

        while (!stack.isEmpty()) {
            int node = stack.pop();
            boolean isProcessed = processed.pop();

            if (isProcessed) {
                // All children processed, compute result
                for (int child : adj.get(node)) {
                    res[node] += res[child] + 1;
                }
            } else {
                stack.push(node);
                processed.push(true);
                for (int child : adj.get(node)) {
                    stack.push(child);
                    processed.push(false);
                }
            }
        }
    }
}