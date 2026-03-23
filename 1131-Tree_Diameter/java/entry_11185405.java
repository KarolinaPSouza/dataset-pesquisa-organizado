// CSES Tree Diameter

import java.io.*;
import java.util.*;

public class entry_11185405 {
    static int[] head;
    static int[] next;
    static int[] to;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(in.readLine());

        head = new int[n];
        next = new int[2 * (n - 1)];
        to = new int[2 * (n - 1)];
        Arrays.fill(head, -1);

        for (int i = 0; i < 2 * (n - 1); i += 2) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            next[i] = head[a];
            head[a] = i;
            to[i] = b;

            next[i + 1] = head[b];
            head[b] = i + 1;
            to[i + 1] = a;
        }

        int[] retA = bfs(0, n);
        int[] retB = bfs(retA[0], n);

        out.println(retB[1]);

        in.close();
        out.close();
    }

    private static int[] bfs(int start, int n) {
        int[] distances = new int[n];
        Arrays.fill(distances, -1);

        int maxDistance = 0;
        int maxPosition = start;
        distances[start] = 0;

        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int edge = head[node]; edge != -1; edge = next[edge]) {
                int nextNode = to[edge];
                if (distances[nextNode] == -1) {
                    distances[nextNode] = distances[node] + 1;

                    if (distances[nextNode] > maxDistance) {
                        maxDistance = distances[nextNode];
                        maxPosition = nextNode;
                    }

                    queue.add(nextNode);
                }
            }
        }

        return new int[] { maxPosition, maxDistance };
    }
}