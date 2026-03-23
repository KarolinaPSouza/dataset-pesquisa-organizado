import java.util.*;
import java.io.*;

public class entry_8514596 {
    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int t = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < t; i++) {
            String[] input = bufferedReader.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);
            long val;
            if ( y > x){
                if(y % 2 == 0)
                    val = ((y-1)*(y-1))+1+(x-1);
                else
                    val = (y*y)-(x-1);
            }else {
                if(x % 2 == 0)
                    val = ((x-1)*(x-1))+1+(x-1)+(x-y);
                else 
                    val = (x * x)-(x - 1)-(x - y);
            }
            System.out.println(val);
        }
    }
}