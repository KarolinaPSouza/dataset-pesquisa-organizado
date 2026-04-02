import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
public class entry_16048918 {
 static class FastScanner {
     BufferedReader br;
     StringTokenizer st;
     FastScanner(InputStream in) {
         br = new BufferedReader(new InputStreamReader(in));
     }
     String next() throws IOException {
         while (st == null || !st.hasMoreTokens())
             st = new StringTokenizer(br.readLine());
         return st.nextToken();
     }
     int nextInt() throws IOException {
         return Integer.parseInt(next());
     }
     long nextLong() throws IOException {
         return Long.parseLong(next());
     }
     String nextLine() throws IOException {
         return br.readLine();
     }
 }
 public static void main(String...strings) throws IOException{
  FastScanner sc=new FastScanner(System.in);
  int n=sc.nextInt();
  int m=sc.nextInt();
  List<List<Integer>> list=new ArrayList<>();
  for(int i=0;i<=n;i++) {
   list.add(new ArrayList<>());
  }
  while(m-->0) {
   int start=sc.nextInt();
   int dest=sc.nextInt();
   list.get(start).add(dest);
   list.get(dest).add(start);
  }
  int[] color=new int[n+1];
  Queue<Integer> queue=new ArrayDeque<>();
  for(int i=1;i<=n;i++) {
   if(color[i]!=0) continue;
   color[i]=1;
   queue.add(i);
   while(!queue.isEmpty()) {
    int cell=queue.poll();
    for(int j=0;j<list.get(cell).size();j++) {
     if(color[list.get(cell).get(j)]==0) {
      color[list.get(cell).get(j)]=color[cell]==1?2:1;
      queue.add(list.get(cell).get(j));
     }
     else {
      if(color[list.get(cell).get(j)]==color[cell]) {
       System.out.println("IMPOSSIBLE");
       return;
      }
     }
    }
   }
  }
  StringBuilder sb=new StringBuilder();
  for(int i=1;i<n+1;i++) sb.append(color[i]+" ");
  System.out.println(sb.toString());
 }
}