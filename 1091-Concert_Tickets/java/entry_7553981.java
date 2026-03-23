import java.security.KeyPair;
import java.util.*;
import java.lang.*;
import java.io.*;
public class entry_7553981 {
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(
                    new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String nline(int n) throws IOException {
            byte[] buf = new byte[n+1]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n') {
                    if (cnt != 0) {
                        break;
                    }
                    else {
                        continue;
                    }
                }
                buf[cnt++] = (byte)c;
            }
            return new String(buf, 0, cnt);
        }

        public int ni() throws IOException {
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

        public long nl() throws IOException {
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

        public double nd() throws IOException {
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

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }

        public int[] ra(int size) throws IOException {
            int[] array = new int[size];
            for (int i = 0; i < size; i++) array[i] = ni();
            return array;
        }

    }
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
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
                if (st.hasMoreTokens()) {
                    str = st.nextToken("\n");
                } else {
                    str = br.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static long gcd(long a, long b) { // return gcd of 2 numbers
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long lcm(long a, long b) { //return lcm of 2 numbers
        return (a / gcd(a, b)) * b;
    }
    static int search(int a[], int b)   //To search element in an array using binary search
    {
        int start = 0, end = a.length - 1;
        while (start <= end)
        {
            int mid = start + ((end - start) / 2);
            if (a[mid] == b) return mid;
            else if (a[mid] > b) end = mid - 1;
            else if (a[mid] < b) start = mid + 1;
        }
        return -1;
    }
    static int mini(int a[],int b)
    {
        int min = Integer.MAX_VALUE,index=0;
        for(int j=b;j<a.length;j++)
        {
            if(min>a[j]) {min=a[j];index=j;}
        }
        return index;
    }
    public static void main(String[] args) throws IOException {
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        Reader sc = new Reader();
        solution1 ss = new solution1();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        int a = sc.ni(),b = sc.ni(),c[] = new int[a],d[] = new int[b];
        for(int j=0;j<a;j++)
        {
            c[j] = sc.ni();
            map.put(c[j],map.getOrDefault(c[j],0)+1);
        }
        Map.Entry<Integer, Integer> ans;
        for(int j=0;j<b;j++)
        {
            d[j] = sc.ni();
            ans = map.lowerEntry(d[j]+1);
            if(ans != null){
                out.println(ans.getKey());
                if(ans.getValue() == 1) map.remove(ans.getKey());
                else map.put(ans.getKey(), ans.getValue()-1);
            }else out.println(-1);
        }
        out.close();
    }
}
class solution1
{
    static final Random random = new Random();
    public void ruffleSort(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n; i++)
        {
            int oi = random.nextInt(n), temp = (int) a[oi];
            a[oi] = a[i];
            a[i] = temp;
        }
        Arrays.sort(a);
    }
    public int[] sortArray(int[] nums)
    {
        ruffleSort(nums);
        return nums;
    }
}