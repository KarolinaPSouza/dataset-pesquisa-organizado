import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class entry_7987862 {


    static final int MOD = 1_000_000_000 + 7;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine = br.readLine();
        String secondLine = br.readLine();

        int target = Integer.parseInt(firstLine.split(" ")[1]);
        int[] coinValuesArray = Arrays.stream(secondLine.split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] table = new int[target + 1];
        table[0] = 1;
        for (int tempTarget = 0; tempTarget <= target; tempTarget++) {
            if (table[tempTarget] != 0) {
                for (int coinValue : coinValuesArray) {
                    int nextTarget = tempTarget + coinValue;
                    if (nextTarget <= target) {
                        table[nextTarget] = (table[nextTarget] + table[tempTarget]) % MOD;
                    }
                }
            }
        }
        System.out.println(table[target]);
    }


}