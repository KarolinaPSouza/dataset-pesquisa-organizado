import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_12631222 {
    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());
        int noofcoins=Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());

        long[] arr=new long[n+1];
        arr[0]=1;

        st=new StringTokenizer(br.readLine());
        int[]coins=new int[noofcoins];
        for(int i=0;i<noofcoins;i++)
        {
            coins[i]=Integer.parseInt(st.nextToken());
        }

        for(int c:coins)
        {
            for(int x=1;x<arr.length;x++)
            {
                if(x-c>=0)
                {
                    arr[x]+=arr[x-c];
                    arr[x]%=1000000007;
                }
            }
        }

        System.out.print(arr[n]%1000000007);
        br.close();
    }
}