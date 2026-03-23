import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class entry_1722342 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        int m = Integer.parseInt(st[1]);
        int k = Integer.parseInt(st[2]);
        st = br.readLine().split(" ");
        PriorityQueue<Integer> applicants = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            applicants.add(Integer.parseInt(st[i]));
        }
        st = br.readLine().split(" ");
        PriorityQueue<Integer> apartments = new PriorityQueue<>(m);
        for (int i = 0; i < m; i++) {
            apartments.add(Integer.parseInt(st[i]));
        }
        int res = 0;
        while (applicants.size() > 0 && apartments.size() > 0) {
            int desired_size = applicants.peek();
            int actual_size = apartments.peek();
            int diff = actual_size - desired_size;
            if (Math.abs(diff) > k) {
                boolean actual_is_bigger = diff > 0;
                if (actual_is_bigger) {
                    // move applicants
                    applicants.poll();
                } else {
                    // move apartments
                    apartments.poll();
                }
            } else {
                res++;
                applicants.poll();
                apartments.poll();
            }
        }
        System.out.println(res);
    }
}