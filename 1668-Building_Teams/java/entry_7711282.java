

import java.util.*;
import java.io.*;

public class entry_7711282 {
 static BufferedReader in;
 static StringTokenizer st;
 static ArrayList<Integer> a[], node;
 static int n, m, v[];
 static boolean impossible;



 static void solve() {

  for (int i = 0; i < n; i++)
   if(v[i]==0) dfs(i, 1);


  StringBuilder sb = new StringBuilder();
  if(impossible) System.out.println("IMPOSSIBLE");
  else {
   for(int i=0; i<n; i++) sb.append(v[i]).append(" ");
   System.out.println(sb.toString());
  }  
 }

 public static void dfs(int i, int c){
  if(v[i] !=0) return;

  v[i] = c;   //System.out.println(i+" "+c + " "+Arrays.toString(v));

  int cc = c==1? 2:1; 
  for (int j: a[i]) {
   if(v[j]==c) {impossible = true; return;}
   if(v[j]==0) dfs(j, cc);
  }
 } 

 static void init() throws IOException {

  st = new StringTokenizer(in.readLine());  
  n = Integer.parseInt(st.nextToken());
  m = Integer.parseInt(st.nextToken());
  a = new ArrayList[n];
  v = new int[n];
  node = new ArrayList<Integer>();
  for (int i = 0; i < n; i++) a[i] = new ArrayList<Integer>();

  for (int i = 0; i < m; i++){
   st = new StringTokenizer(in.readLine());
   int x = Integer.parseInt(st.nextToken())-1;
   int y = Integer.parseInt(st.nextToken())-1;
   a[x].add(y); 
   a[y].add(x);
  }  
  //System.out.println(Arrays.toString(a));
 }

 public static void main(String[] args) throws IOException{
  in = new BufferedReader(new InputStreamReader(System.in));
  init();
  solve();
  in.close();
 }
}