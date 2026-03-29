// mafia29 
import java.io.*;
import java.util.*;
public class entry_13662905 {
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
    int x = nextInt();
    int[][] a = new int[n][2];
    int sum = 0;
    for(int i=0;i<n;i++)
    {
      a[i][0] = nextInt();
      sum += a[i][0];
    }
    x = Math.min(x,sum);
    for(int i=0;i<n;i++)
    a[i][1] = nextInt();
    int[] dp = new int[x+1];
    for(int i=n-1;i>=0;i--)
    {
      int[] temp = new int[x+1];
      for(int j=0;j<=x;j++)
      {
        int ans1 = 0;
        if(j>=a[i][0])
        ans1 = a[i][1]+dp[j-a[i][0]];
        int ans2 = dp[j];
        temp[j] = Math.max(ans1,ans2);
      }
      dp = temp;
    }
    System.out.println(dp[x]);
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