import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
// class DisjointSet{
//     int[] parent ;
//     int[] size;

//     DisjointSet(int n ){
//         parent = new int[n+1];
//         size = new int[n+1];

//         for(int i =1; i<=n; i++) {
//             parent[i] = i;
//             size[i] = 1;
//         }
//     }

//     public int findUlimateParent(int node){
//         if(node  == parent[node]){
//             return node;
//         }
//         return parent[node] =findUlimateParent(parent[node]);
//     }

//     public void unionBySize(int u , int v){
//         int ulp_u = findUlimateParent(u);
//         int ulp_v = findUlimateParent(v);

//         if(ulp_u == ulp_v) return ;
//         if(size[ulp_u] < size[ulp_v]){
//             parent[ulp_u] = ulp_v;
//             size[ulp_v] += size[ulp_u];
//         }
//         else{
//             parent[ulp_v] = ulp_u;
//             size[ulp_u] += size[ulp_v];
//         }
//     }
// }
 public class entry_12631520 {


    static long lcm(int a, int b) { return (a / gcd(a, b)) * b;} 
    private static long gcd(long a, long b) { 
        if (b == 0) {  return a; } return gcd(b, a % b); 
    }

    private static void out(long[] arr){
        for(var i: arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static boolean factors(long n){
        for(int i = 2; i<=Math.sqrt(n); i++){
            if(n%i == 0){
                if(i%2 == 1) return true; 
                if(i != n/i && (n/i)%2 == 1) return true; 
            }
        }
        if(n>1 && n%2 == 1) return true;
        return false;

    }

    public static void p(String s){System.out.println(s);}
    public static void pl(long n) {System.out.println(n);}

    static long[] readArr(int n){
        long[] arr = new long[n];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextLong();
        }
        return arr;
    }

    static long mini(long[] arr){
        var mn = Long.MAX_VALUE;
        for(var num : arr) mn = Math.min(mn,num);
        return mn;
    }
    static long secondMini(long[] arr){
        int len  = arr.length;
        long fmn = Long.MAX_VALUE , smn = Long.MAX_VALUE;
        for(int j = 0; j<len; j++){
            long num = arr[j];
            if (num < fmn) {
                smn = fmn;  
                fmn = num;        
            } else if (num < smn) {
                smn = num;       
            }
        }
        return smn;
    }

    public static void main(String[] args) throws IOException{
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] parent = new int[n + 1];
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        parent[1] = -1;

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int nei : adj.get(node)) {
                if (dist[nei] == Integer.MAX_VALUE) {
                    dist[nei] = dist[node] + 1;
                    parent[nei] = node;
                    q.add(nei);
                }
            }
        }

        // Fast output
        StringBuilder sb = new StringBuilder();
        if (dist[n] == Integer.MAX_VALUE) {
            sb.append("IMPOSSIBLE\n");
        } else {
            List<Integer> path = new ArrayList<>();
            for (int cur = n; cur != -1; cur = parent[cur]) {
                path.add(cur);
            }
            Collections.reverse(path);
            sb.append(path.size()).append("\n");
            for (int node : path) {
                sb.append(node).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    } 

}

