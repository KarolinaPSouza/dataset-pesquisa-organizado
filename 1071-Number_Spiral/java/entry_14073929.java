//package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class entry_14073929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        // Read the number of test cases
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // Read y and x from the same line and parse them as long
            String[] parts = br.readLine().split(" ");
            long y = Long.parseLong(parts[0]);
            long x = Long.parseLong(parts[1]);

            long result;

            // Find the layer of the spiral
            long layer = Math.max(y, x);

            // The largest number in the previous layer's square
            long prevLayerMax = (layer - 1) * (layer - 1);

            if (layer % 2 == 0) { // If the layer number is EVEN
                prevLayerMax += y + layer - x;
            } else { // If the layer number is ODD
                prevLayerMax += x + layer - y;
            }
            pw.println(prevLayerMax);
        }
        pw.flush();
    }
}