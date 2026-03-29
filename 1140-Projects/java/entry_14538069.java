import java.util.*;
import java.io.*;
public class entry_14538069 {
 static int arr[][];
 static Long dp[];
 static int n;
    public static void main(String args[]) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        n= Integer.parseInt(st.nextToken());
        arr= new int[n][3];
        for(int i=0;i<n;i++){
            st= new StringTokenizer(br.readLine());
            arr[i][0]= Integer.parseInt(st.nextToken());
            arr[i][1]= Integer.parseInt(st.nextToken());
            arr[i][2]= Integer.parseInt(st.nextToken());
        }
        dp= new Long[n];
        Arrays.sort(arr,(a,b)-> Integer.compare(a[0], b[0]));
        System.out.print(solver(0));
    }
    public static long solver(int idx){
        if(idx==n) return 0;
        if(dp[idx]!=null) return dp[idx];
        long take=0;
        long notake= solver(idx+1);
        //   if(prev==-1 || arr[prev][1]<arr[idx][0]) 
          take= arr[idx][2]+ solver(findidx(idx,arr));
          return  dp[idx]=Math.max(take,notake);
    }
    public static int findidx(int idx,int arr[][]){
        int target= arr[idx][1];
        int low=0;
        int high= arr.length;
        while(low< high){
              int mid= low +(high-low)/2;
              if(arr[mid][0]<=target) low= mid+1;
              else high= mid;
        }
        return low;
    }

}