//package coding;

import java.io.*;
//import java.util.PriorityQueue;
import java.util.*;


public class entry_1101565 {
 static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 

        public FastReader() 
        { 
            br = new BufferedReader(new
                     InputStreamReader(System.in)); 
        } 

        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 

        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 

        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 

        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 

        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    } 
 static int n;
 static int m;
 static boolean visited[];
 static ArrayList<ArrayList<Integer>> arr;
 static int[] parent;
 static int sv=-1;
 static int ev=-1;

 static ArrayList<Integer> cycle=new ArrayList<>();

 public static void main(String[]args)
 {
  FastReader sc=new FastReader();
  n=sc.nextInt();
  m=sc.nextInt();
  arr=new ArrayList<ArrayList<Integer>>();
  for(int i=0;i<n;i++)
  {
   ArrayList<Integer> a=new ArrayList<>();
   arr.add(a);
  }
  while(m-->0)
  {
   int f=sc.nextInt()-1;
   int s=sc.nextInt()-1;
   arr.get(f).add(s);
   arr.get(s).add(f);
  }
  visited=new boolean[n];
  parent=new int[n];
  boolean ans=false;

  for(int i=0;i<n&&!ans;i++)
  {
   if(!visited[i])
   {
    ans=dfs(i,-1);

   }
  }
  if(!ans)
  {
   System.out.println("IMPOSSIBLE");
  }else {
   StringBuilder sb=new StringBuilder();
   cycle.add(ev);
   int cv=parent[ev];
   while(cv!=sv)
   {
    cycle.add(cv);
    cv=parent[cv];

   }
   cycle.add(sv);
   cycle.add(ev);
   sb.append(cycle.size());
   sb.append("\n");
   for(int i:cycle) 
   {
    sb.append(++i+" ");
   }
   System.out.println(sb);

  }


 }

 private static boolean dfs(int si, int p) {
  // TODO Auto-generated method stub
  parent[si]=p;
  visited[si]=true;
  for(int child:arr.get(si))
  {
   if(!visited[child])
   {
    if(dfs(child,si))
    {

     return true;
    }
   }else {
    if(child!=p) 
    {
     ev=si;
     sv=child;
     return true;
    }
   }

  }
  return false;
 }



} 