import java.util.*;
public class entry_9340730 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++)arr[i]= sc.nextInt();
        long max = Integer.MIN_VALUE;long sum = 0;
        for (int i=0;i<n;i++){
            if(sum<0){
                sum = arr[i];
            }
            else sum+=arr[i];

            max = Math.max(max,sum);
        }
        System.out.println(max);
    }
}