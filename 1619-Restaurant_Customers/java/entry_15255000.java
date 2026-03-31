import java.io.*;
import java.util.*;

public class entry_15255000 {

    static class Pair {
        int a, b;
        Pair(int x, int y) {
            this.a = x;
            this.b = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> x.a - y.a);

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.offer(new Pair(a, 1));
            pq.offer(new Pair(b, -1));
        }

        int count = 0, maxCount = 0;
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            count += p.b;
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}