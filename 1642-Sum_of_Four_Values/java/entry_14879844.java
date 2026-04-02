import java.util.Arrays;
import java.util.Scanner;

public class entry_14879844 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int targetSum = scanner.nextInt();

        NumPos nums[] = new NumPos[n];
        for(int i=0; i<n; i++) {
            int val = scanner.nextInt();
            nums[i] = new NumPos(val, i+1);
        }

        sumOfThree(nums, targetSum);
    }

    private static void sumOfThree(NumPos[] nums, int targetSum) {
        Arrays.sort(nums, (a,b)-> Integer.compare(a.val, b.val));
        for(int i=0; i<nums.length-3; i++) {
            for(int j=i+1; j<nums.length-2; j++) {

                int remainingSum = targetSum - nums[i].val - nums[j].val;
                int thirdPos = j+1; 
                int forthPos = nums.length -1;
                while(thirdPos < forthPos){
                    if(nums[thirdPos].val + nums[forthPos].val == remainingSum) {
                        System.out.println( nums[i].pos +" " + nums[j].pos +  " " + nums[thirdPos].pos + " " + nums[forthPos].pos);
                        return;
                    }
                    else if (nums[thirdPos].val + nums[forthPos].val < remainingSum){
                        thirdPos++;
                    }
                    else{
                        forthPos--;
                    }
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}

class NumPos {
    int val;
    int pos;

    NumPos(int val, int pos) {
        this.val = val;
        this.pos = pos;
    }
}