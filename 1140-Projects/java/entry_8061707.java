//package AmanCode;
import java.util.*;


import java.lang.*;
import java.io.*;

public class entry_8061707 {
 public static void main(String[] args) throws java.lang.Exception {
  PrintWriter out = new PrintWriter(System.out);
  FastReader sc = new FastReader();
  int testCases = 1;
//  testCases = sc.nextInt();
  while (testCases-- > 0) {

   int n = sc.nextInt();
   List<int[]> list = new ArrayList<>();
   for(int i=0;i<n;i++) {
    int a = sc.nextInt();
    int b = sc.nextInt();
    int c = sc.nextInt();
    list.add(new int[] {a,b,c});
   }
   Collections.sort(list,(a,b)->a[0]-b[0]);
   long dp[]=new long[n+1];
   for(int i=n-1;i>=0;i--) {
    int node[]=list.get(i);
    dp[i]=Math.max(dp[i+1], node[2]+dp[findIdx(node[1],list,i+1)]);
   }
   out.println(dp[0]);

  }


  out.close();

 }
 public static int findIdx(int val ,List<int[]> list,int l) {
  int h=list.size()-1;
  while(l<=h) {
   int mid = (l+h)/2;
   if(list.get(mid)[0]>val) h=mid-1;
   else l=mid+1;
  }
  return l;
 }

 public static long power(long a, long b) {
  long res = 1;
//  int mod = 998244353;
  int mod = (int)1e9+7;
  while (b > 0) {
   if ((b & 1) > 0)
    res = (res * a) % mod;
   a = (a * a) % mod;
   b /= 2;
  }
  return res;
 }

 public static boolean isPallindrome(String a, String b) {
  int n = a.length();
  for (int i = 0; i < n; i++)
   if (a.charAt(i) != b.charAt(i))
    return false;
  return true;
 }

 public static long gcd(long a, long b) {
  if (a == 0)
   return b;
  return gcd(b % a, a);
 }

 public static int[] EEA(int a, int b) {

  if (a == 0)
   return new int[] { b, 0, 1 };
  int out[] = EEA(b % a, a);
  return new int[] { out[0], out[2] - (b / a) * (out[1]), out[1] };

 }

 private static long lcm(long a, long b) {
  return (a * b) / gcd(a, b);
 }

 static class SegTree{
  int n;
  int arr[];
  public SegTree(int n,int a[]) {
   this.n=n;
   arr=new int[4*n];
   build(0,0,n-1,a);
  }
  public void build(int node,int l,int r,int a[]) {
   if(l==r) arr[node]=a[l];
   else {
    int mid=(l+r)/2;
    build(2*node+1,l,mid,a);
    build(2*node+2,mid+1,r,a);
    arr[node]=Math.min(arr[2*node+1], arr[2*node+2]);
   }
  }
  public void update(int node,int l,int r,int pos,int a) {
   if(pos<l||r<pos) return;
   else if(l==r) arr[node]=a;
   else {
    int mid=(l+r)/2;
    update(2*node+1,l,mid,pos,a);
    update(2*node+2,mid+1,r,pos,a);
    arr[node]=Math.min(arr[2*node+1], arr[2*node+2]);
   }
  }
  public int getMin(int node,int l,int r,int ql,int qr) {
   if(ql<=l&&r<=qr) return arr[node];
   else if(r<ql||l>qr) return Integer.MAX_VALUE;
   else {
    int mid=(l+r)/2;
    int left=getMin(2*node+1,l,mid,ql,qr);
    int right=getMin(2*node+2,mid+1,r,ql,qr);
    return Math.min(left, right);
   }
  }
 }


 static class FenWick {
  int n;
  long tree[];
  int mod = 1000000007;

  public FenWick(int n) {
   this.n = n;
   tree = new long[n];
  }

  public void add(int idx, long d) {
   while (idx < n) {
    tree[idx] += d;
    tree[idx] += mod;
    tree[idx] %= mod;
    idx += (idx & (-idx));
   }
  }

  public long find(int idx) {
   long sum = 0;
   while (idx > 0) {
    sum += tree[idx];
    sum %= mod;
    idx -= (idx & (-idx));
   }
   return sum;
  }
 }

 static class DSU {
  int parent[];
  int rank[];
  int size[];

  public DSU(int n) {
   this.parent = new int[n];
   this.rank = new int[n];
   size = new int[n];
   for (int i = 0; i < n; i++)
    size[i] = 1;
   for (int i = 0; i < n; i++)
    parent[i] = i;
  }

  public int find(int x) {
   if (parent[x] == x)
    return x;
   return parent[x] = find(parent[x]);
  }

  public boolean union(int x, int y) {
   int px = find(x);
   int py = find(y);
   if (px == py) {
    return false;
   }
   if (rank[px] > rank[py]) {
    parent[py] = px;
    size[px] += size[py];
   } else if (rank[py] > rank[px]) {
    parent[px] = py;
    size[py] += size[px];
   } else {
    rank[px]++;
    parent[py] = px;
    size[px] += size[py];
   }
   return true;

  }
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
    } catch (IOException e) {
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
   } catch (IOException e) {
    e.printStackTrace();
   }
   return str;
  }
 }

}