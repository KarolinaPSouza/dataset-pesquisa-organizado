import java.util.*;
import java.io.*;
class Pairs{
    long digit;
    int ind;
    Pairs(long digit,int ind){
        this.digit = digit;
        this.ind = ind;
    }
}
public class entry_7386446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());
        ArrayList<Pairs> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr.add(new Pairs(Long.parseLong(st.nextToken()), i + 1));
        }

        // Sort the array by digit values
        Collections.sort(arr, Comparator.comparingLong(pair -> pair.digit));

        // Find two elements that sum up to 'm'
        int left = 0;
        int right = n - 1;

        while (left < right) {
            long sum = arr.get(left).digit + arr.get(right).digit;

            if (sum == m) {
                // Found a pair with the target sum
                int index1 = arr.get(left).ind;
                int index2 = arr.get(right).ind;
                System.out.println(index1 + " " + index2);
                return;
            } else if (sum < m) {
                left++;
            } else {
                right--;
            }
        }

        // If no such pair is found
        System.out.println("IMPOSSIBLE");
    }
}