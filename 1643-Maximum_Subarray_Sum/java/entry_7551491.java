import java.util.*;
public class entry_7551491 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long [] arr = new long[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextLong();
        }

        long max = Long.MIN_VALUE;
        long currentMax = 0;

        for(int i = 0; i < n; i++){
            currentMax += arr[i];
            max = Math.max(max, currentMax);
            if(currentMax < 0){
                currentMax = 0;
            }
        }
        System.out.println(max);

    }
}