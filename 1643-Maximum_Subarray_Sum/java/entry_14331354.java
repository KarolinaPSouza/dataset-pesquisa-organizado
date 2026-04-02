import java.util.*;

public class entry_14331354 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
       int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
              arr[i]=sc.nextInt();
        }
        long currsum=0,maxsum=Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            currsum=Math.max(currsum+arr[i],arr[i]);
            maxsum=Math.max(maxsum,currsum);
        }
        System.out.println(maxsum);
    }
}