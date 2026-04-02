import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.*;

public class entry_3476715 {
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out);

        int N = in.nextInt(), M = in.nextInt();
        List<Integer>[] adj = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int u = in.nextInt() - 1, v = in.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] group = new int[N];
        Arrays.fill(group, -1);
        boolean valid = true;
        i: for (int i = 0; i < N; i++) {
            if (group[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                group[i] = 0;
                while (!q.isEmpty()) {
                    int current = q.poll();
                    for (int j: adj[current]) {
                        if (group[j] >= 0 && group[j] == group[current]) {
                            valid = false;
                            break i;
                        }
                        if (group[j] == -1) {
                            group[j] = 1 - group[current];
                            q.offer(j);
                        }
                    }
                }
            }
        }
        if (valid) {
            for (int i = 0; i < N; i++) {
                out.print((group[i] + 1) + (i == N - 1 ? "\n" : " "));
            }
        } else {
            out.println("IMPOSSIBLE");
        }

        out.close();
    }
    static class Reader {
        BufferedInputStream in;
        public Reader() {
            in = new BufferedInputStream(System.in);
        }
        public String nextLine() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder("");
            while ((c = in.read()) != '\n')
                sb.append((char)(c));
            return sb.toString();
        }
        public String next() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder("");
            while ((c = in.read()) != ' ' && c != '\n')
                sb.append((char)(c));
            return sb.toString();
        }
        public int nextInt() throws IOException {
            return (int)nextLong();
        }
        public long nextLong() throws IOException {
            int c;
            long res = 0;
            boolean start = false, negative = false;
            while ((c = in.read()) != ' ' && c != '\n' || !start)
                if (c >= '0' && c <= '9' || c == '-') {
                    start = true;
                    if (c == '-')
                        negative = true;
                    else
                        res = res * 10 + c - '0';
                }
            return res * (negative ? -1 : 1);
        }
    }
    public static void sort(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            list.add(i);
        }
        Collections.sort(list);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
    }
}