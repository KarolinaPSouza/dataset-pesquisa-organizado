import java.util.Scanner;

public class entry_4639800 {
    public static void entry_4639800(String[] args) {
        run();
    }

    public static void run() {

        int[] C;
        int[] X;

        Scanner scanner = new Scanner(System.in);
        String[] in1 = scanner.nextLine().split(" ");
        int n = Integer.parseInt(in1[0]);
        int x = Integer.parseInt(in1[1]);

        C = new int[n];
        X = new int[x+1];

        String[] coinList = scanner.nextLine().split(" ");
        for (int i = 0; i < coinList.length; i++) {
            C[i] = Integer.parseInt(coinList[i]);
        }

        for (int i = 1; i < x+1; i++) {
            X[i] = 0;
        }
        X[0] = 1;

        loadX(X, C);

        System.out.println(X[x]);
    }

    private static void loadX(int[] X, int[]C) {
        int pow = ((int)Math.pow(10, 9) + 7);
        for(int c: C) {
            int index = 0;
            while (index < X.length) {
                if (index + c < X.length) {
                    X[index + c] = (X[index + c] + X[index]) % pow;
                }


                do {
                    index++;
                } while (index < X.length && X[index] == 0);
            }
        }
    }
}