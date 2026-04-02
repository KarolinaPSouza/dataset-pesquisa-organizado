import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class entry_7030441 {
    public static class pairs implements Comparable<pairs> {

        int x;
        int y;
        int z;
        public pairs(int x, int y,int z) {
            this.x = x;
            this.y = y;
            this.z=z;
        }
        @Override
        public int compareTo(pairs a) {
            return this.x-a.x;
        }
    }
    static long dp[][][];
   static long dfs(ArrayList<ArrayList<pairs>>graph,int x,boolean visited[],int par,int mask){
        if(dp[x][par][mask]!=-1)
        return dp[x][par][mask];
         long max=0;
         for(pairs i:graph.get(x)){
             int a=i.x;
             int b=i.y;
             if(!visited[a]){
                int r=mask;
                r=(1<<(a-1));
                r=mask|r;
                visited[a]=true;
                max=Math.max(max,b+dfs(graph, a, visited, x, r));
                visited[a]=false;
             }
         }
         dp[x][par][mask]=max;
       return dp[x][par][mask];
   }

   static int par[],c=0;
   static StringBuilder sb;
   static void dfs2(ArrayList<ArrayList<Integer>>graph,boolean visited[],int x,int p){
    if(sb.length()!=0)return;
        if(!visited[x]){
            visited[x]=true;
            par[x]=p;
            for(int i:graph.get(x)){
                if(visited[i]&&(i!=p)&&sb.length()==0){
                    int y=x;
                    while(y!=i){
                        sb.append(y+" ");c++;
                        y=par[y];
                    }
                    c+=2;
                    sb.append(i+" "+x);
                    return;
                }
                dfs2(graph, visited, i, x);
            }
        }
   }
    public static void entry_7030441(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int t=1;  
        while(t-->0){
            int n=sc.nextInt();
            int m=sc.nextInt();
            ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
            for(int i=0;i<=n;i++){
                graph.add(new ArrayList<>());
            }
            for(int i=0;i<m;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                graph.get(x).add(y);
                graph.get(y).add(x);
            }
            boolean visited[]=new boolean[n+1];
            par=new int[n+1];
             sb=new StringBuilder("");c=0;
            for(int i=1;i<=n;i++){
                if(sb.length()!=0)break;
                if(!visited[i]){
                    dfs2(graph,visited, i, 0);
                }
            }

            if(sb.length()==0){
                out.println("IMPOSSIBLE");
            }
            else{
                out.println(c);
                out.println(sb);
            }
        }
        out.flush();
    }



    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}