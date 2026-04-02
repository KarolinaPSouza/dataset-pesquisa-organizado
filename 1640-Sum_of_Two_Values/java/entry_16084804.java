import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class entry_16084804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][2];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = i+1;
        }

        Arrays.sort(arr, (a,b) -> (a[0]- b[0]));
        int l = 0, r =n-1;
        boolean found = false;

        while(l < r){
            int sum = arr[l][0]+arr[r][0];
            if(sum == target){
                found = true;
                break;
            }else if(sum > target){
                r--;
            }else{
                l++;
            }
        }

        if(!found){
            System.out.println("IMPOSSIBLE");
        }else{
            System.out.print(arr[l][1]+ " "+arr[r][1]);
        }

    }
}