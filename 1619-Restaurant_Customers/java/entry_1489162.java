import java.util.*;
import java.io.*;

public class entry_1489162 {

 public static void main(String[] args) throws Exception {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int n = Integer.parseInt(br.readLine()); // number of customers
  ArrayList<Event> events = new ArrayList<>();
  for(int i = 0; i < n; i++) {
   StringTokenizer st = new StringTokenizer(br.readLine());
   int arrive = Integer.parseInt(st.nextToken());
   int leave = Integer.parseInt(st.nextToken());
   events.add(new Event(arrive, true));
   events.add(new Event(leave, false));
  }

  Collections.sort(events, (a, b) -> a.time - b.time);

  int answer = 0, current = 0;

  for(Event i : events) {
   if(i.enters) {
    current++;
   } else {
    current--;
   }

   answer = Math.max(answer, current);
  }

  System.out.println(answer);
 }

 static class Event {
  int time;
  boolean enters;

  Event(int t, boolean e) {
   time = t;
   enters = e;
  }
 }

}