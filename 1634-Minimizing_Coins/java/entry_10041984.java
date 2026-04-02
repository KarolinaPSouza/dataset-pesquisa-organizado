import java.io.*;
import java.util.*;
public class entry_10041984 {
    /*-------------------------------------------EDITING CODE STARTS HERE-------------------------------------------*/
    public static boolean takeTestCase=false;
    public static int mod = (int) 1e9+7; //DON'T REMOVE IT`
    public static void solve(int tCase) throws IOException {
        int n=sc.nextInt();
        int x=sc.nextInt();
        int[] arr=Helper.read_int_array(n);
        int[] dp=new int[x+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int i=1;i<dp.length;i++){
            for(int j=0;j<n;j++){
                if(i>=arr[j]){
                   if(dp[i-arr[j]]!=-1){
                       if(dp[i]!=-1){
                           dp[i]=Math.min(dp[i],dp[i-arr[j]]+1);
                       }else{
                           dp[i]=dp[i-arr[j]]+1;
                       }
                   }
                }
            }
        }
        out.println(dp[x]);
    }

    /*-------------------------------------------EDITING CODE ENDS HERE-------------------------------------------*/
    /*--------------------------------------MAIN FUNCTIONS Start HERE-----------------------------------------*/
    public static void main(String[] args) throws IOException {
        openIO();
        int testCase=1;
        if(takeTestCase){
            testCase=sc.nextInt();
        }
        for (int i = 1; i <= testCase; i++) solve(i);
        closeIO();
    }
    /*--------------------------------------MAIN FUNCTIONS ENDS HERE-----------------------------------------*/
    /*--------------------------------------ARRAY FUNCTIONS START HERE-----------------------------------------*/

    public static int upper_bound(int[] arr,int val){
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(arr[mid]>val){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i;
        //next greater eleement hi return karega agr bo element present bhi hai to
        //time complexity willl be log(N)
    }
    public static int upper_bound(long[] arr,long val){
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(arr[mid]>val){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i;
        //next greater eleement hi return karega agr bo element present bhi hai to
        //time complexity willl be log(N)
    }
    public static int lower_bound(int[] arr,int val){
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(arr[mid]>=val){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i;
        //agr element hai to vo wala return kardega nahi to just greater wala return karega
        //time complexity is log(N)
    }
    public static int lower_bound(long[] arr,long val){
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int mid=(i+j)/2;
            if(arr[mid]>=val){
                j=mid-1;
            }else{
                i=mid+1;
            }
        }
        return i;
        //agr element hai to vo wala return kardega nahi to just greater wala return karega
        //time complexity is log(N)
    }
    public static void _sort(int[] arr, boolean isAscending) {
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        for (int ele : arr) list.add(ele);
        Collections.sort(list);
        if (!isAscending) Collections.reverse(list);
        for (int i = 0; i < n; i++) arr[i] = list.get(i);
    }
    public static void _sort(long[] arr, boolean isAscending) {
        int n = arr.length;
        List<Long> list = new ArrayList<>();
        for (long ele : arr) list.add(ele);
        Collections.sort(list);
        if (!isAscending) Collections.reverse(list);
        for (int i = 0; i < n; i++) arr[i] = list.get(i);
    }
    public static boolean containSubstring(String str,String t){
        for(int i=0;i<str.length()-t.length()+1;i++){
            if(str.substring(i,i+t.length()).equals(t)){
                return true;
            }
        }
        return false;
    }
    public static boolean containSum(ArrayList<Integer>arr,int val){
        HashMap<Long,Integer> hp=new HashMap<>();
        long sum=0;
        hp.put(0L,-1);
        for(int i=0;i<arr.size();i++){
            sum+=arr.get(i);
            if(hp.containsKey(sum-val)){
                return true;
            }else{
                hp.put(sum,i);
            }
        }
        return false;
    }
    public static boolean containSum(int[] arr,int val){
        HashMap<Long,Integer> hp=new HashMap<>();
        long sum=0;
        hp.put(0L,-1);
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            if(hp.containsKey(sum-val)){
                return true;
            }else{
                hp.put(sum,i);
            }
        }
        return false;
    }
    /*--------------------------------------ARRAY FUNCTIONS ENDS HERE-----------------------------------------*/

    /*--------------------------------------BASIC MATHS START HERE-----------------------------------------*/

    public static int count_divisors(int n){
        int ans=0;
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                ans+=2;
                if(i*i==n){
                    ans--;
                }
            }
        }
        return ans;
        //time complexity  ---> √n
    }
    public static long pow(int base,int p,int mod){
        if(p==0){
            return 1;
        }
        if(p%2==1){
            return base*pow(base,p-1,mod)%mod;
        }else{
            long temp=pow(base,p/2,mod)%mod;
            return temp*temp%mod;
        }
    }
    public static long pow(int base,int p){
        if(p==0){
            return 1;
        }
        if(p%2==1){
            return base*pow(base,p-1);
        }else{
            long temp=pow(base,p/2);
            return temp*temp;
        }
    }
    public static int _digitCount(long num,int base){
        // this will give the # of digits needed for a number num in format : base
        return (int)(1 + Math.log(num)/Math.log(base));
        // time : O(1), space : O(1)
    }
    public static long _gcd(long a, long b) {
        while (a>0){
            long x = a;
            a = b % a;
            b = x;
        }
        return b;
        // euclidean algorithm time O(max (loga ,logb))
    }
    public static long _lcm(long a, long b) {
        return (a / _gcd(a, b)) * b;
        // lcm(a,b) * gcd(a,b) = a * b
    }

    /*--------------------------------------BASIC MATHS ENDS HERE-----------------------------------------*/
    /*--------------------------------------HELPER FUNCTIONS STARTS HERE-----------------------------------------*/
    // time for pre-computation of factorial and inverse-factorial table : O(nlog(mod))
    public static long[] factorial , inverseFact;
    public static void _ncr_precompute(int n){
        factorial = new long[n+1];
        inverseFact = new long[n+1];
        factorial[0] = inverseFact[0] = 1;
        for (int i = 1; i <=n; i++) {
            factorial[i] = (factorial[i - 1] * i) % mod;
            inverseFact[i] = _modExpo(factorial[i], mod - 2);
        }
        // time of factorial calculation after pre-computation is O(1)
    }
    public static int _ncr(int n,int r){
        if(r > n)return 0;
        return (int)(factorial[n] * inverseFact[r] % mod * inverseFact[n - r] % mod);
    }
    public static int _npr(int n,int r){
        if(r > n)return 0;
        return (int)(factorial[n] * inverseFact[n - r] % mod);
    }
    public static long _modExpo(long x, long n) {
        if(x==1)return 1;
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans *= x;
                ans %= mod;
                n--;
            } else {
                x *= x;
                x %= mod;
                n >>= 1;
            }
        }
        return ans;
        // binary exponentiation time O(logn)
    }
    public static long _modInv(long a,long b){

        return (a * _modExpo(b,mod-2)) % mod;
        // function to find a/b under modulo mod. time : O(logn)
    }

    /*--------------------------------------HELPER FUNCTIONS ENDS HERE-----------------------------------------*/
    static class Node<K>{
        K ff;
        public Node(K ff){
            this.ff=ff;
        }
    }
    static class Pair<K, V>{
        K ff;
        V ss;

        public Pair(K ff, V ss) {
            this.ff = ff;
            this.ss = ss;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || this.getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return ff.equals(pair.ff) && ss.equals(pair.ss);
        }

        @Override
        public int hashCode() {
            return Objects.hash(ff, ss);
        }
        @Override
        public String toString(){
            return ff.toString()+" "+ss.toString();
        }
    }
    static class Triple<K,V,L>{
        K f;
        V s;
        L t;
        Triple(K f,V s,L t){
            this.t=t;
            this.f=f;
            this.s=s;
        }
    }
    static class Edge{
        int src;
        int dist;
        int weight;
        public Edge(int src,int dist){
            this.src=src;
            this.dist=dist;
        }
        public Edge(int src,int dist,int weight){
            this.src=src;
            this.dist=dist;
            this.weight=weight;
        }
    }

    //Graph Template Start
    public static ArrayList<Edge>[] constructgraph(int v,int edges) throws IOException {
        return constructgraph(v,edges,false);
    }
    public static ArrayList<Edge>[] constructgraph(int v,int edges,boolean directed) throws IOException {
        ArrayList<Edge>[] ans=new ArrayList[v];
        for(int i=0;i<v;i++){
            ans[i]=new ArrayList<Edge>();
        }
        for(int i=0;i<edges;i++){
            int src=sc.nextInt();
            int dist=sc.nextInt();
            int weight=0;
            if(directed){
                weight=sc.nextInt();
            }
            ans[src-1].add(new Edge(src-1,dist-1,weight));
            ans[dist-1].add(new Edge(dist-1,src-1,weight));
        }
        return ans;
    }
    public static int[][] adjacentmatrix(int v,int edges) throws IOException{
        return adjacentmatrix(v,edges,false);
    }

    public static int[][] adjacentmatrix(int v,int edges,boolean directed) throws IOException {
        int[][] arr=new int[v][v];
        for(int i=0;i<edges;i++){
            int src=sc.nextInt();
            int dest=sc.nextInt();
            int weight=0;
            if(directed){
                weight=sc.nextInt();
            }
            arr[src][dest]=weight;
            arr[dest][src]=weight;
        }
        return arr;
    }
    public static boolean hasPath(ArrayList<Edge>[] graph,int src,int dest,boolean[] visited){
        if(src==dest){
            return true;
        }
        visited[src]=true;
        for(Edge edge:graph[src]){
            if(!visited[edge.dist]){
                boolean havepath=hasPath(graph,edge.dist,dest,visited);
                if(havepath){
                    return true;
                }
            }
        }
        return false;
    }
    //Graph Template End

    /*-------------------------------------------FAST INPUT STARTS HERE---------------------------------------------*/

    static FastestReader sc;
    static PrintWriter out;

    private static void openIO() throws IOException {
        sc = new FastestReader();
        out = new PrintWriter(System.out);
    }

    public static void closeIO() throws IOException {
        out.flush();
        out.close();
        sc.close();
    }

    private static final class FastestReader {
        private static final int BUFFER_SIZE = 1 << 16;
        private final DataInputStream din;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastestReader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public FastestReader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        private static boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        private int skip() throws IOException {
            int b;
            //noinspection StatementWithEmptyBody
            while ((b = read()) != -1 && isSpaceChar(b)) {}
            return b;
        }

        public String next() throws IOException {
            int b = skip();
            final StringBuilder sb = new StringBuilder();
            while (!isSpaceChar(b)) { // when nextLine, (isSpaceChar(b) && b != ' ')
                sb.appendCodePoint(b);
                b = read();
            }
            return sb.toString();
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();

            final boolean neg = c == '-';
            if (neg) c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return neg?-ret:ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ') c = read();

            final boolean neg = c == '-';
            if (neg) c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            return neg?-ret:ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ') c = read();

            final boolean neg = c == '-';
            if (neg) c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
                while ((c = read()) >= '0' && c <= '9')
                    ret += (c - '0') / (div *= 10);

            return neg?-ret:ret;
        }
        public String nextLine() throws IOException {
            final byte[] buf = new byte[(1<<10)]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    break;
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) buffer[0] = -1;
        }
        private byte read() throws IOException {
            if (bufferPointer == bytesRead) fillBuffer();
            return buffer[bufferPointer++];
        }
        public void close() throws IOException {
            din.close();
        }
    }
    static class Helper{
        public static int[] read_int_array(int n) throws IOException {
            int[] arr=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            return arr;
        }
        public static long[] read_long_array(int n) throws IOException {
            long[] arr=new long[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextLong();
            }
            return arr;
        }
        public static int[][] arrayinput(int n,int m) throws IOException {
            int[][] arr=new int[n][m];
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    arr[i][j]=sc.nextInt();
                }
            }
            return arr;
        }
        public static void printarray(int[] arr){
            for(int i=0;i<arr.length;i++){
                out.print(arr[i]+ " ");
            }
            out.println();
        }
        public static void printarray(ArrayList<Integer> arr){
            for(int i=0;i<arr.size();i++){
                out.print(arr.get(i)+ " ");
            }
            out.println();
        }
        public static void arrayfill(int[][] arr,int val){
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    arr[i][j]+=val;
                }
            }
        }
        public static void arrayfill(long[][] arr,int val){
            for(int i=0;i<arr.length;i++){
                for(int j=0;j<arr[0].length;j++){
                    arr[i][j]+=val;
                }
            }
        }
        public static int[] arrayfill(int[] arr,int val){
            for(int i=0;i<arr.length;i++){
                arr[i]+=val;
            }
            return arr;
        }
    }
    static class Bit{
        public static long findor(long L,long R){
            String g1=Long.toBinaryString(L);
            String g2=Long.toBinaryString(R);
            if(g1.length()!=g2.length()){
                return (long)((1L <<g2.length())-1);
            }
            int j=0;
            while(j<g1.length()){
                if(g1.charAt(j)==g2.charAt(j)){
                    j++;
                }else{
                    break;
                }
            }
            return (long)((R|((1L <<(g1.length()-j))-1)));
        }
        public static int findand(int left,int right){
            if(left==right){
                return left;
            }else if(left==0){
                return 0;
            }
            String s=Integer.toBinaryString(left);
            String s1=Integer.toBinaryString(right);
            int i=0;
            if(s.length()!=s1.length()){
                return 0;
            }
            while(i<s.length()){
                if(s.charAt(i)==s1.charAt(i)){
                    i++;
                }else{
                    break;
                }
            }
            return (right>>(s.length()-i))<<(s.length()-i);
        }
        public static int xor(int n){
            if(n%4==0){
                return n;
            }else if(n%4==1){
                return 1;
            }else if(n%4==2){
                return n^1;
            }else{
                return 0;
            }
        }
    }
    static class Prime{
        public static boolean[] all_prime(int n){

            boolean[] arr=new boolean[n+1];
            Arrays.fill(arr,true);
            arr[0]=false;
            arr[1]=false;
            for(int i=2;i<=n;i++){
                if(!arr[i]){
                    continue;
                }
                for(int j=i+i;j<=n;j+=i){
                    arr[j]=false;
                }
            }

            return arr;

            // time_complexity --> n(log(log(n))
        }
        public static boolean _isPrime(long n){
            if(n<2)return false;
            for(long i=2;i*i<=n;i++)
                if(n%i == 0)return false;
            return true;
            // takes O(sqrt(n))
        }
        public static int[]  _firstDivisor(int mx){
            int[] firstDivisor = new int[mx+1];
            firstDivisor[0] = firstDivisor[1] = 1;
            for(int i=2;i<=mx;i++)firstDivisor[i] = i;
            for(int i=2;i*i<=mx;i++)
                if(firstDivisor[i] == i)
                    for(int j = i*i;j<=mx;j+=i)
                        if(firstDivisor[j]==j)firstDivisor[j] = i;
            return firstDivisor;
            //sieve or first divisor time : O(mx * log ( log (mx) ) )
        }
    }
    static class StringHelper{
        public static String sortString(String inputString) {
            // Converting input string to character array
            char[] tempArray = inputString.toCharArray();

            // Sorting temp array using
            Arrays.sort(tempArray);

            // Returning new sorted string
            return new String(tempArray);
        }
        public static int longestcommonsubsequence(String s,String t){
            if(s.length()==0||t.length()==0){
                return 0;
            }
            int[][] dp=new int[s.length()+1][t.length()+1];
            for(int i=0;i<=s.length();i++){
                dp[i][0]=0;
            }
            for(int i=0;i<=t.length();i++){
                dp[0][i]=0;
            }

            for(int i=1;i<=s.length();i++){
                for(int j=1;j<=t.length();j++){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            return dp[s.length()][t.length()];
        }
        public static int longestcommonsubstring(String s,String t){
            int[][] dp=new int[s.length()+1][t.length()+1];
            int ans=0;
            for(int i=0;i<=s.length();i++){
                dp[i][0]=0;
            }
            for(int i=0;i<=t.length();i++){
                dp[0][i]=0;
            }
            for(int i=1;i<=s.length();i++){
                for(int j=1;j<=t.length();j++){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                    }else{
                        dp[i][j]=0;
                    }
                    ans=Math.max(dp[i][j],ans);
                }
            }
            return ans;
        }
        public static String printlongestcommonsubsequence(String s,String t){
            if(s.length()==0||t.length()==0){
                return "";
            }
            int[][] dp=new int[s.length()+1][t.length()+1];
            for(int i=0;i<=s.length();i++){
                dp[i][0]=0;
            }
            for(int i=0;i<=t.length();i++){
                dp[0][i]=0;
            }

            for(int i=1;i<=s.length();i++){
                for(int j=1;j<=t.length();j++){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            int i=s.length();
            int j=t.length();
            String ans="";
            while (i>0&&j>0){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    ans=s.charAt(i-1)+ans;
                    i--;
                    j--;
                }else{
                    if(dp[i-1][j]>dp[i][j-1]){
                        i--;
                    }else{
                        j--;
                    }
                }
            }
            return ans;
        }
        //pending
        public static String shortestsupersubsequence(String s,String t){
            if(s.length()==0||t.length()==0){
                return s+t;
            }
            int[][] dp=new int[s.length()+1][t.length()+1];
            for(int i=0;i<=s.length();i++){
                dp[i][0]=0;
            }
            for(int i=0;i<=t.length();i++){
                dp[0][i]=0;
            }

            for(int i=1;i<=s.length();i++){
                for(int j=1;j<=t.length();j++){
                    if(s.charAt(i-1)==t.charAt(j-1)){
                        dp[i][j]=1+dp[i-1][j-1];
                    }else{
                        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            int i=s.length();
            int j=t.length();
            String ans="";
            while (i>0||j>0){
                if(i==0){
                    ans=t.charAt(j-1)+ans;
                    j--;
                    continue;
                }else if(j==0){
                    ans=s.charAt(i-1)+ans;
                    i--;
                    continue;
                }
                if(s.charAt(i-1)==t.charAt(j-1)){
                    ans=s.charAt(i-1)+ans;
                    i--;
                    j--;
                }else{
                    if(dp[i-1][j]>dp[i][j-1]){
                        ans=s.charAt(i-1)+ans;
                        i--;
                    }else{
                        ans=t.charAt(j-1)+ans;
                        j--;
                    }
                }
            }
            return ans;
        }
        public static String reverseString(String s){
            String ans="";
            for(int i=0;i<s.length();i++){
                ans=s.charAt(i)+ans;
            }
            return ans;
        }
        public static boolean ispalindrom(String s){
            if(s.equals(reverseString(s))){
                return true;
            }else{
                return false;
            }
        }

    }

    /*---------------------------------------------FAST INPUT ENDS HERE ---------------------------------------------*/
}


/** Some points to keep in mind :
 * 1. don't use Arrays.sort(primitive data type array)
 * 2. try to make the parameters of a recursive function as less as possible,more use static variables.
 * 3. If n = 5000, then O(n^2 logn) need atleast 4 sec to work
 * 4. dp[2][n] works faster than dp[n][2]
 * 5. if split wrt 1 char use '\\' before char: .split("\\.");
 * 6. while using dp, do not change the state variable for next recursive call apart from the function call itself.
 * 7. (int + int + long) can give integer overflow while (long + int + int) will not
 * 8. when you divide while doing modulo, better to use modular inverse for division
 * 9. If you are subtracting under modulo, always add mod and then take mod after subtraction
 *
 *
 **/