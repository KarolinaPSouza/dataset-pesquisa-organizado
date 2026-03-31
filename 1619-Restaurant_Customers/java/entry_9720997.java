import java.util.*;
import java.io.*;


public class entry_9720997 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    static class Pair{
        long a;
        long b;
        public Pair(long a, long b){
            this.a = a;
            this.b = b;
        }
    }

    static class CustomComparator implements Comparator<Pair> {

        // override the compare() method
        public int compare(Pair s1, Pair s2) {
            if (s1.a == s2.a)
                return 0;
            else if (s1.a > s2.a)
                return 1;
            else
                return -1;
        }
    }


    public static void main(String[] args) throws IOException{
        FastReader sc = new FastReader();
        FastWriter out = new FastWriter();
        int n = sc.nextInt();
        ArrayList<Pair> arr = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            long start = sc.nextLong();
            long end = sc.nextLong();
            Pair p1 = new Pair(start, 1L);
            Pair p2 = new Pair(end, -1L);
            arr.add(p1);
            arr.add(p2);
        }
        Collections.sort(arr, new CustomComparator());
        long maxi = 0;
        long count = 0;
        for(int i = 0;i<arr.size();i++){
            count += arr.get(i).b;
            maxi = Math.max(count,maxi);
        }
        System.out.println(maxi);

        out.close();
    }
}