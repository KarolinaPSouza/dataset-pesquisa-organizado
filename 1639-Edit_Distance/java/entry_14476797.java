import java.io.*;  
import java.util.*;  

public class entry_14476797 {
    static FastReader in; static PrintWriter out;  
    static final int MOD=1_000_000_007; static final long INF=Long.MAX_VALUE; static final int[] dx={-1,0,1,0}; static final int[] dy={0,1,0,-1};  

    static List<List<Integer>> buildGraph(int n, List<Pair<Integer,Integer>> edges){List<List<Integer>> g=new ArrayList<>();for(int i=0;i<n;i++)g.add(new ArrayList<>());for(Pair<Integer,Integer> e:edges){int u=e.first,v=e.second;g.get(u).add(v);g.get(v).add(u);}return g;}  
    static List<List<Integer>> buildGraph(int n,int[][]edges){List<List<Integer>> g=new ArrayList<>();for(int i=0;i<=n;i++)g.add(new ArrayList<>());for(int[]e:edges){int u=e[0],v=e[1];g.get(u).add(v);g.get(v).add(u);}return g;}  
    static List<List<Integer>> buildDirectedGraph(int n,int[][]edges){List<List<Integer>> g=new ArrayList<>();for(int i=0;i<n;i++)g.add(new ArrayList<>());for(int[]e:edges){g.get(e[0]).add(e[1]);}return g;}  
    static List<List<Edge>> buildDirectedWeightedGraph(int n,int[][]edges){List<List<Edge>> g=new ArrayList<>();for(int i=0;i<=n;i++)g.add(new ArrayList<>());for(int[]e:edges){g.get(e[0]).add(new Edge(e[1],e[2]));g.get(e[1]).add(new Edge(e[0],e[2]));}return g;}  

    static class DisjointSet{List<Integer> p=new ArrayList<>(),sz=new ArrayList<>();DisjointSet(int n){for(int i=0;i<n;i++){p.add(i);sz.add(1);}}int findUPar(int x){if(x==p.get(x))return x;int u=findUPar(p.get(x));p.set(x,u);return u;}void unionBySize(int u,int v){int pu=findUPar(u),pv=findUPar(v);if(pu==pv)return;if(sz.get(pu)<sz.get(pv)){p.set(pu,pv);sz.set(pv,sz.get(pv)+sz.get(pu));}else{p.set(pv,pu);sz.set(pu,sz.get(pu)+sz.get(pv));}}}  

    public static int gcd(int a,int b){while(b!=0){int t=b;b=a%b;a=t;}return a;}  
    public static long gcd(long a,long b){while(b!=0){long t=b;b=a%b;a=t;}return a;}  
    public static int max(int[]a){return Arrays.stream(a).max().getAsInt();}  
    public static int min(int[]a){return Arrays.stream(a).min().getAsInt();}  
    public static int lcm(int a,int b){return (int)(1L*a*b/gcd(a,b));}  
    public static long lcm(long a,long b){return a/gcd(a,b)*b;}  
    public static void swap(int[]a,int i,int j){int t=a[i];a[i]=a[j];a[j]=t;}  
    public static boolean isPrime(int n){if(n<2)return false;for(int i=2;i*i<=n;i++)if(n%i==0)return false;return true;}  
    public static boolean[] sieve(int n){boolean[]p=new boolean[n+1];Arrays.fill(p,true);p[0]=p[1]=false;for(int i=2;i*i<=n;i++)if(p[i])for(int j=i*i;j<=n;j+=i)p[j]=false;return p;}  
    public static boolean isSorted(int[]a){for(int i=1;i<a.length;i++)if(a[i]<a[i-1])return false;return true;}  
    public static int[] read(int n)throws IOException{int[]a=new int[n];for(int i=0;i<n;i++)a[i]=in.nextInt();return a;}  
    public static double[] readD(int n)throws IOException{double[]a=new double[n];for(int i=0;i<n;i++)a[i]=in.nextDouble();return a;}  
    public static int[][] read2(int n,int m)throws IOException{int[][]a=new int[n][m];for(int i=0;i<n;i++)for(int j=0;j<m;j++)a[i][j]=in.nextInt();return a;}  
    static char[][] reads(int n)throws Exception{char[][]g=new char[n][n];for(int i=0;i<n;i++)g[i]=in.nextLine().toCharArray();return g;}  
    public static int[][] readEdges(int n)throws IOException{int[][]e=new int[n][2];for(int i=0;i<n;i++){e[i][0]=in.nextInt();e[i][1]=in.nextInt();}return e;}  

    public static void main(String[] args) throws Exception {
            // Local input/output for testing
            int loc=0;
            if(loc==1)
            {     
                if (System.getProperty("ONLINE_JUDGE") == null) {
                    in = new FastReader(new FileInputStream("input.txt"));
                    out = new PrintWriter(new FileOutputStream("output.txt"));
                } else {
                    in = new FastReader(System.in);
                    out = new PrintWriter(System.out);
                }
            }
            //use while uploading the file 
            else
            {
                in = new FastReader(System.in);
                out = new PrintWriter(System.out);
            }
            int T = 1;
            //T = in.nextInt();  // Uncomment for multiple test cases
            for (int t = 1; t <= T; t++) {
                solve(t);
            }

            out.flush();
            out.close();
        }


















    // ------------------- SOLUTION -------------------
    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
static void solve(int t) throws Exception {
        String s=in.nextLine();
        String z=in.nextLine();
        int n=s.length();
        int m=z.length();
        int [][]dp=new int[n+1][m+1];
        for(int j=0; j<=m; j++) dp[s.length()][j]=m-j;
        for(int i=0; i<=n; i++) dp[i][z.length()]=n-i;
        for(int i=n-1; i>=0; i--)
        {
            for(int j=m-1; j>=0; j--)
            {
                int x=Integer.MAX_VALUE;
                if(s.charAt(i)==z.charAt(j))
                {
                    x=dp[i+1][j+1];
                }
                int r=1+dp[i+1][j+1];
                int in=1+dp[i][j+1];
                int d=1+dp[i+1][j];
                dp[i][j]=Math.min(x,Math.min(in,Math.min(d,r)));
            }
        }
        out.println(dp[0][0]);

}

    //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||












    // UTILITY CLASSES
    static class FastReader{BufferedReader br;StringTokenizer st;FastReader(InputStream s){br=new BufferedReader(new InputStreamReader(s));}String next()throws IOException{while(st==null||!st.hasMoreTokens()){String l=br.readLine();if(l==null)throw new IOException("End");st=new StringTokenizer(l);}return st.nextToken();}String nextLine()throws IOException{return br.readLine();}int nextInt()throws IOException{return Integer.parseInt(next());}long nextLong()throws IOException{return Long.parseLong(next());}double nextDouble()throws IOException{return Double.parseDouble(next());}int[] readI(int n)throws IOException{int[]a=new int[n];for(int i=0;i<n;i++)a[i]=nextInt();return a;}long[] readL(int n)throws IOException{long[]a=new long[n];for(int i=0;i<n;i++)a[i]=nextLong();return a;}}  
    static class Pair<U,V>{public U first;public V second;Pair(U f,V s){first=f;second=s;}}  
    static class Triple<U,V,W>{public U first;public V second;public W third;Triple(U f,V s,W t){first=f;second=s;third=t;}}  
    static class Edge{int to,weight;Edge(int t,int w){to=t;weight=w;}}  
}