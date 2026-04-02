import java.util.*;
import java.io.*;

public class entry_4101972 {

    static class Pairs implements Comparable<Pairs>{
        private int value; private int index;

        public Pairs(int value, int index){
            this.value = value;
            this.index = index;
        }

        public int compareTo(Pairs p){
            return Integer.compare(this.value,p.value);
        }
    }

    public static void main(String[] args){
        Kattio io = new Kattio();
        int n = io.nextInt();
        int x = io.nextInt();

        List<Pairs> arr = new ArrayList<>();

        for(int i = 0; i < n; i++){
            arr.add(new Pairs(io.nextInt(),i+1));
        }

        Collections.sort(arr);

        int left = 0;
        int right = (int) n-1;

        while(left < right){
            Pairs a = arr.get(left);
            Pairs b = arr.get(right);
            if(a.value + b.value == x){
                io.println(a.index + " " + b.index);
                io.close();
                return;
            } else if(a.value + b.value > x){
                right--;
            } else {
                left++;
            }
        }

        io.println("IMPOSSIBLE");
        io.close();
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) { }
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}