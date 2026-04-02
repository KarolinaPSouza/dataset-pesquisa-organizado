//package Codeforces;


import java.util.*;
import java.util.stream.Collectors;
import java.lang.*;
import java.math.BigInteger;
import java.io.*;


public class entry_5454912 {
 static PrintWriter out=new PrintWriter(System.out);
 static int move[][]=new int[][] {{0,1},{-1,0},{0,-1},{1,0}};
 static int mod = (int)1e9+7;
 public static void main (String[] args) throws java.lang.Exception {
  FastReader sc = new FastReader();
  int testCases=1;
//  testCases=sc.nextInt();
  while(testCases-->0) {
   int n = sc.nextInt();
   int pt[]=new int[n];
   int arr[]=new int[n];
   for(int i=1;i<n;i++) {
    int x = sc.nextInt()-1;
    pt[i]=x;
    arr[x]++;
   }
   Queue<Integer> q =new ArrayDeque<>();
   for(int i=0;i<n;i++) if(arr[i]==0) q.add(i);
   int dp[]=new int[n];
   while(!q.isEmpty()) {
    for(int i=q.size();i>0;i--) {
     int u=q.poll();
     if(u==0) break;
     dp[pt[u]]+=(1+dp[u]);
     arr[pt[u]]--;
     if(arr[pt[u]]==0) q.add(pt[u]);
    }
   }
   for(int val : dp) out.print(val+" ");
   out.println();


  }
  out.close();
 }










 public static long pow(long a,long b) {
  long res=1;
  while(b>0) {
   if(b%2==0) {
    a = (a*a)%mod;
    b/=2;
   } else {
    res = (res*a)%mod;
    b--;
   }
  }
  return res;
 }
 static int MAXN=10000000;
    static int spf[] = new int[MAXN];

    // Calculating SPF (Smallest Prime Factor) for every
    // number till MAXN.
    // Time Complexity : O(nloglogn)
    static void sieve()
    {
        spf[1] = 1;
        for (int i=2; i<MAXN; i++)

            // marking smallest prime factor for every
            // number to be itself.
            spf[i] = i;

        // separately marking spf for every even
        // number as 2
        for (int i=4; i<MAXN; i+=2)
            spf[i] = 2;

        for (int i=3; i*i<MAXN; i++)
        {
            // checking if i is prime
            if (spf[i] == i)
            {
                // marking SPF for all numbers divisible by i
                for (int j=i*i; j<MAXN; j+=i)

                    // marking spf[j] if it is not
                    // previously marked
                    if (spf[j]==j)
                        spf[j] = i;
            }
        }
    }

    // A O(log n) function returning primefactorization
    // by dividing by smallest prime factor at every step
    static Vector<Integer> getFactorization(int x)
    {
        Vector<Integer> ret = new Vector<>();
        while (x != 1)
        {
            ret.add(spf[x]);
            x = x / spf[x];
        }
        return ret;
    }





 public static long gcd(long a, long b) {
  if(a==0) return b;
  return gcd(b%a,a);
 }

 private static long lcm(long a, long b) {
  return (a*b)/gcd(a,b);
 }

 private static void swap(int[] arr, int i, int j) {
  int temp = arr[i];
  arr[i] = arr[j];
  arr[j]=temp;
 }

 public static List<Integer> getPrimes(int n){
  boolean isPrime[]=new boolean[n+1];
  Arrays.fill(isPrime, true);
  isPrime[0]=isPrime[1]=true;
  for(int i=2;i*i<=n;i++) {
   if(!isPrime[i]) continue;
   for(int j=i*i;j<=n;j+=i) {
    isPrime[j]=false;
   }
  }
  List<Integer>list=new ArrayList<>();
  for(int i=2;i<=n;i++) {
   if(isPrime[i]) list.add(i);
  }
  return list;
 }


 static class DSU{
  int parent[];
  int rank[];
  int size[];
  public DSU(int n) {
   this.parent = new int[n];
   this.rank = new int[n];
   size=new int[n];
   for(int i=0;i<n;i++) parent[i]=i;
   for(int i=0;i<n;i++) size[i]=1;
  }
  public int find(int x) {
   if(parent[x] != x) parent[x]=find(parent[x]);
   return parent[x];
  }
  public boolean union(int x,int y) {
   int px = find(x);
   int py = find(y);
   if(px == py) return false;
   if(rank[px]>rank[py]) {
    parent[py]=px;
    size[px]+=size[py];
   }
   else if(rank[py]>rank[px]) {
    parent[px]=py;
    size[py]+=size[px];
   }
   else {
    rank[px]++;
    parent[py]=px;
    size[px]+=size[py];
   }
   return true;

  }
 }

 static class FastReader {
  BufferedReader br;
  StringTokenizer st;

  public FastReader() {
   br = new BufferedReader(
     new InputStreamReader(System.in));
  }

  String next() {
   while (st == null || !st.hasMoreElements()) {
    try {
     st = new StringTokenizer(br.readLine());
    } catch (IOException e) {
     e.printStackTrace();
    }
   }
   return st.nextToken();
  }

  int nextInt() {
   return Integer.parseInt(next());
  }

  long nextLong() {
   return Long.parseLong(next());
  }

  double nextDouble() {
   return Double.parseDouble(next());
  }

  String nextLine() {
   String str = "";
   try {
    str = br.readLine();
   } catch (IOException e) {
    e.printStackTrace();
   }
   return str;
  }
 }

}