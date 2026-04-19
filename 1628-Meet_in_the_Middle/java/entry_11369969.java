import java.io.*;
import java.util.*;
import java.util.concurrent.*;
 
class entry_11369969 {
 
    // Generate subset sums iteratively
    static void calcSubsetSums(long[] array, long[] output, int n, int offset) {
        output[0] = 0; // Start with the empty subset
        int size = 1; // Current size of output
        for (int i = 0; i < n; i++) {
            int currentSize = size;
            for (int j = 0; j < currentSize; j++) {
                output[size++] = output[j] + array[i + offset];
            }
        }
    }
 
    // Count subsets with exact sum using two-pointer technique
    static long countSubsetSum(long[] array, int n, long target) {
        int mid = n >> 1;
 
        // Allocate memory for subset sums
        long[] X = new long[1 << mid];
        long[] Y = new long[1 << (n - mid)];
 
        // Generate subset sums iteratively
        calcSubsetSums(array, X, mid, 0);
        calcSubsetSums(array, Y, n - mid, mid);
 
        // Sort second-half subset sums
        Arrays.sort(Y);
 
        // Two-pointer technique for counting
        long count = 0;
        Arrays.sort(X); // Sort X as well for two-pointer approach
        int l = 0, r = Y.length - 1;
        while (l < X.length && r >= 0) {
            long sum = X[l] + Y[r];
            if (sum == target) {
                // Count occurrences of X[l] and Y[r]
                long xCount = 1, yCount = 1;
 
                while (l + 1 < X.length && X[l] == X[l + 1]) {
                    xCount++;
                    l++;
                }
                while (r - 1 >= 0 && Y[r] == Y[r - 1]) {
                    yCount++;
                    r--;
                }
                count += xCount * yCount;
                l++;
                r--;
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
 
        return count;
    }
 
    public static void main(String[] args) throws IOException {
        // Read input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
 
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);    // Number of elements
        long target = Long.parseLong(firstLine[1]); // Target sum
 
        long[] array = Arrays.stream(br.readLine().split(" "))
                             .mapToLong(Long::parseLong)
                             .toArray();
 
        // Solve the subset sum problem
        long result = countSubsetSum(array, n, target);
 
        // Output the result
        pw.println(result);
 
        pw.flush();
        pw.close();
    }
}