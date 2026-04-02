          import java.math.BigInteger;
         import java.util.ArrayList;
         import java.util.Arrays;
        import java.util.Collection;
        import java.util.Collections;
        import java.util.Comparator;
        import java.util.HashMap;
         import java.util.Iterator;
        import java.util.LinkedList;
        import java.util.List;
        import java.util.Map;
       import java.util.Map.Entry;
       import java.util.PriorityQueue;
        import java.util.Scanner;
        import java.util.Set;
        import java.util.Stack;
        import java.io.BufferedReader; 
        import java.io.IOException; 
        import java.io.InputStreamReader; 
        import java.util.Scanner; 
        import java.util.StringTokenizer;
        import java.util.TreeMap;
        import java.util.TreeSet;

         public class entry_903760 {

          static FastReader sc= new FastReader();
          static List<Integer> C;
          static List<Integer> B;
         static int mod=(int)1e9+9;
          static long dp[];
          static int k;
          static boolean prime[] = new boolean[100001]; 
          public static void main(String[] args) {


           int mod=(int)(1e9+7);
           String A=sc.next();
           String B=sc.next();
            int a=A.length();
                  int b=B.length();
                 int dp[][]=new int [a+1][b+1];
                  for(int i=0;i<=a;i++){
                      for(int j=0;j<=b;j++){
                          if(i==0&&j!=0){
                              dp[i][j]=j;
                          }
                          if(j==0&&i!=0){
                              dp[i][j]=i;
                          }
                          }}

                          dp[0][0]=0;
                                              int m=0;

                          for(int i=1;i<=a;i++){

                          for(int j=1;j<=b;j++){
                              if(A.charAt(i-1)!=B.charAt(j-1)){
                                   m=Math.min(dp[i-1][j],dp[i][j-1]);
                                  dp[i][j]=1+Math.min(dp[i-1][j-1],m);
                              }  
                              else{

                                  dp[i][j]=dp[i-1][j-1];
                              }        

                          }} 
           System.out.println(dp[a][b]);


          }












          static void dfs(int node, int parent, ArrayList<Integer> al[], long sts[], long afe[], int n) {
           for(int c:al[node]) {
            if(c!=parent) {
             dfs(c,node,al,sts,afe,n);
             sts[node]=(sts[node]+sts[c]);
            }
           }
  //         System.out.println(k++);
           afe[k++]=(n-sts[node])*sts[node];
          }



           static int gcd(int a, int b) 
              { 
                if (b == 0) 
                  return a; 
                return gcd(b, a % b);  
              } 

           static final int MAXN = 100001; 

              // stores smallest prime factor for every number 
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


         static  void sieveOfEratosthenes(int n) 
              { 
                  // Create a boolean array "prime[0..n]" and initialize 
                  // all entries it as true. A value in prime[i] will 
                  // finally be false if i is Not a prime, else true. 
                  //boolean prime[] = new boolean[n+1]; 
                  for(int i=0;i<n;i++) 
                      prime[i] = true; 

                  for(int p = 2; p*p <=n; p++) 
                  { 
                      // If prime[p] is not changed, then it is a prime 
                      if(prime[p] == true) 
                      { 
                          // Update all multiples of p 
                          for(int i = p*p; i <= n; i += p) 
                              prime[i] = false; 
                      } 
                  } 


                 // System.out.println(n);
              } 




          static long  solve(List<Integer> A,int n,long cost,int k,HashMap<Integer,  Integer> map) {
           //if(!map.containsKey(curr))map.put(curr,);
           //if(n==0&&curr!=0)return 1;
           if(dp[n]!=-1)return dp[n];
           if(n==0)return cost;
       //    if(dp[n]!=-1)return dp[n];
          // if(dp[n]!=-1)return dp[n];


           if(map.containsKey(C.get(n-1))) {

            long addon=0l;
            if(map.get(C.get(n-1))==1)addon=2l;
            else addon=1l;

            map.put(C.get(n-1),map.get(C.get(n-1))+1);
            //System.out.println(cost+" "+n+" "+map);
            return dp[n]=Math.min(solve(A,n-1,cost+addon,k,map),solve(A, n-1,k+cost,k, new HashMap<Integer,Integer>(C.get(n-1),1)));

           }
           else {map.put(C.get(n-1), 1); return dp[n] =solve(A,  n-1, cost,k, map);
           }

          }





         static int exponentMod(int A,  
                              int B, int C)  
       {  

           // Base cases  
           if (A == 0)  
               return 0;  
           if (B == 0)  
               return 1;  

           // If B is even  
           long y;  
           if (B % 2 == 0) 
           {  
               y = exponentMod(A, B / 2, C);  
               y = (y * y) % C;  
           }  

           // If B is odd  
           else 
           {  
               y = A % C;  
               y = (y * exponentMod(A, B - 1,  
                                    C) % C) % C;  
           }  

           return (int)((y + C) % C);  
       }  

         static int modulo(int a,int b,int c) {
              long x=1;
              long y=a;
              while(b > 0){
                  if(b%2 == 1){
                      x=(x*y)%c;
                  }
                  y = (y*y)%c; // squaring the base
                  b /= 2;
              }
              return (int) x%c;
          }

           static int power(int x, int y, int p) 
              { 
                  // Initialize result 
                  int res = 1;      

                  // Update x if it is more   
                  // than or equal to p 
                  x = x % p;  

                 if (x == 0) return 0; // In case x is divisible by p;    

                  while (y > 0) 
                  { 
                      // If y is odd, multiply x 
                      // with result 
                      if((y & 1)==1) 
                          res = (res * x) % p; 

                      // y must be even now 
                      // y = y / 2 
                      y = y >> 1;  
                      x = (x * x) % p;  
                  } 
                  return res; 
              }
          static int N = 100000;  

             static int n; // array size 

             // Max size of tree 
             static int []tree = new int[2 * N]; 

           static void build( int []arr)  
              {  

                  // insert leaf nodes in tree 
                  for (int i = 0; i < n; i++)  
                      tree[n + i] = arr[i]; 

                  // build the tree by calculating 
                  // parents 
                  for (int i = n - 1; i > 0; --i)  
                      tree[i] = tree[i << 1] + 
                                tree[i << 1 | 1];  
              } 

              // function to update a tree node 
              static void updateTreeNode(int p, int value)  
              {  

                  // set value at position p 
                  tree[p + n] = value; 
                  p = p + n; 

                  // move upward and update parents 
                  for (int i = p; i > 1; i >>= 1) 
                      tree[i >> 1] = tree[i] + tree[i^1]; 
              } 

              // function to get sum on 
              // interval [l, r) 
              static int query(int l, int r)  
              {  
                  int res = 0; 

                  // loop to find the sum in the range 
                  for (l += n, r += n; l < r; 
                                       l >>= 1, r >>= 1) 
                  { 
                      if ((l & 1) > 0)  
                          res += tree[l++]; 

                      if ((r & 1) > 0)  
                          res += tree[--r]; 
                  } 

                  return res; 
              } 




          static int a=1;



         static class decimal{
          int n;double d;
          public decimal(int n,double d) {

           this.n=n;
           this.d=d;
           // TODO Auto-generated constructor stub
          }
         }

         static boolean isPossible(List<Integer> C,int m,int k) {
           if(m==0)return false;
           for(int i=0;i<C.size();i++) {

            if(C.get(i)>m) {
             k-=C.get(i)/m;
            }
            if(k<0)return false;
           }
            return true;


          }




          static boolean isSubsetSum(int set[],  int n, int sum) 
        { 
        // The value of subset[i][j] will be 
        // true if there is a subset of 
        // set[0..j-1] with sum equal to i 
        boolean subset[][] = new boolean[sum + 1][n + 1]; 

        // If sum is 0, then answer is true 
        for (int i = 0; i <= n; i++) 
        subset[0][i] = true; 

        // If sum is not 0 and set is empty, 
        // then answer is false 
        for (int i = 1; i <= sum; i++) 
        subset[i][0] = false; 

        // Fill the subset table in botton 
        // up manner 
        for (int i = 1; i <= sum; i++) { 
        for (int j = 1; j <= n; j++) { 
            subset[i][j] = subset[i][j - 1]; 
            if (i >= set[j - 1]) 
                subset[i][j] = subset[i][j] 
                               || subset[i - set[j - 1]][j - 1]; 
        } 
        } 


        return subset[sum][n]; 
        } 




          static boolean search(ArrayList<Integer> a,int m,int h) {
           PriorityQueue<Integer> p=new PriorityQueue<Integer>(new Comparator<Integer>() {
             @Override
             public int compare(Integer o1, Integer o2) {
              // TODO Auto-generated method stub
              return o2-o1;
             }
           });



           for(int i=0;i<m;i++) {
            p.add(a.get(i));
           }
           int c=0;
           //System.out.println(p);
           while(!p.isEmpty()) {
            //System.out.println(p);

            h-=p.poll();
            if(h<0)break;

            c++;

           // System.out.println(h+" "+p+" "+c+" "+m);

            if(!p.isEmpty()) {
            p.poll();
            c++;}


           }
          // System.out.println(c!=m);
           if(c!=m)return false;

           return true;
          }
         // static int  key=-1;






          static boolean isPowerOfTwo(long n) 
             { 
                 if (n == 0) 
                     return false; 

                 while (n != 1) 
                 { 
                     if (n % 2 != 0) 
                         return false; 
                     n = n / 2; 
                 } 
                 return true; 
             } 

           static boolean isPerfectSquare(double x)  
              { 

                  // Find floating point value of 
                  // square root of x. 
                  double sr = Math.sqrt(x); 

                  // If square root is an integer 
                  return ((sr - Math.floor(sr)) == 0); 
              } 






         static int binarySearch(ArrayList<Long> arr, int l, int r, long x,int key) 
             { 
                 if (r >= l) { 
                     int mid =  (r + l) / 2; 
         //  if(mid>=arr.size())return -1;
                     // If the element is present at the 
                     // middle itself 

                     if (arr.get(mid) == x) 
                         return mid+1; 

                     // If element is smaller than mid, then 
                     // it can only be present in left subarray 
                     if (arr.get(mid) > x) {
                         return binarySearch(arr, l, mid - 1, x,key); 
                     }
                     // Else the element can only be present 
                     // in right subarray
                     key=mid+1;
                     return binarySearch(arr, mid + 1, r, x,key); 
                 } 

                 // We reach here when element is not present 
                 // in array 
                 return key; 
             } 








             static boolean isPrime(long n) 
             { 
                  // Corner cases 
                 if (n <= 1) 
                     return false; 
                 if (n <= 3) 
                     return true; 

                 // This is checked so that we can skip 
                 // middle five numbers in below loop 
                 if (n % 2 == 0 || n % 3 == 0) 
                     return false; 

                 for (int i = 5; i * i <= n; i = i + 6) 
                     if (n % i == 0 || n % (i + 2) == 0) 
                         return false; 

                 return true; 
             } 



             static class FastReader 
             { 
                 BufferedReader br; 
                 StringTokenizer st; 

                 public FastReader() 
                 { 
                     br = new BufferedReader(new
                              InputStreamReader(System.in)); 
                 } 

                 String next() 
                 { 
                     while (st == null || !st.hasMoreElements()) 
                     { 
                         try
                         { 
                             st = new StringTokenizer(br.readLine()); 
                         } 
                         catch (IOException  e) 
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



         }

         class Sol {

          int value;int in;int i;
          Sol(int value,int in,int i){
           this.value=value;
           this.in=in;
           this.i=i;
          }

        }

        class SegmentTree {

        SegNode st[];
        int n;
       // long arr[];
        public SegmentTree(int n) {
          this.n=n;
         //this.arr=arr;
         st=new SegNode[4*n];

        }

        void init(long n) {

         for(int i=0;i<4*n;i++) {
          st[i]=new SegNode();
         }

        }

        void set(int i,long v,int x,int lx,int rx) {

         if(rx-lx==1) {
          st[x].sum=v;
          st[x].max=v;
          return ;
         }
         int m=lx+(rx-lx)/2;
         if(i<m) set(i,v,2*x+1,lx,m);
         else set(i,v,2*x+2,m,rx); 

         st[x].sum=st[2*x+1].sum+st[2*x+2].sum;
         long ma=Math.max(st[2*x+1].max,st[2*x+2].max);
          st[x].max=Math.max(ma,st[x].sum);
        }

        void set (int i,long v) {
         set(i,v,0,0,n);
        }

        long max=Integer.MIN_VALUE;
       long sum(int l,int r,int x,int lx,int rx) {
        if(lx>=r||l>=rx)return 0;
        if(lx>=l||rx<=r)return st[x].sum;

         int m=(rx+lx)/2;

         long s1=sum(l,r,2*x+1,lx,m);
         long s2=sum(l,r,2*x+2,m,rx);  

         return max= Math.max(Math.max(Math.max(s1,s2),s1+s2),max);


        }
        long sum(int l,int r) {
         return sum(l,r,0,0,n);
        }










       }
        class SegNode{
         long max;long sum;
         public SegNode() {
          // TODO Auto-generated constructor stub
          sum=0;
          max=Integer.MIN_VALUE;

         }
        }



