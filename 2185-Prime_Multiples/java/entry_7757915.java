import java.io.*;
import java.util.*;

public class entry_7757915 {
 public static void main(String[] args) throws IOException {
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(in.readLine());

  long len = Long.parseLong(st.nextToken());
  int primes = Integer.parseInt(st.nextToken());
  long[] list = new long[primes];

  st = new StringTokenizer(in.readLine());
  for(int i = 0; i < primes; i++) {
   list[i] = Long.parseLong(st.nextToken());
  }

  //for(long i: list) System.out.println(i);

  long count = 0;
  long[] plist = new long[(1 << primes) + 1];
  for(int i = 1; i < (1 << primes); i++) {
   plist[i] = 1;
   OUTER: for(int j = 0; j < primes; j++) {
    //System.out.println((1 << j) & i);
    if(((1 << j) & i) != 0) {
     //System.out.println(i + " " + j);
     if(plist[i] > len / list[j]) {
      plist[i] = len + 1;
      break OUTER;
     }
     else {
      plist[i] *= list[j];
     }
    }
   }

   //System.out.println(plist[i]);
   if(plist[i] == -1) continue;
   if(Integer.bitCount(i) % 2 == 1) {
    count += (len / plist[i]);
   }
   else count -= (len / plist[i]);
  }

  System.out.println(count);
 }
}