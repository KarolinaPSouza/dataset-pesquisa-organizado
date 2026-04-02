import java.util.*;
public class entry_8093972
{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        long n=in.nextLong();
        long arr[]=new long[(int)n];
        for(int i=0;i<n;i++)
        {
            arr[i]=in.nextLong();
        }
        long csum=arr[0];
        long osum=arr[0];
        for(int i=1;i<n;i++)
        {
            if(csum>=0)
            {
                csum+=arr[i];
            }
            else
            {
                csum=arr[i];
            }
            osum=Math.max(osum,csum);
        }
        System.out.println(osum);
        in.close();
    }
}
