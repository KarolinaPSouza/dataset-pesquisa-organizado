import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class entry_11765904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] inputs=br.readLine().split(" ");
        int n=Integer.parseInt(inputs[0]);
        int target=Integer.parseInt(inputs[1]);
        HashMap<Integer,Integer> map=new HashMap<>();
        String[] arr=br.readLine().split(" ");
        for(int i=0;i<n;i++){
            int num=Integer.parseInt(arr[i]);
            int complement=target-num;
            if(map.containsKey(complement)){
                System.out.println((map.get(complement)+1)+" "+(i+1));
                break;
            }
            map.put(num,i);
            if(i==n-1){
                System.out.println("IMPOSSIBLE");
            }
        }
    }
}