import java.io.*;
import java.util.*;

public class entry_15815865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                hs.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(hs.size());
    }
}