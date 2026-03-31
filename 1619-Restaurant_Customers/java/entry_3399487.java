import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Restaurant {
 public static class Pair{
  int time;
  boolean flag;
  Pair(int time, boolean flag){
   this.time = time;
   this.flag = flag;
  }
 }
 public static class PairComparator implements Comparator<Pair>{
     public int compare(Pair a, Pair b){
         if(a.time == b.time){
             if(a.flag){
                 return -1;
             }else{
                 return 1;
             }
         }else{
             return a.time - b.time;
         }
     }
 }
 public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
  PriorityQueue<Pair> queue = new PriorityQueue(new PairComparator());
  while(n-- > 0){
   StringTokenizer str = new StringTokenizer(br.readLine());
   int a = Integer.parseInt(str.nextToken());
   int b = Integer.parseInt(str.nextToken());
   queue.offer(new Pair(a, true));
   queue.offer(new Pair(b, false));
  }
  int max = 0, count = 0;
  while(queue.size() > 0){
   Pair current = queue.poll();
   if(current.flag){
    count++;
    max = Math.max(count, max);
   }else{
       count--;
   }
  }
  System.out.println(max);
 }
}
