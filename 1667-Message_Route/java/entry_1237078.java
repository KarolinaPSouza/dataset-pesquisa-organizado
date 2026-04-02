//package Practice_Problems;
import java.util.*;
import java.io.*;
public class entry_1237078 {
 static ArrayList<Integer> adj[] = new ArrayList[(int) 2e5 + 1];
 static boolean vis[]=new boolean[adj.length];
 static int par[]=new int[adj.length];
 static final int mod=(int)1e9+7;
 static final int inf=(int)1e9;
 static final long INF=(long)1e18;
 public static void main(String[] args) throws IOException
 {
  FastScanner fs=new FastScanner();
  PrintWriter out = new PrintWriter(System.out);
  int nodes=fs.nextInt();
  int edges=fs.nextInt();
  for(int i=1;i<=nodes;i++)adj[i]=new ArrayList<Integer>();
  for(int i=1;i<=edges;i++)
  {
   int a=fs.nextInt();int b=fs.nextInt();
   adj[a].add(b);adj[b].add(a);
  }
  bfs(1);
  if(vis[nodes]==false)
   out.println("IMPOSSIBLE");
  else
  {
   ArrayList<Integer> ans = new ArrayList<Integer>();
   for(int i=nodes;i!=-1;i=par[i])
    ans.add(i);
   out.println(ans.size());
   Collections.reverse(ans);
   for(int i:ans)
    out.print(i+" ");
  }
  out.close();
 }
 public static void bfs(int source)
 {
  ArrayDeque<Integer> deq=new ArrayDeque<Integer>();
  deq.add(source);vis[source]=true;
  par[source]=-1;
  while(!deq.isEmpty())
  {
   int curr=deq.poll();
   for(int child:adj[curr])
   {
    if(!vis[child])
    {
     vis[child]=true;
     deq.add(child);
     par[child]=curr;
    }
   }
  }
 }
 //returns the index of the smallest element in the array that is greater than or equal to
 //the given element.
 public static int lower_bound(int arr[],int key)
 {
  int index=inf,num=0;
  int left=0,right=arr.length-1;
  while(left<=right)
  {
   int mid=left+(right-left)/2;
   if(arr[mid]>=key) {index=mid;num=arr[mid];right=mid-1;}
   else 
    left=mid+1;
  }
  return index==inf ? arr.length:index;
 }
 //returns the index of the smallest element in the array that is less than or equal to
    //the given element.
 public static int upper_bound(int arr[],int key)
 {
  int index=inf,num=0;
  int left=0,right=arr.length-1;
  while(left<=right)
  {
   int mid=left+(right-left)/2;
   if(arr[mid]<=key) {index=mid;num=arr[mid];left=mid+1;}
   else 
    right=mid-1;
  }
  return index==inf ? arr.length:index;
 }
}
class FastScanner 
{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  StringTokenizer st = new StringTokenizer("");
  public String next() 
  {
   while (!st.hasMoreTokens())
    try {
     st=new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   return st.nextToken();

  }
  public String nextLine() throws IOException
  {
      return br.readLine();
  }
  int[] sort(int arr[])
  {
   ArrayList<Integer> list = new ArrayList<Integer>();
   for(int i:arr)list.add(i);
   Collections.sort(list);
   for(int i=0;i<arr.length;i++)
   {
    arr[i]=list.get(i);
   }
   return arr;
  }
  char[] charsort(char arr[])
         {
      ArrayList<Character> list = new ArrayList<>();
      for(char c:arr)list.add(c);
      Collections.sort(list);
      for(int i=0;i<list.size();i++)
      {
       arr[i]=list.get(i);
      }
      return arr;
         }
  long[] longsort(long arr[])
  {
   ArrayList<Long> list = new ArrayList<Long>();
   for(long i:arr)list.add(i);
   Collections.sort(list);
   for(int i=0;i<arr.length;i++)
   {
    arr[i]=list.get(i);
   }
   return arr;
  }
  public int nextInt() 
  {
   return Integer.parseInt(next());
  }
  public int[] readArray(int n)
  {
   int[] arr=new int[n];
   for (int i=0; i<n; i++) arr[i]=nextInt();
   return arr;
  } 
  public long nextLong()
  {
   return Long.parseLong(next());
  }
  public long[] longreadArray(int n) 
  {
   long[] a=new long[n];
   for (int i=0; i<n; i++) a[i]=nextLong();
   return a;
  }
}