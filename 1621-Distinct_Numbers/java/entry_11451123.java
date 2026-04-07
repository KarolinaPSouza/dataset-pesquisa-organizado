import java.io.*;
import java.util.*;

public class entry_11451123 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashSet<Integer> has = new HashSet<>();
        for (int i = 0; i<n; i++) has.add(Integer.parseInt(st.nextToken()));
        System.out.println(has.size());
    }
}