// "static void main" must be defined in a public class.
import java.util.*;
import java.io.*;
import java.lang.*;
//import javafx.util.Pair;
public class entry_7031885 {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
   static class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }

    }

    // static class Pair{
    //     int x;int y;
    //     Pair(int x,int y)
    //     {
    //         this.x=x;this.y=y;
    //     }
    //     int getKey()
    //     {
    //         return x;
    //     }
    //     int getValue()
    //     {
    //         return y;
    //     }
    // }
    static class graph implements Comparable<graph>{
        long x;long y;long z;
        graph()
        {

        }
        graph(long x,long y,long z)
        {
            this.x=x;this.y=y;this.z=z;
        }
        public int compareTo(graph c)
        {
            //int a=1000000007;
            if(c.z>this.z)
                return -1;
            else if(c.z<this.z)
                return 1;
            else return 0;
        }
    }
//     static class pair{
//         String word;int freq;
//         pair p;
//         pair(String xe,int ye)
//         {
//             this.word=xe;this.freq=ye;
//         }
//         String getKey()
//         {
//             return word;
//         }
//         int getValue()
//         {
//             return freq;
//         }

//     }
//     static class TrieNode{
//         TrieNode[] children=new TrieNode[26];
//         boolean is_end;int freq;
//         TrieNode(){
//             is_end=false;
//             for(int i=0;i<26;i++)
//                 children[i]=null;
//             freq=0;
//         }
//         public void insert(String word) {
//         TrieNode r=root;
//         char ch1[]=word.toCharArray();
//         for(int i=0;i<word.length();i++){
//             int ch=ch1[i]-'a';
//             if(r.children[ch]==null){
//                 r.children[ch]=new TrieNode();
//             }
//             r=r.children[ch];

//         }
//         r.is_end=true;
//             r.freq++;
//         }

//         public boolean search(String word) {
//             if(word.length()==0)
//                 return true;
//             TrieNode r=root;
//             char ch1[]=word.toCharArray();
//             for(int i=0;i<word.length();i++){
//                 int ch=ch1[i]-'a';
//                 if(r.children[ch]==null){
//                     return false;
//                 }
//                 r=r.children[ch];
//             }
//             return r.is_end;
//         }

//         public boolean startsWith(String word) {
//             if(word.length()==0)
//                 return true;
//             TrieNode r=root;
//             for(int i=0;i<word.length();i++){
//                 int ch=word.charAt(i)-'a';
//                 if(r.children[ch]==null){
//                     return false;
//                 }
//                 r=r.children[ch];
//             }
//         return true;
//         }
//         public List<pair> options(String word){
//             TrieNode r=root;
//             List<pair> ans=new ArrayList<>();
//             for(int i=0;i<word.length();i++){
//                 int ch=word.charAt(i)-'a';
//                 r=r.children[ch];
//             }//System.out.println("ASf");
//            // Pair p=new Pair(1,2);
//             if(r.is_end){
//                         ans.add(new pair(word,r.freq));
//                     }
//             op(word,ans,r);
//             Collections.sort(ans,(v1,v2)-> v2.getValue()-v1.getValue());//System.out.println("ASf");
//             return ans;
//         }
//         public void op(String word,List<pair> ls,TrieNode t){
//             // System.out.println("ASf");System.out.println("ASf");
//             // System.out.println(t.is_end);
//             //System.out.println("ASf");
//             for(int i=0;i<26;i++){
//                 if(t.children[i]!=null){
//                     word+=(char)(i+'a');//System.out.println(word+" "+t.is_end);
//                     if(t.children[i].is_end){
//                         ls.add(new pair(word,t.children[i].freq));
//                     }
//                     op(word,ls,t.children[i]);
//                     word=word.substring(0,word.length()-1);
//                 }
//             }
//         }
//     }
//     static TrieNode root=new TrieNode();
//     static void initializeDiffArray(int A[], int D[])
//  {

//   int n = A.length;

//   D[0] = A[0];
//   D[n] = 0;
//   for (int i = 1; i < n; i++)
//    D[i] = A[i] - A[i - 1];
//  }

//  // Does range update
//  static void update(int D[], int l, int r, int x)
//  {
//   D[l] += x;
//   D[r + 1] -= x;
// //       for (int i = 0; i < D.length; i++) {

// //    System.out.print(D[i] + " ");
// //   }

// //   System.out.println();
//  }

//  // Prints updated Array
//  static int printArray(int A[], int D[])
//  {
//   for (int i = 0; i < A.length; i++) {

//    if (i == 0)
//     A[i] = D[i];

//    // Note that A[0] or D[0] decides
//    // values of rest of the elements.
//    else
//     A[i] = D[i] + A[i - 1];

//    System.out.print(A[i] + " ");
//   }

//   System.out.println();

//   return 0;
//  }





    static long gcd2(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd2(b % a, a);
    }

    // method to return LCM of two numbers
    static long lcm2(long a, long b)
    {
        return (a / gcd2(a, b)) * b;
    }

    public static boolean prime[] =new boolean[100000 + 1];
    //public static int store[]=new int[1000000000+1];
    static void sieveOfEratosthenes(int n)
    {
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++)
        {
            if (prime[p] == true)
            {
                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }
        int k=0;
        // for (int i = 2; i <= n; i++)
        // {
        //     if (prime[i] == true)
        //     {store[k]=i;k++;}
        // }
    }

     static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b)
    {
        return (a / gcd(a, b)) * b;
    }
    public static Object getRunTimeValue(Map<Object,Object> sampleMap,Object key,Object defaultValue){
        if(sampleMap.containsKey(key))
            return sampleMap.get(key);
        else
            return defaultValue;
    }
    //FastReader sc = new FastReader();

    static long mod=(long)1e9+7;
    static HashSet<Integer> hsg;
    static HashSet<Integer>[] hs;
    static boolean[] vis;
    static long arr[]=new long[1000001];
    public static void main(String[] args) {
        try{
            PrintWriter out = new PrintWriter(System.out);
            FastReader sc = new FastReader();
            int n=sc.nextInt();
            int m= sc.nextInt();
            long []dis=new long[n+1];
            Arrays.fill(dis,1000000000);
            List<int[]> ls=new ArrayList<>();
            for(int i=0;i<m;i++){
                int x=sc.nextInt();int y=sc.nextInt();int d=sc.nextInt();
                ls.add(new int[]{x,y,d});
            }//
            dis[1]=0;//System.out.println("sdfsdf");
            int x=0;int p[]=new int[n+1];Arrays.fill(p,-1);
            for(int v=0;v<n;v++){
                x=-1;
               for(int e=0;e<ls.size();e++){
                   int a[]=ls.get(e);
                   // System.out.println(a[0]+" "+a[1]+" "+a[2]+" "+dis[a[0]]+" gfg "+dis[a[1]]);
                   if(dis[a[1]]>dis[a[0]]+a[2]){
                       dis[a[1]]=dis[a[0]]+a[2];p[a[1]]=a[0];x=a[1];
                   }
                   dis[a[0]]=Math.min(dis[a[0]],Long.MAX_VALUE);
               }
                // for(int i=0;i<n;i++){
                //     System.out.print(dis[i+1]+" ");
                // }
                // System.out.println();
            }
           // System.out.println("sdfsdf");
            // int ind=-1;
            // for(int e=0;e<ls.size();e++){
            //    int a[]=ls.get(e);
            //    //System.out.println(a[0]+" "+a[1]+" "+a[2]);
            //    if(dis[a[0]]!=Long.MAX_VALUE&&dis[a[1]]>dis[a[0]]+a[2]){
            //       ind=e;break;
            //    }
            // }
            if (x == -1) {
                out.println("NO");out.flush();
            } else {
                for (int i = 0; i < n; ++i)
                    x = p[x];

                List<Integer> cycle=new ArrayList<>();
                for (int v = x;; v = p[v]) {
                    cycle.add(v);
                    if (v == x && cycle.size() > 1)
                        break;
                }
                Collections.reverse(cycle);
                out.println("YES");
                for (int v : cycle)
                    out.print(v+" ");
                out.println();
                out.flush();
            }
            // // pair p=new pair();
            // test t1=new test();
            // t1.first();t1.second(23);
            // A a=new A();
            // System.out.println();
            // B b=new B();
            // System.out.println();
            // C c=new C();
            // System.out.println();
        }
          catch(Exception e)
        {
            System.out.println("sdf");
        }
    }
    // static class pair{
    //     int a;int b;
    // }
    interface interl{
        int a=34;
        void first();
        String second(int x);
    }
    static class test implements interl{
         public void first(){
            System.out.println("First");
        }
         public String second(int x){
            return x+" xx"+" "+x;
        }
    }
    static boolean dfs(int c[],List<List<Integer>> ls,int i,List<Integer> set,int par){
        //System.out.println(set+" "+i+" "+c[i]);
        if(c[i]!=-1){
            set.add(i);//System.out.println(set+" "+i+" "+c[i]);
            return true;
        }
        c[i]=1;boolean ans=false;
        set.add(i);
        for(int j:ls.get(i)){
            if(j!=par)
            ans|=dfs(c,ls,j,set,i);
            if(ans)
                return ans;
        }
        //System.out.println(ans+" "+set);
        set.remove(set.size()-1);
        return ans;
    }
    static void join(int x,int y,int par[]){
        x=find(x,par);y=find(y,par);
        if(x!=y)
            par[x]=y;
    }
    static int find(int x,int par[]){
        if(x==par[x])
            return x;
        return par[x]=find(par[x],par);
    }
    static String[] dfs(int i,int j,char c[][]){
        if(i<0||j<0||i>=c.length||j>=c[0].length||c[i][j]=='#')
            return new String[]{"","-"};
        if(c[i][j]=='B')
            return new String[]{"",""};
        c[i][j]='#';
        String ans[]=new String[]{"",""};
        String s1[]=new String[2];String s2[]=new String[2];String s3[]=new String[2];
        String s4[]=new String[2];
        s1=dfs(i+1,j,c);s1[0]="D"+s1[0];System.out.println(s1[0]+" "+s1[1]+" s1"+" "+i+" "+j);
        if(s1[1].length()==0&&(ans[0].length()==0||ans[0].length()>s1[0].length()))
            ans=new String[]{s1[0],""};
        s2=dfs(i-1,j,c);s2[0]="U"+s2[0];System.out.println(s2[0]+" "+s2[1]+" s2"+" "+i+" "+j);
        if(s2[1].length()==0&&(ans[0].length()==0||ans[0].length()>s2[0].length()))
            ans=new String[]{s2[0],""};
        s3=dfs(i,j+1,c);s3[0]="R"+s3[0];System.out.println(s3[0]+" "+s3[1]+" s3"+" "+i+" "+j);
        if(s3[1].length()==0&&(ans[0].length()==0||ans[0].length()>s3[0].length()))
            ans=new String[]{s3[0],""};
        s4=dfs(i,j-1,c);s4[0]="L"+s4[0];System.out.println(s4[0]+" "+s4[1]+" s4"+" "+i+" "+j);
        if(s4[1].length()==0&&(ans[0].length()==0||ans[0].length()>s4[0].length()))
            ans=new String[]{s4[0],""};
        System.out.println(ans[0]+" "+ans[1]+" "+(ans[0].length()==0));
        if(ans[0].length()==0)
            return new String[]{"","-"};
        return ans;
    }
    static long solve(boolean started,boolean isSmaller,String s,int i,int prev,long dp[][][][]){
        if(i==s.length())
            return 1;
        int end=isSmaller?9:s.charAt(i)-'0';
        long ans=0;
        if(prev!=-1)
        if(dp[started?1:0][isSmaller?1:0][i][prev]!=-1)
            return dp[started?1:0][isSmaller?1:0][i][prev];
        for(int i1=0;i1<=end;i1++){
            boolean nStarted=started?true:i1!=0;
            boolean nIsSmaller=isSmaller?true:i1!=end;
            //System.out.println(i1+" "+prev);
            if(i1!=prev||!nStarted)
            ans=(ans+solve(nStarted,nIsSmaller,s,i+1,i1,dp));
        }
        if(prev!=-1)
        dp[started?1:0][isSmaller?1:0][i][prev]=ans;
        return ans;
    }
    static boolean check(int mid[],int x,int a[],int i){
        if(i==a.length)
            return true;
        Set<Integer> s=new HashSet<>();
        boolean ans=false;
        for(int j=0;j<mid.length;j++){
            if(s.contains(mid[j]))
                continue;
            s.add(mid[j]);
            if(mid[j]+a[i]<=x){
                mid[j]+=a[i];
                ans|=check(mid,x,a,i+1);
                if(ans)
                    return ans;
                mid[j]-=a[i];
            }
        }
        return ans;
    }
    static int steps=0;static int count=0;
    static void solve(int i,int j,boolean vis[][],char ch[]){
        if(i==6&&j==0)
        {
            if(steps==48)
            {
                count++;
                //System.out.println("Aa");
            }
            return;
        }
        if(i<0||j<0||i>6||j>6)
            return;
        if((i==0&&j>=1&&j<=5&&vis[i+1][j]&&!vis[i][j-1]&&!vis[i][j+1])||
           (i==6&&j>=1&&j<=5&&vis[i-1][j]&&!vis[i][j-1]&&!vis[i][j+1])||
           (j==0&&i>=1&&i<=5&&vis[i][j+1]&&!vis[i-1][j]&&!vis[i+1][j])||
           (j==6&&i>=1&&i<=5&&vis[i][j-1]&&!vis[i-1][j]&&!vis[i+1][j]))
            return;
        if((j>=1&&j<=5&&i>=1&&i<=5&&vis[i][j-1]&&vis[i][j+1]&&!vis[i+1][j]&&!vis[i-1][j])||
           (i>=1&&i<=5&&j>=1&&j<=5&&vis[i-1][j]&&vis[i+1][j]&&!vis[i][j+1]&&!vis[i][j-1]))
            return;
        if(vis[i][j])
            return;
        vis[i][j]=true;
        //System.out.println(steps+" "+count);
        if((i+1<7)&&(ch[steps]=='D'||ch[steps]=='?'))
        {
            steps++;
            solve(i+1,j,vis,ch);
            steps--;
        }
        if((i-1>=0)&&(ch[steps]=='U'||ch[steps]=='?'))
        {
            steps++;
            solve(i-1,j,vis,ch);
            steps--;
        }
        if((j+1<7)&&(ch[steps]=='R'||ch[steps]=='?'))
        {
            steps++;
            solve(i,j+1,vis,ch);
            steps--;
        }
        if((j-1>=0)&&(ch[steps]=='L'||ch[steps]=='?'))
        {
            steps++;
            solve(i,j-1,vis,ch);
            steps--;
        }
        vis[i][j]=false;
    }
    static class A{
        A(){
            System.out.println("A");
        }
    }
    static class B extends A{
        B(){
            System.out.println("B");
        }
    }
    static class C extends B{
        C(){
            System.out.println("C");
        }
    }
static class disJoint{
    int[] parent;
    int[] size;
    disJoint(int n){
        parent=new int[n];
        size=new int[n];
        makeSet();
    }
    void makeSet(){
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int find(int v){
        if(parent[v]==v)return v;
        else return parent[v]=find(parent[v]);
    }
    void union(int a,int b){
        a=find(a);
        b=find(b);
        if(a!=b){
            if(size[a]<size[b])parent[a]=b;
            else parent[b]=a;
        }
    }
}



    static int mex(int[] arr, int N)
  {

    // sort the array
    Arrays.sort(arr);

    int mex = 0;
    for (int idx = 0; idx < N; idx++) {
      if (arr[idx] == mex) {
        // Increment mex
        mex += 1;
      }
    }

    // Return mex as answer
    return mex;
  }



    static final int MAXN = 1000001;

 // stores smallest prime factor for every number
 static int spf[] = new int[MAXN];

 // Calculating SPF (Smallest Prime Factor) for every
 // number till MAXN.
 // Time Complexity : O(nloglogn)
 static void sieve()
 { //System.out.println(22);
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
 static ArrayList<Integer> getFactorization(int x)
 {
  ArrayList<Integer> ret = new ArrayList<>();
        Set<Integer> s=new HashSet<>();
  while (x != 1)
  {   
            if(!s.contains(spf[x]))
   ret.add(spf[x]);
            s.add(spf[x]);
   x = x / spf[x];
  }
  return ret;
 }




    static long power(long x, long y, long p)
  {
    long res = 1; // Initialize result

    x = x % p; // Update x if it is more than or
    // equal to p

    if (x == 0)
      return 0; // In case x is divisible by p;

    while (y > 0)
    {

      // If y is odd, multiply x with result
      if ((y & 1) != 0)
        res = (res * x) % p;

      // y must be even now
      y = y >> 1; // y = y/2
      x = (x * x) % p;
    }
    return res;
  }
    public static long pow(long b,int p,long mod){
        long ans=1;//System.out.println(p);
        while(p>0){
            ans=ans*b;
            ans=ans%mod;p--;
        }
        //System.out.println(ans+" "+b+" "+p);
        return ans%mod;
    }
    public static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;

        // Check if n=2 or n=3
        if (n == 2 || n == 3)
            return true;

        // Check whether n is divisible by 2 or 3
        if (n % 2 == 0 || n % 3 == 0)
            return false;

        // Check from 5 to square root of n
        // Iterate i by (i+6)
        for (int i = 5; i <= Math.sqrt(n); i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }
    static int binomial(int n,int k){
        long ans=1;
        for(int i=1;i<=k;i++){
            ans=ans*(k+i);
            ans=ans/i;
            System.out.println(ans+" "+i);
        }
        return (int)ans;
    }

  }  