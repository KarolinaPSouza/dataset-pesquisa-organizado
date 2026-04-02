import java.util.*;
public class entry_12396636 {
    // Function to find the lower bound
    public static int lowerBound(int[] arr, int value) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] < value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }

    // Function to find the upper bound
    public static int upperBound(int[] arr, int value) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (arr[mid] <= value) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    public static void sieveOfEratosthenes(int n) {
        boolean prime[] = new boolean[n + 1];
        for (int i = 0; i <= n; i++)
            prime[i] = true;

        for (int p = 2; p * p <= n; p++) {
            if (prime[p] == true) {

                for (int i = p * p; i <= n; i += p)
                    prime[i] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i] == true)
                System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int a[] = new int[n];
       int max = Integer.MIN_VALUE;
       for(int i = 0; i < n; i++){
        a[i] = sc.nextInt();
        max = Math.max(max, a[i]);
       }
       long sum = 0;
       long m = 0;
       if(max <= 0){
        System.out.println(max);
       } else {
       for(int i = 0; i< n; i++){
        sum += a[i];
        sum = Math.max(0, sum);
        m = Math.max(m, sum);
       }
       System.out.println(m);
    }
    }
}