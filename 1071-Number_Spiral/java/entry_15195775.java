import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class NumberSpiral {
    public static void numberSearch(long r, long c, StringBuilder sb) {
        long res = 0;

        if(r == c)
        {
            res = (r * r - (r - 1));
        }
        else
        {
            long dia = Math.max(r, c);
            dia = dia * dia - (dia - 1);

            if(r > c)
            {
                if(r % 2 == 0)
                {
                    res = dia + (r - c);
                }
                else
                {
                    res = dia - (r - c);
                }
            }
            else if(c > r)
            {
                if(c % 2 == 0)
                {
                    res = dia - (c - r);
                }
                else
                {
                    res = dia + (c - r);
                }
            }
        }
        sb.append(res).append("\n");
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long t = Long.parseLong(br.readLine());

        while(t > 0)
        {   
            String[] parts = br.readLine().split(" ");
            // number of rows
            long y = Long.parseLong(parts[0]);
            // number of columns
            long x = Long.parseLong(parts[1]);
            numberSearch(y, x, sb);
            t--;
        }
        System.out.print(sb.toString());
    }
}