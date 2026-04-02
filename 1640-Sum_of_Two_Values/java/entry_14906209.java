import java.io.*;
import java.util.*;

public class entry_14906209 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int sum=Integer.parseInt(st.nextToken());

        st=new StringTokenizer(br.readLine());

        HashMap<Integer, Integer>map=new HashMap<>();
        boolean f=false;
        int a=-1,b=-1;

        for(int i=0;i<n;i++){
            int x=Integer.parseInt(st.nextToken());

            if(map.containsKey(sum-x)){
                a=map.get(sum-x)+1;
                b=i+1;
                f=true;
                break;
            }
            map.put(x, i);
        }

        if(f){
            System.out.println(a+" "+b);
        } else {
            System.out.println("IMPOSSIBLE");
        }
    }
}