import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_10637502 {
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
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited){
        visited[node] = true;
        for(int neigh : adj.get(node)){
            if(!visited[neigh]){
                dfs(neigh, adj, visited);
            }
        }
    }
    public static String bfs(int i, int j, char[][] grid){
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<String[]> q = new LinkedList<>();
        q.add(new String[]{String.valueOf(i), String.valueOf(j), ""});
        visited[i][j] = true;

        while(!q.isEmpty()){
            String[] top = q.poll();
            int x = Integer.valueOf(top[0]);
            int y = Integer.valueOf(top[1]);
            String pathTillNow = top[2];

            if(grid[x][y] == 'B'){

                return pathTillNow;
            }

            for(int k = 0; k<4; k++){
                int newI = x + dx[k];
                int newJ = y + dy[k];

                if(0 <= newI && newI < grid.length && 0<=newJ && newJ < grid[0].length 
                && grid[newI][newJ] != '#' && !visited[newI][newJ]){
                    visited[newI][newJ] = true;
                    // System.out.println(newI+" "+newJ);
                    q.add(new String[]{String.valueOf(newI), String.valueOf(newJ), pathTillNow + (k == 0 ? "D" : k==1? "U" : k == 2 ? "R" : "L")});
                }
            }
        }

        return "";
    }
    public static void entry_10637502(String[] args) throws IOException {
        FastReader sc = new FastReader();
        int mod = (int)1e9 + 7;
        // int t = sc.nextInt();
        // while(t --> 0){
            // String empty = sc.nextLine();
            int n = sc.nextInt();
            int m = sc.nextInt();

            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i<=n; i++){
                adj.add(new ArrayList<>());
            }
            for(int j = 0; j<m; j++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj.get(a).add(b);
                adj.get(b).add(a);
            }

            boolean[] visited = new boolean[n + 1];
            ArrayList<Integer> heads = new ArrayList<>();
            for(int i = 1; i<=n; i++){
                if(!visited[i]){
                    heads.add(i);
                    dfs(i, adj, visited);
                }
            }
            System.out.println(heads.size() - 1);
            for(int i = 1; i<heads.size(); i++){
                System.out.println(heads.get(i - 1)+" "+heads.get(i));
            }
        // }
    }
}