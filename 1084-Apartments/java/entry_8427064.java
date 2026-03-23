import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Math.abs;

public class entry_8427064 {
    public static void main(String[] args) {

        FastReader fs = new FastReader();
        int n = fs.nextInt();
        int m = fs.nextInt();
        int k = fs.nextInt();

        List<Integer> desiredApartments = new ArrayList<>();
        for (int i = 0; i < n; i++){
            desiredApartments.add(fs.nextInt());
        }

        List<Integer> availableApartments = new ArrayList<>();
        for (int i = 0; i < m; i++){
            availableApartments.add(fs.nextInt());
        }

        Collections.sort(desiredApartments);
        Collections.sort(availableApartments);

        int numOfApartments = getNumOfApartments(desiredApartments, availableApartments, k);

        System.out.println(numOfApartments);
    }

    private static int getNumOfApartments(List<Integer> desiredApartments, List<Integer> availableApartments, int k) {
        int numOfApartments = 0;
        int i = 0;
        int j = 0;

        while (i < desiredApartments.size() && j < availableApartments.size()) {
            int diff = abs(desiredApartments.get(i) - availableApartments.get(j));

            if (diff <= k) {
                numOfApartments++;
                availableApartments.set(j, Integer.MAX_VALUE);
                i++;
                j++;
            } else if (desiredApartments.get(i) < availableApartments.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return numOfApartments;
    }


    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

    }
}