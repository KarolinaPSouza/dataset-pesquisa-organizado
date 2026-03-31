import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class entry_1064081 {
    public static class pair implements Comparable {
        int time;
        boolean type;

        pair(int k, boolean b) {
            this.time = k;
            this.type = b;
        }

        @Override
        public int compareTo(Object o) {
          /*  if(((pair) o).t==key){
                return Integer.compare(((pair) o).val,val);
            }*/
            return Integer.compare(time,((pair) o).time);
        }
    }
    public static void main(String args[] ) throws Exception {
        FastScanner scanner =new FastScanner();
        int n =scanner.nextInt();
        PriorityQueue<pair> pq =new PriorityQueue<>();
        for(int i=0;i<n;i++){
            pq.add(new pair(scanner.nextInt(),true));
            pq.add(new pair(scanner.nextInt(),false));
        }
        int ans =0;
        int current=0;
        while (!pq.isEmpty()){
            pair tmp =pq.poll();
            if(tmp.type){
                current++;
                ans=Math.max(ans,current);
            }
            else{
                current--;
            }
        }
     System.out.print(ans);
    }
   /*
    static int binarySearch(List<Integer> arr, int x)
    {
        int l = 0, r = arr.size() - 1;
        int target =-1;
        while (l <= r) {
            int m = l + (r - l) / 2;
             // Check if x is present at mid
            if (arr.get(m) == x) {
                int tmp = arr.get(m);
                arr.remove(m);
                return tmp;
            }
            // If x greater, ignore left half
            if (arr.get(m) < x) {
                l = m + 1;
                target=m;
            }
                // If x is smaller, ignore right half
            else
                r = m - 1;
        }
         // if we reach here, then element was
        // not present then get smaller
        int tmp =-1;
        if(target!=-1){
            tmp=arr.get(target);
            arr.remove(target);
        }
        return tmp;
    }
    public static void sort(int[] arr) {
         if (null == arr || arr.length == 0) {
            return;
        }
        merge_sort(arr);
     }
     private static void merge_sort(int[] arr) {
        if(arr.length == 1) {
            return;
        }
         int[] leftarr = new int[arr.length/2];
        System.arraycopy(arr,0,leftarr,0,leftarr.length);
         int[] rightarr = new int[arr.length - leftarr.length];
        System.arraycopy(arr,leftarr.length,rightarr,0,rightarr.length);
         // recursion
        // sort the left array
        merge_sort(leftarr);
         // sor the right array
        merge_sort(rightarr);
         // merge the two arrays together
        merge(leftarr,rightarr,arr);
    }
     private static void merge(int[] left, int[] right, int[] arr) {
        int[] tmpArray = new int[arr.length];
        int leftpos = 0;
        int rightpos = 0;
        int tmppos = 0;
         while(leftpos < left.length && rightpos < right.length) {
            if(left[leftpos] < right[rightpos]) {
                tmpArray[tmppos]  = left[leftpos];
                leftpos++;
            } else {
                tmpArray[tmppos] = right[rightpos];
                rightpos++;
            }
            tmppos++;
        }
         // copy the rest of the left array
        while(leftpos < left.length) {
            tmpArray[tmppos] = left[leftpos];
            tmppos++;
            leftpos++;
        }
         // copy the rest of the right array
        while(rightpos < right.length) {
            tmpArray[tmppos] = right[rightpos];
            tmppos++;
            rightpos++;
        }
         for(int i=0; i < arr.length; i++) {
            arr[i] = tmpArray[i];
        }
     }*/

    static  class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }
        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
        long nextLong() throws IOException {
            return Long.parseLong(next());
        }
    }
}