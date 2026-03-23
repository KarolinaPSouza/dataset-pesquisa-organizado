import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class entry_12602901 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        //numeros inicials
        String[] nums = in.readLine().split(" ");
        int n = Integer.parseInt(nums[0]);
        int m = Integer.parseInt(nums[1]);
        int k = Integer.parseInt(nums[2]);

        //valors en String
        String[] desiredString = in.readLine().split(" ");
        String[] sizesString = in.readLine().split(" ");
        //crear llistes i afegir valors com a int
        List<Integer> desired = new ArrayList<>();
        List<Integer> sizes = new ArrayList<>();
        for (String str: desiredString) {desired.add(Integer.valueOf(str));}
        for (String str: sizesString) {sizes.add(Integer.valueOf(str));}
        //ordenar
        Collections.sort(desired);
        Collections.sort(sizes);

        //doble for per recorre les llistes
        int i = 0;
        int j = 0;
        int count = 0;
        while (i<n && j<m) {
            if (Math.abs(desired.get(i)-sizes.get(j)) <= k) {
                count++;
                j++;
                i++;
            }
            else {
                if (desired.get(i)<sizes.get(j)) i++;
                else j++;
            }
        }
        System.out.println(count);
    }
}