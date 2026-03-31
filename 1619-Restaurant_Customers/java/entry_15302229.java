import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_15302229 {

   static  class Customer implements Comparable<Customer>{
        int time;
        String type;

        public Customer(int time, String type) {
            this.time = time;
            this.type = type;
        }

        @Override
        public int compareTo(Customer other) {
            return time - other.time;
        }
    }


    public static void main(String[] args) {
        FastReader input = new FastReader();
        int n = input.nextInt();

        int currentCustomer= 0;
        int maxCustomer = 0;

        ArrayList<Customer> customers = new ArrayList<>();




        for (int i = 0; i < n; i++) {
            int arrive = input.nextInt();
            int leaving = input.nextInt();
            customers.add(new Customer(arrive, "in"));
            customers.add(new Customer(leaving, "out"));
        }

        Collections.sort(customers);

        for(Customer c: customers) {
            if(c.type == "in"){
                currentCustomer++;
            }
            else
                currentCustomer--;

            maxCustomer = Math.max(maxCustomer, currentCustomer);
        }
        System.out.println(maxCustomer);
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

