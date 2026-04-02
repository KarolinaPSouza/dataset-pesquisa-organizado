/*This is the modified version Of Kadanes Code from the text book
*Filename: entry_7604554.java
 * @authors Baone Simanyana: 201901584 Tamia Masenya: 201904495
 Kelekantse Moruakgomo: 201904767
 The code's  task is to  find two values (at distinct positions) whose sum is x.
   Compile: javac entry_7604554.java
   Run: java entry_7604554
The first input line has an integer n: the size of the array.
The second line has n integers x_1,x_2,\dots,x_n: the array values.
*/
import java.util.Scanner;

public class entry_7604554 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] x = new int[n];

        for (int i = 0; i < n; i++) {
            x[i] = scanner.nextInt();
        }

        long maxSum = Integer.MIN_VALUE;
        long currentSum = 0;

        for (int i = 0; i < n; i++) {
            currentSum = Math.max(x[i], currentSum + x[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println(maxSum);
    }
}