import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * You are given the arrival and leaving times of n customers in a restaurant.
 *
 * What was the maximum number of customers?
 *
 * Input
 *
 * The first input line has an integer n: the number of customers.
 *
 * After this, there are n lines that describe the customers.
 * Each line has two integers a and b: the arrival and leaving times of a customer.
 *
 * You may assume that all arrival and leaving times are distinct.
 *
 * Output
 *
 * Print one integer: the maximum number of customers.
 * */
public class entry_264020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        List<Event> events = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            events.add(new Event(Integer.parseInt(st.nextToken()), true));
            events.add(new Event(Integer.parseInt(st.nextToken()), false));
        }

        events.sort(Event::compareTo);

        int maxCustomers = 0;
        int cnt = 0;
        for (Event e: events) {
            if (e.arrival) {
                cnt++;
            } else {
                maxCustomers = Math.max(maxCustomers, cnt);
                cnt--;
            }
        }

        System.out.println(maxCustomers);

    }

    private static class Event implements Comparable<Event> {
        private int time;
        private boolean arrival;

        public Event(int time, boolean arrival) {
            this.time = time;
            this.arrival = arrival;
        }

        @Override
        public int compareTo(Event o) {
            return this.time - o.time;
        }
    }
}