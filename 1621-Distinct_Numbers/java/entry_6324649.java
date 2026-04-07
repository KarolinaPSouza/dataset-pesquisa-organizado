import java.util.*;
import java.io.*;

public class entry_6324649 {
    public static void main(String[] args)throws IOException{
       // BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out,1 << 16),false);

        Scanner in = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int n= in.nextInt();
        //int n = Integer.parseInt(in.readLine());
        int a[]=new int[n];
        for (int i = 0; i <n; i++) {
             a[i] =in.nextInt();
                set.add(a[i]);
        }
        out.println(set.size());
        out.flush();//
    }
}