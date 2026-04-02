import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class entry_12689647 {
    public static int total;

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

        System.out.println(backtrack(primes, 0, N, false));
    }

    public static long backtrack(long[] primes, int primeIndex, long value, boolean isEven){
        if (primeIndex >= primes.length) return 0;
        long result = 0;
        long nextVal = value / primes[primeIndex]; // aka, number of result
        result += (isEven? -1:1) * nextVal;
        result += backtrack(primes, primeIndex+1, value, isEven);
        result += backtrack(primes, primeIndex+1, nextVal, !isEven);
        return result;
    }

}