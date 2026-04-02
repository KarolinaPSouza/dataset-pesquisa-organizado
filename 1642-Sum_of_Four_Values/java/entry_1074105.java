import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class entry_1074105 {


    public static void main(String args[] ) throws Exception {
        FastScanner scanner =new FastScanner();
        int n =scanner.nextInt();
        int target =scanner.nextInt();
        pair2 [] arr =new pair2[n];
        long sum =0;
        HashMap<Integer,Integer[] > map =new HashMap<>();
        for(int i=0;i<n;i++) {
            arr[i]=new pair2(scanner.nextInt(),i+1);
            sum+=arr[i].key;
        }

        sort(arr);
        long max=arr[n-1].key;
        if(target> 4*max){
            System.out.print("IMPOSSIBLE");
            return;
        }
        for(int i=0;i<n;i++) {
            Integer arr1[] ={arr[i].value,i};
            map.put(arr[i].key,arr1);
        }
        for(int i=0;i<n-3;i++) {
            if (i>0){
                if (arr[i].key==arr[i-1].key){
                    continue;
                }
            }
            if(arr[i].key>=target){
                break;
            }
            int cur1 =target-arr[i].key;
            for(int j=i+1;j<n-2;j++) {
                int cur2=cur1-arr[j].key;
                if(cur2<=0){
                    break;
                }
                else{
                    for (int c=j+1;c<n-1;c++){
                        int cur3=cur2-arr[c].key;
                        if(cur3<=0){
                            break;
                        }
                        else{
                            if(map.containsKey(cur3)){
                                Integer [] k =map.get(cur3);
                                if(k[1]>c){
                                    System.out.print(arr[i].value+" "+arr[j].value+" "+arr[c].value+" "+k[0]);
                                    return;
                                }
                            }
                        }
                    }

                }
            }
        }
        System.out.print("IMPOSSIBLE");
    }

    public static void sort(pair2[] arr) {

        if (null == arr || arr.length == 0) {
            return;
        }
        merge_sort(arr);

    }

    private static void merge_sort(pair2[] arr) {
        if(arr.length == 1) {
            return;
        }

        pair2[] leftarr = new pair2[arr.length/2];
        System.arraycopy(arr,0,leftarr,0,leftarr.length);

        pair2[] rightarr = new pair2[arr.length - leftarr.length];
        System.arraycopy(arr,leftarr.length,rightarr,0,rightarr.length);

        // recursion
        // sort the left array
        merge_sort(leftarr);

        // sor the right array
        merge_sort(rightarr);

        // merge the two arrays together
        merge(leftarr,rightarr,arr);
    }

    private static void merge(pair2[] left, pair2[] right, pair2[] arr) {
        pair2[] tmpArray = new pair2[arr.length];
        int leftpos = 0;
        int rightpos = 0;
        int tmppos = 0;

        while(leftpos < left.length && rightpos < right.length) {
            if(left[leftpos].key < right[rightpos].key) {
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

    }

     /*public static void sort(int[] arr) {
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
    public static class pair2 implements Comparable {
        int key;
        int value;

        pair2(int o,int i) {
            this.key = o;
            this.value = i;
        }

        @Override
        public int compareTo(Object o) {
           /* if(((pair2) o).key==key){
                return Integer.compare(((pair2) o).value,value);
            }*/
            return Integer.compare(key,((pair2) o).key);
        }
    }
    /*public static class pair2 implements Comparable {
        int in;
        int out;
        int index;
         pair2(int i,int o,int ind) {
            this.in = i;
            this.out = o;
            this.index=ind;
        }
         @Override
        public int compareTo(Object o) {
            if(((pair2) o).in==in){
                return Integer.compare(out,((pair2) o).out);
            }
            return Integer.compare(in,((pair2) o).in);
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