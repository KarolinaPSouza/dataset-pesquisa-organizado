import java.io.*;
import java.text.*;
import java.util.*;
import java.math.*;
public class entry_4656648 {
    public static void main(String[] args) {
        FastScanner f = new FastScanner();
        PrintWriter out = new PrintWriter(System.out);
        int n = f.nextInt();
        int m = f.nextInt();
        int k = f.nextInt();
        ArrayList<Integer> apartment = new ArrayList<>();
        ArrayList<Integer> person = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            person.add(f.nextInt());
        }
        for (int i = 0; i < m; i++) {
            apartment.add(f.nextInt());
        }
        Collections.sort(apartment);
        Collections.sort(person);
        int per = 0;
        int apart = 0;
        int result = 0;
        while(per < person.size() && apart < apartment.size()) {
            int difference = Math.abs(person.get(per) - apartment.get(apart));
            if(difference <= k) {
                per++;
                apart++;
                result++;
            } else if(apartment.get(apart) >= person.get(per)) {
                per++;
            } else {
                apart++;
            }
        }
        out.println(result);
        out.flush();
    }

    static class FastScanner {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in), 32768);
            tokenizer = null;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}