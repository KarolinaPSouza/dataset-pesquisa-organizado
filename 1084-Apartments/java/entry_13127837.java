import java.io.*;
import java.util.*;

public class entry_13127837 {
    private static final FastScanner fs = new FastScanner();
    private static final PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();

        long[] applicants = new long[n];
        long[] apartments = new long[m];

        /*
     If b[j] is within [a[i] - k, a[i] + k], then:
 b[j] ≥ a[i] - k → a[i] - b[j] ≤ k
 b[j] ≤ a[i] + k → b[j] - a[i] ≤ k
 Thus, |a[i] - b[j]| ≤ k.
 Conversely, if |a[i] - b[j]| ≤ k, then:
 -k ≤ a[i] - b[j] ≤ k
 Which rearranges to a[i] - k ≤ b[j] ≤ a[i] + k.
         * 
         * 
         * 
         * 
         */
        for (int i = 0; i < n; i++) {
            applicants[i] = fs.nextLong();
        }
        for (int i = 0; i < m; i++) {
            apartments[i] = fs.nextLong();
        }
        quickSort(applicants, 0, n-1);
        quickSort(apartments, 0, m-1);

        int i = 0, j = 0, count = 0;

        while (i < n && j < m) {
            long diff = applicants[i] - apartments[j];
            if (Math.abs(diff) <= k) {
                count++;
                i++;
                j++;
            } else if (applicants[i]+k < apartments[j]) {
                i++;
            } else {
                j++;
            }
        }

        out.println(count);
        out.close();

    }

    // Optimized FastScanner
    static class FastScanner {
        private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private StringTokenizer st = new StringTokenizer("");

        public String next() {
            while (!st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        } 

        public int[] readArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public String nextLine() {
            try {
                return br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
                return "";
            }
        }
    }

    // Utility methods
    public static void sort(int[] arr) {
        shuffleArray(arr); // Shuffle for performance with quicksort
        Arrays.sort(arr);
    }

    private static void shuffleArray(int[] arr) {
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
    }

    public static void quickSort(long[] arr, int low, int hi){
        if(low < hi){
            int p = partition(arr, low, hi);
            quickSort(arr, low, p);
            quickSort(arr, p+1, hi);
        }
    }

    public static int partition(long[] arr, int low, int hi){
        int i = low-1;
        int j = hi+1;
        long pivot = arr[low];

        while(true){

            do{
                i++;
            }while(arr[i] < pivot);

            do{
                j-=1;
            }while(arr[j] > pivot);

            if(i>=j) return j;

            swap(arr, i, j);
        }
    }

    public static void swap(long[] arr, int i, int j){
        long temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}