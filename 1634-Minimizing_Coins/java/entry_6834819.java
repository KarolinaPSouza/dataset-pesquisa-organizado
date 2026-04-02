// package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class entry_6834819 {
    public static void main(String args[])throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int[] base=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] data=Arrays.stream(bf.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int target=base[1];
        Arrays.sort(data);
        long[] dp=new long[target+1];
        dp[0]=0;
        for(int i=1;i<=target;i++){
            dp[i]=Long.MAX_VALUE;
            for(int j=0;j<base[0];j++){
                if(i>=data[j] && dp[i-data[j]]!=Long.MAX_VALUE){
                     dp[i]=Math.min(dp[i],1+dp[i-data[j]]);
                }else if(i<data[j])break;
            }
        }
        if(dp[target]==Long.MAX_VALUE)dp[target]=-1;

        System.out.println(dp[target]);
    }
}