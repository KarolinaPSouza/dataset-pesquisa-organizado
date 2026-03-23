import java.io.*;

public class entry_11961898 {

    public static long getSpiralNumber(long x, long y){
        if(x>y){
            return x%2 == 0 ? x*x - y + 1 : (x - 1)*(x - 1) + y;
        }
        return y%2 == 0 ? (y - 1)*(y - 1) + x : y*y - x + 1;
    }

    public static void main(String args[]) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        for(int i = 0 ; i<t ; i++){
            String input[] = reader.readLine().split(" ");
            long x = Long.parseLong(input[0]);
            long y = Long.parseLong(input[1]);
            long spiralNumber = getSpiralNumber(x, y);
            System.out.println(spiralNumber);
        }
    }  
}