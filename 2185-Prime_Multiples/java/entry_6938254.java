import java.util.*;
import java.io.*;

public class entry_6938254 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] numbers = new long[K];
        long answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            numbers[i] = Long.parseLong(st.nextToken());
        }

        for (long i = 1; i < 1 << K; i++) {
            long number = 1;
            for (int j = 0; j < K; j++) {
                if ((i & (1 << j)) > 0) {
                    if (number > N / numbers[j]) {
                        number = N + 1;
                        break;
                    }
                    number *= numbers[j];
                }
            }
            if (Long.bitCount(i) % 2 == 1) {
                answer += Math.floorDiv(N, number);
            } else {
                answer -= Math.floorDiv(N, number);
            }
        }

        pw.println(answer);

        br.close();
        pw.close();
    }
}