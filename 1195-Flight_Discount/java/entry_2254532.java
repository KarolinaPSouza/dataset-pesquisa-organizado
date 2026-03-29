import java.util.*;
import java.io.*;
//import java.math.*;

public class entry_2254532 {
        //  ..............code begins here..............

static long mod=(long)1e9+7,mod1=998244353l,inf=(long)1e17;
static List<int[]>[] g;
static boolean[] b;
static long[][] d;
static int f(long[] a,long[] b){
    if(a[1]-b[1]>0)return 1;
    return -1;
}
static void dijkstra() throws IOException{
    d[1][0]=d[1][1]=0;
    PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->f(a,b));
    pq.add(new long[]{1,0,0});
    pq.add(new long[]{1,0,1});
    while(!pq.isEmpty()){
        long[] p=pq.poll();
        int x=(int)p[0],f=(int)p[2];
        if(p[1]>d[x][f]) continue;
        for(int[] v:g[x]){
            if(d[v[0]][f]>v[1]+p[1]){
                d[v[0]][f]=v[1]+p[1];
                pq.add(new long[]{v[0],d[v[0]][f],f});
            }
            if((d[v[0]][1]>v[1]/2+p[1])&&f==0){
                d[v[0]][1]=v[1]/2+p[1];
                pq.add(new long[]{v[0],d[v[0]][1],1});
            }
        }
    }
}
static void solve() throws IOException {
            int[] x=int_arr();
            int n=x[0],m=x[1];
            g=new ArrayList[n+1];
            d=new long[n+1][2];
            for(int i=0;i<=n;i++){
                g[i]=new ArrayList<>();
                d[i][0]=d[i][1]=inf;
            }
            for(int i=0;i<m;i++){
                int[] e=int_arr();
                g[e[0]].add(new int[]{e[1],e[2]});
            }
            dijkstra();
            out.write(Math.min(d[n][0],d[n][1])+"");
}
//
public static void main(String[] args) throws  IOException{
                assign();
                int t=1;//int_v(read());
                int cn=1;
                while(t--!=0){
                    //out.write("Case #"+cn+": ");
                    solve();
                    cn++;
                }
                out.flush();
}

// taking inputs
static BufferedReader s1;
static BufferedWriter out;
static String read() throws IOException{String line="";while(line.length()==0){line=s1.readLine();continue;}return line;}
static int int_v (String s1){return Integer.parseInt(s1);}
static long long_v(String s1){return Long.parseLong(s1);}
static void sort(int[] a){List<Integer> l=new ArrayList<>();for(int x:a){l.add(x);}Collections.sort(l);for(int i=0;i<a.length;i++){a[i]=l.get(i);}}
static int[] int_arr() throws IOException{String[] a=read().split(" ");int[] b=new int[a.length];for(int i=0;i<a.length;i++){b[i]=int_v(a[i]);}return b;}
static long[] long_arr() throws IOException{String[] a=read().split(" ");long[] b=new long[a.length];for(int i=0;i<a.length;i++){b[i]=long_v(a[i]);}return b;}
static void assign(){s1=new BufferedReader(new InputStreamReader(System.in));out=new BufferedWriter(new OutputStreamWriter(System.out));}
//static String setpreciosion(double d,int k){BigDecimal d1 = new BigDecimal(Double.toString(d));return d1.setScale(k,RoundingMode.HALF_UP).toString();}//UP DOWN HALF_UP
static int add(int a,int b){int z=a+b;if(z>=mod)z-=mod;return z;}
static long gcd(long a,long b){if(b==0){return a;}return gcd(b,a%b);}
static long Modpow(long a,long p,long m){long res=1;while(p>0){if((p&1)!=0){res=(res*a)%m;}p >>=1;a=(a*a)%m;}return res%m;}
static long Modmul(long a,long b,long m){return ((a%m)*(b%m))%m;}
static long ModInv(long a,long m){return Modpow(a,m-2,m);}
//static long nck(int n,int r,long m){if(r>n){return 0l;}return Modmul(f[n],ModInv(Modmul(f[n-r],f[r],m),m),m);}
//static long[] f;
}