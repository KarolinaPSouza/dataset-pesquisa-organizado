import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class entry_11499962 {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Set<Long> set = new HashSet<Long>();

        String [] parts = reader.readLine().split(" ");

        for(int i = 0;i<n;i++) {
            set.add(Long.parseLong(parts[i]));
        }

        System.out.println(set.size());

    }
}