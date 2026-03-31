import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class entry_3333530 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(in.readLine());
        PriorityQueue<Time> queue = new PriorityQueue<>();
        for (int i = 0; i < nums; i++) {
            StringTokenizer split = new StringTokenizer(in.readLine());
            queue.add(new Time(Integer.parseInt(split.nextToken()), 1));
            queue.add(new Time(Integer.parseInt(split.nextToken()), -1));
        }

        int sum = 0;
        int maxSum = 0;

        while (!queue.isEmpty()) {
            sum += queue.poll().value;
            if (sum > maxSum) maxSum = sum;
        }

        System.out.println(maxSum);
    }
}

class Time implements Comparable {
    int time;
    int value;

    Time(int time, int value) {
        this.time = time;
        this.value = value;
    }

    public int compareTo(Object o) {
        return time - ((Time) o).time;
    }
}