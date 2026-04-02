import java.util.*;
import java.io.*;

public class entry_887657 {
 static FastReader f = new FastReader();
 static PrintWriter out = new PrintWriter(System.out);

 public static void main(String[] args) {
  int n = f.nextInt(), m = f.nextInt();
  ArrayList<Integer>[] edge = new ArrayList[n];
  for(int i=0;i<n;i++) {
   edge[i] = new ArrayList<>();
  }
  while(m-- > 0) {
   int u = f.nextInt() - 1, v = f.nextInt() - 1;
   edge[u].add(v);
   edge[v].add(u);
  }

  Queue<Integer> que = new ArrayDeque<>();
  boolean[] vis = new boolean[n];
  vis[0] = true;
  que.add(0);
  int[] prev = new int[n];
  for(int i=1;i<n;i++) {
   prev[i] = -1;
  }
  while(!que.isEmpty()) {
   Queue<Integer> next = new ArrayDeque<>();

   while(!que.isEmpty()) {
    int now = que.poll();
    for(int i : edge[now]) {
     if(!vis[i]) {
      vis[i] = true;
      next.add(i);
      prev[i] = now;
     }
    }
   }

   que = next;
  }

  if(prev[n-1] == -1) {
   out.println("IMPOSSIBLE");
  } else {
   Stack<Integer> stack = new Stack<>();
   int now = n-1;
   while(now != prev[now]) {
    stack.add(now);
    now = prev[now];
   }
   stack.add(0);
   out.println(stack.size());
   while(!stack.isEmpty()) {
    out.print((stack.pop()+1)+" ");
   }
   out.println();
  }
  out.close();
 }





 static class FastReader {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st;

  String next() {
   while(st == null || !st.hasMoreElements()) {
    try {
     st = new StringTokenizer(br.readLine());
    } catch(IOException ioe) {
     ioe.printStackTrace();
    }
   }
   return st.nextToken();
  }

  String nextLine() {
   String s = "";
   try {
    s = br.readLine();
   } catch(IOException ioe) {
    ioe.printStackTrace();
   }

   return s;
  }

  int  nextInt() {
   return Integer.parseInt(next());
  }
 }
}