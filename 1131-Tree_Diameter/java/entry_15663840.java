import java.io.*;
import java.util.*;

public class entry_15663840 {

    static class FastScanner {
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
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }
    }

 static int maxDistance = 0;
 static int end = -1;
 static boolean[] visited;
 static List<Integer>[] adj;

 static void dfs(int u){

  Deque<int[]> dq = new ArrayDeque<>();
  dq.addLast(new int[]{u, 0});

  while(!dq.isEmpty()){
   int[] curr = dq.pollLast();
   if(maxDistance <= curr[1]){
    maxDistance = curr[1];
    end = curr[0];
   }
   for(int v : adj[curr[0]]){ 
    if(!visited[v]){
     visited[v] = true;
     dq.addLast(new int[]{v, curr[1] + 1});
    }
   }
  }
 }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();

        adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

  visited = new boolean[n + 1];

        for (int i = 0; i < n - 1; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj[u].add(v);
            adj[v].add(u);
        }

  visited[1] = true;

  dfs(1);

  visited = new boolean[n + 1];

  visited[end] = true;

  maxDistance = 0;

  dfs(end);

  System.out.println(maxDistance);

    }
}