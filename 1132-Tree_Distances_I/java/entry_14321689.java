//package CSES.Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://cses.fi/problemset/task/1132
public class entry_14321689 {
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

    static int n;
    static ArrayList<Integer>[] adj;

    static int[] bfs(int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        int[] q = new int[n + 5];
        int head = 0, tail = 0;
        q[tail++] = start;
        dist[start] = 0;

        while (head < tail) {
            int u = q[head++];
            for (int v : adj[u]) {
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q[tail++] = v;
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        n = nextInt();
        adj = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int a = nextInt();
            int b = nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        // Step 1: BFS from 1 to find A
        int[] d1 = bfs(1);
        int A = 1;
        for (int i = 1; i <= n; i++) {
            if (d1[i] > d1[A]) A = i;
        }

        // Step 2: BFS from A to find B
        int[] da = bfs(A);
        int B = A;
        for (int i = 1; i <= n; i++) {
            if (da[i] > da[B]) B = i;
        }

        // Step 3: BFS from B
        int[] db = bfs(B);

        // Step 4: Answer for each node
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(Math.max(da[i], db[i])).append(" ");
        }
        System.out.println(sb);
    }

//    public static void main(String[] args) throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
//        int n = nextInt();
//        ArrayList<Integer>[] adj = new ArrayList[n + 1];
//        for (int i = 0; i <= n; i++) adj[i] = new ArrayList<>();
//        for (int i = 0; i < n - 1; i++) {
//            int a = nextInt();
//            int b = nextInt();
//            adj[a].add(b);
//            adj[b].add(a);
//        }
//        int par[] = new int[n+1];
//        ArrayDeque<Integer> q = new ArrayDeque<>();
//        int order[] = new int[n+1];
//        q.offer(1);
//        int idx=0;
//        while(!q.isEmpty()){
//            int t= q.poll();
//            order[idx++] = t;
//            for(int v:adj[t]){
//                if(v!=par[t]){
//                    par[v]=t;
//                    q.offer(v);
//                }
//            }
//        }
//
//        int h[] = new int[n+1];
//        for(int i=idx-1;i>=0;i--){
//            int u = order[i];
//            for(int v:adj[u]){
//                if(v!=par[u]){
//                    h[u]=Math.max(h[u],h[v]);
//                }
//            }
//            h[u]++;
//        }
//
//        int up[] = new int[n+1];
//        for(int i=0;i<idx;i++){
//            int u = order[i];
//            List<Integer> child = new ArrayList<>();
//            for(int v:adj[u]){
//                if(v!=par[u])  child.add(v);
//            }
//            int size = child.size();
//            int preMax[]  = new int[size+1];
//            int suffMax[]  = new int[size+1];
//            for (int j = 0; j < size; j++) {
//                preMax[j+1]=Math.max(preMax[j],h[child.get(j)]);
//            }
//            for (int j = size-1; j >=0; j--) {
//                suffMax[j]=Math.max(suffMax[j+1],h[child.get(j)]);
//            }
//            for (int j = 0; j < size; j++) {
//                int v  = child.get(j);
//                int bestSibling = Math.max(preMax[j],suffMax[j+1]);
//                up[v]=Math.max(up[v],Math.max(up[u]+1,bestSibling+1));
//            }
//        }
//        int dp[] = new int[n+1];
//        StringBuilder sb = new StringBuilder();
//        for (int i = 1; i < n+1; i++) {
//            dp[i]=Math.max(h[i]-1,up[i]);
//            sb.append(dp[i]).append(" ");
//        }
//        System.out.println(sb);
//
//
//    }
}