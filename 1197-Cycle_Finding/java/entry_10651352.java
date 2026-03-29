import java.io.*;
import java.util.*;

public class entry_10651352 {
    static final long INF = 1000000000000000L;
    static final int MAX_N = 2501;

    static List<Pair>[] graph = new ArrayList[MAX_N];
    static long[] dist = new long[MAX_N];
    static int[] par = new int[MAX_N];
    static int[] cnt = new int[MAX_N];

    static int n, m, x;
    static boolean[] in_queue = new boolean[MAX_N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        Arrays.fill(dist, INF);
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            graph[a].add(new Pair(b, c));
        }

        for (int i = 1; i <= n; i++) {
            if (!spfa(i)) {
                pw.println("YES");
                Stack<Integer> stack = new Stack<>();
                boolean[] is_stack = new boolean[MAX_N];

                int ele = x;
                while (!is_stack[ele]) {
                    is_stack[ele] = true;
                    stack.push(ele);
                    ele = par[ele];
                }

                pw.print(ele + " ");
                while (stack.peek() != ele) {
                    pw.print(stack.pop() + " ");
                }
                pw.println(ele);
                pw.close();
                return;
            }
        }

        pw.println("NO");
        pw.close();
    }

    static boolean spfa(int start) {
        Arrays.fill(dist, INF);
        Arrays.fill(par, -1);
        Arrays.fill(cnt, 0);
        dist[start] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        in_queue[start] = true;

        while (!q.isEmpty()) {
            int ele = q.poll();
            in_queue[ele] = false;

            for (Pair child : graph[ele]) {
                if (dist[child.first] > dist[ele] + child.second) {
                    cnt[child.first]++;
                    if (cnt[child.first] > n) {
                        x = child.first;
                        par[child.first] = ele;
                        return false;
                    }
                    dist[child.first] = dist[ele] + child.second;
                    if (!in_queue[child.first]) {
                        q.add(child.first);
                        in_queue[child.first] = true;
                    }
                    par[child.first] = ele;
                }
            }
        }
        return true;
    }

    static class Pair {
        int first;
        long second;

        Pair(int first, long second) {
            this.first = first;
            this.second = second;
        }
    }
}