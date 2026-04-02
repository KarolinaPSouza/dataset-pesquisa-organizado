import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_6063362 {
//    final static long INF = (long)1e18;
//    public static void main(String[] args) throws IOException {
//        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st= new StringTokenizer(br.readLine());
//        PrintWriter pw=new PrintWriter(System.out);
//        int n = Integer.parseInt(st.nextToken());
//        int m = Integer.parseInt(st.nextToken());
//        int q = Integer.parseInt(st.nextToken());
//        long[][]graph=new long[n][n];
//        for(int i=0;i<n;i++){
//            for(int j=0;j<n;j++){
//                graph[i][j]=INF;
//                if(i==j){
//                    graph[i][j]=0;
//                }
//            }
//        }
//        for(int i=0;i<m;i++){
//            st = new StringTokenizer(br.readLine());
//            int a = Integer.parseInt(st.nextToken())-1;
//            int b = Integer.parseInt(st.nextToken())-1;
//            int c = Integer.parseInt(st.nextToken());
//            graph[a][b]=graph[b][a]=Math.min(graph[a][b],c);
//        }
//
//        for(int k=0;k<n;k++){
//            for(int i=0;i<n;i++){
//                for(int j=0;j<n;j++){
//                    if(graph[i][k]+graph[k][j]<graph[i][j]){
//                        graph[i][j]=graph[j][i]=graph[i][k]+graph[k][j];
//                    }
//                }
//            }
//        }
//        for(int i=0;i<q;i++){
//            st= new StringTokenizer(br.readLine());
//            int x = Integer.parseInt(st.nextToken())-1;
//            int y = Integer.parseInt(st.nextToken())-1;
//            if(graph[x][y]==INF){
//                pw.println(-1);
//            }
//            else{
//                pw.println(graph[x][y]);
//            }
//
//        }
//        pw.close();
//    }
static class Kattio extends PrintWriter {
    private BufferedReader r;
    private StringTokenizer st;
    // standard input
    public Kattio() { this(System.in, System.out); }
    public Kattio(InputStream i, OutputStream o) {
        super(o);
        r = new BufferedReader(new InputStreamReader(i));
    }
    public String next() {
        try {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(r.readLine());
            return st.nextToken();
        } catch (Exception e) { }
        return null;
    }
    public int nextInt() { return Integer.parseInt(next()); }
    public double nextDouble() { return Double.parseDouble(next()); }
    public long nextLong() { return Long.parseLong(next()); }
}

    public static void main(String[] args) {
        Kattio io = new Kattio();

        int n = io.nextInt(), m = io.nextInt(), q = io.nextInt();

        long[][] mat = new long[n][n];
        long INF = (long)1e18;

        for (long[] row : mat) { Arrays.fill(row, INF); }

        long[][]graph=new long[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                graph[i][j]=INF;
                if(i==j){
                    graph[i][j]=0;
                }
            }
        }
        for(int i=0;i<m;i++){
            int a = io.nextInt()-1;
            int b = io.nextInt()-1;
            int c = io.nextInt();
            graph[a][b]=graph[b][a]=Math.min(graph[a][b],c);
        }

        // floyd-warshall
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(graph[i][k]+graph[k][j]<graph[i][j]){
                        graph[i][j]=graph[j][i]=graph[i][k]+graph[k][j];
                    }
                }
            }
        }
        for(int i=0;i<q;i++){
            int x = io.nextInt()-1;
            int y = io.nextInt()-1;
            if(graph[x][y]==INF){
                io.println(-1);
            }
            else{
                io.println(graph[x][y]);
            }

        }


        io.close();
    }
}