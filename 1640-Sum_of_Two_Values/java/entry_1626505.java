import java.util.*;
import java.io.*;

class Pair implements Comparable<Pair>{
 int x;
 int i;

 Pair(int x, int i){
  this.x = x;
  this.i = i;
 }

 @Override
 public int compareTo(Pair o) {
  return x-o.x;
 }

}

public class entry_1626505 {

 public static void main(String args[]) throws IOException {
  BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(in.readLine());
  int n = Integer.parseInt(st.nextToken());
  int x = Integer.parseInt(st.nextToken());
  StringTokenizer line = new StringTokenizer(in.readLine());
  Pair[] arr = new Pair[n];
  for(int i=0; i<n; i++) {
   arr[i] = new Pair(Integer.parseInt(line.nextToken()),i);
  }
  Arrays.sort(arr);
  int i=0;
  int j=n-1;
  boolean possible = false;
  while(i<j) {
   int y = arr[i].x+arr[j].x;
   if(y==x) {
    possible = true;
    break;
   }
   else if(y<x) {
    i++;
   }
   else {
    j--;
   }
  }
  if(possible) {
   System.out.println((arr[i].i+1)+" "+(arr[j].i+1));
  }
  else {
   System.out.println("IMPOSSIBLE");
  }
 }

}