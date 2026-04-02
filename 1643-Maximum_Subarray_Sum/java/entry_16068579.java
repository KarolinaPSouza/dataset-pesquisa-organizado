import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_16068579 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long maxSum = Long.MIN_VALUE;
        long currentSum = 0;
        for (int i = 0; i < n; i++) {
            currentSum += arr[i];
            maxSum = Math.max(maxSum, currentSum);

            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        System.out.println(maxSum);
    }
}