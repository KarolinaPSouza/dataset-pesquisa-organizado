//package cses.intro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class entry_3373807 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());

        while (testCount-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            numCalc(row, col);
        }
    }

    private static void numCalc(int row, int col) {
        int sq = Math.max(row, col);
        long sqStart = (long) (sq-1) * (sq-1);
        sqStart++;
        long sqEnd = (long) (sq) * (sq);
        if (sq % 2 != 0) {
            if (col > row) {
                System.out.println(sqEnd - row + 1);
            } else {
                System.out.println(sqStart + col - 1);
            }
        } else {
            if (col > row) {
                System.out.println(sqStart + row - 1);
            } else {
                System.out.println(sqEnd - col + 1);
            }
        }
    }
}