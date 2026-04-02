import java.util.*;
import java.lang.*;
import java.io.*;

public class entry_15831593 {
    static int[] solve(int n, int[] arr) {
            List<List<Integer>> adj = new ArrayList<>();
            for(int i = 0; i<=n; i++) adj.add(new ArrayList<>());
            int[] parent = new int[n+1];
            int[] out = new int[n+1];

            for(int i = 0; i<n-1; i++){
                adj.get(arr[i]).add(i+2);
                parent[i+2] = arr[i];
                out[arr[i]]+=1;
            }
            int[] ans = new int[n+1];
            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i<=n; i++){
                if(out[i] == 0) {
                    q.add(i);
                }
            }
            while(!q.isEmpty()){
                int num = q.remove();
                for(int x : adj.get(num)){
                    ans[num] += ans[x] +1;
                }
                if(parent[num] != 0) out[parent[num]] -= 1;
                if(parent[num] != 0 && out[parent[num]] == 0) q.add(parent[num]);
            }
            return ans;
        }
        public static void main (String[] args) throws java.lang.Exception
        {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n - 1];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n - 1; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] ans = solve(n, arr);

            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                sb.append(ans[i]).append(" ");
            }
            System.out.print(sb.toString());
        }
}

// import java.io.*;
// import java.util.*;

// public class entry_15831593 {

//     static int[] solve(int n, int[] arr) {
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i <= n; i++) adj.add(new ArrayList<>());

//         int[] parent = new int[n + 1];
//         int[] out = new int[n + 1];

//         for (int i = 0; i < n - 1; i++) {
//             adj.get(arr[i]).add(i + 2);
//             parent[i + 2] = arr[i];
//             out[arr[i]]++;
//         }

//         int[] ans = new int[n + 1];
//         Deque<Integer> q = new ArrayDeque<>();

//         for (int i = 1; i <= n; i++) {
//             if (out[i] == 0) q.add(i);
//         }

//         while (!q.isEmpty()) {
//             int num = q.poll();

//             for (int x : adj.get(num)) {
//                 ans[num] += ans[x] + 1;
//             }

//             int p = parent[num];
//             if (p != 0 && --out[p] == 0) {
//                 q.add(p);
//             }
//         }

//         return ans;
//     }

//     public static void main(String[] args) throws Exception {
//         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//         int n = Integer.parseInt(br.readLine());
//         int[] arr = new int[n - 1];

//         StringTokenizer st = new StringTokenizer(br.readLine());
//         for (int i = 0; i < n - 1; i++) {
//             arr[i] = Integer.parseInt(st.nextToken());
//         }

//         int[] ans = solve(n, arr);

//         StringBuilder sb = new StringBuilder();
//         for (int i = 1; i <= n; i++) {
//             sb.append(ans[i]).append(" ");
//         }
//         System.out.print(sb.toString());
//     }
// }