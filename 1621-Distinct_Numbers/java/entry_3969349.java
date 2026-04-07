import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class entry_3969349 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer.parseInt(br.readLine());
        Set<Integer> distinctIntegers = new HashSet<>();
        String line = br.readLine();
        for(String x : line.split(" ")) {
            distinctIntegers.add(Integer.parseInt(String.valueOf(x)));
        }
        System.out.println(distinctIntegers.size());

    }
}