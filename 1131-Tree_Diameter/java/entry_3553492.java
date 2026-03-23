import java.io.*;
import java.util.*;

class Main
{
 public static void main(String[] args) throws IOException
 {
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer(br.readLine());
  int N = Integer.parseInt(st.nextToken());
  ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>(N);
  for(int i = 0; i < N; i++)
   adjList.add(new ArrayList<Integer>());
  for(int i = 0; i < N - 1; i++)
  {
   st = new StringTokenizer(br.readLine());
   int p = Integer.parseInt(st.nextToken())-1;
   int q = Integer.parseInt(st.nextToken())-1;
   adjList.get(p).add(q);
   adjList.get(q).add(p);
  }
  boolean[] visited = new boolean[N];
  Queue<Integer> q = new LinkedList<Integer>();
  Stack<Integer> s = new Stack<Integer>();
  q.add(0);
  while(q.size() > 0)
  {
   int tmp = q.size();
   for(int i = 0; i < tmp; i++)
   {
    int tmp1 = q.remove();
    visited[tmp1] = true;
    for(int j : adjList.get(tmp1))
    {
     if(!visited[j])
      q.add(j);
    }
    s.push(tmp1);  
   }
  }
  int max = 0;
  int[] lpath = new int[N];
  while(!s.empty())
  {
   int[] hi = new int[2];
   int tmp = s.pop();
   for(int i : adjList.get(tmp))
   {
    if(lpath[i] > hi[0])
    {
     hi[1] = hi[0];
     hi[0] = lpath[i];
    } else
     hi[1] = Math.max(hi[1], lpath[i]);
   }
   lpath[tmp] = hi[0] + 1;
   max = Math.max(max, hi[0] + hi[1]);
   //System.out.println(tmp + " " + hi[0] + " " +hi[1]);
  }
  System.out.println(max);
 } 
}