import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
public class entry_7024142 {
    public static class pairs implements Comparable<pairs> {

        int x;
        int y;
        public pairs(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(pairs a) {
            return this.x-a.x;
        }
    }
   static void dfs(ArrayList<ArrayList<Integer>>graph,int x,boolean visited[]){
       if(!visited[x]){
         visited[x]=true;
         for(int i:graph.get(x)){
            dfs(graph, i, visited);
         }
       }
   }
    public static void entry_7024142(String[] args) {
        FastReader sc = new FastReader();
        PrintWriter out=new PrintWriter(System.out);
        int t=1;  
        while(t-->0){
            int n=sc.nextInt();
            ArrayList<ArrayList<Integer>>graph=new ArrayList<>();
            for(int i=0;i<=n;i++){
                graph.add(new ArrayList<>());
            }
            int m=sc.nextInt();
            for(int i=0;i<m;i++){
                int x=sc.nextInt();
                int y=sc.nextInt();
                graph.get(x).add(y);graph.get(y).add(x);
            }
            StringBuilder sb=new StringBuilder("");
            int d[]=new int[n+1];
            Arrays.fill(d,Integer.MAX_VALUE);
            d[1]=0;
            PriorityQueue<pairs>pq=new PriorityQueue<>();
            int par[]=new int[n+1];
            pq.add(new pairs(1, 0));
            while(!pq.isEmpty()){
                pairs p=pq.remove();
                for(int i:graph.get(p.x)){
                    if(d[i]>d[p.x]+1){
                        d[i]=d[p.x]+1;
                        pq.add(new pairs(i,d[i]));
                        par[i]=p.x;
                    }
                }
            }
            if(d[n]==Integer.MAX_VALUE){
                out.println("IMPOSSIBLE");continue;
            }

            int y=n;
            ArrayList<Integer>list=new ArrayList<>();
            list.add(y);
            while(y!=1){
                list.add(par[y]);
                y=par[y];
            }
            out.println(list.size());
            for(int i=list.size()-1;i>=0;i--){
                sb.append(list.get(i)+" ");
            }
            out.println(sb);

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