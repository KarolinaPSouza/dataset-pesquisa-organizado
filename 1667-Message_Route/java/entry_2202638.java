/*input
5 5
1 2
1 3
1 4
2 3
5 4
*/
import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_2202638 {
 static PrintWriter out;
 static int MOD = 1000000007;
 static FastReader scan;

    /*-------- I/O usaing short named function ---------*/
 public static String ns(){return scan.next();}
 public static int ni(){return scan.nextInt();}
 public static long nl(){return scan.nextLong();}
 public static double nd(){return scan.nextDouble();}
 public static String nln(){return scan.nextLine();}
 public static void p(Object o){out.print(o);}
 public static void ps(Object o){out.print(o + " ");}
 public static void pn(Object o){out.println(o);}
    /*-------- for output of an array ---------------------*/
     static void iPA(int arr []){
       StringBuilder output = new StringBuilder();
      for(int i=0; i<arr.length; i++)output.append(arr[i] + " ");out.println(output);
 }
 static void lPA(long arr []){
      StringBuilder output = new StringBuilder();
      for(int i=0; i<arr.length; i++)output.append(arr[i] + " ");out.println(output);
 }
 static void sPA(String arr []){
      StringBuilder output = new StringBuilder();
      for(int i=0; i<arr.length; i++)output.append(arr[i] + " ");out.println(output);
 }
 static void dPA(double arr []){
      StringBuilder output = new StringBuilder();
      for(int i=0; i<arr.length; i++)output.append(arr[i] + " ");out.println(output);
 }
    /*-------------- for input in an array ---------------------*/
 static void iIA(int arr[]){
      for(int i=0; i<arr.length; i++)arr[i] = ni();
 }
 static void lIA(long arr[]){
      for(int i=0; i<arr.length; i++)arr[i] = nl(); 
 }
 static void sIA(String arr[]){
      for(int i=0; i<arr.length; i++)arr[i] = ns(); 
 }
 static void dIA(double arr[]){
      for(int i=0; i<arr.length; i++)arr[i] = nd();
 }
 /*------------ for taking input faster ----------------*/
     static class FastReader
 {
  BufferedReader br;
  StringTokenizer st;

  public FastReader()
  {
   br = new BufferedReader(new InputStreamReader(System.in));
  }

  String next()
  {
   while (st == null || !st.hasMoreElements())
   {
    try
    {
     st = new StringTokenizer(br.readLine());
    }
    catch (IOException e)
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

 // Method to check if x is power of 2
    static boolean isPowerOfTwo (int x) { return x!=0 && ((x&(x-1)) == 0);}
    //Method to return lcm of two numbers
    static int gcd(int a, int b){return a==0?b:gcd(b % a, a); }
    //Method to count digit of a number
    static int countDigit(long n){return (int)Math.floor(Math.log10(n) + 1);}

    //Method for sorting
 static void ruffle_sort(int[] a) {
  //shandom_ruffle
  Random r=new Random();
  int n=a.length;
  for (int i=0; i<n; i++) {
   int oi=r.nextInt(n);
   int temp=a[i];
   a[i]=a[oi];
   a[oi]=temp;
  }
  //sort
  Arrays.sort(a);
 }
 //Method for checking if a number is prime or not
 static boolean isPrime(int n) { 
        if (n <= 1) return false; 
        if (n <= 3) return true; 
        if (n % 2 == 0 || n % 3 == 0) return false; 
        for (int i = 5; i * i <= n; i = i + 6) 
            if (n % i == 0 || n % (i + 2) == 0) 
            return false; 
        return true; 
    } 

 public static void main (String[] args) throws java.lang.Exception
 {
  OutputStream outputStream =System.out;
        out =new PrintWriter(outputStream);
        scan =new FastReader();
  //for fast output sometimes
  StringBuilder sb = new StringBuilder();
  int t = 1;
  while(t-->0){
   int n = ni(), m = ni();
   ArrayList<Integer> adj[] = new ArrayList[n+1];
   for(int i=1; i<=n; i++){
    adj[i] = new ArrayList<Integer>();
   }

   for(int i=0; i<m; i++){
    int u = ni(), v = ni();
    adj[u].add(v);
    adj[v].add(u);
   }

   int route[] = new int[n+1];
   Arrays.fill(route, -1);


   Queue<Integer> q = new LinkedList<>();
   q.add(1);
   route[1] =0;

   while(!q.isEmpty()){
    int u = q.poll();

    if(u == n){
     break;
    }

    for(int v : adj[u]){
     if(route[v]==-1){
      route[v] = u;
      q.add(v);
     }
    }
   }

   if(route[n] == -1){
    pn("IMPOSSIBLE");
    continue;
   }


   int path = n;
   int count = 0;

   ArrayList<Integer> res = new ArrayList<Integer>();

   while(path != 0){
    res.add(path);
    count++;
    path = route[path];
   }

   pn(count);
   for(int i=res.size()-1; i>=0; i--){
    ps(res.get(i));
   }
        }
        out.flush();
  out.close();
 }


}
