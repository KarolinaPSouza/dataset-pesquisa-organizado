import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_12027473 {
    static class Event {
        int time;
        int action;     // 1:进来，-1出去

        public Event(int time, int action) {
            this.time = time;
            this.action = action;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        List<Event> events = new ArrayList<>();
        int n = Integer.parseInt(f.readLine());
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(f.readLine());
            int arrive = Integer.parseInt(st.nextToken());
            int leave = Integer.parseInt(st.nextToken());
            events.add(new Event(arrive, 1));
            events.add(new Event(leave, -1));
        }
        events.sort((o1, o2) -> o1.time - o2.time);
        int current = 0;
        int max = 0;
        for (Event event : events) {
            current += event.action;
            max = Math.max(max, current);
        }
        System.out.println(max);
    }

}