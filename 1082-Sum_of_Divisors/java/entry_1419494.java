//package divisors;

import java.io.*;
import java.util.*;

public class entry_1419494 {

 private final long MOD = 1000000007;

 public static void main(String[] args) throws IOException {

  entry_1419494 obj = new entry_1419494();

  obj.doStuff();

 }

 private long range(long lo, long hi) {
  /*
  BigInteger b1 = new BigInteger(Long.toString(lo));
  BigInteger b2 = new BigInteger(Long.toString(hi));
  b1 = b1.multiply(b1.add(BigInteger.ONE)).divide(BigInteger.TWO);
  b2 = b2.multiply(b2.add(BigInteger.ONE)).divide(BigInteger.TWO);
  BigInteger ans = b2.subtract(b1).mod(new BigInteger("1000000007"));
  return Long.parseLong(ans.toString());
  */
  lo = lo%MOD; hi = hi%MOD;
  return (((hi*(hi+1))/2)%MOD - ((lo*(lo+1)/2))%MOD + MOD)%MOD;
 }

 private void doStuff() throws IOException {

  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

  StringTokenizer st = new StringTokenizer(br.readLine());
  long num = Long.parseLong(st.nextToken());
  long ans = 0;

  long curPos = 1;
  while (curPos <= num) {
   long times = num / curPos;
   long maxVal = num / times;
   ans += (times * range(curPos-1, maxVal))%MOD;
   ans %= MOD;
   curPos = maxVal+1;
  }

  System.out.println(ans);

 }

}