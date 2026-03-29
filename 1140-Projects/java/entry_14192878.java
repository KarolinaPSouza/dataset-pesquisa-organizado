import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class entry_14192878 {

    static int mod = 1000000007;


    public static class Project {
        int pay;
        int start;
        int end;

        public Project(int pay, int start, int end) {
            this.pay = pay;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {

        FastReader reader = new FastReader();
        FastWriter writer = new FastWriter();

        int n = reader.readSingleInt();

        ArrayList<Project> projects = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int[] in = reader.readIntArray(3);
            projects.add(new Project(in[2], in[0], in[1]));
        }
        // should order by starting date, then ending date.

        // dp[i] = max money I can make when the (ordered) suffix from i is all projects there are left to attend.
        // dp[i] = Math.max(projects[i][2] + dp[j], dp[i+1])
        // where j is the first project occurring after i that doesn't overlap with j.

        projects.sort((o1, o2) -> {
            if (o1.start < o2.start) {
                return -1;
            } else {
                return 1;
            }
        });

        long[] sols = new long[n];
        sols[n - 1] = projects.get(n - 1).pay;

        for (int i = n - 2; i >= 0; i--) {

            int l = i;
            int r = n;
            //invariant is r a non overlapping project;
            while (l + 1 < r) {
                int m = l + (r - l) / 2;
                if (projects.get(i).end < projects.get(m).start) {
                    r = m;
                } else {
                    l = m;
                }
            }
            if (r == n) {
                sols[i] = Math.max(projects.get(i).pay, sols[i + 1]);
            } else {
                sols[i] = Math.max(projects.get(i).pay + sols[r], sols[i + 1]);
            }
        }

        writer.writeSingleLong(sols[0]);
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