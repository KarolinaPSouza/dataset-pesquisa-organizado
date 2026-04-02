import java.util.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;



public class entry_12748201 {

    static int[] nums;
    static int[][] dp;
    public static int minCoins(int n,int sum){
        if(n<0||sum<0)return Integer.MAX_VALUE;
        if(sum==0)return 0;
        if(dp[n][sum]!=-1)return dp[n][sum];
        int ex=minCoins(n-1, sum);
        int inc=minCoins(n, sum-nums[n]);
        if(inc!=Integer.MAX_VALUE)inc++;
        return dp[n][sum]=Math.min(ex,inc);

    }

    public static void main(String[] args) {

        int n,sum;
        Reader fr=new Reader();
        n=fr.nextInt();sum=fr.nextInt();
        nums=new int[n];
        dp=new int[n][sum+1];
        for(int[] x:dp)Arrays.fill(x, Integer.MAX_VALUE);
        for(int i=0;i<n;i++){
            nums[i]=fr.nextInt();
        }
        int ans;
       // ans=minCoins(n-1,sum);
       //if(ans==Integer.MAX_VALUE)ans=-1;

       for(int i=0;i<n;i++)dp[i][0]=1;

       int[] dp1=new int[sum+1];
       Arrays.fill(dp1, Integer.MAX_VALUE);
       dp1[0]=0;
       for(int s=1;s<=sum;s++){

        for(int i=0;i<n;i++){
            if(s-nums[i]>=0&&dp1[s-nums[i]]!=Integer.MAX_VALUE)dp1[s]=Math.min(dp1[s],1+dp1[s-nums[i]]);
        }
       }
       if(dp1[sum]==Integer.MAX_VALUE)System.out.print(-1);
       else System.out.print(dp1[sum]);

    }
}



 class Reader extends PrintWriter {private InputStream stream;private byte[] buf=new byte[1<<16];private int curChar,numChars;public Reader(){this(System.in,System.out);}public Reader(InputStream i,OutputStream o){super(o);stream=i;}public Reader(String i,String o) throws IOException{super(new FileWriter(o));stream=new FileInputStream(i);}private int nextByte(){if(numChars==-1)throw new InputMismatchException();if(curChar>=numChars){curChar=0;try{numChars=stream.read(buf);}catch(IOException e){throw new InputMismatchException();}if(numChars==-1)return-1;}return buf[curChar++];}public String next(){int c;do{c=nextByte();}while(c<=' ');StringBuilder res=new StringBuilder();do{res.appendCodePoint(c);c=nextByte();}while(c>' ');return res.toString();}public int nextInt(){int c;do{c=nextByte();}while(c<=' ');int sgn=1;if(c=='-'){sgn=-1;c=nextByte();}int res=0;do{if(c<'0'||c>'9')throw new InputMismatchException();res=10*res+c-'0';c=nextByte();}while(c>' ');return res*sgn;}public double nextDouble(){return Double.parseDouble(next());}}