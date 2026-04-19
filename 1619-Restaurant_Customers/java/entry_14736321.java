import java.io.*;
import java.util.*;

public class entry_14736321 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int n = Integer.parseInt(br.readLine().trim());

        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s.add(Integer.parseInt(st.nextToken()));
            s.add(Integer.parseInt(st.nextToken()));
        }

        out.println(s.size());
        out.flush();
    }
}