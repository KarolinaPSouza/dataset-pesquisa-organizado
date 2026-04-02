import java.util.*;
import java.io.*;

public class entry_15902044 {
    public static void main(String []args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int x=Integer.parseInt(st.nextToken());

        HashMap<Integer,Integer> map=new HashMap<>();
        st=new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            int val=Integer.parseInt(st.nextToken());
            int target=x-val;

            if(map.containsKey(target)){
                System.out.println(map.get(target)+" "+i);
                return;
            }
            map.put(val,i);
        }
        System.out.println("IMPOSSIBLE");
    }
}