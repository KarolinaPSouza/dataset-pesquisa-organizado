import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_12417795 {
    // FastReader for fast input reading.
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch(IOException e){
                e.printStackTrace();
            }
            return str;
        }
    }

    public static int bfs(int node, List<List<Integer>> adj,int typ){
        Queue<Integer> q=new LinkedList<>();
        q.add(node);
        q.add(-1);
        int l=0;
        int n=adj.size();
        boolean visited[]=new boolean[n+1];
        Arrays.fill(visited,true);
        visited[node]=false;
        int ans=node;
        while(q.size()>1){
            int x=q.remove();
            if(x==-1){
                l++;
                q.add(-1);
            }
            else{
                for(int neg:adj.get(x)){
                    if(visited[neg]){
                        ans=neg;
                        q.add(neg);
                        visited[neg]=false;
                    }
                }
            }
        }
        if(typ==1) return ans;
        return l;
    }


    public static void solve(FastReader sc) {
       int n=sc.nextInt();
       List<List<Integer>> adj=new ArrayList<>();
       for(int i=0;i<=n;i++)
         adj.add(new ArrayList<>());

        for(int i=0;i<n-1;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int x=bfs(1,adj,1);
        System.out.println(bfs(x,adj,0));;

    }



    public static void main(String args[]) {
        FastReader sc = new FastReader();
        // int t = sc.nextInt();
        // while(t-- > 0){
            solve(sc);
        //}
    }
}