import java.io.*;
import java.util.*;
public class entry_1145791
{
 static ArrayList<Integer> adj[];
 static int color[];
 static int parent[];
 static int cycle_start;
 static int cycle_end;
 public static boolean dfs_cycle(int v,int p)
 {
  color[v]=1;
  for(int u:adj[v])
  {
   if(u==p)
   {
    continue;
   }
   if(color[u]==0)
   {
    parent[u]=v;
    if(dfs_cycle(u,parent[u])==true)
    {
     return true;
    }
   }
   else if(color[u]==1)
   {
    cycle_start=u;
    cycle_end=v;
    return true;
   }
  }
  color[v]=2;
  return false;
 }
 public static void main(String args[]) throws IOException
 {
  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
  String a[]=br.readLine().split(" ");
  int n=0,m=0;
  n=Integer.parseInt(a[0]);
  m=Integer.parseInt(a[1]);
  adj=new ArrayList[n+1];
  color=new int[n+1];
  parent=new int[n+1];
  cycle_start=-1;
  for(int i=1;i<n+1;i++)
  {
   adj[i]=new ArrayList<>();
  }
  while(m-->0)
  {
   String s[]=br.readLine().split(" ");
   adj[Integer.parseInt(s[0])].add(Integer.parseInt(s[1]));
   adj[Integer.parseInt(s[1])].add(Integer.parseInt(s[0]));
  }
  for(int i=1;i<adj.length;i++)
  {
   if(color[i]==0 && dfs_cycle(i,parent[i])==true)
   {
    break;
   }
  }
  if(cycle_start==-1)
  {
   System.out.println("IMPOSSIBLE");
  }
  else
  {
  ArrayList<Integer> cycle=new ArrayList<Integer>();
  cycle.add(cycle_start);
  for(int v=cycle_end;v!=cycle_start;v=parent[v])
  {
   cycle.add(v);
  }
  cycle.add(cycle_start);
  System.out.println(cycle.size());
  for(int i:cycle)
  {
   System.out.print(i+" ");
  }
  System.out.println();}
 }
}
