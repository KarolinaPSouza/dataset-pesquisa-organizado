import java.io.*;
import java.util.*;

public class entry_13725301 {
    static final FastScanner sc = new FastScanner();
    static final PrintWriter out = new PrintWriter(System.out);
    static final int MOD = (int)1e9 + 7;

    public static Integer[][] dp;

    public static int[] nums;
    public static Integer[][] arr;
    public static int size;

    public static int[] nums2;
    public static int size2;

    public static int ans=0;
    public static int k;
    public static int tc;
    public static int low;
    public static int high;
    public static int val;
    public static int temp;

    public static StringBuilder sb;
    public static List<Integer> lt;
    public static Set<Integer> set;
    public static Map<Integer,Integer> map;


    public static void main(String[] args) throws Exception {
        solve();
        out.flush();
    }
    public static void solve() throws IOException {
        size = sc.nextInt();
        k = sc.nextInt();
        arr = new Integer[size][2];
        for(int i=0;i<size;i++){
            arr[i][0]= sc.nextInt();
            arr[i][1]= i+1;
        }
        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));
        int[] ans = find();
        if(ans.length==1) out.println("IMPOSSIBLE");
        else out.println(ans[0]+" "+ans[1]);
    }
    public static int[] find(){
        low =0;high=size-1;
        while (low<high){
            if(arr[low][0]+arr[high][0]==k)return new int[]{arr[low][1],arr[high][1]};
            else if(arr[low][0]+arr[high][0]>k)high--;
            else low++;
        }
        return new int[]{-1};
    }


    static final class FastScanner {
        private final byte[] buf = new byte[1 << 16];
        private int len, ptr;
        private final InputStream in = System.in;

        private final char[] tok = new char[1 << 16];
        private int tokLen;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buf);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buf[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = readByte(); } while (c <= 32 && c != -1);
            if (c == '-') { sign = -1; c = readByte(); }
            while (c > 32 && c != -1) {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
        }

        String nextLine() throws IOException {
            int c = readByte();
            while (c == '\n' || c == '\r') c = readByte();
            StringBuilder sb = new StringBuilder();
            while (c != '\n' && c != '\r' && c != -1) {
                sb.append((char) c);
                c = readByte();
            }
            return sb.toString();
        }

        char nextChar() throws IOException {
            int c = readByte();
            while (c <= 32 && c != -1) c = readByte();
            return (char) c;
        }

        private void loadToken() throws IOException {
            tokLen = 0;
            int c = readByte();
            while (c <= 32 && c != -1) c = readByte();
            while (c > 32 && c != -1) {
                tok[tokLen++] = (char) c;
                c = readByte();
            }
        }

        char nextCharAt(int idx) throws IOException {
            loadToken();
            if (idx < 0 || idx >= tokLen) throw new IndexOutOfBoundsException();
            return tok[idx];
        }
        int currentTokenLength() { return tokLen; }
    }
}