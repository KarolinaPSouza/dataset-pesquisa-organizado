import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class entry_13774902 {
    static int[] price,page;
    public static void main(String ar[])throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        //System.out.println("enter n and x");
        st=new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int[] prev=new int[x+1];
        int[] curr=new int[x+1];


        price=new int[n];
        page=new int[n];
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        price[i] = Integer.parseInt(st.nextToken());
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++)
        page[i] = Integer.parseInt(st.nextToken());


        for(int budget=0;budget<=x;budget++)
        if(price[0]<=budget)
        prev[budget]=page[0];

        for(int ind=1;ind<n;ind++)
        {
            for(int budget=0;budget<=x;budget++)
            {   
                int skip=0,pick=0;
                skip=prev[budget];

                if(budget>=price[ind])
                pick=page[ind]+prev[budget-price[ind]];

                curr[budget]=Math.max(skip,pick);
            }
            int[] temp = prev;
            prev = curr;
            curr = temp;
        }
        System.out.println(prev[x]);
    }
}