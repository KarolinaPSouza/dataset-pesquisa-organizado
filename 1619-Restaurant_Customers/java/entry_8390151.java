import java.io.*;
import java.util.*;



public class entry_8390151 {

    public static void main(String[] args)
            throws IOException {
        Reader sc = new Reader();
        PrintWriter pw=new PrintWriter(System.out);

        int n=sc.nextInt();

        ArrayList<pair> l=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            pair p1=new pair(sc.nextInt(),1);
            l.add(p1);
            pair p2=new pair(sc.nextInt(),-1);
            l.add(p2);
        }

        Collections.sort(l,new valComp());
        int count=0;
        int ans=0;
        for (pair p:l) {
            count+=p.b;
            ans=Math.max(ans,count);
        }

        pw.print(ans);
        pw.close();
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

}

public static class FastWriter {

    // Writer object
    BufferedWriter writer;

    // Constructor
    public FastWriter() {

        // Initialize the writer
        writer = new BufferedWriter(
                new OutputStreamWriter(
                        System.out));
        if (System.getProperty(
                "ONLINE_JUDGE")
                == null) {
            try {
                writer = new BufferedWriter(
                        new OutputStreamWriter(
                                new FileOutputStream(
                                        "output.txt")));
            } catch (Exception e) {
            }
        }
    }

    // Function to write the
    // single integer
    public void writeSingleInteger(int i)
            throws IOException {
        writer.write(Integer.toString(i));
        writer.newLine();
        writer.flush();
    }

    // Function to write single long
    public void writeSingleLong(long i)
            throws IOException {
        writer.write(Long.toString(i));
        writer.newLine();
        writer.flush();
    }

    // Function to write a Integer of
    // array with spaces in one line
    public void writeIntArrayWithSpaces(int[] nums)
            throws IOException {
        for (int i = 0;
             i < nums.length; i++) {
            writer.write(nums[i]
                    + " ");
        }
        writer.newLine();
        writer.flush();
    }

    // Function to write Integer of
    // array without spaces in 1 line
    public void writeIntArrayWithoutSpaces(int[] nums)
            throws IOException {
        for (int i = 0;
             i < nums.length; i++) {
            writer.write(
                    Integer.toString(
                            nums[i]));
        }
        writer.newLine();
        writer.flush();
    }

    // Function to write String
    public void writeString(String s)
            throws IOException {
        writer.write(s);
        writer.newLine();
        writer.flush();
    }
}

    public static boolean isPrime(long n) {
        if (n < 2) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        long sqrtN = (long) Math.sqrt(n) + 1;
        for (long i = 6L; i <= sqrtN; i += 6) {
            if (n % (i - 1) == 0 || n % (i + 1) == 0) return false;
        }
        return true;
    }

    public static long gcd(long a, long b) {
        if (a > b)
            a = (a + b) - (b = a);
        if (a == 0L)
            return b;
        return gcd(b % a, a);
    }

    public static void sort(int[] arr) {
        //because Arrays.sort() uses quicksort which is dumb
        //Collections.sort() uses merge sort
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int x : arr)
            ls.add(x);
        Collections.sort(ls);
        for (int i = 0; i < arr.length; i++)
            arr[i] = ls.get(i);
    }

    static long lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

}

class pair{
    int a;
    int b;

    public pair(int a, int b) {
        this.a = a;
        this.b = b;
    }
}

class valComp implements Comparator<pair>{
    public int compare(pair s1,pair s2){
        if(s1.a==s2.a)
            return 0;
        else if(s1.a>s2.a)
            return 1;
        else
            return -1;
    }
}