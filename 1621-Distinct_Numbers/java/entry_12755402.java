import java.io.*;
import java.util.*;

public class entry_12755402 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(reader.readLine());

        HashSet<Long> hashSet = new HashSet<>();
        StringTokenizer st = new StringTokenizer(reader.readLine());

        while (st.hasMoreTokens()) {
            hashSet.add(Long.parseLong(st.nextToken()));
        }

        System.out.println(hashSet.size());
}}