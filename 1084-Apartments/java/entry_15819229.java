import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class entry_15819229 {
    public static void main(String[] args) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st1 = new StringTokenizer(br.readLine()); 
       int n1 = Integer.parseInt(st1.nextToken());
       int n2 = Integer.parseInt(st1.nextToken());
       int n3 = Integer.parseInt(st1.nextToken());
       StringTokenizer st2 = new StringTokenizer(br.readLine()); 
       StringTokenizer st3 = new StringTokenizer(br.readLine());
       int[] arr1 = new int[n1];
       int[] arr2 = new int[n2];
       for(int i = 0; i < n1; i++){
        arr1[i] = Integer.parseInt(st2.nextToken());
       }
       for(int i = 0; i < n2; i++){
        arr2[i] = Integer.parseInt(st3.nextToken());
       }

       Arrays.sort(arr1);
       Arrays.sort(arr2);
       int i = 0, j = 0, count = 0;
       while ( i < n1 && j < n2){
                if(Math.abs(arr1[i] - arr2[j]) <= n3){
                    count++;
                    i++;
                    j++;
                }
                else if(arr1[i] > arr2[j]){
                    j++;
                }
                else{
                    i++;
                }
       }
       System.out.println(count);
    }
}