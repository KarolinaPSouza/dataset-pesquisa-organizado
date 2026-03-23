//import java.util.Scanner;
//public class entry_11845908 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        while(t>0){
//            long r = sc.nextLong();
//            long c = sc.nextLong();
//            long soln = 0;
//            if(r>=c){
//                if(r%2!=0){
//                    soln=(r-1)*(r-1)+c;
//                }else{
//                    soln=r*r - (c-1);
//                }
//            }
//            else {
//                if(c%2!=0){
//                    soln=c*c - (r-1);
//                }else{
//                    soln=(c-1)*(c-1)+r;
//                }
//            }
//            System.out.print(soln);
//            t--;
//        }
//    }
//}

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class entry_11845908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            long y = Long.parseLong(input[0]);
            long x = Long.parseLong(input[1]);
            long result;

            if (y >= x) {
                if (y % 2 != 0) {
                    result = (y - 1) * (y - 1) + x;
                } else {
                    result = y * y - (x - 1);
                }
            } else {
                if (x % 2 != 0) {
                    result = x * x - (y - 1);
                } else {
                    result = (x - 1) * (x - 1) + y;
                }
            }
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }
}