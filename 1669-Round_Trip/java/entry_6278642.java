import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

public class entry_6278642 {
   static ArrayList<Integer> cycle=new ArrayList<>();
 public static void main(String[] args) throws IOException {
     BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
     PrintWriter pw = new PrintWriter(System.out);
     StringTokenizer st = new StringTokenizer(bf.readLine());
     int n = Integer.parseInt(st.nextToken());
     int m = Integer.parseInt(st.nextToken());
     ArrayList<ArrayList<Integer>> list=new ArrayList<>();
     for(int i=0;i<n+1;i++)
     {
         list.add(new ArrayList<>());
     }
     for(int i=0;i<m;i++)
     {
         st=new StringTokenizer(bf.readLine());
         int u=Integer.parseInt(st.nextToken());
         int v=Integer.parseInt(st.nextToken());
         list.get(u).add(v);
         list.get(v).add(u);
     }
     boolean[] visited=new boolean[n+1];
     for(int i=0;i<visited.length;i++)
     {
         if(visited[i]==false)
         {
             if(detectCycle(list,i,-1,visited))
             {
                 int point=cycle.get(cycle.size()-1);
                 int idx=0;
                 for(int j=0;j<cycle.size();j++)
                 {
                     if(cycle.get(j)==point)
                     {
                         idx=j;
                         break;
                     }
                 }
                 pw.println(cycle.size()-idx);
                 for(int j=idx;j<cycle.size();j++)
                 {
                     pw.print(cycle.get(j)+" ");
                 }
                 pw.close();
                 bf.close();
                 return;

             }
         }
     }
     pw.println("IMPOSSIBLE");
     bf.close();pw.close();

 }
public static boolean detectCycle(ArrayList<ArrayList<Integer>> list,int src,int parent,boolean[] visited)
{
    visited[src]=true;
    cycle.add(src);
    for(int v:list.get(src))
    {
        if(v!=parent)
        {
            if(visited[v]==true)
            {
                cycle.add(v);
                return true;
            }
            if(detectCycle(list,v,src,visited))
                return true;
        }
    }
    cycle.remove(cycle.size()-1);
    return false;
}

}