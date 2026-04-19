import java.io.*;
import java.util.*;
public class entry_16078343{
	static Scanner in=new Scanner();
	static long systemTime;
	static long mod = 1000000007;
	static ArrayList<ArrayList<Integer>> adj;
	static int seive[]=new int[1000001];
	static long C[][];
	static PrintWriter out;
	static int dist[],ans[];
	public static void main(String[] args) throws Exception{
		int z=1;
		out = new PrintWriter(System.out);
		for(int test=1;test<=z;test++) {
			//setTime();
			solve();
			//printTime();
			//printMemory();
		}
		out.close();
	}
	static void solve() {
		int n = in.readInt();
		long k = in.readLong();
		long[] a = nla(n);
 
		int mid = n / 2;
 
		long[] left = gen(a, 0, mid);
		long[] right = gen(a, mid, n);
 
		Arrays.sort(left);
		Arrays.sort(right);
 
		long ans = 0;
		int i = 0, j = right.length - 1;
 
		while (i < left.length && j >= 0) {
			long sum = left[i] + right[j];
			if (sum == k) {
				long lv = left[i], rv = right[j];
				long cntL = 0, cntR = 0;
 
				while (i < left.length && left[i] == lv) {
					cntL++; i++;
				}
				while (j >= 0 && right[j] == rv) {
					cntR++; j--;
				}
				ans += cntL * cntR;
			} else if (sum < k) {
				i++;
			} else {
				j--;
			}
		}
 
		out.println(ans);
	}
 
	static long[] gen(long[] a, int l, int r) {
		int size = 1 << (r - l);
		long[] res = new long[size];
		for (int mask = 0; mask < size; mask++) {
			long sum = 0;
			for (int i = 0; i < r - l; i++) {
				if ((mask & (1 << i)) != 0) {
					sum += a[l + i];
				}
			}
			res[mask] = sum;
		}
		return res;
	}
 
	static long[] dijksta(int src,int n){
		long vis[]=new long[n];
		Arrays.fill(vis,Long.MAX_VALUE);
		vis[src]=0;
		PriorityQueue<long[]> pq=new PriorityQueue<>((u,v)->Long.compare(u[0],v[0]));
		pq.add(new long[]{0,src});
		while(pq.size()>0){
			long node[]=pq.remove();
			if (node[0]>vis[(int)node[1]]){
				continue;
			}
			for(int i=0;i<adj.get((int)node[1]).size();i+=2){
				int child=adj.get((int)node[1]).get(i);
				int w=adj.get((int)node[1]).get(i+1);
				if(vis[child]>node[0]+w){
					vis[child]=node[0]+w;
					pq.add(new long[]{vis[child],child});
				}
			}
		}
		return vis;
	}
	
	static long pow(long n, long m) {
		if(m==0)
			return 1;
		else if(m==1)
			return n;
        long r=pow(n,m/2)%mod;
        r*=r;
        r%=mod;
        if((m&1)==1)
            r*=n;
        return r%mod;
	}
	static long maxsumsub(ArrayList<Long> al) {
		long max=0;
		long sum=0;
		for(int i=0;i<al.size();i++) {
			sum+=al.get(i);
			if(sum<0) {
				sum=0;
			}
			max=Math.max(max,sum);
		}
		return max;
	}
	static long abs(long a) {
		return Math.abs(a);
	}
	static void ncr(int n, int k){
		C= new long[n + 1][k + 1];
		int i, j;
		for (i = 0; i <= n; i++) {
		    for (j = 0; j <= Math.min(i, k); j++) {
		        if (j == 0 || j == i)
		            C[i][j] = 1;
		        else
		            C[i][j] = C[i - 1][j - 1] + C[i - 1][j];
		    }
		}
	}
	static boolean isPalin(String s) {
		int i=0,j=s.length()-1;
		while(i<=j) {
			if(s.charAt(i)!=s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	static int knapsack(int W, int wt[],int val[], int n){
		int []dp = new int[W + 1];
	    for (int i = 1; i < n + 1; i++) {
	    	for (int w = W; w >= 0; w--) {
		        if (wt[i - 1] <= w) {
		        	dp[w] = Math.max(dp[w],dp[w - wt[i - 1]] + val[i - 1]);
		    	}
	    	}
	    }
	    return dp[W];
	}
	static void seive() {
		Arrays.fill(seive, 1);
		seive[0]=0;
		seive[1]=0;
		for(int i=2;i*i<1000001;i++) {
			if(seive[i]==1) {
				for(int j=i*i;j<1000001;j+=i) {
					if(seive[j]==1) {
						seive[j]=0;
					}
				}
			}
		}
	}
	static void sort(int[] a) {
		ArrayList<Integer> l=new ArrayList<>();
		for (int i:a) 
			l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) 
			a[i]=l.get(i);
	}
	static void sort(long[] a) {
		ArrayList<Long> l=new ArrayList<>();
		for (long i:a) 
			l.add(i);
		Collections.sort(l);
		for (int i=0; i<a.length; i++) 
			a[i]=l.get(i);
	}
	static int[] nia(int n){
		int[] arr= new int[n];
		int i=0;
		while(i<n){
			arr[i++]=in.readInt();
		}
		return arr;
	}
	static long[] nla(int n){
		long[] arr= new long[n];
		int i=0;
		while(i<n){
			arr[i++]=in.readLong();
		}
		return arr;
	}
	static long[] nla1(int n){
		long[] arr= new long[n+1];
		int i=1;
		while(i<=n){
			arr[i++]=in.readLong();
		}
		return arr;
	}
	static int[] nia1(int n){
		int[] arr= new int[n+1];
		int i=1;
		while(i<=n){
			arr[i++]=in.readInt();
		}
		return arr;
	}
	static Integer[] nIa(int n){
		Integer[] arr= new Integer[n];
		int i=0;
		while(i<n){
			arr[i++]=in.readInt();
		}
		return arr;
	}
	static Long[] nLa(int n){
		Long[] arr= new Long[n];
		int i=0;
		while(i<n){
			arr[i++]=in.readLong();
		}
		return arr;
	}
	static long gcd(long a, long b) {
		if (b==0) return a;
		return gcd(b, a%b);
	}
	static void no() {
		out.println("NO");
	}
	static void yes() {
		out.println("YES");
	}
	static void print(long i) {
		out.println(i);
	}
	static void print(Object o) {
		out.println(o);
	}
	static void print(int a[]) {
		for(int i:a) {
			out.print(i+" ");
		}
		out.println();
	}
	static void print(long a[]) {
		for(long i:a) {
			out.print(i+" ");
		}
		out.println();
	}
	static void print(ArrayList<Long> a) {
		for(long i:a) {
			out.print(i+" ");
		}
		out.println();
	}
	static void print(Object a[]) {
		for(Object i:a) {
			out.print(i+" ");
		}
		out.println();
	}
	static void setTime() {
		systemTime = System.currentTimeMillis();
	}
	static void printTime() {
		System.err.println("Time consumed: " + (System.currentTimeMillis() - systemTime));
	}
 
	static void printMemory() {
		System.err.println("Memory consumed: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000 + "kb");
	}
	static class Scanner{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer("");
		String readString() {
			while (!st.hasMoreTokens())
				try {
					st=new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
		double readDouble() {
			return Double.parseDouble(readString());
		}
		int readInt() {
			return Integer.parseInt(readString());
		}
		long readLong() {
			return Long.parseLong(readString());
		}
	}
}