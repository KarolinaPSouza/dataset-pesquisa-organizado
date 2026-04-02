import java.io.*;
import java.util.*;
public class entry_11811081 {
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;
        public FastWriter() {
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        public void print(Object o) throws IOException {
            bw.write(o.toString());
        }
        public void println(Object o) throws IOException {
            bw.write(o.toString());
            bw.newLine();
        }
        public void close() throws IOException {
            bw.flush();
            bw.close();
        }
    }

    public static void print(long[][] array) {
        for (long[] row : array) {
            for (long element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }
    public static void print(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void print(long[] array) {
        for (long element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void print(ArrayList<Long> arr) {
        for (long element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) throws IOException {
        FastReader in = new FastReader();
        FastWriter out = new FastWriter();
//        int t = in.nextInt();
        int t = 1;
        while (t-- > 0) {
            solve(in, out);
        }
        out.close();
    }
    static int visit[];
    static ArrayList<Integer> ans=new ArrayList<>();
    public static void solve(FastReader in,FastWriter out) throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        ArrayList<Integer>[] arr=new ArrayList[n+1];
        for(int i=0;i<arr.length;i++){
            arr[i]=new ArrayList<>();
        }

        for(int i=1;i<=m;i++){
            int u=in.nextInt();
            int v=in.nextInt();
            arr[u].add(v);
            arr[v].add(u);
        }
        visit=new int[n+1];
        for(int i=1;i<=n;i++){
            if(visit[i]==0){
                ans.add(i);
                dfs(i,arr);
            }
        }
        System.out.println(ans.size()-1);
        for(int i=1;i<ans.size();i++){
            System.out.println(ans.get(i-1)+" "+ans.get(i));
        }
    }
    public static void dfs(int curr,ArrayList<Integer> adj[]){
        visit[curr]=1;
        for(int ele:adj[curr]){
            if(visit[ele]==0){
                dfs(ele,adj);
            }
        }
    }
    static class Pair{
        int x,y;
        Pair(int x,int y){
            this.x=x;
            this.y=y;
        }
    }
}