import java.io.*;
import java.util.*;
public class entry_5457483 {
    public static void main(String[] args) throws Exception {
        Reader reader = new Reader();
        int n = reader.nextInt();
        int k = reader.nextInt();
        int[][] movie = new int[n][2];
        for (int i = 0; i < n; i++) {
            movie[i][0] = reader.nextInt();
            movie[i][1] = reader.nextInt();
        }
        mergeSort(movie);
        NavigableMap<Integer,Integer> map = new TreeMap<>();
        map.put(0, k);
        int endTime = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            Integer lowerKey = map.lowerKey(movie[i][0]+1);
            if (lowerKey != null) {
                count++;
                removeKey(map, lowerKey);
                addKey(map, movie[i][1]);
            }
        }
        reader.println(count);
        reader.close();
    }
    public static void addKey(NavigableMap<Integer,Integer> map, int key) {
        map.put(key, map.getOrDefault(key, 0)+1);
    }
    public static void removeKey(NavigableMap<Integer,Integer> map, int key) {
        int value = map.get(key);
        if (value == 1) {
            map.remove(key);
        } else {
            map.put(key, value-1);
        }
    }
    public static void mergeSort(int[][] nums) {
        int[][] arr = new int[nums.length][2];
        for (int len = 2; len/2 < nums.length; len<<=1) {
            for (int i = 0; i < nums.length; i+=len) {
                // Perform merge from the len's elements
                int leftEnd = Math.min(i+len/2-1, nums.length-1), rightEnd = Math.min(i+len-1, nums.length-1);
                for (int k = i, left = i, right = i+len/2; k < Math.min(len+i, nums.length); k++) {
                    if (left <= Math.min(leftEnd, nums.length-1) && (right > rightEnd || nums[left][1] < nums[right][1])) {
                        arr[k][0] = nums[left][0];
                        arr[k][1] = nums[left++][1];
                    } else {
                        arr[k][0] = nums[right][0];
                        arr[k][1] = nums[right++][1];
                    }
                }
                for (int j = i; j < i+Math.min(len, nums.length-i); j++) {
                    nums[j][0] = arr[j][0];
                    nums[j][1] = arr[j][1];
                }
            }
        }
    }
    static class Reader extends PrintWriter {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
        public Reader() {
            super(System.out);
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        public Reader(String fileName) throws IOException {
            super(new File(fileName+".out"));
            din = new DataInputStream(new FileInputStream(fileName+".in"));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ') c = read();
            boolean neg = (c == '-');
            if (neg) c = read();
            do {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
            if (neg) return -ret;
            return ret;
        }
    }
}