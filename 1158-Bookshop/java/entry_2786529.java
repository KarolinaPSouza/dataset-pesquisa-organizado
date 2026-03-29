// Piyush Nagpal
import java.util.*;
import java.io.*;
 public class entry_2786529 {

    static int MOD=1000000007;
    static PrintWriter pw;
    static FastReader sc;

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

        double nextDouble(){return Double.parseDouble(next());}

        public char nextChar() throws IOException {return next().charAt(0);}

        String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int[] intArr(int n) throws IOException {int[]in=new int[n];for(int i=0;i<n;i++)in[i]=nextInt();return in;}
        public long[] longArr(int n) throws IOException {long[]in=new long[n];for(int i=0;i<n;i++)in[i]=nextLong();return in;}

    }   


     public static long gcd(long a,long b){if( b>a ){return gcd(b,a);}if( b==0 ){return a;} return gcd(b,a%b);}
     public static long expo( long a,long b,long M ){long result=1;while(b>0){if( b%2==1 ){result=(result*a)%M;}a=(a*a)%M;b=b/2;}return result%M;}
    public static ArrayList<Long> Sieve(int n){boolean [] arr= new boolean[n+1];Arrays.fill(arr, true);ArrayList<Long> list= new ArrayList<>();for(int i=2;i<=n;i++){if( arr[i]==true ){list.add((long)i);}for(int j=2*i;j<=n;j+=i){arr[j]=false;}}return list;}

    public static void printarr(int [] arr){for(int i=0;i<arr.length;i++){pw.print(arr[i]+" ");}}
    public static void printarr(long [] arr){for(int i=0;i<arr.length;i++){pw.print(arr[i]+" ");}}

    // int [] arr=sc.intArr(n);
    static void solve() throws Exception{
        int n=sc.nextInt(),tar=sc.nextInt();
        int [] prices= sc.intArr(n);
        int [] pages= sc.intArr(n);
        int [][] dp= new int [n][tar+1];

        for(int j=0;j<dp[0].length;j++){
            if( (j-prices[0])>=0 ){
                dp[0][j]=pages[0];
            }
        }
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                    if( (j-prices[i])>=0 ){
                        dp[i][j]=Math.max(dp[i-1][j],(dp[i-1][j-prices[i]]+pages[i]));
                    }else{
                            dp[i][j]=dp[i-1][j];
                    }

                }
            }

        pw.println(dp[n-1][tar]);
   }

   public static void main(String[] args) throws Exception{
        try {
            System.setIn(new FileInputStream("input.txt"));
            System.setOut(new PrintStream(new FileOutputStream("output.txt")));
        } catch (Exception e) {
            System.err.println("Error");
        }
        sc= new FastReader();
        pw = new PrintWriter(System.out);



        // for(int i=0;i<1001;i++){
        //     for(int j=0;j<1001;j++){
        //         Arrays.fill(dp[i][j],-1);
        //     }
        // }

        int tc=1;
        // tc=sc.nextInt();
        for(int ii=1;ii<=tc;ii++) {
//            pw.printf("Case #%d: "b, i);
            solve();
            // pw.println(gridpath(0,0,arr));
        }

        pw.flush();



    }

}