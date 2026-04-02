import java.io.*;
import java.util.*;


public class entry_7091193 {
  static int recursive_upper_bound(int arr[], int low,
            int high, int key)
{
if (low > high || low == arr.length)
return low;
int mid = low + (high - low) / 2;
if (key >= arr[mid]) {
return recursive_upper_bound(arr, mid + 1, high,
                key);
}
return recursive_upper_bound(arr, low, mid - 1,
            key);
}
   static int lower(int array[], int key)
     {
         int lowerBound = 0;
         while (lowerBound < array.length) {
             if (key > array[lowerBound])
                 lowerBound++;
             else
                 return lowerBound;
         }

         return lowerBound;
     }
  public static int[] readarr(int n) {
    MyScanner key = new MyScanner();
       out = new PrintWriter(new BufferedOutputStream(System.out));
   int []a=new int[n];
   for(int j=0;j<n;j++) {
    a[j]=key.nextInt();
   }
   return a;

  }
   public static void sort(int[] a)
     {

         ArrayList<Integer> ls = new ArrayList<>();
         for(int x: a)
             ls.add(x);
         Collections.sort(ls);
         for(int i=0; i < a.length; i++)
             a[i] = ls.get(i);
     }
     public static long gcd(long a, long b)
     {
         if(a > b)
             a = (a+b)-(b=a);
         if(a == 0L)
             return b;
         return gcd(b%a, a);
     }
     public static HashMap<Integer, Integer>
     sortByValue(HashMap<Integer, Integer> hm)
     {

         List<Map.Entry<Integer, Integer> > list
             = new LinkedList<Map.Entry<Integer, Integer> >(
                 hm.entrySet());

         Collections.sort(
             list,
             (i1,
              i2) -> i1.getValue().compareTo(i2.getValue()));

         HashMap<Integer, Integer> temp
             = new LinkedHashMap<Integer, Integer>();
         for (Map.Entry<Integer, Integer> aa : list) {
             temp.put(aa.getKey(), aa.getValue());
         }
         return temp;
     }
     public static boolean isPrime(long n)
     {
         if(n < 2) return false;
         if(n == 2 || n == 3) return true;
         if(n%2 == 0 || n%3 == 0) return false;
         long sqrtN = (long)Math.sqrt(n)+1;
         for(long i = 6L; i <= sqrtN; i += 6) {
             if(n%(i-1) == 0 || n%(i+1) == 0) return false;
         }
         return true;
     }
public static int sum(int n,int x,int[]c,int []dp) {
 if(dp[x]!=-1) {
  return dp[x];
 }
 if(x==0) {
  dp[0]=0;
 return 0;
 }
 if(x<0)
  return -1;
 int min=Integer.MAX_VALUE;
 for(int g=0;g<n;g++) {
  int a=sum(n,x-c[g],c,dp);
  if(a!=-1)
  min=Math.min(min,1+a);
 }

 return dp[x]=min;
}
  public static void main(String[] args) {
     MyScanner key = new MyScanner();
     out = new PrintWriter(new BufferedOutputStream(System.out));
    int n=key.nextInt();
    int x=key.nextInt();
    int []c=new int[n];
    int []dp=new int[x+1];
 for(int g=0;g<n;g++) {
c[g]=key.nextInt();
}
 for(int h=0;h<x;h++) {
  dp[h]=-1;
 }
 dp[0]=0;
 for(int j=1;j<=x;j++) {
 int min=Integer.MAX_VALUE;
 for(int g=0;g<n;g++) {
  if(j-c[g]>=0 && dp[j-c[g]]!=-1)
  min=Math.min(min,1+dp[j-c[g]]);
 }
 if(min==Integer.MAX_VALUE)
  dp[j]=-1;
 else
 dp[j]=min;
 }
 out.println(dp[x]);
// for(int j=0;j<=x;j++) {
// out.print(dp[j]+" ");
// }

    out.close();
  }




  public static PrintWriter out;

  public static class MyScanner {
     BufferedReader br;
     StringTokenizer st;

     public MyScanner() {
        br = new BufferedReader(new InputStreamReader(System.in));
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

     String nextLine(){
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