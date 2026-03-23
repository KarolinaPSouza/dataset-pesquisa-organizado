import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class entry_2270895 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line1 = br.readLine();
        String[] numbers = line1.split(" ");
        int n = Integer.parseInt(numbers[0]);
        int m = Integer.parseInt(numbers[1]);
        int k = Integer.parseInt(numbers[2]);
        String line2 = br.readLine();
        String[] desired = line2.split(" ");
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < desired.length; i++)
        {
            a.add(Integer.parseInt(desired[i]));
        }
        String line3 = br.readLine();
        String[] size = line3.split(" ");
        ArrayList<Integer> b = new ArrayList<>();
        for (int i = 0; i < size.length; i++)
        {
            b.add(Integer.parseInt(size[i]));
        }
        int count = process(n, m, k, a, b);
        System.out.println(count);
    }

    public static int process(int n, int m, int k, ArrayList<Integer> a, ArrayList<Integer> b)
    {
        Collections.sort(a);
        Collections.sort(b);
        int count = 0;
        for (int i = 0, j = 0; i < a.size() && j < b.size();)
        {
            if (a.get(i) - b.get(j) > k)
            {
                j++;
            }
            else if (a.get(i) - b.get(j) < -1 * k)
            {
                i++;
            }
            else {
                i++;
                j++;
                count++;
            }
        }
        return count;
    }
}