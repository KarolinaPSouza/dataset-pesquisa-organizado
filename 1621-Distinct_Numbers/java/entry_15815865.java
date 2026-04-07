import java.io.*;
import java.util.*;

public class entry_15815865 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> hs = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            hs.add(val);
        }

        System.out.println(hs.size());
    }
}