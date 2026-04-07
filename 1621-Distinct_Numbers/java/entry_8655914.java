import java.util.*;

public class entry_8655914 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
         int n=sc.nextInt();
         ArrayList<Integer>arr=new ArrayList<>();
         for(int i=0;i<n;i++)
         {
            arr.add(sc.nextInt());
         }
         Set<Integer>sett=new HashSet(arr);
         System.out.println(sett.size());




        sc.close();
    }
}