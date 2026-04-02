import java.io.*;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.*;
import java.io.IOException;

import static java.util.Arrays.setAll;
import static java.util.Arrays.sort;


public class entry_9844287 {
    static FastReader scan = new FastReader(System.in);
    static PrintWriter out = new PrintWriter(System.out);
    static long[] dp;
    static int n;
    static long[] res;
    static int[] bad;
    public static void main(String[] args) throws IOException{
        int ttt= 1;
        for(int eee=0;eee<ttt;eee++){
            solve();
        }
        out.close();
    }

    static ArrayList<Integer>[] graph;
    static long sum;
    static int[] resy;
    static int k;
    public static void solve() throws IOException {
          int n=scan.nextInt();
          int x=scan.nextInt();
          int[] dp = new int[x+1];
          int[] arr = scan.nextArrInt(n);
          Arrays.fill(dp,(int)1e6+1);
          dp[0]=0;
          for (int i=1;i<=x;i++){
                for(int j=0;j<n;j++){
                    if(i-arr[j]>=0){
                        dp[i]=Math.min(dp[i],dp[i-arr[j]]+1);
                    }
                }
          }
          out.println(dp[x]==(1e6)+1?-1:dp[x]);

    }
    static Pair meth(String s,int mx){
        int res=Integer.MAX_VALUE;
        int pos=0;
        for(int i=0;i<n;i++){
            int max=-1;
            for(int j=0;j<n;j++){
                if(s.charAt(j)=='1'){
                    max=Math.max(max,Math.abs(i-j));
                }
            }
            if(mx!=-1){
                max=Math.max(max,i+k+mx+1);
            }
            if(res>max){
                res=max;
                pos=i+1;
            }
        }
        return new Pair(res,pos);

    }

    static void swap(int l,int r){
        int temp=l;
        l=r;
        r=temp;
    }

    static boolean method(int[] arr1,int[] arr2,int[] arr3){
        boolean check =false;
        boolean check2 =false;
        boolean check3 =false;
        resy[0]=1;
        long sum1=0;
        int i=0;
      for( i=0;i<n;i++){
          sum1+=arr1[i];
          resy[1]=i+1;
          if(sum1>=Math.ceil(sum/3)){
              ++i;
              check=true;
              break;
          }
      }
      resy[2]=i+1;
      sum1=0;
      for(;i<n;i++){
          sum1+=arr2[i];
          resy[3]=i+1;
          if(sum1>=Math.ceil(sum/3)){
              ++i;
              check2=true;
              break;
          }
      }
      resy[4]=i+1;
      sum1=0;
      for(;i<n;i++){
          sum1+=arr3[i];
          resy[5]=i+1;
          if(sum1>=Math.ceil(sum/3)){
              ++i;
              check3=true;
              break;
          }
      }
        return check&&check2&&check3;
    }
    public static void sortInt(int[] a, boolean increasing) {
        ArrayList<Integer> arr = new ArrayList<Integer>();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            arr.add(a[i]);
        }
        Collections.sort(arr);
        for (int i = 0; i < n; i++) {
            if (increasing) {
                a[i] = arr.get(i);
            }
            else {
                a[i] = arr.get(n-1-i);
            }
        }
    }



    //    static void dfs2(int v,int pre){
//        res[v]=dp[v];
//        for(int u:list[v]){
//            if(u==pre) continue;
//            dp[v]-=Math.max(0,dp[u]);
//            dp[u]+=Math.max(0,dp[v]);
//            dfs2(u,v);
//            dp[u]-=Math.max(dp[v],0);
//            dp[v]+=Math.max(dp[u],0);
//
//        }
//    }
    static void dfs(int v,int pre){
        dp[v]=bad[v];
        for(int u:graph[v]){
            if(u==pre)continue;
            dfs(u,v);
            dp[v]+=Math.max(dp[u],0);
        }
    }


    static class Pair{
        // int index;
        int first;
        int second;
        Pair(int x, int y){
            // this.index=a;
            this.first=x;
            this.second=y;
        }


    }

    static class FastReader {
        byte[] buf = new byte[2048];
        int index, total;
        InputStream in;

        FastReader(InputStream is) {
            in = is;
        }

        int scan() throws IOException {
            if (index >= total) {
                index = 0;
                total = in.read(buf);
                if (total <= 0) {
                    return -1;
                }
            }
            return buf[index++];
        }

        String next() throws IOException {
            int c;
            for (c = scan(); c <= 32; c = scan()) ;
            StringBuilder sb = new StringBuilder();
            for (; c > 32; c = scan()) {
                sb.append((char) c);
            }
            return sb.toString();
        }

        int nextInt() throws IOException {
            int c, val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        long nextLong() throws IOException {
            int c;
            long val = 0;
            for (c = scan(); c <= 32; c = scan()) ;
            boolean neg = c == '-';
            if (c == '-' || c == '+') {
                c = scan();
            }
            for (; c >= '0' && c <= '9'; c = scan()) {
                val = (val << 3) + (val << 1) + (c & 15);
            }
            return neg ? -val : val;
        }

        int[] nextArrInt(int n) throws IOException {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        long[] nextArrLong(int n) throws IOException {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }

    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;


        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    } else {
                        continue;
                    }
                }
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') {
                c = read();
            }
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0,
                    BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }

        public void printarray(int arr[]) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
        }
    }
}