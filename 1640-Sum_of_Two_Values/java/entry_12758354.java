import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class entry_12758354 {
    public static void entry_12758354(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int sum = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        Pair[] arr = new Pair[size];
        for (int i = 0; i < size; i++) {
            arr[i] = new Pair(Integer.parseInt(st.nextToken()), i+1);
        }
        Arrays.sort(arr,Comparator.comparingInt(p -> p.value));

        for (int i = 0; i < size; i++) {
            int target = sum - arr[i].value, left = i+1, right = size-1;

            while(left <= right){
                int mid = (left + right) / 2;

                if(arr[mid].value == target){
                    System.out.println(arr[i].index + " " + arr[mid].index);
                    return;
                }
                else if(arr[mid].value < target){
                    left = mid +1;
                }
                else{
                    right = mid -1;
                }
            }
        }
        System.out.println("IMPOSSIBLE");

    }

    static class Pair{
        int value, index;
        Pair(int value,int index){
            this.value = value;
            this.index = index;
        }
    }
}