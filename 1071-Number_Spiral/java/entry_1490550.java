import java.io.*;
import java.util.StringTokenizer;

public class entry_1490550 {
    public static void main(String[] args) throws IOException {
        FastReader fastReader = new FastReader();
        BufferedWriter output = new BufferedWriter(
                new OutputStreamWriter(System.out));

        int t = fastReader.nextInt();
        while (t-- > 0) {
            long y = fastReader.nextInt();
            long x = fastReader.nextInt();
            if (y < x) {
                if ((x & 1) == 0) {
                    output.write( (x - 1) * (x - 1) + y + "\n");
//                    System.out.println((x - 1) * (x - 1) + y);
                } else {
                    output.write( x * x - (y - 1)+ "\n");
//                    System.out.println(x * x - (y - 1));
                }
            } else {
                if ((y & 1) == 0) {
                    output.write(y * y - (x - 1) + "\n");
//                    System.out.println(y * y - (x - 1));
                } else {
                    output.write( (y - 1) * (y - 1) + x + "\n");
//                    System.out.println((y - 1) * (y - 1) + x);
                }
            }
        }
        output.flush();
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
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
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}