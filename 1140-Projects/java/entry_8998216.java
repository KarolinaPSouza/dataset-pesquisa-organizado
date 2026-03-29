import java.io.BufferedReader;import java.io.DataInputStream;import java.io.File;import java.io.FileInputStream;import java.io.FileNotFoundException;import java.io.FileWriter;import java.io.IOException;import java.io.InputStreamReader;import java.util.*;import java.util.*;

public class entry_8998216 implements Runnable
{
   //static FastReader sc = new FastReader();
   static long modulo = (int)Math.pow(10,9)+7;


   public static void main(String[] args)  {

     new Thread(null, new entry_8998216(), "Main", 1<<28).start();
    }
    public void run() 
    {
      FastReader sc = new FastReader();
      int tests=1;



      for(int t=0;t<tests;t++) 
      {
        int n = sc.nextInt();
        int arr[][] = new int[n+1][3];
       // TreeMap<Integer,Long> map= new TreeMap<>();
       // map.put(0,0l);
        for(int i=1;i<=n;i++) 
        {
          arr[i][0]=sc.nextInt();
          arr[i][1]=sc.nextInt();
          arr[i][2]=sc.nextInt();
        //  map.put(arr[i][1],0l);
        }
       // map.put(Integer.MAX_VALUE,Long.MAX_VALUE);
        Arrays.sort(arr,Comparator.comparingDouble(o-> o[1]));

        long dp[]= new long[n+1];
        int lk[] = new int[n+1];
       // Arrays.fill(lk,Integer.MAX_VALUE);
       // lk[0]=0;
        // for(int i=0;i<n;i++) System.out.println(Arrays.toString(arr[i]));

        long prev=0;
        for(int i=1;i<=n;i++)
        {
            int start=arr[i][0];
            int end=arr[i][1];
            int rew=arr[i][2];

            dp[i]= Math.max(dp[search(start,lk,i)]+rew,dp[i-1]);
            lk[i]=end;
        }

        print(dp[n]+" ");


      }

    } 

    public static int search(int key,int arr[],int h) 
    {
       int low=0;
       int high=h-1;
       int ret=0;

       while(low<=high) 
       {
          int mid=(low+high)/2;

          if(arr[mid]>=key)high=mid-1;
          else 
          {
            ret=mid;
             low=mid+1;
          }
       }
     //  print(ret+" ");
       return ret;
    }






  public static void weightedDFS(long ans[],ArrayList<ArrayList<Pair>> graph,boolean visited[],int cur,ArrayList<Integer> itr) 
  {
    for(Pair p: graph.get(cur)) 
    {
      int node=(int)p.first;
      long weight=p.second;
      ans[0]&=weight;


      if(!visited[node]) 
      {
        visited[node]=true;
        weightedDFS(ans,graph,visited,node,itr);
      }
    }
    itr.add(cur);
  }

    public static long[] Djistra(ArrayList<ArrayList<Pair>> graph,int st,long flights[]) 
    {
      PriorityQueue<Pair> pq = new PriorityQueue<>(new PairComparator());
     // print(flights);
      pq.add(new Pair(0,st));
      long distances[] = new long[flights.length];
      boolean visited[] = new boolean[flights.length];
     // visited[st]=true;
      Arrays.fill(distances,Long.MAX_VALUE);
      distances[st]=0;
     // Arrays.sort(flights);

      for(int i=0;i<flights.length;i++) 
      {
        if(i!=st) 
        {
          pq.add(new Pair(flights[st]+flights[i],i));
        }
      }

      Set<Integer> set = new HashSet<>();
      for(int i=0;i<flights.length;i++)set.add(i);

      while(!pq.isEmpty()) 
      {
        Pair p=pq.poll();
        int node=(int)p.second;
        long weight = p.first;
        if(visited[node])continue;
     //   print(weight+" "+node);
     //  print("");

        visited[node]=true;
        set.remove(node);
        distances[node]=weight;

        for(Pair p1:graph.get(node)) 
        {
          int dest=(int)p1.first;
          long nextweight=p1.second;
       //   print(flights[1]+"");

         if(!visited[dest]) pq.add(new Pair(Math.min(weight + nextweight,weight+flights[node]+flights[dest]),dest));
        }
        for(Integer i:set)pq.add(new Pair(weight+flights[node]+flights[i],i));
      }
      return distances;

    }


    public static int diff(String str1,String str2) 
    {
      int cnt=0;
       for(int i=0;i<str1.length();i++) 
       {
         if(str1.charAt(i)!=str2.charAt(i))cnt++;
       }
       return cnt;
    }

    public static boolean poss(int i) 
    {
      String temp = Integer.toString(i);
      //  boolean flag=true;
        for(char c:temp.toCharArray()) 
        {
          if(c=='0' || c=='1')continue;
          return false;
        }
       return true;
    }



  public static long dfs(int arr[][],int i,int j,boolean visited[][]) 
  {
    long ans=0;
    if(visited[i][j])return ans;
    ans=arr[i][j];
    visited[i][j]=true;
    if(arr[i][j]==0 )return ans;
     if(i-1>=0)ans+=dfs(arr,i-1,j,visited);
     if(i+1<arr.length)ans+=dfs(arr,i+1,j,visited);
     if(j-1>=0)ans+=dfs(arr,i,j-1,visited);
     if(j+1<arr[0].length)ans+=dfs(arr,i,j+1,visited);


   //  print(ans+" ");
     return ans;
  }




  public static int DFS(ArrayList<ArrayList<Integer>> tree,int parent,int cur,int child[],int whites[],String str) 
  {
      child[cur]=1;
      if(str.charAt(cur)=='W')whites[cur]++;
      int ans=0;
      for(Integer i: tree.get(cur)) 
      {
        if(i==parent)continue;
       ans+= DFS(tree,cur,i,child,whites,str);
        child[cur]+=child[i];
        whites[cur]+=whites[i];

      }
      if(whites[cur]*2==child[cur])ans++;

      return ans;



  }

     public static long query(int l , int r,long[] trees,long arr[]) 
    {
        long ans=query(0,arr.length-1,l,r,trees,0);
        return ans;
    }

    public static long query(int st,int end,int l,int r,long[]trees,int idx) 
    {
        if(st>r || end<l) 
        {

            return 0;
        }
        if(st>=l && end<=r) 
        {

             long arr= trees[idx];
            return arr;
        }
        int mid=(st+end)/2;

        long arr1=query(st,mid,l,r,trees,2*idx+1);
        long arr2 =query(mid+1,end,l,r,trees,2*idx+2);
        long ans = (arr1+arr2);


        return ans%modulo;
    }

    public static void update(long [] trees, long diff, int idx,long arr[]) 
    {
        updateTrees(trees,diff,idx,0,arr.length-1,0);
        arr[idx]+=diff;
    }

    public static void updateTrees(long[] trees, long diff,int idx,int st,int end,int curidx) 
    {
        if(st>idx || end<idx) 
        {
            return;
        }
        if(st==idx && end==idx) 
        {
            trees[curidx]+=diff;
            return;
        }

        int mid=(st+end)/2;

        updateTrees(trees, diff, idx, st, mid, 2*curidx+1);
        updateTrees(trees, diff, idx, mid+1, end, 2*curidx+2);

         trees[curidx]= (trees[2*curidx+1]+trees[2*curidx+2]);
      //   trees[curidx][1]=0;   
    }

    public static long[] create(long arr[]) 
    {
        long trees[] = new long[4*arr.length];
        createTrees(trees,arr,0,arr.length-1,0);
        return trees;
    }

    public static void createTrees(long trees[],long arr[],int st,int end,int idx) 
    {
        if(st==end) 
        {
            trees[idx]=arr[st];
            trees[idx]%=modulo;
            return ;
        }

        int mid=(st+end)/2;

        createTrees(trees, arr, st, mid, 2*idx+1);
        createTrees(trees, arr, mid+1, end, 2*idx+2);

        trees[idx] = (trees[idx*2+1]+trees[2*idx+2])%modulo; 
      }




    public static void solve() 
    {
    }

    public static boolean mapRemove(TreeMap<Integer,Integer> map,int val) 
    {
      if(!map.containsKey(val))return false;
      map.put(val,map.get(val)-1);
      if(map.get(val)<=0)map.remove(val);
      return true;
    }
    public static void mapadd(TreeMap<Integer,Integer> map, int val) 
    {
      map.put(val,map.getOrDefault(val,0)+1);
    }
    public static int mapcnt(TreeMap<Integer,Integer> map , int val) 
    {
      if(!map.containsKey(val))return 0;
      return map.get(val);

    }

    static long nCr(int n, int r)
{
    return fact(n) / (fact(r) *
                  fact(n - r));
}

// Returns factorial of n
static long fact(int n)
{
      if(n==0)
      return 1;
    long res = 1;
    for (int i = 2; i <= n; i++)
        res = res * i;
    return res;
}


    public static void print(String str) {System.out.println(str);}

    public static void print(int arr[]) 
    {StringBuilder sb = new StringBuilder("");for(int i=0;i<arr.length;i++) {    sb.append(arr[i]+" ");}print(sb.toString());}

    public static void print(long arr[]) 
    {StringBuilder sb = new StringBuilder("");for(int i=0;i<arr.length;i++) {    sb.append(arr[i]+" ");}print(sb.toString());}

    public static void print(boolean f,StringBuilder sb) 
    {if(f)sb.append("YES\n");else sb.append("NO\n");}

    // public static int[] inputarr(int n) throws IOException
    // { int arr[] = new int[n]; for(int i=0;i<n;i++)arr[i]=sc.nextInt();return arr;}

    static long gcd(long a, long b)
    { if (b == 0)  return a;else return gcd(b, a%b);}

    static long lcm(long a ,long b) 
    { return ((a*b))/gcd(a,b);}

    static long sum(long n) 
    {return (n*(n+1))/2;}

    public static void print(int arr[][]) 
    {for(int i=0;i<arr.length;i++) {for(int j=0;j<arr[0].length;j++) { System.out.print(arr[i][j]+" "); } System.out.println();}}

    public static int isPrime(int n)
    {if (n <= 1) return -1;if (n == 2 || n == 3)return -1; if (n % 2 == 0 )return 2;
     if(n%3==0)return 3; for (int i = 5; i <= Math.sqrt(n); i = i + 6){if (n % i == 0 )return i;if(n%(i+2)==0)return i+2;}return -1;}
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