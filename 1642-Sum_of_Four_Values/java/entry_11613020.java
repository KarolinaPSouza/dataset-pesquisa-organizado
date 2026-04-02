import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
    int time;
    int id;

    public Pair(int time, int id) {
        this.time = time;
        this.id = id;
    }

    @Override
    public int compareTo(Pair other) {
        return this.time - other.time;
    }
}

public class entry_11613020 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int target = sc.nextInt();
        Pair[] nums = new Pair[n];

        // Read the input and store original indices
        for (int i = 0; i < n; i++) {
            nums[i] = new Pair(sc.nextInt(), i + 1); // Store 1-based index
        }

        // Sort the array based on time
        Arrays.sort(nums);

        // Iterate to find the quadruplet
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i].time == nums[i - 1].time) continue; // Avoid duplicates for i
            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j].time == nums[j - 1].time) continue; // Avoid duplicates for j
                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = (long) nums[i].time + nums[j].time + nums[k].time + nums[l].time;
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        // Print the original indices of the four values
                        System.out.println(nums[i].id + " " + nums[j].id + " " + nums[k].id + " " + nums[l].id);
                        return;
                    }
                }
            }
        }

        // If no solution is found
        System.out.println("IMPOSSIBLE");
    }
}
