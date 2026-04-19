import java.util.*;
import java.io.*;
public class entry_16089742 {
    public static void main(String[] args)throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());
 
        st=new StringTokenizer(br.readLine());
        int[] arr=new int[n];
 
        for(int i=0;i<n;i++){
            arr[i]=Integer.parseInt(st.nextToken());
        }
        int mid=n/2;
 
        int[] a=Arrays.copyOfRange(arr,0,mid);
        int[] b=Arrays.copyOfRange(arr,mid,n);
 
        Map<Long,Integer>map=new HashMap<>();
 
        for(int mask=0;mask<1<<mid;mask++){
            long sum=0l;
            for(int i=0;i<mid;i++){
                if((mask & (1<<i))!=0){
                    sum+=a[i];
                }
            }
            map.put((long)sum,map.getOrDefault(sum,0)+1);
        }
        long res=0;
 
        for(int mask=0;mask<1<<(n-mid);mask++){
            long sum=0;
            for(int i=0;i<b.length;i++){
                if((mask & (1<<i))!=0){
                    sum+=b[i];
                }
            }
            res+=map.getOrDefault(k-sum,0);
        }
        System.out.println(res);
    }
}