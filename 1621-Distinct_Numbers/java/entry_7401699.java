import java.io.*;
import java.util.*;

public class entry_7401699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        HashSet<Integer> distinctValues = new HashSet<>();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            distinctValues.add(x);
        }

        int distinctCount = distinctValues.size();
        System.out.println(distinctCount);
    }
}