import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class entry_4653882 {
    public static void entry_4653882(String[] args) {
        run();
    }

    private static void run() {

        Scanner scanner = new Scanner(System.in);
        char[] in1 = scanner.nextLine().toCharArray();
        char[] in2 = scanner.nextLine().toCharArray();
        int n = in1.length;
        int m = in2.length;

        int[][] arr = new int[n+1][m+1];
        for (int i = 0; i < n+1; i++) {
            arr[i][0] = i;
        }
        for (int i = 0; i < m+1; i++) {
            arr[0][i] = i;
        }

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                int exchangeCost = in1[i-1] == in2[j-1] ? 0 : 1;
                arr[i][j] = Math.min(Math.min(arr[i-1][j] + 1, arr[i][j-1] + 1), arr[i-1][j-1] + exchangeCost);
            }
        }

        System.out.println(arr[n][m]);



    }

}