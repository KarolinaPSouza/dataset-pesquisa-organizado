/*
    /$$$$$  /$$$$$$  /$$    /$$  /$$$$$$
   |__  $$ /$$__  $$| $$   | $$ /$$__  $$
      | $$| $$  \ $$| $$   | $$| $$  \ $$
      | $$| $$$$$$$$|  $$ / $$/| $$$$$$$$
 /$$  | $$| $$__  $$ \  $$ $$/ | $$__  $$
| $$  | $$| $$  | $$  \  $$$/  | $$  | $$
|  $$$$$$/| $$  | $$   \  $/   | $$  | $$
 \______/ |__/  |__/    \_/    |__/  |__/
 /$$$$$$$  /$$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$$   /$$$$$$  /$$      /$$ /$$      /$$ /$$$$$$$$ /$$$$$$$
| $$__  $$| $$__  $$ /$$__  $$ /$$__  $$| $$__  $$ /$$__  $$| $$$    /$$$| $$$    /$$$| $$_____/| $$__  $$
| $$  \ $$| $$  \ $$| $$  \ $$| $$  \__/| $$  \ $$| $$  \ $$| $$$$  /$$$$| $$$$  /$$$$| $$      | $$  \ $$
| $$$$$$$/| $$$$$$$/| $$  | $$| $$ /$$$$| $$$$$$$/| $$$$$$$$| $$ $$/$$ $$| $$ $$/$$ $$| $$$$$   | $$$$$$$/
| $$____/ | $$__  $$| $$  | $$| $$|_  $$| $$__  $$| $$__  $$| $$  $$$| $$| $$  $$$| $$| $$__/   | $$__  $$
| $$      | $$  \ $$| $$  | $$| $$  \ $$| $$  \ $$| $$  | $$| $$\  $ | $$| $$\  $ | $$| $$      | $$  \ $$
| $$      | $$  | $$|  $$$$$$/|  $$$$$$/| $$  | $$| $$  | $$| $$ \/  | $$| $$ \/  | $$| $$$$$$$$| $$  | $$
|__/      |__/  |__/ \______/  \______/ |__/  |__/|__/  |__/|__/     |__/|__/     |__/|________/|__/  |__/
*/
import java.io.*;
import java.security.KeyPair;
import java.util.*;
import java.lang.*;
import java.math.*;
public class entry_6368866 {
    static long mod = (long)(1e9+7);
    static int minInt = Integer.MIN_VALUE;
    static int maxInt = Integer.MAX_VALUE;
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        public FastReader() {
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
        char nextChar(){
            return next().charAt(0);
        }
        String nextLine() {
            String str = "";
            try {
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static long gcd(long a, long b) { // return gcd of 2 numbers
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) { //return lcm of 2 numbers
        return (a / gcd(a, b)) * b;
    }
    static int searchlower(int a[], long b)   //To search element in an array using binary search
    {
        int start = 0, end = a.length-1,f=-1;
        while (start <= end)
        {
            int mid = start + ((end - start) / 2);
            if (a[mid] == b) {f=mid;start=mid+1;}
            else if (a[mid] > b) end = mid - 1;
            else if (a[mid] < b) {f=mid;start = mid + 1;}
        }
        return f;
    }
    static int searchhigher(int a[], long b)   //To search element in an array using binary search
    {
        int start = 0, end = a.length-1,f=-1;
        while (start <= end)
        {
            int mid = start + ((end - start) / 2);
            if (a[mid] == b) {f=mid;start=mid+1;}
            else if (a[mid] > b) {f=mid;end = mid - 1;}
            else if (a[mid] < b) start = mid + 1;
        }
        return f;
    }
    static int search(long a[], long b)   //To search element in an array using binary search
    {
        int start = 0, end = a.length - 1;
        while (start <= end)
        {
            int mid = start + ((end - start) / 2);
            if (a[mid] == b) return mid;
            else if (a[mid] > b) end = mid - 1;
            else if (a[mid] < b) start = mid + 1;
        }
        return -1;
    }
    static int[] sortArray(int[] a)
    {
        final Random random = new Random();
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            int oi = random.nextInt(n), temp = (int) a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
        return a;
    }
    static void sortbyColumn(int arr[][], int col)
    {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[col],b[col]));
    }
    static boolean[] prime(int n) //to pre calculate prime number using sieve
    {
        boolean primecheck[] = new boolean[n+1];
        Arrays.fill(primecheck, true);
        primecheck[0] = false;
        primecheck[1] = false;
        for (int i=2;i*i<n+1;i++)
        {
            if (primecheck[i])
            {
                for (int j=i*2;j<n+1;j+=i) primecheck[j] = false;
            }
        }
        return primecheck;
    }
    static int[] factor(int n) // to pre calculate prime factors using sieve
    {
        int prime[] = new int[n+1];
        for (int i=2;i<n+1;i++)
        {
            if (prime[i]==0)
            {
                for (int j=i;j<n+1;j+=i)
                {
                    if(prime[j]==0) prime[j]=i;
                }
            }
        }
        return prime;
    }
    static long power(long a, long b)
    {
        long res=1;
        while(b>0)
        {
            if(b%2==0) {a=(a*a)%mod;b/=2;}
            else {res=(res*a)%mod;b--;}
        }
        return res;
    }
    static void graph(LinkedList<Integer> node[],int n,int m,FastReader sc)
    {
        for(int j=0;j<=n;j++)
            node[j]=new LinkedList<>();
        for(int j=0;j<m;j++){
            int t1 = sc.nextInt(),t2 = sc.nextInt();
            node[t1].add(t2);
            node[t2].add(t1);
        }
    }
    static boolean isvalid(int time,int row,int col,HashMap<Integer,HashSet<Integer>> r,HashMap<Integer,HashSet<Integer>> c)
    {
        if(r.containsKey(time)){
            if(!r.get(time).contains(row)){
                if(c.containsKey(time)){
                    if(!c.get(time).contains(col)) return true;
                }
                else return true;
            }
        }
        else {
            if(c.containsKey(time)){
                if(!c.get(time).contains(col)) return true;
            }
            else return true;
        }
        return false;
    }
    static void dijkstra(LinkedList<Pair2> node[],long distance[],long visited[])
    {
        distance[1]=0;
        PriorityQueue<Pair2> q = new PriorityQueue<>(new comparingLong());
        q.add(new Pair2(0,1));
        while(!q.isEmpty())
        {
            long t1 = q.peek().a,t2 = q.peek().b;
            //System.out.println(t1+" "+t2);
            q.remove();
            if(visited[(int)t2]==1) continue;
            visited[(int)t2]=1;
            for(Pair2 e:node[(int)t2])
            {
                if(distance[(int)e.a]>(t1+e.b)){
                    distance[(int)e.a]=t1+e.b;
                    q.add(new Pair2(distance[(int)e.a],e.a));
                }
            }
        }
    }
    static int dfs(LinkedList<Integer> node[],int visited[],int number[],int index)
    {
        visited[index]=1;
        boolean p = true;
        for(int e:node[index]){
            if(visited[e]==0){
                p=false;
                number[index]+=(dfs(node,visited,number,e));
            }
        }
        if(p) number[index]=1;
        return number[index];
    }
    static void disjoint_rankunion(int rank[],int parent[],int t1,int t2)
    {
        int parentt1 = disjoint_findparent(parent,t1),parentt2 = disjoint_findparent(parent,t2);
        int rankt1 = rank[parentt1],rankt2 = rank[parentt2];
        if(parentt1==parentt2) return;
        if(rankt1>rankt2) parent[parentt2] = parentt1;
        else if(rankt2>rankt1) parent[parentt1] = parentt2;
        else {parent[parentt2]=parentt1;rank[parentt1]++;}
    }
    static int disjoint_findparent(int parent[],int t1)
    {
        if(parent[t1]==t1) return t1;
        else parent[t1] = disjoint_findparent(parent,parent[t1]);
        return parent[t1];
    }
    static void flowd_marshal(long distace[][])
    {
        for(int j=1;j<distace.length;j++){
            for(int k=1;k<distace.length;k++){
                for(int l=1;l<distace.length;l++){
                    long temp = distace[k][j]+distace[j][l];
                    if(distace[k][l]>temp) distace[k][l]=temp;
                }
            }
        }
    }
    static long sqrt(long a)
    {
        long s=1,e=1000000000;
        while(s<=e){
            long mid = s+((e-s)/2);
            if((mid*mid)==a) return mid;
            else if((mid*mid)<a) s=mid+1;
            else e=mid-1;
        }
        return e;
    }
    public static void main(String[] args) throws IOException
    {
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        FastReader sc = new FastReader();
//        int n = sc.nextInt();
//        //int n = 1;
//        for(int i=1;i<=n;i++)
//        {
//            int a = sc.nextInt(),b = sc.nextInt(),c2=0,c5=0,temp=a;
//            long ans=0;
//            while(temp>0 && temp%2==0){
//                c2++;
//                temp/=2;
//            }
//            while(temp>0 && temp%5==0){
//                c5++;
//                temp/=5;
//            }
//            if(c2==c5){
//                if(b/10==0) out.println(a*1l*b);
//                else out.println(a*1l*(b/10));
//            }
//            else if(c2>c5){
//
//            }
//            else {
//                c5-=c2;
//
//            }
//            out.println(c2+" "+c5);
//        }
        int n = sc.nextInt(),m = sc.nextInt(),q = sc.nextInt();
        long distance[][] = new long[n+1][n+1];
        for(int j=1;j<=n;j++){
            for(int k=1;k<=n;k++){
                if(j==k) distance[j][k]=0;
                else if(distance[j][k]==0) distance[j][k]=(long)1e18;
            }
        }
        for(int j=0;j<m;j++){
            int t1 = sc.nextInt(),t2 = sc.nextInt(),t3 = sc.nextInt();
            if(distance[t1][t2]>t3) distance[t1][t2]=t3;
            if(distance[t2][t1]>t3) distance[t2][t1]=t3;
        }
        flowd_marshal(distance);
        for(int j=0;j<q;j++){
            int t1 = sc.nextInt(),t2 = sc.nextInt();
            if(distance[t1][t2]==1e18) out.println(-1);
            else out.println(distance[t1][t2]);
        }
        out.close();
    }
}
class Pair
{

    int a,b,c;
    Pair(int a1,int b1,int c1)
    {
        this.a=a1;
        this.b=b1;
        this.c=c1;
    }
}
class Pair1
{
    int a,b;
    Pair1(int a1,int b1)
    {
        this.a=a1;
        this.b=b1;
    }
}
class Pair2
{
    long a,b;
    Pair2(long a1,long b1)
    {
        this.a=a1;
        this.b=b1;
    }
}
class Pair3
{
    String a;
    int b;
    Pair3(String a1,int b1)
    {
        this.a=a1;
        this.b=b1;
    }
}
class comparingLong implements Comparator<Pair2>{
    public int compare(Pair2 s1, Pair2 s2){
        //   We are returning the object in asending order of their age.
        if (s1.a < s2.a)
            return -1;
        else if (s1.a > s2.a)
            return 1;
        return 0;
    }
}