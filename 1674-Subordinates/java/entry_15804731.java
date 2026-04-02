import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class entry_15804731 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] indegree = new int[n];
        int[] ans = new int[n];

        int[] par = new int[n];
        Arrays.fill(par, -1);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < n; i++) {
            int x = Integer.parseInt(st.nextToken()) - 1; // 1-based → 0-based
            par[i] = x;
            indegree[x]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++) {
            if(indegree[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int node = q.poll();
            int p = par[node];
            if(p != -1) {
                ans[p] += ans[node] + 1;
                indegree[p]--;
                if(indegree[p] == 0) {
                    q.add(p); 
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int x : ans) sb.append(x).append(" ");
        System.out.print(sb);
    }
}