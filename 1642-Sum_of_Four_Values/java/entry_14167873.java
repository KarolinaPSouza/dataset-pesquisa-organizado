import java.io.*;
import java.util.*;

public class entry_14167873 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        long target = Integer.parseInt(first[1]);
        int[] arr = new int[n];
        String[] parts = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }
        // Optimized O(n^2) solution using sorting and two pointers
        class Pair {
            int value, index;
            Pair(int value, int index) {
                this.value = value;
                this.index = index;
            }
        }
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(arr[i], i + 1); // 1-based index
        }
        Arrays.sort(pairs, Comparator.comparingInt(a -> a.value));
        boolean found = false;
        outer:
        for (int i = 0; i < n - 3; i++) {
            for(int j = i+1; j < n-2; j++) {
                int l = j + 1, r = n - 1;
                while (l < r) {
                    long sum = pairs[i].value + pairs[j].value + pairs[l].value + pairs[r].value;
                    if (sum == target) {
                        System.out.println(pairs[i].index + " " + pairs[j].index + " " + pairs[l].index + " " + pairs[r].index);
                        found = true;
                        break outer;
                    } else if (sum < target) {
                        l++;
                    } else {
                        r--;
                    }
                }
            }
        }
        if (!found) System.out.println("IMPOSSIBLE");
    }
}