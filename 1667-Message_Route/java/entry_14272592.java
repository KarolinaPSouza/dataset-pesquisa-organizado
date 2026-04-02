import java.io.*;
import java.util.*;

public class entry_14272592 {

    static int mod = 1000000007;

    public static class Computer {
        int id;
        Computer parent;
        ArrayList<Computer> adj = new ArrayList<>();

        public Computer(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {

        FastReader reader = new FastReader();
        FastWriter writer = new FastWriter();

        int[] nm = reader.readIntArray(2);
        int n = nm[0], m = nm[1];

        Computer[] computers = new Computer[n];
        for (int i = 0; i < computers.length; i++) {
            computers[i] = new Computer(i + 1);
        }

        for (int i = 0; i < m; i++) {
            int[] connection = reader.readIntArray(2);
            computers[connection[0] - 1].adj.add(computers[connection[1] - 1]);
            computers[connection[1] - 1].adj.add(computers[connection[0] - 1]);
        }

        boolean[] seen = new boolean[computers.length];
        ArrayDeque<Computer> q = new ArrayDeque<>();

        q.addLast(computers[0]);
        seen[computers[0].id - 1] = true;

        while (!q.isEmpty()) {
            var comp = q.removeFirst();
            for (int i = 0; i < comp.adj.size(); i++) {
                var adj = comp.adj.get(i);
                if (!seen[adj.id - 1]) {
                    q.addLast(adj);
                    adj.parent = comp;
                    seen[adj.id - 1] = true;
                }
            }
        }

        if (computers[n - 1].parent == null) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        var current = computers[n - 1];

        ArrayList<Integer> ans = new ArrayList<>();

        while (current != null) {
            ans.add(current.id);
            current = current.parent;
        }


        System.out.println(ans.size());
        Collections.reverse(ans);
        writer.writeIntArrayListWithSpaces(ans);

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