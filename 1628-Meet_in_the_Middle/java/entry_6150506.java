import java.io.BufferedInputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.IntConsumer;

class entry_6150506 {

    static class FastReader {  
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

    

    private PrintWriter writer;
    private FastReader reader;

    private void iterateSubsets(IntConsumer sumConsumer, int sumAccum, int[] arr, int idx){
        if (idx == arr.length){
            sumConsumer.accept(sumAccum);
            return;
        }
        boolean canAddCurrElem = sumAccum <= target-arr[idx];
        if (canAddCurrElem) iterateSubsets(sumConsumer, sumAccum + arr[idx], arr, idx+1);
        iterateSubsets(sumConsumer, sumAccum, arr, idx+1);
    }

    Map<Integer, Integer> sumCounts;
    long subsetSumCnt;
    int target;

    private void addToMap(int sum){
        sumCounts.compute(sum, (kwy, val) -> val == null ? 1 : val + 1);
    }

    private void count(int sum){
        Integer cnt = sumCounts.get(target - sum);
        if (cnt != null) subsetSumCnt += cnt;
    }

    private void solve(){
        writer = new PrintWriter(System.out);
        reader = new FastReader();

        int n = reader.readInt();
        target = reader.readInt();

        List<Integer> list = new ArrayList<>();

        long totalSmallerThanTargetSum = 0;
        for (int i = 0; i < n; i++){
            int x = reader.readInt();
            if (x == target){
                subsetSumCnt++;
            } else if (x < target){
                totalSmallerThanTargetSum += x;
                list.add(x);
            }
        }

        if (totalSmallerThanTargetSum < target){
            writer.println(subsetSumCnt);
        } else if (totalSmallerThanTargetSum == target){
            writer.println(1);
        } else {
            n = list.size();
            list.sort(Collections.reverseOrder());

            int[] firstHalf  = toPrimitiveArray(list.subList(0, n / 2));
            int[] secondHalf = toPrimitiveArray(list.subList(n / 2, n));
            sumCounts = new HashMap<>();

            iterateSubsets(this::addToMap, 0, firstHalf,  0);
            iterateSubsets(this::count,    0, secondHalf, 0);
            writer.println(subsetSumCnt);
        }

        writer.close();
    }

    private int[] toPrimitiveArray(List<Integer> list) {
        return list.stream().mapToInt(Integer::valueOf).toArray();
    }

    public static void main(String[] args) {
        new entry_6150506().solve();  
    }
}