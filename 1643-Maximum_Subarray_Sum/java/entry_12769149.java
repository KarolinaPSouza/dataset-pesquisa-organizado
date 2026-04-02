import java.util.*;
import java.io.*;
public class entry_12769149 {
    public static void main(String [] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n= Integer.parseInt(st.nextToken());
        long [] nums= new long[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            nums[i]= Long.parseLong(st.nextToken());
        }
        long sum=0;
        long maxsum=Integer.MIN_VALUE;
        int j=0;
        while(j<nums.length){
         sum=Math.max(nums[j],sum+nums[j]);
            maxsum=Math.max(maxsum,sum);
            j++;
        }
        System.out.println(maxsum);
    }
}