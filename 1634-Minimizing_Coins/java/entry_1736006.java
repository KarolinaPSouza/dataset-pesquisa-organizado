import java.util.Scanner;

import static java.lang.Math.min;

public class entry_1736006 {

    static int[] weights;
    static boolean[] ready;
    static double[] value;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();

        weights = new int[n];
        ready = new boolean[x + 1];
        value = new double[x + 1];

        for (int i = 0; i < n; i++)
            weights[i] = scanner.nextInt();

        solvei(x);
        double a = value[value.length - 1];
        System.out.printf("%.0f", a == Double.POSITIVE_INFINITY || a == Double.MAX_VALUE ? -1 : a);
    }


    static void solvei(int x) {
        for (int i = 1; i <= x; i++) {
            value[i] = Double.POSITIVE_INFINITY;
            for (int w : weights) {
                if (i - w >= 0)
                    value[i] = min(value[i], value[i - w] + 1);
            }
        }
    }


    static double solver(int x) {

        if (x == 0) return 0;
        if (x < 0) return Double.POSITIVE_INFINITY;

        if (ready[x]) return value[x];
        double best = Double.MAX_VALUE;
        for (int w : weights) {
            if (x - w >= 0)
                best = min(best, solver(x - w) + 1);
        }
        ready[x] = true;
        value[x] = best;

        return best;
    }


}