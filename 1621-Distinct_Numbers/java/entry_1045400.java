import java.util.HashSet;
import java.util.Scanner;

public class entry_1045400 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int t=scanner.nextInt();
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i=0;i<t;i++)hashSet.add(scanner.nextInt());
        System.out.println(hashSet.size());
    }
}