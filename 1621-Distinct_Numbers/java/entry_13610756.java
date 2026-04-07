import java.io.*;
import java.util.*;

public class entry_13610756 {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pw = new PrintWriter(System.out);
    static final StringBuilder sb = new StringBuilder();

    static long maxLong = Long.MAX_VALUE;

    public static void main(String args[]) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        String[] nums = reader.readLine().split(" ");

        Set<Integer> st = new HashSet<>();
        for (String num : nums) {
            st.add(Integer.parseInt(num));
        }
        pw.println(st.size());
        reader.close();
        pw.close();
    }
}