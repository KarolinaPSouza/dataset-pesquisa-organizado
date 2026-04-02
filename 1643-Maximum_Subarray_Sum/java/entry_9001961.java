import java.util.*;
public class entry_9001961 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();
        long a[]=new long[n];

        for(int i=0;i<n;i++){
            a[i]=sc.nextLong();
        }

        long maxSum=Integer.MIN_VALUE;
        long currSum=0;

        for(int i=0;i<n;i++){
            currSum+=a[i];
            //System.out.println("currSum: "+currSum);
            maxSum=Math.max(maxSum,currSum);
            //System.out.println("maxSum: "+maxSum);

            if(currSum<0){
                currSum=0;
            }
        }

        System.out.println(maxSum);
    }
}