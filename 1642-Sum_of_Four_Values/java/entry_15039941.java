import java.io.*;
import java.util.*;

class FastReader {
    BufferedReader br;
    StringTokenizer st;
    public FastReader() { br = new BufferedReader(new InputStreamReader(System.in)); }
    String next() {
        while (st == null || !st.hasMoreElements()) {
            try { st = new StringTokenizer(br.readLine()); } catch (IOException e) { return null; }
        }
        return st.nextToken();
    }
    int nextInt() { return Integer.parseInt(next()); }
}

class Pair {
    int first, second;
    Pair(int f, int s) { first = f; second = s; }
}

public class entry_15039941 {
    public static void main(String[] args) {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = fr.nextInt();
        int x = fr.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = fr.nextInt();

        HashMap<Integer, List<Pair>> map = new HashMap<>();

        // store all pair sums
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = arr[i] + arr[j];
                map.computeIfAbsent(sum, k -> new ArrayList<>()).add(new Pair(i, j));
            }
        }

        // check complements
        for (Map.Entry<Integer, List<Pair>> entry : map.entrySet()) {
            int key = entry.getKey();
            int complement = x - key;
            if (map.containsKey(complement)) {
                for (Pair p1 : entry.getValue()) {
                    for (Pair p2 : map.get(complement)) {
                        if (p1.first != p2.first && p1.first != p2.second &&
                            p1.second != p2.first && p1.second != p2.second) {
                            out.printf("%d %d %d %d",
                                p1.first + 1, p1.second + 1, p2.first + 1, p2.second + 1);
                            out.flush();
                            return;
                        }
                    }
                }
            }
        }

        out.print("IMPOSSIBLE");
        out.flush();
    }
}