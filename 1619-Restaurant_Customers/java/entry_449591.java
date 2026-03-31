import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.StringTokenizer;

public class entry_449591 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static Random rand = new Random();

    public static void main(String[] args) {
        try {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int[] times = new int[n * 2];

            for (int i = 0; i < n; i++) {

                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                times[i * 2] = a * 2;
                times[i * 2 + 1] = b * 2 + 1;

            }
            int count = 0;
            int answer = 0;
            sortShuffle(times);

            for (int i = 0; i < 2 * n; i++) {
                if (times[i] % 2 == 0) {
                    count++;
                } else {
                    count--;
                }

                if (count > answer) {
                    answer = count;
                }
            }
            System.out.println(answer);
        }
        catch(Exception ex){
            System.out.println(ex);
        }
    }

    public static void sortShuffle(int[] a){
        int size = a.length;
        for(int i =0; i < size; i++){
            int j = rand.nextInt(i+1);
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        Arrays.sort(a);
    }
}