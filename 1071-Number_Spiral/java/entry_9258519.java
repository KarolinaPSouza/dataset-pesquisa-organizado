import java.util.Scanner;

public class entry_9258519 {


    public static long pow(long z, long c) {

        long factor = z;

        for (int i = 1; i < c; i++) {
            z *= factor;
        }

        return z;
    }
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        long t = in.nextLong();

        StringBuilder stringBuilder = new StringBuilder();

        for (long i = 0; i < t; i++) {

            long y = in.nextLong();
            long x = in.nextLong();

            if(x > y) {
                if(x % 2 == 0){stringBuilder.append(pow(x-1, 2) + 1 + (y - 1));}
                else {stringBuilder.append(pow(x, 2) - (y - 1));}
            }
            else {
                if(y % 2 == 0) {stringBuilder.append(pow(y, 2) - (x - 1));}
                else {stringBuilder.append(pow(y-1, 2) + 1 + (x - 1));}
            }

            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder);
    }
}