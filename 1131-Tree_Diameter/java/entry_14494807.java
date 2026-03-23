import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// AC but TLE again, fuck the judge.
public class entry_14494807 {

    static int mod = 1000000007;

    public static class Node {
        int id;
        int depth1;
        int depth2;
        List<Node> nodes = new ArrayList<>();

        public Node(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {
        FastReader reader = new FastReader();
        FastWriter writer = new FastWriter();

        int n = reader.readSingleInt();
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < n - 1; i++) {
            int[] e = reader.readIntArray(2);
            nodes[e[0] - 1].nodes.add(nodes[e[1] - 1]);
            nodes[e[1] - 1].nodes.add(nodes[e[0] - 1]);
        }

        boolean[] seen = new boolean[n];
        ArrayDeque<Node> stk = new ArrayDeque<>();

        nodes[0].depth1 = 0;
        stk.addFirst(nodes[0]);
        seen[0] = true;

        while (!stk.isEmpty()) {
            var cur = stk.removeFirst();
            for (int i = 0; i < cur.nodes.size(); i++) {
                var nxt = cur.nodes.get(i);
                if (seen[nxt.id]) {
                    continue;
                }
                seen[nxt.id] = true;
                nxt.depth1 = cur.depth1 + 1;
                stk.addFirst(nxt);
            }
        }

        Node start = null;
        int maxDepth = -1;
        for (int i = 0; i < n; i++) {
            var depth = nodes[i].depth1;
            if(depth > maxDepth){
                maxDepth = depth;
                start = nodes[i];
            }
        }

        seen = new boolean[n];
        stk = new ArrayDeque<>();

        start.depth2 = 0;
        stk.addFirst(start);
        seen[start.id] = true;

        int max = 0;
        while (!stk.isEmpty()) {
            var cur = stk.removeFirst();
            for (int i = 0; i < cur.nodes.size(); i++) {
                var nxt = cur.nodes.get(i);
                max = Math.max(max, cur.depth2);
                if (seen[nxt.id]) {
                    continue;
                }
                seen[nxt.id] = true;
                nxt.depth2 = cur.depth2 + 1;
                stk.addFirst(nxt);
            }
        }

        writer.writeSingleInteger(max);
    }


    public static void mergeSort(int[] a, int n) {
        if (n < 2) {
            return;
        }
        int mid = n / 2;
        int[] l = new int[mid];
        int[] r = new int[n - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = a[i];
        }
        for (int i = mid; i < n; i++) {
            r[i - mid] = a[i];
        }

        mergeSort(l, mid);
        mergeSort(r, n - mid);

        merge(a, l, r, mid, n - mid);
    }


    public static void merge(int[] a, int[] l, int[] r, int left, int right) {

        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (l[i] <= r[j]) {
                a[k++] = l[i++];
            } else {
                a[k++] = r[j++];
            }
        }
        while (i < left) {
            a[k++] = l[i++];
        }
        while (j < right) {
            a[k++] = r[j++];
        }
    }


    public static class FastReader {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;


        public int readSingleInt() throws IOException {
            return Integer.parseInt(reader.readLine());
        }

        public int[] readIntArray(int numInts) throws IOException {
            int[] nums = new int[numInts];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < numInts; i++) {
                nums[i] = Integer.parseInt(tokenizer.nextToken());
            }
            return nums;
        }

        public long[] readLongArray(int numInts) throws IOException {
            long[] nums = new long[numInts];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < numInts; i++) {
                nums[i] = Long.parseLong(tokenizer.nextToken());
            }
            return nums;
        }

        public String readString() throws IOException {
            return reader.readLine();
        }

    }


    public static class FastWriter {

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));


        public void writeSingleInteger(int i) throws IOException {
            writer.write(Integer.toString(i));
            writer.newLine();
            writer.flush();
        }

        public void writeSingleLong(long i) throws IOException {
            writer.write(Long.toString(i));
            writer.newLine();
            writer.flush();
        }

        public void writeIntArrayWithSpaces(int[] nums) throws IOException {
            for (int i = 0; i < nums.length; i++) {
                writer.write(nums[i] + " ");
            }
            writer.newLine();
            writer.flush();
        }

        public void writeLongArrayWithSpaces(long[] nums) throws IOException {
            for (int i = 0; i < nums.length; i++) {
                writer.write(nums[i] + " ");
            }
            writer.newLine();
            writer.flush();
        }

        public void writeIntArrayListWithSpaces(ArrayList<Integer> nums) throws IOException {
            for (int i = 0; i < nums.size(); i++) {
                writer.write(nums.get(i) + " ");
            }
            writer.newLine();
            writer.flush();
        }

        public void writeIntArrayWithoutSpaces(int[] nums) throws IOException {
            for (int i = 0; i < nums.length; i++) {
                writer.write(Integer.toString(nums[i]));
            }
            writer.newLine();
            writer.flush();
        }

        public void writeString(String s) throws IOException {
            writer.write(s);
            writer.newLine();
            writer.flush();
        }

    }


}