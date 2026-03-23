import java.io.*;
import java.util.*;

public class entry_15346583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) b.add(Integer.parseInt(st.nextToken()));

        Collections.sort(a);
        Collections.sort(b);

        int i = 0, j = 0, ans = 0;
        while (i < n && j < m) {
            long low = (long)a.get(i) - k;
            long high = (long)a.get(i) + k;
            long bj = b.get(j);

            if (bj < low) j++;
            else if (bj > high) i++;
            else {
                ans++;
                i++;
                j++;
            }
        }

        System.out.println(ans);
    }
}