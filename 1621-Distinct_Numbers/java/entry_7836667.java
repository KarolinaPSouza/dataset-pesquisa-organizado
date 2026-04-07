import java.util.*;

public class entry_7836667 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int arr[] = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        Set<Integer> ans = new HashSet<>();
        for(int i=0; i<n; i++){
            ans.add(arr[i]);
        }
        System.out.println(ans.size());
    }
}