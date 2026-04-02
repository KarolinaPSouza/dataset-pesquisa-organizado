//package CSES.Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://cses.fi/problemset/task/1674
public class entry_14292584 {
    static BufferedReader br;
    static StringTokenizer st;

    static String next() throws IOException {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

        static HashMap<Integer, List<Integer>> child;
    static int dp[];

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int n = nextInt();
        child = new HashMap<>();
        for (int i = 2; i <= n; i++) {
            child.computeIfAbsent(nextInt(), k -> new ArrayList<>()).add(i);
        }
        List<Integer> order = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        dp = new int[n+1];
        while(!stack.isEmpty()){
            int t = stack.pop();
            order.add(t);
            for(int i:child.getOrDefault(t,new ArrayList<>())) stack.push(i);
        }

        for(int i= order.size()-1;i>=0;i--){
            int u = order.get(i);
            for(int v:child.getOrDefault(u,new ArrayList<>())){
                dp[u]+=1+dp[v];
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) sb.append(dp[i]).append(" ");
        System.out.println(sb.toString().trim());
    }

//    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        int n = nextInt();
//        child = new HashMap<>();
//        for (int i = 2; i <= n; i++) {
//            child.computeIfAbsent(nextInt(), k -> new ArrayList<>()).add(i);
//        }
//        dp = new int[n + 1];
//        solve(1);
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i <= n; i++) {
//            sb.append(dp[i]).append(" ");
//        }
//        System.out.println(sb.toString().trim());
//    }
//
//    static void solve(int src) {
//        for (int key : child.getOrDefault(src, new ArrayList<>())) {
//            solve(key);
//            dp[src] += 1 + dp[key];
//        }
//    }
}