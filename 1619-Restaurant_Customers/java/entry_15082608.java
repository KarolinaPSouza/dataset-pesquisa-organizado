import java.io.*;
import java.util.*;

public class entry_15082608 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine().trim());

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                set.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(set.size());
    }
}