//package sorting_and_searching.sum_of_four_values;

import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FastReader {
    private int BS = 1 << 16;
    private char NC = (char) 0;
    private byte[] buf = new byte[BS];
    private int bId = 0, size = 0;
    private char c = NC;
    private double cnt = 1;
    private BufferedInputStream in;

    public FastReader() {
        in = new BufferedInputStream(System.in, BS);
    }

    // dont' use this to read chars.
    private char readChar() {
        while (bId == size) {
            try {
                size = in.read(buf);
            } catch (Exception e) {
                return NC;
            }
            if (size == -1) return NC;
            bId = 0;
        }
        return (char) buf[bId++];
    }

    public int readInt() {
        return (int) readLong();
    }

    public int[] readInts(int N) {
        int[] res = new int[N];
        for (int i = 0; i < N; i++) {
            res[i] = (int) readLong();
        }
        return res;
    }

    public long[] readLongs(int N) {
        long[] res = new long[N];
        for (int i = 0; i < N; i++) {
            res[i] = readLong();
        }
        return res;
    }

    public long readLong() {
        cnt = 1;
        boolean neg = false;
        if (c == NC) c = readChar();
        for (; (c < '0' || c > '9'); c = readChar()) {
            if (c == '-') neg = true;
        }
        long res = 0;
        for (; c >= '0' && c <= '9'; c = readChar()) {
            res = (res << 3) + (res << 1) + c - '0';
            cnt *= 10;
        }
        return neg ? -res : res;
    }

    public double nextDouble() {
        double cur = readLong();
        return c != '.' ? cur : cur + readLong() / cnt;
    }

    public double[] nextDoubles(int N) {
        double[] res = new double[N];
        for (int i = 0; i < N; i++) {
            res[i] = nextDouble();
        }
        return res;
    }

    public String readString() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = readChar();
        while (c > 32) {
            res.append(c);
            c = readChar();
        }
        return res.toString();
    }

    public String readLine() {
        StringBuilder res = new StringBuilder();
        while (c <= 32) c = readChar();
        while (c != '\n') {
            res.append(c);
            c = readChar();
        }
        return res.toString();
    }

    public boolean hasNext() {
        if (c > 32) return true;
        while (true) {
            c = readChar();
            if (c == NC) return false;
            else if (c > 32) return true;
        }
    }
}

public class entry_4996429 {
    private PrintWriter writer;
    private FastReader reader;
    private long[] getFourSomeIndexes(long[] arr, long target){
        long[][] arrayWithIndex = new long[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            arrayWithIndex[i][0] = arr[i];
            arrayWithIndex[i][1] = i+1;
        }
        Arrays.sort(arrayWithIndex, Comparator.comparingLong(a->a[0]));
        for (int i = 0; i < arrayWithIndex.length; i++){
            long iVal = arrayWithIndex[i][0];
            if (iVal > target-3) break;
            for (int j = i+1; j < arrayWithIndex.length; j++){

                long jVal = arrayWithIndex[j][0];
                if (iVal + jVal > target-2) break;

                long reqVal = target-iVal-jVal;
                int left = j+1;
                int right = arrayWithIndex.length-1;

                while (left < right){
                    long sum = arrayWithIndex[left][0]+arrayWithIndex[right][0];
                    if (sum < reqVal) left++;
                    else if (sum > reqVal) right--;
                    else{
                        return new long[]{arrayWithIndex[i][1], arrayWithIndex[j][1], arrayWithIndex[left][1], arrayWithIndex[right][1]};
                    }
                }
            }

        }

        return null;

    }
    private void solve(){
        writer = new PrintWriter(System.out);
        reader = new FastReader();
        int n = reader.readInt();
        long target = reader.readInt();
        long[] arr = reader.readLongs(n);
        long[] fourSomeIndexes = getFourSomeIndexes(arr, target);

        if (fourSomeIndexes == null) writer.println("IMPOSSIBLE");
        else writer.printf("%d %d %d %d\n", fourSomeIndexes[0], fourSomeIndexes[1], fourSomeIndexes[2], fourSomeIndexes[3]);


        writer.close();

    }

    public static void main(String[] args) {
        new entry_4996429().solve();
    }
}