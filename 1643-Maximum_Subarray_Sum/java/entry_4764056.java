import java.util.*;

public class entry_4764056 {   
 public static void main(String[] args) {

  Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long nums[] = new long[n];
        for(int i = 0; i < n; i++) nums[i] = sc.nextLong();

        long maxSum = nums[0], currSum = nums[0];

  for(int i = 1; i < nums.length; i++) {

   if(nums[i] + currSum > nums[i]) {
    currSum = currSum + nums[i];
    if(currSum > maxSum) {
     maxSum = currSum;
    }
   } else{
    currSum = nums[i];
                if(currSum > maxSum) {maxSum = currSum;}
   }
  }

        System.out.println(maxSum);
    }
}