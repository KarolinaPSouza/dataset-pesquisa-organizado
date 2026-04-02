import  java.util.*;
import java.io.*;

public class entry_11627783 {
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

    public static void main(String[] args) {
        FastReader in = new FastReader();
        int n=in.nextInt();
        int m=in.nextInt();
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=in.nextInt();
            int v=in.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        } int t=0;
        int vis[]=new int[n+1];
        for(int i=1;i<=n;i++){
            if(vis[i]==0)
            { vis[i]=1;
            if(!dfs(adj,vis,i))
            { System.out.println("IMPOSSIBLE"); t=1;
                break;
            }}
        }
        if(t==0)
        {
            for(int i=1;i<=n;i++)
                System.out.print(vis[i]+" ");
        }
    }
    static boolean dfs(List<List<Integer>> adj,int[] v,int i){

        for(int u:adj.get(i)){
            if(v[u]==0)
            {
                v[u]=v[i]^3;
                if(!dfs(adj,v,u))
                    return false;
            }
            else if(v[u]==v[i]){
                return false;
            }

        }
        return true;
    }
}






