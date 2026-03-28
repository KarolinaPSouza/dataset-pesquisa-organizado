import java.io.*;
import java.util.*;
import java.math.*;
import java.math.BigInteger; 
//import javafx.util.*; 
class Main
{    
 static StringBuilder ans=new StringBuilder();
 static FastReader in=new FastReader();
 static ArrayList<Integer> g[];
 static long mod=1000000007;
 static boolean set[],special[];   
 static int f[],c[];
 static int D[],D2[],D1[],q[];
 static int par[];
 static long max=0;
 public static void main(String args[])throws IOException
 {  

  int N=i();
  setGraph(N);
  for(int i=1; i<N; i++)
  {
   int a=i(),b=i();
   g[a].add(b);
   g[b].add(a);
  }
  if(N==1)
  {
   System.out.println(0);
   return;
  }
  int a=bfs(1,D);
  int b=bfs(a,D1);
  bfs(b,D2);
  for(int i=1; i<=N; i++)ans.append(Math.max(D1[i], D2[i])+" ");
  System.out.println(ans);
 }
 static int bfs(int n,int D[])
 {
  int root=0;
  int l=0,r=0;
  q[r]=n;
  D[n]=0;
  D[root]=0;
  while(l<=r)
  {
   //print(q);
   n=q[l++];
   if(D[n]>D[root])
   {
    root=n;
   }
   for(int c:g[n])
   {
    if(D[c]>D[n]+1)
    {
     D[c]=D[n]+1;
     q[++r]=c;
    }
   }
  }
  return root;
 }
 static int fact(int N)
 {
  int f=1; for(int i=2; i<=N; i++)f*=i;
  return f;
 }

 static void setGraph(int N)
 {
  set=new boolean[N+1];
  D=new int[N+1];
  D1=new int[N+1];
  D2=new int[N+1];
  g=new ArrayList[N+1];
  q=new int[N+1];
  for(int i=0; i<=N; i++)
  {    
   g[i]=new ArrayList<Integer>();
   D[i]=Integer.MAX_VALUE;
   D1[i]=Integer.MAX_VALUE;
   D2[i]=Integer.MAX_VALUE;
  }
 }
 static int find(int a)
 {
  if(par[a]<0)return a;
  return par[a]=find(par[a]);
 }
 static void union(int a,int b)
 {
  a=find(a);
  b=find(b);
  if(a!=b)
  {
   par[a]+=par[b];
   par[b]=a;
  }
 }

 // static void print(int A[])
 // {
 //  for(int a:A)System.out.print(a+" ");
 //  System.out.println(); 
 // }

 static void print(char A[])
 {
  for(char c:A)System.out.print(c+" ");
  System.out.println();
 }
 static void print(boolean A[])
 {
  for(boolean c:A)System.out.print(c+" ");
  System.out.println();
 }
 static void print(int A[])
 {
  for(int a:A)System.out.print(a+" ");
  System.out.println(); 
 }
 static void print(ArrayList<Integer> A)
 {
  for(int a:A)System.out.print(a+" ");
  System.out.println();
 }

 static void print(long A[])
 {
  for(long a:A)System.out.print(a+" ");
  System.out.println();
 }
 static long lower_Bound(long A[],int low,int high, long x) 
 { 
  if (low > high) 
   if (x >= A[high]) 
    return A[high]; 

  int mid = (low + high) / 2; 

  if (A[mid] == x) 
   return A[mid]; 

  if (mid > 0 && A[mid - 1] <= x && x < A[mid]) 
   return A[mid - 1]; 

  if (x < A[mid]) 
   return lower_Bound( A, low, mid - 1, x); 

  return lower_Bound(A, mid + 1, high, x); 
 } 
 static void sort(long[] a) //check for long
 {
  ArrayList<Long> l=new ArrayList<>();
  for (long i:a) l.add(i);
  Collections.sort(l);
  for (int i=0; i<a.length; i++) a[i]=l.get(i);
 }


 static  long pow(long a,long b)
 {
  //long mod=1000000007;
  long pow=1;
  long x=a;
  while(b!=0)
  {
   if((b&1)!=0)pow=(pow*x)%mod;
   x=(x*x)%mod;
   b/=2;
  }
  return pow;
 }
 static long toggleBits(long x)//one's complement || Toggle bits
 {
  int n=(int)(Math.floor(Math.log(x)/Math.log(2)))+1;

  return ((1<<n)-1)^x;
 }
 static int countBits(long a)
 {
  return (int)(Math.log(a)/Math.log(2)+1);
 }
 static void sort(int[] a) {
  ArrayList<Integer> l=new ArrayList<>();
  for (int i:a) l.add(i);
  Collections.sort(l);
  for (int i=0; i<a.length; i++) a[i]=l.get(i);
 }
 static boolean isPrime(long N)
 {
  if (N<=1)  return false; 
  if (N<=3)  return true; 
  if (N%2 == 0 || N%3 == 0) return false; 
  for (int i=5; i*i<=N; i=i+6) 
   if (N%i == 0 || N%(i+2) == 0) 
    return false; 
  return true; 
 }
 static long GCD(long a,long b) 
 {
  if(b==0)
  {
   return a;
  }
  else return GCD(b,a%b );
 }

 static int i()
 {
  return in.nextInt();
 }

 static long l()
 {
  return in.nextLong();
 }

 static int[] input(int N){
  int A[]=new int[N];
  for(int i=0; i<N; i++)
  {
   A[i]=in.nextInt();
  }
  return A;
 }

 static long[] inputLong(int N)     {
  long A[]=new long[N];
  for(int i=0; i<A.length; i++)A[i]=in.nextLong();
  return A;
 }


}
class pair implements Comparable<pair>
{
 int a,b,d;
 pair(int a,int b)
 {
  this.a=a;
  this.b=b;
  d=b-a;
 }
 public int compareTo(pair X)
 {
  return this.d-X.d;
 }
}
//Code For FastReader
//Code For FastReader
//Code For FastReader
//Code For FastReader
class FastReader
{
 BufferedReader br;
 StringTokenizer st;
 public FastReader()
 {
  br=new BufferedReader(new InputStreamReader(System.in));
 }

 String next()
 {
  while(st==null || !st.hasMoreElements())
  {
   try
   {
    st=new StringTokenizer(br.readLine());
   }
   catch(IOException e)
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
  String str="";
  try
  {
   str=br.readLine();
  }
  catch (IOException e)
  {
   e.printStackTrace();
  }
  return str;
 }

}