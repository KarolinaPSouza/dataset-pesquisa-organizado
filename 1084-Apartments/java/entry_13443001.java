import java.util.*;
import java.io.*;

public class entry_13443001 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] applicants = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            applicants[i] = Integer.parseInt(st.nextToken());
        }

        int[] apartments = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            apartments[i] = Integer.parseInt(st.nextToken());
        }


        PriorityQueue<Integer> a = new PriorityQueue<>();
        for(int i=0; i<n; ++i) {
            a.add(applicants[i]);
        }
        PriorityQueue<Integer> b = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            b.add(apartments[i]);
        }

        int count = 0;
        while (!a.isEmpty() && !b.isEmpty()) {
            if (Math.abs(a.peek() - b.peek()) <= k) {
                count++;
                a.remove();
                b.remove();
            } else if (a.peek() < b.peek() - k) {
                a.remove();
            } else {
                b.remove();
            }
        }

        System.out.println(count);
    }
}