import java.util.*;
import java.io.*;

class NumberSpiral {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int t =Integer.parseInt(br.readLine());
        StringBuilder sb=new StringBuilder();

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            long y = Long.parseLong(input[0]);
            long x = Long.parseLong(input[1]);

            long ans=0;

            if (y < x ){
                if(x % 2 == 0)    ans = (x - 1)*(x - 1) + y;
                else if (x % 2 == 1) ans = (x)*x - y + 1;
            }
             else{
                if(y % 2 == 0) ans = (y)*(y) - x + 1;
                else if (y % 2 == 1) ans = (y - 1)*(y - 1) + x;
             }

            sb.append(ans).append("\n");
        }

        System.out.print(sb);
    }
}