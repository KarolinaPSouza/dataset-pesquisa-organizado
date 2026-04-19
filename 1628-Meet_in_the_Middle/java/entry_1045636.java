import java.io.*;
import java.util.*;
 
public class entry_1045636 extends PrintWriter {
    
    int n;
    long x;
    long[] v;
    
    
    private void solve() {
        long start = System.nanoTime();
        n = sc.nextInt();
        x = sc.nextInt();
        v = new long[n];
        for(int i = 0; i < n; i++) v[i] = sc.nextInt();
        int mid = (n-1)/2;
        long[] arr_l = doit(0, mid);
        int len_l = idx;
        arr = arr_l;
        sort(0,len_l-1);
        idx = 0;
        long[] arr_r = doit(mid+1, n-1);
        int len_r = idx;
        arr = arr_r;
        sort(0,len_r-1);
        System.err.println((System.nanoTime()-start)/1E9);
        long ans = 0L;
        int l = 0;
        int r = len_r-1;
        while(l < len_l && r >= 0) {
            if(arr_l[l] + arr_r[r] > x) r--;
            else if(arr_l[l] + arr_r[r] < x) l++;
            else {
                long cnt_l = 1;
                long cnt_r = 1;
                while(l < len_l-1 && arr_l[l] == arr_l[l+1]) {
                    l++;
                    cnt_l++;
                }
                while(r > 0 && arr_r[r] == arr_r[r-1]) {
                    cnt_r++;
                    r--;
                }
                ans += cnt_l*cnt_r;
                l++;
                r--;
            }
        }
        println(ans);
    }
    
    int idx = 0;
    
    long[] doit(int l, int r){
        int t = r-l+1;
        long[] res = new long[1<<t];
        for(int i = 0; i < (1<<t); i++) {
            int ii = i;
            long sum = 0;
            boolean ok = true;
            for(int j = 0; j < t; j++) {
                if(ii%2 == 1) {
                    sum += v[l+j];
                    if(sum > x) {
                        ok = false;
                        break;
                    }
                }
                ii/=2;
            }
            if(ok == true) res[idx++] = sum;
        }
        return res;
    }
    
    long[] arr;
    
    void sort(int l, int r) {
        if(l == r) return;
        else {
            int mid = (l+r)/2;
            sort(l, mid);
            sort(mid+1, r);
            long[] temp = new long[r-l+1];
            int idx = 0;
            int i = l;
            int j = mid+1;
            while(i <= mid && j <= r) {
                if(arr[i] <= arr[j]) {
                    temp[idx++] = arr[i++];
                } else {
                    temp[idx++] = arr[j++];
                }
            }
            while(i <= mid) {
                temp[idx++] = arr[i++];
            }
            while(j <= r) {
                temp[idx++] = arr[j++];
            }
            for(i = l; i <= r; i++) {
                arr[i] = temp[i-l];
            }
        }
    }
    
  entry_1045636() { super(System.out); }
  Scanner sc = new Scanner(System.in);
  static class Scanner {
      Scanner(InputStream in) { this.in = in; } InputStream in;
      int k, l; byte[] bb = new byte[1 << 15];
      byte getc() {
          if (k >= l) {
              k = 0;
              try { l = in.read(bb); } catch (IOException e) { l = 0; }
              if (l <= 0) return -1;
          }
          return bb[k++];
      }
      int nextInt() {
          byte c = 0; while (c <= 32) c = getc();
          int a = 0;
          while (c > 32) { a = a * 10 + c - '0'; c = getc(); }
          return a;
      }
      char nextChar() {
          byte c = 0; while (c <= 32) c = getc();
          char ch  = ' ';
          while (c > 32) { ch = (char)c; c = getc(); }
          return ch;
      }
  }
  public static void main(String[] $) {
      new Thread(null, new Runnable() {
          public void run() {
              long start = System.nanoTime();
              try {entry_1045636 solution = new entry_1045636(); solution.solve(); solution.flush();} 
              catch (Exception e) {e.printStackTrace(); System.exit(1);}
              System.err.println((System.nanoTime()-start)/1E9);
          }
      }, "1", 1 << 27).start();
      
  }
}