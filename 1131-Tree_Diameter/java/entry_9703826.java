//package com.CSES.TreeAlgorithms;

import java.util.*;
import java.io.*;

public class entry_9703826 {
//    static int bfs(int[] dist,int src, int n){
//        boolean[] visit = new boolean[n+1];
//        visit[src] = true;
//        Queue<Integer> q = new LinkedList<>();
//        q.add(src);
//        dist[src] = 0;
//        int max = 0;
//        int vertex = src;
//        while(!q.isEmpty()){
//            int u = q.remove();
//            for(int i:adj[u]){
//                if(!visit[i]){
//                    dist[i] = dist[u]+1;
//                    q.add(i);
//                    visit[i] = true;
//                    if(dist[i] > max){
//                        vertex = i;
//                        max = dist[i];
//                    }
//                }
//            }
//        }
//        return vertex;
//    }

    private static int BFS(List<List<Integer>> adj, int[] dist, int node, int n){
        Queue<Integer> que = new LinkedList<>();
        boolean[] visited = new boolean[n];
        que.add(node);
        visited[node] = true;
        dist[node] = 0;
        int max = 0, vertex = node;
        while (!que.isEmpty()){
            int curr_node = que.remove();
            for (Integer val : adj.get(curr_node)){
                if (visited[val]) continue;
                que.add(val);
                visited[val] = true;
                dist[val] = dist[curr_node] + 1;
                if (dist[val] > max){
                    vertex = val;
                    max = dist[val];
                }
            }
        }
        return vertex;
    }

    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }
    public static void main(String[] args) {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();
            int n = in.nextInt();
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
            for (int i = 0; i < n-1; i++){
                int u = in.nextInt()-1, v = in.nextInt()-1;
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            int[] dist = new int[n];
            int node_a = BFS(adj,dist,0,n);
            dist = new int[n];
            node_a = BFS(adj,dist,node_a,n);
            int ans = dist[node_a];
            out.print(ans);
            out.close();
        } catch (Exception e) {
            return;
        }
    }
//static long mod=(long)1e9+7;
//    static long mod1=998244353;
//    static ArrayList<Integer>[] adj;
//
//    public static void main(String[] args) {
//        InputStream inputStream = System.in;
//        OutputStream outputStream = System.out;
//        InputReader in = new InputReader(inputStream);
//        PrintWriter out = new PrintWriter(outputStream);
//
//
//        int t= 1;
//        while(t-->0) {
//
//            int n = in.nextInt();
//            adj = new ArrayList[n+1];
//            for(int i = 0;i<=n;i++)
//                adj[i] = new ArrayList<>();
//
//            for(int i = 0;i<n-1;i++){
//                int a = in.nextInt();
//                int b = in.nextInt();
//                adj[a].add(b);
//                adj[b].add(a);
//            }
//            boolean[] visit = new boolean[n+1];
//            int[] dist = new int[n+1];
//            int u = bfs(dist,1,n);
//            dist = new int[n+1];
//            u = bfs(dist,u,n);
//            out.println(dist[u]);
//
//        }
//        out.close();
//    }
//
//
//    static int bfs(int[] dist, int src, int n){
//        boolean[] visit = new boolean[n+1];
//        visit[src] = true;
//        Queue<Integer> q = new LinkedList<>();
//        q.add(src);
//        dist[src] = 0;
//        int max = 0;
//        int vertex = src;
//        while(!q.isEmpty()){
//            int u = q.remove();
//            for(int i:adj[u]){
//                if(!visit[i]){
//                    dist[i] = dist[u]+1;
//                    q.add(i);
//                    visit[i] = true;
//                    if(dist[i] > max){
//                        vertex = i;
//                        max = dist[i];
//                    }
//                }
//            }
//        }
//        return vertex;
//    }
//
//    static final Random random=new Random();
//
//    static void ruffleSort(int[] a) {
//        int n=a.length;//shuffle, then sort
//        for (int i=0; i<n; i++) {
//            int oi=random.nextInt(n), temp=a[oi];
//            a[oi]=a[i]; a[i]=temp;
//        }
//        Arrays.sort(a);
//    }
//    static long gcd(long x, long y){
//        if(x==0)
//            return y;
//        if(y==0)
//            return x;
//        long r=0, a, b;
//        a = Math.max(x, y);
//        b = Math.min(x, y);
//        r = b;
//        while(a % b != 0){
//            r = a % b;
//            a = b;
//            b = r;
//        }
//        return r;
//    }
//    static long modulo(long a,long b,long c){
//        long x=1,y=a%c;
//        while(b > 0){
//            if(b%2 == 1)
//                x=(x*y)%c;
//            y = (y*y)%c;
//            b = b>>1;
//        }
//        return  x%c;
//    }
//    public static void debug(Object... o){
//        System.err.println(Arrays.deepToString(o));
//    }
//
//    static int upper_bound(int[] arr,int n,int x){
//        int mid;
//        int low=0;
//        int high=n;
//        while(low<high){
//            mid=low+(high-low)/2;
//            if(x>=arr[mid])
//                low=mid+1;
//            else
//                high=mid;
//        }
//        return low;
//    }
//
//    static int lower_bound(int[] arr,int n,int x){
//        int mid;
//        int low=0;
//        int high=n;
//        while(low<high){
//            mid=low+(high-low)/2;
//            if(x<=arr[mid])
//                high=mid;
//            else
//                low=mid+1;
//        }
//        return low;
//    }
//    static String printPrecision(double d){
//        DecimalFormat ft = new DecimalFormat("0.00000000000");
//        return String.valueOf(ft.format(d));
//    }
//    static int countBit(long mask){
//        int ans=0;
//        while(mask!=0){
//            mask&=(mask-1);
//            ans++;
//        }
//        return ans;
//    }
//
//    static class InputReader {
//        public BufferedReader reader;
//        public StringTokenizer tokenizer;
//
//        public InputReader(InputStream stream) {
//            reader = new BufferedReader(new InputStreamReader(stream), 32768);
//            tokenizer = null;
//        }
//
//        public String next() {
//            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//                try {
//                    tokenizer = new StringTokenizer(reader.readLine());
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//            return tokenizer.nextToken();
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//        public long nextLong() {
//            return Long.parseLong(next());
//        }
//        public double nextDouble() {
//            return Double.parseDouble(next());
//        }
//        public int[] readArray(int n)
//        {
//            int[] arr=new int[n];
//            for(int i=0;i<n;i++) arr[i]=nextInt();
//            return arr;
//        }
//    }
}