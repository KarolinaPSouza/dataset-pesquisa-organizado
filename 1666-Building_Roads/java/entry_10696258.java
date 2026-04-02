
/**
* @author E-Sir
*
*/

import java.io.*;
import java.util.*;
import java.lang.*;
import java.math.*;

public class entry_10696258 {
    static final int MOD = 1_000_000_007;
    static final int INF =Integer.MAX_VALUE;
    static final int NINF = Integer.MIN_VALUE;
    static int[] parent;
    static int[] size;
    static int[][] ex;

    static int readInt(String s){return Integer.parseInt(s);}
    static long readLong(String s){return Long.parseLong(s);}
    static int[] readIntArr(String s){
        String[] tk = s.split(" ");
        int n = tk.length;
        int[] res = new int[n];
        for(int i =0;i<n;i++)
            res[i] = readInt(tk[i]);
        return res;
    }
    static long[] readLongArr(String s){
        String[] tk = s.split(" ");
        int n = tk.length;
        long[] res = new long[n];
        for(int i =0;i<n;i++){
            res[i] = Long.parseLong(tk[i]);
        }
        return res;
    }

    static <T extends Comparable<T>> T max(T a, T b){
        return a.compareTo(b) > 0 ? a : b;
    }

    static <T extends Comparable<T>> T min(T a, T b){
        return a.compareTo(b) < 0 ? a : b;
    }
    static int abs(int a, int b){return Math.abs(a-b);}
    static long abs(long a, long b){return Math.abs(a-b);}
    static class Pair<E,T>{
        E val1;
        T val2;
        public Pair(E val1, T val2){
            this.val1 = val1;
            this.val2 = val2;
        }
    }
    static int find(int a){
        if(parent[a] == a)
            return a;
        return parent[a] = find(parent[a]);
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a != b){
            if(size[a] < size[b]){
                parent[a] = b;
                size[b] += size[a];

                if(ex[a][0] != ex[b][0] && ex[a][1] != ex[b][1] && ex[a][0] != INF && ex[a][1] !=NINF){
                    ex[b][0] = min(ex[b][0],ex[a][0]);

                    ex[b][1] = max(ex[b][1], ex[a][1]);
                }
                else{
                    ex[b][0] = min(a, b);
                    ex[b][1] = max(a, b);
                }

            }
            else{
                parent[b]=a;
                size[a] += size[b];


                if(ex[a][0] != ex[b][0] && ex[a][1] != ex[b][1] && ex[a][0] != INF && ex[a][1] !=NINF){
                    ex[a][0] = min(ex[b][0],ex[a][0]);

                    ex[a][1] = max(ex[b][1], ex[a][1]);
                }
                else{
                    ex[a][0] = min(a, b);
                    ex[a][1] = max(a, b);
                }





            }
        }
    }

    public static void solve() throws IOException{
        PrintWriter pw = new PrintWriter(System.out);
        StringBuilder st = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = readIntArr(br.readLine());

        int n = nm[0], m = nm[1];
        parent = new int[n];
        size = new int[n];
        ex = new int[n][2];
        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i]=i;
            ex[i][0]=Integer.MAX_VALUE;
            ex[i][1]=Integer.MIN_VALUE;
        }
        for(int i =0;i<m;i++){
            int[] ab = readIntArr(br.readLine());
            int a = ab[0], b = ab[1];
            a--;
            b--;
            union(a, b);
        }
        TreeSet<Integer> set = new TreeSet<>();
        for(int i =0;i<n;i++){
            set.add(find(i));
        }
        int cnt = set.size();
        st.append(--cnt).append('\n');
        Iterator<Integer> iter = set.iterator();
        int fi = iter.next();
        fi++;
        //int p = ex[fi][1];
        while(iter.hasNext()){
            int curr = iter.next();
            curr++;
            //int temp = ex[curr][0];
            st.append(fi).append(" ").append(curr).append('\n');
            fi =curr; 
            //pw.println(curr+"----");

        }




        pw.println(st);
        pw.flush();
        pw.close();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}