import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_14969581 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            String[] parts = br.readLine().split(" ");
            long y = Long.parseLong(parts[0]);
            long x = Long.parseLong(parts[1]);
            long n = Math.max(x, y);
            long ans;
            if (n % 2 == 0){
                if (y == n) ans = n * n - x + 1;
                else ans = (n - 1) * (n - 1) + y;
            }
            else {
                if (x == n) ans = n * n - y + 1;
                else ans = (n - 1) * (n - 1) + x;
            }
            System.out.println(ans);
        }
    }
}