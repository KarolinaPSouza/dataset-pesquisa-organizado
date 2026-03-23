import java.util.*;
import java.io.*;

public class entry_838007 {
 public static void main(String[] args) throws IOException {
  Scanner sc = new Scanner(System.in);
  StringBuilder sb = new StringBuilder();
  int t = sc.nextInt();
  for (int i = 0; i < t; i++) {
   int x = sc.nextInt();
   int y = sc.nextInt();
   long v = 1L * Math.max(x,y);
   long ans = v * v - v + 1;
   if (x == y) {
    sb.append(ans+"\entry_838007");
   } else if (x > y) {
    if (x % 2 == 1) {
     ans += y-x;
    } else {
     ans += x-y;
    }
    sb.append(ans+"\entry_838007");
   } else {
    if (y % 2 == 0) {
     ans += x-y;
    } else {
     ans += y-x;
    }
    sb.append(ans+"\entry_838007");
   }
  }
  System.out.println(sb.toString());
 }
}