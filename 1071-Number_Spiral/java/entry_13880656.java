import java.io.*;
import java.util.*;

public class entry_13880656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            StringTokenizer st= new StringTokenizer(br.readLine());
            long x,y;
            x = Long.parseLong(st.nextToken());
            y = Long.parseLong(st.nextToken());

            long ans = 0;

            if (x == y) {
                ans = x * x - x + 1;//ok
            }
            else if (x > y) {
                if (x % 2 == 0) {
                    ans = x * x - y + 1; //ok
                }
                else {
                    ans = x * x - 2*x+y+1;
                }
            }
            else {
                if (y % 2 == 0) {
                    ans = y * y - 2*y +x + 1;
                }
                else {
                    ans = y * y - x +1; //ok
                }
            }

            System.out.println(ans);
        }
    }
}