// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class entry_5928104 {

 public static void main(String[] args) throws IOException {
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter out = new PrintWriter(System.out);

  StringTokenizer st = new StringTokenizer(in.readLine());

  long[] nums = new long[Integer.parseInt(st.nextToken())];

  st = new StringTokenizer(in.readLine());
  for(int i = 0; i < nums.length; i++) {
   nums[i] = Long.parseLong(st.nextToken());
   if(i == 0 ) {
    continue;
   }
   nums[i] += nums[i-1];
  }

  long max = nums[0];
  long min = 0;

  for(long i : nums) {
   max = Math.max(max, i - min);
   min = Math.min(min, i);
  }

  out.println(max);

  out.close();
 }
}