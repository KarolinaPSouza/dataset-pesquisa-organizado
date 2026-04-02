//package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_7558939 {
    /**
     * Hare Krishna
     **/
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static ArrayList<Integer>[] graph;
    public static int col[];
    public  static boolean flag=false;
    public static void main(String[] args) {
        FastReader br=new FastReader();
        int n=br.nextInt();
        int m= br.nextInt();
        graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int u= br.nextInt();
            int v=br.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        col=new int[n+1];
        Arrays.fill(col,-1);
        for(int i=1;i<=n;i++){
            if(col[i]==-1)dfs(i,0);
        }
        if(flag) System.out.println("IMPOSSIBLE");
        else {
            for(int i=1;i<=n;i++) System.out.print((col[i]+1)+" ");
        }
    }
    public static void dfs(int curr,int color){
        if(col[curr]!=-1){
            if(col[curr]!=color){
                flag=true;

            }
            return;
        }
        col[curr]=color;
        for(int i:graph[curr]){
            if(!flag)dfs(i,1-color);
        }
    }
}