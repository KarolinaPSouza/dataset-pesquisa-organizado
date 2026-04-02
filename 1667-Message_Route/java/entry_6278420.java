import java.io.*;
import java.lang.reflect.Array;
import java.nio.Buffer;
import java.util.*;

public class entry_6278420 {
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
     Queue<Integer> queue=new LinkedList<>();
     queue.offer(1);
     int[] parent=new int[n+1];
     Arrays.fill(parent,-1);
     parent[1]=1;
     int[] steps=new int[n+1];
     steps[1]=1;
     while(!queue.isEmpty())
     {
         int u=queue.poll();
         for(int v:list.get(u))
         {
             if(parent[v]==-1)
             {
                 steps[v]=steps[u]+1;
                 parent[v]=u;
                 queue.offer(v);
             }
         }
     }
     if(parent[n]==-1)
         System.out.println("IMPOSSIBLE");
     else
     {System.out.println(steps[n]);
         Stack<Integer> stack=new Stack<>();
         stack.push(n);
         while(parent[stack.peek()]!=stack.peek())
         {
             stack.push(parent[stack.peek()]);
         }
         StringBuilder sb=new StringBuilder();
         while(!stack.empty())
         {
             sb.append(stack.pop()+" ");
         }
         System.out.println(sb.toString());
     }
 }
}