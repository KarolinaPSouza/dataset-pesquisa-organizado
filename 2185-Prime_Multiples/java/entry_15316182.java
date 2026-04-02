import java.io.*;
import java.util.*;

public class entry_15316182 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
         StringTokenizer st = new StringTokenizer(br.readLine());
        long n= Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long prime[]= new long[k];
          StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++)
        {
            prime[i]= Long.parseLong(st2.nextToken());
        }
        long ans=0;
        for(int i=1;i<(1<<k);i++)
        {
            long temp=n;
            int countset=0;
            for(int j=0;j<k;j++)
            {
                if((i & (1<<j))!=0)
                {
                    countset++;
                    temp/=prime[j];
                }
            }
            if((countset&1)==1) ans+=temp;
            else ans-=temp;

        }
        pw.println(ans);











        pw.close();
    }
}
