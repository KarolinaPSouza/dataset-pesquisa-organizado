import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_13738504 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        HashMap<Long,Integer> map = new HashMap<>();
        boolean flag = false;

        for(int i=0;i<n;i++)
        {
            long k = Long.parseLong(st.nextToken());    
            if(map.containsKey(x-k))
            {
                System.out.println((map.get(x-k)+1)+" "+(i+1));
                flag = true;
                break;
            }
            else map.put(k,i);
        }
        if(!flag) System.out.println("IMPOSSIBLE");

    }
}