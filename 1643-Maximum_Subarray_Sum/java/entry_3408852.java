import java.io.*;

public class entry_3408852 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        long[] num = new long[n];
        String[] numbers = bf.readLine().split(" ");
        for(int i = 0;i<n;i++){
            num[i] = Long.parseLong(numbers[i]);
        }
        long sum = 0;
        long maximum = Long.MIN_VALUE;
        for(int i = 0;i<n;i++){
            sum = Math.max(num[i],sum+num[i]);
            maximum = Math.max(maximum,sum);
        }
        System.out.println(maximum);
    }
}