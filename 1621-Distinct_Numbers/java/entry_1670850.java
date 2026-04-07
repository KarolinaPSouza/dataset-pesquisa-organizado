import java.io.*;
import java.util.*;

public class entry_1670850 {
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

    }

    static InputReader r = new InputReader(System.in);
    static PrintWriter pw = new PrintWriter(System.out);
        public static void main(String args[]){
            int num = r.nextInt();
            int[] array = new int[num];
            for (int i = 0; i < num; i++){
                array[i] = r.nextInt();
            }
            HashSet<Integer> hs = new HashSet<Integer>();
            for (int i = 0; i < array.length; i++){
                hs.add(array[i]);
            }
            int count = hs.size();




            /*
            int num = r.nextInt();
            int count = 0;
            int[] array = new int[num];
            for (int i = 0; i < num; i++){
                array[i] = r.nextInt();
             }
            for (int i = 0; i < array.length; i++) {
                int j = 0;
                for (j = 0; j < i; j++) {
                    if (array[i] == array[j])
                        break;
                }
                 // If not printed earlier,
                // then print it
                if (i == j)
                    count++;
            }
              */

            pw.print(count);
            pw.close();
    }
}