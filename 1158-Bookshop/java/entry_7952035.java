import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;
import java.util.*;


public class entry_7952035 {
    static int wayss=0;
     static int modd=(int)Math.pow(10,9)+7;
  public static void main(String args[])
  {
     FastScanner sc = new FastScanner();


     int test=1;
     int modulo=998244353;

     for(int t=1;t<=test;t++)
     {
       int n=sc.nextInt();
       int maxprice=sc.nextInt();
       int prices[] = new int[n+1];
       int pages[] = new int[n+1];

       for(int i=1;i<=n;i++) 
       {
          prices[i]=sc.nextInt();
       }
       for(int j=1;j<=n;j++)
       {
         pages[j]=sc.nextInt();
       }

       int dp[][] = new int[2][maxprice+1];



       for(int i=1;i<=n;i++) 
       {
         for(int j=1;j<=maxprice;j++) 
         {
             if(prices[i]>j) 
            {
                dp[1][j]=dp[0][j];
            }
            else 
            {
                dp[1][j]=Math.max(dp[0][j],pages[i]+dp[0][j-prices[i]]);
            }
         }
       //  print(dp);
         for(int j=1;j<=maxprice;j++) 
         {
            dp[0][j]=dp[1][j];
         }
       }
       System.out.println(dp[1][maxprice]);



     }


}


public static boolean isSorted(String sb) 
{
    for(int i=1;i<sb.length();i++) 
    {
        if(sb.charAt(i)<sb.charAt(i-1)) 
        {
            return false;
        }
    }
    return true;
}

    public static String dectobin(long n) 
    {
        StringBuilder sb = new StringBuilder("");
        while(n>0) 
        {
            sb.append(Long.toString(n%2));
            n/=2;
        }
        return sb.toString();
    }





 public static void print(double [][] arr) 
 {
    int n=arr.length;
    for(int i=0;i<n;i++) 
    {
        for(int j=0;j<n;j++) 
        {
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
 }


 public static boolean isPrime(long n)
  {
      if (n <= 1)
          return false;
      if (n == 2 || n == 3)
          return true;
      if (n % 2 == 0 || n % 3 == 0)
          return false;
      for (int i = 5; i <= Math.sqrt(n); i = i + 6)
          if (n % i == 0 || n % (i + 2) == 0)
              return false;

      return true;
  }

  public static long ciel(long a,long b){

        if(a%b==0) 
        {
            return a/b;
        } 
      return ((a/b)+1);
  }

  public static long[] getopr(long n,long val)
  {
     long ans=n/val;

     long rem=n%val;
     if(rem>0)
     {
        ans++;
        rem=n/ans;
     }
     else 
     {
        rem=val;
     }
     long arr[]={ans,rem};
    // System.out.print(arr[0]+" "+arr[1]+" ");
     return arr;
  }

public static void print(boolean flag)
{
    if(flag)
    {
        System.out.println("YES");
    }
    else 
    {
        System.out.println("NO");
    }
}

public static int getsum(String str)
{
    int sum=0;

    for(char ch:str.toCharArray())
    {
        sum+=ch-'0';
    }
    return sum;
}

static long mod = 998244353;
  static long power( long x,
       long y, long p)
   {
       long res = 1; 

       x = x % p; 
       while (y > 0)
       {
           if ((y & 1)>0)
               res = (res * x) % p;

           y = y >> 1; 
           x = (x * x) % p;
       }
       return res;
   }
    static long inv( long n,
       long p)
   {
       return power(n, p - 2, p);
   }

    static long nCrModPFermat( int n, int r, long p)
    {

        if (n < r)
            return 0;

        if (r == 0)
            return 1;

        long fac[] = new long[n+1];
        fac[0] = 1;
        for (int i = 1; i <= n; i++)
            fac[i] = (fac[i - 1] * i) % p;

        return (fac[n] * inv(fac[r], p) % p
            * inv(fac[n - r], p) % p)
            % p;
    }


public static int getSort(int mid,int arr[])
{
    int st=mid;
    int ans=st;

    for(int i=0;i<arr.length;i++)
    {
        if(arr[i]==st)
        {
            ans=st;
            st++;
        }
    }

    return ans;
}

public static int findnext(int ind,int arr[])
{
    for(int i=ind-1;i>0;i--)
    {
        if(arr[i]>0)
        {
            return i;
        }
    }
    return 0;
}

public static boolean check(long arr[],long num,int ch)
{
    for(int i=ch;i<arr.length;i+=2)
    {
        if(arr[i]%num==0)
        {
            return false;
        }
    }

    return true;
}

public static long get2s(int temp)
{
    long cnt=0;
    while(temp>0)
    {
       //  System.out.print(temp+" "+cnt+" ");
        temp/=2;
        cnt++;
    }
  //  System.out.print(temp+" "+cnt+" ");
    return cnt;

}

public static void print(char[][] arr)
{
    for(int i=0;i<arr.length;i++)
    {
        for(int j=0;j<arr[0].length;j++)
        {
            System.out.print(arr[i][j]+" ");
        }

        System.out.println();
    }
}

public static long BinSearch(int arr[][])
{
   long low =0;
   long high=(long)Math.pow(10,10);
   long ans=-1;;


   while(low<=high)
   {
        long mid=(low+ high)/2;

        if(check(arr,mid)) 
        {
            high=mid-1;
            ans=mid;
        }
        else 
        {
            low=mid+1;
        }

   }

   return ans;
   //System.out.println(x+" "+ans+" ");

}

public static boolean check(int arr[][],long mid)
{
        long cur1=0;
        long cur2=0;
        for(int i=0;i<arr.length;i++) 
        {
          //  if(cur<arr[i][0]) 
            {
                cur1=Math.min(cur1+mid,arr[i][1]);
                 cur2=Math.max(cur2-mid,arr[i][0]);

                 if(cur1<arr[i][0]) 
                {
                   return false;
                 }
                 if(cur2>arr[i][1]) 
                 {
                    return false;
                 }
            }

        }

        return true;
}

public static boolean interval(long val1,long val2 , long max , long min)
{
    if(min<=val1 && max>=val1)
    {
        return true;
    }
    else if(min<=val2 && max>=val2)
    {
        return true;
    }
    else if(val2<=min && val1>=min)
    {
        return true;
    }
     else if(val2<=max && val1>=max)
    {
        return true;
    }

    return false;
}

public static boolean exists(int arr[],int mid,int start)

{
    int st=start;

    for(int i=0;i<arr.length;i++)
    {
        if(arr[i]==st)
        {
            st++;
        }
        if(st==(mid+1))
        {
            return true;
        }
    }

    return false;
}



public static boolean LinSearch(long sum,int n)
{
    for(int i=1;i<=Math.pow(10,6);i++)
    {
        if(exponentiation(i, n)==sum)
        {
            return true;
        }
    }
    return false;
}

 public static double min(double A ,double B,double C ,double D)
 {
    double ans=A;

    ans=Math.min(ans,B);
    ans=Math.min(ans,C);
    ans=Math.min(ans,D);

      return ans;
 }

  public static double max(double A ,double B,double C )
 {
    double ans=A;

    ans=Math.max(ans,B);
     ans=Math.max(ans,C);
   //   ans=Math.min(ans,D);

      return ans;
 }

 public static long arrsum(int arr[])
 {
    long sum=0;

    for(int i=0;i<arr.length;i++)
    {
        sum+=Math.abs(arr[i]);
    }

return sum;
 }

 public static void print(int arr[][])
 {
    for(int i=0;i<arr.length;i++)
    {
        for(int j=0;j<arr[0].length;j++)
        {
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
    System.out.println();
 }


 public static void print(long arr[])
 {
    for(int i=0;i<arr.length;i++)
    {
        System.out.print(arr[i]+" ");
    }
    System.out.println();
 }


 public static long[] CreateTrees(int arr[])
 {
    long trees[] = new long[4*arr.length];
    int index=0;
    int st=0;
    int end=arr.length-1;

    Create(trees,arr,index,st,end);

    return trees;
 }


 public static void Create(long trees[], int arr[] , int index,int st,int end)
 {
    if(st==end)
    {
        trees[index]=arr[st];
        return;
    }
    int mid=st+(end-st)/2;

    Create( trees, arr ,2*index+1,st,mid);

   Create( trees, arr ,2*index+2,mid+1,end);

   trees[index]=(trees[2*index+1]+trees[2*index+2]);

 }

 public static void UpdateTrees(long trees[],long diff,int index,int arr[])
 {
     Update(trees,diff,index,0,arr.length-1,0);
 }

 public static void Update(long trees[],long diff,int index,int st,int end,int i)
 {
     if(index>end || index<st)
     {
        return ;
     }
     trees[i]+=diff;
     if(st==end)
     {
        return;
     }
     int mid=st+(end-st)/2;
     Update(trees,diff,index,st,mid,2*i+1);
     Update(trees,diff,index,mid+1,end,2*i+2);
    // trees[i]=(trees[2*i+1]+trees[2*i+2]);
 }

 public static long query(long trees[],int l , int r, int[] arr)
 {
     return Query(trees,0,l,r,0,arr.length-1);
 }

 public static long Query(long[] trees, int index,int l , int r, int st , int end)
 {
    if(st>r || end<l)
    {
        return 0;
    }
    if(l<=st && end<=r)
    {
        return trees[index];
    }

    int mid=(st)+(end-st)/2;

    long l1=Query(trees,2*index+1,l,r,st,mid);
    long l2=Query(trees,2*index+2,l,r,mid+1,end);

    return (l1+l2);

 }

 public static boolean Desc(int arr[])
 {
    for(int i=1;i<arr.length;i++)
    {
        if(arr[i]>arr[i-1])
        {
            return false;
        }
    }
    return true;
 }

 public static boolean isSort(int arr[])
 {
    for(int i=1;i<arr.length;i++)
    {
        if(arr[i]<arr[i-1])
        {
            return false;
        }
    }
    return true;
 }

 public static long gcd(long a, long b)
    {
        if (a == 0)
            return b;

        return gcd(b % a, a);
    }


 public static long sum(long n)
 {
    return n*(n+1)/2;
 }

 public static long sum(int arr[],int n)
 {
    long ans=0;
    for(int i=n;i<arr.length;i++)
    {
        ans+=Math.max(arr[i],0);
    }
    return ans;
 }

 public static void print(long arr[][])
 {
    for(int i=0;i<arr.length;i++)
    {
        for(int j=0;j<arr[0].length;j++)
        {
            System.out.print(arr[i][j]+" ");
        }
        System.out.println();
    }
    System.out.println();
 }

 public static void print(int arr[])
 {
    for(int i=0;i<arr.length;i++)
    {
        System.out.print(arr[i]+" ");
    }
    System.out.println();
 }

 public static long nC2(long n)
 {
    long mod=998244353;
    return ((n%mod)*((n-1)%mod)/2)%mod;
 }


 private static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");

        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long[] readArrayLong(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }

        int[] readArrayInt(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = nextInt();
            return a;
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        boolean nextBoolean() {
            return Boolean.parseBoolean(next());
        }
    }

    public  static long exponentiation(long base, long exp)
    {
         long mod=998244353;
        if (exp == 0)
            return 1;

        if (exp == 1)
            return base % mod;

        long t = exponentiation(base, exp / 2);
        t = (t * t) % mod;

        // if exponent is even value
        if (exp % 2 == 0)
            return t;

        // if exponent is odd value
        else
            return ((base % mod) * t) % mod;
    }

    static long expo(long x, long y) { long res = 1; while (y>0) 
        {
            if (y % 2==0) res = (res * x % mod) % mod; x = (x * x) % mod; y /= 2; 
        } 
        return res;
    }
    static long inv(long x) 
    {
        return expo(x, mod - 2);
    }
    static long add(long a, long b) 
    {a = a % mod; b = b % mod; return (((a + b) % mod) + mod) % mod;
    }
    static long mul(long a, long b) 
    {
        a = a % mod; b = b % mod; return (((a * b) % mod) + mod) % mod;
    }
    static long sub(long a, long b) 
    {
        a = a % mod; b = b % mod; return (((a - b) % mod) + mod) % mod;
    }
    static long m_div(long a, long b) 
    {
        a = a % mod; b = b % mod; return (mul(a, inv(b)) + mod) % mod;
    }
}