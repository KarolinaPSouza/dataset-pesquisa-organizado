import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class entry_405330 {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(br.readLine());
        for (int k = 0; k < number; k++) {
            String s=br.readLine();
            String[]  s1=s.split(" ");
            long i =Integer.parseInt(s1[0]);
            long j =Integer.parseInt(s1[1]);
            long max = Math.max(i, j);
            System.out.println((j - i) * (max % 2 * 2 - 1) + max * max - max + 1);
        }
    }
}