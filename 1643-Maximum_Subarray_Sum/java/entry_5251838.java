import java.util.Scanner;

public class entry_5251838 {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner (System.in);

        int length = scanner.nextInt ();
        int [] a = new int [length];

        for (int i = 0; i < length; i ++)
        {
            a [i] = scanner.nextInt ();
        }

        long [] b = new long [length];

        b [0] = a [0];

        for (int i = 1; i < length; i ++)
        {
            b [i] = b [i - 1] + a [i];
        }

        long [] c = new long [length];

        for (int i = 1; i < length; i ++)
        {
            c [i] = Math.min (b [i - 1], c [i - 1]);
        }

        long output = b [0] - c [0];

        for (int i = 1; i < length; i ++)
        {
            output = Math.max (output, b [i] - c [i]);
        }

        System.out.println (output);
    }
}