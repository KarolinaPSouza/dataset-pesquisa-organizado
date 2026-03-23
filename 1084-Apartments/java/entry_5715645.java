import java.util.*;
import java.io.*;

public class entry_5715645 {
    public static void main(String[] args) throws java.lang.Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inp = br.readLine().trim().split(" ");
        int n = Integer.parseInt(inp[0]);
        int m = Integer.parseInt(inp[1]);
        int k = Integer.parseInt(inp[2]);
        String[] free = br.readLine().trim().split(" ");
        String[] apar = br.readLine().trim().split(" ");
        List<Integer> a = new ArrayList<>(free.length);
        List<Integer> b = new ArrayList<>(apar.length);
        for (String x : free) {
            a.add(Integer.parseInt(x));
        }
        for (String x : apar) {
            b.add(Integer.parseInt(x));
        }
        Collections.sort(a);
        Collections.sort(b);
        // System.out.println(a);
        // System.out.println(b);
        int ptr1 = 0, ptr2 = 0;
        int ct = 0;
        while (ptr1 < n && ptr2 < m) {
            if (b.get(ptr2) >= (a.get(ptr1) - k) && b.get(ptr2) <= (a.get(ptr1) + k)) {
                ptr1++;
                ptr2++;
                ct++;
            } else if (b.get(ptr2) < a.get(ptr1)-k) {
                ptr2++;
            } else {
                ptr1++;
            }

        }
        System.out.println(ct);
    }
}