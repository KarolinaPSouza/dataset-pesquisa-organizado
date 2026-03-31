import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_11213952 {

    public static void main(String[] args) {
        FastScanner fastScanner = new FastScanner();

        int totalCustomerCount = fastScanner.nextInt();
        List<Entry> timePeopleChangeList = new ArrayList<>();
        for (int i = 0; i < totalCustomerCount; ++i) {
            int arrivalTime = fastScanner.nextInt();
            int departureTime = fastScanner.nextInt();

            timePeopleChangeList.add(new Entry(arrivalTime, 1));
            timePeopleChangeList.add(new Entry(departureTime, -1));
        }

        Comparator<Entry> comparator = (o1, o2) -> Integer.compare(o1.time, o2.time);
        Collections.sort(timePeopleChangeList, comparator);

        int currentPeopleInRestaurant = 0;
        int maxPeopleInRestaurant = 0;
        for (int i = 0, j = 0; i < timePeopleChangeList.size(); i = j) {
            while (j < timePeopleChangeList.size() &&
                    timePeopleChangeList.get(j).time == timePeopleChangeList.get(i).time) {
                currentPeopleInRestaurant += timePeopleChangeList.get(j).delta;
                ++j;
            }
            maxPeopleInRestaurant = Math.max(maxPeopleInRestaurant, currentPeopleInRestaurant);
        }

        System.out.println(maxPeopleInRestaurant);
    }

    static class Entry {
        int time;
        int delta;

        public Entry(int time, int delta) {
            this.time = time;
            this.delta = delta;
        }
    }

    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }
    }
}