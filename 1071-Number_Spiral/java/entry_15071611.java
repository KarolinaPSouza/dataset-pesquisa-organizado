import java.io.*; 
import java.util.*; 

public class entry_15071611 {
    private static final long MOD = 1000000007; 
    private static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        // if (System.getProperty("ONLINE_JUDGE") == null) { 
        //     PrintStream ps = new PrintStream(new File("/Users/kzaydahmed/Desktop/Practice_Pro/cses/output.txt")); 
        //     InputStream is = new FileInputStream("/Users/kzaydahmed/Desktop/Practice_Pro/cses/input.txt"); 
        //     System.setIn(is); 
        //     System.setOut(ps); 
        // } 

        ReadInput in = new ReadInput(); 

        int T = in.nextInt(); 
        while (T-- > 0) {
            long N = in.nextLong(); // row
            long M = in.nextLong(); // col

            if (N <= M) {
                if ((M&1) == 1) {
                    out.println((M*M)-(N-1));
                }
                else {
                    out.println((M-1)*(M-1)+(N));
                }
            }   
            else {
                if ((N&1) == 1) {
                    out.println(((N-1)*(N-1))+(M));
                }
                else {
                    out.println((N*N)-(M-1));
                }
            }
        }
        out.flush(); 
    }    

    static class ReadInput {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
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
    }
}