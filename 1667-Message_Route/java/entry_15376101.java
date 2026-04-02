// mafia29 
import java.io.*;
import java.util.*;
public class entry_15376101 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
  static StringTokenizer st; 
  static String next() 
  { 
    while(st==null||!st.hasMoreElements()) 
    { 
      try 
      {
        st = new StringTokenizer(br.readLine()); 
      }
      catch(IOException e) 
      {
        e.printStackTrace(); 
      }
    } 
    return st.nextToken(); 
  } 
  static int nextInt() 
  { 
    return Integer.parseInt(next()); 
  } 
  static long nextLong() 
  { 
    return Long.parseLong(next()); 
  } 
  static double nextDouble() 
  { 
    return Double.parseDouble(next()); 
  }
  public static boolean[] steve(int k)//steve for prime
  {
    boolean[] prime = new boolean[k];
    Arrays.fill(prime,true);
    prime[0] = false;
    prime[1] = false;
    for(int i=2;i*i<k;i++)
    {
      if(prime[i]==true)
      {
        for(int j=i*i;j<k;j+=i)
        prime[j] = false;
      }
    }
    return prime;
  }
  public static int gcd(int a,int b)//gcd
  {
    if(b==0)
    return a;
    return gcd(b,a%b);
  }
  public static int lcm(int a,int b)//lcm
  {
    return(a/gcd(a,b))*b;
  }
  public static void main(String[] args) 
  {
    int n = nextInt();
    int m = nextInt();
    List<List<Integer>> ls = new ArrayList<>();
    int[] parent = new int[n+1];
    for(int i=0;i<=n;i++)
    {
      ls.add(new ArrayList<>());
      parent[i] = -1;
    }
    for(int i=0;i<m;i++)
    {
      int u = nextInt(), v = nextInt();
      ls.get(u).add(v);
      ls.get(v).add(u);
    }
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    parent[1] = 0;
    while(!q.isEmpty())
    {
      int node = q.poll();
      for(int nextnode : ls.get(node))
      {
        if(parent[nextnode]==-1)
        {
          parent[nextnode] = node;
          q.add(nextnode);
        }
      }
    }
    if(parent[n]==-1)
    System.out.println("IMPOSSIBLE");
    else
    {
      List<Integer> ans = new ArrayList<>();
      int cur = n;
      while(cur!=0)
      {
        ans.add(cur);
        cur = parent[cur];
      }
      int size = ans.size()-1;
      System.out.println(size+1);
      for(int i=size;i>=0;i--)
      System.out.print(ans.get(i)+" ");
      System.out.println();
    }
  }
  public static boolean checkprime(int N)//checkprime
  {
    int i;
    if(N==1)
    return false;
    if((N&1)==0&&N!=2)
    return false;
    else if(N%3==0&&N!=3)
    return false;
    else if(N%11==0&&N!=11)
    return false;
    else if(N%13==0&&N!=13)
    return false;
    else if(N%17==0&&N!=17)
    return false;
    else
    {
      for(i=3;i<=Math.sqrt(N);i+=2)
      {
        if(N%i==0)
        return false;
      }
    }
    return true;
  }
}