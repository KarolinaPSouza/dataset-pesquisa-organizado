import java.util.*;
import java.util.stream.Stream;
import java.io.*;
public class entry_5761761 {


 static List<List<Integer>> l;

 public static void sol(boolean vis[],int curr) {
  vis[curr]=true;
  for(int a:l.get(curr)) {
   if(!vis[a]) {
    sol(vis,a);
   }
  }
 }
public static void main(String[] args) {
 FastScanner s=new FastScanner();
 PrintWriter out=new PrintWriter(System.out);


      int t=1;
      while(t-->0) {

        int n=s.nextInt();
        int m=s.nextInt();
        l=new ArrayList<>();
        for(int i=0;i<n;i++) {
         l.add(new ArrayList<>());

        }
        for(int i=0;i<m;i++) {
         int a=s.nextInt();int b=s.nextInt();
         a--;b--;
         l.get(a).add(b);
         l.get(b).add(a);
        }
        List<Integer> con=new ArrayList<>();
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++) {
         if(vis[i])continue;
            con.add(i);
         sol(vis,i);
        }
        System.out.println(con.size()-1);
        if(con.size()==1) {
         continue;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<con.size();i++) {
         sb.append((con.get(0)+1)+" "+(con.get(i)+1)+"\n");
        }
        System.out.println(sb);


      }    
}

 //INPUT

static class FastScanner {
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st=new StringTokenizer("");
  String next() {
   while (!st.hasMoreTokens())
    try {
     st=new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }
  int[] readArray(int n) {
   int[] a=new int[n];
   for (int i=0; i<n; i++) a[i]=nextInt();
   return a;
  }
  long nextLong() {
   return Long.parseLong(next());
  }
  double nextDouble() {
   return Double.parseDouble(next());
  }
}

}