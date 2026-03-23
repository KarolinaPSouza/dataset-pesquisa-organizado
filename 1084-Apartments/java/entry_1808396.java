import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class entry_1808396 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] inVar = bufferedReader.readLine().split(" ");
        String[] inReqSizes = bufferedReader.readLine().split(" ");
        String[] inAptSizes = bufferedReader.readLine().split(" ");

        int applicants = Integer.parseInt(inVar[0]);
        int apartments = Integer.parseInt(inVar[1]);
        int difference = Integer.parseInt(inVar[2]);

        PriorityQueue<Integer> applicantsDesiredSizes = new PriorityQueue<>();
        PriorityQueue<Integer> apartmentsSizes = new PriorityQueue<>();

        for (int i=0; i < applicants; i++) {
            applicantsDesiredSizes.add(Integer.parseInt(inReqSizes[i]));
        }

        for (int j=0; j < apartments; j++) {
            apartmentsSizes.add(Integer.parseInt(inAptSizes[j]));
        }

        int result = 0;
        while (!apartmentsSizes.isEmpty() && !applicantsDesiredSizes.isEmpty()) {
            long nextApplicant = applicantsDesiredSizes.peek();
            long nextApartment = apartmentsSizes.peek();
            if (Math.abs(nextApartment - nextApplicant) <= difference) {
                result++;
                apartmentsSizes.poll();
                applicantsDesiredSizes.poll();
            } else if (nextApartment < nextApplicant)
                apartmentsSizes.poll();
            else
                applicantsDesiredSizes.poll();
        }
        System.out.println(result);
    }
}