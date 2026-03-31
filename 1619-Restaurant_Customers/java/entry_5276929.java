// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class entry_5276929 {
 public static void main(String[] args) throws IOException {
  BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);


  int n = Integer.parseInt(r.readLine());
  ArrayList<int[]> list = new ArrayList<int[]>();

  for(int i = 0; i < n; i++) {
   StringTokenizer st = new StringTokenizer(r.readLine());
   list.add(new int[]{Integer.parseInt(st.nextToken()), 1});
   list.add(new int[]{Integer.parseInt(st.nextToken()), -1});
  }
  Collections.sort(list, new Comp());
  int maxcount = 0;
  int count=0;
  for(int[] i:list) {
   count+= i[1];
   if(count>maxcount) maxcount = count;
  }
  pw.print(maxcount);

  pw.close();
 }
 static class Comp implements Comparator<int[]> {
  public int compare(int[] a, int[] b) {
   return Integer.compare(a[0], b[0]);
  }
 }
}