import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * There are n applicants and m free apartments. Your task is to distribute the apartments so that as many applicants as 
 * possible will get an apartment. Each applicant has a desired apartment size, and they will accept any apartment 
 * whose size is close enough to the desired size.
 * 
 * Input
 *  The first input line has three integers 
 *      n: the number of applicants 
 *      m: the number of apartments 
 *      k: and the maximum allowed difference.
 *  The next line contains n: 
 *      integers a_1, a_2, ..., a_n: the desired apartment size of each applicant. If the desired size of an applicant is x, 
 *      he or she will accept any apartment whose size is between x-k and x+k.
 *  The last line contains m: 
 *      integers b_1, b_2, ..., b_m: the size of each apartment.
 * 
 *  Output
 *      Print one integer: the number of applicants who will get an apartment.
 * 
 * Constraints
 * 1 <= n, m <= 2.10^5
 * 0 <= k <= 10^9
 * 1 <= a_i, b_i <= 10^9
 * Example
 *  Input:
 *      4 3 5
 *      60 45 80 60
 *      30 60 75
 *  Output:
 *      2
 */

public class entry_9584743 {

    public static void printArray(List<Integer> list, String name) {
        System.out.printf("%s: ", name);
        for (Integer integer : list) {
            System.out.printf("%d, ", integer);
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = br.readLine().split(" ");
        String[] secondLine = br.readLine().split(" ");
        String[] thirdLine = br.readLine().split(" ");
        // Number of applicants
        int n = Integer.valueOf(firstLine[0]);
        // Number of appartments
        int m = Integer.valueOf(firstLine[1]);
        // Maximum allowed diference
        int k = Integer.valueOf(firstLine[2]);

        // Desired size apartment for each applicant
        List<Integer> desiredSizeApt = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            desiredSizeApt.add(Integer.valueOf(secondLine[i]));
        }

        // Size of each apt
        List<Integer> aptSizeList = new ArrayList<>();
        for(int i = 0; i<m; i++) {
            aptSizeList.add(Integer.valueOf(thirdLine[i]));
        }

        Collections.sort(aptSizeList);
        Collections.sort(desiredSizeApt);

        // printArray(aptSizeList, "aptSizeList");
        // printArray(desiredSizeApt, "desiredSizeApt");

        // System.out.println("k: "+k);

        int counter = 0;
        int i = 0; 
        int j = 0;

        while (i < n && j < m) {
            if(Math.abs(desiredSizeApt.get(i) - aptSizeList.get(j)) <= k) {
                counter++;
                i++;
                j++;
            } else if (desiredSizeApt.get(i) < aptSizeList.get(j)) {
                i++;
            } else {
                j++;
            }
        }
        System.out.println(counter);
    }
}