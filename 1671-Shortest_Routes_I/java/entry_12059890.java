import java.io.*;
import java.util.*;

public class entry_12059890 {
    public static class Pair<T extends Comparable<T>, V extends Comparable<V>> implements Comparable<Pair<T, V>> {
        private final T first;
        private final V second;
        public Pair(T first, V second) {
            this.first = first;
            this.second = second;
        }
        public T getFirst() { return first; }
        public V getSecond() { return second; }
        @Override
        public int compareTo(Pair<T, V> o) {
            return this.second.compareTo(o.second);
        }
    }
    private static final ArrayList<ArrayList<Pair<Long, Long>>> edges = new ArrayList<>(); // cost, nod
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer token = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(token.nextToken());
        int m = Integer.parseInt(token.nextToken());
        for (int i = 0; i <= n; i++) {
            edges.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            token = new StringTokenizer(br.readLine());
            long start = Long.parseLong(token.nextToken());
            long end = Long.parseLong(token.nextToken());
            long cost = Long.parseLong(token.nextToken());
            edges.get((int) start).add(new Pair<>(end, cost));
        }
        StringBuilder str = new StringBuilder();
        PriorityQueue<Pair<Long, Long>> pq = new PriorityQueue<>();
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[1] = 0;
        pq.add(new Pair<>(1L, 0L));
        while (!pq.isEmpty()) {
            Pair<Long, Long> pair = pq.poll();
            long nod = pair.getFirst();
            long cost = pair.getSecond();
            if (cost > dist[(int) nod]) continue;
            for (Pair<Long, Long> edge : edges.get((int) nod)) {
                long v = edge.getFirst();
                long w = edge.getSecond();
                if (dist[(int) v] > dist[(int) nod] + w) {
                    dist[(int) v] = dist[(int) nod] + w;
                    pq.add(new Pair<>(v, dist[(int) v]));
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            str.append(dist[i] == Long.MAX_VALUE ? -1 : dist[i]).append(" ");
        }
        System.out.println(str);
    }
}