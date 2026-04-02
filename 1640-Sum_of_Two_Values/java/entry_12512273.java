import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class entry_12512273 {

    public static void main(String[] args)throws IOException{


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tok = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(tok.nextToken());
        int x = Integer.parseInt(tok.nextToken());

        tok = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        for(int i=0; i<n; i++){
            a[i] = Integer.parseInt(tok.nextToken());
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean flag = false;
        for(int i=0; i<n; i++){
            if(map.containsKey(x - a[i])){
                System.out.println((map.get(x - a[i])+1) + " " + (i+1));
                flag = true;
                break;
            }
            else{
                map.put(a[i], i);
            }
        }

        if(!flag){
            System.out.println("IMPOSSIBLE");
        }
    }
}