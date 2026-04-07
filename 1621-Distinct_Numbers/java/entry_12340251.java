import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class entry_12340251 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] strNumbers = br.readLine().split(" ");
        Set<Long> unique = new HashSet<>();
        for (int i = 0; i < n; i++) {
            unique.add(Long.parseLong(strNumbers[i]));
        }
        System.out.println(unique.size());
    }
}