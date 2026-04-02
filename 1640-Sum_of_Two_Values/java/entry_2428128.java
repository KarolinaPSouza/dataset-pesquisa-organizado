import java.io.*;
import java.util.StringTokenizer;

public class entry_2428128 {


    static int mod = 1000000007;

    public static void main(String[] args) throws IOException {

        FastReader reader = new FastReader();
        FastWriter writer = new FastWriter();
        int[] nx = reader.readIntArray(2);
        int n = nx[0], x = nx[1];

        int[] nums = reader.readIntArray(n);

        int[] duplicate = new int[n];
        for(int i = 0; i<n; i++){
            duplicate[i] = nums[i];
        }

        mergeSort(nums, n);

        int l = 0, r = n-1;

        while(l != r){
            if(nums[l] + nums[r] == x){
                break;
            }
            if(nums[l] + nums[r] > x){
                r--;
            } else {
                l++;
            }
        }

        if(l == r){
            writer.writeString("IMPOSSIBLE");
            return;
        }

        for(int i = 0; i<n; i++){
            if(nums[l] == duplicate[i]){
                writer.writeSingleIntegerNoNL(i+1);
                break;
            }
        }

        boolean seen = false;
        for(int i = 0; i<n; i++){
            if(nums[l] == nums[r] && nums[r] == duplicate[i] && !seen){
               seen = true;
               continue;
            }
            if(nums[l] == nums[r] && nums[r] == duplicate[i] && seen){
                writer.writeSingleInteger(i+1);
                break;
            }
            if(nums[r] == duplicate[i]){
                writer.writeSingleInteger(i+1);
                break;
            }
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

        public void writeSingleIntegerNoNL(int i) throws IOException {
            writer.write(Integer.toString(i) + " ");
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