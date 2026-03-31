import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class entry_2844943 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int totalEntries = Integer.parseInt(br.readLine());

        int[] in = new int[totalEntries];
        int[] out = new int[totalEntries];

        for (int i = 0; i < totalEntries; i++) {
            String[] tokens = br.readLine().split(" ");
            in[i] = Integer.parseInt(tokens[0]);
            out[i] = Integer.parseInt(tokens[1]);
        }

        Arrays.sort(in);
        Arrays.sort(out);

        int i = 0;
        int j = 0;
        int runningCount = 0;
        int maxCustomers = 0;

        while (i < totalEntries && j < totalEntries) {
            if (in[i] < out[j]) {
                runningCount++;
                i++;
                maxCustomers = Math.max(maxCustomers, runningCount);
            } else {
                runningCount--;
                j++;
            }
        }
        System.out.println(maxCustomers);
    }
}