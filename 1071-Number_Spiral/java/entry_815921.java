import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class entry_815921 {
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        String[] split;
        long size = Long.parseLong(input.readLine()), y, x;

        for (int i = 0; i < size; i++)
        {
            split = input.readLine().split(" ");
            y = Long.parseLong(split[0]);
            x = Long.parseLong(split[1]);

            pw.println((y <= x) ? (x-1)*((x-1)+1) + 1 + ((x % 2 == 0) ? y-x : x-y) : (y-1)*((y-1)+1) + 1 + ((y % 2 == 0) ? y-x : x-y));
        }

        pw.close();
    }
}