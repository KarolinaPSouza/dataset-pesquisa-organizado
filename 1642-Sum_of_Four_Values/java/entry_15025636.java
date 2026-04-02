import java.io.*;
import java.math.BigDecimal;
import java.util.*;
public class entry_15025636 {

static class FastReader{private final InputStream in; private final byte[] buffer = new byte[1 << 16];private int ptr = 0, len = 0;
FastReader(){ this.in = System.in; }private int read() throws IOException { if(ptr >= len){len = in.read(buffer);ptr = 0;if(len <= 0) return -1;}return buffer[ptr++];}
int nextInt() {int c; try{while((c = read()) <= ' '){if(c == -1) return Integer.MIN_VALUE;}int sign = 1;if(c == '-'){ sign = -1; c = read(); }int val = 0;while(c > ' '){val = val * 10 + (c - '0');c = read();}return val * sign;}catch(IOException e){ return 0; }}
long nextLong() {int c; try{ while((c = read()) <= ' '){ if(c == -1) return Long.MIN_VALUE;}int sign = 1;if(c == '-'){ sign = -1; c = read();}long val = 0;while(c > ' '){ val = val * 10 + (c - '0');  c = read();}return val * sign;}catch(IOException e){ return 0; }}
String next(){StringBuilder sb = new StringBuilder();int c;try{ while((c = read()) <= ' ' && c != -1);while(c > ' ' && c != -1){sb.append((char)c);c = read();}}catch(IOException e){}return sb.toString();}}

FastReader sc = new FastReader();
PrintWriter out = new PrintWriter(System.out);
static final long modL=9223372036854775783L;
static final int mod=676767677;
static final int max=Integer.MAX_VALUE;
static final long maxx=(long)1e18;
static final long INF=(long)1e63-1;
static final int min=Integer.MIN_VALUE;
static final long minn=-(long)1e30;
static final BigDecimal pi=new BigDecimal("3.141592653589793238");

int ini(){return sc.nextInt();}
long inl(){return sc.nextLong();}
String ins(){return sc.next();}
char inch(){return sc.next().charAt(0);}
void inArr(int[]a){for(int i=0;i<a.length;i++){a[i]=sc.nextInt();}}
void inArr(long[]a){for(int i=0;i<a.length;i++){a[i]=sc.nextLong();}}
void inArr(int[][]a){for(int i=0;i<a.length;i++){for(int j=0;j<a[0].length;j++){a[i][j]=sc.nextInt();}}}
void inArr(long[][]a){for(int i=0;i<a.length;i++){for(int j=0;j<a[0].length;j++){a[i][j]=sc.nextLong();}}}

void pll(){out.println();}
void pll(int x){out.println(x);}
void pll(long x){out.println(x);}
void pll(double x){out.println(x);}
void pll(String x){out.println(x);}
void pl(int x){out.print(x);}
void pl(long x){out.print(x);}
void pl(double x){out.print(x);}
void pl(String x){out.print(x);}
void pll(char x){out.println(x);}
void pl(char x){out.print(x);}
void pArr(int[]a){for(int i=0;i<a.length;i++){out.print(a[i]+" ");}pll();}
void pArr(long[]a){for(int i=0;i<a.length;i++){out.print(a[i]+" ");}pll();}
void pArr(ArrayList<Integer>a){for(int i=0;i<a.size();i++){out.print(a.get(i)+" ");}pll();}
void pArr(int[][]a){for(int i=0;i<a.length;i++){for(int j=0;j<a[0].length;j++){out.print(a[i][j]+" "); } pll();}}
void yes(){out.println("Yes");}
void no(){out.println("No");}

int max(int a,int b){return Math.max(a, b);}
int min(int a,int b){return Math.min(a, b);}
long max(long a,long b){return Math.max(a, b);}
long min(long a,long b){return Math.min(a, b);}
int ceil(int x,int y){int x1=(int)Math.ceil((double)x /(double)y); return x1;}
long ceil(long x,long y){long x1=(long)Math.ceil((double)x /(double)y);return x1;}
double ceil( double x){ return Math.log(x)/ Math.log(2);}
long floor(long x,long y){long x1=(long)Math.floor((double)x/(double)y);return x1;}
int stoi( String st){String s=st.replaceFirst("^0" ,"");if( s=="0"){return 0;}return Integer.parseInt(s);}
long log2(long num){return(long)(Math.log(num)/Math.log(2));}
int log2(int num){return(int)(Math.log(num)/Math.log(2));}
double log2(double num){return(double)(Math.log(num)/Math.log(2));}
boolean isPerfectSq( int n){int s= (int)Math.sqrt(n);return  (s*s == n);}
boolean isPerfectSq( long n){long s= (long)Math.sqrt(n);return  (s*s == n);}
long sqrt(long x) {long start = 0, end = (long) 3e9, ans = 1; while (start <= end) {long mid = (start + end) / 2; if (mid * mid <= x) {ans = mid;start = mid + 1;} else end = mid - 1;} return ans;}
long modInverse(long a, long mod) {return pow(a, mod - 2);}
long pow(long b, long e){long res=1;b= b % mod; while(e> 0){ if((e & 1)==1){e-=1; res= (res * b) % mod; }else{ b=(b * b) % mod;e>>=1;}}return res;}
int gcd(int a, int b){if(b==0) {return a;}return gcd(b, a % b);}
long gcd(long a, long b){if(b==0) {return a;}return gcd(b, a % b);}
long lcm(long a, long b){return (a/gcd(a,b)*b);}
long abs(long a) { return Math.abs(a);}
int  abs(int a) { return Math.abs(a);}
int MEX(int a[]){ Set<Integer>st=new HashSet<>(); for(int i=0;i<a.length; i++){ st.add(a[i]);}int mex=0; while(st.contains(mex)) { mex++;} return mex;}

int findMax(int[] a) {int m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] > m) {m = a[i];}} return m;}
long findMax(long [] a) {long m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] > m) {m = a[i];}} return m;}
int findMin(int[] a) {int m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] < m) {m = a[i];}} return m;}
long findMin(long [] a) {long m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] <m) {m = a[i];}} return m;}
long findSum(long a[]){ long sum =0;for(int i=0;i<a.length;i++){ sum+=a[i];} return sum; }
long findSum(ArrayList<Long>a){ long sum =0;for(int i=0;i<a.size();i++){ sum+=a.get(i);} return sum; }

int lower_bound(long[] a,long val) {int l = 0; int r = a.length - 1; int ans = a.length ; while (l <= r) { int m = (l + r) / 2; if (a[m] >= val) { r = m - 1; ans = m;} else {l = m + 1; }} return ans; }// lowest index ele greater then equals to val 
int lower_bound(int[] a,int val) {int l = 0; int r = a.length - 1; int ans = a.length ; while (l <= r) { int m = (l + r) / 2; if (a[m] >= val) { r = m - 1; ans = m;} else {l = m + 1; }} return ans; }// lowest index ele greater then equals to val 
int lower_bound(ArrayList<Integer> ls , int val){ int l=0;int r= ls.size()-1; int ans= ls.size(); while( l<= r){int mid= (l+r)/2; if( ls.get(mid) >= val){  r= mid - 1;ans= mid ; }else{ l=mid+ 1;}  } return ans;}
int upper_bound(int[] a,int val) {int l= 0; int r = a.length - 1; int ans = a.length ; while (l <= r){int m = (l + r) / 2; if (a[m] <= val ) { l = m + 1; ans = m ;} else {r = m - 1 ;} }  return ans; } // gretest index ele less then equals tp val 
int upper_bound(ArrayList<Integer> ls , int val){int l=0;int r=ls.size()-1;  int ans= -1; while( l<= r){int mid= (l+r)/2; if( ls.get(mid)> val){ r=mid-1;  ans= ls.get(mid); }else{ l= mid+1;}}return ans;}

static class PairL {long x; long y;PairL(long x, long y){this.x = x;this.y=y;}} ;
static class Pair {int x; int y;Pair(int x,int y) { this.x = x;this.y = y;}@Override public boolean equals(Object o) { if (this == o) return true;if (o == null || getClass() != o.getClass()) return false; Pair pair = (Pair) o;return x == pair.x && y == pair.y; } @Override  public int hashCode() {return Objects.hash(x, y); }}
static class Triple {int x,y,z; Triple(int x, int y,int z){this.x = x;this.y = y; this.z=z;}}

void merge(int[] arr,int l,int m,int h){ArrayList<Integer> t=new ArrayList<>();int i=l;int r=m+1;while(i<=m&&r<=h){if(arr[i]<=arr[r]){t.add(arr[i]);i++;}else{t.add(arr[r]);r++;}}while(i<=m){t.add(arr[i]);i++;}while(r<= h){t.add(arr[r]);r++;}for(int x=l;x<=h;x++){arr[x]=t.get(x-l);}}
void ascSort(int[]arr,int l,int h){if(l>=h)return ;int m=(l+h)/2 ;ascSort(arr, l, m);ascSort(arr,m+1,h);merge(arr,l,m,h);}
void dmerge(int[]arr, int l,int m,int h) {ArrayList<Integer> t=new ArrayList<>();int i=l;int r=m+1;while(i<=m&&r<=h){if(arr[i]>=arr[r]){t.add(arr[i]);i++;}else{t.add(arr[r]);r++;}}while(i<=m){t.add(arr[i]);i++;}while(r<= h){t.add(arr[r]);r++;}for(int x=l;x<=h;x++){arr[x]=t.get(x-l);}}
void descSort(int[] arr,int l,int h){if(l>=h)return ;int m=(l+h)/2 ;descSort(arr,l,m);descSort(arr,m+1,h);dmerge(arr,l,m,h);}
void ascSort(long[]arr,long l,long h){if(l>=h)return ;long m=(l+h)/2 ;ascSort(arr, l, m);ascSort(arr,m+1,h);merge(arr,l,m,h);}
void merge(long[]arr,long l,long m,long h){ArrayList<Long> t=new ArrayList<>();long i=l;long r=m+1;while(i<=m&&r<=h){if(arr[(int)i]<=arr[(int)r]){t.add(arr[(int)i]);i++;}else{t.add(arr[(int)r]);r++;}}while(i<=m){t.add(arr[(int)i]);i++;}while(r<= h){t.add(arr[(int)r]);r++;}for(long x=l;x<=h;x++){arr[(int)x]=t.get((int)(x-l));}}
void descSort(long[] arr, int l, int h) {if (l >= h) return;int m = (l + h) / 2;descSort(arr, l, m);descSort(arr, m + 1, h);dmerge(arr, l, m, h);}
void dmerge(long[] arr, int l, int m, int h) {ArrayList<Long> t = new ArrayList<>();int i = l, r = m + 1; while (i <= m && r <= h) {if (arr[i] >= arr[r]) {t.add(arr[i]); i++;}else {t.add(arr[r]);r++;}}while (i <= m) {t.add(arr[i]);i++;}while (r <= h) { t.add(arr[r]);r++;}for (int x = l; x <= h; x++) {arr[x] = t.get(x - l);}}

public void DEBUG(Object... args){for(Object arg:args){ if(arg instanceof int[]){System.out.println(Arrays.toString((int[])arg));} else if(arg instanceof long[]){System.out.println(Arrays.toString((long[])arg));} else if(arg instanceof double[]){System.out.println(Arrays.toString((double[])arg));}else if(arg instanceof Object[]){System.out.println(Arrays.deepToString((Object[])arg));}else{System.out.println(arg);}}}

public static void main(String[]args){entry_15025636 sk_18=new entry_15025636();sk_18.solve();}
public void solve(){
    int t=1;
    while(t-- >0){
      ans();
    }
    out.flush();
}

// public void ans(){
//       int n= ini();
//       int a[][]= new int[n][3];
//       for(int i=0; i< n; i++){
//           int x= ini(); int y= ini();
//           a[i][0]= x; a[i][1]= y; a[i][2]=i;
//       }
//       Arrays.sort(a, (p1, p2) -> {
//            if(p1[1]== p2[1]){
//                return Integer.compare(p2[0], p1[0]);
//            }else{
//                return Integer.compare(p1[1], p2[1]);
//            }
//       });
//       TreeMap<Integer, Integer> mp = new TreeMap<>();
//      // DEBUG(a);
//       int ans[][]=new int[2][n];
//       for(int i=0; i< n; i++){
//           int cnt=0;
//           for(Integer v : mp.tailMap(a[i][0], true).values()){
//               cnt+= v;
//           }
//           ans[0][a[i][2]]= cnt;
//           mp.put(a[i][0], mp.getOrDefault(a[i][0], 0) + 1);
//       }
//         mp.clear();
//         for(int i= n-1; i >= 0 ; i--){
//            int cnt=0;
//            for(Integer v : mp.headMap(a[i][0], true).values()){
//                cnt+= v;
//            }
//            ans[1][a[i][2]]= cnt;
//            mp.put(a[i][0], mp.getOrDefault(a[i][0],0) + 1);
//       }
//       pArr(ans);

//   }
// }


public void ans(){
      int n= ini();
      long tar= inl();
      long a[][]=new long[n][2];
      for(int i=0; i< n; i++){
          a[i][0]= inl();
          a[i][1]= i;
      }

      Arrays.sort(a, (p1, p2) -> Long.compare(p1[0], p2[0]));

      for(int i=0; i< n - 3; i++){
          if (a[i][0] + a[i + 1][0] + a[i + 2][0] + a[i + 3][0] > tar) {
                break; 
            }
            if (a[i][0] + a[n - 1][0] + a[n - 2][0] + a[n - 3][0] < tar) {
                continue; 
            }

          for(int j = i + 1;  j< n -2 ; j++){
                   if (a[i][0] + a[j][0] + a[j + 1][0] + a[j + 2][0] > tar) {
                        break;
                    }

                    if (a[i][0] + a[j][0] + a[n - 1][0] + a[n - 2][0] < tar) {
                        continue;
                    }

                    int jj = j + 1;
                    int k= n-1;

                    while( jj < k){
                         if(a[i][0] + a[j][0] + a[jj][0] + a[k][0] == tar){
                            long ans[]= { a[i][1] + 1, a[j][1] +1, a[jj][1] + 1, a[k][1] + 1};
                            Arrays.sort(ans);
                            pArr(ans);
                            return;
                        }else if( a[i][0] + a[j][0] + a[jj][0] + a[k][0] < tar){
                            jj++;
                        }else{
                            k--;
                        }
                }
        }
    }



      pll("IMPOSSIBLE");



  }

}