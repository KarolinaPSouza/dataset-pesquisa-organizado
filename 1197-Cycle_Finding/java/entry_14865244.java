/**
 * Author: Balu
 * Created: Thu Oct 09 20:04:14 IST 2025
**/

import java.util.*;
import java.io.*;

public class entry_14865244 {
    static long mod = (int) 1e9 + 7;

    public static long pow(long a, long b) {
        long re = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                re = (re * a) % mod;
            }
            a = (a * a) % mod;
            b >>= 1;
        }
        return re;
    }

    public static void revArr(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void sort(int[] a) {
        mergeSort(a, 0, a.length - 1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return;
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1, n2 = right - mid;
        int[] L = new int[n1], R = new int[n2];
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int i = 0; i < n2; i++)
            R[i] = arr[mid + 1 + i];
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j])
                arr[k++] = L[i++];
            else
                arr[k++] = R[j++];
        }
        while (i < n1)
            arr[k++] = L[i++];
        while (j < n2)
            arr[k++] = R[j++];
    }

    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int tt = 1;
        while (tt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int edges[][] = new int[m][3];

            ArrayList<Integer> list[] = new ArrayList[n];
            for(int i = 0;i < n;i++){
                list[i] = new ArrayList<>();
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                u--;
                v--;
                int wt = Integer.parseInt(st.nextToken());
                edges[i][0] = u;
                edges[i][1] = v;
                edges[i][2] = wt;
                list[u].add(i);

            }
            long dp[] = new long[n];
            // dp[0] = 0;
            Arrays.fill(dp,(long)1e15);
            dp[0] = 0;

            int par[] = new int[n];
            Arrays.fill(par,-1);

            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < m; j++) {
                    int u = edges[j][0];
                    int v = edges[j][1];
                    int wt = edges[j][2];
                    if ((dp[u] + wt < dp[v])) {
                        par[v] = u;
                        dp[v] = dp[u] + wt;
                    }
                }
            }

            // pw.println(Arrays.toString(dp));
            // ArrayDeque<Integer> q = new ArrayDeque<>();
            long re = dp[n - 1];
            int start = -1;
            for (int j = 0; j < m; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];
                if (dp[u] + wt < dp[v] ) {
                    par[v] = u;
                    dp[v] = dp[u] + wt;
                    // q.add(v);
                    start = v;

                }

            }


            if(start == -1){
                pw.println("NO");
                continue;
            }
            else {

                for(int i = 1;i <= n && start != -1;i++){
                    start = par[start];
                }
                pw.println("YES");
                int parents[] = new int[n];
                ArrayList<Integer> ans = new ArrayList<>();

                ans.add(start+1);
                start = par[start];
                // pw.println(start);
                // pw.println(Arrays.toString(par));
                while(start != ans.get(0)-1){
                    ans.add(start+1);
                    start = par[start];
                    // pw.println(start);
                }
                ans.add(start+1);


                Collections.reverse(ans);
                for(int i : ans){
                    pw.print(i +  " " );
                }

                pw.println();

            }
        }
        pw.flush();
    }

    static int cs = -1;
    static int ce = -1;
    public static boolean dfs(int curr,ArrayList<Integer> list[],int edges[][],boolean vis[],int par,int parents[]){

        vis[curr] = true;

        for(int j : list[curr]){
            int e = edges[j][0]^edges[j][1] ^ curr;
            if (e == par)continue;
            if(!vis[e]){
                parents[e] = curr;
                if(dfs(e, list, edges, vis, curr,parents))return true;
            }
            else {
                cs = e;
                ce = curr;
                return true;
            }
        }
        return false;
    }
}