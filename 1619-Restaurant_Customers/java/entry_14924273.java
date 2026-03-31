import java.io.*; 
import java.util.*;
import java.util.Map.Entry;
public class entry_14924273 {
    static final FastScanner sc = new FastScanner();
    static PrintWriter out=new PrintWriter(System.out);
    static long MOD = (long)(1e9+7);

    public static void main(String[] args) throws Exception {
        int t = 1;
        // t = sc.nextInt();
        while (t-- > 0) {
            solve();
        }
        out.flush();
    }

    public static void solve() {
        int n=sc.nextInt();
        int a[][]=new int[n][2];
        for(int i=0;i<n;i++) {
            a[i][0]=sc.nextInt();
            a[i][1]=sc.nextInt();
        }
        Arrays.sort(a, (x,y) -> (x[0]-y[0]));
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        // int ans=0,c=0;
        int ans=0;
        // TreeMap<Integer,Integer> tm=new TreeMap<>();
        for(int i=0;i<n;i++) {
            int s=a[i][0],e=a[i][1];
            while (!pq.isEmpty() && pq.peek() < s) {
                pq.poll();
            }
            // tm.put(e,tm.getOrDefault(e, 0)+1);
            pq.add(e);
            ans=Math.max(ans,pq.size());
        }
        out.println(ans);
    }

    static class FastScanner {
        private final InputStream is = System.in;
        private final byte[] buf = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private int read() {
            if (ptr >= len) try { len = is.read(buf); ptr = 0; } catch (IOException e) { return -1; }
            return (len == -1) ? -1 : buf[ptr++];
        }
        private int skip() {
            int c; while ((c = read()) <= ' ' && c != -1); return c;
        }
        String next() {
            int c = skip(); if (c == -1) return null;
            StringBuilder sb = new StringBuilder();
            while (c > ' ') { sb.append((char) c); c = read(); if (c == -1) break; }
            return sb.toString();
        }
        int nextInt() {
            int c = skip(), s = 1, x = 0; if (c == '-') { s = -1; c = read(); }
            while (c > ' ') { x = x * 10 + c - '0'; c = read(); }
            return x * s;
        }
        long nextLong() {
            int c = skip(), s = 1; long x = 0; if (c == '-') { s = -1; c = read(); }
            while (c > ' ') { x = x * 10 + c - '0'; c = read(); }
            return x * s;
        }
        int[] nextIntArr(int n) {
            int arr[] = new int[n];
            for(int i=0;i<n;i++)    arr[i]=nextInt();
            return arr;
        }
        long[] nextLongArr(int n) {
            long arr[] = new long[n];
            for(int i=0;i<n;i++)    arr[i]=nextLong();
            return arr;
        }
    }
}


class Sort {
    private Sort() {}

    // sort(int[]): sorts primitives quickly
    // ex: [5,-2,3] -> [-2,3,5]
    public static void sort(int[] a){
        if(a==null||a.length<2)return;
        if(a.length<200){Arrays.sort(a);return;}
        int mn=a[0],mx=a[0];for(int v:a){if(v<mn)mn=v;if(v>mx)mx=v;}
        long range=(long)mx-mn;
        if(mn>=0&&range<=2_000_000L)countingSortNonNeg(a,mx);
        else radixSort32(a);
    }
    public static void sort(long[] a){
        if(a==null||a.length<2)return;
        if(a.length<200){Arrays.sort(a);return;}
        radixSort64(a);
    }
    public static void sort(ArrayList<Integer> list){
        int n=list.size();if(n<2)return;
        int[] a=new int[n];for(int i=0;i<n;i++)a[i]=list.get(i);
        sort(a);for(int i=0;i<n;i++)list.set(i,a[i]);
    }
    public static void sortLongList(ArrayList<Long> list){
        int n=list.size();if(n<2)return;
        long[] a=new long[n];for(int i=0;i<n;i++)a[i]=list.get(i);
        sort(a);for(int i=0;i<n;i++)list.set(i,a[i]);
    }

    // sortWithComparatorByIndex(T[], cmp): sorts objects by comparator
    // ex: ["b","a"] -> ["a","b"]
    public static <T> void sortWithComparatorByIndex(T[] arr,Comparator<? super T>cmp){
        int n=arr.length;if(n<2)return;
        Integer[]idx=new Integer[n];for(int i=0;i<n;i++)idx[i]=i;
        Arrays.sort(idx,(i,j)->cmp.compare(arr[i],arr[j]));
        applyIndexPermutation(arr,idx);
    }
    @SuppressWarnings("unchecked")
    public static <T> void sortListWithComparatorByIndex(List<T>list,Comparator<? super T>cmp){
        int n=list.size();if(n<2)return;
        Object[]a=list.toArray();Integer[]idx=new Integer[n];
        for(int i=0;i<n;i++)idx[i]=i;
        Arrays.sort(idx,(i,j)->cmp.compare((T)a[i],(T)a[j]));
        Object[]tmp=new Object[n];for(int i=0;i<n;i++)tmp[i]=a[idx[i]];
        list.clear();for(Object o:tmp)list.add((T)o);
    }

    // indexPermutation(T[], cmp): returns sorted index order
    // ex: ["b","a"] -> [1,0]
    public static <T> Integer[] indexPermutation(T[] arr,Comparator<? super T>cmp){
        int n=arr.length;Integer[]idx=new Integer[n];for(int i=0;i<n;i++)idx[i]=i;
        Arrays.sort(idx,(i,j)->cmp.compare(arr[i],arr[j]));return idx;
    }

    // ------------------------------------------------------------------------------------------------------------
    private static void applyIndexPermutation(Object[]a,Integer[]idx){
        int n=a.length;Object[]tmp=new Object[n];
        for(int i=0;i<n;i++)tmp[i]=a[idx[i]];
        System.arraycopy(tmp,0,a,0,n);
    }

    private static void countingSortNonNeg(int[]a,int max){
        int[]c=new int[max+1];for(int v:a)c[v]++;
        int id=0;for(int v=0;v<=max;v++){int k=c[v];while(k-->0)a[id++]=v;}
    }

    private static void radixSort32(int[]a){
        int n=a.length;int[]t=new int[n];final int B=16,M=0xFFFF;int[]c=new int[1<<B];
        Arrays.fill(c,0);for(int v:a)c[v&M]++;for(int i=1;i<c.length;i++)c[i]+=c[i-1];
        for(int i=n-1;i>=0;i--)t[--c[a[i]&M]]=a[i];
        Arrays.fill(c,0);for(int v:t)c[((v>>>B)^0x8000)&M]++;for(int i=1;i<c.length;i++)c[i]+=c[i-1];
        for(int i=n-1;i>=0;i--)a[--c[((t[i]>>>B)^0x8000)&M]]=t[i];
    }

    private static void radixSort64(long[]a){
        int n=a.length;long[]k=new long[n],t=new long[n];
        for(int i=0;i<n;i++)k[i]=a[i]^Long.MIN_VALUE;
        final int B=16,M=0xFFFF;int[]c=new int[1<<B];
        for(int p=0,s=0;p<4;p++,s+=B){
            Arrays.fill(c,0);
            for(int i=0;i<n;i++)c[(int)((k[i]>>>s)&M)]++;
            for(int i=1;i<c.length;i++)c[i]+=c[i-1];
            for(int i=n-1;i>=0;i--)t[--c[(int)((k[i]>>>s)&M)]]=k[i];
            System.arraycopy(t,0,k,0,n);
        }
        for(int i=0;i<n;i++)a[i]=k[i]^Long.MIN_VALUE;
    }
}