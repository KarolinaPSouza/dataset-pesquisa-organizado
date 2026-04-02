import java.io.*;
import java.util.*;

public class entry_12284401 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long INF = (long) 1e18;
        long[][] dist = new long[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (c < dist[a][b]) {
                dist[a][b] = c;
                dist[b][a] = c;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                long ik = dist[i][k];
                if (ik == INF) continue;
                for (int j = i + 1; j <= n; j++) {
                    long kj = dist[k][j];
                    if (kj == INF) continue;
                    long newDist = ik + kj;
                    if (newDist < dist[i][j]) {
                        dist[i][j] = newDist;
                        dist[j][i] = newDist;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long res = dist[a][b];
            sb.append(res == INF ? -1 : res).append('\n');
        }
        System.out.print(sb);
    }
}