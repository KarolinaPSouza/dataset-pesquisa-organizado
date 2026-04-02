import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_13353307 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        Solution2 sol = new Solution2();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long[][] a = new long[n+1][n+1];
        int[][] queries = new int[q][2];

        for(int i = 0; i <= n; i++) {
            Arrays.fill(a[i], (long) 1e15);
            a[i][i] = 0;

        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            a[u][v] = Math.min(a[u][v], w);
            a[v][u] = Math.min(a[v][u], w);

        }

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(reader.readLine());
            int q1 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());

            queries[i][0] = q1;
            queries[i][1] = q2;

        }


        sol.solve(a, queries);

    }

}


class Solution2 {
    public void solve(long[][] a, int[][] queries) {
        int n = a.length - 1;

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    a[i][j] = Math.min(a[i][j], a[i][k] + a[k][j]);

                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for(int[] q: queries) {
            long answer = a[q[0]][q[1]];
            if(answer == (long) 1e15) {
                answer = -1;
            }
            sb.append(answer);
            sb.append('\n');

        }
        System.out.print(sb);

    }

}