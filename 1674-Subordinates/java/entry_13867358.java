import java.io.*;
import java.util.*;

public class entry_13867358 {
    static int n;
    static int[] head = new int[200001];
    static int[] next = new int[200001];
    static int[] target = new int[200001];
    static int[] ans = new int[200001];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        for (int child = 2; child <= n; child++) {
            int parent = Integer.parseInt(st.nextToken());
            addEdge(parent, child, child);       
        }

        calculateSubtreeSize(1);

        for (int i = 1; i <= n; i++) {
            sb.append(ans[i] - 1);
            if (i < n) sb.append(" ");
        }

        pw.println(sb.toString().trim());
        pw.close();
        br.close();
    }

    static void addEdge(int u, int v, int edgeId) {
        next[edgeId] = head[u];
        head[u] = edgeId;
        target[edgeId] = v;
    }

    public static int calculateSubtreeSize(int node) {
        ans[node] = 1;

        for (int edge = head[node]; edge != 0; edge = next[edge]) {
            int child = target[edge];
            ans[node] += calculateSubtreeSize(child);
        }

        return ans[node];
    }
}