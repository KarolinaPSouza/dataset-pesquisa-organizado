/*
https://cses.fi/problemset/task/1668
Building Teams
 There are n pupils in Uolevi's class, and m friendships between them. Your task is to divide the pupils into two teams in such a way that no two pupils in a team are friends. You can freely choose the sizes of the teams.
Input
The first input line has two integers n and m: the number of pupils and friendships. The pupils are numbered 1,2,...,n.
Then, there are m lines describing the friendships. Each line has two integers a and b: pupils a and b are friends.
Every friendship is between two different pupils. You can assume that there is at most one friendship between any two pupils.
Output
Print an example of how to build the teams. For each pupil, print "1" or "2" depending on to which team the pupil will be assigned. You can print any valid team.
If there are no solutions, print "IMPOSSIBLE".
*/

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class entry_11480641 {
    static final int MOD = 1000000007;

    //Bipartiteness check
    private static boolean BFS(int node, Boolean[] visited, ArrayList[] adj) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);

        while (! queue.isEmpty()) {
            Integer t = queue.poll();
            Boolean group = visited[t];

            ArrayList<Integer> adjNodes = adj[t];

            for (int j : adjNodes) {
                if (visited[j] == null) {
                    visited[j] = ! group;
                    queue.add(j);
                } else if (visited[j] == group) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void solve(InputStream input, PrintWriter writer) throws IOException {
        MyReader reader = new MyReader(input);

        int n = reader.nextInt();
        int m = reader.nextInt();

        ArrayList[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i ++) {
            adj[i] = new ArrayList();
        }

        for (int i = 0; i < m; i++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        Boolean[] visited = new Boolean[n + 1];


        boolean hasSolution = true;

        for (int i = 1; i <= n; i++) {
            if (visited[i] != null) {
                continue;
            }

            visited[i] = true;

            hasSolution = BFS(i, visited, adj);
            if (! hasSolution) {
                break;
            }
        }

        if (hasSolution) {
            for (int i = 1; i <= n; i++) {
                writer.print(visited[i] ? "1 " : "2 ");
            }
            writer.println();
        } else {
            writer.println("IMPOSSIBLE");
        }

        writer.close();
        reader.close();
    }

    static class MyReader {
        final private int BUFFER_SIZE = 1 << 16;

        private DataInputStream din;

        private byte[] buffer;

        private int bufferPointer, bytesRead;

        public MyReader(InputStream input) {
            din = new DataInputStream(input);

            buffer = new byte[BUFFER_SIZE];

            bufferPointer = bytesRead = 0;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);

            if (bytesRead == -1) buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();

            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null) return;

            din.close();
        }

        public int nextInt() throws IOException {
            int ret = 0;

            byte c = read();

            while (c <= ' ') c = read();

            boolean neg = (c == '-');

            if (neg) c = read();

            do { ret = ret * 10 + c - '0'; } while ((c = read()) >= '0' && c <= '9');

            if (neg) return -ret;

            return ret;
        }
    }

    public static void main(String[] args) throws IOException {
        solve(System.in, new PrintWriter(System.out));
    }
}