import java.util.*;
import java.io.*;

public class entry_5250715 {
 static class Movie implements Comparable<Movie>{
  int start, end;
  public Movie(int s, int e) {
   start = s; end = e;
  }
  public int compareTo(Movie o) {
   return end-o.end;
  }
 }
 public static void main(String[] args) throws IOException{
  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
  String[] input = reader.readLine().split(" ");
  int movies = Integer.parseInt(input[0]);
  int members = Integer.parseInt(input[1]);
  if (members>199998) {
   System.out.println(200000);
   return;

  }
  ArrayList<Movie> times = new ArrayList<Movie>();
  for (int i=0; i<movies; i++) {
   input = reader.readLine().split(" ");
   times.add(new Movie(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
  }
  Collections.sort(times);
  TreeMap<Integer, Integer> available = new TreeMap<Integer, Integer>();
  available.put(0, members);
  int time = 0;
  int watched = 0;
  int index = 0;
  while (index<movies) {
   if (time<available.firstKey()) {
    time = available.firstKey();
   }
   if (times.get(index).start<time) {
    index++;
    continue;
   }
   Map.Entry<Integer, Integer> select = available.floorEntry(times.get(index).start);
   if (select.getValue()==1) {
    available.remove(select.getKey());
   } else {
    available.put(select.getKey(), select.getValue()-1);
   }
   if (available.containsKey(times.get(index).end)) {
    available.put(times.get(index).end, available.get(times.get(index).end)+1);
   } else {
    available.put(times.get(index).end, 1);
   }
   index++;
   watched++;
  }
  System.out.println(watched);
 }
}