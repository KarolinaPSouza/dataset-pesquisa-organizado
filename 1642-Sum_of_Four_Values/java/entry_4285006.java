// Map based question

import java.util.*;
import java.io.*;
public class entry_4285006 {
    static class Pair { 
  int i, j;
  Pair(int i, int j) {
   this.i = i; 
      this.j = j;  
  }
 }
    public static void main(String[] args) throws Exception {

  Scanner sc = new Scanner(System.in);
  int n = sc.nextInt();  
  int target = sc.nextInt();
  int a[] = new int[n]; 
  for(int i = 0; i < n; i++) {
   a[i] = sc.nextInt(); 
  }
  Map<Integer, Pair> map = new HashMap<>(); 
  for(int i = 0; i < n; i++) {
   for(int j = i+1; j < n; j++) {
    int sum = a[i]+a[j]; 
    if(!map.containsKey(sum)) {
     map.put(sum, new Pair(i, j)); 
    }
   }
  } 
  boolean found = false; 
  for(int i = 0; i < n; i++) {
   for(int j = i+1; j < n; j++) {
    int sum = a[i]+a[j]; 
    if(map.containsKey(target-sum)) {
     Pair p = map.get(target-sum);
     if(i != p.i && i != p.j && j != p.i && j != p.j) {
      System.out.println((i+1)+" "+(j+1)+" "+(p.i+1)+" "+(p.j+1)); 
      found = true; 
      break;
     }
    }
   }
   if(found) break;
  }
  if(!found) System.out.println("IMPOSSIBLE");

    }
}
