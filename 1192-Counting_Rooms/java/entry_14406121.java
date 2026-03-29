import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.* ;
public class entry_14406121 {

            static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    String line = br.readLine();
                    if (line == null) return null; // Avoid NPE if input is over
                    st = new StringTokenizer(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }


        int nextInt()     { return Integer.parseInt(next()); }
        long nextLong()   { return Long.parseLong(next()); }
        double nextDouble(){ return Double.parseDouble(next()); }
        String nextLine() {
            String str = "";
            try { str = br.readLine(); }
            catch (IOException e) { e.printStackTrace(); }
            return str;
        }
    }

    public static void dfs(char [][] map, int row, int col, boolean [][] vis){

        Queue<int[]> q = new LinkedList<>() ;
        q.add(new int[]{row,col}) ;
        vis[row][col] = true ;

        while(!q.isEmpty()){

        int [] curr = q.poll() ;
        row = curr[0] ;
        col = curr[1] ;

         int [] delA = {-1,0,1,0} ;
         int [] delB = {0,-1,0,1} ;

         for(int i=0 ;i <4 ;i++){
              int newRow = row + delA[i] ;
              int newCol = col + delB[i] ;

              if(newRow >= 0 && newCol >= 0 && newRow < map.length && newCol < map[0].length){
                   if(map[newRow][newCol] == '.' && !vis[newRow][newCol]){
                       vis[newRow][newCol] = true ;
                       q.add(new int[]{newRow,newCol}) ;
                   }
              }
         }
        }

    }

    public static void main(String[] args) {

        FastReader fr = new FastReader() ;
        int n = fr.nextInt() ;
        int m = fr.nextInt() ;

        char [][] map = new char[n][m] ;
        for(int i=0; i<n ;i++){
            map[i] = fr.next().toCharArray() ;
        }
        int cnt = 0 ;
        boolean [][] vis = new boolean[n][m] ;

        for(int i=0 ;i < n; i++){
            for(int j=0 ;j <m ;j++){
                 if(!vis[i][j] && map[i][j] == '.'){
                    cnt++ ;
                    dfs(map, i, j, vis);
                 }
            }
        }

        PrintWriter pw =new PrintWriter(System.out) ;
        pw.println(cnt);
        pw.flush();

    }

}