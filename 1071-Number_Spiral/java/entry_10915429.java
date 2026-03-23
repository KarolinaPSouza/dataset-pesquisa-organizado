import java.io.*;
public class entry_10915429 {

    public static void main(String[] args) throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        int t = Integer.parseInt(bufferedReader.readLine());
        while (t>0){
            String[] input = bufferedReader.readLine().split(" ");
            valueFinder(Long.parseLong(input[0]),Long.parseLong(input[1]));

            t--;
        }


    }

    private static void valueFinder(long x, long y) {
        long val;
        if ( y > x){
            val = y % 2 == 0 ? ((y-1)*(y-1))+1+(x-1)       : (y*y)-(x-1);
        }else {
            val = x % 2 == 0 ? ((x-1)*(x-1))+1+(x-1)+(x-y) : (x*x)-(x-1)-(x-y);
        }
        System.out.println(val);
    }

}