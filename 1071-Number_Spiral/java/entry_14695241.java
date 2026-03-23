import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_14695241 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String[] strs = br.readLine().split(" ");
            long x = Integer.parseInt(strs[0]);
            long y = Integer.parseInt(strs[1]);
            if(x==y) {
                long l = x*x-x+1;
                System.out.println(l);
            }else if (x>y) {
                long l = x*x;
                if(x%2==0){l=l-y+1;}
                else {l=(x-1)*(x-1)+y;}
                System.out.println(l);
            } else {
                long l = y*y;
                if(y%2==0) {l=(y-1)*(y-1)+x;}
                else {l=l-x+1;}
                System.out.println(l);
            }
        }
    }
}