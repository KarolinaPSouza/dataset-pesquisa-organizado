//package com.company;

import java.io.*;
import java.util.*;

public class entry_5900016 {
    static PrintWriter out = new PrintWriter(System.out);
    static FastScanner scanner;
    public static void main(String[] args) throws IOException{
        scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        ArrayList<ArrayList<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int from = scanner.nextInt()-1;
            int to = scanner.nextInt()-1;
            adj.get(from).add(new Edge(from,to, scanner.nextLong()));
        }
        long[][] dist = new long[n][2];
        for (int i = 0; i < n; i++) {
            dist[i][0] = Long.MAX_VALUE;
            dist[i][1] = Long.MAX_VALUE;
        }
        dist[0][0] = 0;
        dist[0][1] = 0;
        Queue<Pos> heap = new PriorityQueue<>((i,j)->Long.compare(i.cost,j.cost));
        heap.add(new Pos(0,0,0));
        while (!heap.isEmpty()){
            Pos curr = heap.poll();
            long cost = dist[curr.pos][curr.used];
//            out.println(cost + " "+curr.cost);
            if (cost != curr.cost) continue;
//            out.println(curr.pos);
            if (curr.pos == n-1) break;
            for (Edge edge: adj.get(curr.pos)){
                if (curr.used==0){
                    long new_cost = cost + edge.c/2;
                    if (dist[edge.to][1] > new_cost){
                        dist[edge.to][1] = new_cost;
                        heap.add(new Pos(edge.to,1,new_cost));
                    }
                }
//                out.println("to = "+edge.to);
                if (cost + edge.c < dist[edge.to][curr.used]){
                    dist[edge.to][curr.used] = cost + edge.c;
                    heap.add(new Pos(edge.to, curr.used, cost + edge.c));
                }
            }
        }
        out.println(dist[n-1][1]);
        out.close();
    }
    static class Pos{
        int pos;
        int used;
        long cost;

        public Pos(int pos, int used, long cost){
            this.pos = pos;
            this.used = used;
            this.cost = cost;
        }
    }
    static class Edge{
        int from, to;
        long c;

        public Edge(int from, int to, long c){
            this.from = from;
            this.to = to;
            this.c = c;
        }
    }
    public static boolean checkBit(int n, int i){
        return (n&(1<<i))!=0;
    }
    public static long lcm(long a, long b){
        return (a*b)/gcd(a,b);
    }
    public static long gcd(long a, long b){
        if (a==0){
            return b;
        }else if (b==0){
            return a;
        }
        if (a<b){
            return gcd(a,b%a);
        }else{
            return gcd(a%b,b);
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st = new StringTokenizer("");

        FastScanner(String s) throws IOException{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(s))));
        }
        FastScanner() throws IOException{
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
            while (!st.hasMoreTokens()) try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return st.nextToken();
        }
        double nextDouble(){return Double.parseDouble(next());}
        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}