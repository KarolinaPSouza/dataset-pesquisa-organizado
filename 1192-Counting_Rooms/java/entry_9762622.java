import java.util.*;
//import java.lang.*;
import java.io.*;
//a to x
//97 to 122

public class entry_9762622 {
    static class Pair {
        int key;
        int value;

        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return Objects.equals(key, pair.key) && Objects.equals(value, pair.value);
        }
        @Override
        public int hashCode() {
            return Objects.hash(key, value);
        }
        @Override
        public String toString() {
            return "(" + key + ", " + value + ")";
        }
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

        float nextFloat()
        {
            return Float.parseFloat(next());
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

        int[] readArray(int n) {
   int[] a=new int[n];
   for (int i=0; i<n; i++) a[i]=nextInt();
   return a;
  }

  long[] readArrayLong(int n) {
   long[] a=new long[n];
   for (int i=0; i<n; i++) a[i]=nextLong();
   return a;
  }

        int[][] readArraysTwo(int n,int m){
            int[][] a=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    a[i][j]=sc.nextInt();
                }
            }
            return a;
        }
        char[][] readArraysTwoChar(int n,int m){
            char[][] a=new char[n][m];
            for(int i=0;i<n;i++){
                String line=sc.next();
                for(int j=0;j<m;j++){
                    a[i][j]=line.charAt(j);
                }
            }
            return a;
        }

    }
    static FastReader sc=new FastReader();
    static PrintWriter ot = new PrintWriter(System.out);
    public static void main(String[] args){
        //int tc=sc.nextInt();
        int tc=1;
        while(tc-- > 0)solve();
    }
    static int[] dx={1,0,-1,0};
    static int[] dy={0,1,0,-1};
    static int result=0;
    public static void solve(){
        int n=sc.nextInt();
        int m=sc.nextInt();
        char[][] grid=new char[n][m];
        grid=sc.readArraysTwoChar(n, m);
        boolean[][] vis=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='.'){
                    count++;
                    Deque<Pair> st=new ArrayDeque<>();
                    st.push(new Pair(i, j));
                    vis[i][j]=true;
                    while(!st.isEmpty()){
                        Pair cur=st.pop();
                        for(int k=0;k<4;k++){
                            int nx=cur.key+dx[k];
                            int ny=cur.value+dy[k];
                            if(nx<0 || ny<0 || nx>=n || ny>=m || vis[nx][ny] || grid[nx][ny]=='#')continue;
                            vis[nx][ny]=true;
                            st.push(new Pair(nx, ny));
                        }
                    }
                }
            }
        }
        ot.println(count);
        ot.flush();
    }
}