import java.io.*;
import java.util.*;

public class entry_8162142 {
    // static int mod = (int) 998244353;
    static int mod = (int) 1e9+7;
    public static void main(String[] args) {
        int t = 1;
        while (t-- > 0) {
            start();
        }
        io.close();
    }

    private static void start() {
        int n = io.nextInt();
        int m = io.nextInt();
        ArrayList<int[]> al = new ArrayList<>(m);
        for(int i = 0 ; i < m ; i++)al.add(new int[]{io.nextInt(),io.nextInt(),io.nextInt()});
        long cst[] = new long[n+1];
        int par[] = new int[n+1];
        boolean fault[] = new boolean[n+1];
        Arrays.fill(cst,(int)1e15);
        cst[1] = 0;
        Arrays.fill(par,-1);
        boolean cycle = Graph.bellmanFord(al, n, m, cst, par,fault);
        if(!cycle){
            io.println("NO");
        }else{
            io.println("YES");
            int vis[] = new int[n+1];
            for(int i = 1 ; i <= n ; i++){
                if(fault[i]){
                    ArrayList<Integer> ans = new ArrayList<>();
                    int c = i;
                    while(vis[c]!=1){
                        ans.add(c);
                        vis[c] = 1;
                        c = par[c];
                    }
                    ans.add(c);
                    Collections.reverse(ans);
                    io.spreadList(ans);
                    return;
                }
            }
        }
    }
}

class Graph {
    public static ArrayList<HashMap<Integer,Integer>> getAdj(ArrayList<int[]> edges , int n , int m){
        ArrayList<HashMap<Integer,Integer>> al = new ArrayList<>();
        for(int i = 0 ;  i <= n ; i++)al.add(new HashMap<>());
        for(int i = 0 ; i  < m ; i++){
            int fr = edges.get(i)[0];
            int to = edges.get(i)[1];
            int cs = edges.get(i)[2];
            al.get(fr).merge(to,cs,Integer::min);
        }
        return al;
    }

    public static boolean bellmanFord(ArrayList<int[]> edges , int n , int m , long cst[] , int par[] , boolean fault[]){
        for(int t = 0 ; t < n-1 ; t++){
            for(int i = 0 ; i < m ; i++){
                int fr = edges.get(i)[0];
                int to = edges.get(i)[1];
                int cs = edges.get(i)[2];
                if(cst[to] > cst[fr]+cs){
                    cst[to] = cst[fr]+cs;
                    par[to] = fr;
                }
            }
        }
        long temp[] = cst.clone();
        for(int i = 0 ; i < m ; i++){
            int fr = edges.get(i)[0];
            int to = edges.get(i)[1];
            int cs = edges.get(i)[2];
            if(cst[to] > cst[fr]+cs){
                cst[to] = cst[fr]+cs;
                par[to] = fr;
            }
        }
        boolean ans = false;
        for(int i = 1 ; i <= n ; i++){
            if(cst[i] != temp[i]){
                fault[i] = true;
                ans = true;
            }
        }
        return ans;
    }
}

class io {
    static PrintWriter pw;
    static BufferedReader br;
    static StringTokenizer st;

    static {
        File file = new File("output.txt");
        if (file.exists()) {
            try {
                pw = new PrintWriter(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            pw = new PrintWriter(System.out);
        }
    }


    static {
        File file = new File("input.txt");
        if (file.exists()) {
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } 
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
    }

    static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    static int nextInt() {
        return Integer.parseInt(next());
    }

    static long nextLong() {
        return Long.parseLong(next());
    }

    static double nextDouble() {
        return Double.parseDouble(next());
    }

    static String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    static void spreadArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i] + " ");
        }
        pw.println();
    }

    static void spreadArray(long[] arr) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i] + " ");
        }
        pw.println();
    }

    static void spreadArray(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            print(arr[i] + " ");
        }
        pw.println();
    }

    static void spreadList(List<?> list) {
        for (int i = 0; i < list.size(); i++) {
            print(list.get(i) + " ");
        }
        pw.println();
    }

    static void println(Object o) {
        pw.println(o);
    }

    static void print(Object o) {
        pw.print(o);
    }

    static void close() {
        pw.close();
    }
}