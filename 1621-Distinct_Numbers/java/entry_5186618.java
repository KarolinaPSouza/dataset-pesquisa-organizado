// Online IDE - Code Editor, Compiler, Interpreter
import java.util.*;
public class entry_5186618 {
    public static void main(String[] args) {
    Scanner in=new Scanner(System.in);
    int n=in.nextInt();
    int[]arr=new int[n];
    Set<Integer>set=new HashSet<>();
    for(int i=0;i<n;i++){   arr[i]=in.nextInt();
                            set.add(arr[i]);
    }
    System.out.println(set.size());
}
}