import java.io.*;
import java.util.*;

public class entry_13684888 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");

        Set<Integer> distinctNumbers = new HashSet<>();
        for (int i = 0; i < n; i++) {
            distinctNumbers.add(Integer.parseInt(input[i]));
        }

        writer.write(String.valueOf(distinctNumbers.size()));
        writer.newLine();
        writer.flush();
    }
}