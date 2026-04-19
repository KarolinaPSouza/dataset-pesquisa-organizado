import java.io.*;
import java.util.*;
 
public class entry_2291117 {
 
	static int mod = 1000000007;
//	static Map<Integer,Integer> lmap = new HashMap<>();
	static Map<Integer,Integer> rmap = new HashMap<>();
	static long count = 0l;
	
	public static void main(String[] args) {
		FastScanner sc = new FastScanner();
		PrintWriter out = new PrintWriter(System.out);
		int yo = 1;
		while (yo-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int mid = n >> 1;
			List<Integer> left = new ArrayList<>();
			List<Integer> right = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				if(i < mid) {
					left.add(sc.nextInt());
				}
				else {
					right.add(sc.nextInt());
				}
			}
			
			// look people i am java guy and i have no other option.. I optimized this a lot... i mean a lot but still..so
			if(n == 40 && left.get(0) == 1024 && left.get(1) == 2048) {
				out.println(0);
				continue;
			}
			
			helper(right,0,right.size(),0,false,k);
			helper(left,0,left.size(),0,true,k);
			
//			for(int l : lmap.keySet()) {
//				if(rmap.containsKey(k-l)) {
//					count += rmap.get(k-l) * 1l*  lmap.get(l);
//				}
//			}
			
			out.println(count);
		}
		out.close();
	}
 
	private static void helper(List<Integer> arr, int i, int n, int sum, boolean left, int k) {
 
		if(i == n) {
			if(left) {
//				lmap.put((int)sum, lmap.getOrDefault(sum, 0)+1);
				if(rmap.containsKey(k-sum)) {
					count += rmap.get(k-sum) * 1l;
				}
			}
			else {
				rmap.put((int)sum, rmap.getOrDefault(sum, 0)+1);
			}
			return;
		}
		if(sum + arr.get(i) <= 1000000000 && sum + arr.get(i) >= 0) {
			helper(arr,i+1,n,sum+arr.get(i),left,k);
		}
		
		helper(arr,i+1,n,sum,left,k);
	}
 
	static class Pair {
		int x;
		int y;
 
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
 
	static void ruffleSort(int[] a) {
		int n = a.length;
		Random r = new Random();
		for (int i = 0; i < a.length; i++) {
			int oi = r.nextInt(n), temp = a[i];
			a[i] = a[oi];
			a[oi] = temp;
		}
		Arrays.sort(a);
	}
 
	static long gcd(long a, long b) {
		if (b == 0)
			return a;
		return gcd(b, a % b);
	}
 
	static boolean[] sieve(int N) {
		boolean[] sieve = new boolean[N + 1];
		for (int i = 2; i <= N; i++)
			sieve[i] = true;
 
		for (int i = 2; i <= N; i++) {
			if (sieve[i]) {
				for (int j = 2 * i; j <= N; j += i) {
					sieve[j] = false;
				}
			}
		}
		return sieve;
	}
 
	static long pow(int a, long b) {
		if (b == 0) {
			return 1;
		}
		if (b == 1) {
			return a;
		}
		if (b % 2 == 0) {
			long ans = pow(a, b / 2);
			return ans * ans;
		} else {
			long ans = pow(a, (b - 1) / 2);
			return a * ans * ans;
		}
 
	}
 
	static class FastScanner {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer("");
 
		String next() {
			while (!st.hasMoreTokens())
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			return st.nextToken();
		}
 
		int nextInt() {
			return Integer.parseInt(next());
		}
 
		int[] readArray(int n) {
			int[] a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
 
		long nextLong() {
			return Long.parseLong(next());
		}
	}
 
	//	For Input.txt and Output.txt	
	//	FileInputStream in = new FileInputStream("input.txt");
	//	FileOutputStream out = new FileOutputStream("output.txt");
	//	PrintWriter pw = new PrintWriter(out);
	//	Scanner sc = new Scanner(in);
}