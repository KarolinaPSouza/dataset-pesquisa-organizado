import java.io.*;
import java.util.*;

public class entry_5775049 {
 private static final String name = "haybales";
 private static final int mod = 1_000_000_007, inf = Integer.MAX_VALUE;
 private static final int[][] d4 = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
 private static final long inf2 = Long.MAX_VALUE;
 private static PrintWriter out;
 private static FastIO sc;
 private static long time = -1;
 private static long[] fact;
 private static long mod1 = 4611686018427387847L, mod2 = 4611686018427387833L, mod3 = 4611686018427387813L;
 public static void main(String[] args) throws Exception {
  try {
   if(name.length() != 0 && new File(name+".in").exists()) {
    sc = new FastIO(name+".in");
    out = new PrintWriter(name+".out");
   }else if(new File("C:\\Users\\anaba\\eclipse-workspace\\test\\src\\main\\java\\input.in").exists()){
    sc = new FastIO("C:\\Users\\anaba\\eclipse-workspace\\test\\src\\main\\java\\input.in");
    if(args.length == 1 && args[0].equals("testingwithtestcases"))
     out = new PrintWriter("C:\\Users\\anaba\\eclipse-workspace\\test\\src\\main\\java\\input.out");
    else
     out = new PrintWriter(new BufferedOutputStream(System.out));
    time = System.currentTimeMillis();
   }else {
    sc = new FastIO(System.in);
    out = new PrintWriter(new BufferedOutputStream(System.out));
   }
  }catch(SecurityException e) {
   sc = new FastIO(System.in);
   out = new PrintWriter(new BufferedOutputStream(System.out));
  }
  //for(int T = sc.nextInt(); T>0; T--) 
   solve();
  if(time != -1) System.out.println("Time: "+(System.currentTimeMillis()-time)+"ms");
        out.close();
 }
 private static void solve() throws Exception {
  int N = sc.nextInt(), Q = sc.nextInt(), nums[] = sc.nextArr(N);
  LZST st = new LZST(N);
  for(int i = 0; i<N; i++) st.add(i, N-1, nums[i]);
  while(Q--> 0) if(sc.nextInt() == 1){
   int k = sc.nextInt()-1, x = sc.nextInt();
   st.add(k, N-1, x-nums[k]);
   nums[k] = x;
  }else {
   int a = sc.nextInt()-1, b = sc.nextInt()-1;
   out.println(max(st.max(a, b)-(a == 0 ? 0:st.get(a-1)), 0));
  }
 }
 private static class LZST {
  private class Node {
   public int l, r;
   public Node left, right;
   public long val = 0, max = 0, min = 0, add = 0;
   public boolean isSet = false;
   public Node(int a, int b) {
    l = a;
    r = b;
    if(l != r) {
     int mid = (l+r)>>1;
     left = new Node(l, mid);
     right = new Node(mid+1, r);
    }
   }
   public void set(long num) {
    isSet = true;
    add = max = min = num;
    val = num*(r-l+1);
   }
   public void add(long num) {
    add+=num;
    val+=num*(r-l+1);
    max+=num;
    min+=num;
   }
   public void prop() {
    if(isSet) {
     isSet = false;
     if(l != r) {
      left.set(add);
      right.set(add);
     }
    }else if(add != 0) {
     if(l != r) {
      left.add(add);
      right.add(add);
     }
    }
    add = 0;
   }
   public void upd() {
    val = left.val+right.val;
    min = Math.min(left.min, right.min);
    max = Math.max(left.max, right.max);
   }
  }
  Node top;
  public LZST(int N) {
   assert(N > 0);
   top = new Node(0, N-1);
  }
  private void set(int s, int e, long num, Node curr) {
   if(curr.l == s && curr.r == e) {
    curr.set(num);
    return;
   }
   curr.prop();
   if(e <= curr.left.r) set(s, e, num, curr.left);
   else if(s >= curr.right.l) set(s, e, num, curr.right);
   else{
    set(s, curr.left.r, num, curr.left);
    set(curr.right.l, e, num, curr.right);
   }
   curr.upd();
  }
  private void add(int s, int e, long num, Node curr) {
   if(curr.l == s && curr.r == e) {
    curr.add(num);
    return;
   }
   curr.prop();
   if(e <= curr.left.r) add(s, e, num, curr.left);
   else if(s >= curr.right.l) add(s, e, num, curr.right);
   else{
    add(s, curr.left.r, num, curr.left);
    add(curr.right.l, e, num, curr.right);
   }
   curr.upd();
  }
  private long sum(int s, int e, Node curr) {
   if(curr.l == s && curr.r == e) return curr.val;
   curr.prop();
   if(e <= curr.left.r) return sum(s, e, curr.left);
   if(s >= curr.right.l) return sum(s, e, curr.right);
   return sum(s, curr.left.r, curr.left)+sum(curr.right.l, e, curr.right);
  }
  private long max(int s, int e, Node curr) {
   if(curr.l == s && curr.r == e) return curr.max;
   curr.prop();
   if(e <= curr.left.r) return max(s, e, curr.left);
   if(s >= curr.right.l) return max(s, e, curr.right);
   return Math.max(max(s, curr.left.r, curr.left), max(curr.right.l, e, curr.right));
  }
  private long min(int s, int e, Node curr) {
   if(curr.l == s && curr.r == e) return curr.min;
   curr.prop();
   if(e <= curr.left.r) return min(s, e, curr.left);
   if(s >= curr.right.l) return min(s, e, curr.right);
   return Math.min(min(s, curr.left.r, curr.left), min(curr.right.l, e, curr.right));
  }
  public long get(int s) {
   assert(s >= top.l && s <= top.r);
   Node curr = top;
   LinkedList<Node> stk = new LinkedList<>();
   while(curr.l != curr.r) {
    stk.push(curr);
    curr.prop();
    if(s <= curr.left.r) curr = curr.left;
    else curr = curr.right;
   }
   while(!stk.isEmpty()) stk.pop().upd();
   return curr.val;
  }
  public long sum(int s, int e) {
   assert(s >= top.l && s <= top.r && e >= top.l && e <= top.r);
   return sum(s, e, top);
  }
  public long max(int s, int e) {
   assert(s >= top.l && s <= top.r && e >= top.l && e <= top.r);
   return max(s, e, top);
  }
  public long min(int s, int e) {
   assert(s >= top.l && s <= top.r && e >= top.l && e <= top.r);
   return min(s, e, top);
  }
  public void add(int s, int e, long num) {
   assert(s >= top.l && s <= top.r && e >= top.l && e <= top.r);
   add(s, e, num, top);
  }
  public void set(int s, int e, long num) {
   assert(s >= top.l && s <= top.r && e >= top.l && e <= top.r);
   set(s, e, num, top);
  }
  public void set(int s, long num) {
   assert(s >= top.l && s <= top.r);
   set(s, s, num);
  }
  @Override
  public String toString() {
   StringBuilder sb = new StringBuilder("[");
   for(int i = 0; i<=top.r; i++) sb.append(get(i)+(i == top.r ? "]":", "));
   return sb.toString();
  }
 }
    public static class AST {

  public interface Oper {
   long[] solve(long[] a, long[] b);
  }

  private class Node {
   public long[] val;
   public Node p, le, ri;
   public int l, r;

   public Node(int l, int r) {
    this.l = l;
    this.r = r;
   }
  }

  private final Oper oper;
  private final Node top;
  private final Node[] last;
  public AST(int n, Oper oper) {
   this.oper = oper;
   top = new Node(0, n - 1);
   last = new Node[n];
   getNode(top);
  }

  private void getNode(Node t) {
   if (t.l == t.r) {
    last[t.l] = t;
    return;
   }
   int mid = (t.l + t.r) >> 1;
   t.le = new Node(t.l, mid);
   t.ri = new Node(mid + 1, t.r);
   getNode(t.le);
   getNode(t.ri);
   t.le.p = t.ri.p = t;
  }

  public void set(int k, long[] num) {
   Node t = last[k];
   t.val = num;
   t = t.p;
   while (t != null) {
    if (t.le.val != null && t.ri.val != null)
     t.val = oper.solve(t.le.val, t.ri.val);
    t = t.p;
   }
  }

  public long[] all() {
   return top.val;
  }

  public long[] get(int a) {
   return last[a].val;
  }

  public long[] get(int a, int b) {
   if (a == b)
    return get(a);
   return get(a, b, top);
  }

  private long[] get(int a, int b, Node n) {
   if (a == n.l && b == n.r)
    return n.val;
   Node l = n.le, r = n.ri;
   if (l.l <= a && l.r >= b)
    return get(a, b, l);
   if (r.l <= a && r.r >= b)
    return get(a, b, r);
   long[] left = get(a, l.r, l), right = get(r.l, b, r);
   return oper.solve(left, right);
  }
 }
 private static long[] minPath(int x, List<int[]>[] g) {
  long[] l = new long[g.length];
  PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Long.compare(l[a], l[b]));
  Arrays.fill(l, Long.MAX_VALUE);
  l[x] = 0;
  pq.add(x);
  while (!pq.isEmpty()) {
   int c = pq.poll();
   for (int[] a : g[c])
    if (l[a[0]] > l[c] + a[1]) {
     l[a[0]] = l[c] + a[1];
     pq.add(a[0]);
    }
  }
  return l;
 }
 private static class RevBIT {
  private final long[] bit;
  private final long[] arr;
  private final int len;

  public RevBIT(int len) {
   bit = new long[len + 1];
   arr = new long[len];
   this.len = len;
  }

  public void set(int ind, long val) {
   add(ind, ind, val - get(ind));
  }

  public void add(int s, int e, long val) {
   add(s, val);
   if (e != len - 1)
    add(e + 1, -val);
  }

  private void add(int ind, long val) {
   arr[ind] += val;
   ind++;
   for (; ind <= len; ind += ind & -ind)
    bit[ind] += val;
  }

  public long prev(int ind) {
   return arr[ind];
  }

  public long get(int ind) {
   ind++;
   long sum = 0;
   for (; ind > 0; ind -= ind & -ind)
    sum += bit[ind];
   return sum;
  }

  @Override
  public String toString() {
   StringBuilder ret = new StringBuilder();
   ret.append("[");
   for (int i = 0; i < len; i++)
    ret.append(get(i) + (i == len - 1 ? "]" : ", "));
   return ret.toString();
  }
 }
 private static int lca(int a, int b, int[][] jp, int[] depth) {
  if(depth[a] > depth[b]) {
   int s = a;
   a = b;
   b = s;
  }
  int k = depth[b]-depth[a];
  for(int i = 0; i<19; i++) if((k&(1<<i)) != 0) b = jp[b][i];
  if(a == b) return a;
  for(int i = 18; i>=0; i--) if(jp[a][i] != jp[b][i]) {
   a = jp[a][i];
   b = jp[b][i];
  }
  return jp[a][0];
 }
 private static int[][] HLD(List<Integer>[] g){
  int N = g.length;
  int[] pos = new int[N], last = new int[N], cnt = new int[N];
  dfsCNTHLD(g, cnt, 0, -1);
  dfsHLD(g, pos, last, 0, 0, -1, cnt);
  return new int[][] {pos, last};
 }private static void dfsCNTHLD(List<Integer>[] g, int[] cnt, int s, int p) {
  cnt[s] = 1;
  for(int i: g[s]) if(i != p) {
   dfsCNTHLD(g, cnt, i, s);
   cnt[s]+=cnt[i];
  }
 }private static int dfsHLD(List<Integer>[] g, int[] pos, int[] last, int timer, int s, int p, int[] cnt) {
  pos[s] = timer++;
  int m = -1;
  for(int i: g[s]) if(i != p)
   if(m == -1 || cnt[i] > cnt[m]) m = i;
  if(m == -1) return timer;
  last[m] = last[s];
  timer = dfsHLD(g, pos, last, timer, m, s, cnt);
  for(int i: g[s]) if(i != p && i != m) {
   last[i] = i;
   timer = dfsHLD(g, pos, last, timer, i, s, cnt);
  }
  return timer;
 }
 private static List<List<Integer>> SCC(List<Integer>[] g) {
  int N = g.length;
  int[] disc = new int[N];
  int[] low = new int[N];
  Arrays.fill(disc, -1);
  Arrays.fill(low, -1);
  boolean stackMember[] = new boolean[N];
  LinkedList<Integer> st = new LinkedList<>();
  LinkedList<List<Integer>> ans = new LinkedList<>();
  ans.add(new LinkedList<>());
  for (int i = 0; i<N; i++)
   if (disc[i] == -1)
    SCCUtil(i, low, disc, stackMember, st, 0, g, ans);
  ans.pollLast();
  return ans;
 }private static int SCCUtil(int s, int[] low, int[] disc, boolean[] stackMember, LinkedList<Integer> st, int time, List<Integer>[] g, List<List<Integer>> ans) {
  disc[s] = time;
  low[s] = time;
  time++;
  stackMember[s] = true;
  st.push(s);
  for(int i: g[s]){
   if (disc[i] == -1) {
    time = SCCUtil(i, low, disc, stackMember, st, time, g, ans);
    low[s] = min(low[s], low[i]);
   } else if(stackMember[i] == true)
    low[s] = min(low[s], disc[i]);
  }
  int w = -1;
  if (low[s] == disc[s]) {
   while (w != s) {
    w = st.pop();
    ans.get(ans.size()-1).add(w);
    stackMember[w] = false;
   }
   ans.add(new LinkedList<>());
  }
  return time;
 }
 private static int[][] getDepth(List<Integer>[] g, int s) {
  int[][] ans = new int[2][g.length];
  getDepthDFS(g, s, -1, ans);
  return ans;
 }private static void getDepthDFS(List<Integer>[] g, int s, int p, int[][] d) {
  d[1][s] = p;
  for(int i: g[s]) if(i != p) {
   d[0][i] = d[0][s]+1;
   getDepthDFS(g, i, s, d);
  }
 }
 private static List<Integer>[][] treeComp(List<Integer>[] g){
  int N = g.length;
  if(N == 1) {
   List<Integer>[][] ans = new List[2][1];
   ans[0][0] = new LinkedList<>();
   ans[1][0] = new LinkedList<>();
   ans[1][0].add(0);
   return ans;
  }
  int[] map = new int[N];
  int K = treeCompGetCount(g, 0, -1, map, 0);
  List<Integer>[][] ans = new List[2][K];
  for(int i = 0; i<K; i++) {
   ans[0][i] = new LinkedList<>();
   ans[1][i] = new LinkedList<>();
  }
  treeCompDFS(g, map, ans, 0);
  return ans;
 }private static int treeCompGetCount(List<Integer>[] g, int s, int p, int[] map, int time) {
  g[s].remove((Integer)p);
  if(p == -1 || g[p].size() != 1) map[s] = time++; else map[s] = -1;
  for(int i: g[s]) if(i != p) time = treeCompGetCount(g, i, s, map, time);
  return time;
 }private static void treeCompDFS(List<Integer>[] g, int[] map, List<Integer>[][] ret, int s) {
  int curr = s;
  while(g[curr].size() == 1) {
   ret[1][map[s]].add(curr);
   curr = g[curr].get(0);
  }
  ret[1][map[s]].add(curr);
  for(int i: g[curr]) {
   ret[0][map[s]].add(map[i]);
   treeCompDFS(g, map, ret, i);
  }
 }
 private static boolean hasCycle(List<Integer>[] g) {
  byte[] vis = new byte[g.length];
  for(int i = 0; i<g.length; i++) if(vis[i] == 0 && hasCycleHelper(g, i, vis)) return true;
  return false;
 }private static boolean hasCycleHelper(List<Integer>[] g, int s, byte[] vis) {
  vis[s] = 1;
  for(int i: g[s]) if(vis[i] == 1) return true;
  else if(vis[i] == 0 && hasCycleHelper(g, i, vis)) return true;
  vis[s] = 2;
  return false;
 }
 private static class Cnt<T> {

  public TreeMap<T, Integer> map;
  boolean first = true;
  public Cnt() {}

  public int get(T num) {
   if(first) {
    if(num instanceof Long) map = new TreeMap<>((a, b) -> Long.compare((long)a, (long)b));
    else map = new TreeMap<>();
    first = false;
   }
   Integer get = map.get(num);
   if (get == null)
    return 0;
   return get;
  }

  public void add(T num) {
   add(num, 1);
  }

  public void rem(T num) {
   add(num, -1);
  }

  public void rem(T num, int cnt) {
   add(num, -cnt);
  }

  public void add(T num, int cnt) {
   if(first) {
    if(num instanceof Long) map = new TreeMap<>((a, b) -> Long.compare((long)a, (long)b));
    else map = new TreeMap<>();
    first = false;
   }
   Integer get = map.get(num);
   if (get == null)
    get = 0;
   get += cnt;
   if (get == 0)
    map.remove(num);
   else
    map.put(num, get);
  }
  public boolean isEmpty() {
   if(map == null) return true;
   return map.isEmpty();
  }
  public T min() {
   if(map == null) return null;
   return map.isEmpty() ? null:map.firstKey();
  }
  public T max() {
   if(map == null) return null;
   return map.isEmpty() ? null:map.lastKey();
  }
 }
 private static int gcf(int a, int b) {
  return b == 0 ? a:gcf(b, a%b);
 }
 private static long nCk(int n, int k) {
  return (fact[n]*((inv(fact[k])*inv(fact[n-k])%mod)))%mod;
 }
 private static void fact(int max) {
  fact = new long[max+1];
  fact[0] = 1;
  for(int i = 1; i<=max; i++) fact[i] = (fact[i-1]*i)%mod;
 }
 private static void print(long[] a) {
  System.out.println(Arrays.toString(a));
 }
 private static void print(int[] a) {
  System.out.println(Arrays.toString(a));
 }
 private static int max(int... x) {
  for (int i = 1; i < x.length; i++)
   x[0] = Math.max(x[0], x[i]);
  return x[0];
 }
 private static int min(int... x) {
  for (int i = 1; i < x.length; i++)
   x[0] = Math.min(x[0], x[i]);
  return x[0];
 }
 private static long max(long... x) {
  for (int i = 1; i < x.length; i++)
   x[0] = Math.max(x[0], x[i]);
  return x[0];
 }
 private static long min(long... x) {
  for (int i = 1; i < x.length; i++)
   x[0] = Math.min(x[0], x[i]);
  return x[0];
 }
 private static long mul(long a, long b, long mod) {
  long ret = 0;
  while(b > 0) {
   if((b&1) == 1)
    ret = (ret+a)%mod;
   a = (a<<1)%mod;
   b>>=1;
  }
  return ret;
 }
 private static long inv(long x) {
  return pow(x, mod - 2, mod);
 }
 private static long inv(long x, long mod) {
  return pow(x, mod - 2, mod);
 }
 private static long pow(long x, long n) {
  return pow(x, n, mod);
 }
 private static long pow(long x, long n, long mod) {
  x %= mod;
  long res = 1;
  while (n > 0) {
   if ((n & 1) == 1)
    res = res * x % mod;
   x = x * x % mod;
   n >>= 1;
  }
  return res;
 }
 private static class BS {
  public interface Oper {
   boolean test(long num);
  }

  private BS() {

  }

  public static long last(long lo, long hi, Oper oper) {
   lo--;
   while (lo < hi) {
    long mid = lo + (hi - lo + 1) / 2;
    if (oper.test(mid)) {
     lo = mid;
    } else {
     hi = mid - 1;
    }
   }
   return lo;
  }

  public static long first(long lo, long hi, Oper oper) {
   hi++;
   while (lo < hi) {
    long mid = lo + (hi - lo) / 2;
    if (oper.test(mid)) {
     hi = mid;
    } else {
     lo = mid + 1;
    }
   }
   return lo;
  }
 }
 private static class Merge<T> implements Iterable<T> {
  private class Node {
   public T num;
   public Node next = null;

   public Node(T num) {
    this.num = num;
   }
  }

  private class mergeIterator implements Iterator<T> {
   private Node s;

   public mergeIterator(Node s) {
    this.s = s;
   }

   @Override
   public boolean hasNext() {
    return s != null;
   }

   @Override
   public T next() {
    T ret = s.num;
    s = s.next;
    return ret;
   }
  }

  private Node s, e;
  private int size;

  public Merge() {
   s = e = null;
   size = 0;
  }

  public void addF(T n) {
   if (s == null)
    s = e = new Node(n);
   else {
    Node p = new Node(n);
    p.next = s;
    s = p;
   }
   size++;
  }

  public void add(T n) {
   if (s == null)
    s = e = new Node(n);
   else {
    e.next = new Node(n);
    e = e.next;
   }
   size++;
  }

  public void addAll(Merge<T> m) {
   if (m == this)
    return;
   if (e == null)
    s = e = m.s;
   else
    e.next = m.s;
   e = m.e;
   size += m.size;
  }

  public int size() {
   return size;
  }

  public String toString() {
   StringBuilder sb = new StringBuilder();
   sb.append("[");
   for (T i : this)
    sb.append(i + ", ");
   if (sb.length() > 1)
    sb.delete(sb.length() - 2, sb.length());
   sb.append("]");
   return sb.toString();
  }

  @Override
  public Iterator<T> iterator() {
   return new mergeIterator(s);
  }

  public void clear() {
   s = e = null;
   size = 0;
  }
 }
 private static class DSU {
  private interface Oper {
   long[] combine(long[] a, long[] b);
  }
  private long[][] vals;
  private int[] par, size;
  private Merge<Integer>[] all;
  private int cc;
  private Oper o;
  public DSU(int N, boolean storeAll) {this(N, null, storeAll);}
  public DSU(int N, Oper o) {this(N, o, false);}
  public DSU(int N) {this(N, null, false);}
  public DSU(int N, Oper o, boolean storeAll) {
   par = new int[N];
   size = new int[N];
   cc = N;
   Arrays.fill(par, -1);
   Arrays.fill(size, 1);
   this.o = o;
   if(o != null) vals = new long[N][];
   if(storeAll) {
    all = new Merge[N];
    for(int i = 0; i<N; i++) {
     all[i] = new Merge();
     all[i].add(i);
    }
   }
  }

  public long[] getVal(int num) {
   return vals[get(num)];
  }

  public int size(int num) {
   return size[get(num)];
  }

  public int get(int num) {
   return par[num] == -1 ? num : (par[num] = get(par[num]));
  }

  public boolean isSame(int x, int y) {
   return get(x) == get(y);
  }

  public boolean unite(int x, int y) {
   int p1 = get(x), p2 = get(y);
   if (p1 == p2)
    return false;
   long[] next = o == null ? new long[0]:o.combine(vals[p1], vals[p2]);
   Merge<Integer> a = all == null ? null:all[p1], b = all == null ? null:all[p2];
   if (size[p1] < size[p2]) {
    int s = p2;
    p2 = p1;
    p1 = s;
    Merge<Integer> v = a;
    a = b;
    b = v;
   }
   size[p1] += size[p2];
   par[p2] = p1;
   cc--;
   if(vals != null) vals[p1] = next;
   if(a != null)
    a.addAll(b);
   return true;
  }

  public int getCC() {
   return cc;
  }

  public void set(int num, long[] curr) {
   vals[get(num)] = curr;
  }

  public Merge<Integer> getAll(int num) {
   return all[get(num)];
  }
 }
 private static class Two<A, B> {
  public final A a;
  public final B b;

  public Two(A a, B b) {
   this.a = a;
   this.b = b;
  }

  @Override
  public boolean equals(Object obj) {
   if (!(obj instanceof Two))
    return false;
   Two curr = (Two) obj;
   return curr.a.equals(a) && curr.b.equals(b);
  }

  @Override
  public int hashCode() {
   long seed = a.hashCode();
   seed = seed << 32;
   seed |= b.hashCode();
   Random r = new Random();
   r.setSeed(seed);
   return r.nextInt();
  }

  @Override
  public String toString() {
   return "(" + a.toString() + ", " + b.toString() + ")";
  }
 }
 private static class BIT {
  private final long[] bit;
  private final long[] arr;
  private final int len;
  private long all;

  public BIT(int len) {
   bit = new long[len + 1];
   arr = new long[len];
   this.len = len;
   all = 0;
  }

  public long get(int ind) {
   return arr[ind];
  }

  public void set(int ind, long val) {
   add(ind, val - arr[ind]);
  }

  public void add(int ind, long val) {
   all+=val;
   arr[ind] += val;
   ind++;
   for (; ind <= len; ind += ind & -ind)
    bit[ind] += val;
  }

  public long suf(int ind) {
   return all-(ind == 0 ? 0:prev(ind-1));
  }

  public long prev(int ind) {
   if(ind == len-1) return all;
   ind++;
   long sum = 0;
   for (; ind > 0; ind -= ind & -ind)
    sum += bit[ind];
   return sum;
  }

  public long sum(int a, int b) {
   return prev(b) - (a == 0 ? 0 : prev(a - 1));
  }
  @Override
  public String toString() {
   StringBuilder ret = new StringBuilder();
   ret.append("[");
   for(int i = 0; i<len; i++) ret.append(get(i)+(i == len-1 ? "]":", "));
   return ret.toString();
  }
 }
 public static class ST {
  public interface Oper {
   long solve(long a, long b);
  }

  private long[] tree;
  public final int n;
  private final Oper oper;
  private final int def;

  public ST(int n, Oper oper, int def) {
   this.n = n;
   tree = new long[n << 1];
   this.oper = oper;
   this.def = def;
   for (int i = 0; i < n; i++)
    set(i, def);
  }

  public ST(int n, Oper oper) {
   this(n, oper, 0);
  }

  public ST(int n) {
   this(n, (a, b) -> Math.min(a, b), 0);
  }

  public long get(int a, int b) {
   if (a == b)
    return tree[a + n];
   if (b < a)
    return def;
   a += n;
   b += n;
   long curr = 0;
   boolean checked = false;
   while (a <= b) {
    if ((a & 1) == 1) {
     if (checked)
      curr = oper.solve(curr, tree[a++]);
     else
      curr = tree[a++];
     checked = true;
    }
    if ((b & 1) == 0) {
     if (checked)
      curr = oper.solve(curr, tree[b--]);
     else
      curr = tree[b--];
     checked = true;
    }
    a = a >> 1;
   b = b >> 1;
   }
   return curr;
  }

  public long all() {
   return get(0, n-1);
  }

  public void set(int index, long val) {
   index += n;
   tree[index] = val;
   for (index = index >> 1; index >= 1; index = index >> 1)
    tree[index] = oper.solve(tree[index << 1], tree[(index << 1) + 1]);
  }

  public long get(int index) {
   return tree[index + n];
  }

  @Override
  public String toString() {
   StringBuilder sb = new StringBuilder();
   sb.append("[");
   for (int i = 0; i < n; i++) {
    sb.append(get(i));
    if (i != n - 1)
     sb.append(", ");
   }
   sb.append("]");
   return sb.toString();
  }
 }
 public static class FastIO {
  InputStream dis;
  byte[] buffer = new byte[500007];
  int pointer = 0, end = 0;

  public FastIO(String fileName) throws Exception {
   dis = new FileInputStream(fileName);
  }

  public FastIO(InputStream is) throws Exception {
   dis = is;
  }

  public int nextInt() throws Exception {
   int ret = 0;
   byte b;
   do {
    b = nextByte();
   } while (b <= ' ');
   boolean negative = false;
   if (b == '-') {
    negative = true;
    b = nextByte();
   }
   while (b >= '0' && b <= '9') {
    ret = 10 * ret + b - '0';
    b = nextByte();
   }
   return (negative) ? -ret : ret;
  }

  public long nextLong() throws Exception {
   long ret = 0;
   byte b;
   do {
    b = nextByte();
   } while (b <= ' ');
   boolean negative = false;
   if (b == '-') {
    negative = true;
    b = nextByte();
   }
   while (b >= '0' && b <= '9') {
    ret = 10 * ret + b - '0';
    b = nextByte();
   }
   return (negative) ? -ret : ret;
  }

  private byte nextByte() throws Exception {
   while (pointer >= end) {
    end = dis.read(buffer, 0, buffer.length);
    pointer = 0;
   }
   return buffer[pointer++];
  }

  public double nextDouble() throws Exception {
   return Double.parseDouble(next());
  }

  public String next() throws Exception {
   StringBuffer ret = new StringBuffer();
   byte b;
   do {
    b = nextByte();
   } while (b <= ' ');
   while (b > ' ') {
    ret.appendCodePoint(b);
    b = nextByte();
   }
   return ret.toString();
  }

  public int[] nextArr() throws Exception {
   return nextArr(nextInt());
  }

  public int[] nextArr(int len) throws Exception {
   int[] ans = new int[len];
   for (int i = 0; i < len; i++)
    ans[i] = nextInt();
   return ans;
  }

  public List<Integer>[] nextTree() throws Exception {
   return nextTree(nextInt());
  }

  public LinkedList<Integer>[] nextTree(int n) throws Exception {
   return nextGraph(n, n - 1);
  }

  public LinkedList<Integer>[] nextGraph(int n, int m) throws Exception {
   LinkedList<Integer>[] ans = new LinkedList[n];
   for (int i = 0; i < n; i++)
    ans[i] = new LinkedList<>();
   for (int i = 0; i < m; i++) {
    int a = nextInt() - 1, b = nextInt() - 1;
    ans[a].add(b);
    ans[b].add(a);
   }
   return ans;
  }

  public char[] chars() throws Exception {
   return next().toCharArray();
  }
 }
}