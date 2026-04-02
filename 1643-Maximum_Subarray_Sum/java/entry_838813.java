import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_838813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] s=br.readLine().split(" ");
        String[] s1=br.readLine().split(" ");
        int n=Integer.parseInt(s[0].trim());
        int[] a=new int[n];
        for(int i=0;i<n;i++){
            a[i]=Integer.parseInt(s1[i].trim());
        }
        kadane(a,n);

    }



    public static void kadane(int[] a,int n){

        long res=a[0];
        long sum=a[0];
        for(int i=1;i<n;i++){
            sum=Math.max(a[i],sum+a[i]);
            res=Math.max(res,sum);
        }
        System.out.println(res);
    }





}