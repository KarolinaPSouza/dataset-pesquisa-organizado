//package CSES;

import java.io.*;
import java.util.*;

public class entry_3332477 {

 static MyScanner sc = new MyScanner();
 static PrintWriter pw = new PrintWriter(System.out);

 static TreeMap<Integer,Integer> multiset = new TreeMap<>();


 public static void main(String[] args) throws IOException{

//  int applicants = sc.nextInt();
//  int appartments = sc.nextInt();
//  int diff = sc.nextInt();
//  
////  int choices[] = new int[applicants];
////  for(int i = 0; i<applicants; i++) {
////   choices[i] = sc.nextInt();
////  }
////  
////  ruffleSort(choices);
//  
//  PriorityQueue<Integer> pq = new PriorityQueue<>();
//  for(int i = 0; i<applicants; i++) {
//   pq.add(sc.nextInt());
//   
//  }
//  for(int i = 0; i<appartments; i++) {
//   int house = sc.nextInt();
//   add(house);
//  }
//  
//  int cnt =0;
//  
//  while(!pq.isEmpty()) {
//   int choice = pq.poll();
//   Integer lowest = multiset.higherKey(choice-diff-1);
//   
//   if(lowest!= null && lowest>=choice-diff&&lowest<=choice+diff) {
//    cnt++;
//    remove(lowest);
//   }
//   
//  }
//  
//  pw.println(cnt);
//  pw.close();

   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         String st[] = br.readLine().split(" ");
         int n = Integer.parseInt(st[0]);
         int m = Integer.parseInt(st[1]);
         int k = Integer.parseInt(st[2]);

         st = br.readLine().split(" ");
         PriorityQueue<Integer> arr = new PriorityQueue<>(n);
         for (int i = 0; i < n; i++) {
             arr.add(Integer.parseInt(st[i]));
         }
         st = br.readLine().split(" ");
         PriorityQueue<Integer> brr = new PriorityQueue<>(m);
         for (int i = 0; i < m; i++) {
             brr.add(Integer.parseInt(st[i]));
         }
//         Arrays.sort(arr);
//         Arrays.sort(brr);

         int cnt = 0;
         while(!arr.isEmpty() && !brr.isEmpty()) {
             if((brr.peek() >= arr.peek() - k) && (brr.peek() <= arr.peek() + k)){
                 arr.poll();
                 brr.poll();
                 cnt++;
             } else if(arr.peek() + k < brr.peek()) {
                 arr.poll();
             } else if(arr.peek() - k > brr.peek()) {
                 brr.poll();
             }
         }
         System.out.println(cnt);
 }

 static void ruffleSort(int a[]) {

        int n = a.length;

        Random r = new Random();

        for (int i = 0; i < n; i++) {

            int oi = r.nextInt(n);
            int temp = a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }

        Arrays.sort(a);
    }

 static void add(int x) {
  if(multiset.containsKey(x)) {
   multiset.put(x,multiset.get(x)+1);
  }
  else {
   multiset.put(x, 1);
  }
 }

 static void remove(int x) {
  multiset.put(x, multiset.get(x)-1);
  if(multiset.get(x)==0) {
   multiset.remove(x);
  }
 }


  public static class MyScanner {
         BufferedReader br;
         StringTokenizer st;

         public MyScanner() {
             br = new BufferedReader(new InputStreamReader(System.in));
         }

         String next() {
             while (st == null || !st.hasMoreElements()) {
                 try {
                     st = new StringTokenizer(br.readLine());
                 } catch (IOException e) {
                     e.printStackTrace();
                 }
             }
             return st.nextToken();
         }

         int nextInt() {
             return Integer.parseInt(next());
         }

         long nextLong() {
             return Long.parseLong(next());
         }

         double nextDouble() {
             return Double.parseDouble(next());
         }

         String nextLine() {
             String str = "";
             try {
                 str = br.readLine();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             return str;
         }

     }


}