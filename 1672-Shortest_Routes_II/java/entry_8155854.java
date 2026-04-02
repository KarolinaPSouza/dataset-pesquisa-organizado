import java.io.*;
import java.util.*;

public class entry_8155854 {
    // static int mod = (int) 998244353;
    static int mod = (int) 1e9+7;
    static int rr[] = new int[]{1,0,-1,0};
    static int cc[] = new int[]{0,1,0,-1};

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
        int q = io.nextInt();
        long mat[][] = new long[n+1][n+1];
        for(long i[] : mat){
            Arrays.fill(i,(long)1e14);
        }
        for(int i = 0 ; i < m ; i++){
            int fr = io.nextInt();
            int to = io.nextInt();
            int ct = io.nextInt();
            mat[fr][to] = Math.min(mat[fr][to] , ct);
            mat[to][fr] = Math.min(mat[to][fr] , ct);
        }
        for(int i = 0 ; i <= n ; i++)mat[i][i] = 0;
        for(int v = 1 ; v <= n ; v++){
            for(int f = 1 ; f <=n ; f++){
                if(f==v)continue;
                for(int t = f+1 ; t <=n ; t++){
                    if(f==t||v==t)continue;
                    mat[f][t] = Math.min(mat[f][t] , mat[f][v]+mat[v][t]);
                    mat[t][f] = Math.min(mat[t][f] , mat[t][v]+mat[v][f]);
                }
            }
        }
        for(int i = 0 ; i < q ; i++){
            long cst = mat[io.nextInt()][io.nextInt()];
            if(cst==(long)1e14)io.println(-1);
            else io.println(cst);
        }
    }

    private static void bfs(ArrayList<int[]> al, int vis[][] , String s[]){
        int n = s.length;
        int m = s[0].length();
        Queue<int[]> qu = new LinkedList<>();
        for(int i[] : al){
            qu.add(i);
            vis[i[0]][i[1]] = 0;
        }
        int t = 1;
        while(!qu.isEmpty()){
            int si = qu.size();
            while(si-->0){
                int cur[] = qu.remove();
                for(int d = 0 ; d < 4 ; d++){
                    int nr = rr[d]+cur[0];
                    int nc = cc[d]+cur[1];
                    if(nr>=0&&nr<n&&nc>=0&&nc<m&&vis[nr][nc]>t&&s[nr].charAt(nc)=='.'){
                        vis[nr][nc] = t;
                        qu.add(new int[]{nr,nc});
                    }
                }
            }
            t++;
        }
    }
}

class DisjointSet{
    int size[];
    int pare[];
    int edge[];
    DisjointSet(int n){
        this.size = new int[n+1];
        this.pare = new int[n+1];
        this.edge = new int[n+1];
        for(int i = 0 ; i < n+1 ; i++)
            pare[i]=i;
        Arrays.fill(size,1);
    }

    int getparent(int n){
        if(pare[n]==n)return n;
        return pare[n]=getparent(pare[n]);
    }

    boolean insert(int i , int j){
        int pai = getparent(i);
        int paj = getparent(j);
        if(pai==paj){
            edge[pai]++;
            return false;
        }

        if(size[pai]>size[paj]){
            pare[paj] = pai;
            size[pai]+=size[paj];
            edge[pai]+=edge[paj];
            edge[pai]++;
        }else{
            pare[pai] = paj;
            size[paj]+=size[pai];
            edge[paj]+=edge[pai];
            edge[paj]++;
        }
        return true;
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

    static void printf(String format, Object... args) {
        pw.printf(format, args);
    }

    static void close() {
        pw.close();
    }
}