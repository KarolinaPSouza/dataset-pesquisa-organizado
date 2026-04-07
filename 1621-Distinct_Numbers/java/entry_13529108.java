import java.io.*;
import java.util.*;

public class entry_13529108 {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] parts = br.readLine().split(" ");
        HashSet<Long> hs = new HashSet<>();
        for(String num : parts){
            hs.add(Long.parseLong(num));
        }
        System.out.println(hs.size());

    }
}