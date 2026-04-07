import java.util.*;

public class entry_11689563 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        String nums = sc.nextLine();

        HashSet<Long> map = new HashSet<>();
        int idxx = 0;
        for(String num : nums.split(" ")) {
            if(num.isBlank()) {
                continue;
            }
            map.add(Long.parseLong(num));
        }

        System.out.println(map.size());

    }
}