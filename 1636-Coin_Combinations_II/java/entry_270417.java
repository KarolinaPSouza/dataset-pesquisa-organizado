import java.io.*;
import java.util.*;

public class entry_270417 {

 public static void main(String[] args) {
  // TODO Auto-generated method stub
  Scanner inputs = new Scanner(System.in);

  int num = inputs.nextInt();
  int sum = inputs.nextInt();
  int[] coins = new int[num];
  long[] table = new long[sum+1];

  for(int x=0; x<num; x++)
   coins[x] = inputs.nextInt();
  table[0]=1;
  for(int j=0; j<num; j++) {
   for(int i=coins[j]; i<=sum; i++) {
     table[i] = (table[i]+  table[i-coins[j]])%(1000000000+7);
   }
  }

  System.out.println(table[sum]);
  inputs.close();

 }

}