import java.io.*;
import java.util.HashSet;
import java.util.StringTokenizer;

public class entry_14833403 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                set.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.println(set.size());
    }
}