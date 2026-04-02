//package com.paypal.cloud.event.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

/*
Byteland has n cities, and m roads between them. The goal is to construct new roads so that there is a route between any two cities.
Your task is to find out the minimum number of roads required, and also determine which roads should be built.
Input
The first input line has two integers n and m: the number of cities and roads. The cities are numbered 1,2,\dots,n.
After that, there are m lines describing the roads. Each line has two integers a and b: there is a road between those cities.
A road always connects two different cities, and there is at most one road between any two cities.
Output
First print an integer k: the number of required roads.
Then, print k lines that describe the new roads. You can print any valid solution.
Constraints
 1 \le n \le 10^5
1 \le m \le 2 \cdot 10^5
1 \le a,b \le n
 Example
Input:
4 2
1 2
3 4
 Output:
1
2 3
* */
public class entry_15789714 {
    static boolean visited[][];
    public static void main(String[] args) {
        FastScanner in = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        // inputs
        int cities = in.nextInt(), roads = in.nextInt();
        DisjointSet ds = new DisjointSet(cities);
        for (int i = 0; i < roads; i++) {
            int src = in.nextInt(), dest = in.nextInt();
            ds.union(src, dest);
        }

//        for (int i = 0; i < ds.parent.length; i++) {
//            System.out.print(ds.parent[i] + " ");
//        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= cities; i++) {
            int parent = ds.find(i);
            map.put(parent, map.getOrDefault(parent, 0) + 1);
        }
        System.out.println(map.size() - 1);
        Object[] array = map.keySet().toArray();
        for (int i = 1; i < array.length; i++) {
            System.out.println(array[0] + " " + array[i]);
        }
    }

    static class DisjointSet {
        int[] parent;
        int[] rank;
        int cities;

        public DisjointSet(int cities) {
            this.cities = cities;
            this.rank = new int[cities + 1];
            this.parent = new int[cities + 1];
            for (int i = 1; i <= cities; i++) {
                parent[i] = i;
            }
        }

        public int find(int u) {
            int root = parent[u];
            if (parent[root] != root) {
                return parent[u] = find(root);
            }
            return root;
        }

        public void union(int c1, int c2) {
            int p1 = find(c1);
            int p2 = find(c2);
            if (p1 == p2) {
                return;
            }

            if (rank[p1] > rank[p2]) {
                parent[p2] = p1;
            } else if (rank[p1] < rank[p2]) {
                parent[p1] = p2;
            } else {
                parent[p2] = p1;
                rank[p1] = rank[p1] + 1;

            }

        }
    }

    static class FastScanner {
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

        char nextChar() {
            return Character.toLowerCase(next().charAt(0));
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
}