

/*******BISMILLAHIRRAHMAANIRRAHEEM*******/
import java.io.*;
import java.util.*;





public class entry_12747196 {
    public static void main(String[] args) throws IOException {
        // int t = scanInt();
        // while (t-- > 0) {
            solve();
        // }
    }

    public static void solve() throws IOException {
        int nCities=scanInt();
        int nConns=scanInt();
        int nQ=scanInt();

        long INF=(long)1e15;

        int g[][]=new int[nConns][3];
        for(int i=0;i<nConns;i++) g[i]=scanIntArray(3);

        long dis[][]=new long[nCities][nCities];
        for(int i=0;i<nCities;i++){
            Arrays.fill(dis[i], INF);
            dis[i][i]=0;
        }

        for(int[]e:g){
            dis[e[0]-1][e[1]-1] = Math.min(dis[e[0]-1][e[1]-1], e[2]);
            dis[e[1]-1][e[0]-1] = Math.min(dis[e[1]-1][e[0]-1], e[2]);

        }

        // for(var r:dis) System.out.println(Arrays.toString(r));

        for (int k = 0; k < nCities; k++) {
            long[] disK = dis[k];               // row k
            for (int i = 0; i < nCities; i++) {
                long dik = dis[i][k];           // d(i,k)
                if (dik == INF) continue;       // no need to try any j if i→k unreachable
                long[] disI = dis[i];           // row i
                // now only one array‐bounds check per iteration, no Math.min call
                for (int j = 0; j < nCities; j++) {
                    long alt = dik + disK[j];  
                    if (alt < disI[j]) {
                        disI[j] = alt;
                    }
                }
            }
        }

        StringBuilder sb=new StringBuilder();

        while (nQ--!=0) {
            int i=scanInt();
            int j=scanInt();
            long ans=dis[i-1][j-1];
            if(ans==INF) sb.append(-1);
            else sb.append(ans);
            sb.append(" ");
        }

        print(sb);

    }

    static int MOD = 1_000_000_007;
    static long fact[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;

    static int scanInt() throws IOException {
        return Integer.parseInt(nextToken());
    }

    static long scanLong() throws IOException {
        return Long.parseLong(nextToken());
    }

    static String scanString() throws IOException {
        return nextToken();
    }

    static int[] scanIntArray(int size) throws IOException {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanInt();
        }
        return array;
    }

    static int GCD(int a, int b) {
        return (b == 0) ? (a) : GCD(b, a % b);
    }

    static int LCM(int a, int b) {
        return ((a * b) / GCD(a, b));
    }

    static String nextToken() throws IOException {
        if (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static List<Integer> getPrimeList(int from, int tillWhere) {
        boolean isPrime[] = new boolean[tillWhere + 1];
        List<Integer> primesList = new ArrayList<>();
        Arrays.fill(isPrime, true);
        for (int i = 2; i <= tillWhere; i++) {
            if (isPrime[i]) {
                if (i >= from) {
                    primesList.add(i);
                }
                for (int j = i * i; j <= tillWhere; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return primesList;
    }

    static List<Integer> getDivisorListOf(int num) {
        List<Integer> divisorList = new ArrayList<>();
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                divisorList.add(i);
                if (num / i != i) {
                    divisorList.add(num / i);
                }
            }
        }
        return divisorList;
    }

    static void printArray(int arr[]) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int e : arr) {
            sb.append(e + " ");
        }
        bw.write(sb.toString().trim());
        bw.newLine();
        bw.flush();
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if ((n % i) == 0) {
                return false;
            }
        }
        return true;
    }

    static List<Integer> getPrimeFactorsListOf(int num) {
        if (num <= 1) {
            return new ArrayList<>();
        }
        List<Integer> primefactorsList = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                primefactorsList.add(i);
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
        if (num != 1) {
            primefactorsList.add(num);
        }
        return primefactorsList;
    }

    static long pow(long base, long exp) {
        long ans = 1l;
        boolean isNegativeExponent = exp < 0;
        exp = Math.abs(exp);
        while (exp > 0) {
            if ((exp & 1) == 1) {
                ans = (ans * base * 1l) % MOD;
            }
            base = (base * base * 1l) % MOD;
            exp >>= 1;
        }
        return isNegativeExponent ? (1l / ans) : ans;
    }

    static void compute_fact(){
        fact=new long[100001];
        fact[0]=fact[1]=1;
        for(int i=2;i<=100000;i++){
            fact[i]=(i*1l*fact[i-1])%MOD;
        }
    }

    static long nCr(int n,int r){
        long nr=fact[n];
        long dr=(fact[n-r]*1l*fact[r])%MOD;
        long inv=pow(dr,MOD-2);//using fermat little theorm, inverse(x)=pow(x,m-2) given m is prime
        long ans=(nr*1l*inv)%MOD;
        return ans;
    }

    static void print(Object o) throws IOException {
        bw.write(o.toString());
        bw.newLine();
        bw.flush();
    }

    static List<List<int[]>>get_adj(int graph[][],int nNodes){
        List<List<int[]>>adj=new ArrayList<>();
        for(int i=0;i<=nNodes;i++) adj.add(new ArrayList<>());
        for(int con[]:graph){
            adj.get(con[0]-1).add(new int[]{con[1]-1,con[2]});
            adj.get(con[1]-1).add(new int[]{con[0]-1,con[2]});
        }
        return adj;
    }

}