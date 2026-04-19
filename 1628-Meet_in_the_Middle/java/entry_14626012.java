import java.io.*;
import java.util.*;
 
//took help from this https://cses.fi/problemset/hack/1628/entry/11369969/
class entry_14626012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
        String[] tokens = br.readLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int x = Integer.parseInt(tokens[1]);
        long[] arr = Arrays.stream(br.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
 
        int mid = n>>1;
        long[] leftSums = new long[1<<mid];
        getSubsetSums(arr, leftSums, mid, 0);
        long[] rightSums = new long[1 << (n - mid)];
        getSubsetSums(arr, rightSums,n-mid, mid);
 
        Arrays.sort(leftSums);
        Arrays.sort(rightSums);
 
        long count = countPairs(leftSums, rightSums, x);
        System.out.println(count);
    }
 
    public static void getSubsetSums(long[] arr, long[] sums, int n, int offset) {
        sums[0]=0;
        int size=1;
        for(int i=0;i<n;i++) {
            int currentSize = size;
            for(int j=0;j<currentSize;j++) {
                sums[size++]=sums[j]+arr[i+offset];
            }
        }
    }
 
    // two-pointer method to count matching pairs
    public static long countPairs(long[] left, long[] right, long target) {
        long count = 0;
        //i=j since skipping repeated numbers
        int r = right.length - 1;
        for (int i = 0, j = 0; i < left.length; i = j) {
            while (j < left.length && left[i] == left[j])
                j++; //i is already incremented here, i=j
            while (r >= 0 && left[i] + right[r] > target)
                r--;
            while (r >= 0 && left[i] + right[r] == target) {
                count += j - i;
                r--;
            }
        }
        return count;
    }
}
