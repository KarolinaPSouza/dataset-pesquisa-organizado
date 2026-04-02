//package DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class entry_10669998 {
  public static final int infinity = (int) 1e7;

  public static void main(String[] args) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

    String dimesion[] = bufferedReader.readLine().split(" ");
    int totalCoins = Integer.parseInt(dimesion[0]);
    int target = Integer.parseInt(dimesion[1]);

    List<Integer> coins =
        Arrays.stream(bufferedReader.readLine().split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    int table[][] = new int[totalCoins][target + 1];
    Arrays.stream(table)
        .forEach(
            row -> {
              Arrays.fill(row, infinity);
              row[0] = 0;
            });

    for (int firstCoin = coins.get(0); firstCoin <= target; firstCoin += coins.get(0)) {
      table[0][firstCoin] = table[0][firstCoin - coins.get(0)] + 1;
    }

    for (int index = 1; index < totalCoins; index++) {
      int coin = coins.get(index);
      for (int sum = 1; sum <= target; sum++) {
        int answer = table[index - 1][sum];
        if (sum >= coin) answer = Math.min(answer, table[index][sum - coin] + 1);

        table[index][sum] = answer;
      }
    }

    int answer = table[totalCoins - 1][target];
    if (answer >= infinity) bufferedWriter.write("-1\n");
    else bufferedWriter.write(Integer.toString(answer));

    bufferedWriter.flush();
  }
}