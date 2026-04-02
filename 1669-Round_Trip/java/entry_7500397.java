import java.io.*;
import java.util.*;

public class entry_7500397 {
    public static class pair{
        public int x;
        public int y;
        pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

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
                }
                catch (IOException e) {
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
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    public static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static FastReader sc = new FastReader();
    public static int mod = 1000_000_007;

    public static int[] dirs = {0,1,0,-1,0};
    public static char[] charDirs = {' ','R','D','L','U'};

    public static void main(String[] args) {
        int r = sc.nextInt();
        int c = sc.nextInt();
        List<Integer>[] g = new ArrayList[r+1];
        for(int i=1;i<=r;i++) g[i] = new ArrayList<>();
        for(int i=0;i<c;i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            g[src].add(dest);
            g[dest].add(src);
        }

        int[] visited = new int[r+1];
        int[] parent = new int[r+1];
        boolean res = false;
        for(int i=1;i<=r;i++){
            if(visited[i]==0 && !res &&  dfs(i,-1,g,parent,visited)){
                res = true;
            }
        }
        if(!res){
            out.print("IMPOSSIBLE");
        };
        out.flush();out.close();
    }

    private static boolean dfs(int src,int prnt,List<Integer>[] g,int[] parent,int[] visited){
        visited[src] = 1;
        for(int ngb:g[src]){
//            System.out.println(src+" "+ngb);
            if(ngb==prnt || visited[ngb]==2) continue;
            if(visited[ngb]==1) {
                printAns(src,ngb,parent);
                return true;
            }
            parent[ngb] = src;
            if(dfs(ngb,src,g,parent,visited)) return true;
        }
        visited[src] = 2;
        return false;
    }

    private static void printAns(int src, int ngb, int[] parent) {
        int current = src;
        List<Integer> ans = new ArrayList<>();
        ans.add(src);
        while(current!=ngb){
//            System.out.println(current+" "+ngb);
            current = parent[current];
            ans.add(current);
        }
        ans.add(src);
        out.println(ans.size());
        for(int i=0;i<ans.size();i++){
            out.print(ans.get(i)+" ");
        }
    }
}