import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Given an array of n integers, your task is to find the maximum sum of values in a contiguous, nonempty subarray.
 *
 * Input
 *
 * The first input line has an integer n: the size of the array.
 *
 * The second line has n integers x1,x2,…,xn: the array values.
 *
 * Output
 *
 * Print one integer: the maximum subarray sum.
 * */
public class entry_264672 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        final int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // need to find max sum for subarray ended in k position
        // two possible options: 1) arr[k] + subarray ended in k-1 pos, 2) arr[k] subarray
        // sum must be max in these two cases
        long maxSum = Long.MIN_VALUE;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum = Math.max(arr[i], sum+arr[i]);
            maxSum = Math.max(maxSum, sum);
        }

        System.out.println(maxSum);

    }
}