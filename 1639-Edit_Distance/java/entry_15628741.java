import java.util.*;

public class entry_15628741 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();
        String t = in.next();

        int n = s.length();
        int m = t.length();

        int[] prev = new int[m+1];
        int[] curr = new int[m+1];

        for (int j = 0; j <= m; j++) {
            prev[j] = j;
        }

        for (int i = 1; i <= n; i++) {
            curr[0] = i;
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i-1)==t.charAt(j-1)){
                    curr[j] = prev[j-1];
                }else{
                    curr[j] = 1+ Math.min(prev[j-1], Math.min(prev[j], curr[j-1]));
                }
            }
            prev = curr;
            curr = new int[m+1];
        }
        System.out.println(prev[m]);
    }
}