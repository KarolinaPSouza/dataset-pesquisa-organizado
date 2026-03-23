import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class entry_7727689 {
    public static void main(String[] args) {
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));
        FastReader in = new FastReader();
        int t = 1;
        while(t-- > 0){
            int n = in.nextInt();
            for (int i = 0; i < n; i++) {
                long x = in.nextLong();
                long y = in.nextLong();
                long curr = Math.max(x, y);
                if(curr == x){
                    if((curr & 1) == 1){
                        pw.println(((x - 1) * (x - 1)) + y);
                    }else{
                        pw.println((x * x) - y + 1);
                    }
                }else{
                    if((curr & 1) == 0){
                        pw.println(((y - 1) * (y - 1)) + x);
                    }else{
                        pw.println((y * y) - x + 1);
                    }
                }
            }
        }
 pw.close();
    }
    static class Pair implements Comparable<Pair>{
        long key;
        long value;
        Pair(long key, long value){
            this.key = key;
            this.value = value;
        }
        @Override
        public int compareTo(Pair that){
            return (int)this.value - (int)that.value;
        }
        @Override
        public String toString() {
            return key + " " + value;
        }
        public boolean isEqualTo(Pair other) {
            return this.key == other.key && this.value == other.value;
        }
    }
    public static int calcMex(List<Integer> list) {
        Set<Integer> set = new HashSet<>(list);
        for (int i = 0; i <= list.size(); i++) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return list.size();
    }
    public static class UnionFind {
        int[] p, rank, setSize;
        int numSets;

        public UnionFind(int N) {
            p = new int[numSets = N];
            rank = new int[N];
            setSize = new int[N];
            for (int i = 0; i < N; i++) {
                p[i] = i;
                setSize[i] = 1;
            }
        }

        public int findSet(int i) {
            return p[i] == i ? i : (p[i] = findSet(p[i]));
        }

        public boolean isSameSet(int i, int j) {
            return findSet(i) == findSet(j);
        }

        public void unionSet(int i, int j) {
            if (isSameSet(i, j))
                return;
            numSets--;
            int x = findSet(i), y = findSet(j);
            if (rank[x] > rank[y]) {
                p[y] = x;
                setSize[x] += setSize[y];
            } else {
                p[x] = y;
                setSize[y] += setSize[x];
                if (rank[x] == rank[y]) rank[y]++;
            }
        }

        public int numDisjointSets() {
            return numSets;
        }

        public int sizeOfSet(int i) {
            return setSize[findSet(i)];
        }
    }
    static class Fenwick_Tree {
  int n;
  int[] tree;
  Fenwick_Tree(int N) {
   tree = new int[N+1];
   n = N;
  }
  void update(int idx, int val) {
   while(idx<=n) {
    tree[idx]+=val;
    idx+=(idx&-idx);
   }
  }
  int query(int idx) {
   int sum = 0;
   while(idx>0) {
    sum+=tree[idx];
    idx-=(idx&-idx);
   }
   return sum;
  }
 }
    public static int gcd(int a, int b){
        if(a == 0){
            return b;
        }
        return gcd(b % a, a);
    }
    public static int upper_bound(ArrayList<Long> obj, long k){
        int start = 0;
        int end = obj.size();
        while(start < end){
            int mid = start + (end - start) / 2;
            if(obj.get(mid) <= k){
                start = mid + 1;
            }else{
                end = mid;
            }
        }
        return start - 1;
    }
    public static long sqrt(long x){
        long i = 0;
        long j = Integer.MAX_VALUE;
        while(i < j){
            long mid = i + (j - i) / 2;
            if(mid * mid <= x){
                i = mid + 1;
            }else{
                j = mid;
            }
        }
        return i - 1;
    }
    static int lcm(int a, int b){
        return (a / gcd(a, b)) * b;
    }
    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}