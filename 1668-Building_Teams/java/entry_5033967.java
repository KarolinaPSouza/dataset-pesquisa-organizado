import java.io.*;
import java.util.*;

public class entry_5033967 {
 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 static PrintWriter pw = new PrintWriter(System.out);

 public static final int MN = 100010;
 public static final int MM = 200010;

 public static int N, M;
 public static boolean bad;
 public static boolean[] vis = new boolean[MN], group = new boolean[MN];
 public static int[] hd = new int[MN], nx = new int[MM*2], to = new int[MM*2];

 public static void dfs(int n, boolean g)
 {
  vis[n]=true;
  group[n]=g;
  for(int id=hd[n];id!=0;id=nx[id])
   if(vis[to[id]])
   {
    if(group[to[id]]==g)
     bad=true;
   }
   else
    dfs(to[id], !g);
 }
 public static void adde(int u, int v, int id)
 {
  nx[id]=hd[u];
  hd[u]=id;
  to[id]=v;
 }
 public static void main(String... args) throws IOException
 {
  StringTokenizer st = new StringTokenizer(br.readLine());
  N=Integer.parseInt(st.nextToken());
  M=Integer.parseInt(st.nextToken());
  for(int i=0,u,v;i<M;++i)
  {
   st = new StringTokenizer(br.readLine());
   u=Integer.parseInt(st.nextToken());
   v=Integer.parseInt(st.nextToken());
   adde(u,v,i*2+1);
   adde(v,u,i*2+2);
  }
  for(int i=1;!bad && i<=N;++i)
   if(!vis[i])
    dfs(i, false);
  if(bad)
   pw.println("IMPOSSIBLE");
  else
   for(int i=1;i<=N;++i)
   {
    pw.print(group[i] ? '1' : '2');
    if(i<N) pw.print(' ');
    else pw.println();
   }
  pw.close();
 }
}