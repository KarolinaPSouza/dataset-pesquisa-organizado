import java.io.*;
import java.util.*;

public class entry_15110295 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        Set<Integer> distinct = new HashSet<>();

        int n = Integer.parseInt(r.readLine());

        for (int i = 0; i < n; i++) {
            String[] nums = r.readLine().split(" ");
            for (String num : nums) {
                distinct.add(Integer.parseInt(num));
            }
        }

        pw.println(distinct.size());
        pw.close();
    }
}