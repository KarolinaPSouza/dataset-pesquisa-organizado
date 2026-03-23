import java.util.*;
import java.io.*;
public class entry_3667013 {
    public static void main(String[] args) throws IOException {
        Reader in = new Reader();
        PrintWriter out = new PrintWriter(System.out);

        int N = in.nextInt(), M = in.nextInt(), K = in.nextInt();
        int[] arr = new int[N], size = new int[M];
        for (int i = 0; i < N; i++) {
            arr[i] = in.nextInt();
        }
        for (int i = 0; i < M; i++) {
            size[i] = in.nextInt();
        }
        sort(arr);
        sort(size);
        int j = 0, res = 0;
        for (int i = 0; i < N; i++) {
            while (j < M && size[j] + K < arr[i]) {
                j++;
            }
            if (j < M && size[j] - K <= arr[i] && size[j] + K >= arr[i]) {
                res++;
                j++;
            }
        }
        out.println(res);

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
            int c;
            int res = 0;
            while ((c = in.read()) != ' ' && c != '\n')
                res = res * 10 + c - '0';
            return res;
        }
        public long nextLong() throws IOException {
            int c;
            long res = 0;
            while ((c = in.read()) != ' ' && c != '\n')
                res = res * 10 + c - '0';
            return res;
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