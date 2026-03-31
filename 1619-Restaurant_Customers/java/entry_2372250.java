import java.io.*;
import java.util.*;

public class entry_2372250 {


    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {

        FastReader reader = new FastReader();
        FastWriter writer = new FastWriter();
        int n = reader.readSingleInt();
        int[][] times = new int[n][2];

        for(int i = 0; i<n; i++){
            times[i] = reader.readIntArray(2);
        }


        ArrayList<Node> nodes = new ArrayList<>();
        for(int i = 0; i<n; i++){
            Node a = new Node(times[i][0], true);
            Node b = new Node(times[i][1], false);
            nodes.add(a);
            nodes.add(b);
        }

        Collections.sort(nodes, new Comparator<Node>() {
            @Override
            public int compare(Node a, Node b) {
                if(a.time < b.time){
                    return -1;
                } else if(a.time == b.time){
                    if(a.s == true) return -1;
                    if(b.s == true) return 1;
                }
                return 1;
            }
        });


        int count = 0;
        int max = 0;
        for(int i = 0; i<nodes.size(); i++){
            if(nodes.get(i).s){
                count++;
                if(count > max){
                    max = count;
                }
            } else {
                count--;
            }
        }

        writer.writeSingleInteger(max);
    }


    public static class Node {

        boolean s = false;
        int time;

        public Node(int time, boolean s){
            this.time = time;
            this.s = s;
        }
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
            }
            else {
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
            for(int i = 0; i<numInts; i++){
                nums[i] = Integer.parseInt(tokenizer.nextToken());
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
            for(int i = 0; i<nums.length; i++){
                writer.write(nums[i] + " ");
            }
            writer.newLine();
            writer.flush();
        }

        public void writeIntArrayWithoutSpaces(int[] nums) throws IOException {
            for(int i = 0; i<nums.length; i++){
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