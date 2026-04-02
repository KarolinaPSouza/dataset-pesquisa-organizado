import java.io.*;
import java.util.*;

public class entry_10719489 {
    public static void main(String[] args) throws IOException {
        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // Reading input
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        Map<Integer, Integer> frq = new HashMap<>();
        String[] input = br.readLine().split(" ");

        for (int i = 1; i < n; i++) {
            arr[i] = Integer.parseInt(input[i - 1]) - 1;
            frq.put(arr[i], frq.getOrDefault(arr[i], 0) + 1);
        }

        int subs[] = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (!frq.containsKey(i)) q.add(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            if (u == 0) break;
            int v = frq.get(arr[u]);
            v--;
            frq.put(arr[u], v);
            subs[arr[u]] += subs[u] + 1;
            if (v == 0) {
                q.add(arr[u]);
            }
        }

        // Fast output
        for (int i = 0; i < n; i++) {
            bw.write(subs[i] + " ");
        }
        bw.flush(); // Ensures all output is written
    }
}