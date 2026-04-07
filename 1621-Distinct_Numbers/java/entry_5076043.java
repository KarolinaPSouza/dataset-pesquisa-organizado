import java.util.*;
public class entry_5076043 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++){
            set.add(scan.nextInt());
        }
        System.out.println(set.size());
    }
}