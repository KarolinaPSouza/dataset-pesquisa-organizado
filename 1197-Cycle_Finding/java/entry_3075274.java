import java.util.*;
import java.io.*;

public class entry_3075274 {

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
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] graph = new int[m+n][3];
        for(int i=0;i<m;i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph[i][0]=a;
            graph[i][1]=b;
            graph[i][2]=c;
        }
        long[] path = new long[n+1];
        int[] parent = new int[n+1];
        int x = -1;
        for(int i=1;i<=n;i++){
            x=-1;
            for(int j=0;j<m;j++){
                int u = graph[j][0];
                int v = graph[j][1];
                int wt = graph[j][2];
                if(path[u]==Long.MAX_VALUE) continue;
                if(path[v]>path[u]+wt){
                    path[v]=path[u]+wt;
                    parent[v]=u;
                    x=v;
                }
            }
        }

        if(x==-1){
            System.out.println("NO");
        }
        else{
            for(int i=1;i<=n;i++){
                x=parent[x];
            }
            List<Integer> res = new ArrayList<>();
            int v = x;
            while(true){
                if(v==x && res.size()>1) break;
                res.add(v);
                v = parent[v];
            }
            res.add(x);
            Collections.reverse(res);
            System.out.println("YES");
            for(int i=0;i<res.size();i++){
                System.out.print(res.get(i)+" ");
            }
        }
    }
}