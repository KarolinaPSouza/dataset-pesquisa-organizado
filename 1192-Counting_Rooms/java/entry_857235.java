
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class entry_857235 {
 static class Pair{
  int a,b;
  Pair(int a,int b){
   this.a=a;
   this.b=b;
  }
 }
 public static boolean  isSafe(int i,int j,int n,int m,char c[][],boolean visited[][]) {
  return i>=0&&i<n&&j>=0&&j<m&&c[i][j]=='.'&&!visited[i][j];
 }

 public static void dfs(char c[][],int i,int j,int n,int m,boolean visited[][]) {
  int row[]= {
    -1,0,0,1
  };
  int col[]= {
    0,-1,1,0
  };
  Queue<Pair> q=new LinkedList<Pair>();
  q.add(new Pair(i, j));

  visited[i][j]=true;
  while(!q.isEmpty()) {
   Pair p1=q.poll();
   int first=p1.a;
   int sec=p1.b;

   for(int i1=0;i1<4;i1++) {
    if(isSafe(first+row[i1], sec+col[i1], n, m, c, visited)) {
     visited[first+row[i1]][sec+col[i1]]=true;
     q.add(new Pair(first+row[i1], sec+col[i1]));
    }
   }
  }



 }




 public static void main(String[] args) {
  FastScanner sc=new FastScanner();
  int n=sc.nextInt(),m=sc.nextInt();
  char c[][]=new char[n][m];
  for(int i=0;i<n;i++) {
   char line[]=sc.next().toCharArray();
   for(int j=0;j<m;j++) c[i][j]=line[j];
  }
  int ans=0;
  boolean visited[][]=new boolean[n][m];
  for(int i=0;i<n;i++) {
   for(int j=0;j<m;j++) {
    if(!visited[i][j]&&c[i][j]=='.') {

     dfs(c, i, j, n, m, visited);
     ans++;
    }
   }
  }
  System.out.println(ans);


 }

 static class FastScanner {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");

  String next() {
   while (!st.hasMoreTokens())
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  int[] readArray(int n) {
   int[] a = new int[n];
   for (int i = 0; i < n; i++)
    a[i] = nextInt();
   return a;
  }

  long nextLong() {
   return Long.parseLong(next());
  }
 }

}