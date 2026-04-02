import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_8872722 implements Runnable
{
    public static void main(String args[]) 
    {
            new Thread(null, new entry_8872722(), "Main", 1<<28).start();
    }

    public void run()
    {
        FastReader sc = new FastReader();
        int n=sc.nextInt();
        int m=sc.nextInt();

        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();

        for(int i=0;i<n;i++) 
        {
            ArrayList<Pair> temp = new ArrayList<>();
            graph.add(temp);
        }

        for(int i=0;i<m;i++) 
        {
            int u=sc.nextInt();
            int v=sc.nextInt();
            int wt=sc.nextInt();
            u--;
            v--;
            graph.get(u).add(new Pair(v,wt));
        }

        djikistra(graph);
    }

    public static void djikistra(ArrayList<ArrayList<Pair>> graph) 
    {
        PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());

        pq.add(new Pair(0,0));
        boolean visited[] = new boolean[graph.size()];
      //  visited[0]=true;
        int prev[] = new int[graph.size()];
        long distance[] = new long[graph.size()];
        Arrays.fill(distance,Long.MAX_VALUE);
        distance[0]=0;

        while(!pq.isEmpty()) 
        {
            Pair p=pq.poll();
            long cur = p.second;
            long dist=p.first;
            if(visited[(int)p.second]==true)continue;
            visited[(int)p.second]=true;

            for(Pair p1: graph.get((int)cur)) 
            {
                if(!visited[(int)p1.first] && distance[(int)p1.first]>dist + p1.second) 
                {
                    distance[(int)p1.first] = dist + p1.second;
                    pq.add(new Pair(p1.second+ dist,p1.first));
                    prev[(int)p1.first] = (int)p.second; 
                }
            }   
        }
        print(Arrays.toString(distance).replace('[',' ').replace(',', ' ').replace(']',' '));

    }

    public static void print(String str) 
    {
        System.out.println(str);
    }



    static class FastReader { 
        BufferedReader br;  StringTokenizer st;public FastReader() 
       { br = new BufferedReader(  new InputStreamReader(System.in));} 
       String next() {  while (st == null || !st.hasMoreElements()) { try { st = new StringTokenizer(br.readLine()); } 
       catch (IOException e) {  e.printStackTrace(); } } return st.nextToken(); } 
       int nextInt() { return Integer.parseInt(next()); } long nextLong() { return Long.parseLong(next()); } double nextDouble() 
     { return Double.parseDouble(next()); } String nextLine() { String str = ""; try { if(st.hasMoreTokens()){ str = st.nextToken("\n"); } else{ str = br.readLine(); } } 
     catch (IOException e) {  e.printStackTrace(); } return str;  }} }


     class Pair {long first=-1;long second=-1;Pair(long f,long s) {first=f;second=s;}}


     class Tuple {int first=-1;int second=-1;int third=-1;Tuple(int f,int s,int t) {first=f;second=s;third=t;}}



     class PairComparator implements Comparator<Pair> {
       @Override
       public int compare(Pair p1, Pair p2) {
           // Compare integers in reverse order
           if(p1.first>p2.first) 
           {
             return 1;
           }
           else if(p1.first==p2.first && p1.second<p2.second) 
           {
             return 1;
           }
           else if(p1.first==p2.first && p1.second==p2.second) 
           {
             return 0;
           }
           {
             return -1;
           }
       }
     }
     class TupleComparator implements Comparator<Tuple> {
       @Override
       public int compare(Tuple p1, Tuple p2) {
           // Compare integers in reverse order
           if(p1.third>p2.third) 
           {
             return 1;
           }
           if(p1.third==p2.third)return 0;

           return -1;
       }


     }




       /**   template to increase stack size
          * class Main implements Runnable {
      static void main(...){
       new Thread(null, new Main(), "Main", 1<<28).start();
      }
           public void run() {
       // your code here
      }
     }
          */