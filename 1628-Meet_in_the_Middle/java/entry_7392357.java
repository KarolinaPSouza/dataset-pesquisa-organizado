import java.io.*;
import java.util.*;
 
public class Main {
	long[] tmp = new long[1<<20];
	void solve()
	{
		int n = in.nextInt();
		int x = in.nextInt();
		int[] t = in.nextInts(n);
		
		
		int s1 = Math.min(n, 20);
		int s2 = n-s1;
		
		long[] v1 = new long[1<<s1];
		long[] v2 = new long[1<<s2];
		for(int i=0;i<(1<<s1);i++)
		{
			long sum = 0;
			for(int j=0;j<s1;j++)
				if( ((i>>j)&1) == 1 )
					sum += t[j];
			v1[i] = sum;
		}
		for(int i=0;i<(1<<s2);i++)
		{
			long sum = 0;
			for(int j=0;j<s2;j++)
				if( ((i>>j)&1) == 1 )
					sum += t[j+s1];
			v2[i] = sum;
		}
		
//		safeSort(v1);
//		safeSort(v2);
//		Arrays.sort(v1);
//		Arrays.sort(v2);
		mergeSort(v1);
		mergeSort(v2);
		
		long res = 0;
		int ptr2 = v2.length-1;
		for(int i=0;i<v1.length;i++)
		{
			int cnt1 = 1, cnt2 = 0;
			
			while(ptr2>=0 && v2[ptr2] + v1[i] >= x) {
				if(v2[ptr2]+v1[i] == x)
					cnt2++;
				ptr2--;
			}
			
			while(i+1 < v1.length && v1[i+1] == v1[i]) {
				cnt1++;
				i++;
			}
			
			res += cnt1 * 1L * cnt2;
		}
		out.printLong(res).println();
	}
	
	void mergeSort(long[] arr)
	{
		int n = arr.length;
		for ( int h=1 ; h<arr.length ; h *= 2 ) {
			for(int l=0; l+h<n; l += 2*h) {
				int ptr1 = l;
				int ptr2 = l+h;
				int mid = ptr2;
				int r = Math.min(mid+h, n);
				int top = l;
				
				while( ptr1 < mid && ptr2 < r )
				{
					if(arr[ptr1] <= arr[ptr2])
						tmp[top++] = arr[ptr1++];
					else
						tmp[top++] = arr[ptr2++];
				}
				while( ptr1 < mid )
					tmp[top++] = arr[ptr1++];
				while( ptr2 < r )
					tmp[top++] = arr[ptr2++];
				for(int i=l;i<top;i++)
					arr[i] = tmp[i];
			}
		}
	}
	
	
	public void printlnArray(int[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			if(i!=0)
				out.print(' ');
			out.printInt(array[i]);
		}
		out.println();
	}
 
	public void printlnArray(long[] array)
	{
		for(int i=0;i<array.length;i++)
		{
			if(i!=0)
				out.print(' ');
			out.printLong(array[i]);
		}
		out.println();
	}
 
	static Random rand = new Random();	
	public static void safeSort(int[] arr)
	{
		int n = arr.length;
		while(n>1)
		{
			int pos = rand.nextInt(n);
			int tmp = arr[pos];
			arr[pos] = arr[n-1];
			arr[n-1] = tmp;
			n--;
		}
		Arrays.sort(arr);
	}
	
	public static void safeSort(long[] arr)
	{
		int n = arr.length;
		while(n>1)
		{
			int pos = rand.nextInt(n);
			long tmp = arr[pos];
			arr[pos] = arr[n-1];
			arr[n-1] = tmp;
			n--;
		}
		Arrays.sort(arr);
	}
 
	private SuperQuickReader in;
	private SuperQuickWriter out;
	public Main(SuperQuickReader in, SuperQuickWriter out) {
		this.in = in;
		this.out = out;
	}
	
	public static void main(String[] args) throws IOException {
		SuperQuickReader in = new SuperQuickReader(System.in);
 
		try(SuperQuickWriter out = new SuperQuickWriter(System.out);)
		{
			new Main(in, out).solve();
		}
	}
	
}
 
class QuickReader {
	BufferedReader in;
	StringTokenizer token;
 
	public QuickReader(InputStream ins) {
		in = new BufferedReader(new InputStreamReader(ins));
		token = new StringTokenizer("");
	}
 
	public boolean hasNext() {
		while (!token.hasMoreTokens()) {
			try {
				String s = in.readLine();
				if (s == null)
					return false;
				token = new StringTokenizer(s);
			} catch (IOException e) {
				throw new InputMismatchException();
			}
		}
		return true;
	}
 
	public String next() {
		hasNext();
		return token.nextToken();
	}
 
	public int nextInt() {
		return Integer.parseInt(next());
	}
 
	public int[] nextInts(int n) {
		int[] res = new int[n];
		for (int i = 0; i < n; i++)
			res[i] = nextInt();
		return res;
	}
 
	public long nextLong() {
		return Long.parseLong(next());
	}
 
	public long[] nextLongs(int n) {
		long[] res = new long[n];
		for (int i = 0; i < n; i++)
			res[i] = nextLong();
		return res;
	}
 
}
 
class SuperQuickWriter implements Closeable
{
	static final int BUFFER_SIZE = 4*4096;
	static final int SMALL_BUFFER_SIZE = 64;
	Writer out;
	char[] buf = new char[BUFFER_SIZE];
	char[] smallBuf = new char[SMALL_BUFFER_SIZE];
	int bufTop;
	public SuperQuickWriter(OutputStream out)
	{
		this.out = new OutputStreamWriter(out);
	}
	
	public SuperQuickWriter print(char c)
	{
		try {
		if(bufTop == BUFFER_SIZE)
		{
			out.write(buf);
			bufTop = 0;
		}
		buf[bufTop++] = c;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return this;
	}
	
	public SuperQuickWriter printInt(int x)
	{
		int top = 0;
		if ( x < 0 )
		{
			print('-');
			x = -x;
		}
		do
		{
			smallBuf[top++]=(char) (x%10+'0');
			x/=10;
		}
		while(x!=0);
		
		while(top>0)
			print(smallBuf[--top]);
		
		return this;
	}
	
	public SuperQuickWriter printLong(long x) {
		int top = 0;
		if ( x < 0 )
		{
			print('-');
			x = -x;
		}
		do
		{
			smallBuf[top++]=(char) (x%10+'0');
			x/=10;
		}
		while(x!=0);
		
		while(top>0)
			print(smallBuf[--top]);
		return this;
	}
	
	public SuperQuickWriter printString(String x)
	{
		for(int i=0;i<x.length();i++)
			print(x.charAt(i));
		return this;
	}
 
	public SuperQuickWriter println()
	{
		print('\n');
		return this;
	}
	
	public void flush() {
		try {
			out.write(buf, 0, bufTop);
			out.flush();
			bufTop = 0;
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void close() throws IOException {
		flush();
		out.close();
	}
	
}
 
class SuperQuickReader
{
	final int BUFFER_SIZE = 4096;
	Reader in;
	
	char[] buf = new char[BUFFER_SIZE];
	int bufL, bufR;
	
	public SuperQuickReader(InputStream ins)
	{
		in=new InputStreamReader(ins);
	}
	
	static boolean isWhitespace(char c)
	{
		return c == ' ' || c == '\n' || c == '\r' || c == '\t';
	}
 
	public char nextChar()
	{
		try {
			while(bufR >= 0)
			{
				if(bufL < bufR)
				{
					char x = buf[bufL++];
					return x;
				}
				else
				{
					bufR = in.read(buf);
					bufL = 0;
				}
			}
		}
		catch(IOException e)
		{
			bufL = bufR = -1;
		}
		return 0;
	}
	
	public char nextNonSpaceChar()
	{
		char c;
		do
		{
			c = nextChar();
		}while(isWhitespace(c));
		return c;
	}
	
	public int nextInt()
	{
		int res = 0;
		char c;
		boolean neg = false;
		do
		{
			c = nextChar();
		}
		while(isWhitespace(c));
		if(c == '-')
		{
			neg = true;
			c = nextChar();
		}
		
		do
		{
			res = res * 10 + (c-'0');
			c = nextChar();
		}
		while(!isWhitespace(c) && c!=0);
		
		if(neg) res = -res;
		return res;
	}
	
	public long nextLong()
	{
		long res = 0;
		char c;
		boolean neg = false;
		do
		{
			c = nextChar();
		}
		while(isWhitespace(c));
		if(c == '-')
		{
			neg = true;
			c = nextChar();
		}
		
		do
		{
			res = res * 10 + (c-'0');
			c = nextChar();
		}
		while(!isWhitespace(c) && c!=0);
		
		if(neg) res = -res;
		return res;
	}
 
	public int[] nextInts(int n)
	{
		int[] res = new int[n];
		for (int i = 0; i < n; i++)
			res[i] = nextInt();
		return res;
	}
	
	public long[] nextLongs(int n)
	{
		long[] res = new long[n];
		for (int i = 0; i < n; i++)
			res[i] = nextLong();
		return res;
	}
 
}