import java.io.*;
import java.util.*;

public class entry_13430298 {
    public static void main(String[] args) throws IOException {
        // Fast input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        int k = Integer.parseInt(first[2]);

        String[] aStr = br.readLine().split(" ");
        String[] bStr = br.readLine().split(" ");

        PriorityQueue<Integer> applicants = new PriorityQueue<>();
        PriorityQueue<Integer> apartments = new PriorityQueue<>();

        for (int i = 0; i < n; i++) applicants.add(Integer.parseInt(aStr[i]));
        for (int i = 0; i < m; i++) apartments.add(Integer.parseInt(bStr[i]));

        int count = 0;

        while (!applicants.isEmpty() && !apartments.isEmpty()) {
            int applicant = applicants.peek();
            int apartment = apartments.peek();

            if (Math.abs(applicant - apartment) <= k) {
                count++;
                applicants.poll();
                apartments.poll();
            } else if (apartment < applicant - k) {
                apartments.poll(); // too small, try next apartment
            } else {
                applicants.poll(); // too big, try next applicant
            }
        }

        System.out.println(count);
    }
}