import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class entry_1714789 {

    static BufferedReader br;
    static long mod = 1000000000 + 7;
    static HashSet<Integer> p = new HashSet<>();

    public static void main(String[] args) throws Exception {
        br = new BufferedReader(new InputStreamReader(System.in));
        int tc = 1;
        //  tc = cinI();
        while (tc-- > 0) {
            int[] nm =readArray(2,0,0);int n  =nm[0];int m =nm[1];
            List<Integer>[] g = new List[n+1];
            for(int i=0;i<n+1;i++){
                g[i]=new LinkedList<>();
            }
            for(int i=0;i<m;i++){
                int[] uv = readArray(2,0,0);int u = uv[0];int v=uv[1];
                g[u].add(v);g[v].add(u);
            }
            //Stack<Integer> list = new Stack<>();
            boolean[] vis = new boolean[n+1];
            //  Stack<Integer> list = new Stack<>();
            int[] par= new int[n+1];
            boolean ans=false;
            int cycle=-1;
            int tem=-1;
            for(int i=1;i<=n;i++){
                if(ans==true){
                    break;
                }
                if(vis[i]==false){
                    Stack<Integer> list = new Stack<>();
                    //  Queue<Integer> elem = new LinkedList<>();
                    list.add(i);
                    par[i]=-1;
                    while (list.isEmpty()==false){

                        int x = list.pop();
                        //     System.out.println(x);
                        vis[x]=true;
                        for(int c: g[x]){
                            //    System.out.println("chi "+c);
                            if(vis[c]==false){
                                par[c]=x;
                                list.add(c);
                            }
                            else if(vis[c]==true && c!=par[x]){
                                // par[c]=x;
                                cycle=x;
                                tem=c;
                                ans=true;
                                break;
                            }
                        }
                        if(ans==true){
                            break;
                        }
                    }

                }
            }
            if(ans==false){
                System.out.println("IMPOSSIBLE");
                continue;
            }
            StringBuilder ob =  new StringBuilder();
            int z = cycle;
            //System.out.println(cycle+" "+par[cycle]);
            int cnt =0;
            while (cycle!=tem){
                cnt+=1;
                ob.append(cycle+" ");
                cycle= par[cycle];

            }
            System.out.println(cnt+2);
            System.out.println(ob.toString().trim()+" "+tem+" "+z);

        }
    }


    private static int dfs(TreeMap<Integer, HashSet<Integer>> graph, boolean[] vis, Integer key, Stack<Integer> st) {
        if (st.size() == 0) {
            return 0;
        }
        int par = st.pop();

        HashSet<Integer> child = graph.get(par);
        vis[par] = true;
        int nodes = 1;
        for (int c : child) {
            if (vis[c] == false) {
                st.add(c);
                nodes += dfs(graph, vis, c, st);
            }
        }
        return nodes;
    }


    public static boolean isSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }


    private static long gcd(long a, long b) {
        if (a == 0)
            return b;
        if (b == 0)
            return a;

        // base case
        if (a == b)
            return a;

        // a is greater
        if (a > b)
            return gcd(a % b, b);
        return gcd(a, b % a);
    }


    public static long min(long a, long b) {
        return Math.min(a, b);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }


    public static void sieve() {
        int[] pf = new int[100000000 + 1];
        //0 prime //1 not prime
        pf[0] = 1;
        pf[1] = 1;
        for (int j = 2; j <= 10000; j++) {

            if (pf[j] == 0) {
                p.add(j);
                for (int k = j * j; k < pf.length; k += j) {
                    pf[k] = 1;
                }
            }
        }

    }


    public static int[] readArray(int n, int x, int z) throws Exception {
        int[] arr = new int[n];
        String[] ar = cinA();
        for (int i = x; i < n + x; i++) {
            arr[i] = getI(ar[i - x]);
        }
        return arr;
    }

    public static long[] readArray(int n, int x) throws Exception {
        long[] arr = new long[n];
        String[] ar = cinA();
        for (int i = x; i < n + x; i++) {
            arr[i] = getL(ar[i - x]);
        }
        return arr;
    }

    public static void arrinit(String[] a, long[] b) throws Exception {
        for (int i = 0; i < a.length; i++) {
            b[i] = Long.parseLong(a[i]);
        }
    }

    public static HashSet<Integer>[] Graph(int n, int edge, int directed) throws Exception {
        HashSet<Integer>[] tree = new HashSet[n];

        for (int j = 0; j < edge; j++) {

            String[] uv = cinA();
            int u = getI(uv[0]);
            int v = getI(uv[1]);
            if (directed == 0) {

                tree[v].add(u);
            }
            tree[u].add(v);
        }
        return tree;
    }

    public static void arrinit(String[] a, int[] b) throws Exception {
        for (int i = 0; i < a.length; i++) {
            b[i] = Integer.parseInt(a[i]);
        }
    }


    static double findRoots(int a, int b, int c) {
        // If a is 0, then equation is not
        //quadratic, but linear


        int d = b * b - 4 * a * c;
        double sqrt_val = Math.sqrt(Math.abs(d));


        // System.out.println("Roots are real and different \n");

        return Math.max((double) (-b + sqrt_val) / (2 * a),
                (double) (-b - sqrt_val) / (2 * a));


    }

    public static String cin() throws Exception {
        return br.readLine();
    }

    public static String[] cinA() throws Exception {
        return br.readLine().split(" ");
    }

    public static String[] cinA(int x) throws Exception {
        return br.readLine().split("");
    }

    public static String ToString(Long x) {
        return Long.toBinaryString(x);
    }

    public static void cout(String s) {
        System.out.println(s);
    }

    public static Integer cinI() throws Exception {
        return Integer.parseInt(br.readLine());
    }

    public static int getI(String s) throws Exception {
        return Integer.parseInt(s);
    }

    public static long getL(String s) throws Exception {
        return Long.parseLong(s);
    }

    public static long max(long a, long b) {
        return Math.max(a, b);
    }

    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static void coutI(int x) {
        System.out.println(String.valueOf(x));
    }

    public static void coutI(long x) {
        System.out.println(String.valueOf(x));
    }

    public static Long cinL() throws Exception {
        return Long.parseLong(br.readLine());
    }

    public static void arrInit(String[] arr, int[] arr1) throws Exception {
        for (int i = 0; i < arr.length; i++) {
            arr1[i] = getI(arr[i]);
        }

    }
}