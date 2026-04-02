import java.util.*;
import java.math.*;
import java.io.*; 
 public class entry_1255117 {

static FastReader scan=new FastReader();
 public static PrintWriter out = new PrintWriter (new BufferedOutputStream(System.out));
  static LinkedList<Integer>edges[];
  static LinkedList<Integer>Same[];
  static LinkedList<Integer>Dif[];
  static LinkedList<Integer>integers[];
static int []dx={1,-1,0,0};
static int []dy={0,0,1,-1};
int dx_8[]={1,1,1,0,0,-1,-1,-1};
int dy_8[]={-1,0,1,-1,1,-1,0,1};

static boolean prime[];
static long LCM(long a,long b){
    return (Math.abs(a*b))/gcd(a,b);
   }
   static long gcd(long a, long b) {
    if(a!=0&&b!=0)
        while((a%=b)!=0&&(b%=a)!=0);
    return a^b;
}
static int countSetBits(int n) 
    { 
        int count = 0; 
        while (n > 0) { 
            count += n & 1; 
            n >>= 1; 
        } 
        return count; 
    } 
 static void sieve(long n) 
    { 

        prime = new boolean[(int)n+1]; 
        for(int i=0;i<n;i++) 
            prime[i] = true; 

        for(int p = 2; p*p <=n; p++) 
        { 

            if(prime[p] == true) 
            { 

                for(int i = p*p; i <= n; i += p) 
                    prime[i] = false; 
            } 
        } 
    }  

    static int count;

  static boolean canTransmit[][]=new boolean[1000+5][1000+5];



    static boolean vis[];
    static boolean light[][];
    static char grid[][]; 

           static boolean isprime(long x)
           {
            for(long i=2;i*i<=x;i++)
                if(x%i==0)
                    return false;
                return true;
           }
           static int ans=0,perm=0,FOR=0;
           static int n,m;
           static boolean valid(int x,int y)
           {
            return (x>=0&&x<n&&y>=0&&y<n&&grid[x][y]!='.');
           }
    static ArrayList<Pair>BRAINFUCK;
    static int area[]=new int[1000000];
    static int region[][]=new int[1001][1001];
    static int permiter[]=new int[1000000];

static int R;

    static int ret=0;
    static void findp(){
        ret=0;
       for(int i=0;i<n;i++)
       {
        for(int j=0;j<n;j++)
        {

            int r=region[i][j];
            if(r==0)
                continue;
            try{
            if(region[i-1][j]==0){
                 //out.println(r);
                permiter[r]++;
            }
        }
        catch(IndexOutOfBoundsException e)
        {
            permiter[r]++;
        }
            if(region[i][j+1]==0)
                permiter[r]++;
            if(region[i+1][j]==0)
                permiter[r]++;
            try{
            if(region[i][j-1]==0)
                permiter[r]++;
        }
        catch(IndexOutOfBoundsException e)
        {
            permiter[r]++;
        }



    }

       }

    }
    static long arr[];
    static int sz[]=new int[(int)1e5+5];

static int upper_bound(long e)
{
    int l=0,r=arr.length;
    while(l<r)
    {
        int mid=(l+r)/2;
        if(arr[mid]>e)
            r=mid;
        else 
            l=mid+1;
    }
    return l;
}

static boolean flag=false;
static ArrayList<Integer>res=new ArrayList<>();
static void dfs(int x)
{
    vis[x]=true;
if(x==n){
    flag=true;
    return;
}
for(int i:edges[x])
{
    if(!vis[i]){
        dfs(i);
        res.add(i);
    }

}

}
public static void main(String[] args)  throws IOException 
{
//java.util.Scanner scan=new java.util.Scanner(new File("lightson.in"));
 //PrintWriter out = new PrintWriter (new FileWriter("lightson.out"));
  //  System.out.println(~-1);


        //System.out.println(0^1);

//SUCK IT UP AND DO IT ALRIGHT
    //System.out.println((-1*1)%mod);
    vis=new boolean[(int)1e5+5];
edges=new LinkedList[(int)1e5+5];
 n=scan.nextInt();
 m=scan.nextInt();
for(int i=0;i<=n+1;i++)
    edges[i]=new LinkedList();
for(int i=0;i<m;i++)
{
    int a=scan.nextInt(),b=scan.nextInt();
edges[a].add(b);
edges[b].add(a);
}
 ArrayDeque<Integer> q = new ArrayDeque<Integer>();
 q.add(1);
 int []dist=new int[(int)1e5+5];
 int par[]=new int[(int)1e5+5];
 dist[1]=0;
 Arrays.fill(dist,1000000);
  while(!q.isEmpty())
  {
    int p=q.poll();
    for(int i:edges[p])
    {
        if(dist[i]==1000000)
        {
            dist[i]=dist[p]+1;
            par[i]=p;
            q.add(i);
        }

    }
  }
  ArrayList<Integer>rev=new ArrayList<>();
  if(dist[n]==1000000)

    out.println("IMPOSSIBLE");

else 
{
    //out.println(par[5]);
    rev.add(n);
    int p=par[n];
    rev.add(p);
    while(p!=1)
    {
        //rev.add(p);
        p=par[p];
        rev.add(p);
    }
    Collections.reverse(rev);
out.println(rev.size());
for(int i=0;i<rev.size();i++)
    out.print(rev.get(i)+" ");
}





 out.close();



//SEE UP 

}

static long powMod(long base, long exp, long mod) {
       if (base == 0 || base == 1) return base;
       if (exp == 0) return 1;
       if (exp == 1) return base % mod;
       long R = powMod(base, exp/2, mod) % mod;
       R *= R;
       R %= mod;
       if ((exp & 1) == 1) {
           return base * R % mod;
       }
       else return R % mod;
   }
static double dis(double x1,double y1,double x2,double y2)
{
    return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
}
static long mod(long x,long y)
    {
        if(x<0)
            x=x+(-x/y+1)*y;
        return x%y;
    }
 public static  long pow(long b, long e) {
            long r = 1;
            while (e > 0) {
                if (e % 2 == 1) r = r * b ;
                b = b * b;
                e >>= 1;
            }
            return r;
        }
private static void sort(long[] arr) {
        List<Long> list = new ArrayList<>();
        for (long object : arr) list.add(object);
        Collections.sort(list);
        for (int i = 0; i < list.size(); ++i) arr[i] = list.get(i);
    }
 public static class FastReader {
        BufferedReader br;
        StringTokenizer root;


        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        boolean hasNext(){
            String line;
            while(root.hasMoreTokens())
                return true;
            return false;
        }

        String next() {
            while (root == null || !root.hasMoreTokens()) {
                try {
                    root = new StringTokenizer(br.readLine());
                } catch (Exception addd) {
                    addd.printStackTrace();
                }
            }
            return root.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (Exception addd) {
                addd.printStackTrace();
            }
            return str;
        }
         public int[] nextIntArray(int arraySize) {
            int array[] = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                array[i] = nextInt();
            }

            return array;
        }
}
 static class Pair implements Comparable<Pair>{
        public int x, y;
        public Pair(int x1, int y1) {
            x=x1;
            y=y1;
        }
        @Override
        public int hashCode() {
            return (int)(x + 31 * y);
        }
        public String toString() {
            return x + " " + y;
        }
        @Override
        public boolean equals(Object o){
            if (o == this) return true;
            if (o.getClass() != getClass()) return false;
            Pair t = (Pair)o;
            return t.x == x && t.y == y;
        }
public int compareTo(Pair o)
{
    return (x-o.y)-(o.x-y);

    }

static class pair{
    int i;
    int j;
pair(int i,int j){
    this.i=i;
    this.j=j;
}}}
 static class tuple{
        int x,y,z;
        tuple(int a,int b,int c){
            x=a;
            y=b;
            z=c;
        }
    }
    static class Edge{
        int d,w;
        Edge(int d,int w)
        {
            this.d=d;
            this.w=w;
        }
    }
}








