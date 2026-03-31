// Restaurant Customers

import java.io.*;
import java.util.*;

public class entry_5007970 {
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(r.readLine());
        int n = Integer.parseInt(st.nextToken());

        ArrayList<Integer> arrive = new ArrayList<Integer>(n);
        ArrayList<Integer> leave = new ArrayList<Integer>(n);

        for (int i = 0; i < n; i++) {
            StringTokenizer stt = new StringTokenizer(r.readLine());
            int a = Integer.parseInt(stt.nextToken());
            arrive.add(a);
            int b = Integer.parseInt(stt.nextToken());
            leave.add(b);
        }

        Collections.sort(arrive);
        Collections.sort(leave);

        int maxCount = 0;
        int cur = 0;
        int a = 0;
        int b = 0;
        while (a < n) {
            if (arrive.get(a) < leave.get(b)) {
                cur++;
                a++;
                if (cur > maxCount) {
                maxCount = cur;
                }
                continue;
            }
            if (arrive.get(a) > leave.get(b)) {
                cur--;
                b++;
                continue;
            }
            a++;
            b++;
        }

        System.out.println(maxCount);
    }
}