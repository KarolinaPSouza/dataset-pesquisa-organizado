import java.util.*;
public class entry_13875810 {
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       int n = sc.nextInt();
       int x = sc.nextInt();

       int arr [] = new int [n];

       for(int i=0; i<n ;i++){
           arr[i] = sc.nextInt();
       }


       int prev [] = new int [x+1];
       int curr [] = new int [x+1];

       prev[0] = 0;
       for(int i=1; i<=x; i++){
           if(i % arr[0] == 0) prev[i] = i / arr[0];
           else prev[i] = (int) 1e9;
       }

       for(int i=1; i<=n ;i++){
           for(int j=1; j<=x; j++){

               int notTake = prev[j];
               int take = (int) 1e9;

               if(j - arr[i-1] >= 0) {
                   take = 1 + curr[j - arr[i-1]];
               }

               curr[j] = Math.min(take, notTake);


           }
           prev = Arrays.copyOf(curr, x+1);
       }

       System.out.println(curr[x] == (int)1e9 ? -1 : curr[x]);



    }
}
