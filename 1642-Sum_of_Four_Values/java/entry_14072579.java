import java.io.*;
import java.util.*;

public class entry_14072579 {
    public static void main(String[] args) throws IOException {
        FastReader fr = new FastReader();
        PrintWriter out = new PrintWriter(System.out);
        int n = fr.nextInt();
        int x = fr.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = fr.nextInt();
        }
        Map<Integer,List<Pair>> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i +1; j <= n; j++) {
                int sum = arr[i] + arr[j];
                if (!map.containsKey(sum)) map.put(sum,new ArrayList<>());
                map.get(sum).add(new Pair(i,j));
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                int target = x - arr[i] - arr[j];
                List<Pair> list = map.getOrDefault(target,new ArrayList<>());
                for (Pair p: list) {
                    int k = p.f;
                    int l = p.s;
                    if (k != i && k != j && l != i && l != j) {
                        out.println(i + " "+ j + " "+ k +" "+ l);
                        out.close();
                        return;
                    }
                }
            }
        }
        out.println("IMPOSSIBLE");
        out.close();
    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    static class Pair {
        int f, s;
        Pair(int f, int s) {
            this.f = f;
            this.s = s;
        }
    }
}