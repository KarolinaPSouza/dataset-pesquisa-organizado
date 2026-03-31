import java.io.*;
import java.util.*;
public class entry_15587737 {
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        long[] a1=new long[n];
        long[] a2=new long[n];
        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            a1[i]=Long.parseLong(st.nextToken());
            a2[i]=Long.parseLong(st.nextToken());
        }
        Arrays.sort(a1);
        Arrays.sort(a2);
        int i=0,j=0,ans=0,count=0;
        while(i<a1.length){
            count++;
            while(j<a2.length && a2[j]<=a1[i]){
                count--;
                j++;
            }
            ans=Math.max(ans,count);
            i++;
        }
        System.out.println(ans);
    }
}