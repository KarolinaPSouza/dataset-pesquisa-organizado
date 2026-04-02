import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class entry_15740112 {
    public static void main(String[] args) throws  Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int no = Integer.parseInt(st.nextToken());




        int[] ar = new int[no];
        boolean flag=false;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < no; i++) {
            ar[i] = Integer.parseInt(st.nextToken());
            if(ar[i]>0){
                flag=true;
            }
        }
        long mx=Long.MIN_VALUE;
        long sum=0;

        for(int i=0;i<no;i++){
           sum+=ar[i];
           if(flag==true && sum<0){
               sum=0;
           }
           if(flag==true && sum>mx){
               mx=sum;
           }
           if(flag==false && ar[i]>mx){
                mx=ar[i];
            }
        }
        System.out.print(mx);
    }
}