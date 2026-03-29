import java.io.*;
import java.util.*;

public class entry_14289610 {

    static int mod = 1000000007;

    public static class City {
        int id;
        ArrayList<City> adj = new ArrayList<>();
        ArrayList<City> adjReverse = new ArrayList<>();

        ArrayList<Integer> cost = new ArrayList<>();
        ArrayList<Integer> costReverse = new ArrayList<>();

        public City(int id) {
            this.id = id;
        }
    }

    public static void main(String[] args) throws IOException {

        FastReader reader = new FastReader();
        FastWriter writer = new FastWriter();

        int[] nm = reader.readIntArray(2);
        int n = nm[0], m = nm[1];

        /**
         * Idea.
         * 1. find the shorted path from source every other node
         *    (Dijkstra's algo)
         *
         * 2. Reverse the direction of edges and find the shortest path from
         *    sink to every other node.
         *    (Dijkstra's algo)
         *
         * 3. Go through each node, look at all edges, and see if
         *    applying the coupon brings down the min.
         */

        City[] cities = new City[n];
        for (int i = 0; i < n; i++) {
            cities[i] = new City(i);
        }

        for (int i = 0; i < m; i++) {
            int[] flight = reader.readIntArray(3);
            cities[flight[0] - 1].adj.add(cities[flight[1] - 1]);
            cities[flight[0] - 1].cost.add(flight[2]);

            cities[flight[1] - 1].adjReverse.add(cities[flight[0] - 1]);
            cities[flight[1] - 1].costReverse.add(flight[2]);
        }


        long[] forwardSols = process(cities, false);
        long[] backwardSols = process(cities, true);

        long min = forwardSols[n - 1];

        for (int i = 0; i < cities.length; i++) {
            var city = cities[i];

            long cost = Long.MAX_VALUE;
            for (int j = 0; j < city.adj.size(); j++) {
                var next = city.adj.get(j);
                long discountedFlight = city.cost.get(j) / 2L; // Applying the discount

                if (forwardSols[i] == Long.MAX_VALUE || backwardSols[next.id] == Long.MAX_VALUE) {
                    continue;
                }
                cost = Math.min(cost, forwardSols[i] + discountedFlight + backwardSols[next.id]);
            }
            min = Math.min(min, cost);
        }

        writer.writeSingleLong(min);
    }

    public static long[] process(City[] cities, boolean isReverse) {
        int n = cities.length;

        long[] sols = new long[n];
        var fill = Long.MAX_VALUE;
        Arrays.fill(sols, fill);

        boolean[] processed = new boolean[n];
        PriorityQueue<long[]> pq = new PriorityQueue<long[]>(Comparator.comparingLong(o -> o[1]));

        if (!isReverse) {
            sols[0] = 0;
            pq.add(new long[]{0, 0});
        } else {
            sols[n - 1] = 0;
            pq.add(new long[]{n - 1, 0});
        }

        while (!pq.isEmpty()) {
            long[] cc = pq.poll();
            City city = cities[(int) cc[0]];
            long cost = cc[1];

            if (processed[city.id]) {
                continue;
            }
            processed[city.id] = true;

            var adjacent = !isReverse ? city.adj : city.adjReverse;
            var costs = !isReverse ? city.cost : city.costReverse;

            for (int i = 0; i < adjacent.size(); i++) {
                var adj = adjacent.get(i);
                var totalCost = cost + costs.get(i);

                if (sols[adj.id] > totalCost) {
                    sols[adj.id] = totalCost;
                    pq.add(new long[]{adj.id, totalCost});
                }
            }
        }

        return sols;
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