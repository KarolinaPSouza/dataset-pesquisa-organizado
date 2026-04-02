import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class entry_15366838 {

    static class Number implements Comparable<Number>{
        int value, position;

        public Number(int value, int position) {
            this.value = value;
            this.position = position;
        }

        @Override
        public int compareTo(Number other) {
            return this.value - other.value;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "value=" + value +
                    ", position=" + position +
                    '}';
        }
    }

    public static void main(String[] args) {
        FastReader input = new FastReader();
        int n = input.nextInt();
        int x = input.nextInt();

        ArrayList<Number> list = new ArrayList<>();
        for(int i=0; i<n; i++){
            int val = input.nextInt();
            list.add( new Number(val, i+1) );
        }

        Collections.sort(list);


        for( int i=0; i<list.size(); i++){

            int target = x - list.get(i).value;

            int l=i+1, r=n-1;

            while( l <= r){
                int m = (l+r)/2;

                if( target == list.get(m).value){
                        System.out.println(list.get(i).position + " " + list.get(m).position);
                        return;
                }
                else if ( target > list.get(m).value){
                    l=m+1;
                }
                else{
                    r=m-1;
                }

            }


        }
        System.out.println("IMPOSSIBLE");

    }



    static class FastReader {

        // BufferedReader to read input
        BufferedReader b;

        // StringTokenizer to tokenize input
        StringTokenizer s;

        // Constructor to initialize BufferedReader
        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        // Method to read the next token as a string
        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        // Method to read the next token as an integer
        int nextInt() {
            return Integer.parseInt(next());
        }

        // Method to read the next token as a long
        long nextLong() {
            return Long.parseLong(next());
        }

        // Method to read the next token as a double
        double nextDouble() {
            return Double.parseDouble(next());
        }

        // Method to read the next line as a string
        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}