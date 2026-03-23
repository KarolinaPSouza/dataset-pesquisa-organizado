import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class entry_15734695 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] values = br.readLine().trim().split(" ");

        int n = Integer.parseInt(values[0]);
        int m = Integer.parseInt(values[1]);

        int k = Integer.parseInt(values[2]);

        int [] d_apart = new int[n];

        int [] apart = new int[m];

        String [] d_value = br.readLine().trim().split(" ");


        for(int i =0 ; i<n ;i++){
            d_apart[i] = Integer.parseInt(d_value[i]);

        }

        String [] a_value = br.readLine().trim().split(" ");
        for(int i =0 ; i<m ;i++){
            apart[i] = Integer.parseInt(a_value[i]);

        }





        int ans = Apartment_alot(apart, d_apart, k);
        System.out.println(ans);
    }

    public static int Apartment_alot (int [] apart, int [] d_apart, int k ){
        Arrays.sort(apart);
        Arrays.sort(d_apart);


        int n = d_apart.length;

        int m = apart.length;

        int i = 0 ;
        int j = 0 ;
        int count = 0;

        while(i < n && j < m){

            if(Math.abs(d_apart[i] - apart[j]) <= k){
                count++;
                i++;
                j++;
            }
            else if(apart[j] < d_apart[i] - k){
                j++;
            }
            else{
                i++;
            }
        }
        return count;

    }
}