import java.util.*;
import java.io.*;
public class entry_4055820 {
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out);

        int N = in.nextInt(), K = in.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        HashMap<Integer, int[]> map = new HashMap<>();
        boolean found = false;
        i: for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (map.containsKey(K - arr[i] - arr[j])) {
                    int[] pair = map.get(K - arr[i] - arr[j]);
                    out.println((pair[0] + 1) + " " + (pair[1] + 1) + " " + (i + 1) + " " + (j + 1));
                    found = true;
                    break i;
                }
            }
            for (int j = 0; j < i; j++) {
                map.put(arr[j] + arr[i], new int[]{j, i});
            }
        }
        if (!found) {
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