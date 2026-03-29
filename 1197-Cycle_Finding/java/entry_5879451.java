import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.StringTokenizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

class Main {

    static class Node {
        int x, y;
        long w;

        public Node(int x, int y, long w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintStream out = new PrintStream(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Node> list = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                    Long.parseLong(st.nextToken())));
        }

        long dist[] = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE / 2);
        dist[1] = 0;

        boolean flag = false;
        int minVertexOfCycle = Integer.MAX_VALUE;
        int parent[] = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            flag = false;
            for (int j = 0; j < list.size(); j++) {
                Node node = list.get(j);

                if (dist[node.x] + node.w < dist[node.y]) {
                    dist[node.y] = dist[node.x] + node.w;

                    parent[node.y] = node.x;
                    flag = true;

                    minVertexOfCycle = node.y;

                }
            }
        }

        if (flag) {

            int temp = minVertexOfCycle;
            int count[] = new int[n + 1];
            while (true) {
                count[temp]++;
                if (count[temp] == 2) {
                    minVertexOfCycle = temp;
                    break;
                }
                temp = parent[temp];
            }
            temp = minVertexOfCycle;
            StringBuilder ans = new StringBuilder();

            do {
                ans.insert(0, temp + " ");
                temp = parent[temp];
            } while (temp != minVertexOfCycle);
            ans.insert(0, minVertexOfCycle + " ");

            out.println("YES" + "\n" + ans);
        } else {
            out.println("NO");
        }
    }
}