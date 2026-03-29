import java.util.*;
class Pair{
    int num;
    long dist;
    public  Pair(int a,long b){
        this.num=a;
        this.dist = b;
    }
}
public class entry_13070555 {
    static int mod = (int) Math.pow(10, 9) + 7;
    static int GCD(int u, int v)
    {
        if (u == 0)
            return v;
        return GCD(v % u, u);
    }

    // LCM of two numbers
    static int LCM(int u, int v)
    {
        return (u / GCD(u, v)) * v;
    }


    public static int binPow(int a, int b,int mod){
        if(b==0){
            return 1;
        }
        else if(b%2 == 1){
            return (a*binPow(a,b-1,mod)%mod);
        }
        else{
            int temp = (a*a)%mod;
            return binPow(temp,b/2,mod);
        }
    }
    public static int inv(int b, int mod){
        return binPow(b%mod,mod-2,mod);
    }
    public static long longBinPow(long a, long b,int mod){
        if(b==0){
            return 1;
        }
        else if(b%2 == 1){
            return (a*longBinPow(a,b-1,mod)%mod);
        }
        else{
            long temp = (a*a)%mod;
            return longBinPow(temp,b/2,mod);
        }
    }
    public static long inverse(long b, int mod){
        return longBinPow(b%mod,mod-2,mod);
    }

    static long fact[] = new long[1000100];
    static long invfact[] = new long[1000100];
   static void precompute_for_faster() {    // O(n) + O(log(mod)) + O(n) ~ O(n + log(mod))
        fact[0] = 1;
        for(int i=1; i<=1000000; i++) {
            fact[i] = (fact[i-1] * i) % mod;
        }
        invfact[1000000] = inverse(fact[1000000],mod);
        for(int i=1000000; i>=1; i--) {
            invfact[i-1] = (invfact[i] * i) % mod;
        }
    }

    static long ncr_fact_faster(int n, int r) {    // O(1)
        long num = fact[n];
        long den = (invfact[n-r] * invfact[r]) % mod;
        return (num * den) % mod;    // den is already inverted
    }

    public static boolean isPrime(int x){
       if(x == 1) return false;
       for(int i = 2;i*i<=x;i++){
           if(x%i == 0) return false;
       }
       return true;
    }
    public static long getPrimeFactor(int x){
       if(x == 1) return 1;
       long ans=1;
       boolean flag = false;
        for(int i = 2;i*i<=x;i++){
            while(x%i == 0){
                flag = true;
                ans = ans*i;
                x=x/i;
            }
            if(flag) return ans;
        }
        return ans;
    }

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static boolean isValid(int x, int y,int n, int m,char[][] grid) {
        return x >= 0 && x <n && y >= 0 && y <m  && grid[x][y] == '.';
    }

    static final long INF = (long) 1e18;
    static final int MOD = (int) 1e9 + 7;

    public static int rec(int i, int j, int k, String s1, String s2, String s3, int[][][] dp) {
        if (i < 0 || j < 0 || k < 0) {
            return 0;
        }
        if (dp[i][j][k] != -1) {
            return dp[i][j][k];
        }
        if (s1.charAt(i) == s2.charAt(j) && s2.charAt(j) == s3.charAt(k)) {
            dp[i][j][k] =  1 + rec(i - 1, j - 1, k - 1, s1, s2, s3, dp);
        } else {
            dp[i][j][k] = Math.max(rec(i - 1, j, k, s1, s2, s3, dp),
                    Math.max(rec(i, j - 1, k, s1, s2, s3, dp),
                            rec(i, j, k - 1, s1, s2, s3, dp)));
        }
        return dp[i][j][k];
    }

    public static void bfs(int i,int j,char[][] grid,int n,int m,boolean[][] vis){

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        vis[i][j] = true;
        while (!q.isEmpty()){
            int[] curr = q.poll();
            for(int k=0;k<4;k++){
                int X = curr[0]+dx[k];
                int Y = curr[1]+dy[k];
                if(isValid(X,Y,n,m,grid) && !vis[X][Y] ){
                    q.add(new int[]{X,Y});
                    vis[X][Y] = true;
                }
            }
        }
    }

    public static int ansBit(char[][] grid,int n,int m) {

        boolean[][] vis = new boolean[n][m];
        int ans = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == '.'){
                    bfs(i,j,grid,n,m,vis);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> al = new ArrayList<>();

        int n =  sc.nextInt();
        int m = sc.nextInt();
        char[][] grid = new char[n][m];
        sc.nextLine();
        for(int i=0;i<n;i++){
            String str = sc.nextLine();
            grid[i] = str.toCharArray();
        }
        System.out.println(ansBit(grid,n,m));

    }



}