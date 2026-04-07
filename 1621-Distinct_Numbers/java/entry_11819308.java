import java.io.*;
import java.util.*;

class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        Set<Integer> hs = new HashSet<>(n);
        for (String num : input) {
            hs.add(Integer.parseInt(num));
        }
        System.out.println(hs.size());
    }
}