import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_11304426 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[][] mat = new int[n][2];
        for (int i =0; i < n; i++) {
         String line = bf.readLine();
         StringTokenizer st = new StringTokenizer(line);
         mat[i][0] = Integer.parseInt(st.nextToken());
         mat[i][1] = Integer.parseInt(st.nextToken());  
        }
        int[] arr = new int[n];
        int[] dep = new int[n];
        for(int i = 0; i<n;i++){
            arr[i] = mat[i][0];
            dep[i] = mat[i][1];
        }
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0; int j =0;
        int currentCustomers = 0;
        int max = 0;
        while(i<n && j<n){
            if(arr[i] <= dep[j]){
                currentCustomers++;
                max = Math.max(max, currentCustomers);
                i++;
            }
            else{
                j++;
                currentCustomers--;
            }
        }
        System.out.println(max);
    }
}