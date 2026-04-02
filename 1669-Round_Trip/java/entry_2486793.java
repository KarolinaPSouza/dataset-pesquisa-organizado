//package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_2486793 {

    public static void main(String[] args) {
        FastScanner fs=new FastScanner();
        int n = fs.nextInt();
        int m = fs.nextInt();
        Map<Integer, List<Integer>> g = new HashMap<>();
        for(int i = 0; i < m; ++i) {
            int a = fs.nextInt() - 1;
            int b = fs.nextInt() - 1;
            List<Integer> an = g.getOrDefault(a, new ArrayList<>());
            List<Integer> bn = g.getOrDefault(b, new ArrayList<>());
            an.add(b);
            bn.add(a);
            g.put(a, an);
            g.put(b, bn);
        }

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);
        boolean foundCycle = false;
        List<Integer> result = new ArrayList<>();
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for(int i = 0; i < n; ++i) {
            if(!visited[i] && g.containsKey(i)) {
                result.clear();
                Arrays.fill(parent, -1);
                dfs(i, -1, parent, visited, result, g);
                if(result.size() > 0) {
                    Collections.reverse(result);
                    foundCycle = true;
                    break;
                }

            }
        }
        if(foundCycle) {
            StringBuilder sb = new StringBuilder();
            sb.append(result.size());
            sb.append("\n");
            for(int i = 0; i < result.size(); ++i) {
                sb.append(result.get(i) + " ");
            }
            System.out.println(sb.toString());
        } else {
            System.out.println("IMPOSSIBLE");
        }



    }

    private static void dfs(int u, int p, int[] parent,
                               boolean[] visited, List<Integer> result,
                               Map<Integer, List<Integer>> g) {
        List<Integer> un = g.getOrDefault(u, new ArrayList<>());
        visited[u] = true;
        for(int i = 0; i < un.size(); ++i) {
            int x = un.get(i);
            if(!visited[x]) {
                parent[x] = u;
                dfs(x, u, parent, visited, result, g);
            } else if(visited[x] && x != p && result.size() == 0) {
                result.add(x + 1);
                int par = u;
                while(par != x) {
                    result.add(par + 1);
                    par = parent[par];
                    if(par == -1) break;
                }
                result.add(x + 1);
                return;
            }
        }
    }

    static class FastScanner {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer("");
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
        int[] readArray(int n) {
            int[] a=new int[n];
            for (int i=0; i<n; i++) a[i]=nextInt();
            return a;
        }
        long nextLong() {
            return Long.parseLong(next());
        }
    }


}