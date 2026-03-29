import java.io.*;
import java.util.*;
public class entry_14303894 {

    public static class Pair{
        int row;
        int col;

        public Pair(int row,int col){
            this.col = col;
            this.row = row;
        }
    }

    public static void solve(){
        FastIO sc = new FastIO();
        int n = sc.nextInt();
        int m = sc.nextInt();
        char arr[][] = new char[n][m];

        for(int i=0;i<n;i++){
            String s = sc.next();
            arr[i] = s.toCharArray();
        }

        boolean vis[][] = new boolean[n][m];
        int cnt =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && arr[i][j]=='.'){
                    bfs(arr,vis,i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    public static void bfs(char arr[][],boolean vis[][], int row,int col){
        int n = arr.length;
        int m = arr[0].length;

        int delRow[] = {1,0,-1,0};
        int delCol[] = {0,-1,0,1};

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row,col));
        vis[row][col] = true;

        while(!q.isEmpty()){
            int currRow = q.peek().row;
            int currCol = q.peek().col;
            q.remove();
            // System.out.println(currCol+" "+currRow);
            for(int i=0;i<4;i++){
                int nCol = currCol+delCol[i];
                int nRow = currRow+delRow[i];

                if(nRow<n && nCol>=0 && nCol<m && nRow>=0 && arr[nRow][nCol]=='.' && !vis[nRow][nCol]){
                    q.add(new Pair(nRow, nCol));
                    vis[nRow][nCol] = true;
                }
            }
        }
    }

    public static void dfs(char arr[][],boolean vis[][], int row,int col){
        vis[row][col] = true;
        int n = arr.length;
        int m = arr[0].length;

        int delRow[] = {1,0,-1,0};
        int delCol[] = {0,-1,0,1};

        for(int i=0;i<4;i++){
            int nCol = row+delCol[i];
            int nRow = col+delRow[i];

            if(nCol<n && nCol>=0 && nRow<m && nRow>=0 && arr[nCol][nRow]=='.' && !vis[nCol][nRow]){
                dfs(arr,vis,nCol,nRow);
            }
        }
    }

    public static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static long lcm(long a, long b) {
        return Math.abs(a * b) / gcd(a, b);
    }
    static class FastIO{
        BufferedReader br;
        StringTokenizer st;
        public FastIO(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next(){
            while(st==null || !st.hasMoreElements()){
                try{
                    st = new StringTokenizer(br.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }


    }
    public static void main(String args[]){
        solve();
    }
}