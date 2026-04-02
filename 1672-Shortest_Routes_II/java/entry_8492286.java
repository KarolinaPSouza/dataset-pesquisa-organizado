import java.util.*;
import java.io.*;
public class entry_8492286 {
    static long inf = Long.MAX_VALUE/3;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        long[][]dist = new long[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(dist[i], inf);
            dist[i][i] = 0;
        }
        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());


            dist[a][b] = Math.min(dist[a][b], c);
            dist[b][a] = Math.min(dist[b][a], c);
        }

        for(int k = 0; k < N; k++){
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
                }
            }
        }
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        for(int i = 0; i < Q; i++){
            st = new StringTokenizer(br.readLine());
            long len = dist[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1];
            pw.println( (len==inf) ? -1 : len);
        }
        pw.close();
    }
}

/*
   (conditional) ? val1 : val2
 */