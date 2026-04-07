import java.util.*;
import java.io.*;

public class entry_1182744 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(in.readLine());
        TreeSet<Integer> set = new TreeSet<>();
        st = new StringTokenizer(in.readLine());
        for (int i = 0; i<N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        out.println(set.size());
        in.close();
        out.close();
    }

}