import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

public class entry_11024620 {
static class FastReader {

    BufferedReader br;
    StringTokenizer st;
    public FastReader() {br=new BufferedReader(new InputStreamReader(System.in));}
    String next() {while (st == null || !st.hasMoreElements()){try {st = new StringTokenizer(br.readLine());}catch(IOException e){e.printStackTrace();}}return st.nextToken();}
    int nextInt() {return Integer.parseInt(next());}
    long nextLong() {return Long.parseLong(next());}
    double nextDouble() {return Double.parseDouble(next());}}
    FastReader sc = new FastReader();
    PrintWriter out = new PrintWriter(System.out);

    static final int mod=1000000007;
    static final int max=Integer.MAX_VALUE;
    static final int min=Integer.MIN_VALUE;
    static final BigDecimal pi = new BigDecimal("3.141592653589793238");


    int ini(){return sc.nextInt();}
    long inl(){return sc.nextLong();}
    String ins(){return sc.next();}
    char inch(){return sc.next().charAt(0);}
    void inArr(int[]a){for(int i=0;i<a.length;i++){a[i] = sc.nextInt();}}
    void inArr(char[]a){for(int i=0;i<a.length;i++){a[i]=sc.next().charAt(i);}}
    void inArr(long[] a){for(int i=0;i<a.length;i++){a[i]=sc.nextLong();}}
    void inArr(String[] a){for (int i = 0; i < a.length; i++){a[i] = sc.next();}}
    void inList(ArrayList<Integer>a){for(int i=0;i<a.size();i++){a.add(sc.nextInt());}}
    void inmat(int [][]a){for(int i=0;i<a.length;i++){for(int j=0;j<a[0].length;j++){a[i][j]=sc.nextInt();}}}
    void inmat(long [][]a){for(int i=0;i<a.length;i++){for(int j=0;j<a[0].length;j++){a[i][j]=sc.nextLong();}}}
    void inmat(char[][]a){for(int i=0;i<a.length;i++){for(int j=0;j<a[0].length;j++){a[i][j]=sc.next().charAt(0);}}}

    void yes(){out.println("Yes");}
    void no(){out.println("No");}
    void pl(){out.println();}
    void pl(int x){out.println(x);}
    void pl(double x){out.println(x);}
    void pl(long x){out.println(x);}
    void pl(char x){out.println(x);}
    void pl(String x){out.println(x);}
    void pArr(int[] a){for(int i=0;i<a.length;i++){out.print(a[i]+" "); }}
    void pArr(long[]a){for(int i=0;i<a.length;i++){out.print(a[i]+" "); pl();}}
    void pArr(ArrayList<Integer> a){for(int i=0; i<a.size();i++){out.print(a.get(i)+" ");pl();}}
    void pArr(int [][]a){for(int i=0;i<a.length;i++){for(int j=0;j<a[0].length;j++){out.print(a[i][j]+" ");} pl();} pl();}

    //find
    int max(int a,int b){return Math.max(a, b);}
    int min(int a,int b){return Math.min(a, b);}
    long max(long a,long b){return Math.max(a, b);}
    long min(long a,long b){return Math.min(a, b);}
    int ceil(int x,int y){int x1=(int)Math.ceil((double)x /(double)y); return x1;}
    int stoi( String st){String s=st.replaceFirst("^0" ,"");if( s=="0"){return 0;}return Integer.parseInt(s);}
    boolean isPowOf(long k,int n){return ((k&(k-1)) == 0);}
    long log2(long x,long n){return(long)(Math.log(x)/Math.log(n));}
    long pow(long base, long expo){long res = 1;base = base % mod; while (expo > 0) {if ((expo & 1) == 1) { res=(res*base)%mod;}expo = expo >> 1;base = (base * base) % mod;}return res;}
    int gcd(int a, int b){if(b==0) {return a;}return gcd(b, a % b);}
    long gcd(long a, long b){if(b==0) {return a;}return gcd(b, a % b);}
    long lcm(long a, long b){return (a/gcd(a,b)*b);}

    int getMax(int[] a) {int m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] > m) {m = a[i];}} return m;}
    long getMax(long [] a) {long m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] > m) {m = a[i];}} return m;}
    int getMin(int[] a) {int m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] < m) {m = a[i];}} return m;}
    long getMin(long [] a) {long m = a[0];for (int i = 1; i < a.length; i++) {if (a[i] <m) {m = a[i];}} return m;}
    int binToDec(String s){int dec=Integer.parseInt(s,2);return dec;}
    String decToBin(int n){StringBuilder res = new StringBuilder();while (n > 0) {res.append(n % 2);n /= 2;}return revString(res.toString());}
    boolean isPrime(int n){int c=0;for(int i=1;i<=Math.sqrt(n);i++ ){if(n %i ==0){c++;if((n/i) !=i){c++;}}if(c>2){return false;}}return c==2;}
    void swap(int []arr,int i,int j){int temp=arr[i];arr[i]=arr[j]; arr[j]=temp;}
    String ConvertNumToStr(int num){ return Integer.toString(num);}
    String ConvertStrArrToStr(String a[]){return String.join("");}
    String ConvertNumArrToStr(int a[]){StringBuilder sb=new StringBuilder(); for(int i=0;i<a.length;i++){sb.append(Integer.toString(a[i]));} return sb.toString();}

    void merge(int[] arr,int l,int m,int h){ArrayList<Integer> t=new ArrayList<>();int i=l;int r=m+1;while(i<=m&&r<=h){if(arr[i]<=arr[r]){t.add(arr[i]);i++;}else{t.add(arr[r]);r++;}}while(i<=m){t.add(arr[i]);i++;}while(r<= h){t.add(arr[r]);r++;}for(int x=l;x<=h;x++){arr[x]=t.get(x-l);}}
    void ascSort(int[]arr,int l,int h){if(l>=h)return ;int m=(l+h)/2 ;ascSort(arr, l, m);ascSort(arr,m+1,h);merge(arr,l,m,h);}
    void dmerge(int[]arr, int l,int m,int h) {ArrayList<Integer> t=new ArrayList<>();int i=l;int r=m+1;while(i<=m&&r<=h){if(arr[i]>=arr[r]){t.add(arr[i]);i++;}else{t.add(arr[r]);r++;}}while(i<=m){t.add(arr[i]);i++;}while(r<= h){t.add(arr[r]);r++;}for(int x=l;x<=h;x++){arr[x]=t.get(x-l);}}
    void descSort(int[] arr,int l,int h){if(l>=h)return ;int m=(l+h)/2 ;descSort(arr,l,m);descSort(arr,m+1,h);dmerge(arr,l,m,h);}
    boolean isSorted(int a[],int start,int end){ boolean f=true;for(int i=start;i<end-1;i++){if(a[i] >a[i+1]){f=false;break;}}return f; }
    void sortPairArr( Pair[] a){ Arrays.sort(a, (p1, p2) -> Integer.compare(p1.x, p2.x));}
    void SortArr2d(int arr[][]){Arrays.sort(arr,(a,b) -> Integer.compare(a[0],b[0]));}
    void revArr(int arr[]){int i=0;int j=arr.length-1; while(i<j){int t=arr[i];arr[i]=arr[j];arr[j]=t;i++;j--;}}
    String revString(String st){StringBuilder str=new StringBuilder(st); str.reverse();  return str.toString();}

    public static class Pair {int x,y;Pair(int x, int y){this.x = x;this.y = y;}}
    public static class Triple {int x,y,z;Triple(int x, int y,int z){this.x = x;this.y = y; this.z=z;}}
    // void minPairPq(Pair arr[]){PriorityQueue<Pair>minpq=new PriorityQueue<>((a,b)->Integer.compare(a.x,b.x));}
    void ascSort(long[]arr,long l,long h){if(l>=h)return ;long m=(l+h)/2 ;ascSort(arr, l, m);ascSort(arr,m+1,h);merge(arr,l,m,h);}
    void merge(long[] arr,long l,long m,long h){ArrayList<Long> t=new ArrayList<>();long i=l;long r=m+1;while(i<=m&&r<=h){if(arr[(int)i]<=arr[(int)r]){t.add(arr[(int)i]);i++;}else{t.add(arr[(int)r]);r++;}}while(i<=m){t.add(arr[(int)i]);i++;}while(r<= h){t.add(arr[(int)r]);r++;}for(long x=l;x<=h;x++){arr[(int)x]=t.get((int)(x-l));}}

    public static void main(String args[]){entry_11024620 FC27 = new entry_11024620();FC27.solve();}
        public void solve() {
            int t =1;

            while (t-- > 0) {
                ans();

            }
            out.close();
        }
// || 


 //-------------------dp-----------------
 //state->dp[i][j]=maximum no. of pages i have with j MONEY
 //transition-> 
//  if(Price(i-1) <=M)
//         dp[i][j]=max(val[i][j]+dp[i-1][j-wt[i],dp[i-1][j]]) ----(take,notTake)ith book
//  else   dp[i][j]=dp[i-1][j];

 //base case - if(money==0) then no. of book =0  if book is 0 then no. of books is also 0


public void ans(){
    int n=ini();
    int k=ini();
    int pr[]=new int[n];
    int pages[]=new int[n];
    inArr(pr);
    inArr(pages);
    int dp[][]=new int[n+1][k+1];

    for(int i=0;i<=n;i++){
         dp[i][0]=0;
    }
    for(int i=0;i<=k;i++){
        dp[0][i]=0;
   }


    for(int i=1; i<=n;i++){
        for(int j=1;j<=k;j++){
            if(pr[i-1] <=j){
                dp[i][j]=max(pages[i-1]+ dp[i-1][j-pr[i-1]],dp[i-1][j]);
            }
            else{
                dp[i][j]=dp[i-1][j];
            }
    }
    }
    System.out.println(dp[n][k]);



}
}






















