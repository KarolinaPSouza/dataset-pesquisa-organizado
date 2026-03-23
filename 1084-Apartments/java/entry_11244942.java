import java.io.*;
import java.util.*;


public class entry_11244942 {
    static class InputReader {

        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        String next() { // reads in the next string
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() { // reads in the next int
            return Integer.parseInt(next());
        }

        public long nextLong() { // reads in the next long
            return Long.parseLong(next());
        }

        public double nextDouble() { // reads in the next double
            return Double.parseDouble(next());
        }
    }


    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);

    public static void main(String[] args) {


        int n = r.nextInt();
        int m = r.nextInt();
        int k = r.nextInt();
        int counter = 0;
        ArrayList<Integer> d = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        for (int i=0; i<n; i++) {
            int x = r.nextInt();
            d.add(x);
        }

        for (int j=0; j<m; j++) {
            int z = r.nextInt();
            b.add(z);
        }

        Collections.sort(d);
        Collections.sort(b);

        int i = 0, j = 0;
    while (i < n && j < m) {
        if (Math.abs(d.get(i) - b.get(j)) <= k) {
            counter++;
            i++;
            j++;
        } else if (d.get(i) < b.get(j)) {
            i++;
        } else {
            j++;
        }
    }


        System.out.println(counter);

        pw.close(); // flushes the output once printing is done

    }

         //DATA STRUCTURES

        //Arraylist - basic add and remove based off index
        //Stacks - Last in First Out
        //Queues (Using Linked List) - First in First Out
        //Deques - Insertions and Deletions from both ends
        //Priority Qeues (Important) - Insertion and Deletion based on priority
        //HashSet - Unordered Set - insert, delete, and searching for elements
        //TreeSet - Best for searching for elements
        //HashMap - key:value pairs
        //TreeMap - key:value pairs with better searching features
        //Multiset through Tree Map - TreeSet that allows repetition
}