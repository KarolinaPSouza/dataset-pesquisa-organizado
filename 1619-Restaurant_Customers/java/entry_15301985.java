import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_15301985 {

    static class FastReader {
        BufferedReader b;
        StringTokenizer s;

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return s.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();

        int n = fr.nextInt();

        ArrayList<Integer> arrive = new ArrayList<>();
        ArrayList<Integer> leave = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int a = fr.nextInt();
            int b = fr.nextInt();
            arrive.add(a);
            leave.add(b);
        }

        Collections.sort(arrive);
        Collections.sort(leave);

        int i = 0, j = 0;
        int current = 0;
        int maxPeople = 0;

        while (i < n && j < n) {
            if (arrive.get(i) < leave.get(j)) {
                current++;
                maxPeople = Math.max(maxPeople, current);
                i++;
            } else {
                current--;
                j++;
            }
        }

        System.out.println(maxPeople);
    }
}