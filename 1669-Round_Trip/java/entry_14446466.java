// Author:- keshav_.agg
import java.io.*;
import java.util.*;

public class entry_14446466 {
    private static final int mod = 1000000007;

    // Custom class to hold pairs
    static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static class Triplet {
        int first;
        int second;
        int third;

        Triplet(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }

    // Euclidean algorithm for finding GCD for int type
    public static int gcdInt(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Euclidean algorithm for finding GCD for long type
    public static long gcdLong(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // Binary exponentiation for int type
    public static int power_Int(int base, int exponent) {
        int result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }

    // Binary exponentiation for long type
    public static long power_Long(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result *= base;
            }
            base *= base;
            exponent >>= 1;
        }
        return result;
    }

    // Modular exponentiation for int type with MOD = 1e9 + 7
    public static int power_modInt(int base, int exponent) {
        int result = 1;
        base %= mod;
        while (exponent > 0) {
            if ((exponent & 1) == 1) {
                result = (int) ((result * (long) base) % mod);
            }
            base = (int) ((base * (long) base) % mod);
            exponent >>= 1;
        }
        return result;
    }

    // greater than or equal to key
    public static long long_lowerBound(long[] arr, long key) {
        long low = 0, high = arr.length - 1;
        long ans = arr.length;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (arr[(int) mid] >= key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // greater than or equal to key
    public static long long_upperBound(long[] arr, long key) {
        long low = 0, high = arr.length - 1;
        long ans = arr.length;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (arr[(int) mid] > key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // greater than equal to key
    public static int int_lowerBound(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] >= key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    // greater than key
    public static int int_upperBound(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] > key) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static int modInverse(int a) {
        return power_modInt(a, mod - 2);
    }

    public static int nCr(int n, int r, int[] fact) {
        if (r > n)
            return 0;
        return (int) ((fact[n] * (long) modInverse((int) ((fact[r] * (long) fact[n - r]) % mod))) % mod);
    }

    public static void sortTwoArrays(int[] array1, int[] array2) {
        int n = array1.length;
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(array1[i], array2[i]);
        }
        Arrays.sort(pairs, (a, b) -> {
            if (a.first != b.first) {
                return Integer.compare(a.first, b.first);
            } else {
                return Integer.compare(a.second, b.second);
            }
        });
        for (int i = 0; i < n; i++) {
            array1[i] = pairs[i].first;
            array2[i] = pairs[i].second;
        }
    }

    // No. of one in binary representation of Integer
    public static int int_oneCount(int n) {
        return Integer.bitCount(n);
    }

    // No. of one in binary representation of Long
    public static int long_oneCount(long n) {
        return Long.bitCount(n);
    }

    // No. of zero in binary representation of Integer
    public static int int_zeroCount(int n) {
        return Integer.toBinaryString(n).length() - Integer.bitCount(n);
    }

    // No. of zero in binary representation of Long
    public static int long_zeroCount(long n) {
        return Long.toBinaryString(n).length() - Long.bitCount(n);
    }

    // change this for different differnt queries
    public static int mergeSeg(int l, int r) {
        return l + r;
    }

    // Build segment tree
    public static void buildSeg(int[] a, int[] seg, int s, int e, int i) {
        if (e == s) {
            seg[i] = a[e];
            return;
        }
        int m = s + (e - s) / 2;
        buildSeg(a, seg, s, m, 2 * i);
        buildSeg(a, seg, m + 1, e, 2 * i + 1);
        seg[i] = mergeSeg(seg[2 * i], seg[2 * i + 1]);
        return;
    }

    // Update segment tree and change in if(s==e) for update query
    public static void updateSeg(int[] a, int[] seg, int s, int e, int i, int pos, int val) {
        if (s == e) {
            if (e == pos) {
                a[pos] = val;
                seg[i] = a[pos];
            }
            return;
        }
        int m = s + (e - s) / 2;
        if (pos <= m) {
            updateSeg(a, seg, s, m, 2 * i, pos, val);
        } else {
            updateSeg(a, seg, m + 1, e, 2 * i + 1, pos, val);
        }
        seg[i] = mergeSeg(seg[2 * i], seg[2 * i + 1]);
        return;
    }

    // Query segment tree and change in if(s>r || e<l) for differnt range query
    public static int querySeg(int[] a, int[] seg, int s, int e, int i, int l, int r) {
        if (l <= s && r >= e) {
            return seg[i];
        }
        if (s > r || e < l) {
            return 0;
        }
        int m = s + (e - s) / 2;
        int left = querySeg(a, seg, s, m, 2 * i, l, r);
        int right = querySeg(a, seg, m + 1, e, 2 * i + 1, l, r);
        return mergeSeg(left, right);
    }

    public static int findParDsu(int i, int[] par) {
        if (par[i] == i) {
            return i;
        }
        return par[i] = findParDsu(par[i], par);
    }

    public static void unionSize(int u, int v, int[] par, int[] size) {
        int pu = findParDsu(u, par);
        int pv = findParDsu(v, par);
        if (pu == pv)
            return;
        if (size[pu] >= size[pv]) {
            par[pv] = pu;
            size[pu] += size[pv];
        } else {
            par[pu] = pv;
            size[pv] += size[pu];
        }
    }

    public static void unionRank(int u, int v, int[] par, int[] rank) {
        int pu = findParDsu(u, par);
        int pv = findParDsu(v, par);
        if (pu == pv)
            return;
        if (rank[pu] == rank[pv]) {
            par[pv] = pu;
            rank[pu]++;
        } else if (rank[pu] > rank[pv]) {
            par[pv] = pu;
        } else {
            par[pu] = pv;
        }
    }

    public static int kruskal(List<Triplet> a, int[] par, int[] size) {
        a.sort((t1, t2) -> Integer.compare(t1.third, t2.third));
        int sum = 0;
        for (int i = 0; i < a.size(); i++) {
            int u = a.get(i).first;
            int v = a.get(i).second;
            if (findParDsu(u, par) != findParDsu(v, par)) {
                sum += a.get(i).third;
                System.out.println(u + " " + v);
                unionSize(u, v, par, size);
            }
        }
        return sum;
    }

    // solve

    public static void dfs(int i, List<Integer> a[], int par[], boolean vis[], Pair[] cy){
        vis[i]=true;
        if(cy[0].first!=-1){
            return;
        }
        for(int e : a[i]){
            if(cy[0].first!=-1){
                return;
            }
            if(vis[e] && par[i]!=e){
                cy[0]=new Pair(i, e);
                return;
            }else if(!vis[e]){
                par[e]=i;
                dfs(e,a,par,vis,cy);
            }
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int m = Integer.parseInt(nk[1]);

        @SuppressWarnings("unchecked")
        List<Integer>[] a = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            int u = Integer.parseInt(s[0]) - 1;
            int v = Integer.parseInt(s[1]) - 1;
            a[u].add(v);
            a[v].add(u);
        }
        int par[] = new int[n];
        Arrays.fill(par, -1);
        boolean vis[] = new boolean[n];
        Pair cy[] = new Pair[1];
        cy[0]=new Pair(-1, -1);
        Arrays.fill(args, a);
        for(int i = 0; i<n; i++){
            if(cy[0].first!=-1){
                break;
            }
            if(!vis[i]){
                dfs(i,a,par,vis,cy);
            }
        }
        if(cy[0].first==-1){
            out.println("IMPOSSIBLE");
        }else{
            List<Integer> l = new ArrayList<>();
            l.add(cy[0].second+1);
            int i = cy[0].first;
            while(i!=cy[0].second){
                l.add(i+1);
                i = par[i];
            }
            l.add(cy[0].second+1);
            out.println(l.size());
            Collections.reverse(l);
            for(i = 0; i<l.size(); i++){
                out.print(l.get(i)+" ");
            }
        }
        out.flush();
        out.close();
        br.close();
    }
}