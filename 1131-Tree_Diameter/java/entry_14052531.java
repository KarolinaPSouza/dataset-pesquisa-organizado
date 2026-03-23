import java.io.*;
import java.util.*;

public class entry_14052531 {
    static int max = (int)(2e5);
    static ArrayList<Integer>[] adj = new ArrayList[max+5];
    public static void main(String[] args) throws Exception {
        FastReader fr = new FastReader();
        int n = fr.nextInt();
        if(n == 2) {
            System.out.println(1);
            return;
        }
        for(int i = 0; i<=n; i++) {
            adj[i] = new ArrayList<>();
        }
        for(int i = 1; i<=n-1; i++) {
            int u = fr.nextInt();
            int v = fr.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] dia1 = BFS(1, n);
        //System.out.print(dia1[0] + " " + dia1[1]);
        int[] dia2 = BFS(dia1[0], n);
        System.out.println(dia2[1]);

    }

    public static int[] BFS(int u, int n) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(u);
        int level = -1;
        int node = 0;
        int[] vis = new int[n+1];
        while(!q.isEmpty()) {
            int sz = q.size();
            level++;
            while(sz-- > 0) {
                int p = q.poll();
                node = p;
                for(int v : adj[p]) {
                    if(vis[v] != 1) {
                        q.offer(v);
                        vis[v] = 1;
                    }
                }
            }
        }
        return new int[] {node, level};
    } 

    // Ultra-fast input reader
    static class FastReader {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');
            if (c == '-') {
                sign = -1;
                c = readByte();
            }
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = readByte();
            }
            return val * sign;
        }
    }
}