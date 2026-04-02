import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_8500927 {
    public static long total;

    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(r.readLine());
        long N = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] primes = new long[K];

        st = new StringTokenizer(r.readLine());
        for(int i = 0; i < K; i++){
            primes[i] = Long.parseLong(st.nextToken());
        }

        total = 0L;
        backtrack2(primes, K, N, K, 0L);

        System.out.println(total);
    }

    public static void backtrack2(long[] primes, int K, long pastResult, int thisIndex, long binaryExpression){

        if (thisIndex != K) {

            pastResult /= primes[thisIndex];

            binaryExpression = binaryExpression + (1L << thisIndex);

            if (Long.bitCount(binaryExpression) % 2 == 1) {
                total += pastResult;
            } else {
                total -= pastResult;
            }
        }

        for(int i = thisIndex - 1; i >= 0; i--){
            backtrack2(primes, K, pastResult, i, binaryExpression);
        }
    }
}