import java.util.*;
import java.lang.*;
import java.io.*;
public class entry_4198683 {

  public static void main(String[] args) throws IOException{
    Scanner sc = new Scanner(System.in);

    int n =sc.nextInt();
    long total = 0;
    long max =Integer.MIN_VALUE;
    long min = 0;
    for(int i =0;i<n;i++) {
     total+=sc.nextInt();
     max = Math.max(max, total-min);
     min = Math.min(total, min);


    }

System.out.println(max);
  }


}


