import java.util.*;
import java.io.*;

public class entry_14221441 {
    static int[] head, to, next;
    static int edgeIdx, n;
    public static void addEdge(int u, int v){
        to[edgeIdx] = v;
        next[edgeIdx] = head[u];
        head[u] = edgeIdx++;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(read.readLine());
        n = Integer.parseInt(st.nextToken());
        head = new int[n+1];
        Arrays.fill(head, -1);
        int m = n-1;
        next = new int[2*m];
        to = new int[2*m];
        edgeIdx = 0;
        for(int i=1; i<n; i++){
            st = new StringTokenizer(read.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            addEdge(a, b);
            addEdge(b, a);
        }
        int[] dist = bfs(1);
        int A = fatherNode(dist);
        int[] distA = bfs(A);
        int B = fatherNode(distA);
        int[] distB = bfs(B);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n; i++){
            sb.append(Math.max(distA[i], distB[i])).append(' ');
        }
        out.println(sb);
        out.flush();
    }
    public static int[] bfs(int node){
        int[] dist = new int[n+1];
        Arrays.fill(dist, -1);
        dist[node] = 0;
        int[] q = new int[n];
        int qh = 0;
        int qt = 0;
        q[qt++] = node;
        while(qh < qt){
            int curr = q[qh++];
            for(int e=head[curr]; e!=-1; e=next[e]){
                int neighbour = to[e];
                if(dist[neighbour] == -1){
                    dist[neighbour] = dist[curr]+1;
                    q[qt++] = neighbour;
                }
            }
        }
        return dist;
    }
    public static int fatherNode(int[] dist){
        int node = 1; 
        int far = dist[1];
        for(int i=2; i<=n; i++){
            if(far < dist[i]){
                far = dist[i];
                node = i;
            }
        }
        return node;
    }
}