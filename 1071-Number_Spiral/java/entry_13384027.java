import java.io.*;
import static java.lang.System.out;
import java.util.StringTokenizer;

public class entry_13384027 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int numOfInt = Integer.parseInt(in.readLine());

        for (int i = 0; i < numOfInt; i++) {
            StringTokenizer tokenStream = new StringTokenizer(in.readLine());
            long Y = Integer.parseInt(tokenStream.nextToken());
            long X = Integer.parseInt(tokenStream.nextToken());

            if (Y >= X){
                if ((Y & 1) == 0)
                    out.println(Y*Y  - X + 1L);
                else
                    out.println((long)(Y-1)*(Y-1) + X);
            }
            else{
                if ((X & 1) == 0)
                    out.println((long)(X-1)*(X-1) + Y);
                else
                    out.println(X * X - Y + 1L);
            }
        }

        in.close();
    }
}