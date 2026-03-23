import java.util.Scanner;


public class entry_1101322 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        long t = in.nextInt();
        StringBuilder str = new StringBuilder();


        for (int i = 0; i < t; i++) {
            long y = in.nextInt();
            long x = in.nextInt();
            if (x > y) {
                if (x % 2 == 1)  str.append(x*x - y +1).append(" ");

                else {
                    x--;
                    str.append(x*x + y).append(" ");
                }

            }

            else {

                if (y % 2 == 0) str.append(y*y - x +1).append(" ");

                else {
                    y--;
                    str.append(y*y + x).append(" ");
                }

            }

        }

         System.out.println(str);       


    }

}