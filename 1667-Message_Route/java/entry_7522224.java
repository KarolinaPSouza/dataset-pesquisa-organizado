//package com.company;
import java.io.*;
import java.util.*;
import java.lang.*;
public class entry_7522224 {
    public static class FastReader {
        private InputStream stream;
        private byte[] buf = new byte[1024];
        private int curChar;
        private int numChars;
        private SpaceCharFilter filter;
        public FastReader(InputStream stream) {
            this.stream = stream;
        }
        public int read() {
            if (numChars==-1)
                throw new InputMismatchException();
            if (curChar >= numChars) {
                curChar = 0;
                try {
                    numChars = stream.read(buf);
                }
                catch (IOException e) {
                    throw new InputMismatchException();
                }
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
        public String nextLine() {
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String str = "";
            try {
                str = br.readLine();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
        public int nextInt() {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if(c<'0'||c>'9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }
        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while (!isSpaceChar(c));
            return res * sgn;
        }
        public double nextDouble() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            double res = 0;
            while (!isSpaceChar(c) && c != '.') {
                if (c == 'e' || c == 'E')
                    return res * Math.pow(10, nextInt());
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if (c == '.') {
                c = read();
                double m = 1;
                while (!isSpaceChar(c))
                {
                    if (c == 'e' || c == 'E')
                        return res * Math.pow(10, nextInt());
                    if (c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }
        public char nextChar() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            return (char)c;
        }
        public String next() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while (!isSpaceChar(c));
            return res.toString();
        }
        public boolean isSpaceChar(int c) {
            if (filter != null)
                return filter.isSpaceChar(c);
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }
        public interface SpaceCharFilter {
            public boolean isSpaceChar(int ch);
        }
    }
    static long gcd(long a, long b){
        if (a == 0)
            return b;  
        return gcd(b % a, a);  
    }
    static long lcm(long a, long b)  {
        return (a*b)/gcd(a, b);  
    }
    static long func(long a[],long size,int s){
        long max1=a[s];
        long maxc=a[s];
        for(int i=s+1;i<size;i++){
            maxc=Math.max(a[i],maxc+a[i]);
            max1=Math.max(maxc,max1);
        }
        return max1;
    }
    static int prime[];
    static void seive(){
        prime=new int[1000001];
        prime[0]=1;
        prime[1]=1;
        prime[2]=0;
        int i,j;
        for(i=2;i*i<1000001;i++){
            if(prime[i]==0){
                for(j=i*i;j<1000001;j+=i){
                    prime[j]=1;
                }
            }
        }
    }
    static class Pair{
        int x,p;
        // ,px,py,d;
        Pair(int x,int p){
            this.x=x;
            this.p=p;
            // this.px=px;
            // this.py=py;
            // this.d=d;
        }
    }

    static void dfs(ArrayList<Integer> a[], int u, boolean vis[]){
        if(vis[u]){
            return;
        }
        vis[u]=true;
        for(int v: a[u]){
            dfs(a,v,vis);
        }
    }

    public static void main(String args[]){
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        FastReader sc = new FastReader(inputStream);
        PrintWriter w = new PrintWriter(outputStream);

        int n=sc.nextInt();
        int r = sc.nextInt();

        ArrayList<Integer> a[] = new ArrayList[n];

        for(int i=0;i<n;i++){
            a[i]=new ArrayList<>();
        }

        for(int i=0;i<r;i++){
            int u = sc.nextInt()-1, v = sc.nextInt()-1;
            a[u].add(v);
            a[v].add(u);
        }

        boolean vis[]=new boolean[n];
        int p[]=new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        p[0]=-1;
        vis[0]=true;
        int ans[]=new int[n];
        int flag=0;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int v: a[cur]){
                if(!vis[v]){
                    if(v==n-1){

                       p[v]=cur;
                       String str="";
                       int k=0;
                       while(v!=-1){
                           ans[k++]=v+1;
                           v=p[v];
                       }
                       System.out.println(k);
                       for(int i=k-1;i>=0;i--){
                           System.out.print(ans[i]+" ");
                       }
                       flag++;
                       break;
                    }
                    if(flag!=0) break;
                    vis[v]=true;
                    q.add(v);
                    p[v]=cur;
                }
                if(flag!=0) break;
            }

            }
            if(flag==0){
System.out.println("IMPOSSIBLE");  
        }
    }
}