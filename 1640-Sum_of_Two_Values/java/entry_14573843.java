import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class entry_14573843 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        HashMap<Integer,Integer> hm=new HashMap<>();
        int fidx=-1;
        int sidx=-1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int val = arr[i];
            if(hm.containsKey(x-val)){
                fidx=hm.get(x-val)+1;
                sidx=i+1;
                break;

            }
            hm.put(arr[i],i);


        }
        if(fidx==-1){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.println(fidx+" "+sidx);

        }




    }
}