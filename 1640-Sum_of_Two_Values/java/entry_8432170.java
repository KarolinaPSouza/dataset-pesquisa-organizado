import java.util.*;
import java.io.*;

public class entry_8432170 {

 static BufferedReader in;
 static StringTokenizer st;
 static int n, x, cur, seek;
 static HashMap<Integer, Integer> m;

 public static void main(String[] args) throws IOException{
   in = new BufferedReader(new InputStreamReader(System.in)); 
   st = new StringTokenizer(in.readLine());

   //get data
   n = Integer.parseInt(st.nextToken());
   x = Integer.parseInt(st.nextToken());

   m = new HashMap<Integer, Integer>();
   //processing
   st  = new StringTokenizer(in.readLine());

   boolean found = false;
   for(int i = 1; i <= n; i++) {
    cur = Integer.parseInt(st.nextToken());
    seek = x-cur;

    if (m.containsKey(seek)) {
     System.out.println(m.get(seek) + " " + i);
     found = true;
     break;
    }
    else {
     m.put(cur, i);
    }
   }

   if (!found) System.out.println("IMPOSSIBLE");
 }

}