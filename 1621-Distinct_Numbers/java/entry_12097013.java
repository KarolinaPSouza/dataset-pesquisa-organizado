import java.io.*;
import java.util.HashMap;

public class entry_12097013 {

    private static void distinctNumbers() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Boolean> map = new HashMap<>();
        String [] keys = br.readLine().split(" ");
        for (String key : keys) {
            map.put(Integer.parseInt(key), true);
        }
        System.out.println(map.size());
    }

    public static void main(String[] args) throws IOException {
        distinctNumbers();
    }
}