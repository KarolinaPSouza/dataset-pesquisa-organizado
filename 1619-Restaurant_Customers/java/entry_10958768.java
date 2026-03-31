import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class entry_10958768 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        long count = 0, maxCount = 0;
        List<ArrayFortask> arrayFortasks = new ArrayList<>(2 * n);

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long start = Long.parseLong(tokenizer.nextToken());
            long end = Long.parseLong(tokenizer.nextToken());

            arrayFortasks.add(new ArrayFortask(start, 1));
            arrayFortasks.add(new ArrayFortask(end, -1));
        }
        Collections.sort(arrayFortasks, (e1, e2) -> {
            if (e1.time == e2.time) {
                return Long.compare(e1.sum, e2.sum);
            } else {
                return Long.compare(e1.time, e2.time);
            }
        });

        for (ArrayFortask event : arrayFortasks) {
            count += event.sum;
            maxCount = Math.max(maxCount, count);
        }

        System.out.println(maxCount);
    }
}
class ArrayFortask {
    long time;
    long sum;

    public ArrayFortask(long time, long sum) {
        this.time = time;
        this.sum = sum;
    }
}