import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class NumberSpiral {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(in.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < test; i++) {
            String[] parts = in.readLine().split(" ");
            long r = Long.parseLong(parts[0]);
            long c = Long.parseLong(parts[1]);
            sb.append(getNumber(r, c)).append('\n');
        }
        System.out.print(sb);
    }

    private static long getNumber(long r, long c) {
       long max = Math.max(r, c);
       if(max % 2 == 0){
        if(max == r){
            return max * max - (c - 1);
        }else{
            return (max - 1) * (max - 1) + r;
        }
       }else{
        if(max == r){
            return (max - 1) * (max - 1) + c;
        }else{
            return max * max - (r - 1);
       }

    }
}
}