// Source: https://usaco.guide/general/io

import java.io.*;
import java.util.*;

public class entry_4810964 {

 static ArrayList<Integer> indices;

 static int getCompressedIndex(int a) {
  return Collections.binarySearch(indices, a);
 }

 public static void main(String[] args) throws IOException {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  PrintWriter pw = new PrintWriter(System.out);
  int N = Integer.parseInt(br.readLine());
  int[] start = new int[N];
  int[] end = new int[N];
  // indices = new ArrayList<Integer>();
  for(int i = 0; i < N; i++) {
   StringTokenizer st = new StringTokenizer(br.readLine());
   start[i] = Integer.parseInt(st.nextToken());
   end[i] = Integer.parseInt(st.nextToken());
   // indices.add(start[i]); indices.add(end[i]);
  }
  // TreeSet<Integer> temp = new TreeSet<Integer>(indices);
  // indices.clear();
  // indices.addAll(temp);
  Arrays.sort(start);
  Arrays.sort(end);
  int max = 0;
  int startIndex = 0;
  int endIndex = 0;
  int curr = 0;
  while(startIndex != N) {
   if(start[startIndex] < end[endIndex]) {
    startIndex++;
    curr++;
   } else {
    endIndex++;
    curr--;
   }
   max = Math.max(curr, max);
  }
  pw.println(max);
  pw.close();
 }
}