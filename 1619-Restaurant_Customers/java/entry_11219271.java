// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class entry_11219271 {

 static int n;
 static ArrayList<Customer> customers = new ArrayList<>();

 static class Customer implements Comparable<Customer> {
  int time, type;
  Customer(int time, int type) {
   this.time = time;
   this.type = type;
  }

  public int compareTo(Customer O) {
   return this.time - O.time;
  }
 }

 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);

  n = Integer.parseInt(r.readLine());

  StringTokenizer st;
  for(int i = 0; i < n; i++) {
   st = new StringTokenizer(r.readLine());
   Customer c1 = new Customer(Integer.parseInt(st.nextToken()), 1);
   Customer c2 = new Customer(Integer.parseInt(st.nextToken()), -1);
   customers.add(c1); customers.add(c2);
  }

  Collections.sort(customers);
  int max = 0, sum = 0;
  for(Customer temp : customers) {
   sum += temp.type;
   max = Math.max(max, sum);
  }

  pw.println(max);

  pw.close();
 }
}